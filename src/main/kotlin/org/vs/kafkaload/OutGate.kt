package org.vs.kafkaload

import mu.KotlinLogging
import org.apache.avro.generic.GenericRecord
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import kotlin.concurrent.thread

@Component
class OutGate<K,V>(
    val topic: String,
    val threadCount : Int,
    val messageCount : Long,
    val generator : Generator<K,V>,
    val coordinator: Coordinator,
    @Autowired val telemetry: Telemetry,
    @Autowired val template: KafkaTemplate<K, V>,
) {
    val log = KotlinLogging.logger {}

    val threads : Array<Thread> = Array<Thread>(threadCount){
        thread(start = false, name = "Publish $it"){
            while (coordinator.started) {
                val key = generator.createKey()
                val value = generator.createValue()
                val id = generator.extractId(key, value)
                telemetry
                template.send(topic, key, value)
            }
        }
    }

    fun start(){
        log.info { "****** START SENDING ******" }
        threads.forEach { it.start() }
    }

    fun stop(){
        log.info { "****** STOP SENDING ******" }
    }
}
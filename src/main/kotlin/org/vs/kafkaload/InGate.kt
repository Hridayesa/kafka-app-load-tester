package org.vs.kafkaload

import mu.KotlinLogging
import org.apache.avro.generic.GenericRecord
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import reactor.kafka.sender.KafkaSender
import reactor.kafka.sender.internals.DefaultKafkaSender

@Component
class InGate
//    (
//    @Autowired val telemetry: Telemetry,
//    //generator : RecordGenerator,
//    @Autowired val kafkaSender: KafkaSender<String, GenericRecord>,
//)
{
    val log = KotlinLogging.logger {}

    fun start() {
        log.info { "****** START RECEIVING ******" }

//        kafkaSender.send<> {  }
    }

    fun stop() {
        log.info { "****** STOP RECEIVING ******" }
    }
}
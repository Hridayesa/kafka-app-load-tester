package org.vs.kafkaload.kafka

import mu.KotlinLogging
import org.apache.kafka.clients.consumer.Consumer
import org.apache.kafka.clients.producer.Producer
import org.apache.kafka.clients.producer.ProducerRecord
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.test.EmbeddedKafkaBroker
import org.springframework.kafka.test.context.EmbeddedKafka
import org.springframework.kafka.test.utils.KafkaTestUtils

@EmbeddedKafka(topics = ["qqq"])
@SpringBootTest
class Simple {
    val log = KotlinLogging.logger {}

    @Autowired
    lateinit var broker: EmbeddedKafkaBroker

    @Test
    internal fun sendReceiveTest() {
        Assertions.assertNotNull(broker)
        log.info { broker.brokersAsString }
        val producer = getProducer<Int,String>()
        val consumer = getConsumer<Int,String>()

        consumer.subscribe(listOf("qqq"))
        producer.send(ProducerRecord("qqq",1, "Value1"))
        val singleRecord = KafkaTestUtils.getSingleRecord(consumer, "qqq")
        Assertions.assertEquals(1, singleRecord.key())
        Assertions.assertEquals("Value1", singleRecord.value())
    }

    fun <K,V> getProducer(): Producer<K,V> {
        val producerProps = KafkaTestUtils.producerProps(broker)
        val producerFactory = DefaultKafkaProducerFactory<K,V>(producerProps)
        return producerFactory.createProducer();
    }

    fun <K,V> getConsumer(): Consumer<K,V> {
        val consumerProps = KafkaTestUtils.consumerProps("G1", "true", broker)
        val consumerFactory = DefaultKafkaConsumerFactory<K,V>(consumerProps)
        return consumerFactory.createConsumer()
    }
}
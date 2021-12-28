package org.vs.kafkaload

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkaAppLoadTesterApplication

fun main(args: Array<String>) {
    runApplication<KafkaAppLoadTesterApplication>(*args)
}

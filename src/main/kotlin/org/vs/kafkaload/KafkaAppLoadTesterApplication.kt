package org.vs.kafkaload

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ConfigurableApplicationContext

@SpringBootApplication
class KafkaAppLoadTesterApplication

fun main(args: Array<String>) {
    val ctx : ConfigurableApplicationContext = runApplication<KafkaAppLoadTesterApplication>(*args)
    val runner = ctx.getBean(AppRunner::class.java)
    runner.run(null)
}

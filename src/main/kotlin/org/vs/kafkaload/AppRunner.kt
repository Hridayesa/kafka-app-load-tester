package org.vs.kafkaload

import mu.KotlinLogging
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.stereotype.Component

@Component
class AppRunner : ApplicationContextAware {
    val log = KotlinLogging.logger {}

    lateinit var ctx: ApplicationContext

    fun run(args: ApplicationArguments?) {
        log.info { "QQQQ" }
//        receiver.

        (ctx as ConfigurableApplicationContext).close()
    }

    override fun setApplicationContext(applicationContext: ApplicationContext) {
        ctx = applicationContext
    }
}
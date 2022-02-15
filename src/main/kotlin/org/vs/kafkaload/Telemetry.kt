package org.vs.kafkaload

import mu.KotlinLogging
import org.springframework.stereotype.Component

@Component
class Telemetry() {
    val log = KotlinLogging.logger {}

    fun send(id: String){
    }

    fun receive(id: String){
    }

    fun finalPrint(){
        log.info { "****** RESULT *******" }
    }
}
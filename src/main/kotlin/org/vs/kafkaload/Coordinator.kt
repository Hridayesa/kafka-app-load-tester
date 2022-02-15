package org.vs.kafkaload

import mu.KotlinLogging
import org.springframework.stereotype.Component
import java.util.concurrent.atomic.AtomicBoolean

@Component
class Coordinator {
    private val log = KotlinLogging.logger {}
    @Volatile
    private var isStarted: Boolean = false

    val started: Boolean
        get() = isStarted

    fun start(){
        isStarted = true
    }

    fun stop(){
        isStarted = false
    }
}
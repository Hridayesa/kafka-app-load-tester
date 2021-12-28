package org.vs.kafkaload

import mu.KotlinLogging
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class KafkaAppLoadTesterApplicationTests {
    val log = KotlinLogging.logger {}

    @Test
    fun contextLoads() {
        log.info { "QQQQQQQQQQQQ" }
    }

}

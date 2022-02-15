package org.vs.kafkaload

interface Generator<K,V> {
    fun createKey(): K
    fun createValue(): V
    fun extractId(key: K, value: V): String
}
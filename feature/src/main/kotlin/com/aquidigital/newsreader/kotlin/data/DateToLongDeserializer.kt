package com.aquidigital.newsreader.kotlin.data

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import java.text.SimpleDateFormat
import java.util.*

/**
 * by default - Realm does not support persistance of Date value type
 * - persist to millisecs and construct data object from that
 */
class DateToLongDeserializer : JsonDeserializer<Long>(){

    override fun deserialize(jsonParser: JsonParser, context: DeserializationContext): Long {
        val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        val date = jsonParser.text ?: return  Date().time
        return  format.parse(date).time
    }

}
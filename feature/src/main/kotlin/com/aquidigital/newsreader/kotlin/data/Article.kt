package com.aquidigital.newsreader.kotlin.data

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * will be saved to local db
 */
open class Article : RealmObject(){

    @PrimaryKey
    lateinit var url: String
    lateinit var title: String
    var description: String? = null
    var author: String? = null
    var urlToImage: String? = null
    lateinit var category: String
    @JsonDeserialize(using = DateToLongDeserializer::class)
    var publishedAt: Long? = null
    @JsonIgnore
    var isUnread = true

}

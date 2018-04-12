package com.aquidigital.newsreader.kotlin.data

/**
 * Object mapping of response from API
 */
class SourceResponse {

    var status = ""
    var sources = listOf<Source>()
}
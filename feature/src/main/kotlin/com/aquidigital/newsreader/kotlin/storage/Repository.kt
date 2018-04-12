package com.aquidigital.newsreader.kotlin.storage

import io.realm.RealmModel
import io.realm.RealmQuery
import io.realm.Sort
import java.io.Closeable

/**
 * - Closeable interface used here to allow Realm to close operations and free up resources
 * - Realm fast -> using methods prefixed with suspend when it's expected that operations will
 *   take longer - so as not to block the main thread
 */
interface Repository<T> : Closeable where T : RealmModel {

    fun getById(id : String): T?

    suspend fun delete(filter: RealmQuery<T>.() -> Unit)

    fun update(id: String, modifier: T.() -> Unit)

    fun add(item: T)

    suspend  fun addAll(items: List<T>)

    fun count(filter: RealmQuery<T>.() -> Unit): Long

    fun count(): Long

    suspend fun query(filter: RealmQuery<T>.() -> Unit, sortFields:Array<String>?, orders: Array<Sort>?): List<T>

    val clazz: Class<T>

}
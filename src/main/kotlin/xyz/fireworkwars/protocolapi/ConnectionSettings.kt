package xyz.fireworkwars.protocolapi

import kotlinx.serialization.Serializable

/** Redis and PostgresSQL settings */
@Serializable
data class ConnectionSettings(
    val redisHost: String,
    val redisPort: Int,

    val databaseHost: String,
    val databasePort: Int,
    val databaseName: String,
    val databaseUser: String,
    val databasePassword: String,
)

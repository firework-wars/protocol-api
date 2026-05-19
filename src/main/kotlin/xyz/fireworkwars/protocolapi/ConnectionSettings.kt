package xyz.fireworkwars.protocolapi

import kotlinx.serialization.Serializable

/**
 * Redis + Postgres connection settings shared by every plugin. The operator declares these
 * exactly once in the network's master `config/network.json`; `start.sh` injects them into
 * each backend's `FWWCommon/common.json` and the proxy reads its own master file directly.
 *
 * No defaults: these are required operational settings, and silent fallbacks would mask a
 * misconfigured deployment.
 */
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

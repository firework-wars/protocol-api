package xyz.fireworkwars.protocolapi.messages

import kotlinx.serialization.Serializable

/** Register request from a backend */
@Serializable
data class ServerRegisterMessage(
    val serverId: String,
    val serverType: String,
    val port: Int,
    val maxPlayers: Int,
    val mapName: String
)

/** Backend state heartbeat */
@Serializable
data class ServerStateMessage(
    val serverId: String,
    val state: String,
    val playerCount: Int
)

/** Send player to server request */
@Serializable
data class PlayerSendMessage(
    val playerUuid: String,
    val targetServerId: String
)

/** Send player to most appropriate server of type [xyz.fireworkwars.protocolapi.ServerType] request */
@Serializable
data class PlayerJoinGameMessage(
    val playerUuid: String,
    val serverTypes: List<String>
)

/** Save disconnection info of a player (for /rejoin) */
@Serializable
data class PlayerDisconnectMessage(
    val playerUuid: String,
    val serverId: String
)

/** Live server info of every backend, sent by the proxy */
@Serializable
data class ServerDirectoryMessage(
    val servers: List<ServerDirectoryEntry>
)

@Serializable
data class ServerDirectoryEntry(
    val id: String,
    val type: String,
    val port: Int,
    val state: String,
    val playerCount: Int,
    val maxPlayers: Int,
    val mapName: String
)

/** Dispatch command in a specific backend server request */
@Serializable
data class ServerCommandMessage(
    val serverId: String,
    val command: String
)

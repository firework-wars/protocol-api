package xyz.fireworkwars.protocolapi.messages

import kotlinx.serialization.Serializable

@Serializable
data class ServerRegisterMessage(
    val serverId: String,
    val serverType: String,
    val port: Int,
    val maxPlayers: Int,
    val mapName: String
)

@Serializable
data class ServerStateMessage(
    val serverId: String,
    val state: String,
    val playerCount: Int
)

@Serializable
data class PlayerSendMessage(
    val playerUuid: String,
    val targetServerId: String
)

@Serializable
data class PlayerJoinGameMessage(
    val playerUuid: String,
    val serverTypes: List<String>
)

@Serializable
data class PlayerDisconnectMessage(
    val playerUuid: String,
    val serverId: String
)

@Serializable
data class ServerListMessage(
    val servers: List<ServerInfo>
)

@Serializable
data class ServerInfo(
    val id: String,
    val type: String,
    val port: Int,
    val state: String,
    val playerCount: Int,
    val maxPlayers: Int,
    val mapName: String
)

@Serializable
data class ServerCommandMessage(
    val serverId: String,
    val command: String
)

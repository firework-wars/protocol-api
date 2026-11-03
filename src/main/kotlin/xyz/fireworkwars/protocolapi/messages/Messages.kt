package xyz.fireworkwars.protocolapi.messages

import kotlinx.serialization.Serializable
import xyz.fireworkwars.protocolapi.ChatChannel
import xyz.fireworkwars.protocolapi.GameState
import xyz.fireworkwars.protocolapi.ServerType

sealed interface NetworkMessage

@Serializable
data class ServerRegisterMessage(
    val serverId: String,
    val serverType: ServerType,
    val port: Int,
    val maxPlayers: Int,
    val mapName: String
) : NetworkMessage

@Serializable
data class ServerStateMessage(
    val serverId: String,
    val state: GameState,
    val playerCount: Int
) : NetworkMessage

@Serializable
data class ServerHeartbeatMessage(
    val serverId: String
) : NetworkMessage

@Serializable
data class PlayerSendMessage(
    val playerUuid: String,
    val targetServerId: String
) : NetworkMessage

@Serializable
data class PlayerJoinGameMessage(
    val playerUuid: String,
    val serverTypes: List<ServerType>
) : NetworkMessage

@Serializable
data class PlayerDisconnectMessage(
    val playerUuid: String,
    val serverId: String
) : NetworkMessage

@Serializable
data class ServerListMessage(
    val servers: List<ServerInfo>
) : NetworkMessage

@Serializable
data class ServerListRequestMessage(
    val serverId: String
) : NetworkMessage

@Serializable
data class ServerInfo(
    val id: String,
    val type: ServerType,
    val port: Int,
    val state: GameState,
    val playerCount: Int,
    val maxPlayers: Int,
    val mapName: String
)

@Serializable
data class ProfileUpdatedMessage(
    val playerUuid: String
) : NetworkMessage

@Serializable
data class ServerCommandMessage(
    val serverId: String,
    val command: String
) : NetworkMessage

@Serializable
data class ChatChannelMessage(
    val playerUuid: String,
    val channel: ChatChannel
) : NetworkMessage

@Serializable
data class PartyChatMessage(
    val playerUuid: String,
    val message: String
) : NetworkMessage

@Serializable
data class ChatAsMessage(
    val playerUuid: String,
    val message: String
) : NetworkMessage

@Serializable
data class PartyJoinMessage(
    val serverId: String,
    val members: List<String>
) : NetworkMessage

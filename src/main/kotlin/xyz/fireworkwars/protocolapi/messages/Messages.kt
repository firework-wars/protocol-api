package xyz.fireworkwars.protocolapi.messages

import kotlinx.serialization.Serializable

/** Published by a backend on enable; the proxy registers the server with Velocity. */
@Serializable
data class ServerRegisterMessage(
    val serverId: String,
    val serverType: String,
    val port: Int,
    val maxPlayers: Int,
    val mapName: String
)

/** Periodic state + player-count update from each backend. State is a GameState enum name. */
@Serializable
data class ServerStateMessage(
    val serverId: String,
    val state: String,
    val playerCount: Int
)

/** A request to move a player to a specific backend. Handled by the proxy's PLAYER_SEND subscriber. */
@Serializable
data class PlayerSendMessage(
    val playerUuid: String,
    val targetServerId: String
)

/**
 * A request to move a player to *any* joinable backend whose type is in the given list. The
 * proxy runs server selection across all candidate types and either routes the player or
 * sends them a "no servers available" message — the publisher (lobby) doesn't need its own
 * view of which servers are joinable. The list lets a single message cover "any FWW map"
 * (FWW_BARRACKS, FWW_TOWN) as well as the specific-map case.
 */
@Serializable
data class PlayerJoinGameMessage(
    val playerUuid: String,
    val serverTypes: List<String>
)

/**
 * A player disconnected mid-game; the proxy remembers this so /rejoin can route them back
 * (until expiresAt or until the source server unregisters).
 */
@Serializable
data class PlayerDisconnectMessage(
    val playerUuid: String,
    val serverId: String,
    val expiresAt: Long
)

/** Proxy-pushed snapshot of every known server. Sent on changes and on directory_request. */
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

/** A console command to dispatch on a specific backend. Subscribed to by FWWCommon. */
@Serializable
data class ServerCommandMessage(
    val serverId: String,
    val command: String
)

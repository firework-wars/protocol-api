package xyz.fireworkwars.protocolapi

/**
 * Every kind of server in the network. Lobbies and game servers share this enum so that
 * scoreboards, directory consumers, and routing all speak the same language.
 */
@Suppress("unused")
enum class ServerType {
    LOBBY_MAIN,
    LOBBY_FWW,
    LOBBY_LR,

    FWW_BARRACKS,
    FWW_TOWN,

    LR;

    val isLobby: Boolean
        get() = this == LOBBY_MAIN || this == LOBBY_FWW || this == LOBBY_LR

    val isGame: Boolean
        get() = !isLobby

    /**
     * Canonical server ID for the lobby of this kind. Only valid for [isLobby] types —
     * game types have many concrete server IDs spawned dynamically and don't fit this
     * mapping. Backed by the convention that lobby server IDs are the lowercased enum
     * name (LOBBY_FWW → "lobby_fww").
     */
    val lobbyId: String
        get() {
            require(isLobby) { "lobbyId is only defined for lobby ServerTypes (got $this)" }
            return name.lowercase()
        }
}

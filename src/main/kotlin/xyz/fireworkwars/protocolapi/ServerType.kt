package xyz.fireworkwars.protocolapi

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

    val templateName: String
        get() = name.lowercase()

    val lobbyId: String
        get() {
            require(isLobby) { "lobbyId is only defined for lobby ServerTypes (got $this)" }
            return name.lowercase()
        }
}

package xyz.fireworkwars.protocolapi

/**
 * The lifecycle states a game (or lobby) server passes through. Published over
 * fww:server_state by every backend; consumed by the proxy and any lobby.
 */
enum class GameState {
    LOADING,
    WAITING,
    STARTING,
    PLAYING,
    ENDING;

    fun isJoinable(): Boolean = this == WAITING || this == STARTING
}

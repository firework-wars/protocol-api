package xyz.fireworkwars.protocolapi

enum class GameState {
    LOADING,
    WAITING,
    STARTING,
    PLAYING,
    ENDING;

    fun isJoinable(): Boolean = this == WAITING || this == STARTING
}

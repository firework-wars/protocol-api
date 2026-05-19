package xyz.fireworkwars.protocolapi

/**
 * Canonical Redis channel names used across the network. Every publisher and subscriber
 * (proxy, lobby, game, lava-rising, common) references these constants — never the raw
 * strings — so a channel rename is a one-line change with a compile error at every site
 * that needs updating.
 */
object RedisChannels {
    const val SERVER_REGISTER = "fww:server_register"
    const val SERVER_STATE = "fww:server_state"
    const val SERVER_HEARTBEAT = "fww:server_heartbeat"
    const val SERVER_DIRECTORY = "fww:server_directory"
    const val DIRECTORY_REQUEST = "fww:directory_request"

    const val PLAYER_SEND = "fww:player_send"
    const val PLAYER_JOIN_GAME = "fww:player_join_game"
    const val PLAYER_DISCONNECT = "fww:player_disconnect"

    const val PROFILE_UPDATED = "fww:profile_updated"

    const val SERVER_COMMAND = "fww:server_command"

    val ALL = listOf(
        SERVER_REGISTER,
        SERVER_STATE,
        SERVER_HEARTBEAT,
        SERVER_DIRECTORY,
        DIRECTORY_REQUEST,
        PLAYER_SEND,
        PLAYER_JOIN_GAME,
        PLAYER_DISCONNECT,
        PROFILE_UPDATED,
        SERVER_COMMAND
    )
}

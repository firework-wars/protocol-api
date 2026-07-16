package xyz.fireworkwars.protocolapi

object RedisChannels {
    const val SERVER_REGISTER = "fww:server_register"
    const val SERVER_STATE = "fww:server_state"
    const val SERVER_HEARTBEAT = "fww:server_heartbeat"
    const val SERVER_LIST = "fww:server_list"
    const val SERVER_LIST_REQUEST = "fww:server_list_request"

    const val PLAYER_SEND = "fww:player_send"
    const val PLAYER_JOIN_GAME = "fww:player_join_game"
    const val PLAYER_DISCONNECT = "fww:player_disconnect"

    const val PROFILE_UPDATED = "fww:profile_updated"

    const val SERVER_COMMAND = "fww:server_command"
}

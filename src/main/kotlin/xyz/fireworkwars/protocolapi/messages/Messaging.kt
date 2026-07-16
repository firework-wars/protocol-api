package xyz.fireworkwars.protocolapi.messages

import kotlinx.serialization.json.Json
import xyz.fireworkwars.data.MessageBus
import xyz.fireworkwars.protocolapi.RedisChannels
import kotlin.reflect.KClass

val networkJson = Json {
    ignoreUnknownKeys = true
    encodeDefaults = true
}

val messageChannels: Map<KClass<out NetworkMessage>, String> = mapOf(
    ServerRegisterMessage::class to RedisChannels.SERVER_REGISTER,
    ServerStateMessage::class to RedisChannels.SERVER_STATE,
    ServerHeartbeatMessage::class to RedisChannels.SERVER_HEARTBEAT,
    ServerListMessage::class to RedisChannels.SERVER_LIST,
    ServerListRequestMessage::class to RedisChannels.SERVER_LIST_REQUEST,
    PlayerSendMessage::class to RedisChannels.PLAYER_SEND,
    PlayerJoinGameMessage::class to RedisChannels.PLAYER_JOIN_GAME,
    PlayerDisconnectMessage::class to RedisChannels.PLAYER_DISCONNECT,
    ProfileUpdatedMessage::class to RedisChannels.PROFILE_UPDATED,
    ServerCommandMessage::class to RedisChannels.SERVER_COMMAND
)

inline fun <reified T : NetworkMessage> MessageBus.publish(message: T) {
    publish(messageChannels.getValue(T::class), networkJson.encodeToString(message))
}

inline fun <reified T : NetworkMessage> MessageBus.subscribe(noinline handler: (T) -> Unit) {
    subscribe(messageChannels.getValue(T::class)) { message ->
        handler(networkJson.decodeFromString<T>(message))
    }
}

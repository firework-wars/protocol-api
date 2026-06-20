package xyz.fireworkwars.protocolapi

import kotlinx.serialization.Serializable

/** Shared default config of the Common plugin on each backend */
@Serializable
data class CommonConfig(
    val serverId: String,
    val connection: ConnectionSettings,

    val serverType: String = "",
    val mapName: String = "",

    val disableVanillaRecipes: Boolean = true,
    val suppressJoinQuitMessages: Boolean = true,
    val applyChatPrefix: Boolean = true,
    val applyNameTags: Boolean = true,
    val applyTablist: Boolean = true,

    val tablistHeader: String = "<bold><color:#ff365e>Firework</color> <color:#00e0e0>Wars</color></bold>",
    val tablistFooter: String = "<newline><gray>play.fireworkwars.net<newline><aqua>discord.fireworkwars.net"
)

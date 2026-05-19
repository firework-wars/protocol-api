package xyz.fireworkwars.protocolapi

import kotlinx.serialization.Serializable

/**
 * Per-backend operational + cosmetic config. Loaded from `plugins/FWWCommon/common.json`
 * on every Paper backend (lobby, game, lava-rising). The single source of truth on a
 * backend — individual game/lobby plugins no longer ship their own `NetworkConfig`.
 *
 * `serverType` and `mapName` are only meaningful for game backends (FWW_BARRACKS, LR, …);
 * lobbies leave them blank and derive their own serverType from `lobby.json`'s lobbyType.
 *
 * Lives in protocol-api (rather than the common plugin) so every backend can deserialize
 * the same file off its own classpath without depending on FWWCommon at compile or load
 * time. The proxy doesn't read this — it has its own NetworkConfig.
 */
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
    val tablistFooter: String = "<newline><gray>play.fireworkwars.xyz<newline><aqua>discord.gg/fireworkwars"
)

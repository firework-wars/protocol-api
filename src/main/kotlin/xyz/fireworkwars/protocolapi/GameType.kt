package xyz.fireworkwars.protocolapi

/**
 * The high-level gameplay mode a player is in. Used for stat partitioning (stat_events.game_type)
 * and for leaderboard filtering. Distinct from ServerType because multiple ServerTypes can
 * map to one GameType (FWW_BARRACKS and FWW_TOWN both produce FWW stats).
 */
enum class GameType {
    FWW,
    LR
}

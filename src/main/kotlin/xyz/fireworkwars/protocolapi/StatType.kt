package xyz.fireworkwars.protocolapi

/**
 * Per-event stat types recorded in the `stat_events` table for time-windowed leaderboards.
 * The enum name is what's persisted, so renames are a schema migration.
 */
enum class StatType {
    WIN,
    LOSS,
    DRAW,
    KILL,
    DEATH
}

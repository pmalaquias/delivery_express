package com.pmalaquias.deliveryexpress.data.models.enums

/**
 * Enum class representing different statuses of a tracker.
 *
 * @property PENDING Represents a tracker status where the delivery is pending.
 * @property IN_PROGRESS Represents a tracker status where the delivery is in progress.
 * @property DELIVERED Represents a tracker status where the delivery has been delivered.
 */
enum class TrackerStatus {
    PENDING,
    IN_PROGRESS,
    DELIVERED
}
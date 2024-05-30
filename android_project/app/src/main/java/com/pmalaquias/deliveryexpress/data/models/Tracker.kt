package com.pmalaquias.deliveryexpress.data.models

import com.pmalaquias.deliveryexpress.data.models.enums.TrackerStatus

/**
 * Data class representing a Tracker entity.
 *
 * @property idTracker Unique identifier for the tracker.
 * @property idOrder Reference to the Order entity associated with this tracker.
 * @property status Current status of the tracker, represented by the TrackerStatus enum.
 * @property date Date when the status was last updated.
 */
data class Tracker(
    val idTracker: Int,
    val idOrder: Order,
    val status: TrackerStatus,
    val date: String
)
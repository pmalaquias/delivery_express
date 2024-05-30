package com.pmalaquias.deliveryexpress.data.models

import com.pmalaquias.deliveryexpress.data.models.enums.TrackerStatus

data class Tracker(
    val idTracker: Int,
    val idOrder: Order,
    val status: TrackerStatus,
    val date: String
)
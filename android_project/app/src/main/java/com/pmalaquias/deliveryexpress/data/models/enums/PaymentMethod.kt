package com.pmalaquias.deliveryexpress.data.models.enums

/**
 * Enum class representing different methods of payment.
 *
 * @property CREDIT_CARD Represents payment made with a credit card.
 * @property DEBIT_CARD Represents payment made with a debit card.
 * @property CASH Represents payment made with cash.
 * @property PIX Represents payment made with PIX (a Brazilian instant payment method).
 */
enum class PaymentMethod {
    CREDIT_CARD,
    DEBIT_CARD,
    CASH,
    PIX
}
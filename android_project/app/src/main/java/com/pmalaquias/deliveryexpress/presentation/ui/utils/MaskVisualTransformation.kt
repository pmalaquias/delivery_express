package com.pmalaquias.deliveryexpress.presentation.ui.utils

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import kotlin.math.absoluteValue


/**
 * A class that applies a visual transformation to text based on a mask.
 *
 * @property mask The mask to apply. Any character in the mask that is not a '#' is considered a special symbol.
 */
class MaskVisualTransformation(private val mask: String) : VisualTransformation {

    // Indices in the mask that correspond to special symbols.
    private val specialSymbolsIndices = mask.indices.filter { mask[it] != '#' }

    /**
     * Applies the mask to the input text.
     *
     * @param text The text to transform.
     * @return The transformed text.
     */
    override fun filter(text: AnnotatedString): TransformedText {
        var out = ""
        var maskIndex = 0
        text.forEach { char ->
            // Add special symbols from the mask to the output.
            while (specialSymbolsIndices.contains(maskIndex)) {
                out += mask[maskIndex]
                maskIndex++
            }
            // Add the current character from the input text to the output.
            out += char
            maskIndex++
        }
        // Return the transformed text with an offset translator.
        return TransformedText(AnnotatedString(out), offsetTranslator())
    }

    /**
     * Creates an offset translator.
     *
     * The offset translator is used to map positions in the original text to positions in the transformed text and vice versa.
     *
     * @return The offset translator.
     */
    private fun offsetTranslator() = object : OffsetMapping {
        /**
         * Maps a position in the original text to a position in the transformed text.
         *
         * @param offset The position in the original text.
         * @return The corresponding position in the transformed text.
         */
        override fun originalToTransformed(offset: Int): Int {
            val offsetValue = offset.absoluteValue
            if (offsetValue == 0) return 0
            var numberOfHashtags = 0
            val masked = mask.takeWhile {
                if (it == '#') numberOfHashtags++
                numberOfHashtags < offsetValue
            }
            return masked.length + 1
        }

        /**
         * Maps a position in the transformed text to a position in the original text.
         *
         * @param offset The position in the transformed text.
         * @return The corresponding position in the original text.
         */
        override fun transformedToOriginal(offset: Int): Int {
            return mask.take(offset.absoluteValue).count { it == '#' }
        }
    }
}
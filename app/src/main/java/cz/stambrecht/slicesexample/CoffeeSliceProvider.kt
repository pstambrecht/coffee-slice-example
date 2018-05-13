/*
 *  Copyright (C) 2018 Bc. Pavel Stambrecht - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Pavel Stambrecht
 * /
 */

package cz.stambrecht.slicesexample

import android.net.Uri
import androidx.core.graphics.drawable.IconCompat
import androidx.slice.Slice
import androidx.slice.SliceProvider
import androidx.slice.builders.ListBuilder
import androidx.slice.builders.ListBuilder.LARGE_IMAGE


/**
 * [CoffeeSliceProvider] is an example of Android Slices. It extends [SliceProvider]
 * to handle "/coffee" path.
 *
 * @author Pavel Stambrecht
 * @date 13/05/2018
 */
class CoffeeSliceProvider : SliceProvider() {

    companion object {
        private const val PATH_COFFEE = "/coffee"
    }

    /**
     * @return true if the provider was successfully loaded, false otherwise
     * @see [SliceProvider] documentation
     */
    override fun onCreateSliceProvider(): Boolean = true

    /**
     * Handles "/coffee" path to create coffee slice
     * @see [CoffeeSliceProvider.createCoffeeSlice]
     */
    override fun onBindSlice(sliceUri: Uri): Slice? = when (sliceUri.path) {
        PATH_COFFEE -> createCoffeeSlice(sliceUri)
        else -> null
    }

    /**
     * Creates simple [Slice] containing Header Title, Image, Title and Subtitle
     * @return [Slice]
     */
    private fun createCoffeeSlice(sliceUri: Uri): Slice? =
            ListBuilder(context, sliceUri, ListBuilder.INFINITY)
                    .setHeader {
                        it.apply {
                            setTitle("Hello Coffee")
                        }
                    }
                    .addGridRow {
                        it.apply {
                            addCell {
                                it.apply {
                                    addImage(IconCompat.createWithResource(context, R.drawable.coffee), LARGE_IMAGE)
                                }
                            }
                        }
                    }
                    .addRow {
                        it.apply {
                            setTitle("Coffee")
                            setSubtitle("#CoffeeLover")
                        }
                    }
                    .build()

}
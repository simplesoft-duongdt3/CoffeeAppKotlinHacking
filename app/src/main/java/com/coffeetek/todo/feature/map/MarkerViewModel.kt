package com.coffeetek.todo.feature.map

import android.support.annotation.DrawableRes
import com.google.android.gms.maps.model.LatLng

/**
 * Create by Mr.X on 1/20/19
 */
data class MarkerViewModel @JvmOverloads constructor(
    var id: Long? = null,
    var latLng: LatLng = LatLng(0.0, 0.0),
    @DrawableRes var iconMarker: Int = 0,
    @DrawableRes var iconMarkerSelected: Int = 0
)
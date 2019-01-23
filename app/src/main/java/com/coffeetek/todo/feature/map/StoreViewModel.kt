package com.coffeetek.todo.feature.map

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Create by Mr.X on 1/23/19
 */
@Parcelize
data class StoreViewModel(
    var id: Long,
    var name: String,
    var minDistance: Double,
    var minTime: Double,
    var addressName: String
) :
    Parcelable

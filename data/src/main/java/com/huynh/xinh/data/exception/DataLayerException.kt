package com.huynh.xinh.data.exception

import android.os.Build
import android.support.annotation.RequiresApi

open class DataLayerException : RuntimeException {
    constructor()

    constructor(message: String) : super(message)

    constructor(message: String, cause: Throwable) : super(message, cause)

    constructor(cause: Throwable) : super(cause)

    @RequiresApi(api = Build.VERSION_CODES.N)
    constructor(message: String, cause: Throwable, enableSuppression: Boolean, writableStackTrace: Boolean) : super(
        message,
        cause,
        enableSuppression,
        writableStackTrace
    )
}

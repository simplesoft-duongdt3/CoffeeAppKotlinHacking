package com.coffeetek.todo.location.rxfusedlocation

import android.app.Activity
import android.app.PendingIntent
import android.content.Intent
import android.content.IntentSender
import android.os.Bundle
import com.coffeetek.todo.location.settinglocaiton.SettingsFusedLocationSingleOnSubscribe

open class LocationSettingsActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            handleIntent()
        }
    }

    override fun onNewIntent(intent: Intent) {
        setIntent(intent)
        handleIntent()
    }

    private fun handleIntent() {
        val resolution = intent.getParcelableExtra<PendingIntent>(ARG_RESOLUTION)

        try {
            startIntentSenderForResult(resolution, REQUEST_CODE_RESOLUTION)
        } catch (e: IntentSender.SendIntentException) {

            setResolutionResultAndFinish(Activity.RESULT_CANCELED)
        } catch (e: NullPointerException) {
            setResolutionResultAndFinish(Activity.RESULT_CANCELED)
        }
    }

    private fun startIntentSenderForResult(pendingIntent: PendingIntent, requestCode: Int) {
        startIntentSenderForResult(pendingIntent.intentSender, requestCode, null, 0, 0, 0, null)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (requestCode == REQUEST_CODE_RESOLUTION) {
            setResolutionResultAndFinish(resultCode)
        } else {
            setResolutionResultAndFinish(Activity.RESULT_CANCELED)
        }
    }

    private fun setResolutionResultAndFinish(resultCode: Int) {
        SettingsFusedLocationSingleOnSubscribe.onResolutionResult(intent.getStringExtra(ARG_ID), resultCode)
        finish()
    }

    companion object {
        const val ARG_ID = "id"
        const val ARG_RESOLUTION = "resolution"

        const val REQUEST_CODE_RESOLUTION = 1000
    }
}
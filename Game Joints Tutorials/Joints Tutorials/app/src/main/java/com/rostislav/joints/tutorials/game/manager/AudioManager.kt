package com.rostislav.joints.tutorials.game.manager

import android.content.Context
import android.media.AudioManager
import com.rostislav.joints.tutorials.appContext

object AudioManager {

    val audioManager   by lazy { appContext.getSystemService(Context.AUDIO_SERVICE) as AudioManager }
    val maxVolumeLevel by lazy { audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC) }
    val volumeLevel    get() = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)

    val onePercentVolumeLevel by lazy { (maxVolumeLevel / 100f) }
    val volumeLevelPercent    get() = volumeLevel / onePercentVolumeLevel

}
package com.rostislav.joints.tutorials.game.manager.util

import com.badlogic.gdx.audio.Sound
import com.rostislav.joints.tutorials.game.manager.AudioManager
import com.rostislav.joints.tutorials.game.manager.SoundManager
import com.rostislav.joints.tutorials.game.utils.runGDX

class SoundUtil {

    // Common
    val TOUCH_DOWN  = SoundManager.EnumSound.TOUCH_DOWN.data.sound

    // Collision
    val ELECTRICITY = SoundManager.EnumSound.ELECTRICITY.data.sound
    val BORDER      = SoundManager.EnumSound.BORDER.data.sound
    val METAL       = SoundManager.EnumSound.METAL.data.sound
    val CLUNK       = SoundManager.EnumSound.CLUNK.data.sound

//    val listok by lazy { listOf(
//                "t5" to SoundManager.EnumSound.t5.data.sound,
//    ) }

    var volumeLevel = AudioManager.volumeLevelPercent / 100f

    var isPause = (volumeLevel <= 0f)

    fun play(sound: Sound) = runGDX { if (isPause.not()) sound.play(volumeLevel) }
}
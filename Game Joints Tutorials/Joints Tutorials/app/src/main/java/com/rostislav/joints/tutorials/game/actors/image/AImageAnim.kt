package com.rostislav.joints.tutorials.game.actors.image

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.Animation
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable
import com.badlogic.gdx.utils.Array
import com.rostislav.joints.tutorials.game.utils.advanced.AdvancedGroup
import com.rostislav.joints.tutorials.game.utils.advanced.AdvancedScreen

class AImageAnim(
    override val screen  : AdvancedScreen,
    frameDuration: Float,
    keyFrames    : List<TextureRegion>,
    playMode     : PlayMode,
): AdvancedGroup() {

    // Actor
    private val image = Image()

    // Field
    private val animation = Animation<TextureRegion>(frameDuration, Array(keyFrames.toTypedArray()), playMode)
    private var time      = 0f

    override fun addActorsOnGroup() {
        addAndFillActor(image)
    }

    override fun draw(batch: Batch?, parentAlpha: Float) {
        super.draw(batch, parentAlpha)
        image.drawable = TextureRegionDrawable(animation.getKeyFrame(time))
        time += Gdx.graphics.deltaTime
    }

}
package com.rostislav.joints.tutorials.game.box2d.bodies

import com.badlogic.gdx.physics.box2d.BodyDef
import com.badlogic.gdx.physics.box2d.FixtureDef
import com.rostislav.joints.tutorials.game.actors.volume.AVolume
import com.rostislav.joints.tutorials.game.box2d.AbstractBody
import com.rostislav.joints.tutorials.game.utils.advanced.AdvancedBox2dScreen
import com.rostislav.joints.tutorials.game.utils.advanced.AdvancedGroup

class BVolume(
    override val screenBox2d: AdvancedBox2dScreen,
    val type: AVolume.Static.Type
): AbstractBody() {
    override val name       = "volume"
    override val bodyDef    = BodyDef().apply {
        type = BodyDef.BodyType.StaticBody
    }
    override val fixtureDef = FixtureDef()
    override var actor: AdvancedGroup? = AVolume(screenBox2d, type)

    fun getActor(): AVolume? = actor as? AVolume
}
package com.rostislav.joints.tutorials.game.box2d.bodies

import com.badlogic.gdx.physics.box2d.BodyDef
import com.badlogic.gdx.physics.box2d.FixtureDef
import com.rostislav.joints.tutorials.game.actors.image.AImage
import com.rostislav.joints.tutorials.game.box2d.AbstractBody
import com.rostislav.joints.tutorials.game.utils.advanced.AdvancedBox2dScreen
import com.rostislav.joints.tutorials.game.utils.advanced.AdvancedGroup

class BLiftPlatform(override val screenBox2d: AdvancedBox2dScreen): AbstractBody() {
    override val name       = "lift_platform"
    override val bodyDef    = BodyDef().apply {
        type          = BodyDef.BodyType.DynamicBody
        fixedRotation = true
    }
    override val fixtureDef = FixtureDef().apply {
        density     = 1f
        restitution = 0f
        friction    = 1f
    }
    override var actor: AdvancedGroup? = AImage(screenBox2d, screenBox2d.game.themeUtil.assets.LIFT_PLATFORM)
}
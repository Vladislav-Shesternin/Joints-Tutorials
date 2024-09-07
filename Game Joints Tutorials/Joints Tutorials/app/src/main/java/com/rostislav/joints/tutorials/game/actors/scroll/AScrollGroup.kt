package com.rostislav.joints.tutorials.game.actors.scroll

import com.rostislav.joints.tutorials.game.utils.advanced.AdvancedGroup
import com.rostislav.joints.tutorials.game.utils.advanced.AdvancedScreen

class AScrollGroup(override val screen: AdvancedScreen) : AdvancedGroup() {

    override fun getPrefWidth(): Float {
        return width
    }

    override fun getPrefHeight(): Float {
        return height
    }

    override fun addActorsOnGroup() {}

}
package com.rostislav.joints.tutorials.game.screens.practicalScreen

import com.rostislav.joints.tutorials.game.LibGDXGame
import com.rostislav.joints.tutorials.game.box2d.bodiesGroup.practical.AbstractBGPractical
import com.rostislav.joints.tutorials.game.box2d.bodiesGroup.practical.BGPractical_JPulley
import com.rostislav.joints.tutorials.game.utils.TIME_ANIM_SCREEN_ALPHA
import com.rostislav.joints.tutorials.game.utils.actor.animHide
import com.rostislav.joints.tutorials.game.utils.actor.animShow
import com.rostislav.joints.tutorials.game.utils.advanced.AdvancedPracticalScreen
import com.rostislav.joints.tutorials.game.utils.region

class Practical_JPulleyScreen(override val game: LibGDXGame): AdvancedPracticalScreen(game) {

    // BodyGroup
    override val bgPractical: AbstractBGPractical = BGPractical_JPulley(this)

    override fun show() {
        stageUI.root.animHide()
        setUIBackground(game.themeUtil.assets.BACKGROUND.region)
        super.show()

        stageUI.root.animShow(TIME_ANIM_SCREEN_ALPHA)
    }

}
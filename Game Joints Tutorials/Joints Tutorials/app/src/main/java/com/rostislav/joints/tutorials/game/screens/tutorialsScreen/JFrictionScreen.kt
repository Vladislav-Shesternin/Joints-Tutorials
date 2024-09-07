package com.rostislav.joints.tutorials.game.screens.tutorialsScreen

import com.rostislav.joints.tutorials.game.LibGDXGame
import com.rostislav.joints.tutorials.game.actors.scroll.tutorial.AScrollPanel_JFriction
import com.rostislav.joints.tutorials.game.manager.SpriteManager
import com.rostislav.joints.tutorials.game.manager.util.SpriteUtil
import com.rostislav.joints.tutorials.game.screens.practicalScreen.Practical_JFrictionScreen
import com.rostislav.joints.tutorials.game.utils.advanced.AdvancedTutorialScreen

class JFrictionScreen(override val game: LibGDXGame): AdvancedTutorialScreen(game) {

    override val title               = "Friction Joint"
    override val practicalScreenName = Practical_JFrictionScreen::class.java.name

    override var loadableAtlasList   = SpriteManager.EnumAtlas_JointFriction.values().map { it.data }.toMutableList()
    override val loadableTextureList = SpriteManager.EnumTexture_JointFriction.values().map { it.data }.toMutableList()

    override fun loadingAssets() {
        if (isFinishLoading.not()) {
            if (assetManager.update(16)) {
                isFinishLoading = true
                initAssets()

                spriteUtil  = SpriteUtil.JointFriction()
                aScrollPane = AScrollPanel_JFriction(this, spriteUtil as SpriteUtil.JointFriction)

                superShow()
            }
        }
    }

}
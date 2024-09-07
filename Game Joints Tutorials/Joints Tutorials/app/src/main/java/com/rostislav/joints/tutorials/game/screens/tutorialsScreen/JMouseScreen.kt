package com.rostislav.joints.tutorials.game.screens.tutorialsScreen

import com.rostislav.joints.tutorials.game.LibGDXGame
import com.rostislav.joints.tutorials.game.actors.scroll.tutorial.AScrollPanel_JMouse
import com.rostislav.joints.tutorials.game.manager.SpriteManager
import com.rostislav.joints.tutorials.game.manager.util.SpriteUtil
import com.rostislav.joints.tutorials.game.screens.practicalScreen.Practical_JMouseScreen
import com.rostislav.joints.tutorials.game.utils.advanced.AdvancedTutorialScreen

class JMouseScreen(override val game: LibGDXGame): AdvancedTutorialScreen(game) {

    override val title               = "Mouse Joint"
    override val practicalScreenName = Practical_JMouseScreen::class.java.name

    override var loadableAtlasList   = SpriteManager.EnumAtlas_JointMouse.values().map { it.data }.toMutableList()
    override val loadableTextureList = SpriteManager.EnumTexture_JointMouse.values().map { it.data }.toMutableList()

    override fun loadingAssets() {
        if (isFinishLoading.not()) {
            if (assetManager.update(16)) {
                isFinishLoading = true
                initAssets()

                spriteUtil  = SpriteUtil.JointMouse()
                aScrollPane = AScrollPanel_JMouse(this, spriteUtil as SpriteUtil.JointMouse)

                superShow()
            }
        }
    }

}
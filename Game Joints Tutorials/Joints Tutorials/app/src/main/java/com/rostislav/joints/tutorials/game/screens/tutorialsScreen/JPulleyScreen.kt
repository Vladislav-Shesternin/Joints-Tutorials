package com.rostislav.joints.tutorials.game.screens.tutorialsScreen

import com.rostislav.joints.tutorials.game.LibGDXGame
import com.rostislav.joints.tutorials.game.actors.scroll.tutorial.AScrollPanel_JPulley
import com.rostislav.joints.tutorials.game.manager.SpriteManager
import com.rostislav.joints.tutorials.game.manager.util.SpriteUtil
import com.rostislav.joints.tutorials.game.screens.practicalScreen.Practical_JPulleyScreen
import com.rostislav.joints.tutorials.game.utils.advanced.AdvancedTutorialScreen

class JPulleyScreen(override val game: LibGDXGame): AdvancedTutorialScreen(game) {

    override val title               = "Pulley Joint"
    override val practicalScreenName = Practical_JPulleyScreen::class.java.name

    override var loadableAtlasList   = SpriteManager.EnumAtlas_JointPulley.values().map { it.data }.toMutableList()
    override val loadableTextureList = SpriteManager.EnumTexture_JointPulley.values().map { it.data }.toMutableList()

    override fun loadingAssets() {
        if (isFinishLoading.not()) {
            if (assetManager.update(16)) {
                isFinishLoading = true
                initAssets()

                spriteUtil  = SpriteUtil.JointPulley()
                aScrollPane = AScrollPanel_JPulley(this, spriteUtil as SpriteUtil.JointPulley)

                superShow()
            }
        }
    }

}
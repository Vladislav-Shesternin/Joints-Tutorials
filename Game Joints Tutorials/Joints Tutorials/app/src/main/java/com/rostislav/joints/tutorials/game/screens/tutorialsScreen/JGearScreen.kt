package com.rostislav.joints.tutorials.game.screens.tutorialsScreen

import com.rostislav.joints.tutorials.game.LibGDXGame
import com.rostislav.joints.tutorials.game.actors.scroll.tutorial.AScrollPanel_JGear
import com.rostislav.joints.tutorials.game.manager.SpriteManager
import com.rostislav.joints.tutorials.game.manager.util.SpriteUtil
import com.rostislav.joints.tutorials.game.screens.practicalScreen.Practical_JGearScreen
import com.rostislav.joints.tutorials.game.utils.advanced.AdvancedTutorialScreen

class JGearScreen(override val game: LibGDXGame): AdvancedTutorialScreen(game) {

    override val title               = "Gear Joint"
    override val practicalScreenName = Practical_JGearScreen::class.java.name

    override var loadableAtlasList   = SpriteManager.EnumAtlas_JointGear.values().map { it.data }.toMutableList()
    override val loadableTextureList = SpriteManager.EnumTexture_JointGear.values().map { it.data }.toMutableList()

    override fun loadingAssets() {
        if (isFinishLoading.not()) {
            if (assetManager.update(16)) {
                isFinishLoading = true
                initAssets()

                spriteUtil  = SpriteUtil.JointGear()
                aScrollPane = AScrollPanel_JGear(this, spriteUtil as SpriteUtil.JointGear)

                superShow()
            }
        }
    }

}
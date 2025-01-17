package com.rostislav.joints.tutorials.game.screens.tutorialsScreen

import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.utils.Align
import com.rostislav.joints.tutorials.game.LibGDXGame
import com.rostislav.joints.tutorials.game.utils.GameColor
import com.rostislav.joints.tutorials.game.utils.TIME_ANIM_SCREEN_ALPHA
import com.rostislav.joints.tutorials.game.utils.actor.animHide
import com.rostislav.joints.tutorials.game.utils.actor.animShow
import com.rostislav.joints.tutorials.game.utils.advanced.AdvancedScreen
import com.rostislav.joints.tutorials.game.utils.advanced.AdvancedStage
import com.rostislav.joints.tutorials.game.utils.font.FontParameter
import com.rostislav.joints.tutorials.game.utils.region
import com.rostislav.joints.tutorials.tutorials.R

class WillBeLaterScreen(override val game: LibGDXGame): AdvancedScreen() {

    private val fontParameter    = FontParameter().setCharacters(FontParameter.CharType.ALL)
    private val fontExtraBold_70 = fontGeneratorInter_ExtraBold.generateFont(fontParameter.setSize(70))
    private val fontRegular_50   = fontGeneratorInter_Regular.generateFont(fontParameter.setSize(50))
    private val fontLight_50     = fontGeneratorInter_Light.generateFont(fontParameter.setSize(50))

    // Actor
    private val willBeLaterLbl    = Label(game.languageUtil.getStringResource(R.string.will_be_later), Label.LabelStyle(fontExtraBold_70, GameColor.textRed))
    private val nowImplementedLbl = Label(game.languageUtil.getStringResource(R.string.now_implemented), Label.LabelStyle(fontRegular_50, GameColor.textGreen))
    private val nowScreensLbl     = Label(game.languageUtil.getStringResource(R.string.now_implemented_screen), Label.LabelStyle(fontLight_50, GameColor.textRed))

    override fun show() {
        stageUI.root.animHide()
        setUIBackground(game.themeUtil.assets.BACKGROUND.region)
        super.show()
    }

    override fun AdvancedStage.addActorsOnStageUI() {
        addLbls()
        stageUI.root.animShow(TIME_ANIM_SCREEN_ALPHA)
    }

    // ---------------------------------------------------
    // Add Actor
    // ---------------------------------------------------

    private fun AdvancedStage.addLbls() {
        addActors(willBeLaterLbl, nowImplementedLbl, nowScreensLbl)
        willBeLaterLbl.apply {
            setBounds(0f, 1068f, 700f, 85f)
            setAlignment(Align.center)
        }
        nowImplementedLbl.apply {
            setBounds(0f, 891f, 700f, 61f)
            setAlignment(Align.center)
        }
        nowScreensLbl.apply {
            setBounds(96f, 237f, 604f, 610f)
        }
    }

}
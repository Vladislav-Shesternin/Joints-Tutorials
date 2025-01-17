package com.rostislav.joints.tutorials.game.actors.frame

import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.rostislav.joints.tutorials.game.actors.label.AutoLanguageSpinningLabel
import com.rostislav.joints.tutorials.game.utils.GameColor
import com.rostislav.joints.tutorials.game.utils.advanced.AdvancedGroup
import com.rostislav.joints.tutorials.game.utils.advanced.AdvancedScreen
import com.rostislav.joints.tutorials.game.utils.font.FontParameter
import com.rostislav.joints.tutorials.game.utils.font.FontParameter.CharType
import com.rostislav.joints.tutorials.tutorials.R
import kotlinx.coroutines.launch

class AFrameLanguage(override val screen: AdvancedScreen): AdvancedGroup() {

    override var standartW = 314f

    private val themeUtil   = screen.game.themeUtil

    private val parameter = FontParameter()

    private val frameImg    = Image(themeUtil.assets.FRAME_LANGUAGE)
    private val languageLbl = AutoLanguageSpinningLabel(screen, if (screen.game.languageUtil.languageFlow.value.language == "uk") R.string.ukrainian else R.string.english, Label.LabelStyle(screen.fontGeneratorInter_ExtraBold.generateFont(parameter.setCharacters(CharType.LATIN_CYRILLIC).setSize(50)), GameColor.textGreen))

    override fun addActorsOnGroup() {
        addFrameImg()
        addLanguageLbl()

        asyncCollectLocaleAndUpdateResId()
    }

    // ------------------------------------------------------------------------
    // Add Actors
    // ------------------------------------------------------------------------

    private fun addFrameImg() {
        addActor(frameImg)
        frameImg.setBoundsStandart(0f,0f,314f,102f)
    }

    private fun addLanguageLbl() {
        addActor(languageLbl)
        languageLbl.apply {
            setBoundsStandart(10f,10f,294f,82f)
        }
    }

    // ---------------------------------------------------
    // Logic
    // ---------------------------------------------------

    private fun asyncCollectLocaleAndUpdateResId() {
        coroutine?.launch {
            screen.game.languageUtil.languageFlow.collect {
                when(it.language) {
                    "uk" -> R.string.ukrainian
                    else -> R.string.english
                }.also { resId -> languageLbl.setResId(resId) }
            }
        }
    }

}
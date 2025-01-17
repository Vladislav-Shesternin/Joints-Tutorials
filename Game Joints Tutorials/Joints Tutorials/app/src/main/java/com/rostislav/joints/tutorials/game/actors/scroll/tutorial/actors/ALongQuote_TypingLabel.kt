package com.rostislav.joints.tutorials.game.actors.scroll.tutorial.actors

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.github.tommyettinger.textra.Font
import com.github.tommyettinger.textra.TypingLabel
import com.rostislav.joints.tutorials.game.utils.advanced.AdvancedGroup
import com.rostislav.joints.tutorials.game.utils.advanced.AdvancedScreen

class ALongQuote_TypingLabel(
    override val screen : AdvancedScreen,
    textQuote: String,
    font     : Font,
): AdvancedGroup() {

    private val lineImg    = Image(screen.drawerUtil.getRegion(Color.BLACK))
    val quoteLbl   = TypingLabel(textQuote, font)

    override fun addActorsOnGroup() {
        addQuoteLbl()
        addLineImg()
    }

    private fun addQuoteLbl() {
        addActor(quoteLbl)
        quoteLbl.apply {
            x      = 14f
            wrap   = true
            width  = this@ALongQuote_TypingLabel.width - 14
            height = prefHeight
        }

        height = quoteLbl.height
    }

    private fun addLineImg() {
        addActor(lineImg)
        lineImg.setBounds(0f, 0f, 6f, quoteLbl.height)
    }

}
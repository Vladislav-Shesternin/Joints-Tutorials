package com.rostislav.joints.tutorials.game.actors.button

import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.utils.Align
import com.github.tommyettinger.textra.TypingLabel
import com.rostislav.joints.tutorials.game.utils.actor.disable
import com.rostislav.joints.tutorials.game.utils.advanced.AdvancedScreen

class AButton_Regular(
    override val screen: AdvancedScreen,
    text: String, labelStyle: Label.LabelStyle,
    labelType: Static.LabelType = Static.LabelType.DEFAULT
): AButton(screen, AButton.Static.Type.REGULAR) {

    override var standartW = 466f

    val label = when(labelType) {
        Static.LabelType.DEFAULT -> Label(text, labelStyle)
        Static.LabelType.TYPING  -> TypingLabel(text, labelStyle)
    }

    override fun addActorsOnGroup() {
        super.addActorsOnGroup()
        addLabel()
    }

    // ------------------------------------------------------------------------
    // Add Actors
    // ------------------------------------------------------------------------

    private fun addLabel() {
        addActor(label)
        label.apply {
            setBoundsStandart(0f,19f,466f,150f)
            disable()

            when(label) {
                is Label -> {
                    label.setAlignment(Align.center)
                    label.wrap = true
                }
                is TypingLabel -> {
                    label.alignment = Align.center
                    label.wrap = true
                }
            }

        }
    }

    // ------------------------------------------------------------------------
    // Logic
    // ------------------------------------------------------------------------

    fun setText(text: String) {
        when (label) {
            is Label       -> label.setText(text)
            is TypingLabel -> label.setText(text)
        }
    }

    object Static {
        enum class LabelType {
            DEFAULT, TYPING
        }
    }

}
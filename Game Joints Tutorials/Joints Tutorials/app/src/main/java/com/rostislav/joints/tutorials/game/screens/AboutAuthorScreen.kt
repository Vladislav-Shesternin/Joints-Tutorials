package com.rostislav.joints.tutorials.game.screens

import android.content.Intent
import android.net.Uri
import com.badlogic.gdx.math.Interpolation
import com.badlogic.gdx.scenes.scene2d.actions.Actions
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.utils.Align
import com.rostislav.joints.tutorials.game.LibGDXGame
import com.rostislav.joints.tutorials.game.actors.label.ASpinningLabel
import com.rostislav.joints.tutorials.game.box2d.BodyId
import com.rostislav.joints.tutorials.game.box2d.bodies.BSeparator
import com.rostislav.joints.tutorials.game.box2d.bodiesGroup.BGBorders
import com.rostislav.joints.tutorials.game.box2d.bodiesGroup.BGDescriptionPanel
import com.rostislav.joints.tutorials.game.box2d.bodiesGroup.BGThanksFrame
import com.rostislav.joints.tutorials.game.box2d.destroyAll
import com.rostislav.joints.tutorials.game.utils.GameColor
import com.rostislav.joints.tutorials.game.utils.TIME_ANIM_SCREEN_ALPHA
import com.rostislav.joints.tutorials.game.utils.actor.animHide
import com.rostislav.joints.tutorials.game.utils.actor.animShow
import com.rostislav.joints.tutorials.game.utils.actor.setOnClickListener
import com.rostislav.joints.tutorials.game.utils.advanced.AdvancedMouseScreen
import com.rostislav.joints.tutorials.game.utils.advanced.AdvancedStage
import com.rostislav.joints.tutorials.game.utils.font.FontParameter
import com.rostislav.joints.tutorials.game.utils.font.FontParameter.CharType
import com.rostislav.joints.tutorials.game.utils.region
import com.rostislav.joints.tutorials.tutorials.BuildConfig
import com.rostislav.joints.tutorials.tutorials.R
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.launch


class AboutAuthorScreen(override val game: LibGDXGame): AdvancedMouseScreen(game) {

    // Actor
    private val aHandVImg    = Image(game.themeUtil.assets.HAND_V)
    private val aEldanImg    = Image(game.themeUtil.assets.EL_DAN)
    private val aPSImg       = Image(game.themeUtil.assets.PS)
    private val aStarsImg    = Image(game.themeUtil.assets.stars)
    private val aStarsLbl    = Label(game.languageUtil.getStringResource(R.string.stars), Label.LabelStyle(fontGeneratorInter_ExtraBold.generateFont(FontParameter().setCharacters(CharType.LATIN_CYRILLIC).setSize(35)), GameColor.textGreen))

    // Body
    private val bSeparator = BSeparator(this)

    // BodyGroup
    private val bgBorders          = BGBorders(this)
    private val bgDescriptionPanel = BGDescriptionPanel(this)
    private val bgThanksFrame      = BGThanksFrame(this)

    override fun show() {
        stageUI.root.animHide()
        setUIBackground(game.themeUtil.assets.BACKGROUND.region)
        super.show()
    }

    override fun AdvancedStage.addActorsOnStageUI() {
        initB_Separator()

        addV()
        addTelegramImg()

        createBG_Borders()
        createB_Separator()
        createBG_DescriptionPanel()
        createBG_ThanksFrame()

        coroutine?.launch { animV() }
        stageUI.root.animShow(TIME_ANIM_SCREEN_ALPHA)
    }


    override fun dispose() {
        listOf(bgBorders, bgDescriptionPanel, bgThanksFrame).destroyAll()
        super.dispose()
    }

    // ------------------------------------------------------------------------
    // Add Actors
    // ------------------------------------------------------------------------
    private fun AdvancedStage.addV() {
        addActors(aHandVImg, aEldanImg, aPSImg)
        aHandVImg.apply {
            setBounds(-112f, 1188f, 112f, 203f)
            animHide()
        }
        aEldanImg.apply {
            setBounds(192f, 1400f, 254f, 91f)
            animHide()
        }
        aPSImg.apply {
            setBounds(700f, 1189f, 411f, 64f)
            animHide()
        }
    }

    private fun AdvancedStage.addTelegramImg() {
        addActor(aStarsImg)
        aStarsImg.apply {
            setBounds(154f, 212f, 392f, 258f)
            setOnClickListener {
                game.activity.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=${BuildConfig.APPLICATION_ID}")))
            }
        }

        addActor(aStarsLbl)
        aStarsLbl.setBounds(0f, 132f, 700f, 42f)
        aStarsLbl.setAlignment(Align.center)
    }

    // ---------------------------------------------------
    // Init Body
    // ---------------------------------------------------

    private fun initB_Separator() {
        bSeparator.apply {
            id = BodyId.SEPARATOR
            collisionList.addAll(arrayOf(BodyId.AboutAuthor.ITEM))
        }
    }

    // ---------------------------------------------------
    // Create Body
    // ---------------------------------------------------

    private fun createB_Separator() {
        bSeparator.create(0f, 1179f, 700f, 10f)
    }

    // ------------------------------------------------------------------------
    // Create Body Group
    // ------------------------------------------------------------------------
    private fun createBG_Borders() {
        bgBorders.create(0f,0f,700f,1400f)
    }

    private fun createBG_DescriptionPanel() {
        bgDescriptionPanel.create(53f,650f,595f,529f)
    }

    private fun createBG_ThanksFrame() {
        bgThanksFrame.create(0f,534f,700f,72f)
    }

    // ---------------------------------------------------
    // Anim
    // ---------------------------------------------------

    private suspend fun animV() = CompletableDeferred<Unit>().also { continuation ->
        val moveTime  = 0.7f
        val alphaTime = 0.5f

        aHandVImg.addAction(Actions.parallel(
            Actions.moveTo(107f, 1188f, moveTime, Interpolation.sineOut),
            Actions.fadeIn(alphaTime),
        ))
        aEldanImg.addAction(Actions.parallel(
            Actions.moveTo(192f, 1290f, moveTime, Interpolation.sineOut),
            Actions.fadeIn(alphaTime),
        ))
        aPSImg.addAction(Actions.sequence(
            Actions.parallel(
                Actions.moveTo(240f, 1189f, moveTime, Interpolation.sineOut),
                Actions.fadeIn(alphaTime),
            ),
            Actions.run { continuation.complete(Unit) }
        ))
    }.await()

}
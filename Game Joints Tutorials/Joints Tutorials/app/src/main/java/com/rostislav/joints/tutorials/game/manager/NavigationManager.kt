package com.rostislav.joints.tutorials.game.manager

import com.badlogic.gdx.Gdx
import com.rostislav.joints.tutorials.game.LibGDXGame
import com.rostislav.joints.tutorials.game.screens.*
import com.rostislav.joints.tutorials.game.screens.practicalScreen.*
import com.rostislav.joints.tutorials.game.screens.tutorialsScreen.*
import com.rostislav.joints.tutorials.game.utils.advanced.AdvancedScreen
import com.rostislav.joints.tutorials.game.utils.runGDX

class NavigationManager(val game: LibGDXGame) {

    private val backStack = mutableListOf<String>()
    var key: Int? = null
        private set

    fun navigate(toScreenName: String, fromScreenName: String? = null, key: Int? = null) = runGDX {
        this.key = key

        game.updateScreen(getScreenByName(toScreenName))
        backStack.filter { name -> name == toScreenName }.onEach { name -> backStack.remove(name) }
        fromScreenName?.let { fromName ->
            backStack.filter { name -> name == fromName }.onEach { name -> backStack.remove(name) }
            backStack.add(fromName)
        }
    }

    fun back(key: Int? = null) = runGDX {
        this.key = key

        if (isBackStackEmpty()) exit() else game.updateScreen(getScreenByName(backStack.removeAt(backStack.lastIndex)))
    }


    fun exit() = runGDX { Gdx.app.exit() }


    fun isBackStackEmpty() = backStack.isEmpty()

    private fun getScreenByName(name: String): AdvancedScreen = when(name) {
        LoaderScreen              ::class.java.name -> LoaderScreen(game)
        MenuScreen                ::class.java.name -> MenuScreen(game)
        TutorialIntroductionScreen::class.java.name -> TutorialIntroductionScreen(game)
        SettingsScreen            ::class.java.name -> SettingsScreen(game)
        AboutAuthorScreen         ::class.java.name -> AboutAuthorScreen(game)
        TutorialsScreen           ::class.java.name -> TutorialsScreen(game)
        // Tutorials Screens
        GeneralInformationScreen::class.java.name -> GeneralInformationScreen(game)
        JMouseScreen            ::class.java.name -> JMouseScreen(game)
        JDistanceScreen         ::class.java.name -> JDistanceScreen(game)
        JRevoluteScreen         ::class.java.name -> JRevoluteScreen(game)
        JPrismaticScreen        ::class.java.name -> JPrismaticScreen(game)
        JWheelScreen            ::class.java.name -> JWheelScreen(game)
        JWeldScreen             ::class.java.name -> JWeldScreen(game)
        JFrictionScreen         ::class.java.name -> JFrictionScreen(game)
        JRopeScreen             ::class.java.name -> JRopeScreen(game)
        JPulleyScreen           ::class.java.name -> JPulleyScreen(game)
        JGearScreen             ::class.java.name -> JGearScreen(game)
        JMotorScreen            ::class.java.name -> JMotorScreen(game)

        WillBeLaterScreen::class.java.name -> WillBeLaterScreen(game)
        // Practical Screens
        Practical_JMouseScreen    ::class.java.name -> Practical_JMouseScreen(game)
        Practical_JDistanceScreen ::class.java.name -> Practical_JDistanceScreen(game)
        Practical_JRevoluteScreen ::class.java.name -> Practical_JRevoluteScreen(game)
        Practical_JPrismaticScreen::class.java.name -> Practical_JPrismaticScreen(game)
        Practical_JWheelScreen    ::class.java.name -> Practical_JWheelScreen(game)
        Practical_JWeldScreen     ::class.java.name -> Practical_JWeldScreen(game)
        Practical_JFrictionScreen ::class.java.name -> Practical_JFrictionScreen(game)
        Practical_JRopeScreen     ::class.java.name -> Practical_JRopeScreen(game)
        Practical_JPulleyScreen   ::class.java.name -> Practical_JPulleyScreen(game)
        Practical_JGearScreen     ::class.java.name -> Practical_JGearScreen(game)
        Practical_JMotorScreen    ::class.java.name -> Practical_JMotorScreen(game)



        else -> MenuScreen(game)
    }

}
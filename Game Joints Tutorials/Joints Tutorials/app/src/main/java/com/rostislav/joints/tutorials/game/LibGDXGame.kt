package com.rostislav.joints.tutorials.game

import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.assets.loaders.resolvers.LocalFileHandleResolver
import com.badlogic.gdx.utils.Disposable
import com.badlogic.gdx.utils.ScreenUtils
import com.rostislav.joints.tutorials.MainActivity
import com.rostislav.joints.tutorials.game.manager.MusicManager
import com.rostislav.joints.tutorials.game.manager.NavigationManager
import com.rostislav.joints.tutorials.game.manager.SoundManager
import com.rostislav.joints.tutorials.game.manager.SpriteManager
import com.rostislav.joints.tutorials.game.manager.util.MusicUtil
import com.rostislav.joints.tutorials.game.manager.util.SoundUtil
import com.rostislav.joints.tutorials.game.screens.LoaderScreen
import com.rostislav.joints.tutorials.game.utils.GameColor
import com.rostislav.joints.tutorials.game.utils.advanced.AdvancedGame
import com.rostislav.joints.tutorials.game.utils.disposeAll
import com.rostislav.joints.tutorials.game.utils.language.LanguageUtil
import com.rostislav.joints.tutorials.game.utils.theme.ThemeUtil
import com.rostislav.joints.tutorials.util.log

class LibGDXGame(val activity: MainActivity) : AdvancedGame() {

    lateinit var assetManager     : AssetManager      private set
    lateinit var assetManagerLocal: AssetManager      private set
    lateinit var navigationManager: NavigationManager private set
    lateinit var spriteManager    : SpriteManager     private set
    lateinit var musicManager     : MusicManager      private set
    lateinit var soundManager     : SoundManager      private set

    val musicUtil    by lazy { MusicUtil()    }
    val soundUtil    by lazy { SoundUtil()    }
    val themeUtil    by lazy { ThemeUtil()    }
    val languageUtil by lazy { LanguageUtil(activity) }

    var backgroundColor = GameColor.background
    val disposableSet   = mutableSetOf<Disposable>()

    override fun create() {
        navigationManager = NavigationManager(this)
        assetManager      = AssetManager()
        assetManagerLocal = AssetManager(LocalFileHandleResolver())
        spriteManager     = SpriteManager(assetManager)
        musicManager      = MusicManager(assetManager)
        soundManager      = SoundManager(assetManager)

        navigationManager.navigate(LoaderScreen::class.java.name)
    }

    override fun render() {
        ScreenUtils.clear(backgroundColor)
        super.render()
    }

    override fun dispose() {
        try {
            log("dispose LibGDXGame")
            disposableSet.disposeAll()
            disposeAll(musicUtil, assetManager, assetManagerLocal)
            super.dispose()
        } catch (e: Exception) { log("exception: ${e.message}") }
    }

}
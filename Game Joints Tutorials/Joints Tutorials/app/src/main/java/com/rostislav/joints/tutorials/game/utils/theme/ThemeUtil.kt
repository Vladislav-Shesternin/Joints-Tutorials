package com.rostislav.joints.tutorials.game.utils.theme

import com.badlogic.gdx.graphics.Color
import com.rostislav.joints.tutorials.game.manager.util.SpriteUtil
import com.rostislav.joints.tutorials.game.utils.GameColor
import com.rostislav.joints.tutorials.tutorials.R


class ThemeUtil {

    var type: Type = Type.WHITE
        private set
    var assets: SpriteUtil.AllAssets = SpriteUtil.YanAssets()
        private set
    var backgroundColor: Color = GameColor.yan
        private set
    var navBarColorId: Int = R.color.yan
        private set

    fun update(type: Type) {
        this.type = type

        when (type) {
            Type.WHITE -> {
                assets          = SpriteUtil.YanAssets()
                backgroundColor = GameColor.yan
                navBarColorId   = R.color.yan
            }
            Type.BLACK -> {
                assets          = SpriteUtil.YinAssets()
                backgroundColor = GameColor.yin
                navBarColorId   = R.color.yin
            }
        }
    }


    enum class Type {
        BLACK, WHITE
    }

}
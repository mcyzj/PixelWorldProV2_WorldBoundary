package com.mcyzj.pixelworldprov2.worldboundary

import com.mcyzj.pixelworldpro.PixelWorldPro
import com.mcyzj.pixelworldpro.api.Expansion
import com.mcyzj.pixelworldpro.api.objects.Config
import com.mcyzj.pixelworldprov2.worldboundary.listener.Level
import com.mcyzj.pixelworldprov2.worldboundary.listener.WorldSuccess


@Suppress("unused")
class WorldBoundary : Expansion() {
    private val logger = PixelWorldPro.instance.logger

    private var config = Config.INSTANCE.buildConfig("Config.yml")
    override fun onEnable() {
        logger.info("加载PixelWorldPro官方扩展-WorldBoundary世界边界")
        this.listenerManager.register.registerWorldSuccessListener(WorldSuccess)
        this.listenerManager.register.registerLevelListener(Level)
    }

    override fun onDisable() {
        logger.info("卸载PixelWorldPro官方扩展-WorldBoundary世界边界")
    }
    fun buildLevelMap(): HashMap<Int, Int> {
        val levelMap = HashMap<Int, Int>()
        for (key in config.getConfigurationSection("boundary")!!.getKeys(false)){
            levelMap[key.toInt()] = config.getInt("boundary.$key.default")
        }
        return levelMap
    }
}
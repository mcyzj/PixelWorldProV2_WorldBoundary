package com.mcyzj.pixelworldprov2.worldboundary.listener

import com.mcyzj.pixelworldpro.api.interfaces.event.world.WorldSuccessAPI
import com.mcyzj.pixelworldpro.data.dataclass.WorldData
import com.mcyzj.pixelworldpro.expansion.core.level.admin.Admin
import com.mcyzj.pixelworldprov2.worldboundary.WorldBoundary
import org.bukkit.Bukkit
import java.util.*

object WorldSuccess: WorldSuccessAPI {
    override fun createWorld(worldData: WorldData, temlete: String) {
        val levelMap = WorldBoundary().buildLevelMap()
        val level = Admin.INSTANCE.getLevel(worldData)
        val world = Bukkit.getWorld("pixelworldpro/${worldData.world}/world")?:return
        val size = levelMap[level] ?: levelMap.values.last()
        world.worldBorder.size = size.toDouble()
        world.worldBorder.center = world.spawnLocation
    }

    override fun loadWorld(worldData: WorldData) {
        val levelMap = WorldBoundary().buildLevelMap()
        val level = Admin.INSTANCE.getLevel(worldData)
        val world = Bukkit.getWorld("pixelworldpro/${worldData.world}/world")?:return
        val size = levelMap[level] ?: levelMap.values.last()
        world.worldBorder.size = size.toDouble()
        world.worldBorder.center = world.spawnLocation
    }

    override fun unloadWorld(worldData: WorldData) {
    }

    override fun backupWorld(worldData: WorldData, save: Boolean?) {
    }
}
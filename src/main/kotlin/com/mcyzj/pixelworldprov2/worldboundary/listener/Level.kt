package com.mcyzj.pixelworldprov2.worldboundary.listener

import com.mcyzj.pixelworldpro.api.interfaces.event.level.LevelAPI
import com.mcyzj.pixelworldpro.data.dataclass.WorldData
import com.mcyzj.pixelworldprov2.worldboundary.WorldBoundary
import org.bukkit.Bukkit

object Level: LevelAPI {
    override fun levelChange(worldData: WorldData, level: Int) {
        val levelMap = WorldBoundary().buildLevelMap()
        val world = Bukkit.getWorld("pixelworldpro/${worldData.world}/world")?:return
        val size = levelMap[level] ?: levelMap.values.last()
        world.worldBorder.size = size.toDouble()
        world.worldBorder.center = world.spawnLocation
    }

}
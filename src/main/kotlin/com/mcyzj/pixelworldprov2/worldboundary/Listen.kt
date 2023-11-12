package com.mcyzj.pixelworldprov2.worldboundary

import com.mcyzj.pixelworldpro.api.event.world.WorldLoadSuccess
import com.mcyzj.pixelworldpro.expansion.core.level.WorldLevelChange
import com.mcyzj.pixelworldpro.expansion.core.level.admin.Admin
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

class Listen : Listener {
    @EventHandler
    fun levelChange(e: WorldLevelChange){
        println(1)
        val levelMap = WorldBoundary().buildLevelMap()
        val worldData = e.worldData
        val world = Bukkit.getWorld("pixelworldpro/${worldData.world}/world")?:return
        val size = levelMap[e.level] ?: levelMap.values.last()
        world.worldBorder.size = size.toDouble()
        world.worldBorder.center = world.spawnLocation
    }
    @EventHandler
    fun worldLoad(e: WorldLoadSuccess){
        println(2)
        val levelMap = WorldBoundary().buildLevelMap()
        val worldData = e.worldData
        val level = Admin.INSTANCE.getLevel(worldData)
        val world = Bukkit.getWorld("pixelworldpro/${worldData.world}/world")?:return
        val size = levelMap[level] ?: levelMap.values.last()
        world.worldBorder.size = size.toDouble()
        world.worldBorder.center = world.spawnLocation
    }
}
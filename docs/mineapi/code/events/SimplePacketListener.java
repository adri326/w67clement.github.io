package com.w67clement.mineapi.test;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.w67clement.mineapi.api.PacketHandler;
import com.w67clement.mineapi.api.ReflectionAPI;
import com.w67clement.mineapi.api.event.PacketListener;
import com.w67clement.mineapi.api.event.ReceivePacketEvent;
import com.w67clement.mineapi.api.event.SendPacketEvent;
import com.w67clement.mineapi.enums.PacketList;
import com.w67clement.mineapi.message.PacketChat;
import com.w67clement.mineapi.packets.play.in.PacketPlayInChat;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

/**
 * Created by w67clement on 19/03/2016.
 * <p>
 * Class of project: MineAPI_Examples
 */
public class SimplePacketListener implements PacketListener
{
    private static final JsonParser parser = new JsonParser();

    @PacketHandler(listenType = PacketList.PacketPlayOutChat)
    public void onPacketOutChat(SendPacketEvent<PacketChat> event)
    {
        // Get the MineAPI's packet
        PacketChat packet = event.getPacketWrapper().getPacket();
        // Let's get informations!
        String message = packet.getContent();
        byte data = packet.getData();
        // The message is formatted in Json.
        JsonObject json = (JsonObject) parser.parse(message);
        // Let's to modify the packet!
        if (json.get("text").getAsString().equalsIgnoreCase("Notch is beautiful!") && data == 1)
        {
            json.remove("text");
            json.addProperty("text", ChatColor.GREEN + "Notch is beautiful!");
            packet.setContent(json.toString());
            packet.setData((byte) 2);
        }
    }

    @PacketHandler(listenType = PacketList.PacketPlayOutChat)
    public void onPacketInChat(ReceivePacketEvent<PacketPlayInChat> event)
    {
        // Get the MineAPI's packet
        PacketPlayInChat packet = event.getPacketWrapper().getPacket();
        // Let's get informations!
        String message = packet.getMessage();
        // Now we can modify!
        message = message.substring(0, 1).toUpperCase() + message.substring(1);
        if (message.contains("stupid"))
        {
            message = message.replace("stupid", "******");
        }
        packet.setMessage(message);
    }

    @PacketHandler(listenType = PacketList.PacketPlayOutCamera)
    public void onPacketOutCamera(SendPacketEvent<?> event)
    {
        // No, we can't get the MineAPI's packet, because it didn't exists :(
        Object nmsPacket = event.getPacketWrapper().getNmsPacket();
        // Get data with Reflection :D
        int entityId = ReflectionAPI.getIntValue(nmsPacket, ReflectionAPI.getField(nmsPacket.getClass(), "a", true));
        Bukkit.getLogger().info("SERVER: Player '" + event.getPlayer().getName() + "' received packet PacketPlayOutCamera. Data: EntityId = '" + entityId + "'.");
    }
}

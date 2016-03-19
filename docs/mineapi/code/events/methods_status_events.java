/*
 * Gets the PacketWrapper, with we can get the MineAPI packet and modify NMS' packet or get data.
 */
public MC_PacketWrapper<T> getPacketWrapper();

/*
 * Gets the IP of sender or receiver of the packet.
 */
public String getIp();

/*
 * Checks whether cancel send packet.
 */
public boolean isCancelled();

/*
 * Sets whether cancel send packet.
 */
public void setCancelled(boolean cancel);

/*
 * Checks whether force changes on NMS' packet.
 */
public boolean hasForceChanges();

/*
 * Sets whether force changes on NMS' packet.
 * It's have effect only if the event don't have MineAPI's packet.
 */
public void setForceChanges(boolean forceChanges);

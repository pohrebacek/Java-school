package ctvrtak.networking.chatRoom;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class RoomManager {
    public final static RoomManager ROOM_MANAGER = new RoomManager();
    public final static String LOBBY_ROOM_NAME = "lobby";

    private final Room lobby = new Room(LOBBY_ROOM_NAME, true);
    //seznam vsech rooms
    private final ConcurrentMap<String, Room> rooms = new ConcurrentHashMap<>();
    private final ConcurrentMap<ClientHandler, Room> membership = new ConcurrentHashMap<>();

    private RoomManager(){
        rooms.put(LOBBY_ROOM_NAME, lobby);
    }

    public void roomCast(ClientHandler client, String message){
        Room clientRoom = rooms.get(getCurrentRoom(client));
        clientRoom.broadCastChat(client.getClientID(), message);
    }

    public boolean createRoom(String roomName){
        Room r = new Room(roomName, false);
        if (!rooms.containsKey(roomName)){
            rooms.put(roomName, r);
            return true;
        }
        return false;
    }

    private void removeRoom(String name){
        Room toDel = rooms.get(name);
        if (!toDel.isLobby())
            rooms.remove(name);
    }

    public boolean joinRoom(ClientHandler who, String where){
        Room toJoin;
        if ((toJoin = rooms.get(where)) == null) {
            return false;
        }
        //chce jit ze stejne room do stejne
        Room current = membership.get(who);
        if (toJoin == null || toJoin.equals(current))
            return false;

        membership.replace(who, toJoin);
        toJoin.addMember(who);
        current.removeMember(who);

        //mazani current room
        if (current.isEmpty()){
            removeRoom(current.getName());
        }
        return true;
    }

    public String getCurrentRoom(ClientHandler client){
        return membership.get(client).getName();
    }
//
//    public void leaveToLobby(ClientHandler client){
//        joinRoom(client, LOBBY_ROOM_NAME);
//    }

    public void joinLobby(ClientHandler client){
        membership.put(client, lobby);
        lobby.addMember(client);
    }

    public List<String> listRoomNames(){
        return new ArrayList<>(rooms.keySet());
    }

    public List<String> listRoomMembers(ClientHandler client, String roomName) {
        List<String> members = new ArrayList<>();
        Room currentRoom = membership.get(client);
        for (ClientHandler anotherClient : currentRoom.getMembers()) {
            members.add(anotherClient.getClientID());
        }
        return members;
    }
}

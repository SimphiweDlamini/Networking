import java.net.Socket;

public class CPlayer {
    private String  playerID;
    private Socket client;

    public CPlayer(String _playerID,Socket _client){
        playerID=_playerID;
        client=_client;
    }

    public Socket getClient() {
        return client;
    }

    public String getPlayerID(){
        return playerID;
    }
}

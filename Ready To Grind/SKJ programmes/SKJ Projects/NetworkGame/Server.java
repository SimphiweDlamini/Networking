import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class Server {
    public List<CPlayer> active = new ArrayList<>();
    public List<CPlayer> players = new ArrayList<>();

    public void listenSocket() {
        ServerSocket server = null;
        Socket client = null;
        try {
            server = new ServerSocket(55555);
        } catch (IOException e) {
            System.out.println("Could not listen");
            System.exit(-1);
        }
        System.out.println("Server listens on port: " + server.getLocalPort());

        while (true) {
            try {
                client = server.accept();

            } catch (IOException e) {
                System.out.println("Accept failed");
                System.exit(-1);
            }
            (new Player(client)).start();

        }

    }

    public void addaPlayer(CPlayer player){
        active.add(player);
    }

    public int getSizeofaList(){
        return active.size();
    }

    public CPlayer getAPlayer(int i){
       return active.get(i);
    }

    public void addPlayer(CPlayer player){
        players.add(player);
    }

    public int getSizeofList(){
        return players.size();
    }

    public CPlayer getPlayer(int i){
        return players.get(i);
    }

    public static void main(String [] args){
        Server test= new Server();
        test.listenSocket();
    }
}

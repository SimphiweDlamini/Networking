import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player extends Thread{
    private Socket socket;
    private PrintWriter write = null;
    private BufferedReader read = null;
    private int num=2;

    public Player(Socket socket) {
        super();
        this.socket = socket;
    }

    public void run(){
        Scanner scan = new Scanner(System.in);
        int row,column;
        try {
            write = new PrintWriter(socket.getOutputStream(),true);
            write.println("Please send message 'PLAY' when ready to duel,To cut the connection " +
                    "from the server send ' LOGOUT ', to receive information about the players send 'LIST' ");
        }catch(IOException t){
            t.printStackTrace();
        }
        try {
            CPlayer defau = new CPlayer("Player" + num,socket);
            Server f=new Server();
            f.players.add(defau);
            read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = read.readLine();
            if (message.equals("PLAY")) {
                f.active.add(defau);
                if (f.active.size() / 2 == 0) {
                    write.println("Please wait for opponent");
                } else {
                    Game jam = new Game(f.active.get(f.active.size() - 2), f.active.get(f.active.size()-1));
                    do {

                        jam.clear();
                        jam.print();
                        jam.printToPlayer();
                        do {
                            write.println();
                            row = scan.nextInt() - 1;
                            column = scan.nextInt() - 1;
                        } while (!jam.placeMark(row, column));
                        jam.changePlayer();
                    }while (!jam.checkForWin() && !jam.movesMaxed());
                    if(jam.movesMaxed()&& !jam.checkForWin()){
                        write.println("No one wins result : DRAW ");
                    }
                    else{
                        jam.print();
                        jam.printToPlayer();
                        jam.changePlayer();
                        write.println(jam.getCurrentPlayerMark() + " has won the game");
                    }
                }

            }else if (message.equals("LIST")){
                f.active.forEach(e -> write.println(e.getPlayerID()));
            }else if (message.equals("LOGOUT")){
                socket.close();
            }
        }catch (IOException f){
            f.printStackTrace();
        }
        }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client2 {
    public static void main(String []args){
        Socket socket;
        PrintWriter cin = null;
        BufferedReader cout = null;
        String address="192.168.1.45";
        int port = 55555;
        try{
            //address = InetAddress.getLocalHost().toString();
            socket = new Socket(address,port);
            cin = new PrintWriter(socket.getOutputStream(),true);
            cout = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }catch (Exception f){
            f.printStackTrace();
        }
        try {
            System.out.println(cout.readLine());
        }catch(Exception g){
            g.printStackTrace();
        }

        try{
            //THE OPTION WHICH YOU CHOOSE BETWEEN PLAY,LIST AND LOGOUT
            cin.println("PLAY");
        }catch (Exception j){
            j.printStackTrace();
        }

        try{
            System.out.println(cout.readLine());
        }catch (Exception a){
            a.printStackTrace();
        }

        while(true){
            try {
                cout.readLine();
            }catch (IOException h){
                h.printStackTrace();
            }
        }
    }
}

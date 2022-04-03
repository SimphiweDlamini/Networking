import com.sun.jndi.cosnaming.IiopUrl;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Proxy {
    public void listenSocket() {
        ServerSocket server = null;
        Socket client = null;
        try {
            server = new ServerSocket(3020);
        } catch (IOException en) {
            System.out.println("Could not listen");
            System.exit(-1);
        }

        System.out.println("Server listens on port :" + server.getLocalPort());
       while (true) {
            try {
                client = server.accept();
            } catch (IOException es) {
                System.out.println("Accept has failed");
                System.exit(-1);
            }
            (new ProxyThread(client)).run();
       }
    }
    public static void main(String args[]){
        Proxy pro=new Proxy();
        pro.listenSocket();
        }
}

import sun.net.www.http.HttpCaptureInputStream;
import sun.net.www.http.HttpClient;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ProxyThread  extends Thread{
    private Socket socket;
    private Socket ProxyClient;
    private PrintWriter cout=null;
    private BufferedReader cin=null;
    private PrintWriter pout=null;

    private BufferedReader pin=null;
    private  List<String> all= new ArrayList<>();
    private List<String> message = new ArrayList<>();

    protected ProxyThread(Socket socket){
        super();
        this.socket=socket;
    }

    public void run(){
        System.out.println("client connected".toUpperCase());
        try {
            cin =new BufferedReader(new InputStreamReader(socket.getInputStream()));
            cout= new PrintWriter(socket.getOutputStream(),true);
            int count=0;
            while(count <3) {
                all.add(cin.readLine());
                count++;
            }
            all.forEach(e-> System.out.println(e));
            String request=all.get(1);
            if(request.contains("Host:")){
                String address=request.substring(6).trim();
                System.out.println("The address you are trying to connect to: " + address);
                ProxyClient=new Socket(address,80);
                pin = new BufferedReader(new InputStreamReader(ProxyClient.getInputStream()));
                pout= new PrintWriter(ProxyClient.getOutputStream(),true);
                pout.print(all.get(0));
                pout.println(all.get(1));
                pout.println();
                System.out.println("The response to the client :".toUpperCase());
                String fetch;
                while((fetch=pin.readLine())!=null) {
                    message.add(fetch);
                }
                message.forEach(e-> System.out.println(e));
                message.forEach(e->cout.write(e));
            }else{
                System.out.println("non-compatible for the proxy".toUpperCase());
            }
        }catch (IOException es){
            System.out.println("Error reading message");
           // System.exit(-1);
        }catch (NullPointerException s){
            System.out.println("Nothing returned from Server".toUpperCase());
        }
       try{
        socket.close();
          cin.close();
          cout.close();
           System.out.println("Connection closed".toUpperCase());
           System.out.println(" ");
           System.out.println(" ");
        }catch (IOException s){
            System.out.println("Failure closing Client socket and streams");
        }

    }
}

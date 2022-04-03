
import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class MyServer {
    private DatagramSocket server;
    private DatagramSocket arr[];
    private int count = 0;
    private int numports = 5;
    private int servecounter=0;
    private File file1=new File("");
    private File file2=new File("");
    private File file3=new File("");
    private File file4=new File("");
    private File file5=new File("");
    private File file;
    public MyServer() throws SocketException  {
        openSockets(numports);
    }


    public void openSockets(int num)throws SocketException {
        server = new DatagramSocket();
        System.out.println("Opened UDP server " + server.getLocalPort());
        arr= new DatagramSocket[num];

        for (int i=1;i<num;i++){
           arr[i]=new DatagramSocket();
            System.out.println("Created UDP port :"+ arr[i].getLocalPort());
        }
    }
    private void service() throws IOException {
        byte[] buff = new byte[UDPSIZE.MAX_DATAGRAM_SIZE];
        final DatagramPacket datagram = new DatagramPacket(buff, buff.length);
        server.receive(datagram);
        switch (servecounter){
            case 0:
                file= file1;
            case 1:
                file = file2;
            case 2:
                file = file3;
            case 3:
                file = file4;
            case 4:
                file =file5;
        }
        new Thread(() -> {
            int cport=datagram.getPort();
            InetAddress caddress=datagram.getAddress();
            byte[] message = String.valueOf(arr[count]).getBytes();
            System.out.println("Client that connected port: "+cport+" address :"+caddress );
            DatagramPacket intial= new DatagramPacket(message,message.length,caddress,cport);
            try{
                server.send(intial);
                System.out.println("sent port number "+message.toString());
                serve(arr[count]);
                count++;
            }catch (IOException e){
                e.printStackTrace();
            }

        }).start();
        if (count>numports){
            System.out.println("The maximum number of ports has been exceeded");
            System.exit(-1);
        }
    }

    private void serve(DatagramSocket tosend)throws IOException{
        byte[] buff =new byte[UDPSIZE.MAX_DATAGRAM_SIZE];
        final DatagramPacket datagram = new DatagramPacket(buff,buff.length);
        tosend.receive(datagram);

        new Thread(() -> {
            int cport = datagram.getPort();
            InetAddress caddress = datagram.getAddress();
            byte [] message =file.getName().getBytes();
            System.out.println("Sending file name : "+file.getName());
            DatagramPacket namefile=new DatagramPacket(message,message.length,caddress,cport);
            try{
                server.send(namefile);
                System.out.println("Sent name of file");
            }catch (IOException e){
                e.printStackTrace();
            }
            try {
                BufferedReader context = new BufferedReader(new FileReader(file));
                String line;
                while((line=context.readLine())!= null){
                    byte [] part = line.getBytes();
                    namefile = new DatagramPacket(part,part.length,caddress,cport);
                    try{
                        server.send(namefile);
                    }catch (IOException ki){
                        ki.printStackTrace();
                    }
                }
                System.out.println("Sent context of file");
            }catch (Exception er){
                System.out.println("failed reading file");
                er.printStackTrace();
            }
        }).start();
    }

    public void listen() {
        while(true) {
            try {
                service();
                servecounter++;
            } catch (IOException e) {
            }
        }
    }

    public static void main(String[] args) {
        try {
            new MyServer().listen();
    } catch (SocketException e) {
        System.out.println("Could not set up the server");
    }
    }
}

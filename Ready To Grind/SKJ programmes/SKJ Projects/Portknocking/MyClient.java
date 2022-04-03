import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MyClient {
    public static void main(String[]args)throws IOException {
        InetAddress address = InetAddress.getLocalHost();
        int numofexfiles=8;
        // set number of port when the server is run
        int port =;
        byte[] buff =new byte[UDPSIZE.MAX_DATAGRAM_SIZE];
        DatagramPacket datagram = new DatagramPacket(buff,buff.length,address,port);

        DatagramSocket socket = new DatagramSocket();

        DatagramPacket portinfo = new DatagramPacket(buff,buff.length);

        socket.receive(portinfo);

        String gooo = new String(portinfo.getData(), 0, portinfo.getLength()).trim();
        Integer portsequence = Integer.parseInt(gooo);

        DatagramPacket cracked = new DatagramPacket(buff,buff.length,address,portsequence);

        DatagramSocket filecontexts = new DatagramSocket();

        filecontexts.receive(cracked);

        String name= new String(cracked.getData(),0,cracked.getLength()).trim();
        System.out.println("The name of the file is : " + name );

        System.out.println("These are the contexts of your file:");
        //String contexts="--";
        while(numofexfiles>0) {
            filecontexts.receive(cracked);
            String contexts = new String(cracked.getData(), 0, cracked.getLength()).trim();
            System.out.println(contexts);
            numofexfiles--;
        }


    }
}

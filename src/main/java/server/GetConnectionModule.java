package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

public class GetConnectionModule {

    private DatagramSocket socket;

    public GetConnectionModule(DatagramSocket socket){
        this.socket = socket;
    }

    public DatagramPacket connect(){
        byte[] buffer = new byte[2048];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        try {
            socket.receive(packet);
        }
        catch (SocketTimeoutException e){
            //System.out.println("Timeout");
            return null;
        } catch (IOException e) {
            System.out.println("Unable to recieve packet");
            return null;
        }
        System.out.println("Client connected: " + packet.getAddress() + ":" + packet.getPort()); // выводим сообщение о подключении клиента
        if(packet.getAddress() == null){
            return null;
        }
        else return packet;
    }
}

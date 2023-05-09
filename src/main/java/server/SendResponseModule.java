package server;

import model.Response;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class SendResponseModule {

    private final Response response;
    private final DatagramPacket packet;
    private final DatagramSocket socket;
    public SendResponseModule(Response response, DatagramPacket packet, DatagramSocket socket){
        this.response = response;
        this.packet = packet;
        this.socket = socket;
    }
    public void send(){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(baos);
        } catch (IOException e) {
            System.out.println("Unable to prepare byte array");
            return;
        }
        try {
            oos.writeObject(response);
        } catch (IOException e) {
            System.out.println("Unable to write response");
            return;
        }
        byte[] data = baos.toByteArray();
        DatagramPacket responsePacket = new DatagramPacket(data, data.length, packet.getAddress(), packet.getPort());
        try {
            socket.send(responsePacket);
        } catch (IOException e) {
            System.out.println("Unable to send response");
        }
    }
}

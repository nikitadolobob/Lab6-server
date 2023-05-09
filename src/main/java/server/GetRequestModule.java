package server;

import commands.Command;
import model.Movie;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;

public class GetRequestModule {

    private DatagramPacket packet;
    public GetRequestModule(DatagramPacket packet){
        this.packet = packet;
    }

    public Command recieve(){
        ByteArrayInputStream bais = new ByteArrayInputStream(packet.getData());
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(bais);
        } catch (IOException e) {
            System.out.println("Unable to deserialize Command");
            return null;
        }
        Command command = null;
        try {
            command = (Command) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unable to read command");
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("Unable to read class Command");
            return null;
        }
        return command;
    }
}

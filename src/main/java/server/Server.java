package server;

import commands.Command;
import model.Response;
import org.junit.runner.Request;
import server.filler.JSONInput;
import server.filler.JSONOutput;

import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Scanner;
import java.util.zip.ZipEntry;

public class Server {

    private final int port;

    private String filleName;
    private DatagramSocket socket;


    private final GetConnectionModule getConnectionModule;
    private GetRequestModule getRequestModule;

    private ProcessCommandModule processCommandModule;

    private SendResponseModule sendResponseModule;

    public Server(int port, String fillename) throws SocketException {
        this.socket = new DatagramSocket(port);
        this.filleName = fillename;
        this.port = port;
        this.getConnectionModule = new GetConnectionModule(this.socket);
    }

    private void prepareCollection(){

        String DEFAULT_NAME = "Collection.json";

        boolean isValidFile = false;
        String filleName = null;
        if(this.filleName.isEmpty()){
            this.filleName = DEFAULT_NAME;
            filleName = DEFAULT_NAME;
            File f = new File(filleName);
            if(f.exists() && f.length() != 0) isValidFile = true;
            try {
                boolean created = f.createNewFile();
                if(!created && !f.exists()) throw new IOException();
            } catch (IOException e) {
                System.out.println("You gave no file. Unable to create new file");
                System.exit(-1);
            }
        }
        else{
            //CommandSystem.filleName = args[0];
            filleName = this.filleName;
            File f = new File(filleName);
            if(!f.exists()){
                try {
                    boolean created = f.createNewFile();
                    if(!created) throw new IOException();
                } catch (IOException e) {
                    System.out.println("You gave not existing file. Unable to create new file");
                    System.exit(-1);
                }
            }
            else isValidFile = true;
        }
        if(isValidFile){ //этот if нужен, потому что пустой файл не нужно парсить
            //Создание экземпляра класса, который считывает данные с заданного JSON-файла
            JSONInput jsonInput = new JSONInput(this.filleName); //("/home/nikita/IdeaProjects/Lab5/src/main/java/server.sourse/Data.json");
            jsonInput.readJSON();
        }
    }

    private void saveCollection(){
        JSONOutput jsonOutput = new JSONOutput(this.filleName);
        jsonOutput.writeJSON();
    }

    public void start(){
        System.out.println("Server is started on port " + port);
        prepareCollection();
        System.out.print("&~");


        boolean exitServer = false;
        try {
            socket.setSoTimeout(100);
        } catch (SocketException e) {
            System.out.println("Unable to make server non-blocking");
        }
        Scanner scanner = new Scanner(System.in);
        while (!exitServer){
            // Проверяем, есть ли данные для чтения из консоли
            try {
                if (System.in.available() > 0) {
                    String input = scanner.nextLine();
                    if (input.trim().equals("exit")) {
                        System.out.println("server is dead");
                        exitServer = true;
                        continue;
                    }
                    else if(input.trim().equals("save")){
                        System.out.println("Collection is saved");
                        saveCollection();
                    }
                    System.out.print("&~");
                }
            } catch (IOException e) {
                System.out.println("Error! Can not stop server!");
            }
            DatagramPacket packet = getConnectionModule.connect();
            if(packet != null) {
                this.getRequestModule = new GetRequestModule(packet);
                Command command = getRequestModule.recieve();
                this.processCommandModule = new ProcessCommandModule(command);
                Response response = processCommandModule.process();
                this.sendResponseModule = new SendResponseModule(response, packet, socket);
                sendResponseModule.send();

            }
        }
    }

}

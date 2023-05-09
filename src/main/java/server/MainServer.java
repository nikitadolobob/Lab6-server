package server;

import server.filler.JSONInput;

import java.io.File;
import java.io.IOException;
import java.net.SocketException;
import java.sql.Struct;

public class MainServer {

    public static void printMessage(String s){
        System.out.println(s);
    }
    public static void main(String[] args) {

        String filleName = null;
        if(args.length == 0){
            filleName = "";
        }
        else filleName = args[0];

        //создаем сервер
        Server server = null;
        try {
            server = new Server(1234, filleName);
        } catch (SocketException e) {
            System.out.println("Ошибка! Невозможно получить доступ к сокету!");
            System.exit(-1);
        }
        server.start();
    }
}

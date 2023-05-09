package server;

import commands.Command;
import model.Movie;
import model.Response;

import java.util.ArrayList;

public class ProcessCommandModule {
    public static ArrayList<Movie> arrayList = new ArrayList<>();
    private final Command command;

    public ProcessCommandModule(Command command){
        this.command = command;
    }

    public Response process(){
        command.setCollection(arrayList);
        String result = command.runCommand();
        //System.out.println(result);
        return new Response(result);
    }
}

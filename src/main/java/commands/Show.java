package commands;

import model.Movie;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Элемент Pattern Command, описывающий конкретную команду show.
 */
public class Show implements Command {

    private ArrayList<Movie> collection;

    public void setCollection(ArrayList<Movie> collection){
        this.collection = collection;
    }
    /**
     * Реализация команды, выводящей на консоль все фильмы коллекции
     */
    private String show(){
        if(collection.isEmpty()){
            return "Collection is empty, so there is nothing to show.";
        }
        return collection.stream()
                        .map(movie -> movie.toString() + "\n---------------------------------\n")
                        .collect(Collectors.joining()) +
                "Command SHOW successfully finished\n";
    }

    /**
     * переопределённый метод, запускающий команду show
     */
    @Override
    public String runCommand() {
        return this.show();
    }

    /**
     * Конструктор экземпляра show.
     *
     */
    public Show (){

    }
}

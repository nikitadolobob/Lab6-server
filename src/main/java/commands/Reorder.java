package commands;

import model.Movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.IntStream;

/**
 * Элемент Pattern Command, описывающий конкретную команду reorder.
 */
public class Reorder implements Command {

    private ArrayList<Movie> collection;

    public void setCollection(ArrayList<Movie> collection){
        this.collection = collection;
    }
    /**
     * Реализация команды, переставляющей элементы коллекции в обратном порядке
     */
    private String reorder(){
        Collections.reverse(collection);
        //java Stream API
        IntStream.range(0, collection.size())
                .forEach(i -> collection.get(i).setId(i + 1));
        return "The movies in the collection reversed their order\n";
    }

    /**
     * переопределённый метод, запускающий команду reorder
     */
    @Override
    public String runCommand() {
        return this.reorder();
    }

    /**
     * Конструктор экземпляра reorder.
     *
     */
    public Reorder (){

    }
}

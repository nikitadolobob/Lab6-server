package commands;

import model.Movie;

import java.util.ArrayList;

/**
 * Элемент Pattern Command, описывающий конкретную команду Clear.
 */
public class Clear implements Command {

    private ArrayList<Movie> collection;

    public void setCollection(ArrayList<Movie> collection){
        this.collection = collection;
    }


    /**
     * Реализация команды, очищающей коллекцию (в результате коллекция, с которой мы работаем, становится пустой)
     */
    private String clear(){
        collection.clear();
        return "The collection is empty now";
    }

    /**
     * переопределённый метод, запускающий команду clear
     */
    @Override
    public String runCommand() {
        return this.clear();
    }

    /**
     * Конструктор экземпляра clear.
     *
     */
    public Clear(){
    }
}

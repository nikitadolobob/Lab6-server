package commands;

import model.Movie;

import java.util.ArrayList;

/**
 * Элемент Pattern Command, описывающий конкретную команду info.
 */
public class Info implements Command {

    private ArrayList<Movie> collection;

    public void setCollection(ArrayList<Movie> collection){
        this.collection = collection;
    }
    /**
     * Реализация команды, выводящей на консоль информацию о коллекции(её размер и класс)
     */
    private String info(){
        return "Information about collection:" + "\n" +
                "Collection size: " + collection.size() + "\n" +
                "Collection type: " + collection.getClass() + "\n";
    }

    /**
     * переопределённый метод, запускающий команду info
     */
    @Override
    public String runCommand() {
        return this.info();
    }

    /**
     * Конструктор экземпляра info.
     *
     */
    public Info (){

    }
}

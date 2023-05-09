package commands;

import model.Movie;

import java.util.ArrayList;

/**
 * Элемент Pattern Command, описывающий конкретную команду removeLast.
 */
public class RemoveLast implements Command {

    private ArrayList<Movie> collection;

    public void setCollection(ArrayList<Movie> collection){
        this.collection = collection;
    }

    /**
     * Реализация команды, удаляющей фильм из конца коллекции, если она не пуста
     */
    private String removeLast(){
        if(collection.isEmpty()){
            return "Can not remove last because collection is empty. Enter your next command\n";
        }
        collection.remove(collection.size() - 1);
        return "The last movie of the collection is successfully removed from it\n";
    }


    /**
     * переопределённый метод, запускающий команду removeLast
     */
    @Override
    public String runCommand() {
        return this.removeLast();
    }

    /**
     * Конструктор экземпляра removeLast.
     *
     */
    public RemoveLast (){

    }
}

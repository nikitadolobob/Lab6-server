package commands;

import model.Movie;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Элемент Pattern Command имплементируемый всеми командами приложения
 */
public interface Command extends Serializable {

    void setCollection(ArrayList<Movie> collection);
    /**
     * метод, переопределяемый и реализуемый по своему для каждой конкретной команды
     */
    String runCommand();
}

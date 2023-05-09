package commands;

import model.Movie;

import java.io.File;
import java.util.ArrayList;

/**
 * Элемент Pattern Command, описывающий конкретную команду executeScript.
 */
public class ExecuteScript implements Command {

    /**
     * Реализация команды, выполняющей команды из файла, заданного пользователем
     *
     * @param filleName имя файла заданного пользователем
     */
    private String executeScript(String filleName){
        return filleName;
    }
    private final String filleName;

    @Override
    public void setCollection(ArrayList<Movie> collection) {

    }

    /**
     * переопределённый метод, запускающий команду executeScript
     */
    @Override
    public String runCommand() {
        return this.executeScript(filleName);
    }

    /**
     * Конструктор экземпляра executeScript.
     *
     * @param filleName имя вводимого пользователем файла, с которым будет работать экземпляр команды
     */
    public ExecuteScript (String filleName){
        this.filleName = filleName;
    }
}

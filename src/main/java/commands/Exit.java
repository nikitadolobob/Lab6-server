package commands;

import model.Movie;

import java.util.ArrayList;

/**
 * Элемент Pattern Command, описывающий конкретную команду exit.
 */
public class Exit implements Command {

    /**
     * Реализация команды, завершающей работу приложения без сохранения изменений в файл, за исключением тех, что уже были отдельно сохранены командой save
     */
    private String exit(){
        return "Exit program";
    }

    @Override
    public void setCollection(ArrayList<Movie> collection) {

    }

    /**
     * переопределённый метод, запускающий команду exit
     */
    @Override
    public String runCommand() {
        return this.exit();
    }

    /**
     * Конструктор экземпляра exit.
     *
     */
    public Exit (){

    }
}

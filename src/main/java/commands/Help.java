package commands;

import model.Movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Элемент Pattern Command, описывающий конкретную команду help.
 */
public class Help implements Command {

    /**
     * Реализация команды, выводящей на консоль информацию о каждой команде приложения
     */

    private String help(){
        //java stream api
        return Arrays.stream(Commands.values())
                .map(command -> command.commandName + ": " + command.description + "\n")
                .collect(Collectors.joining());
    }

    @Override
    public void setCollection(ArrayList<Movie> collection) {

    }

    /**
     * переопределённый метод, запускающий команду help
     */
    @Override
    public String runCommand() {
        return this.help();
    }

    /**
     * Конструктор экземпляра help.
     *
     */
    public Help (){

    }
}

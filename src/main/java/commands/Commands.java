package commands;

import model.Movie;

/**
 * Енам всех команд приложения имеет две цели:
 * 1) при вводе пользователем команды довольно просто, без условия под каждую команду, можно установить команду и выполнить её
 * 2) при выполнении команды help при помощи введённых через конструктор имени и описания команды, проще оперировать с выводимыми данными
 */
public enum Commands {
    /**
     * Команда, выводящая в консоль информацию обо всех командах приложения
     */
    HELP("help", "describes all commands"){
    },
    /**
     * Команда, выводящая в консоль информацию о коллекции
     */
    INFO("info", "gives data on collections"){

    },
    /**
     * Команда, выводящая в консоль все элементы коллекции
     */
    SHOW("show", "demonstrates all collection elements"){
    },
    /**
     * Команда, добавляющая в конец коллекции введённый пользователем фильм
     */
    ADD("add", "adds ellement to collection"){
    },
    /**
     * Команда, вносящая заданные пользователем изменения в элемент коллекции с заданным id
     */
    UPDATE("update", "changes element with given id"){
    },
    /**
     * Команда, удаляющая из коллекции элемент с заданным id
     */
    REMOVE_BY_ID("remove_by_id", "removes element with given id"){
    },
    /**
     * Команда, очищающая коллекцию
     */
    CLEAR("clear", "makes the collection empty"){
    },
    /**
     * Команда, выполняющая команды из заданного пользователем файла
     */
    EXECUTE_SCRIPT("execute_script", "executes your script from a given fille"){
    },
    /**
     * Команда, завершающая работу приложения
     */
    EXIT("exit", "finishes the programm without saving collection to the fille"){
    },
    /**
     * Команда, удаляющая последний элемент коллекции, при его наличии
     */
    REMOVE_LAST("remove_last", "removes the last element of collection"){
    },
    /**
     * Команда добавляющая элемент в коллекцию, если он меньше минимального элемента коллекции
     */
    ADD_IF_MIN("add_if_min", "adds an element to collection if it is less than current collection minimum"){
    },
    /**
     * Команда, переставляющая элементы коллекции в обратном порядке
     */
    REORDER("reorder", "reverses the order of the collection"){
    },
    /**
     * Команда, выводящая в консоль количество фильмов, жанр которых, в соответствие с полем genreRating меньше заданного
     */
    COUNT_LES_THAN_GENRE("count_les_than_genre", "tells the ammount of elements whiches genre is lesser than given"){
    },
    /**
     * Команда, выводящая в консоль количество фильмов, жанр которых, в соответствие с полем genreRating больше заданного
     */
    COUNT_GREATER_THAN_GENRE("count_greater_than_genre", "tells the amount of elements with gener greater than given"){
    },
    /**
     * Команда, выводящая в консоль фильмы, жанр которых, в соответствие с полем genreRating больше заданного.
     */
    FILTER_GREATER_THAN_GENRE("filter_greater_than_genre", "outputs the elements with gener greater than given"){

    };

    /**
     * Конструктор енама
     * @param commandName имя команды
     * @param description словесное описание команды
     */
    Commands(String commandName, String description) {
        this.commandName = commandName;
        this.description = description;
    }

    /**
     * Переопределяемый командами, на вход которым не подаются данные, метод, реализующий исполнение команд
     *
     * @return
     */

    /**
     * Поле имя команды, используемая в каждой константе енама при помощи конструктора
     */
    final public String commandName;
    /**
     * Поле описание команды, используемое в каждой константе енами при помощи конструктора
     */
    final public String description;

    /**
     * метод возвращающий поле имя команды
     *
     * @return строковое значение - имя команды
     */
    public String getCommandName(){
        return this.commandName;
    }
}

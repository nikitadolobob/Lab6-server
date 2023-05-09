package server.filler;

import model.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import server.ProcessCommandModule;

import java.io.FileReader;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Iterator;

/**
 * Класс для считывания данных из JSON файла и их помещения в коллекцию, с которой работает приложение.
 */
public class JSONInput {

    /**
     * Имя считываемого файла
     */
    public String filleName;

    /**
     * Конструктор для экземляра класса, чтобы считывать с конкретного файла
     *
     * @param filleName - имя файла, с которым будет работать экземпляр класса
     */
    public JSONInput(String filleName){
        this.filleName = filleName;
    }


    /**
     * Метод для обработки конкретного фильма и перевода его из JSON файла в коллекцию в качестве эллемента типа Class Movie
     *
     * @param jsonObject - поступающий методу на вход фильм в формате JSON
     */
    public void readMovie(JSONObject jsonObject){
        try{
            Movie movie = new Movie();
            Coordinates coordinates = new Coordinates();
            Person person = new Person();
            Location location = new Location();

            if(!jsonObject.containsKey("coordinates")) return;
            JSONObject cord = (JSONObject) jsonObject.get("coordinates");

            if(!cord.containsKey("x")) return;
            coordinates.setX(Integer.parseInt((String) cord.get("x")));
            if(!cord.containsKey("y")) return;
            coordinates.setY(Float.parseFloat((String) cord.get("y")));
            if(coordinates.getY() > 208) return;

            if(!jsonObject.containsKey("director")) return;
            JSONObject direct = (JSONObject) jsonObject.get("director");

            if(!direct.containsKey("name")) return;
            person.setName((String) direct.get("name"));
            if(person.getName().trim().equals("")) return;

            if(!direct.containsKey("location")) return;
            JSONObject loc = (JSONObject) direct.get("location");

            if(!loc.containsKey("x")) return;
            location.setX(Double.parseDouble((String) loc.get("x")));
            if(!loc.containsKey("y")) return;
            location.setY(Integer.parseInt((String) loc.get("y")));

            location.setZ(Float.parseFloat((String) loc.get("z")));

            if(direct.containsKey("weight")) {
                person.setWeight(Float.parseFloat((String) direct.get("weight")));
                if(person.getWeight() <= 0) return;
            }


            boolean isEyeColorCorrect = false;
            if(direct.containsKey("eyeColor")) {
                String eyeColor = (String) direct.get("eyeColor");
                for (model.colorEyes.Color color : model.colorEyes.Color.values()) {
                    if (color.name().equals(eyeColor)) {
                        person.setEyeColor(color);
                        isEyeColorCorrect = true;
                    }
                }
            }
            if(!isEyeColorCorrect && direct.containsKey("eyeColor")) return;

            if(!direct.containsKey("hairColor")) return;
            boolean isHairColorCorrect = false;
            String hairColor = (String) direct.get("hairColor");
            for(model.colorHair.Color color : model.colorHair.Color.values()){
                if(color.name().equals(hairColor)){
                    person.setHairColor(color);
                    isHairColorCorrect = true;
                }
            }
            if(!isHairColorCorrect) return;



            if(!direct.containsKey("nationality")) return;
            boolean isCorrectNationality = false;
            String country = (String) direct.get("nationality");
            for(Country eCountry : Country.values()){
                if(eCountry.name().equals(country)){
                    person.setNationality(eCountry);
                    isCorrectNationality = true;
                }
            }
            if(!isCorrectNationality) return;

            person.setLocation(location);

            if(!jsonObject.containsKey("id")) return;
            movie.setId(Integer.parseInt((String) jsonObject.get("id")));
            if(movie.getId() <= 0) return;

            if(!jsonObject.containsKey("name")) return;
            movie.setName((String)jsonObject.get("name"));
            if(movie.getName().trim().equals("")) return;

            movie.setCoordinates(coordinates);


            if(!jsonObject.containsKey("creationDate")) return;
            DateTimeFormatter formatter = DateTimeFormatter.ISO_ZONED_DATE_TIME;
            movie.setCreationDate(ZonedDateTime.parse((String) jsonObject.get("creationDate"), formatter));


            movie.setOscarsCount(Integer.parseInt((String) jsonObject.get("oscarsCount")));

            if(!jsonObject.containsKey("genre")) return;
            boolean isCorrectGenre = false;
            String genre = (String) jsonObject.get("genre");
            for(MovieGenre eGenre : MovieGenre.values()){
                if(eGenre.name().equals(genre)){
                    movie.setGenre(eGenre);
                    isCorrectGenre = true;
                }
            }
            if(!isCorrectGenre) return;

            boolean isCorrectRating = false;
            if(jsonObject.containsKey("mpaRating")){
                String mpaaRating = (String) jsonObject.get("mpaaRating");
                for(MpaaRating rating : MpaaRating.values()){
                    if(rating.name().equals(mpaaRating)){
                        movie.setMpaaRating(rating);
                        isCorrectRating = true;
                    }
                }
            }
            if(!isCorrectRating && jsonObject.containsKey("mpaRating")) return;

            movie.setDirector(person);

            //переопределяем id как порядковый номер
            movie.setId(ProcessCommandModule.arrayList.size() + 1);
            ProcessCommandModule.arrayList.add(movie);


        }catch (NullPointerException e){
            System.out.println("Can not read movies from JSON. Some of required fields are missing");
            System.exit(-1);
        }catch (NumberFormatException | DateTimeParseException e) {
            return;
        }
    }


    /**
     * Метод, переводящий содержимое JSON файла в эллементы коллекции
     */
    public void readJSON()  {
        Object obj = null;
        try {
            obj = new JSONParser().parse(new FileReader(filleName));
        } catch (IOException e) {
            System.out.println("Error during file reading. For correct work file must contain root element containing Movies array");
            System.exit(-1);
        } catch (ParseException e) {
            System.out.println("Unable to parse file. For correct work file must contain root element containing Movies array");
            System.exit(-1);
        }
        JSONObject jo = (JSONObject) obj;
        JSONArray moviesArr = (JSONArray) jo.get("Movies");
        if(moviesArr == null){
            System.out.println("No Movies array in file. For correct work file must contain root element containing Movies array");
            System.exit(-1);
        }
        Iterator moviesItr = moviesArr.iterator();

        while (moviesItr.hasNext()) {
            JSONObject test = (JSONObject) moviesItr.next();
            readMovie(test);
        }
    }
}

package model;

import java.io.Serializable;

public class Response implements Serializable {
    public String data;
    public Response(String data){
        this.data = data;
    }
}

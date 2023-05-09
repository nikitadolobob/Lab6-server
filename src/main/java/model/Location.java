package model;

import java.io.Serializable;

public class Location implements Serializable {
    private Double x; //Поле не может быть null
    private Integer y; //Поле не может быть null
    private Float z;

    public Location(Double x, Integer y, Float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Location(){}

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Float getZ() {
        return z;
    }

    public void setZ(Float z) {
        this.z = z;
    }
}

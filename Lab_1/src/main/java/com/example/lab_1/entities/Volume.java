package com.example.lab_1.entities;

import lombok.Getter;
import lombok.Setter;

public class Volume {
    @Getter
    @Setter
    private double volume;

    public Volume(double volume) {
        this.volume = volume;
    }

/*    public double getV() {
        return volume;
    }
2
    public void setV(double volume) {
        this.volume = volume;
    }*/
}

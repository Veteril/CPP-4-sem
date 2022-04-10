package com.example.lab_1.result;

import org.jetbrains.annotations.NotNull;
import org.springframework.lang.Nullable;
import java.util.Objects;

public class Input {

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        if (obj == null || obj.getClass() != this.getClass())
            return false;

        Input params = (Input) obj;

        return  Objects.equals(firstValue,  params.firstValue)  &&
                Objects.equals(secondValue, params.secondValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstValue, secondValue);
    }

    private @Nullable Integer firstValue;

    private @Nullable Integer secondValue;


    private @Nullable Double height;

    private @Nullable Double radius;

    public Input(
            @Nullable Double height,
            @Nullable Double radius
    ) {
        if (height == null && radius == null)
            throw new IllegalArgumentException("No first and second values!");

        if (height == null)
            throw new IllegalArgumentException("No first value!");

        if (radius == null)
            throw new IllegalArgumentException("No second value!");

        this.height = height;
        this.radius = radius;
    }

    @NotNull
    public Double getHeight() {
        assert height != null;
        return height;
    }

    @NotNull
    public Double getRadius() {
        assert radius != null;
        return radius;
    }

    public void setHeight(@Nullable Double height) {
        this.height = height;
    }
    public void setRadius(@Nullable Double radius) {
        this.radius = radius;
    }

}
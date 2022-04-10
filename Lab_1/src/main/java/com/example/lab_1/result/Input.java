package com.example.lab_1.result;

import org.jetbrains.annotations.NotNull;
import org.springframework.lang.Nullable;
import java.util.Objects;

public class Input {

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
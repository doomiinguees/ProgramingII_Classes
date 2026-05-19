package pt.ipleiria.estg.schedules.Model;

import androidx.annotation.NonNull;

public abstract class Describer {

    private String name;

    public Describer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @NonNull
    @Override
    public String toString() {
        return getName();
    }
}

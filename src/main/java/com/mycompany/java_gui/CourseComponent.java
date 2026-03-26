package com.mycompany.java_gui;
import java.io.Serializable;

public class CourseComponent implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private double weight;

    public CourseComponent(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() { return name; }
    public double getWeight() { return weight; }

    @Override
    public String toString() {
        return name + " (" + weight + "%)";
    }
}

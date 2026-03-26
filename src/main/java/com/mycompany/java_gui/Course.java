package com.mycompany.java_gui;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    private String courseCode;
    private String courseTitle;
    private int creditHours;
    private List<CourseComponent> components = new ArrayList<>();

    public Course(String courseCode, String courseTitle, int creditHours) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.creditHours = creditHours;
    }

    public String getCourseCode() { return courseCode; }
    public String getCourseTitle() { return courseTitle; }
    public int getCreditHours() { return creditHours; }


    public List<CourseComponent> getComponents() {
        return components;
    }

    public boolean addComponent(CourseComponent comp) {
        if (comp == null) return false;
        return components.add(comp);
    }

    @Override
    public String toString() {
        return courseCode + " - " + courseTitle + " (" + creditHours + "cr)";
    }
}

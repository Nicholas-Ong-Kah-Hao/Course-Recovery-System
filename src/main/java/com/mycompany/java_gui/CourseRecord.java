package com.mycompany.java_gui;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CourseRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    private String recordId;
    private Course course;
    private Map<String, Double> componentMarks = new HashMap<>();
    private Double finalPercent = null;
    private Grade finalGrade = null;

    public CourseRecord(String recordId, Course course) {
        this.recordId = recordId;
        this.course = course;
    }

    public String getRecordId() { return recordId; }
    public Course getCourse() { return course; }
    public Map<String, Double> getComponentMarks() { return componentMarks; }
    public Double getFinalPercent() { return finalPercent; }
    public Grade getFinalGrade() { return finalGrade; }

    public boolean setComponentMark(String componentName, double percent) {
        componentMarks.put(componentName, percent);
        finalPercent = null;
        finalGrade = null;
        return true;
    }

    public void computeFinalResult() {
        double sum = 0.0;
        for (CourseComponent comp : course.getComponents()) {
            double weight = comp.getWeight();
            Double mark = componentMarks.get(comp.getName());
            if (mark == null) mark = 0.0;
            sum += (mark * weight / 100.0);
        }
        this.finalPercent = sum;
        this.finalGrade = Grade.fromNumeric(sum);
    }

    public boolean isFailed() {
        if (finalGrade == null) {
            computeFinalResult();
        }
        return finalGrade != null && finalGrade.isFail();
    }

    @Override
    public String toString() {
        return course.getCourseCode() + " : " + (finalGrade != null ? finalGrade.toString() : "N/A");
    }
}

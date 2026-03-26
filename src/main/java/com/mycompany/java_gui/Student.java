package com.mycompany.java_gui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person implements Serializable {
    private static final long serialVersionUID = 1L;

    private String studentId;
    private String program;
    private List<CourseRecord> courseRecords = new ArrayList<>();
    private boolean eligible = false;
    private RegisterStatus registerStatus = RegisterStatus.NOT_ALLOWED;

    private static final double MIN_CGPA = 2.0;
    private static final int MAX_FAILED_COURSES = 3;

    public Student(String fullName, String email, String studentId, String program) {
        super(fullName, email);
        this.studentId = studentId;
        this.program = program;
    }

    public String getStudentId() { return studentId; }
    public String getProgram() { return program; }
    public List<CourseRecord> getCourseRecords() { return courseRecords; }
    public boolean isEligible() { return eligible; }
    public RegisterStatus getRegisterStatus() { return registerStatus; }

    public void setProgram(String program) { this.program = program; }
    public void setEligible(boolean eligible) { this.eligible = eligible; }
    public void setRegisterStatus(RegisterStatus registerStatus) { this.registerStatus = registerStatus; }

    public void addCourseRecord(CourseRecord rec) {
        if (rec != null) {
            courseRecords.add(rec);
        }
    }

    public double computeCgpa() {
        double totalGradePoints = 0.0;
        int totalCreditHours = 0;

        for (CourseRecord rec : courseRecords) {
            if (rec == null) continue;

            if (rec.getFinalGrade() == null) {
                try {
                    rec.computeFinalResult();
                } catch (Exception ex) {
                    continue;
                }
            }

            Grade g = rec.getFinalGrade();
            if (g == null) continue;

            Course c = rec.getCourse();
            if (c == null) continue;

            int ch = c.getCreditHours();
            if (ch <= 0) continue;

            totalGradePoints += g.getGradePoint() * ch;
            totalCreditHours += ch;
        }

        return totalCreditHours > 0 ? totalGradePoints / totalCreditHours : 0.0;
    }

    public int countFailedCourses() {
        int failed = 0;

        for (CourseRecord rec : courseRecords) {
            if (rec == null) continue;

            if (rec.getFinalGrade() == null) {
                try {
                    rec.computeFinalResult();
                } catch (Exception ex) {
                    continue;
                }
            }

            Grade g = rec.getFinalGrade();
            if (g == null) continue;

            if (g.isFail()) failed++;
        }

        return failed;
    }

    public boolean computeEligibility() {
        double cgpa = computeCgpa();
        int failed = countFailedCourses();
        boolean elig = (cgpa >= MIN_CGPA) && (failed <= MAX_FAILED_COURSES);
        this.eligible = elig;
        return elig;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", program='" + program + '\'' +
                ", registerStatus=" + registerStatus +
                '}';
    }
}

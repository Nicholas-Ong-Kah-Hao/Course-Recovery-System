package com.mycompany.java_gui;
import java.util.ArrayList;
import java.util.List;

public class DUMMYDATA {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Registrar", "reg@gmail.com", "user1", "123", Role.USER_MANAGEMENT));
        users.add(new User("Recovery", "recover@gmail.com", "user2", "123", Role.COURSE_RECOVERY));
        users.add(new User("Eligibility", "admin@gmail.com", "user3", "123", Role.ELIGIBILITY_OFFICER));
        users.add(new User("Academic", "academic@gmail.com", "user4", "123", Role.ACADEMIC_PERFORMANCE));
        users.add(new User("Email", "email@gmail.com", "user5", "123", Role.EMAIL));

        boolean okUsers = FileHandler.saveToFile("users.dat", users);
        if (!okUsers) {
            System.err.println("Failed to save users.dat");
        }

        Course c1 = new Course("CS101", "Intro to CS", 3);
        c1.addComponent(new CourseComponent("Exam", 70));
        c1.addComponent(new CourseComponent("Assignment", 30));

        Course c2 = new Course("MA101", "Calculus", 4);
        c2.addComponent(new CourseComponent("Exam", 60));
        c2.addComponent(new CourseComponent("Quiz", 40));

        Student s1 = new Student("Alice Smith", "alice@gmail.com", "S0001", "CS");
        CourseRecord r1 = new CourseRecord("R1", c1);
        r1.setComponentMark("Exam", 80);
        r1.setComponentMark("Assignment", 90);
        r1.computeFinalResult();
        s1.addCourseRecord(r1);

        CourseRecord r2 = new CourseRecord("R2", c2);
        r2.setComponentMark("Exam", 45);
        r2.setComponentMark("Quiz", 50);
        r2.computeFinalResult();
        s1.addCourseRecord(r2);


        Student s2 = new Student("Bob billy", "bob@gmail.com", "S0002", "CS");
        CourseRecord r3 = new CourseRecord("R3", c1);
        r3.setComponentMark("Exam", 30);
        r3.setComponentMark("Assignment", 20);
        r3.computeFinalResult();
        s2.addCourseRecord(r3);

        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);

        boolean okStudents = FileHandler.saveToFile("students.dat", students);
        if (!okStudents) {
            System.err.println("Failed to save students.dat");
        } else {
            System.out.println("Dummy data written to data/users.dat and data/students.dat");
        }
    }
}

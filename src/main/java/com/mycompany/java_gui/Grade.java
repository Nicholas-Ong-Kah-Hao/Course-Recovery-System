package com.mycompany.java_gui;
import java.io.Serializable;

public enum Grade implements Serializable {
    A(4.0),
    A_MINUS(3.7),
    B_PLUS(3.3),
    B(3.0),
    C_PLUS(2.3),
    C(2.0),
    D(1.0),
    F(0.0);

    private final double gradePoint;
    Grade(double gp) { this.gradePoint = gp; }
    public double getGradePoint() { return gradePoint; }
    public boolean isFail() { return this == F; }

    public static Grade fromNumeric(double percent) {
        if (percent >= 85) return A;
        if (percent >= 80) return A_MINUS;
        if (percent >= 75) return B_PLUS;
        if (percent >= 70) return B;
        if (percent >= 60) return C_PLUS;
        if (percent >= 50) return C;
        if (percent >= 40) return D;
        return F;
    }

    @Override
    public String toString() {
        switch (this) {
            case A_MINUS: return "A-";
            case B_PLUS: return "B+";
            case C_PLUS: return "C+";
            default: return name();
        }
    }
}

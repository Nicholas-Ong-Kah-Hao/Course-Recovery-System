package com.mycompany.java_gui;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class EligibilityModule extends javax.swing.JFrame {
    public EligibilityModule() {
        initComponents();
        jTable1.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] { "Student ID", "Name", "CGPA", "Failed Courses", "Eligible", "Registered" }
        ));
        displayStudents(loadStudents());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnviewallstudents = new javax.swing.JButton();
        btnviewnoteligible = new javax.swing.JButton();
        Search = new javax.swing.JButton();
        btnautomaticchange = new javax.swing.JButton();
        btnlogout = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnviewallstudents.setText("View All Students");
        btnviewallstudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnviewallstudentsActionPerformed(evt);
            }
        });

        btnviewnoteligible.setText("View Not Eligible");
        btnviewnoteligible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnviewnoteligibleActionPerformed(evt);
            }
        });

        Search.setText("Search");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        btnautomaticchange.setText("Automatic Change");
        btnautomaticchange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnautomaticchangeActionPerformed(evt);
            }
        });

        btnlogout.setText("Log Out");
        btnlogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlogoutActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnautomaticchange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnviewnoteligible, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnviewallstudents, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnlogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnviewallstudents)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnviewnoteligible)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Search)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnautomaticchange)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnlogout)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void displayStudents(List<Student> students) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        for (Student s : students) {
            try {
                s.computeEligibility();

                String sid = (s.getStudentId() == null) ? "" : s.getStudentId();
                String name = (s.getFullName() == null) ? "" : s.getFullName();
                String regStatus = (s.getRegisterStatus() == null)
                        ? "Not Allowed"
                        : (s.getRegisterStatus() == RegisterStatus.ALLOWED ? "Allowed" : "Not Allowed");

                double cgpa = s.computeCgpa();
                if (Double.isNaN(cgpa)) cgpa = 0.0;

                int failed = s.countFailedCourses();

                model.addRow(new Object[]{
                        sid,
                        name,
                        String.format("%.2f", cgpa),
                        failed,
                        s.isEligible() ? "Yes" : "No",
                        regStatus
                });

            } catch (Exception ex) {
                System.err.println("Error loading student: " + s.getStudentId());
            }
        }
    }
    private List<Student> loadStudents() {
        List<Student> students = FileHandler.loadFromFile("students.dat", List.class);
        return (students != null) ? students : new ArrayList<>();
    }

    
    private boolean saveStudents(List<Student> students) {
        return FileHandler.saveToFile("students.dat", students);
    }
    private void btnautomaticchangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnautomaticchangeActionPerformed
        List<Student> students = loadStudents();
        if (students.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No students loaded.");
            return;
        }

        for (Student s : students) {
            try{
                boolean eligible = s.computeEligibility();
                s.setRegisterStatus(eligible ? RegisterStatus.ALLOWED : RegisterStatus.NOT_ALLOWED);
            }catch (Exception ex){
                continue;
            }
        }

        if (saveStudents(students)) {
            JOptionPane.showMessageDialog(this, "Automatic update completed.");
        }
        displayStudents(students);
    }//GEN-LAST:event_btnautomaticchangeActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        String search = JOptionPane.showInputDialog(this, "Enter search keyword (Name or Student ID):");
        List<Student> students = loadStudents();
        if (search == null || search.trim().isEmpty()) {
            displayStudents(students);
            return;
        }
        String key = search.trim().toLowerCase();
        List<Student> filtered = new ArrayList<>();
        for (Student s : students) {
            String sid = s.getStudentId();
            String name = s.getFullName();
            if ((sid != null && sid.toLowerCase().contains(key)) || (name != null && name.toLowerCase().contains(key))) {
                filtered.add(s);
            }
        }
        displayStudents(filtered);
    }//GEN-LAST:event_SearchActionPerformed

    private void btnviewnoteligibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnviewnoteligibleActionPerformed
        List<Student> students = loadStudents();
        List<Student> notEligible = new ArrayList<>();
        for (Student s : students) {
            if (!s.computeEligibility()) notEligible.add(s);
        }
        displayStudents(notEligible);
    }//GEN-LAST:event_btnviewnoteligibleActionPerformed

    private void btnviewallstudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnviewallstudentsActionPerformed
        List<Student> students = loadStudents();
        displayStudents(students);
    }//GEN-LAST:event_btnviewallstudentsActionPerformed

    private void btnlogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlogoutActionPerformed
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_btnlogoutActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new EligibilityModule().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Search;
    private javax.swing.JButton btnautomaticchange;
    private javax.swing.JButton btnlogout;
    private javax.swing.JButton btnviewallstudents;
    private javax.swing.JButton btnviewnoteligible;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

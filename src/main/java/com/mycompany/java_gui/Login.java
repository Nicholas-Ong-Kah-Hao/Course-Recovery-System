package com.mycompany.java_gui;
import javax.swing.*;
import java.util.List;

public class Login extends javax.swing.JFrame {     
    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblusername = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        lblpassword = new javax.swing.JLabel();
        btnlogin = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();
        pwdpassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblusername.setText("Username");

        lblpassword.setText("Password");

        btnlogin.setText("Login");
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });

        btnexit.setText("Exit");
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtusername)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnexit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 236, Short.MAX_VALUE)
                        .addComponent(btnlogin))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblusername)
                            .addComponent(lblpassword))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pwdpassword))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblusername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblpassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pwdpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnlogin)
                    .addComponent(btnexit))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
        String username = txtusername.getText().trim();
        String password = new String(pwdpassword.getPassword()).trim();

        List<User> users = (List<User>) FileHandler.loadFromFile("users.dat", List.class);

        if (users == null) {
            JOptionPane.showMessageDialog(this,
                "User data file missing or unreadable.",
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (User u : users) {
            if (username.equalsIgnoreCase(u.getUsername()) && password.equals(u.getPassword())) {
                Role r = u.getRole();
                switch (r) {
                    case USER_MANAGEMENT -> JOptionPane.showMessageDialog(this,
                            "Login successful! User Management",
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                    case COURSE_RECOVERY -> JOptionPane.showMessageDialog(this,
                            "Login successful! Course Recovery",
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                    case ELIGIBILITY_OFFICER -> {
                        JOptionPane.showMessageDialog(this,
                            "Login successful! Eligibility Officer",
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                        try {
                            new EligibilityModule().setVisible(true);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(this, "Failed to open module.");
                        }
                    }
                    case ACADEMIC_PERFORMANCE -> JOptionPane.showMessageDialog(this,
                            "Login successful! Academic Officer",
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                    case EMAIL -> JOptionPane.showMessageDialog(this,
                            "Login successful! Email",
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                    default -> JOptionPane.showMessageDialog(this,
                            "Login successful! Role unknown.",
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                }
                return;
            }
        }

        JOptionPane.showMessageDialog(this,
            "Invalid username or password.",
            "Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnloginActionPerformed

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        System.exit(0);
    }                                       

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Login().setVisible(true));
    }//GEN-LAST:event_btnexitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnlogin;
    private javax.swing.JLabel lblpassword;
    private javax.swing.JLabel lblusername;
    private javax.swing.JPasswordField pwdpassword;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}

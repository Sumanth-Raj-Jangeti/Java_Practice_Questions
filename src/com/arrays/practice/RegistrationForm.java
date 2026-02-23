package com.arrays.practice;

import javax.swing.*;
import java.awt.event.*;

public class RegistrationForm extends JFrame implements ActionListener {
    JTextField txtName, txtEmail, txtPhone, txtDOB;
    JRadioButton rbMale, rbFemale;
    JTextArea txtAddress;
    JButton btnSubmit, btnReset;
    RegistrationForm() {
        setTitle("Registration Form");
        setSize(400, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Name
        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(40, 30, 100, 25);
        add(lblName);
        txtName = new JTextField();
        txtName.setBounds(140, 30, 180, 25);
        add(txtName);
        // Email
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(40, 70, 100, 25);
        add(lblEmail);
        txtEmail = new JTextField();
        txtEmail.setBounds(140, 70, 180, 25);
        add(txtEmail);
        // Phone
        JLabel lblPhone = new JLabel("Phone No:");
        lblPhone.setBounds(40, 110, 100, 25);
        add(lblPhone);
        txtPhone = new JTextField();
        txtPhone.setBounds(140, 110, 180, 25);
        add(txtPhone);
        // Gender
        JLabel lblGender = new JLabel("Gender:");
        lblGender.setBounds(40, 150, 100, 25);
        add(lblGender);
        rbMale = new JRadioButton("Male");
        rbMale.setBounds(140, 150, 70, 25);
        rbFemale = new JRadioButton("Female");
        rbFemale.setBounds(220, 150, 80, 25);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbMale);
        bg.add(rbFemale);
        add(rbMale);
        add(rbFemale);
        // Date of Birth
        JLabel lblDOB = new JLabel("DOB:");
        lblDOB.setBounds(40, 190, 100, 25);
        add(lblDOB);
        txtDOB = new JTextField("DD/MM/YYYY");
        txtDOB.setBounds(140, 190, 180, 25);
        add(txtDOB);
        // Address
        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setBounds(40, 230, 100, 25);
        add(lblAddress);
        txtAddress = new JTextArea();
        txtAddress.setBounds(140, 230, 180, 70);
        add(txtAddress);
        // Buttons
        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(140, 330, 80, 30);
        btnSubmit.addActionListener(this);
        add(btnSubmit);
        btnReset = new JButton("Reset");
        btnReset.setBounds(240, 330, 80, 30);
        btnReset.addActionListener(this);
        add(btnReset);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {
            JOptionPane.showMessageDialog(this, "Form Submitted Successfully!");
        }
        if (e.getSource() == btnReset) {
            txtName.setText("");
            txtEmail.setText("");
            txtPhone.setText("");
            txtDOB.setText("");
            txtAddress.setText("");
            rbMale.setSelected(false);
            rbFemale.setSelected(false);
        }
    }
    public static void main(String[] args) {
        new RegistrationForm();
    }
}

package com.library;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class LibrarySystem extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JRadioButton rdbtnNewRadioButton;
    private JRadioButton rdbtnNewRadioButton_2;
    private JComboBox comboBox;

    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LibrarySystem frame = new LibrarySystem();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public LibrarySystem() {
  
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 523);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
     // TITLE
        JLabel titleLabel = new JLabel("Library Book Issue System");
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
        titleLabel.setBounds(56, 15, 350, 40);
        contentPane.add(titleLabel);

        JLabel lblNewLabel = new JLabel("Student Name");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblNewLabel.setBounds(56, 78, 158, 34);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Roll Number");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_1.setBounds(56, 123, 89, 14);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Book Title");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_2.setBounds(58, 156, 101, 20);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Book Category");
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_3.setBounds(56, 200, 115, 14);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Issue Date");
        lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_4.setBounds(56, 265, 103, 14);
        contentPane.add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("Return Date");
        lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_5.setBounds(56, 302, 101, 14);
        contentPane.add(lblNewLabel_5);

        textField = new JTextField();
        textField.setBounds(201, 87, 96, 20);
        contentPane.add(textField);

        textField_1 = new JTextField();
        textField_1.setBounds(201, 121, 96, 20);
        contentPane.add(textField_1);

        textField_2 = new JTextField();
        textField_2.setBounds(201, 157, 96, 20);
        contentPane.add(textField_2);

        textField_3 = new JTextField();
        textField_3.setBounds(201, 262, 96, 20);
        contentPane.add(textField_3);

        textField_4 = new JTextField();
        textField_4.setBounds(201, 299, 96, 20);
        contentPane.add(textField_4);

        rdbtnNewRadioButton = new JRadioButton("Old");
        rdbtnNewRadioButton.setBounds(247, 225, 110, 22);
        contentPane.add(rdbtnNewRadioButton);

        rdbtnNewRadioButton_2 = new JRadioButton("New");
        rdbtnNewRadioButton_2.setBounds(201, 225, 110, 22);
        contentPane.add(rdbtnNewRadioButton_2);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"Programming", "AI", "Databases", "Networking"}));
        comboBox.setBounds(201, 188, 96, 26);
        contentPane.add(comboBox);

        JButton btnNewButton = new JButton("Issue Book");
        btnNewButton.setBounds(45, 379, 102, 22);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Reset");
        btnNewButton_1.setBounds(166, 379, 101, 22);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Exit");
        btnNewButton_2.setBounds(298, 379, 101, 22);
        contentPane.add(btnNewButton_2);

        // ISSUE
        btnNewButton.addActionListener(e -> {
            try {
                if (textField.getText().isEmpty())
                    throw new EmptyFieldException("Student Name is required!");
                if (textField_1.getText().isEmpty())
                    throw new EmptyFieldException("Roll Number is required!");
                if (textField_2.getText().isEmpty())
                    throw new EmptyFieldException("Book Title is required!");
                if (textField_3.getText().isEmpty())
                    throw new EmptyFieldException("Issue Date is required!");
                if (textField_4.getText().isEmpty())
                    throw new EmptyFieldException("Return Date is required!");
                if (!textField_1.getText().matches("[0-9]+"))
                    throw new InvalidRollNumberException("Roll Number must contain numbers only!");
                int roll = Integer.parseInt(textField_1.getText());
                if (comboBox.getSelectedItem() == null)
                    throw new NullSelectionException("Please select a Book Category!");
                if (!rdbtnNewRadioButton.isSelected() && !rdbtnNewRadioButton_2.isSelected())
                    throw new NullSelectionException("Please select Book Type!");
                String[] issueParts = textField_3.getText().split("/");
                String[] returnParts = textField_4.getText().split("/");
                int issueDay = Integer.parseInt(issueParts[0]);
                int returnDay = Integer.parseInt(returnParts[0]);
                if (returnDay < issueDay)
                    throw new InvalidDateException("Return Date cannot be earlier than Issue Date!");
                JOptionPane.showMessageDialog(null,
                    "Book Issued Successfully!\nName: " + textField.getText() +
                    "\nRoll No: " + roll + "\nBook: " + textField_2.getText() +
                    "\nCategory: " + comboBox.getSelectedItem(), "Success",
                    JOptionPane.INFORMATION_MESSAGE);
            } catch (EmptyFieldException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Empty Field Error", JOptionPane.ERROR_MESSAGE);
            } catch (InvalidRollNumberException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Invalid Roll Number", JOptionPane.ERROR_MESSAGE);
            } catch (InvalidDateException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Invalid Date", JOptionPane.ERROR_MESSAGE);
            } catch (NullSelectionException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Selection Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid number format!", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                System.out.println("Operation Completed.");
                JOptionPane.showMessageDialog(null, "Operation Completed", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // RESET
        btnNewButton_1.addActionListener(e -> {
            textField.setText("");
            textField_1.setText("");
            textField_2.setText("");
            textField_3.setText("");
            textField_4.setText("");
            comboBox.setSelectedIndex(0);
            rdbtnNewRadioButton_2.setSelected(true);
        });

        // EXIT
        btnNewButton_2.addActionListener(e -> System.exit(0));
    }
}
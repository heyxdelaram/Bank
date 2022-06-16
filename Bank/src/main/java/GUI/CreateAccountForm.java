package GUI;

import Controller.CentralBankC;
import Controller.CustomerC;
import Controller.StaffC;

import javax.swing.*;

public class CreateAccountForm extends javax.swing.JDialog implements AutoCloseable{

    public CreateAccountForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);

    }

    private void initComponents() {

        firstNameLabel = new javax.swing.JLabel();
        firstNameText = new javax.swing.JTextField();
        lastNameLabel = new javax.swing.JLabel();
        lastNameText = new javax.swing.JTextField();
        fNameLabel = new javax.swing.JLabel();
        fNameText = new javax.swing.JTextField();
        passLabel = new javax.swing.JLabel();
        passText = new javax.swing.JTextField();
        nCodeLabel = new javax.swing.JLabel();
        nCodeText = new javax.swing.JTextField();
        cellLabel = new javax.swing.JLabel();
        cellText = new javax.swing.JTextField();
        addressLabel = new javax.swing.JLabel();
        addressText = new javax.swing.JTextField();
        cityLabel = new javax.swing.JLabel();
        cityText = new javax.swing.JTextField();
        birthdayLabel = new javax.swing.JLabel();
        birthdayText = new javax.swing.JTextField();
        balanceLabel = new javax.swing.JLabel();
        balanceText = new javax.swing.JTextField();
        typeLabel = new javax.swing.JLabel();
        typeText = new javax.swing.JComboBox<>();
        cardIssuanceButton = new javax.swing.JButton();
        submitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Account");
        setMinimumSize(new java.awt.Dimension(400, 300));
        getContentPane().setLayout(new java.awt.GridLayout(12, 2, 2, 2));

        firstNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firstNameLabel.setText("First Name:");
        firstNameLabel.setToolTipText("");
        getContentPane().add(firstNameLabel);
        getContentPane().add(firstNameText);

        lastNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lastNameLabel.setText("Last Name:");
        getContentPane().add(lastNameLabel);

        lastNameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameTextActionPerformed(evt);
            }
        });
        getContentPane().add(lastNameText);

        fNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fNameLabel.setText("Father's Name:");
        getContentPane().add(fNameLabel);
        getContentPane().add(fNameText);

        passLabel.setHorizontalAlignment(SwingConstants.CENTER);
        passLabel.setText("Password: ");
        getContentPane().add(passLabel);
        getContentPane().add(passText);

        nCodeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nCodeLabel.setText("National Code:");
        getContentPane().add(nCodeLabel);

        nCodeText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nCodeTextActionPerformed(evt);
            }
        });
        getContentPane().add(nCodeText);

        cellLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cellLabel.setText("Cell Number:");
        getContentPane().add(cellLabel);
        getContentPane().add(cellText);

        addressLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addressLabel.setText("Address:");
        getContentPane().add(addressLabel);

        addressText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressTextActionPerformed(evt);
            }
        });
        getContentPane().add(addressText);

        cityLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cityLabel.setText("City:");
        getContentPane().add(cityLabel);
        getContentPane().add(cityText);

        birthdayLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        birthdayLabel.setText("Birth Date:");
        getContentPane().add(birthdayLabel);
        getContentPane().add(birthdayText);

        balanceLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        balanceLabel.setText("Balance:");
        getContentPane().add(balanceLabel);
        getContentPane().add(balanceText);

        typeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        typeLabel.setText("Account Type:");
        getContentPane().add(typeLabel);

        typeText.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Checking", "Savings" }));
        typeText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeTextActionPerformed(evt);
            }
        });
        getContentPane().add(typeText);

        cardIssuanceButton.setText("Card Issuance");
        cardIssuanceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardIssuanceButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cardIssuanceButton);

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(submitButton);

        pack();
    }

    private void typeTextActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void lastNameTextActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void nCodeTextActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void addressTextActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String firstName = null;
        String lastName = null;
        String fName = fNameText.getName();
        String nCode = null;
        String cellNum = cellText.getText();
        String address = addressText.getText();
        String city = cityText.getText();
        String birthday = birthdayText.getText();
        String pass = passText.getText();
        double amount = 0;
        String accType;

        StringBuilder warning = new StringBuilder();

        if (firstNameText.getText().isEmpty()){
            warning.append("\tfist name must be entered\n");
        }else{
            firstName = firstNameText.getText();
        }

        if (lastNameText.getText().isEmpty()){
            warning.append("last name must be entered\n");
        }else{
            lastName = lastNameText.getText();
        }
        if (nCodeText.getText().isEmpty()){
            warning.append("national code must be entered\n");
        }else {
            nCode = nCodeText.getText();
        }
        if (balanceText.getText().isEmpty()){
            warning.append("amount must be entered\n");
        }else {
            amount = Double.parseDouble(balanceText.getText());
        }

        if (warning.length() > 0)
            JOptionPane.showMessageDialog(this, warning.toString(), "Input Error", JOptionPane.WARNING_MESSAGE);
        else{
            CustomerC customerC = new CustomerC();
            this.dispose();
            try {
                customerC.createAccount(firstName, lastName, fName, nCode, pass, cellNum, address, city, birthday);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    private void cardIssuanceButtonActionPerformed(java.awt.event.ActionEvent evt) {

        String firstName = null;
        String lastName = null;
        String fName = fNameText.getName();
        String nCode = nCodeText.getText();
        String cellNum = cellText.getText();
        String address = addressText.getText();
        String city = cityText.getText();
        String birthday = birthdayText.getText();
        String pass = passText.getText();
        double amount = 0;
        String accType;

        StringBuilder warning = new StringBuilder();

        if (firstNameText.getText().isEmpty()){
            warning.append("\tfist name must be entered\n");
        }else{
            firstName = firstNameText.getText();
        }

        if (lastNameText.getText().isEmpty()){
            warning.append("last name must be entered\n");
        }else{
            lastName = lastNameText.getText();
        }
        if (nCodeText.getText().isEmpty()){
            warning.append("national code must be entered\n");
        }else {
            nCode = nCodeText.getText();
        }
        if (balanceText.getText().isEmpty()){
            warning.append("amount must be entered\n");
        }else {
            amount = Double.parseDouble(balanceText.getText());
        }

        if (warning.length() > 0)
            JOptionPane.showMessageDialog(this, warning.toString(), "Input Error", JOptionPane.WARNING_MESSAGE);
        else {
            JOptionPane.showMessageDialog(this, "card issued successfully", "Successful", JOptionPane.PLAIN_MESSAGE);
        }
/*
        else{

            StaffC staffC = new StaffC();
            this.dispose();
            try {
                staffC.createAccount();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

 */
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CreateAccountForm dialog = new CreateAccountForm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField addressText;
    private javax.swing.JLabel balanceLabel;
    private javax.swing.JTextField balanceText;
    private javax.swing.JLabel birthdayLabel;
    private javax.swing.JTextField birthdayText;
    private javax.swing.JButton cardIssuanceButton;
    private javax.swing.JLabel passLabel;
    private javax.swing.JTextField passText;
    private javax.swing.JLabel cellLabel;
    private javax.swing.JTextField cellText;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JTextField cityText;
    private javax.swing.JLabel fNameLabel;
    private javax.swing.JTextField fNameText;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField firstNameText;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField lastNameText;
    private javax.swing.JLabel nCodeLabel;
    private javax.swing.JTextField nCodeText;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel typeLabel;
    private javax.swing.JComboBox<String> typeText;

    @Override
    public void close() throws Exception {

    }
}
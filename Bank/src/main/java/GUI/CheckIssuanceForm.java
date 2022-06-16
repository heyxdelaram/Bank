package GUI;

import javax.swing.*;

public class CheckIssuanceForm extends javax.swing.JDialog {

    public CheckIssuanceForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
    }
    private void initComponents() {

        firstNameLabel = new javax.swing.JLabel();
        firstNameText = new javax.swing.JTextField();
        lastNameLabel = new javax.swing.JLabel();
        lastNameText = new javax.swing.JTextField();
        accountNumLabel = new javax.swing.JLabel();
        accountNumText = new javax.swing.JTextField();
        cvv2Label = new javax.swing.JLabel();
        cvv2Text = new javax.swing.JTextField();
        writeCheckButton = new javax.swing.JButton();
        submitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Check Issuance Form");
        setMinimumSize(new java.awt.Dimension(400, 300));
        getContentPane().setLayout(new java.awt.GridLayout(5, 2, 2, 2));

        firstNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firstNameLabel.setText("First Name :");
        getContentPane().add(firstNameLabel);
        getContentPane().add(firstNameText);

        lastNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lastNameLabel.setText("Last Name :");
        getContentPane().add(lastNameLabel);
        getContentPane().add(lastNameText);

        accountNumLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        accountNumLabel.setText("Account Number :");
        getContentPane().add(accountNumLabel);

        accountNumText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountNumTextActionPerformed(evt);
            }
        });
        getContentPane().add(accountNumText);

        cvv2Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cvv2Label.setText("cvv2 :");
        getContentPane().add(cvv2Label);

        cvv2Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cvv2TextActionPerformed(evt);
            }
        });
        getContentPane().add(cvv2Text);

        writeCheckButton.setText("Write a Check");
        writeCheckButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                writeCheckButtonActionPerformed(evt);
            }
        });
        getContentPane().add(writeCheckButton);

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(submitButton);

        pack();
    }

    private void accountNumTextActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void cvv2TextActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void writeCheckButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        MainMenu mm = new MainMenu();
        WriteCheckForm writeCheck = new WriteCheckForm(mm, true);
        writeCheck.setVisible(true);
    }

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        StringBuilder success = new StringBuilder();
        JOptionPane.showMessageDialog(this, "Check successfully written", "successful", JOptionPane.PLAIN_MESSAGE);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CheckIssuanceForm dialog = new CheckIssuanceForm(new javax.swing.JFrame(), true);
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

    private javax.swing.JLabel accountNumLabel;
    private javax.swing.JTextField accountNumText;
    private javax.swing.JLabel cvv2Label;
    private javax.swing.JTextField cvv2Text;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField firstNameText;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField lastNameText;
    private javax.swing.JButton submitButton;
    private javax.swing.JButton writeCheckButton;
}
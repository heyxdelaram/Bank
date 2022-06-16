package GUI;

import Controller.CentralBankC;
import Controller.CustomerC;
import Entity.CustomerE;

import javax.swing.*;
public class CustomerLogin extends javax.swing.JDialog implements AutoCloseable {

    public CustomerLogin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
    }

    public CustomerLogin() {
        initComponents();
    }

    public void initComponents() {

        nCodeLabel = new javax.swing.JLabel();
        nCodeText = new javax.swing.JTextField();
        passLabel = new javax.swing.JLabel();
        passText = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Customer Log In");
        setMinimumSize(new java.awt.Dimension(400, 300));
        getContentPane().setLayout(new java.awt.GridLayout(3, 2, 2, 2));

        nCodeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nCodeLabel.setText("Natoinal Code :");
        getContentPane().add(nCodeLabel);
        getContentPane().add(nCodeText);

        passLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passLabel.setText("Password :");
        getContentPane().add(passLabel);
        getContentPane().add(passText);

        loginButton.setText("Log in ");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        getContentPane().add(loginButton);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton);

        pack();
    }

    public void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {

        String nCode = null;
        String pass = null;
        StringBuilder warning = new StringBuilder();

        if (nCodeText.getText().isEmpty()){
            warning.append("\tnational code is empty\n");
        }else{
            nCode = nCodeText.getText();
        }

        if (passText.getText().isEmpty()){
            warning.append("\tpassword is empty\n");
        }else{
            pass = passText.getText();
        }

        if (warning.length() > 0)
            JOptionPane.showMessageDialog(this, warning.toString(), "Input Error", JOptionPane.WARNING_MESSAGE);
        else{
            CustomerC customerC = new CustomerC();
            this.dispose();
            try {
                customerC.login(nCode, pass);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CustomerLogin dialog = new CustomerLogin(new javax.swing.JFrame(), true);
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

    private javax.swing.JButton cancelButton;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel nCodeLabel;
    private javax.swing.JTextField nCodeText;
    private javax.swing.JLabel passLabel;
    private javax.swing.JPasswordField passText;

    @Override
    public void close() throws Exception {

    }
}
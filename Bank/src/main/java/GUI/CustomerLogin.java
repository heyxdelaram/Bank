package GUI;

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

    }

    private void initComponents() {

        nCodeLabel = new javax.swing.JLabel();
        nCodeText = new javax.swing.JTextField();
        passLabel = new javax.swing.JLabel();
        passText = new javax.swing.JTextField();
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

        CustomerLogin customerLogin=new CustomerLogin();
        customerLogin.setnCodeText(nCodeText);

        passLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passLabel.setText("Password :");
        getContentPane().add(passLabel);
        getContentPane().add(passText);

        customerLogin.setPassText(passText);

        loginButton.setText("Log in ");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    loginButtonActionPerformed(evt);
                } catch (Exception e) {
                    e.printStackTrace();
                }
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

    public void loginButtonActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
        CustomerC c=new CustomerC();
        c.login();
        this.dispose();
        MainMenu mm = new MainMenu();
        CustomerMenu customerMenu = new CustomerMenu(mm, true);
        customerMenu.setVisible(true);
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
    private javax.swing.JTextField passText;

    public JTextField getnCodeText() {
        return nCodeText;
    }

    public void setnCodeText(JTextField nCodeText) {
        this.nCodeText = nCodeText;
    }

    public JTextField getPassText() {
        return passText;
    }

    public void setPassText(JTextField passText) {
        this.passText = passText;
    }

    @Override
    public void close() throws Exception {

    }
}

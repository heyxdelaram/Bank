package GUI;

import Controller.CentralBankC;
import Controller.StaffC;

import javax.swing.*;

public class CentralBankLogin extends javax.swing.JDialog implements AutoCloseable{

    public CentralBankLogin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);

    }

    public CentralBankLogin(){
        initComponents();
    }
    private void initComponents() {

        usernameLabel = new javax.swing.JLabel();
        usernameText = new javax.swing.JTextField();
        passLabel = new javax.swing.JLabel();
        passText = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Log In");
        setMinimumSize(new java.awt.Dimension(400, 300));
        getContentPane().setLayout(new java.awt.GridLayout(3, 2, 10, 5));

        usernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernameLabel.setText("Username:");
        getContentPane().add(usernameLabel);
        getContentPane().add(usernameText);

        passLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passLabel.setText("Password:");
        getContentPane().add(passLabel);
        getContentPane().add(passText);

        loginButton.setText("Log in");
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

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {

        String username = null;
        String pass = null;
        StringBuilder warning = new StringBuilder();

        if (usernameText.getText().isEmpty()){
            warning.append("\tusername is empty\n");
        }else{
            username = usernameText.getText();
            //setUsername(usernameText.getText());
        }

        if (passText.getText().isEmpty()){
            warning.append("\tpassword is empty\n");
        }else{
            pass = passText.getText();
            //setPass(passText.getText());
        }

        if (warning.length() > 0)
            JOptionPane.showMessageDialog(this, warning.toString(), "Input Error", JOptionPane.WARNING_MESSAGE);
        else{
            CentralBankC centralBankC = new CentralBankC();
            this.dispose();
            try {
                centralBankC.login(username, pass);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CentralBankLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CentralBankLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CentralBankLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CentralBankLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CentralBankLogin dialog = new CentralBankLogin(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel passLabel;
    private javax.swing.JPasswordField passText;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameText;

    @Override
    public void close() throws Exception {

    }
}
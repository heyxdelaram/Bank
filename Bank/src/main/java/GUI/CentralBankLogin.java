package GUI;

import Controller.CentralBankC;
import Controller.StaffC;

import static GUI.StaffLogin.username1;

public class CentralBankLogin extends javax.swing.JDialog implements AutoCloseable{

    private String username1;
    private String pass1;

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

        usernameLabel.setText("Username:");
        getContentPane().add(usernameLabel);
        getContentPane().add(usernameText);

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
        getContentPane().add(cancelButton);

        pack();
    }

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {

        String nCode = usernameText.getText();
        String pass = passText.getText();

        this.username1 = nCode;
        this.pass1 = pass;
        CentralBankC centralBankC = new CentralBankC();
        try {
            centralBankC.login();
        } catch (Exception e) {
            e.printStackTrace();
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

    public String getPass() {
        return pass1;
    }


    public String getUsername() {
        return username1;
    }

    @Override
    public void close() throws Exception {

    }
}
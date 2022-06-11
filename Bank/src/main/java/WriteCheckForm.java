
package GUI;

public class WriteCheckForm extends javax.swing.JDialog {

    public WriteCheckForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);

    }

    private void initComponents() {

        amountNumberLabel = new javax.swing.JLabel();
        amountNumberText = new javax.swing.JTextField();
        amountWordLabel = new javax.swing.JLabel();
        amountWordText = new javax.swing.JTextField();
        accountNumReceiverLabel = new javax.swing.JLabel();
        accountNumReceiverText = new javax.swing.JTextField();
        dateLabel = new javax.swing.JLabel();
        dateText = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Write Check Form");
        getContentPane().setLayout(new java.awt.GridLayout(5, 5, 2, 2));

        amountNumberLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        amountNumberLabel.setText("Amount-in-numbers :");
        getContentPane().add(amountNumberLabel);
        getContentPane().add(amountNumberText);

        amountWordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        amountWordLabel.setText("Amount-in-words :");
        getContentPane().add(amountWordLabel);

        amountWordText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountWordTextActionPerformed(evt);
            }
        });
        getContentPane().add(amountWordText);

        accountNumReceiverLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        accountNumReceiverLabel.setText("Account Number (Receiver) :");
        getContentPane().add(accountNumReceiverLabel);
        getContentPane().add(accountNumReceiverText);

        dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateLabel.setText("Date :");
        getContentPane().add(dateLabel);
        getContentPane().add(dateText);

        submitButton.setText("Submit");
        getContentPane().add(submitButton);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton);

        pack();
    }

    private void amountWordTextActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        MainMenu mm = new MainMenu();
        CheckIssuanceForm cif = new CheckIssuanceForm(mm, true);
        cif.setVisible(true);
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
            java.util.logging.Logger.getLogger(WriteCheckForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WriteCheckForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WriteCheckForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WriteCheckForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                WriteCheckForm dialog = new WriteCheckForm(new javax.swing.JFrame(), true);
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

    private javax.swing.JLabel accountNumReceiverLabel;
    private javax.swing.JTextField accountNumReceiverText;
    private javax.swing.JLabel amountNumberLabel;
    private javax.swing.JTextField amountNumberText;
    private javax.swing.JLabel amountWordLabel;
    private javax.swing.JTextField amountWordText;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField dateText;
    private javax.swing.JButton submitButton;
}

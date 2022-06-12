
package GUI;

public class TransferMoneyForm extends javax.swing.JDialog {

    public TransferMoneyForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
    }

    private void initComponents() {

        payeeNumLabel = new javax.swing.JLabel();
        payeeNumText = new javax.swing.JTextField();
        ReceiverNumLabel = new javax.swing.JLabel();
        ReceiverNumText = new javax.swing.JTextField();
        amountLabel = new javax.swing.JLabel();
        amountText = new javax.swing.JTextField();
        cvv2Label = new javax.swing.JLabel();
        cvv2Text = new javax.swing.JTextField();
        expiryDateLabel = new javax.swing.JLabel();
        expiryDateText = new javax.swing.JTextField();
        transferButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Transfer Money");
        getContentPane().setLayout(new java.awt.GridLayout(6, 2, 2, 2));

        payeeNumLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        payeeNumLabel.setText("Payee Account Number :");
        payeeNumLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        payeeNumLabel.setFocusTraversalPolicyProvider(true);
        getContentPane().add(payeeNumLabel);
        getContentPane().add(payeeNumText);

        ReceiverNumLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ReceiverNumLabel.setText("Receiver Account Number :");
        getContentPane().add(ReceiverNumLabel);

        ReceiverNumText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReceiverNumTextActionPerformed(evt);
            }
        });
        getContentPane().add(ReceiverNumText);

        amountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        amountLabel.setText("Amount :");
        getContentPane().add(amountLabel);
        getContentPane().add(amountText);

        cvv2Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cvv2Label.setText("cvv2 :");
        getContentPane().add(cvv2Label);
        getContentPane().add(cvv2Text);

        expiryDateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        expiryDateLabel.setText("Expiry Date :");
        getContentPane().add(expiryDateLabel);

        expiryDateText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expiryDateTextActionPerformed(evt);
            }
        });
        getContentPane().add(expiryDateText);

        transferButton.setText("Transfer");
        getContentPane().add(transferButton);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton);

        pack();
    }

    private void ReceiverNumTextActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    private void expiryDateTextActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TransferMoneyForm dialog = new TransferMoneyForm(new javax.swing.JFrame(), true);
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

    private javax.swing.JLabel ReceiverNumLabel;
    private javax.swing.JTextField ReceiverNumText;
    private javax.swing.JLabel amountLabel;
    private javax.swing.JTextField amountText;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel cvv2Label;
    private javax.swing.JTextField cvv2Text;
    private javax.swing.JLabel expiryDateLabel;
    private javax.swing.JTextField expiryDateText;
    private javax.swing.JLabel payeeNumLabel;
    private javax.swing.JTextField payeeNumText;
    private javax.swing.JButton transferButton;
}

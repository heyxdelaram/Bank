package GUI;

public class PayDebtForm extends javax.swing.JDialog {

    public PayDebtForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);

    }

    private void initComponents() {

        payeeNumLabel = new javax.swing.JLabel();
        payeeNumText = new javax.swing.JTextField();
        ReceiverNumLabel = new javax.swing.JLabel();
        ReceiverNumText = new javax.swing.JTextField();
        debtTypeLabel = new javax.swing.JLabel();
        DebtTypeText = new javax.swing.JComboBox<>();
        amountLabel = new javax.swing.JLabel();
        amountText = new javax.swing.JTextField();
        payButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pay Debt");
        getContentPane().setLayout(new java.awt.GridLayout(5, 2, 2, 2));

        payeeNumLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        payeeNumLabel.setText("Payee Account Number :");
        getContentPane().add(payeeNumLabel);
        getContentPane().add(payeeNumText);

        ReceiverNumLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ReceiverNumLabel.setText("Receiver Account Number :");
        getContentPane().add(ReceiverNumLabel);
        getContentPane().add(ReceiverNumText);

        debtTypeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        debtTypeLabel.setText("Debt Type :");
        getContentPane().add(debtTypeLabel);

        DebtTypeText.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Loan", "Check Debt" }));
        getContentPane().add(DebtTypeText);

        amountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        amountLabel.setText("Amount :");
        getContentPane().add(amountLabel);
        getContentPane().add(amountText);

        payButton.setText("Pay");
        getContentPane().add(payButton);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton);

        pack();
    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PayDebtForm dialog = new PayDebtForm(new javax.swing.JFrame(), true);
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

    private javax.swing.JComboBox<String> DebtTypeText;
    private javax.swing.JLabel ReceiverNumLabel;
    private javax.swing.JTextField ReceiverNumText;
    private javax.swing.JLabel amountLabel;
    private javax.swing.JTextField amountText;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel debtTypeLabel;
    private javax.swing.JButton payButton;
    private javax.swing.JLabel payeeNumLabel;
    private javax.swing.JTextField payeeNumText;
}

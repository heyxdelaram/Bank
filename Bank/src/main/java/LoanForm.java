package GUI;

public class LoanForm extends javax.swing.JDialog {

    public LoanForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
    }
    private void initComponents() {

        firstNameLabel = new javax.swing.JLabel();
        firstNameText = new javax.swing.JTextField();
        lastNameLabel = new javax.swing.JLabel();
        lastNameText = new javax.swing.JTextField();
        AccountNumLabel = new javax.swing.JLabel();
        AccountNumText = new javax.swing.JTextField();
        typeLabel = new javax.swing.JLabel();
        typeText = new javax.swing.JComboBox<>();
        amountLabel = new javax.swing.JLabel();
        amountText = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Loan Form");
        getContentPane().setLayout(new java.awt.GridLayout(6, 2, 2, 2));

        firstNameLabel.setText("First Name :");
        getContentPane().add(firstNameLabel);
        getContentPane().add(firstNameText);

        lastNameLabel.setText("Last Name : ");
        getContentPane().add(lastNameLabel);
        getContentPane().add(lastNameText);

        AccountNumLabel.setText("Account Number :");
        getContentPane().add(AccountNumLabel);
        getContentPane().add(AccountNumText);

        typeLabel.setText("Loan Type : ");
        getContentPane().add(typeLabel);

        typeText.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Home and Mortgage", "Auto", "Student" }));
        getContentPane().add(typeText);

        amountLabel.setText("Loan Amount");
        getContentPane().add(amountLabel);
        getContentPane().add(amountText);

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

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoanForm dialog = new LoanForm(new javax.swing.JFrame(), true);
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

    private javax.swing.JLabel AccountNumLabel;
    private javax.swing.JTextField AccountNumText;
    private javax.swing.JLabel amountLabel;
    private javax.swing.JTextField amountText;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField firstNameText;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField lastNameText;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel typeLabel;
    private javax.swing.JComboBox<String> typeText;
}

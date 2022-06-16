
package GUI;

public class StaffMenu extends javax.swing.JDialog {

    public StaffMenu(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
    }

    private void initComponents() {

        createAccountButton = new javax.swing.JButton();
        checkIssuanceButton = new javax.swing.JButton();
        loanAppliancesButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Staff Menu");
        setMinimumSize(new java.awt.Dimension(400, 300));
        getContentPane().setLayout(new java.awt.GridLayout(3, 0));

        createAccountButton.setText("Create Account");
        createAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAccountButtonActionPerformed(evt);
            }
        });
        getContentPane().add(createAccountButton);

        checkIssuanceButton.setText("Check Issuance");
        checkIssuanceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkIssuanceButtonActionPerformed(evt);
            }
        });
        getContentPane().add(checkIssuanceButton);

        loanAppliancesButton.setText("Loan Appliance");
        loanAppliancesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loanAppliancesButtonActionPerformed(evt);
            }
        });
        getContentPane().add(loanAppliancesButton);

        pack();
    }

    private void createAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        MainMenu mm = new MainMenu();
        CreateAccountForm createAccount = new CreateAccountForm(mm, true);
        createAccount.setVisible(true);
    }

    private void checkIssuanceButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        MainMenu mm = new MainMenu();
        CheckIssuanceForm checkIssue = new CheckIssuanceForm(mm, true);
        checkIssue.setVisible(true);
    }

    private void loanAppliancesButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        MainMenu mm = new MainMenu();
        LoanForm loan = new LoanForm(mm, true);
        loan.setVisible(true);
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                StaffMenu dialog = new StaffMenu(new javax.swing.JFrame(), true);
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

    private javax.swing.JButton checkIssuanceButton;
    private javax.swing.JButton createAccountButton;
    private javax.swing.JButton loanAppliancesButton;
}
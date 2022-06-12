package GUI;

public class CustomerMenu extends javax.swing.JDialog {

    public CustomerMenu(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);

    }

    private void initComponents() {

        transferMoneyButton = new javax.swing.JButton();
        showBalanceButton = new javax.swing.JButton();
        payLoanButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Customer Menu");
        setMinimumSize(new java.awt.Dimension(400, 300));
        getContentPane().setLayout(new java.awt.GridLayout(3, 1, 5, 5));

        transferMoneyButton.setText("Transfer Money");
        transferMoneyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferMoneyButtonActionPerformed(evt);
            }
        });
        getContentPane().add(transferMoneyButton);

        showBalanceButton.setText("Show Account Status");
        showBalanceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showBalanceButtonActionPerformed(evt);
            }
        });
        getContentPane().add(showBalanceButton);

        payLoanButton.setText("Pay Debts");
        payLoanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payLoanButtonActionPerformed(evt);
            }
        });
        getContentPane().add(payLoanButton);

        pack();
    }

    private void transferMoneyButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        MainMenu mm = new MainMenu();
        TransferMoneyForm tmf = new TransferMoneyForm(mm, true);
        tmf.setVisible(true);
    }

    private void payLoanButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        MainMenu mm = new MainMenu();
        PayDebtForm pdf = new PayDebtForm(mm, true);
        pdf.setVisible(true);
    }

    private void showBalanceButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        MainMenu mm = new MainMenu();
        AccountStatusTable ast = new AccountStatusTable(mm, true);
        ast.setVisible(true);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CustomerMenu dialog = new CustomerMenu(new javax.swing.JFrame(), true);
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

    private javax.swing.JButton payLoanButton;
    private javax.swing.JButton showBalanceButton;
    private javax.swing.JButton transferMoneyButton;
}

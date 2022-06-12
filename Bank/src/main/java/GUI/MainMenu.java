package GUI;

public class MainMenu extends javax.swing.JFrame {

    public MainMenu() {
        initComponents();
        setLocationRelativeTo(null);
    }
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        welcomeLabel = new javax.swing.JLabel();
        welcome2Label = new javax.swing.JLabel();
        customerButton = new javax.swing.JButton();
        staffButton = new javax.swing.JButton();
        centralbankButton = new javax.swing.JButton();
        backgroundImage = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        exitItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bank Application");

        jPanel1.setLayout(null);

        welcomeLabel.setBackground(new java.awt.Color(255, 255, 255));
        welcomeLabel.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        welcomeLabel.setText("Welcome");
        jPanel1.add(welcomeLabel);
        welcomeLabel.setBounds(220, 50, 200, 80);

        welcome2Label.setFont(new java.awt.Font("Roona Sans Light PERSONAL", 0, 8)); // NOI18N
        welcome2Label.setText("Please select your role");
        jPanel1.add(welcome2Label);
        welcome2Label.setBounds(270, 120, 110, 12);

        customerButton.setText("Customer");
        customerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerButtonActionPerformed(evt);
            }
        });
        jPanel1.add(customerButton);
        customerButton.setBounds(230, 170, 190, 70);

        staffButton.setText("Staff");
        staffButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffButtonActionPerformed(evt);
            }
        });
        jPanel1.add(staffButton);
        staffButton.setBounds(230, 250, 190, 70);

        centralbankButton.setText("Central Bank");
        centralbankButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                centralbankButtonActionPerformed(evt);
            }
        });
        jPanel1.add(centralbankButton);
        centralbankButton.setBounds(230, 330, 190, 70);

        backgroundImage.setIcon(new javax.swing.ImageIcon("C:\\Users\\asus\\IdeaProjects\\Bank\\src\\rm222-mind-22_1_2.jpg")); // NOI18N
        jPanel1.add(backgroundImage);
        backgroundImage.setBounds(0, 0, 700, 510);

        jMenu1.setText("File");

        exitItem.setText("Exit");
        exitItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitItemActionPerformed(evt);
            }
        });
        jMenu1.add(exitItem);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
        );

        pack();
    }

    private void centralbankButtonActionPerformed(java.awt.event.ActionEvent evt) {
        CentralBankLogin cbank = new CentralBankLogin(this, true);
        cbank.setVisible(true);
    }

    private void customerButtonActionPerformed(java.awt.event.ActionEvent evt) {
        CustomerLogin cli = new CustomerLogin(this, true);
        cli.setVisible(true);
    }

    private void staffButtonActionPerformed(java.awt.event.ActionEvent evt) {
        StaffLogin stfl = new StaffLogin(this, true);
        stfl.setVisible(true);
    }

    private void exitItemActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    private javax.swing.JLabel backgroundImage;
    private javax.swing.JButton centralbankButton;
    private javax.swing.JButton customerButton;
    private javax.swing.JMenuItem exitItem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton staffButton;
    private javax.swing.JLabel welcome2Label;
    private javax.swing.JLabel welcomeLabel;
}

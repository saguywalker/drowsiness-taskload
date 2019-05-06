/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DrowsinessApp;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import processing.awt.PSurfaceAWT.SmoothCanvas;
import processing.core.PSurface;

/**
 *
 * @author guygu
 */
public final class GUIClass extends JFrame {

    /**
     * Creates new form JFrame
     */
    private static CardLayout card;
    private static List<Transaction> samples;
    private static StaffAccount staff;
    private static ActionListener[] actions;
    private static Timer timer;
    public MainCore mc;
    private PSurface ms;
    private SmoothCanvas msc;

    public GUIClass() {
        initComponents();
        //mainCore.init();
        //add(mainCore);
        card = (CardLayout) mainPanel.getLayout();
        setTableHeader();
        setTableData();
        initActions();
        
        mc = new MainCore();
        ms = mc.getInitSurface();
        ms.setSize(570,480);
        msc = (SmoothCanvas) ms.getNative();
        mainPanel.add(msc);
        
        /*mainPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e){
                System.out.println(e.getX() + ", " + e.getY());
            }
        });*/
        
        for (int i = 0; i < actions.length; i++) {
            timer = new Timer(3000 * (i + 1), actions[i]);
            timer.setRepeats(false);
            timer.start();
        }
    }

    public void setTableData() {
        DefaultTableModel model = (DefaultTableModel) txTable.getModel();
        model.setRowCount(0);
        Collections.shuffle(samples);
        for (int i = 0; i < samples.size(); i++) {
            model.insertRow(i, new Object[]{samples.get(i).getId(), samples.get(i).getType(), samples.get(i).getBank(), samples.get(i).getAccount()});
        }
    }

    public void setTableData(JTable txTable, int num) {
        DefaultTableModel model = (DefaultTableModel) txTable.getModel();
        model.setRowCount(0);
        Collections.shuffle(samples);
        for (int i = 0; i < num; i++) {
            model.insertRow(i, new Object[]{samples.get(i).getId(), samples.get(i).getType(), samples.get(i).getBank(), samples.get(i).getAccount()});
        }
    }

    public void setTableHeader() {
        Object[] columnNames = {"Transaction ID", "Type", "Bank", "Bank Account"};
        //txTable = new JTable(new DefaultTableModel(new Object[]{"Transaction ID", "Type", "Bank", "Bank Account"}, 0));

        JTableHeader th = txTable.getTableHeader();
        TableColumnModel tcm = th.getColumnModel();
        for (int i = 0; i < columnNames.length; i++) {
            tcm.getColumn(i).setHeaderValue(columnNames[i]);
        }
        th.repaint();
    }

    public boolean isTxidCorrect(int txid) {
        for (DrowsinessApp.Transaction tx : samples) {
            if (tx.getId() == txid) {
                accountTextField.setText(tx.getAccount());
                ownerTextField.setText(tx.getOwner());
                amountTextField.setText("" + tx.getAmountDue());
                transferTextField.setText("" + tx.getAmountTransfer());

                return true;
            }
        }
        return false;
    }

    public void clearTransactionPage() {
        accountTextField.setText("");
        ownerTextField.setText("");
        amountTextField.setText("");
        transferTextField.setText("");
        enterTxIdTextField.setText("");
    }

    public void clearStaffPage() {
        staffIdTextField.setText("");
        staffPwdField.setText("");
    }

    public void initActions() {
        actions = new ActionListener[3];
        actions[0] = (ActionEvent e) -> {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            DefaultTableModel model = (DefaultTableModel) txTable.getModel();
            model.setRowCount(0);
            Collections.shuffle(samples);
            for (int i = 0; i < 18; i++) {
                model.insertRow(i, new Object[]{samples.get(i).getId(), samples.get(i).getType(), samples.get(i).getBank(), samples.get(i).getAccount()});
            }
        };

        actions[1] = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                DefaultTableModel model = (DefaultTableModel) txTable.getModel();
                model.setRowCount(0);
                Collections.shuffle(samples);
                for (int i = 0; i < 10; i++) {
                    model.insertRow(i, new Object[]{samples.get(i).getId(), samples.get(i).getType(), samples.get(i).getBank(), samples.get(i).getAccount()});
                }
            }
        };

        actions[2] = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                DefaultTableModel model = (DefaultTableModel) txTable.getModel();
                model.setRowCount(0);
                Collections.shuffle(samples);
                for (int i = 0; i < 3; i++) {
                    model.insertRow(i, new Object[]{samples.get(i).getId(), samples.get(i).getType(), samples.get(i).getBank(), samples.get(i).getAccount()});
                }
            }
        };
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        companyPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txTable = new javax.swing.JTable();
        goButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        transactionPanel = new javax.swing.JPanel();
        enterTxIdLabel = new javax.swing.JLabel();
        enterTxIdTextField = new javax.swing.JTextField();
        goButton2 = new javax.swing.JButton();
        transactionLabel = new javax.swing.JLabel();
        txDetialPanel = new javax.swing.JPanel();
        accountTextField = new javax.swing.JTextField();
        ownerTextField = new javax.swing.JTextField();
        accountLabel = new javax.swing.JLabel();
        ownerLabel = new javax.swing.JLabel();
        amountLabel = new javax.swing.JLabel();
        amountTextField = new javax.swing.JTextField();
        tranferLabel = new javax.swing.JLabel();
        transferTextField = new javax.swing.JTextField();
        confirmButton = new javax.swing.JButton();
        reportButton = new javax.swing.JButton();
        staffPanel = new javax.swing.JPanel();
        staffIdLabel = new javax.swing.JLabel();
        staffIdTextField = new javax.swing.JTextField();
        staffPwdLabel = new javax.swing.JLabel();
        goButton3 = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        staffPwdField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        mainPanel.setPreferredSize(new java.awt.Dimension(570, 480));
        mainPanel.setLayout(new java.awt.CardLayout());

        txTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        txTable.setEnabled(false);
        jScrollPane1.setViewportView(txTable);

        goButton.setBackground(new java.awt.Color(153, 204, 255));
        goButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        goButton.setText("Go");
        goButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goButtonActionPerformed(evt);
            }
        });

        refreshButton.setBackground(new java.awt.Color(149, 215, 248));
        refreshButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 130, 27));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("X Company");
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout companyPanelLayout = new javax.swing.GroupLayout(companyPanel);
        companyPanel.setLayout(companyPanelLayout);
        companyPanelLayout.setHorizontalGroup(
            companyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, companyPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(goButton)
                .addGap(60, 60, 60))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, companyPanelLayout.createSequentialGroup()
                .addGroup(companyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(companyPanelLayout.createSequentialGroup()
                        .addContainerGap(24, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(companyPanelLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refreshButton)))
                .addGap(36, 36, 36))
        );
        companyPanelLayout.setVerticalGroup(
            companyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(companyPanelLayout.createSequentialGroup()
                .addGroup(companyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(companyPanelLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(refreshButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, companyPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(goButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.add(companyPanel, "companyPanel");

        enterTxIdLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        enterTxIdLabel.setText("Please Enter Transaction ID");

        enterTxIdTextField.setBackground(new java.awt.Color(222, 203, 229));
        enterTxIdTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterTxIdTextFieldActionPerformed(evt);
            }
        });

        goButton2.setBackground(new java.awt.Color(153, 204, 255));
        goButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        goButton2.setText("Go");
        goButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goButton2ActionPerformed(evt);
            }
        });

        transactionLabel.setBackground(new java.awt.Color(180, 198, 125));
        transactionLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        transactionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        transactionLabel.setText("Transaction");
        transactionLabel.setOpaque(true);

        txDetialPanel.setBackground(new java.awt.Color(253, 239, 216));
        txDetialPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        accountTextField.setBackground(new java.awt.Color(218, 236, 255));

        ownerTextField.setBackground(new java.awt.Color(218, 236, 255));
        ownerTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ownerTextFieldActionPerformed(evt);
            }
        });

        accountLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        accountLabel.setText("Bank Account");

        ownerLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ownerLabel.setText("Owner");

        amountLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        amountLabel.setText("Amout Due");

        amountTextField.setBackground(new java.awt.Color(218, 236, 255));
        amountTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountTextFieldActionPerformed(evt);
            }
        });

        tranferLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tranferLabel.setText("Amount Transferred");

        transferTextField.setBackground(new java.awt.Color(218, 236, 255));

        confirmButton.setBackground(new java.awt.Color(0, 255, 102));
        confirmButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        confirmButton.setText("Confirm");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        reportButton.setBackground(new java.awt.Color(255, 51, 51));
        reportButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        reportButton.setText("Report");
        reportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout txDetialPanelLayout = new javax.swing.GroupLayout(txDetialPanel);
        txDetialPanel.setLayout(txDetialPanelLayout);
        txDetialPanelLayout.setHorizontalGroup(
            txDetialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txDetialPanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(accountLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ownerLabel)
                .addGap(67, 67, 67))
            .addGroup(txDetialPanelLayout.createSequentialGroup()
                .addGroup(txDetialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txDetialPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(txDetialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(txDetialPanelLayout.createSequentialGroup()
                                .addComponent(confirmButton)
                                .addGap(46, 46, 46))
                            .addGroup(txDetialPanelLayout.createSequentialGroup()
                                .addComponent(amountLabel)
                                .addGap(57, 57, 57))
                            .addGroup(txDetialPanelLayout.createSequentialGroup()
                                .addComponent(transferTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)))
                        .addGroup(txDetialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ownerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txDetialPanelLayout.createSequentialGroup()
                                .addComponent(reportButton)
                                .addGap(40, 40, 40))))
                    .addGroup(txDetialPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(txDetialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(accountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tranferLabel)))
                    .addGroup(txDetialPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(amountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        txDetialPanelLayout.setVerticalGroup(
            txDetialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txDetialPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(txDetialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accountLabel)
                    .addComponent(ownerLabel))
                .addGap(18, 18, 18)
                .addGroup(txDetialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ownerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(amountLabel)
                .addGap(18, 18, 18)
                .addComponent(amountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tranferLabel)
                .addGap(18, 18, 18)
                .addComponent(transferTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(txDetialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmButton)
                    .addComponent(reportButton))
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout transactionPanelLayout = new javax.swing.GroupLayout(transactionPanel);
        transactionPanel.setLayout(transactionPanelLayout);
        transactionPanelLayout.setHorizontalGroup(
            transactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transactionPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(transactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(transactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(enterTxIdLabel)
                        .addComponent(enterTxIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(goButton2))
                .addGap(18, 18, 18)
                .addComponent(txDetialPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, transactionPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(transactionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
        );
        transactionPanelLayout.setVerticalGroup(
            transactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transactionPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(transactionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(transactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txDetialPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(transactionPanelLayout.createSequentialGroup()
                        .addComponent(enterTxIdLabel)
                        .addGap(18, 18, 18)
                        .addComponent(enterTxIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(goButton2)
                        .addGap(195, 195, 195)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        mainPanel.add(transactionPanel, "transactionPanel");

        staffIdLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        staffIdLabel.setText("Staff ID");

        staffIdTextField.setBackground(new java.awt.Color(215, 215, 248));

        staffPwdLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        staffPwdLabel.setText("Staff Password");

        goButton3.setBackground(new java.awt.Color(0, 255, 51));
        goButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        goButton3.setText("Confirm");
        goButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goButton3ActionPerformed(evt);
            }
        });

        cancelButton.setBackground(new java.awt.Color(255, 51, 51));
        cancelButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        staffPwdField.setBackground(new java.awt.Color(215, 215, 248));

        javax.swing.GroupLayout staffPanelLayout = new javax.swing.GroupLayout(staffPanel);
        staffPanel.setLayout(staffPanelLayout);
        staffPanelLayout.setHorizontalGroup(
            staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(staffPanelLayout.createSequentialGroup()
                .addGroup(staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(staffPanelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(staffPanelLayout.createSequentialGroup()
                                .addComponent(goButton3)
                                .addGap(36, 36, 36)
                                .addComponent(cancelButton))
                            .addComponent(staffPwdField)
                            .addComponent(staffIdTextField)))
                    .addGroup(staffPanelLayout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(staffIdLabel))
                    .addGroup(staffPanelLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(staffPwdLabel)))
                .addContainerGap(305, Short.MAX_VALUE))
        );
        staffPanelLayout.setVerticalGroup(
            staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(staffPanelLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(staffIdLabel)
                .addGap(18, 18, 18)
                .addComponent(staffIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(staffPwdLabel)
                .addGap(18, 18, 18)
                .addComponent(staffPwdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(goButton3)
                    .addComponent(cancelButton))
                .addContainerGap(156, Short.MAX_VALUE))
        );

        mainPanel.add(staffPanel, "staffPanel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enterTxIdTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterTxIdTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enterTxIdTextFieldActionPerformed

    private void amountTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amountTextFieldActionPerformed

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        // TODO add your handling code here:
        clearTransactionPage();
        card.show(mainPanel, "staffPanel");
    }//GEN-LAST:event_confirmButtonActionPerformed

    private void ownerTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ownerTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ownerTextFieldActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:
        setTableData();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void goButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goButtonActionPerformed
        // TODO add your handling code here:
        card.show(mainPanel, "transactionPanel");
    }//GEN-LAST:event_goButtonActionPerformed

    private void reportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportButtonActionPerformed
        // TODO add your handling code here:
        clearTransactionPage();
        card.show(mainPanel, "staffPanel");
    }//GEN-LAST:event_reportButtonActionPerformed

    private void goButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goButton3ActionPerformed
        // TODO add your handling code here:
        if (staffIdTextField.getText().isBlank() || staffPwdField.getPassword().length == 0) {
            JOptionPane.showMessageDialog(rootPane, "Please enter both username and password!", "Error", ERROR_MESSAGE);
        } else if (staff.isAuthen(staffIdTextField.getText(), staffPwdField.getPassword())) {
            card.show(mainPanel, "companyPanel");
            clearStaffPage();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Username or password is not correct!", "Error", ERROR_MESSAGE);
        }

    }//GEN-LAST:event_goButton3ActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        clearStaffPage();
        card.show(mainPanel, "transactionPanel");
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void goButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goButton2ActionPerformed
        // TODO add your handling code here:
        try {
            int number = Integer.parseInt(enterTxIdTextField.getText());
            if (!isTxidCorrect(number)) {
                JOptionPane.showMessageDialog(rootPane, "Transaction ID is not found.", "Error", ERROR_MESSAGE);
            }
        } catch (NumberFormatException ne) {
            JOptionPane.showMessageDialog(rootPane, "Transaction ID must be a number!", "Erro", ERROR_MESSAGE);
        }/*
        if (enterTxIdTextField.getText().isBlank() || !isTxidCorrect(Integer.parseInt(enterTxIdTextField.getText()))) {
            JOptionPane.showMessageDialog(rootPane, "Transaction ID is not found.", "Error", ERROR_MESSAGE);
        }*/


    }//GEN-LAST:event_goButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        staff = new StaffAccount();
        staff.addAccount("sky", "skypwd");
        samples = new ArrayList<>();
        samples.add(new Transaction(1134, "Transaction", "SCB", "11111111112", "Luke Skywalker", 65535, 56636));
        samples.add(new Transaction(1335, "Credit", "KTB", "11131313111", "Someone", 99.99, 9.99));
        samples.add(new Transaction(1136, "Transaction", "KBank", "11132332121", "Thayakorn", 32745.75, 32285.5));
        for (int i = 0; i < 50; i++) {
            String type, bank;
            if (i % 5 == 0) {
                bank = "SCB";
            } else if (i % 3 == 0) {
                bank = "TMB";
            } else if (i % 2 == 0) {
                bank = "KBANK";
            } else {
                bank = "KTB";
            }
            if (i % 2 == 0) {
                type = "Transaction";
            } else {
                type = "Credit";
            }
            samples.add(new Transaction(1137 + i, type, bank, "11132334" + i, "Dummy " + i, 100 + i, 50 + i));
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIClass().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accountLabel;
    private javax.swing.JTextField accountTextField;
    private javax.swing.JLabel amountLabel;
    private javax.swing.JTextField amountTextField;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel companyPanel;
    private javax.swing.JButton confirmButton;
    private javax.swing.JLabel enterTxIdLabel;
    private javax.swing.JTextField enterTxIdTextField;
    private javax.swing.JButton goButton;
    private javax.swing.JButton goButton2;
    private javax.swing.JButton goButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel ownerLabel;
    private javax.swing.JTextField ownerTextField;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton reportButton;
    private javax.swing.JLabel staffIdLabel;
    private javax.swing.JTextField staffIdTextField;
    private javax.swing.JPanel staffPanel;
    private javax.swing.JPasswordField staffPwdField;
    private javax.swing.JLabel staffPwdLabel;
    private javax.swing.JLabel tranferLabel;
    private javax.swing.JLabel transactionLabel;
    private javax.swing.JPanel transactionPanel;
    private javax.swing.JTextField transferTextField;
    private javax.swing.JPanel txDetialPanel;
    private javax.swing.JTable txTable;
    // End of variables declaration//GEN-END:variables
}

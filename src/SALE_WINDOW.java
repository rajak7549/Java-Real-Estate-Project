
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Raja
 */
public class SALE_WINDOW extends javax.swing.JFrame {

    /**
     * Creates new form SALE_WINDOW
     */
    public SALE_WINDOW() {
        initComponents();
        
        // 255,51,0
        Border panel_tittle_border = BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(255,10,0));
        jPanel_Tittle.setBorder(panel_tittle_border);
        
        // populate the jtable properties with the propertt id ,ownerid, and price 
        fillJtableProperties();
        
        // populate the jtable client with the client  id ,first name , and  last name  
        fillJtableClient();
        // populate the jtable sales with the sale id ,propertyid ,client id,price,selling date 
        fillJtablesale();
        setTitle("Sale Window");
        
        jTable_Properties.setRowHeight(40);
        jTable_Client.setRowHeight(40);
        jTable_Sale.setRowHeight(40);
        
          //change the jtable selection background
        jTable_Properties.setSelectionBackground(new Color(255, 60 , 0));//27, 150, 77
        jTable_Client.setSelectionBackground(new Color(27, 150, 77));//255, 60 , 0
        jTable_Sale.setSelectionBackground(new Color(0, 70, 0));
          //change th ID column width
        jTable_Properties.getColumnModel().getColumn(0).setPreferredWidth(25);
        jTable_Client.getColumnModel().getColumn(0).setPreferredWidth(25);
        jTable_Sale.setSelectionBackground(new Color(27, 150, 77));
          //change th Address column width
        jTable_Properties.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTable_Client.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTable_Sale.getColumnModel().getColumn(1).setPreferredWidth(250);
    }
    // create a function to populate the jtable with properies data 
    public void fillJtableProperties() {

        P_PROPERTY property = new P_PROPERTY();

        ArrayList<P_PROPERTY> propertyList = property.propertiesList();
           // the jtable colums   0    1       
        String[] colNames = {"ID", "Owner id","Price"};

        //the jtable row
        //owneerList.size()=the 
        Object[][] rows = new Object[propertyList.size()][3];

        // add data from the list to the rows
        for (int i = 0; i < propertyList.size(); i++) {

            rows[i][0] = propertyList.get(i).getId();
            rows[i][1] = propertyList.get(i).getOwnerId();
            rows[i][2] = propertyList.get(i).getPrice();

        }
        DefaultTableModel model = new DefaultTableModel(rows, colNames);
        jTable_Properties.setModel(model);
        
    }
    
    // create a function to populate the jtable with properies data 
    public void fillJtableClient() {

        P_CLIENT client = new P_CLIENT();

        ArrayList<P_CLIENT> clientList = client.clientList();

        // the jtable colums 
        String[] colNames = {"ID", "FirstName", "LastName"};

        //the jtable row
        //owneerList.size()=the 
        Object[][] rows = new Object[clientList.size()][4];

        // add data from the list to the rows
        for (int i = 0; i < clientList.size(); i++) {

            rows[i][0] = clientList.get(i).getId();
            rows[i][1] = clientList.get(i).getFName();
            rows[i][2] = clientList.get(i).getLname();
            rows[i][3] = clientList.get(i).getPhone();

        }
        DefaultTableModel model = new DefaultTableModel(rows, colNames);
        jTable_Client.setModel(model);

    }
    
    // create a function to populate the jtable with properies data 
    public void fillJtablesale() {
        P_SALE sales = new P_SALE();

        ArrayList<P_SALE> saleList = sales.saleList();
        // the jtable colums 
        String[] colNames = {"ID", "Property", "Client", "Price", "Date"};

        //the jtable row
        //owneerList.size()=the 
        Object[][] rows = new Object[saleList.size()][5];

        // add data from the list to the rows
        for (int i = 0; i < saleList.size(); i++) {

            rows[i][0] = saleList.get(i).getId();
            rows[i][1] = saleList.get(i).getPropertyId();
            rows[i][2] = saleList.get(i).getClientId();
            rows[i][3] = saleList.get(i).getFinalPrice();
            rows[i][4] = saleList.get(i).getSellingDate();

        }
        DefaultTableModel model = new DefaultTableModel(rows, colNames);
        jTable_Sale.setModel(model);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel_Tittle = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField_id = new javax.swing.JTextField();
        jTextField_Property_Id = new javax.swing.JTextField();
        jButton_remove_sale = new javax.swing.JButton();
        jButton_add_sale = new javax.swing.JButton();
        jButton_edit_sale = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField_Client_ID = new javax.swing.JTextField();
        jTextField_Final_Price = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Properties = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_Client = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable_Sale = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        JDateChooser_SaleDate = new com.toedter.calendar.JDateChooser();
        jButton_add_sale1 = new javax.swing.JButton();
        jButton_add_sale2 = new javax.swing.JButton();
        jButton_add_sale3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jPanel_Tittle.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setBackground(new java.awt.Color(0, 102, 102));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 204));
        jLabel1.setText("Sale");
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout jPanel_TittleLayout = new javax.swing.GroupLayout(jPanel_Tittle);
        jPanel_Tittle.setLayout(jPanel_TittleLayout);
        jPanel_TittleLayout.setHorizontalGroup(
            jPanel_TittleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_TittleLayout.createSequentialGroup()
                .addGap(503, 503, 503)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_TittleLayout.setVerticalGroup(
            jPanel_TittleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_TittleLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("ID:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("Property ID:");

        jTextField_id.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jTextField_Property_Id.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField_Property_Id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Property_IdActionPerformed(evt);
            }
        });

        jButton_remove_sale.setBackground(new java.awt.Color(255, 0, 0));
        jButton_remove_sale.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_remove_sale.setForeground(new java.awt.Color(255, 255, 255));
        jButton_remove_sale.setText("Remove");
        jButton_remove_sale.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jButton_remove_sale.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_remove_sale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_remove_saleActionPerformed(evt);
            }
        });

        jButton_add_sale.setBackground(new java.awt.Color(0, 204, 0));
        jButton_add_sale.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_add_sale.setForeground(new java.awt.Color(255, 255, 255));
        jButton_add_sale.setText("Add");
        jButton_add_sale.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jButton_add_sale.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_add_sale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_add_saleActionPerformed(evt);
            }
        });

        jButton_edit_sale.setBackground(new java.awt.Color(0, 153, 255));
        jButton_edit_sale.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_edit_sale.setForeground(new java.awt.Color(255, 255, 255));
        jButton_edit_sale.setText("Edit");
        jButton_edit_sale.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jButton_edit_sale.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_edit_sale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_edit_saleActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setText("Client ID:");

        jTextField_Client_ID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField_Client_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Client_IDActionPerformed(evt);
            }
        });

        jTextField_Final_Price.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField_Final_Price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Final_PriceActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel6.setText("Final Price:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel7.setText("Date:");

        jTable_Properties.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable_Properties.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_PropertiesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_Properties);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel8.setText("Properties List ");

        jTable_Client.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable_Client.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_ClientMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable_Client);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel9.setText("Client List ");

        jTable_Sale.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable_Sale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_SaleMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable_Sale);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel10.setText("Sale List ");

        JDateChooser_SaleDate.setDateFormatString("dd/MM/YYYY");

        jButton_add_sale1.setBackground(new java.awt.Color(0, 204, 0));
        jButton_add_sale1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_add_sale1.setForeground(new java.awt.Color(255, 255, 255));
        jButton_add_sale1.setText("Refresh");
        jButton_add_sale1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jButton_add_sale1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_add_sale1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_add_sale1ActionPerformed(evt);
            }
        });

        jButton_add_sale2.setBackground(new java.awt.Color(0, 204, 0));
        jButton_add_sale2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_add_sale2.setForeground(new java.awt.Color(255, 255, 255));
        jButton_add_sale2.setText("Refresh");
        jButton_add_sale2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jButton_add_sale2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_add_sale2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_add_sale2ActionPerformed(evt);
            }
        });

        jButton_add_sale3.setBackground(new java.awt.Color(0, 204, 0));
        jButton_add_sale3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_add_sale3.setForeground(new java.awt.Color(255, 255, 255));
        jButton_add_sale3.setText("Refresh");
        jButton_add_sale3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jButton_add_sale3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_add_sale3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_add_sale3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_Tittle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField_Client_ID, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_Property_Id, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_Final_Price)
                            .addComponent(jTextField_id, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JDateChooser_SaleDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton_edit_sale, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_add_sale, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_remove_sale, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButton_add_sale1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButton_add_sale2, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_add_sale3, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel_Tittle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_Property_Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_Client_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField_Final_Price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(JDateChooser_SaleDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addComponent(jButton_add_sale, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_edit_sale, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jButton_remove_sale, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_add_sale1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_add_sale2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_add_sale3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_Property_IdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Property_IdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Property_IdActionPerformed

    private void jButton_remove_saleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_remove_saleActionPerformed
        
        // remove the selected sale  
        int id = Integer.valueOf(jTextField_id.getText());

        if (new P_SALE().deleteSale(id)) {
            JOptionPane.showMessageDialog(null, "Sale Data Has Been Deleted", "Deleted sale", 1);
        } else {
            JOptionPane.showMessageDialog(null, "Sale is Not Deleted ", "Deleted sale", 2);
        }
        
    }//GEN-LAST:event_jButton_remove_saleActionPerformed

    private void jButton_add_saleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_add_saleActionPerformed

        // add a new sale 
        //int id = Integer.valueOf(jTextField_id.getText());
        int propertyId = Integer.valueOf(jTextField_Property_Id.getText());
        int clientid = Integer.valueOf(jTextField_Client_ID.getText());
        String finalPrice = jTextField_Final_Price.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String sellingDate = dateFormat.format(JDateChooser_SaleDate.getDate());

        P_SALE sale=new P_SALE(0, propertyId, clientid, finalPrice, sellingDate);// this is original sale 
        if (new P_SALE().addNewSale(sale)) {
            JOptionPane.showMessageDialog(null, "A new Sale Has Been Created And Added ", "Add sale", 1);
        } else {
            JOptionPane.showMessageDialog(null, "Sale is Not Created ", "Add sale", 2);
        }
         
    }//GEN-LAST:event_jButton_add_saleActionPerformed

    private void jButton_edit_saleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_edit_saleActionPerformed

        // edit the selected sale  
        int id = Integer.valueOf(jTextField_id.getText());
        int propertyId = Integer.valueOf(jTextField_Property_Id.getText());
        int clientid = Integer.valueOf(jTextField_Client_ID.getText());
        String finalPrice = jTextField_Final_Price.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String sellingDate = dateFormat.format(JDateChooser_SaleDate.getDate());

        P_SALE sale=new P_SALE(id, propertyId, clientid, finalPrice, sellingDate);// this is original sale 

        if (new P_SALE().editsaleData(sale)) {
            JOptionPane.showMessageDialog(null, "Sale Data Has Been Updated", "Edit sale", 1);
        } else {
            JOptionPane.showMessageDialog(null, "Sale is Not Updated ", "Edit sale", 2);
        }
      
    }//GEN-LAST:event_jButton_edit_saleActionPerformed

    private void jTextField_Client_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Client_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Client_IDActionPerformed

    private void jTextField_Final_PriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Final_PriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Final_PriceActionPerformed

    private void jTable_PropertiesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_PropertiesMouseClicked

        int selectedRowIndex = jTable_Properties.getSelectedRow();
        jTextField_id.setText(jTable_Properties.getValueAt(selectedRowIndex, 0).toString());
        jTextField_Property_Id.setText(jTable_Properties.getValueAt(selectedRowIndex, 1).toString());
        jTextField_Final_Price.setText(jTable_Properties.getValueAt(selectedRowIndex, 2).toString());
        
    }//GEN-LAST:event_jTable_PropertiesMouseClicked

    private void jTable_ClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ClientMouseClicked
        // TODO add your handling code here:
        int selectedRowIndex = jTable_Client.getSelectedRow();
        jTextField_Client_ID.setText(jTable_Client.getValueAt(selectedRowIndex, 0).toString());
    }//GEN-LAST:event_jTable_ClientMouseClicked

    private void jTable_SaleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_SaleMouseClicked
        // TODO add your handling code here:
        int selectedRowIndex=jTable_Sale.getSelectedRow();
        jTextField_id.setText(jTable_Sale.getValueAt(selectedRowIndex, 0).toString());
        jTextField_Property_Id.setText(jTable_Sale.getValueAt(selectedRowIndex, 1).toString());
        jTextField_Client_ID.setText(jTable_Sale.getValueAt(selectedRowIndex, 2).toString());
        jTextField_Final_Price.setText(jTable_Sale.getValueAt(selectedRowIndex, 3).toString());
        
        // display the data in jdatechooser
        
        Date saleData;
        try {
            saleData = new SimpleDateFormat("yyyy-MM-dd").parse(jTable_Sale.getValueAt(selectedRowIndex, 4).toString());
            JDateChooser_SaleDate.setDate(saleData);
        } catch (ParseException ex) {
            Logger.getLogger(SALE_WINDOW.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }//GEN-LAST:event_jTable_SaleMouseClicked

    private void jButton_add_sale1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_add_sale1ActionPerformed
        // TODO add your handling code here:
        fillJtablesale();
    }//GEN-LAST:event_jButton_add_sale1ActionPerformed

    private void jButton_add_sale2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_add_sale2ActionPerformed
        // TODO add your handling code here:
        // fetch the client data from the Jtable 
        
        fillJtableClient();
        
    }//GEN-LAST:event_jButton_add_sale2ActionPerformed

    private void jButton_add_sale3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_add_sale3ActionPerformed
        // TODO add your handling code here
        // inthis we refresh the data bse from the jtable properties
        fillJtableProperties();
    }//GEN-LAST:event_jButton_add_sale3ActionPerformed

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
            java.util.logging.Logger.getLogger(SALE_WINDOW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SALE_WINDOW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SALE_WINDOW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SALE_WINDOW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SALE_WINDOW().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser JDateChooser_SaleDate;
    private javax.swing.JButton jButton_add_sale;
    private javax.swing.JButton jButton_add_sale1;
    private javax.swing.JButton jButton_add_sale2;
    private javax.swing.JButton jButton_add_sale3;
    private javax.swing.JButton jButton_edit_sale;
    private javax.swing.JButton jButton_remove_sale;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel_Tittle;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable_Client;
    private javax.swing.JTable jTable_Properties;
    private javax.swing.JTable jTable_Sale;
    private javax.swing.JTextField jTextField_Client_ID;
    private javax.swing.JTextField jTextField_Final_Price;
    private javax.swing.JTextField jTextField_Property_Id;
    private javax.swing.JTextField jTextField_id;
    // End of variables declaration//GEN-END:variables
}

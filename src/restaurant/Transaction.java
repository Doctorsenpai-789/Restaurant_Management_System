/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import static java.lang.Integer.parseInt;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author 2ndyrGroupA
 */
public class Transaction extends javax.swing.JInternalFrame {

    /**
     * Creates new form Sales
     */
    public Transaction() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);
        data();
        data2();
        
        table.getTableHeader().setFont(new Font("Leelawadee",Font.BOLD,12));
        table.getTableHeader().setOpaque(false);
        table.getTableHeader().setBackground(new Color(32,136,203));
        table.getTableHeader().setForeground(new Color(255,255,255));
        
     //   String selected = String.valueOf(jComboBox1.getSelectedItem());
    }

     Connection con;
    PreparedStatement insert;

    public void data() {
        int count;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_db", "root", "");

            insert = con.prepareStatement("select * from product");
            ResultSet result = insert.executeQuery();
            ResultSetMetaData datas = result.getMetaData();
            count = datas.getColumnCount();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            while (result.next()) {
                Vector info = new Vector();

                for (int a = 1; a <= count; a++) {
                    //info.add(result.getString("id"));
                    info.add(result.getString("product_name"));
                    info.add(result.getString("product_price"));

                }

                model.addRow(info);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
     public void data2() {
        int count;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_db", "root", "");

            insert = con.prepareStatement("select * from orders");
            ResultSet result = insert.executeQuery();
            ResultSetMetaData datas = result.getMetaData();
            count = datas.getColumnCount();
            DefaultTableModel model = (DefaultTableModel) table2.getModel();
            model.setRowCount(0);

            while (result.next()) {
                Vector info = new Vector();

                for (int a = 1; a <= count; a++) {
                    info.add(result.getString("id"));
                    info.add(result.getString("table_number"));
                    info.add(result.getString("menu"));
                    info.add(result.getString("price"));
                    info.add(result.getString("quantity"));
                    info.add(result.getString("total"));
                    info.add(result.getString("status"));

                }

                model.addRow(info);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        productname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        productprice = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        DELIVER = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        Confirm = new javax.swing.JButton();
        quantitylbl1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        tablenoTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        searchbtn = new javax.swing.JButton();
        paymentbtn = new javax.swing.JButton();
        payment = new javax.swing.JTextField();
        resetbtn = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(610, 402));

        jLabel3.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/image/purchase-order-32.png"))); // NOI18N
        jLabel3.setText("MENU :");

        productname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productnameActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/image/sale-32.png"))); // NOI18N
        jLabel4.setText("Price:");

        productprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productpriceActionPerformed(evt);
            }
        });

        btnCreate.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        btnCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/image/add-list-32.png"))); // NOI18N
        btnCreate.setText("ADD");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        DELIVER.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        DELIVER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/image/waiter-32.png"))); // NOI18N
        DELIVER.setText("DELIVER");
        DELIVER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELIVERActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/image/cancel-32.png"))); // NOI18N
        btnDelete.setText("CANCEL");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        table.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MENU", "PRICE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "TABLE NO.", "MENU", "PRICE", "QUANTITY", "TOTAL", "STATUS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table2);

        Confirm.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        Confirm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/image/check-32.png"))); // NOI18N
        Confirm.setText("CONFIRM");
        Confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmActionPerformed(evt);
            }
        });

        quantitylbl1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantitylbl1ActionPerformed(evt);
            }
        });

        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField3.setText("QUANTITY :");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        tablenoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tablenoTextFieldActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/image/table-32.png"))); // NOI18N
        jLabel1.setText("TABLE NO.");

        searchbtn.setText("search table");
        searchbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                searchbtnMousePressed(evt);
            }
        });

        paymentbtn.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        paymentbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/image/list-ingredients-32.png"))); // NOI18N
        paymentbtn.setText("payment");
        paymentbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentbtnActionPerformed(evt);
            }
        });

        resetbtn.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        resetbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/image/settings-13-32.png"))); // NOI18N
        resetbtn.setText("RESET");
        resetbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(resetbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(paymentbtn)
                        .addGap(18, 18, 18)
                        .addComponent(payment, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(searchbtn)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3))
                                        .addGap(34, 34, 34)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(productprice)
                                            .addComponent(productname)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(quantitylbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tablenoTextField)))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Confirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(DELIVER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(productname, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Confirm))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(productprice, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(quantitylbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tablenoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(DELIVER, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resetbtn)
                    .addComponent(paymentbtn)
                    .addComponent(payment, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(214, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void productnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productnameActionPerformed

    private void productpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productpriceActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        if (tablenoTextField.getText().isEmpty()||productname.getText().isEmpty() || productprice.getText().isEmpty() ) {
            JOptionPane.showMessageDialog(this, "Please fill in all required fields");
        } else {

            try {
                Class.forName("com.mysql.jdbc.Driver"); //load the driver
                //Connection con = DriverManager.getConnection("jdbc:mysql://192.168.0.2/torresRa", "torresRa", "ravenAccess");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_db", "root", "");
                Statement stmt = (Statement) con.createStatement(); //get the connection stream(connection port)
                int price = parseInt(productprice.getText());
                int quantity = parseInt(quantitylbl1.getText());
                int total = price * quantity;
                
                String query = "INSERT INTO `orders`(`table_number`,`menu`,`price`,`quantity`,`total`,`status`) VALUES ('" + this.tablenoTextField.getText() + "','" + this.productname.getText() + "','" + this.productprice.getText() + "','" + this.quantitylbl1.getText() + "','" +total+ "','pending')";
                stmt.executeUpdate(query);
                con.close();
                JOptionPane.showMessageDialog(this, "Successfully Added.");
                data();
                data2();

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void DELIVERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELIVERActionPerformed

//        if (productname.getText().isEmpty() || productprice.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Please fill in all required fields");
//            int i = Integer.parseInt(productname.getText());
//            System.out.println(i);
//        } else {

            DefaultTableModel model = (DefaultTableModel) table2.getModel();
            int selectedIndex = table2.getSelectedRow();
            int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
            String st = model.getValueAt(selectedIndex, 6).toString();
            if ("confirmed".equals(st)){
            try {

                //int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
              
                System.out.println(id);
                Class.forName("com.mysql.jdbc.Driver");
                //con = DriverManager.getConnection("jdbc:mysql://192.168.0.2/torresRa", "torresRa", "ravenAccess");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_db", "root", "");
                insert = con.prepareStatement("UPDATE orders SET status=? WHERE id=?");

              //  insert.setString(1, productName);
                insert.setString(1,"delivered");
                insert.setInt(2, id);

                insert.executeUpdate();
                JOptionPane.showMessageDialog(this, "Succesfully Deliver");

                data();
                data2();

                con.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } else{
             JOptionPane.showMessageDialog(this, "you need to confirm first");

            }
    }//GEN-LAST:event_DELIVERActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        DefaultTableModel model = (DefaultTableModel) table2.getModel();
        int selectedIndex = table2.getSelectedRow();

        try {

            int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
            int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to cancel this order?", "Warning", JOptionPane.YES_NO_OPTION);

            if (dialogResult == JOptionPane.YES_OPTION) {

                Class.forName("com.mysql.jdbc.Driver");
                //con = DriverManager.getConnection("jdbc:mysql://192.168.0.2/torresRa", "torresRa", "ravenAccess");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_db", "root", "");
                insert = con.prepareStatement("DELETE FROM orders WHERE id=? ");

                insert.setInt(1, id);

                insert.executeUpdate();
                JOptionPane.showMessageDialog(this, "Succesfully Deleted");

                data();
                data2();

                con.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int selectedIndex = table.getSelectedRow();

        productname.setText(model.getValueAt(selectedIndex, 0).toString());
        productprice.setText(model.getValueAt(selectedIndex, 1).toString());
    }//GEN-LAST:event_tableMouseClicked

    private void table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table2MouseClicked
        DefaultTableModel model = (DefaultTableModel) table2.getModel();
        int selectedIndex = table2.getSelectedRow();
        
        tablenoTextField.setText(model.getValueAt(selectedIndex, 1).toString());
        productname.setText(model.getValueAt(selectedIndex, 2).toString());
        productprice.setText(model.getValueAt(selectedIndex, 3).toString());
        quantitylbl1.setText(model.getValueAt(selectedIndex, 4).toString());
        payment.setText(model.getValueAt(selectedIndex, 5).toString());
       //w id.setText(model.getValueAt(selectedIndex, 0).toString());
        
    }//GEN-LAST:event_table2MouseClicked

    private void ConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmActionPerformed
         DefaultTableModel model = (DefaultTableModel) table2.getModel();
            int selectedIndex = table2.getSelectedRow();
            int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
            String st = model.getValueAt(selectedIndex, 6).toString();
            if ("pending".equals(st)){
                
                
                try {
                

                
              
                System.out.println(id);
                Class.forName("com.mysql.jdbc.Driver");
                //con = DriverManager.getConnection("jdbc:mysql://192.168.0.2/torresRa", "torresRa", "ravenAccess");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_db", "root", "");
                insert = con.prepareStatement("UPDATE orders SET status=? WHERE id=?");

              //  insert.setString(1, productName);
              
                insert.setString(1,"confirmed");
                insert.setInt(2, id);

                insert.executeUpdate();
                JOptionPane.showMessageDialog(this, "Succesfully Confirmed");

                data();
                data2();

                con.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

                         
                         
                         
            }
            else{
             JOptionPane.showMessageDialog(this, "Invalid operation");
            }
    }//GEN-LAST:event_ConfirmActionPerformed

    private void quantitylbl1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantitylbl1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantitylbl1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void tablenoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tablenoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tablenoTextFieldActionPerformed

    private void searchbtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbtnMousePressed
          DefaultTableModel model = (DefaultTableModel) table2.getModel();
          TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
          table2.setRowSorter(tr);
          tr.setRowFilter(RowFilter.regexFilter(search.getText().trim()));
    }//GEN-LAST:event_searchbtnMousePressed

    private void paymentbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentbtnActionPerformed
        DefaultTableModel model = (DefaultTableModel) table2.getModel();
            int selectedIndex = table2.getSelectedRow();
            int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
            String st = model.getValueAt(selectedIndex, 6).toString();
            if ("delivered".equals(st)){
                
                
                try {
                

                
              
                System.out.println(id);
                Class.forName("com.mysql.jdbc.Driver");
                //con = DriverManager.getConnection("jdbc:mysql://192.168.0.2/torresRa", "torresRa", "ravenAccess");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_db", "root", "");
                insert = con.prepareStatement("UPDATE orders SET status=? WHERE id=?");

              //  insert.setString(1, productName);
              
                insert.setString(1,"paid na ");
                insert.setInt(2, id);

                insert.executeUpdate();
                JOptionPane.showMessageDialog(this, "Succesfully Paid");

                data();
                data2();

                con.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

                         
                         
                         
            }
            else{
             JOptionPane.showMessageDialog(this, "Invalid operation");
            }
    }//GEN-LAST:event_paymentbtnActionPerformed

    private void resetbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbtnActionPerformed
        productname.setText(null);
        productprice.setText(null);
        quantitylbl1.setText(null);
        tablenoTextField.setText(null);
        payment.setText(null);
        

    }//GEN-LAST:event_resetbtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Confirm;
    private javax.swing.JButton DELIVER;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField payment;
    private javax.swing.JButton paymentbtn;
    private javax.swing.JTextField productname;
    private javax.swing.JTextField productprice;
    private javax.swing.JTextField quantitylbl1;
    private javax.swing.JButton resetbtn;
    private javax.swing.JTextField search;
    private javax.swing.JButton searchbtn;
    private javax.swing.JTable table;
    private javax.swing.JTable table2;
    private javax.swing.JTextField tablenoTextField;
    // End of variables declaration//GEN-END:variables
}

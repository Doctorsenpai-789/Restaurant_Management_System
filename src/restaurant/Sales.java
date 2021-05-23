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
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 2ndyrGroupA
 */
public class Sales extends javax.swing.JInternalFrame {

    /**
     * Creates new form Sales
     */
    public Sales() {
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
        jTextField1 = new javax.swing.JTextField();
        payment = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        quantitylbl1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        Confirm = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(610, 402));

        jLabel3.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\2ndyrGroupA\\Downloads\\product-32.png")); // NOI18N
        jLabel3.setText("MENU :");

        productname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productnameActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\2ndyrGroupA\\Downloads\\best-price-badge-32.png")); // NOI18N
        jLabel4.setText("Price:");

        productprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productpriceActionPerformed(evt);
            }
        });

        btnCreate.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        btnCreate.setIcon(new javax.swing.ImageIcon("C:\\Users\\2ndyrGroupA\\Downloads\\add-list-32.png")); // NOI18N
        btnCreate.setText("ADD");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        DELIVER.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        DELIVER.setIcon(new javax.swing.ImageIcon("C:\\Users\\2ndyrGroupA\\Downloads\\waiter-32.png")); // NOI18N
        DELIVER.setText("DELIVER");
        DELIVER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELIVERActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon("C:\\Users\\2ndyrGroupA\\Downloads\\cancel-32.png")); // NOI18N
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

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField1.setText("QUANTITY");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        payment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentActionPerformed(evt);
            }
        });

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "MENU", "PRICE", "QUANTITY", "TOTAL", "STATUS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
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

        quantitylbl1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantitylbl1ActionPerformed(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField2.setText("PAYMENT");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        Confirm.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        Confirm.setIcon(new javax.swing.ImageIcon("C:\\Users\\2ndyrGroupA\\Downloads\\check-32.png")); // NOI18N
        Confirm.setText("CONFIRM");
        Confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(productname, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Confirm))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(quantitylbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(productprice, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(DELIVER, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                            .addComponent(btnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(payment, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(productname, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Confirm))
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(productprice, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(quantitylbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DELIVER))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(payment, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(104, 104, 104))
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
        if (productname.getText().isEmpty() || productprice.getText().isEmpty() || quantitylbl1.getText().isEmpty()) {
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
                
                String query = "INSERT INTO `orders`(`menu`,`price`,`quantity`,`total`,`status`) VALUES ('" + this.productname.getText() + "','" + this.productprice.getText() + "','" + this.quantitylbl1.getText() + "','" +total+ "','pending')";
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
            String st = model.getValueAt(selectedIndex, 5).toString();
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
            int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to delete this order?", "Warning", JOptionPane.YES_NO_OPTION);

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

    private void paymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paymentActionPerformed

    private void table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table2MouseClicked
        DefaultTableModel model = (DefaultTableModel) table2.getModel();
        int selectedIndex = table2.getSelectedRow();
        
        productname.setText(model.getValueAt(selectedIndex, 0).toString());
        productprice.setText(model.getValueAt(selectedIndex, 1).toString());
        quantitylbl1.setText(model.getValueAt(selectedIndex, 2).toString());
        
    }//GEN-LAST:event_table2MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void quantitylbl1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantitylbl1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantitylbl1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void ConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmActionPerformed
         DefaultTableModel model = (DefaultTableModel) table2.getModel();
            int selectedIndex = table2.getSelectedRow();
            int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
            String st = model.getValueAt(selectedIndex, 5).toString();
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Confirm;
    private javax.swing.JButton DELIVER;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField payment;
    private javax.swing.JTextField productname;
    private javax.swing.JTextField productprice;
    private javax.swing.JTextField quantitylbl1;
    private javax.swing.JTable table;
    private javax.swing.JTable table2;
    // End of variables declaration//GEN-END:variables
}

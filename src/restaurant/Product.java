/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 2ndyrGroupA
 */
public class Product extends javax.swing.JInternalFrame {

    /**
     * Creates new form Product
     */
    public Product() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);
        data();
        
        table.getTableHeader().setFont(new Font("Leelawadee",Font.BOLD,12));
        table.getTableHeader().setOpaque(false);
        table.getTableHeader().setBackground(new Color(32,136,203));
        table.getTableHeader().setForeground(new Color(255,255,255));
        
        
        
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
                    info.add(result.getString("id"));
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        productname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        productprice = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        resetbtn = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(610, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        productname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productnameActionPerformed(evt);
            }
        });
        getContentPane().add(productname, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 204, 38));

        jLabel3.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\2ndyrGroupA\\Downloads\\product-32.png")); // NOI18N
        jLabel3.setText("MENU :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 110, 40));

        jLabel4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\2ndyrGroupA\\Downloads\\best-price-badge-32.png")); // NOI18N
        jLabel4.setText("Price:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 110, 40));

        productprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productpriceActionPerformed(evt);
            }
        });
        getContentPane().add(productprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 204, 38));

        btnCreate.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        btnCreate.setIcon(new javax.swing.ImageIcon("C:\\Users\\2ndyrGroupA\\Downloads\\add-list-32.png")); // NOI18N
        btnCreate.setText("ADD");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        getContentPane().add(btnCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 100, -1));

        btnUpdate.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon("C:\\Users\\2ndyrGroupA\\Downloads\\edit-property-32.png")); // NOI18N
        btnUpdate.setText("EDIT");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 120, 40));

        btnDelete.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon("C:\\Users\\2ndyrGroupA\\Downloads\\delete-32.png")); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 120, 40));

        table.setBackground(new java.awt.Color(240, 240, 240));
        table.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " ID", "MENU", "PRICE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table.setGridColor(new java.awt.Color(255, 153, 102));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 470, 170));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 70, 390));

        resetbtn.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        resetbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/image/settings-13-32.png"))); // NOI18N
        resetbtn.setText("RESET");
        resetbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetbtnActionPerformed(evt);
            }
        });
        getContentPane().add(resetbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 110, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        if (productname.getText().isEmpty() || productprice.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all required fields");
        } else {

            try {
                Class.forName("com.mysql.jdbc.Driver"); //load the driver
                //Connection con = DriverManager.getConnection("jdbc:mysql://192.168.0.2/torresRa", "torresRa", "ravenAccess");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_db", "root", "");
                Statement stmt = (Statement) con.createStatement(); //get the connection stream(connection port)

                String query = "INSERT INTO `product`(`product_name`,`product_price`) VALUES ('" + this.productname.getText() + "','" + this.productprice.getText() + "')";
                stmt.executeUpdate(query);
                con.close();
                JOptionPane.showMessageDialog(this, "Successfully Added.");
                data();

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
       
        if (productname.getText().isEmpty() || productprice.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all required fields");
            int i = Integer.parseInt(productname.getText());
            System.out.println(i);
        } else {
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int selectedIndex = table.getSelectedRow();

        try {

            int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
            String productName = productname.getText();
            String productPrice = productprice.getText();

            Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://192.168.0.2/torresRa", "torresRa", "ravenAccess");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_db", "root", "");
            insert = con.prepareStatement("UPDATE product SET product_name= ? , product_price=? WHERE id=?");

            insert.setString(1, productName);
            insert.setString(2, productPrice);
            insert.setInt(3, id);

            insert.executeUpdate();
            JOptionPane.showMessageDialog(this, "Succesfully Updated");

            data();

            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int selectedIndex = table.getSelectedRow();

        try {

            int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
            int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to delete the product?", "Warning", JOptionPane.YES_NO_OPTION);

            if (dialogResult == JOptionPane.YES_OPTION) {

                Class.forName("com.mysql.jdbc.Driver");
                //con = DriverManager.getConnection("jdbc:mysql://192.168.0.2/torresRa", "torresRa", "ravenAccess");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_db", "root", "");
                insert = con.prepareStatement("DELETE FROM product WHERE id=? ");

                insert.setInt(1, id);

                insert.executeUpdate();
                JOptionPane.showMessageDialog(this, "Succesfully Deleted");

                data();

                con.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int selectedIndex = table.getSelectedRow();

        productname.setText(model.getValueAt(selectedIndex, 1).toString());
        productprice.setText(model.getValueAt(selectedIndex, 2).toString());

    }//GEN-LAST:event_tableMouseClicked

    private void productpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productpriceActionPerformed

    private void productnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productnameActionPerformed

    private void resetbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbtnActionPerformed
      productname.setText(null);
      productprice.setText(null);
     
    }//GEN-LAST:event_resetbtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField productname;
    private javax.swing.JTextField productprice;
    private javax.swing.JButton resetbtn;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}

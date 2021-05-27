/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author 2ndyrGroupA
 */
public class Dashboard extends javax.swing.JInternalFrame {

    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);
        sales();
        pending();
        deliverOrder();
    }

    Connection con;
    PreparedStatement stmt,stmt1;

    public void sales() {
        int MILLIS_IN_DAY = 1000 * 60 * 60 * 24;
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date todDate = new java.sql.Date(utilDate.getTime());
        java.sql.Date prevDate = new java.sql.Date(utilDate.getTime() - MILLIS_IN_DAY);
        System.out.println(todDate);
        System.out.println(prevDate);
        try {

            Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://192.168.0.2/torresRa", "torresRa", "ravenAccess");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_db", "root", "");
            stmt = con.prepareStatement("SELECT sum(total) as grandTotal FROM orders WHERE created_at = '"+todDate+"'");
           stmt1 = con.prepareStatement("SELECT sum(total) as grandTotal FROM orders WHERE created_at = '"+prevDate+"'");
           
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                
                int saleToday = rs.getInt("grandTotal");
                System.out.println(Integer.toString(saleToday));
                salesToday.setText(Integer.toString(saleToday));
            }
            
            ResultSet rs1 = stmt1.executeQuery();
            if (rs1.next() ) {
                int saleToday = rs.getInt("grandTotal");
                int prev = rs1.getInt("grandTotal");
                int total = prev+saleToday;
               
                prevSales.setText(Integer.toString(prev));
                
               totalsales.setText(Integer.toString(total));
           }
           //   ResultSet rs2 = stmt.executeQuery();
           
           
           
           
            
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
       }

    }
    
    
    public void pending() {
        int MILLIS_IN_DAY = 1000 * 60 * 60 * 24;
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date todDate = new java.sql.Date(utilDate.getTime());
        java.sql.Date prevDate = new java.sql.Date(utilDate.getTime() - MILLIS_IN_DAY);
        System.out.println(todDate);
        System.out.println(prevDate);
        try {

            Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://192.168.0.2/torresRa", "torresRa", "ravenAccess");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_db", "root", "");
            stmt = con.prepareStatement("SELECT count(status) as pendingTotal FROM orders WHERE  status = 'pending' AND created_at = '"+todDate+"'");
           stmt1 = con.prepareStatement("SELECT count(status) as pendingTotal FROM orders WHERE status = 'pending' AND created_at = '"+prevDate+"'");
           
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                
                int pending = rs.getInt("pendingTotal");
                
                System.out.println(Integer.toString(pending));
                pendingToday.setText(Integer.toString(pending));
            }
            
            ResultSet rs1 = stmt1.executeQuery();
            if (rs1.next() ) {
                int pending = rs.getInt("pendingTotal");
                int prevs = rs1.getInt("pendingTotal");
                int total = prevs+pending;
               
                pendingYesterday.setText(Integer.toString(prevs));
                
               result.setText(Integer.toString(total));
           }
           //   ResultSet rs2 = stmt.executeQuery();
           
           
           
           
            
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
       }

    }
    
       public void deliverOrder() {
        int MILLIS_IN_DAY = 1000 * 60 * 60 * 24;
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date todDate = new java.sql.Date(utilDate.getTime());
        java.sql.Date prevDate = new java.sql.Date(utilDate.getTime() - MILLIS_IN_DAY);
        System.out.println(todDate);
        System.out.println(prevDate);
        try {

            Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://192.168.0.2/torresRa", "torresRa", "ravenAccess");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_db", "root", "");
            stmt = con.prepareStatement("SELECT count(status) as deliverTotal FROM orders WHERE  status = 'delivered' AND created_at = '"+todDate+"'");
           stmt1 = con.prepareStatement("SELECT count(status) as deliverTotal FROM orders WHERE  status = 'delivered' AND created_at = '"+prevDate+"'");
           
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                
                int deliverkaron = rs.getInt("deliverTotal");
                
                System.out.println(Integer.toString(deliverkaron));
                deliverToday.setText(Integer.toString(deliverkaron));
            }
            
            ResultSet rs1 = stmt1.executeQuery();
            if (rs1.next() ) {
                int deliverkaron = rs.getInt("deliverTotal");
                int deliverkahapon = rs1.getInt("deliverTotal");
                int total = deliverkahapon+deliverkaron;
               
                deliverYesterday.setText(Integer.toString(deliverkahapon));
                
               totalDeliver.setText(Integer.toString(total));
           }
           //   ResultSet rs2 = stmt.executeQuery();
           
           
           
           
            
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
       }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        salesToday = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        prevSales = new javax.swing.JLabel();
        totalsales = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        pendingYes = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        pendingToday = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        pendingYesterday = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        deliverToday = new javax.swing.JLabel();
        deliverYesterday = new javax.swing.JLabel();
        result = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        totalDeliver = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(610, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Monotype Corsiva", 1, 24)); // NOI18N
        jLabel1.setText("WELCOME ADMIN");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 240, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\2ndyrGroupA\\Downloads\\sale-32.png")); // NOI18N
        jLabel2.setText("SALES  ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 120, 50));
        getContentPane().add(salesToday, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 30, 20));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/image/delivery-food-32.png"))); // NOI18N
        jLabel4.setText("Deliver Order");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 150, -1));

        jLabel5.setText("Yesterday");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        prevSales.setText("19");
        getContentPane().add(prevSales, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, -1, -1));

        totalsales.setText("38");
        getContentPane().add(totalsales, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, -1, -1));

        jLabel8.setText("Total");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\2ndyrGroupA\\Downloads\\purchase-order-32.png")); // NOI18N
        jLabel9.setText(" Pending Order");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, -1, -1));

        jInternalFrame1.setMinimumSize(new java.awt.Dimension(610, 400));
        jInternalFrame1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setText("WELCOME ADMIN");
        jInternalFrame1.getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, 300, 50));

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\2ndyrGroupA\\Downloads\\sale-32.png")); // NOI18N
        jLabel11.setText("SALES  ");
        jInternalFrame1.getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 170, 50));

        jLabel12.setText("19");
        jInternalFrame1.getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, -1));

        jLabel13.setText("Today");
        jInternalFrame1.getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel14.setText("Yesterday");
        jInternalFrame1.getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jLabel15.setText("19");
        jInternalFrame1.getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, -1, -1));

        jLabel16.setText("38");
        jInternalFrame1.getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, -1, -1));

        jLabel17.setText("Total");
        jInternalFrame1.getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        jLabel18.setIcon(new javax.swing.ImageIcon("C:\\Users\\2ndyrGroupA\\Downloads\\purchase-order-32.png")); // NOI18N
        jLabel18.setText(" Pending Order");
        jInternalFrame1.getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, -1, -1));

        getContentPane().add(jInternalFrame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pendingYes.setText("Yesterday");
        getContentPane().add(pendingYes, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, -1, -1));

        jLabel20.setText("Total");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, -1, -1));

        pendingToday.setText("51");
        getContentPane().add(pendingToday, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, -1, -1));

        jLabel22.setText("Today");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

        jLabel23.setText("Today");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, -1, -1));

        pendingYesterday.setText("23");
        getContentPane().add(pendingYesterday, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, -1, -1));

        jLabel25.setText("Yesterday");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, -1, -1));

        jLabel26.setText("Total");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, -1, -1));

        deliverToday.setText("60");
        getContentPane().add(deliverToday, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, -1, -1));

        deliverYesterday.setText("30");
        getContentPane().add(deliverYesterday, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, -1, -1));

        result.setText("74");
        getContentPane().add(result, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, -1, -1));

        jLabel30.setText("Today");
        getContentPane().add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, -1, -1));

        totalDeliver.setText("90");
        getContentPane().add(totalDeliver, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel deliverToday;
    private javax.swing.JLabel deliverYesterday;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel pendingToday;
    private javax.swing.JLabel pendingYes;
    private javax.swing.JLabel pendingYesterday;
    private javax.swing.JLabel prevSales;
    private javax.swing.JLabel result;
    private javax.swing.JLabel salesToday;
    private javax.swing.JLabel totalDeliver;
    private javax.swing.JLabel totalsales;
    // End of variables declaration//GEN-END:variables
}

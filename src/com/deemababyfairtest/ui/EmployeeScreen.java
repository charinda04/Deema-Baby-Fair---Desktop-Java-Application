package com.deemababyfairtest.ui;

import com.deemababyfairtest.connecor.JavaConnect;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Charinda
 */
public class EmployeeScreen extends javax.swing.JFrame {

    /**
     * Creates new form EmployeeScreen
     */
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    
    int month;
    int year;
    int day;
    int second;
    int minute;
    int hour;
    
    int count;
    int count1;
    int updateSales;
    int updateOrderProduct;
    int updateSupplier;
    int row;
    double tot,sum;
    int orderReceivedCount=0;
    
    String up,dg;
    String gender;
    String paymentStatus;
    String orderid;
    String pid; // keeps the selected Prduct id in price setting table
    String cid;
    String cash;
    double change;
    
    ArrayList<Double> list = new ArrayList<>();
    ArrayList<List<String>> list1 = new ArrayList<>();
    
    DefaultTableModel model; 
    
    public EmployeeScreen() {

        
        try {
            initComponents();
            conn = JavaConnect.ConnectorDb();
            
            updateProductsTable();
            updateSalesTable();
            checkSalesId();
            currentDateTime();
            updatetbl();
            updateReturnedSaleTable();
            updateRejectedOrderTable();
            jLabel7.setText(Login.id);
            jLabel9.setText(Login.id);
            
            
        setUndecorated(true);
        setBackground(new Color(0,0,0,0));
        jPanel1.setBackground(new Color(0,0,0,0));
        jPanel2.setBackground(new Color(0,0,0,0));
        jPanel3.setBackground(new Color(0,0,0,0));
        Background.setBackground(new Color(0,0,0,0));
 
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    private void updatetbl()
    { 
        try{
        pst = (PreparedStatement) conn.prepareStatement("select Pro_ID,Compartment_ID,Quantity from store");
        rs   = pst.executeQuery();
        jTable13.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception exc){exc.printStackTrace();
        }
    }

    
    private void searchtbl()
    { 
       try{

        String y =(String)jComboBox31.getSelectedItem();
        
        if("Product ID".equals(y))
        {pst = (PreparedStatement) conn.prepareStatement( "select Pro_ID,Compartment_ID,Quantity from `store` where Pro_ID like ? ;");
        pst.setString(1,jTextField30.getText()+"%");
        rs = pst.executeQuery();}
        
        if("Compartment ID".equals(y))
        {pst= (PreparedStatement) conn.prepareStatement( "select Pro_ID,Compartment_ID,Quantity from `store` where Compartment_ID like ? ;");
        pst.setString(1,jTextField30.getText()+"%");
        rs = pst.executeQuery();}
    
         jTable13.setModel(DbUtils.resultSetToTableModel(rs));
         
         if (jTextField30.getText().isEmpty())
                        {updatetbl();}
          }
        catch(Exception exc){exc.printStackTrace();}
    }

    
    private void updateReturnedSaleTable() throws SQLException{
        String sql = "SELECT `Date`,`Sales_ID`,returned_sales.`Pro_ID`,`Product_Name`,returned_sales.`Quantity`,`Discription` "
                + "FROM `returned_sales`,`products` WHERE returned_sales.`Pro_ID` = products.`Pro_ID` AND `Date` = ?";
        String date = year+"-"+month+"-"+day;
        pst = (PreparedStatement) conn.prepareStatement(sql);
        pst.setString(1, date);
        rs   = pst.executeQuery();
        jTable2.setModel(DbUtils.resultSetToTableModel(rs));
        //System.out.println("test");
    }

     private void updateRejectedOrderTable() throws SQLException{
        String sql = "SELECT `Date`,`Order_ID`,rejected_orders.`Pro_ID`,`Product_Name`,rejected_orders.`Quantity`,`Discription` "
                + "FROM `rejected_orders`,`products` WHERE rejected_orders.`Pro_ID` = products.`Pro_ID` AND `Date` = ?;";
        pst = (PreparedStatement) conn.prepareStatement(sql);
        String date = year+"-"+month+"-"+day;
        pst.setString(1, date);
        rs   = pst.executeQuery();
        jTable4.setModel(DbUtils.resultSetToTableModel(rs));
        //System.out.println("test");
    }

    
    
    public void checkSalesId() throws SQLException{
        try {
            
            
            
            String id=null;
            String sql1 = "SELECT Sales_ID FROM `sales`";
            pst = (PreparedStatement) conn.prepareStatement(sql1);
            rs = pst.executeQuery();
            String id1=null;
            int x = 0,max=0;
            while (rs.next()){
                id = rs.getString("Sales_ID");
                id1=id.substring(1);
                x = Integer.parseInt(id1);
                if(x>max)
                    max = x;         
            }
            max+=1;
            //System.out.println(x);
            jTextField1.setText("S"+max);
            
        } catch (Exception ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    public void currentDateTime(){
        Calendar cal = new GregorianCalendar();
        month = cal.get(Calendar.MONTH) + 1;
        year = cal.get(Calendar.YEAR);
        day = cal.get(Calendar.DAY_OF_MONTH);
        
        
        second = cal.get(Calendar.SECOND) ;
        minute = cal.get(Calendar.MINUTE);
        hour = cal.get(Calendar.HOUR_OF_DAY);
        
        jLabel5.setText(day+"/"+month+"/"+year);
        jLabel6.setText(hour+":"+minute+":"+second);
        jLabel10.setText(day+"/"+month+"/"+year);
        jLabel13.setText(day+"/"+month+"/"+year);
        jLabel18.setText(day+"/"+month+"/"+year);
        
       // System.out.println(year+" "+month+" "+day);
        //System.out.println(hour+" "+minute+" "+second);
    }

    
    private void updateProductsTable() throws SQLException{
        String sql = "select * from products";
        pst = (PreparedStatement) conn.prepareStatement(sql);
        rs   = pst.executeQuery();
        jTable3.setModel(DbUtils.resultSetToTableModel(rs));
    } 
    
    void updateSalesTable() throws SQLException{
        String sql = "SELECT sales_product.`Pro_ID`, `Product_Name`, sales_product.`Quantity`, sales_product.`Unit_Price`, `Discount_Given` "
                + "FROM `sales_product`,`Products` WHERE `Sales_ID` = ? AND sales_product.`Pro_ID` = Products.`Pro_ID`;";
        pst = (PreparedStatement) conn.prepareStatement(sql);
        pst.setString(1, jTextField1.getText());
        rs   = pst.executeQuery();
        //System.out.println("test");
       // jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        jTable9.setModel(DbUtils.resultSetToTableModel(rs));
        tot=0;
        for(int i =0 ; i<list.size();i++){
            tot += list.get(i);
            
        }
        jLabel58.setText(String.format("%.2f",tot));
        
            
            
        //System.out.println(tot);
        
       // System.out.println("test");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton51 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel27 = new javax.swing.JPanel();
        jPanel51 = new javax.swing.JPanel();
        jComboBox31 = new javax.swing.JComboBox();
        jLabel69 = new javax.swing.JLabel();
        jTabbedPane7 = new javax.swing.JTabbedPane();
        jPanel52 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jPanel53 = new javax.swing.JPanel();
        jTextField23 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jButton37 = new javax.swing.JButton();
        jLabel98 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jPanel54 = new javax.swing.JPanel();
        jLabel101 = new javax.swing.JLabel();
        jTextField26 = new javax.swing.JTextField();
        jButton38 = new javax.swing.JButton();
        jLabel102 = new javax.swing.JLabel();
        jPanel55 = new javax.swing.JPanel();
        jTextField27 = new javax.swing.JTextField();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jTextField28 = new javax.swing.JTextField();
        jLabel105 = new javax.swing.JLabel();
        jButton39 = new javax.swing.JButton();
        jLabel106 = new javax.swing.JLabel();
        jTextField29 = new javax.swing.JTextField();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTable13 = new javax.swing.JTable();
        jTextField30 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        jPanel15 = new javax.swing.JPanel();
        jPanel59 = new javax.swing.JPanel();
        jPanel60 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable9 = new javax.swing.JTable();
        jPanel61 = new javax.swing.JPanel();
        jButton46 = new javax.swing.JButton();
        jButton47 = new javax.swing.JButton();
        jButton48 = new javax.swing.JButton();
        jButton49 = new javax.swing.JButton();
        jButton50 = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel18 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel19 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jTextField5 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel23 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel24 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jPanel26 = new javax.swing.JPanel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel33 = new javax.swing.JLabel();
        jPasswordField2 = new javax.swing.JPasswordField();
        jLabel34 = new javax.swing.JLabel();
        jPasswordField3 = new javax.swing.JPasswordField();
        jButton21 = new javax.swing.JButton();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Deema Baby Fair - Employee");
        getContentPane().setLayout(null);

        jButton51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/minimize.png"))); // NOI18N
        jButton51.setContentAreaFilled(false);
        jButton51.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/minimize - light.png"))); // NOI18N
        jButton51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton51ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton51);
        jButton51.setBounds(1210, 10, 30, 30);

        jButton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close.png"))); // NOI18N
        jButton27.setContentAreaFilled(false);
        jButton27.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close - light.png"))); // NOI18N
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton27);
        jButton27.setBounds(1230, 10, 40, 30);

        jPanel2.setLayout(null);

        jPanel1.setPreferredSize(new java.awt.Dimension(201, 661));

        jButton1.setText("Product");
        jButton1.setPreferredSize(new java.awt.Dimension(61, 23));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Add Sale");
        jButton2.setPreferredSize(new java.awt.Dimension(61, 23));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Store");
        jButton4.setPreferredSize(new java.awt.Dimension(61, 23));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Revieve an Order");
        jButton5.setPreferredSize(new java.awt.Dimension(61, 23));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Add Returned Sale");
        jButton6.setPreferredSize(new java.awt.Dimension(61, 23));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Add Rejected Order");
        jButton7.setPreferredSize(new java.awt.Dimension(61, 23));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton9.setText("Log Out");
        jButton9.setPreferredSize(new java.awt.Dimension(61, 23));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Exit");
        jButton10.setMaximumSize(new java.awt.Dimension(61, 23));
        jButton10.setMinimumSize(new java.awt.Dimension(61, 23));
        jButton10.setPreferredSize(new java.awt.Dimension(61, 23));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton20.setText("Change U/P");
        jButton20.setPreferredSize(new java.awt.Dimension(61, 23));
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(jButton20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1);
        jPanel1.setBounds(31, 0, 170, 680);

        jPanel3.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1070, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel4, "card2");

        jLabel21.setText("Search Product Name");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Search", jPanel7);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        jPanel3.add(jPanel5, "card3");

        jComboBox31.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Product ID", "Compartment ID" }));
        jComboBox31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox31ActionPerformed(evt);
            }
        });

        jLabel69.setText("Search by");

        jTabbedPane7.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jPanel52.setBackground(new java.awt.Color(204, 204, 255));
        jPanel52.setLayout(null);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel52.add(jSeparator1);
        jSeparator1.setBounds(430, 0, 20, 100);

        jButton35.setText("Add");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });
        jPanel52.add(jButton35);
        jButton35.setBounds(190, 43, 110, 40);

        jButton36.setText("Retrive");
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });
        jPanel52.add(jButton36);
        jButton36.setBounds(630, 40, 110, 40);
        jPanel52.add(jTextField19);
        jTextField19.setBounds(70, 30, 80, 30);
        jPanel52.add(jTextField20);
        jTextField20.setBounds(70, 60, 80, 30);
        jPanel52.add(jTextField21);
        jTextField21.setBounds(500, 30, 80, 30);
        jPanel52.add(jTextField22);
        jTextField22.setBounds(500, 60, 80, 30);

        jLabel70.setText("Product ID");
        jPanel52.add(jLabel70);
        jLabel70.setBounds(10, 30, 70, 30);

        jLabel71.setText("Quantity");
        jPanel52.add(jLabel71);
        jLabel71.setBounds(20, 60, 60, 30);

        jLabel72.setText("Product ID");
        jPanel52.add(jLabel72);
        jLabel72.setBounds(440, 30, 70, 30);

        jLabel73.setText("Quantity");
        jPanel52.add(jLabel73);
        jLabel73.setBounds(450, 60, 60, 30);

        jLabel74.setForeground(new java.awt.Color(102, 102, 102));
        jLabel74.setText("Retrive products from store");
        jLabel74.setName(""); // NOI18N
        jPanel52.add(jLabel74);
        jLabel74.setBounds(460, 0, 170, 30);

        jLabel75.setForeground(new java.awt.Color(102, 102, 102));
        jLabel75.setText("Add products \nto store");
        jLabel75.setName(""); // NOI18N
        jPanel52.add(jLabel75);
        jLabel75.setBounds(30, 0, 120, 30);

        jTabbedPane7.addTab("Update the Store", jPanel52);

        jPanel53.setBackground(new java.awt.Color(204, 204, 255));
        jPanel53.setLayout(null);
        jPanel53.add(jTextField23);
        jTextField23.setBounds(80, 20, 80, 30);
        jPanel53.add(jTextField24);
        jTextField24.setBounds(260, 20, 80, 30);

        jLabel96.setText("Quantity");
        jPanel53.add(jLabel96);
        jLabel96.setBounds(200, 20, 60, 30);

        jLabel97.setText("Product ID");
        jPanel53.add(jLabel97);
        jLabel97.setBounds(20, 20, 70, 30);

        jButton37.setText("Add");
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });
        jPanel53.add(jButton37);
        jButton37.setBounds(430, 50, 110, 40);

        jLabel98.setText("Compartment ID");
        jPanel53.add(jLabel98);
        jLabel98.setBounds(160, 60, 100, 30);
        jPanel53.add(jTextField25);
        jTextField25.setBounds(260, 60, 80, 30);

        jLabel99.setText("Date :");
        jPanel53.add(jLabel99);
        jLabel99.setBounds(430, 14, 40, 20);
        jPanel53.add(jLabel100);
        jLabel100.setBounds(470, 10, 120, 30);

        jTabbedPane7.addTab("Add new products to the Store", jPanel53);

        jPanel54.setBackground(new java.awt.Color(204, 204, 255));
        jPanel54.setLayout(null);

        jLabel101.setText("Product ID");
        jPanel54.add(jLabel101);
        jLabel101.setBounds(150, 30, 70, 30);
        jPanel54.add(jTextField26);
        jTextField26.setBounds(210, 30, 80, 30);

        jButton38.setText("Delete");
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });
        jPanel54.add(jButton38);
        jButton38.setBounds(320, 30, 90, 30);
        jPanel54.add(jLabel102);
        jLabel102.setBounds(420, 30, 190, 30);

        jTabbedPane7.addTab("Delete Product", jPanel54);

        jPanel55.setBackground(new java.awt.Color(204, 204, 255));

        jTextField27.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField27KeyReleased(evt);
            }
        });

        jLabel103.setText("Product ID");

        jLabel104.setText("Change Compartment From");

        jTextField28.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField28ActionPerformed(evt);
            }
        });

        jLabel105.setText("To");

        jButton39.setText("Change");
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });

        jTextField29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField29ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel55Layout = new javax.swing.GroupLayout(jPanel55);
        jPanel55.setLayout(jPanel55Layout);
        jPanel55Layout.setHorizontalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel55Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jLabel104, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel55Layout.setVerticalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel104, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTabbedPane7.addTab("Change Compartment", jPanel55);

        jTable13.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Pro_ID", "Compartment_ID", "Quantity"
            }
        ));
        jScrollPane13.setViewportView(jTable13);

        jTextField30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField30ActionPerformed(evt);
            }
        });
        jTextField30.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField30KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel51Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jComboBox31, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane13)
                    .addComponent(jTabbedPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE))
                .addContainerGap(220, Short.MAX_VALUE))
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jTabbedPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(162, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1134, Short.MAX_VALUE)
            .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel27Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 633, Short.MAX_VALUE)
            .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel27Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane5.addTab("View", jPanel27);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane5)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane5)
        );

        jPanel3.add(jPanel8, "card9");

        jPanel60.setBorder(javax.swing.BorderFactory.createTitledBorder("Sales Details"));

        jLabel4.setText("Time");

        jLabel14.setText("Employee ID");

        jLabel58.setText("0.00");

        jLabel7.setText("ID");

        jLabel59.setText("Sales ID");

        jLabel5.setText("Date");

        jLabel60.setText("Date");

        jLabel6.setText("Time");

        jLabel8.setText("Total");

        javax.swing.GroupLayout jPanel60Layout = new javax.swing.GroupLayout(jPanel60);
        jPanel60.setLayout(jPanel60Layout);
        jPanel60Layout.setHorizontalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel60Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel59)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel60Layout.createSequentialGroup()
                        .addComponent(jLabel58)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel60Layout.createSequentialGroup()
                        .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(73, 73, 73)
                        .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel60Layout.createSequentialGroup()
                                .addComponent(jLabel60)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel60Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel60Layout.setVerticalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel60Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel59))
                    .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel60)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(jLabel7))
                    .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel6)))
                .addGap(18, 18, 18)
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel58))
                .addContainerGap())
        );

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder("Product Details"));

        jLabel61.setText("Product ID");

        jLabel62.setText("Quantity");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel61)
                .addGap(35, 35, 35)
                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel62)
                .addGap(39, 39, 39)
                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel59Layout = new javax.swing.GroupLayout(jPanel59);
        jPanel59.setLayout(jPanel59Layout);
        jPanel59Layout.setHorizontalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel59Layout.setVerticalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTable9.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane9.setViewportView(jTable9);

        jButton46.setText("Add Product");
        jButton46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton46ActionPerformed(evt);
            }
        });

        jButton47.setText("Update Product");
        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton47ActionPerformed(evt);
            }
        });

        jButton48.setText("Delete Product");
        jButton48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton48ActionPerformed(evt);
            }
        });

        jButton49.setText("Next Sale");
        jButton49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton49ActionPerformed(evt);
            }
        });

        jButton50.setText("Print Bill");
        jButton50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton50ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel61Layout = new javax.swing.GroupLayout(jPanel61);
        jPanel61.setLayout(jPanel61Layout);
        jPanel61Layout.setHorizontalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton47, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
            .addComponent(jButton48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton50, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel61Layout.setVerticalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addComponent(jButton46)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton47)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton48)
                .addGap(29, 29, 29)
                .addComponent(jButton50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton49)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder("Customer Change"));

        jLabel63.setText("Customer Cash");

        jLabel64.setText("Change");

        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });

        jLabel65.setText("0.00");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel63)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(jLabel64)
                .addGap(52, 52, 52)
                .addComponent(jLabel65)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel64)
                    .addComponent(jLabel65))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel59, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel15Layout.createSequentialGroup()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                    .addComponent(jPanel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane6.addTab("Add", jPanel15);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1070, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTabbedPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1050, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTabbedPane6)
                    .addContainerGap()))
        );

        jPanel3.add(jPanel6, "card4");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Name", "Quantity", "Compartment ID"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jLabel3.setText("Employee ID");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton3.setText("Reset");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel9.setText("ID");

        jLabel10.setText("Date");

        jLabel11.setText("Date");

        jLabel1.setText("Order ID");

        jButton11.setText("Confirm");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("Save to Compartment");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField2)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(37, 37, 37)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 277, Short.MAX_VALUE)
                .addComponent(jButton11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 841, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Receive", jPanel13);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        jPanel3.add(jPanel9, "card6");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable2);

        jButton15.setText("Add");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setText("Delete");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton15)
                .addGap(18, 18, 18)
                .addComponent(jButton16)
                .addGap(52, 52, 52))
        );

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Customer Preferance", "Faulty Product", "Broken Seal", "Expired", " ", " " }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Sales ID");

        jLabel12.setText("Product ID");

        jLabel13.setText("Date");

        jLabel15.setText("Reason");

        jLabel16.setText("Date");

        jLabel17.setText("Quantity");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31))))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(205, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Returned", jPanel18);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );

        jPanel3.add(jPanel10, "card7");

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jTable4);

        jButton17.setText("Add");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setText("Delete");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton18)
                .addGap(45, 45, 45))
        );

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Faulty Product", "Broken Seal", "Expired" }));

        jLabel18.setText("Date");

        jLabel19.setText("Quantity");

        jLabel20.setText("Product ID");

        jLabel22.setText("Reason");

        jLabel23.setText("Order ID");

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Null" }));

        jLabel24.setText("Date");

        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jRadioButton1.setText("All the Products");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(55, 55, 55)
                        .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel20)
                            .addComponent(jLabel24)
                            .addComponent(jLabel19))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField8)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField7)
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addComponent(jRadioButton1))))))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGap(22, 22, 22)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1045, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(199, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Rejected", jPanel23);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4)
        );

        jPanel3.add(jPanel11, "card8");

        jLabel25.setText("Enter your current password");

        jLabel33.setText("Enter your new password");

        jLabel34.setText("Renter your new password");

        jButton21.setText("Confirm");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addComponent(jLabel25)
                            .addGap(84, 84, 84)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel33)
                                .addComponent(jLabel34))
                            .addGap(92, 92, 92)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPasswordField3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(646, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addGap(34, 34, 34)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addGap(54, 54, 54)
                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(342, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel12, "card9");

        jPanel2.add(jPanel3);
        jPanel3.setBounds(207, 30, 1070, 600);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 48, 1341, 652);

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/adminScreen.png"))); // NOI18N
        getContentPane().add(Background);
        Background.setBounds(0, 0, 1320, 720);

        setSize(new java.awt.Dimension(1336, 724));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            updateProductsTable();
            jPanel3.removeAll();
            jPanel3.repaint();
            jPanel3.revalidate();
            
            jPanel3.add(jPanel5);
            jPanel3.repaint();
            jPanel3.revalidate();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        currentDateTime();
        jPanel3.removeAll();
        jPanel3.repaint();
        jPanel3.revalidate();
        
        jPanel3.add(jPanel6);
        jPanel3.repaint();
        jPanel3.revalidate();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        updatetbl();
        jPanel3.removeAll();
        jPanel3.repaint();
        jPanel3.revalidate();
        
        jPanel3.add(jPanel8);
        jPanel3.repaint();
        jPanel3.revalidate();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        currentDateTime();
        jPanel3.removeAll();
        jPanel3.repaint();
        jPanel3.revalidate();
        
        jPanel3.add(jPanel9);
        jPanel3.repaint();
        jPanel3.revalidate();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        currentDateTime();
        jPanel3.removeAll();
        jPanel3.repaint();
        jPanel3.revalidate();
        
        jPanel3.add(jPanel10);
        jPanel3.repaint();
        jPanel3.revalidate();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        currentDateTime();
        jPanel3.removeAll();
        jPanel3.repaint();
        jPanel3.revalidate();
        
        jPanel3.add(jPanel11);
        jPanel3.repaint();
        jPanel3.revalidate();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        try {
            // TODO add your handling code here:
            this.dispose();
            Login ls = new Login();
            ls.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        // TODO add your handling code here:
        try {

            String productName = jTextField3.getText();
            String sql = "select * from products where Product_Name like ?";
            pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1,jTextField3.getText()+"%");
            rs=pst.executeQuery();
            jTable3.setModel(DbUtils.resultSetToTableModel(rs));

            if (jTextField3.getText().isEmpty()){
                //System.out.println("test12");
                updateProductsTable();
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton46ActionPerformed

        currentDateTime();
        if (jTextField9.getText().isEmpty() || jTextField10.getText().isEmpty())
            JOptionPane.showMessageDialog(null, "Enter product details","",WARNING_MESSAGE);
        else{
            if (count == 0){
                try {
                    // TODO add your handling code here:
                    String salesId = jTextField1.getText();



                    String sql = "INSERT INTO `deemababyfair`.`sales` (`Sales_ID`, `Date`, `Time`, `Emp_ID`) "
                    + "VALUES (?, ?, ?, ?);";

                    pst = (PreparedStatement) conn.prepareStatement(sql);

                    pst.setString(1, jTextField1.getText());
                    pst.setString(2, year+"-"+month+"-"+day);
                    pst.setString(3, hour+":"+minute+":"+second);
                    pst.setString(4, Login.id);

                    pst.execute();

                } catch (Exception ex) {
                    Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            count++;
            //addSalesProduct asp = new addSalesProduct(jTextField1.getText(),addSales.this,list);
            //asp.setVisible(true);

            try {
                // TODO add your handling code here:
                //Connector con = new Connector();

                PreparedStatement myStmt ;

                if(updateSales==0){
                    
                    String sql1 = "SELECT * FROM `products` WHERE `Pro_ID` = ?;";
                    pst = (PreparedStatement) conn.prepareStatement(sql1);
                    pst.setString(1, jTextField9.getText());
                    rs = pst.executeQuery();
                    
                    while(rs.next()){
                        
                        up = rs.getString("Unit_Price");
                        dg = rs.getString("Discount");
                    }

                    String sql2 = "SELECT * FROM `sales_product` WHERE `Sales_ID` = ? AND `Pro_ID` = ?";
                    pst = (PreparedStatement) conn.prepareStatement(sql2);
                    pst.setString(1, jTextField1.getText());
                    pst.setString(2, jTextField9.getText());
                    ResultSet rs1 = pst.executeQuery();
                    if(rs1.next()){
                        JOptionPane.showMessageDialog(null,"Product Alreday entered","",WARNING_MESSAGE);
                    }else{
                        
                        String sql = "INSERT INTO `deemababyfair`.`sales_product` (`Sales_ID`, `Pro_ID`, `Quantity`, `Unit_Price`, `Discount_Given`) "
                        + "VALUES (?, ?, ?, ?, ?);";


                        //System.out.println("tt");
                        pst = (PreparedStatement) conn.prepareStatement(sql);

                        pst.setString(1, jTextField1.getText());
                        pst.setString(2, jTextField9.getText());
                        pst.setString(3, jTextField10.getText());
                        pst.setString(4, up);
                        pst.setString(5, dg);
                        //pst.execute();

                        String s = "SELECT * FROM `products` WHERE `Pro_ID` = ?;";
                        PreparedStatement pst1 =  (PreparedStatement) conn.prepareStatement(s);
                        pst1.setString(1, jTextField9.getText());
                        ResultSet rs2 = pst1.executeQuery();
                        if(rs2.next()){
                            //System.out.println("tt");
                            String Q = rs2.getString("Quantity");
                            int newQ = Integer.parseInt(Q)- Integer.parseInt(jTextField10.getText());
                            String s1 = "UPDATE `products` SET `Quantity`=? WHERE `Pro_ID` = ?;";
                            PreparedStatement pst =  (PreparedStatement) conn.prepareStatement(s1);
                            pst.setString(1, String.format("%d", newQ));
                            pst.setString(2, jTextField9.getText());
                            int r = pst.executeUpdate();
                            //System.out.println(r);
                        }


                    }



                }else{

                    String sql ="UPDATE `sales_product` SET `Quantity`=?,`Unit_Price`=?,`Discount_Given`=? "
                    + "WHERE `Sales_ID` = ? AND `Pro_ID` = ? ";
                    pst = (PreparedStatement) conn.prepareStatement(sql);

                    tot=0;
                    pst.setString(1, jTextField10.getText());
                    pst.setString(2, up);
                    pst.setString(3, dg);
                    pst.setString(4, jTextField1.getText());
                    pst.setString(5, jTextField9.getText());
                    //pst.execute();

                    String s = "SELECT * FROM `products` WHERE `Pro_ID` = ?;";
                    PreparedStatement pst1 =  (PreparedStatement) conn.prepareStatement(s);
                    pst1.setString(1, jTextField9.getText());
                    ResultSet rs2 = pst1.executeQuery();
                    if(rs2.next()){
                        String Q = rs2.getString("Quantity");
                        String newQ = Integer.toString(Integer.parseInt(Q)- Integer.parseInt(jTextField10.getText()));
                        String s1 = "UPDATE `products` SET `Quantity`=? WHERE `Pro_ID` = ?;";
                        PreparedStatement pst =  (PreparedStatement) conn.prepareStatement(s1);
                        pst.setString(1, newQ);
                        pst.setString(2, jTextField9.getText());
                        pst.execute();
                    }


                }

                pst.execute();
                int qty = Integer.parseInt(jTextField10.getText());
                double price = Double.parseDouble(up);
                double dis = Double.parseDouble(dg);
                sum += (double)(price*qty - price*qty*dis/100);
                //System.out.println(sum);
                if(updateSales ==0)
                list.add(sum);
                else{
                    list.remove(row);
                    list.add(row,sum);
                    //System.out.println(row);
                    //System.out.println(sum);
                }
                sum=0;

                updateSalesTable();
                updateSales=0;
                //this.setVisible(false);
                jTextField9.setText("");
                jTextField10.setText("");

            } catch (Exception ex) {
                Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_jButton46ActionPerformed

    private void jButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton47ActionPerformed
        try {
            // TODO add your handling code here:
            updateSales++;
            sum=0;
            row = jTable9.getSelectedRow();
            //String sid = (String) jTable9.getModel().getValueAt(row, 0);
            String pid = (String) jTable9.getModel().getValueAt(row, 0);
            //int qty =  (int) jTable1.getModel().getValueAt(row, 2);
            //double up = (double) jTable1.getModel().getValueAt(row, 3);
            //double dg = (double) jTable1.getModel().getValueAt(row, 4);
            String qty=null;
            String up=null ;
            String dg=null ;

            String sql = "SELECT * FROM `sales_product` WHERE `Sales_ID` = ? AND `Pro_ID` = ? ";

            pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, jTextField1.getText());
            pst.setString(2, pid);
            rs = pst.executeQuery();
            if(rs.next()){
                //sid = rs.getString("Sales_ID");
                pid = rs.getString("Pro_ID");
                qty = rs.getString("Quantity");
                up = rs.getString("Unit_Price");
                dg = rs.getString("Discount_Given");
            }
            jTextField9.setText(pid);
            jTextField10.setText(qty);
            
            String s = "SELECT * FROM `products` WHERE `Pro_ID` = ?;";
            pst =  (PreparedStatement) conn.prepareStatement(s);
            pst.setString(1, jTextField9.getText());
            ResultSet rs2 = pst.executeQuery();
            if(rs2.next()){
                String Q = rs2.getString("Quantity");
                String newQ = Integer.toString(Integer.parseInt(Q)+ Integer.parseInt(jTextField10.getText()));
                String s1 = "UPDATE `products` SET `Quantity`=? WHERE `Pro_ID` = ?;";
                pst =  (PreparedStatement) conn.prepareStatement(s1);
                pst.setString(1, newQ);
                pst.setString(2, jTextField9.getText());
                pst.execute();
            }

            //System.out.println(sid+" "+pid+" "+qty+" "+up+" "+dg);

            //addSalesProduct asp = new addSalesProduct(sid,pid,qty,up,dg,addSales.this,row);
            //asp.setVisible(true);

        
        }catch(SQLException ex){
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(null,"Select a row first","",WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jButton47ActionPerformed

    private void jButton48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton48ActionPerformed
        try {
            // TODO add your handling code here:
            int row = jTable9.getSelectedRow();
            //String sid = (String) jTable9.getModel().getValueAt(row, 0);
            String pid = (String) jTable9.getModel().getValueAt(row, 0);
            String sql = "DELETE FROM `sales_product` WHERE `Sales_ID` = ? AND `Pro_ID` = ? ";

            pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, jTextField1.getText());
            pst.setString(2, pid);
            int r = pst.executeUpdate();
            list.remove(row);
            updateSalesTable();
        } catch (SQLException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }catch (ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(null,"Select a row first","",WARNING_MESSAGE);
        }    }//GEN-LAST:event_jButton48ActionPerformed

    private void jButton49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton49ActionPerformed
        try {
            // TODO add your handling code here:
            tot = 0;
            currentDateTime();
            jLabel5.setText(day+"/"+month+"/"+year);
            jLabel6.setText(hour+":"+minute+":"+second);

            checkSalesId();
            updateSalesTable();
            list.clear();
            count=0;
            jTextField10.setText("");
            jLabel58.setText("0.00");
            jLabel65.setText("0.00");
            jTextField9.setText("P");
            jTextField11.setText("");

        } catch (SQLException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton49ActionPerformed

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
         cash = jTextField11.getText();
         change = (double) (Double.parseDouble(cash) - tot);
        jLabel65.setText(String.format("%.2f",change));
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        //System.out.println(orderReceivedCount);
        if(orderReceivedCount==0){
            try {
                orderReceivedCount++;
                
               // TODO add your handling code here:
               String sql = "SELECT `Order_ID`, order_product.`Pro_ID`, order_product.`Quantity`, `Product_Name` FROM `order_product`,`products` "
                       + "WHERE `Order_ID` = ? AND order_product.`Pro_ID` = products.`Pro_ID` ";

               pst = (PreparedStatement) conn.prepareStatement(sql);
               pst.setString(1, jTextField2.getText());

               rs = pst.executeQuery();

               while (rs.next()){
                   String pid = rs.getString("Pro_ID");
                   String qty = rs.getString("Quantity");
                   String name = rs.getString("Product_Name");

                   String sql2 = "SELECT `Compartment_ID` FROM `store` WHERE `Pro_ID` = ?;";
                   pst = (PreparedStatement) conn.prepareStatement(sql2);
                   pst.setString(1,pid);
                   ResultSet rs1 = pst.executeQuery();
                   while(rs1.next()){
                       String cid = rs1.getString("Compartment_ID");
                       list1.add(Arrays.asList(pid,name,qty,cid));
                       count++;
                   }
                   if(count == 0)
                       list1.add(Arrays.asList(pid,name,qty,"Not Given"));
                   count =0;
                   //selectCompartment sc = new selectCompartment(pid,receiveOrder.this);
                   //sc.setVisible(true);
                   //String sql1 = "INSERT INTO `deemababyfair`.`store` (`Compartment_ID`, `Quantity`, `In_Date`, `Out_Date`, `Pro_ID`, `Emp_ID`)"
                   //      + " VALUES (?, ?, ?, NULL, ?, ?);";

                   // pst = conn.prepareStatement(sql1);
                   // pst.setString(1, cid);
                   // pst.setString(2, qty);
                   // pst.setString(3, year+"-"+month+"-"+day);
                   // pst.setString(4, pid);
                   // pst.setString(5, loginScreen.id);

                   // pst.execute();

               }

               model = (DefaultTableModel) jTable1.getModel();
               //model.setColumnCount(0);
               Object rawdata[] = new Object[4];
               for (int i = 0; i<list1.size();i++){
                   rawdata[0] = list1.get(i).get(0);
                   rawdata[1] = list1.get(i).get(1);
                   rawdata[2] = list1.get(i).get(2);
                   rawdata[3] = list1.get(i).get(3);
                   model.addRow(rawdata);
               }

           } catch (SQLException ex) {
               Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
           }       
        
        }

    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        try {
            // TODO add your handling code here:
            currentDateTime();
            int rows = jTable1.getRowCount();
            int Quantity = 0,ComId=0;
            

            
            String sql4 = "SELECT * FROM `order` WHERE `Order_ID` = ?;";
            pst = (PreparedStatement) conn.prepareStatement(sql4);
            pst.setString(1, jTextField2.getText());
            rs =pst.executeQuery();
            
            if (jTable1.getRowCount()>0 ){
                for(int i =0; i < jTable1.getRowCount() ; i++){
                   String p = (String) jTable1.getValueAt(i,3);
                   if(p.equals("Not Given"))
                        ComId++;
                }               
                if(ComId==0){
                    if(rs.next()){
                        String status = rs.getString("Receive_Status");
                        if(Integer.parseInt(status)==0){
                            for(int i =0 ; i<rows;i++){
                                try {

                                    cid = (String) jTable1.getModel().getValueAt(i, 3);
                                    String qty = (String) jTable1.getModel().getValueAt(i, 2);
                                    String pid = (String) jTable1.getModel().getValueAt(i, 0);

                                    String sql2 = "SELECT * FROM `store` WHERE `Compartment_ID` = ?;";
                                    pst = (PreparedStatement) conn.prepareStatement(sql2);
                                    pst.setString(1,cid);
                                    rs = pst.executeQuery();

                                    if(rs.next()){
                                        String q = rs.getString("Quantity");
                                        Quantity = Integer.parseInt(q) + Integer.parseInt(qty);
                                        String sql1 = "UPDATE `store` SET `Quantity`=?,`Pro_ID`=? WHERE `Compartment_ID` = ?;";
                                        pst = (PreparedStatement) conn.prepareStatement(sql1);
                                        pst.setString(1, String.format("%d", Quantity));
                                        pst.setString(2, pid);
                                        pst.setString(3, cid);
                                        pst.execute();

                                    }else{
                                        String sql1 = "INSERT INTO `deemababyfair`.`store` (`Compartment_ID`, `Quantity`, `Pro_ID`)"
                                                + " VALUES (?, ?, ?);";

                                        pst = (PreparedStatement) conn.prepareStatement(sql1);
                                        pst.setString(1, cid);
                                        pst.setString(2,qty);
                                        //pst.setString(3, year+"-"+month+"-"+day);
                                        pst.setString(3, pid);
                                        // pst.setString(5, LoginScreen.id);

                                        pst.execute();
                                    }



                                    String sql3 = "INSERT INTO `store_history`(`Compartment_ID`, `Pro_ID`, `Action`, `Previous_Quantity`,`New_Quantity`, `Date`, `Time`, `Emp_ID`) "
                                            + "VALUES (?,?,?,?,?,?,?,?);";
                                    pst = (PreparedStatement) conn.prepareStatement(sql3);
                                    pst.setString(1, cid);
                                    pst.setString(2, pid);
                                    pst.setString(3, "Add");
                                    pst.setString(4, qty);
                                    pst.setString(5, String.format("%d", Quantity));
                                    pst.setString(6, year+"-"+month+"-"+day);
                                    pst.setString(7, hour+":"+minute+":"+second);
                                    pst.setString(8, Login.id);
                                    pst.execute();



                                    /*sql3 = "SELECT * FROM `products` WHERE `Pro_ID` = ?;";
                                    pst = (PreparedStatement) conn.prepareStatement(sql3);
                                    pst.setString(1, pid);
                                    ResultSet rs3 = pst.executeQuery();
                                    if(rs3.next()){
                                        int q1 = 0;
                                        String q2 = rs3.getString("Quantity");
                                        q1 = Integer.parseInt(q2) + Integer.parseInt(qty);
                                        String sql = "UPDATE `products` SET `Quantity`=? WHERE `Pro_ID` = ?;";
                                        pst = (PreparedStatement) conn.prepareStatement(sql);
                                        pst.setString(1, String.format("%d", q1));
                                        pst.setString(2,pid);
                                        pst.execute();
                                    }*/





                                } catch (SQLException ex) {
                                    Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            String sql3 = "UPDATE `order` SET `Receive_Status`=? WHERE `Order_ID` = ?;";
                            pst = (PreparedStatement) conn.prepareStatement(sql3);
                            pst.setString(1, "1");
                            pst.setString(2, jTextField2.getText());
                            int x = pst.executeUpdate();
                            if(x!=0){
                                JOptionPane.showMessageDialog(null, "Saved");
                                orderReceivedCount=0;
                                model.setColumnCount(0);
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Order Already received");
                            orderReceivedCount=0;
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Incorrect Order ID");
                        orderReceivedCount=0;
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Compartment Id");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Order not taken. Renter Order ID");
                orderReceivedCount=0;
                jTextField2.setText("");
            }
            
            //System.out.println(rows);
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        jTable1.setValueAt(jTextField4.getText(), row, 3);
        jTextField4.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        try {
            // TODO add your handling code here:
            currentDateTime();
            String sql = "INSERT INTO `deemababyfair`.`returned_sales` (`Pro_ID`, `Sales_ID`, `Date`, `Discription`, `Quantity`) "
            + "VALUES (?, ?, ?, ?, ?);";

            pst = (PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, (String) jComboBox1.getSelectedItem());
            pst.setString(2, jTextField5.getText());
            pst.setString(3, year+"-"+month+"-"+day);
            pst.setString(4, (String) jComboBox2.getSelectedItem());
            pst.setString(5, jTextField6.getText());

            pst.execute();
            updateReturnedSaleTable();
            jTextField5.setText("");
            jTextField6.setText("");

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        try {
            // TODO add your handling code here:
            int row = jTable2.getSelectedRow();
            String pid = (String) jTable2.getModel().getValueAt(row, 0);
            String sid = (String) jTable2.getModel().getValueAt(row, 1);

            String sql = "DELETE FROM `returned_sales` WHERE `Pro_ID` = ? AND `Sales_ID` = ?;";

            pst = (PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, pid);
            pst.setString(2, sid);

            int r = pst.executeUpdate();
            updateReturnedSaleTable();

        } catch (SQLException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(null,"Select a Returned Sale");
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        try {
            // TODO add your handling code here:
            jComboBox1.removeAllItems();
            String sql = "SELECT * FROM `sales_product` WHERE `Sales_ID` = ? ";
            pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, jTextField5.getText());
            rs = pst.executeQuery();

            while(rs.next()){
                String pid = rs.getString("Pro_ID");
                jComboBox1.addItem(pid);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        try {
            // TODO add your handling code here:

            currentDateTime();
            if(jRadioButton1.isSelected()){
                String sql1 = "SELECT * FROM `order_product` WHERE `Order_ID` = ? ";
                pst = (PreparedStatement) conn.prepareStatement(sql1);
                pst.setString(1, jTextField7.getText());
                rs = pst.executeQuery();

                while(rs.next()){
                    String pid = rs.getString("Pro_ID");
                    String qty = rs.getString("Quantity");
                    String sql = "INSERT INTO `deemababyfair`.`rejected_orders` (`Pro_ID`, `Order_ID`, `Date`, `Discription`, `Quantity`) "
                    + "VALUES (?, ?, ?, ?, ?);";

                    pst = (PreparedStatement) conn.prepareStatement(sql);

                    pst.setString(1, pid);
                    pst.setString(2, jTextField7.getText());
                    pst.setString(3, year+"-"+month+"-"+day);
                    pst.setString(4, (String) jComboBox3.getSelectedItem());
                    pst.setString(5, qty);

                    pst.execute();
                }
            }else{
                String sql = "INSERT INTO `deemababyfair`.`rejected_orders` (`Pro_ID`, `Order_ID`, `Date`, `Discription`, `Quantity`) "
                + "VALUES (?, ?, ?, ?, ?);";

                pst = (PreparedStatement) conn.prepareStatement(sql);
                pst.setString(1, (String) jComboBox4.getSelectedItem());
                pst.setString(2, jTextField7.getText());
                pst.setString(3, year+"-"+month+"-"+day);
                pst.setString(4, (String) jComboBox3.getSelectedItem());
                pst.setString(5, jTextField8.getText());

                pst.execute();
            }
            updateRejectedOrderTable();
            jTextField7.setText("");
            jTextField8.setText("");
            jRadioButton1.setSelected(false);
            jComboBox3.setSelectedIndex(0);
            jComboBox4.removeAll();
            //jComboBox1.removeAllItems();
        } catch (SQLException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        try {
            // TODO add your handling code here:
            int row = jTable4.getSelectedRow();
            String pid = (String) jTable4.getModel().getValueAt(row, 0);
            String oid = (String) jTable4.getModel().getValueAt(row, 1);

            String sql = "DELETE FROM `rejected_orders` WHERE `Pro_ID` = ? AND `Order_ID` = ?;";

            pst = (PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, pid);
            pst.setString(2, oid);

            int r = pst.executeUpdate();
            updateRejectedOrderTable();
        } catch (SQLException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(null,"Select a Returned Sale");
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        try {
            // TODO add your handling code here:
            jComboBox4.removeAllItems();
            String sql = "SELECT * FROM `order_product` WHERE `Order_ID` = ? ";
            pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, jTextField7.getText());
            rs = pst.executeQuery();

            while(rs.next()){
                String pid = rs.getString("Pro_ID");
                jComboBox4.addItem(pid);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
        jPanel3.removeAll();
        jPanel3.repaint();
        jPanel3.revalidate();
        
        jPanel3.add(jPanel12);
        jPanel3.repaint();
        jPanel3.revalidate();
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
        try {
            if(jPasswordField1.getText().isEmpty() || jPasswordField2.getText().isEmpty() || jPasswordField3.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Password box cannot be empty");
                jPasswordField1.setText("");
                jPasswordField2.setText("");
                jPasswordField3.setText("");
            }else{
                String sql = "SELECT * FROM `employee` WHERE `Emp_ID` = ?;";
                String epass = null;
                pst = (PreparedStatement) conn.prepareStatement(sql);

                pst.setString(1,Login.id);

                rs = pst.executeQuery();

                if(rs.next()){
                    epass = rs.getString("Password");
                }

                if(jPasswordField1.getText().equals(epass)){
                    if(jPasswordField2.getText().equals(jPasswordField3.getText())){
                        String sql2 = "UPDATE `employee` SET `Password`= ?  WHERE `Emp_ID` = ? ";
                        pst = (PreparedStatement) conn.prepareStatement(sql2);
                        pst.setString(1, jPasswordField2.getText());
                        pst.setString(2, Login.id);
                        int r = pst.executeUpdate();
                        //System.out.println(r);
                        //System.out.println(LoginScreen.id);
                        JOptionPane.showMessageDialog(null, "Saved");
                        jPasswordField1.setText("");
                        jPasswordField2.setText("");
                        jPasswordField3.setText("");
                    }else{
                        JOptionPane.showMessageDialog(null, "Passwords doesn't match. Retype the password");
                        jPasswordField2.setText("");
                        jPasswordField3.setText("");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Password");
                    jPasswordField1.setText("");
                    jPasswordField2.setText("");
                    jPasswordField3.setText("");
                }                
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jComboBox31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox31ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox31ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed

        currentDateTime();
        String x = jTextField19.getText();
        String y = jTextField20.getText();
        int q1=0;
        try{

            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            PreparedStatement pst1 = null;
            ResultSet rs1 = null;

            String CID = null;
            String PID = jTextField19.getText();
            String Act = "Quantity Increased";

            String date = year+"-"+month+"-"+day;
            String time = hour+":"+minute+":"+second;
            String PreQ = "0" ;
            //String EID = "Not_found";

            pst1=(PreparedStatement) conn.prepareStatement("Select * from store where Pro_ID ='"+PID+"';");
            rs1 = pst1.executeQuery();
            if (rs1.next()){ PreQ = rs1.getString("Quantity");CID = rs1.getString("Compartment_ID"); }

            String NewQ = Integer.toString(Integer.parseInt(jTextField20.getText())+ Integer.parseInt(PreQ));

            Statement mystmnt1 = conn.createStatement();
            mystmnt1.executeUpdate("Insert into store_history (Compartment_ID,Pro_ID,Action,Date,Time,Previous_Quantity,New_Quantity,Emp_ID)"
                + "values('"+CID+"','"+PID+"','"+Act+"','"+date+"','"+time+"','"+PreQ+"','"+NewQ+"','"+Login.id+"')");

            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            pst=(PreparedStatement) conn.prepareStatement("Select Quantity from store WHERE Pro_ID=\""+x+"\";");
            rs =pst.executeQuery();

            if (rs.next())
            { q1= rs.getInt("Quantity"); }

            int newq = q1+Integer.parseInt(y);
            String h = Integer.toString(newq);

            Statement mystmnt = conn.createStatement();
            String sqlcode = "Update store set Quantity =\""+h+"\" where Pro_ID=\""+x+"\"";
            mystmnt.executeUpdate(sqlcode);
            updatetbl();

        }
        catch(Exception exc){exc.printStackTrace();}
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        currentDateTime();
        String x = jTextField21.getText();
        String y = jTextField22.getText();
        int q1=0;
        try{

            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            PreparedStatement pst1 = null;
            ResultSet rs1 = null;

            String CID = null;
            String PID = jTextField21.getText();
            String Act = "Quantity Decreased";
            String date = year+"-"+month+"-"+day;
            String time = hour+":"+minute+":"+second;
            String PreQ = "0" ;
            String EID = Login.id;

            pst1=(PreparedStatement) conn.prepareStatement("Select * from store where Pro_ID ='"+PID+"';");
            rs1 = pst1.executeQuery();
            if (rs1.next()){ PreQ = rs1.getString("Quantity");CID = rs1.getString("Compartment_ID"); }

            String NewQ = Integer.toString(Integer.parseInt(PreQ)- Integer.parseInt(jTextField22.getText()));

            Statement mystmnt1 = conn.createStatement();
            currentDateTime();
            mystmnt1.executeUpdate("Insert into store_history (Compartment_ID,Pro_ID,Action,Date,Time,Previous_Quantity,New_Quantity,Emp_ID)"
                + "values('"+CID+"','"+PID+"','"+Act+"','"+date+"','"+time+"','"+PreQ+"','"+NewQ+"','"+EID+"')");

            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            pst=(PreparedStatement) conn.prepareStatement("Select Quantity from store WHERE Pro_ID=\""+x+"\";");
            rs =pst.executeQuery();

            if (rs.next())
            { q1= rs.getInt("Quantity"); }

            int newq = q1-Integer.parseInt(y);
            String h = Integer.toString(newq);

            Statement mystmnt = conn.createStatement();
            String sqlcode2 = "Update store set Quantity =\""+h+"\" where Pro_ID=\""+x+"\"";
            mystmnt.executeUpdate(sqlcode2);
            
            String sql3 = "SELECT * FROM `products` WHERE `Pro_ID` = ?;";
            pst = (PreparedStatement) conn.prepareStatement(sql3);
            pst.setString(1, PID);
            ResultSet rs3 = pst.executeQuery();
            if(rs3.next()){
                int q11 = 0;
                String q2 = rs3.getString("Quantity");
                q11 = Integer.parseInt(q2) + Integer.parseInt(jTextField22.getText());
                String sql = "UPDATE `products` SET `Quantity`=? WHERE `Pro_ID` = ?;";
                pst = (PreparedStatement) conn.prepareStatement(sql);
                pst.setString(1, String.format("%d", q11));
                pst.setString(2,PID);
                pst.execute();
            }

            
            updatetbl();
        }
        catch(Exception exc){exc.printStackTrace();}
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        currentDateTime();
        String x = jTextField23.getText();
        String y = jTextField24.getText();
        int q1=0;
        try
        {
            PreparedStatement pst1 = null;
            ResultSet rs1 = null;

            Statement mystmnt1 = conn.createStatement();

            /////////////////////////////////////////////////////////////////////////////////

            String CID = jTextField25.getText();
            String PID = jTextField23.getText();
            String Act = "New Item Added";
            String date = year+"-"+month+"-"+day;
            String time = hour+":"+minute+":"+second;

            String PreQ = "0" ;
            String NewQ = jTextField24.getText(); String EID = "Not_found";

            pst1=(PreparedStatement) conn.prepareStatement("Select * from store where Pro_ID ='"+jTextField6.getText()+"';");
            rs1 = pst1.executeQuery();
            if (rs1.next()){ PreQ= rs1.getString("Quantity"); }

            mystmnt1.executeUpdate("Insert into store_history (Compartment_ID,Pro_ID,Action,Date,Time,Previous_Quantity,New_Quantity,Emp_ID)"
                + "values('"+CID+"','"+PID+"','"+Act+"','"+date+"','"+time+"','"+PreQ+"','"+NewQ+"','"+Login.id+"')");

            Statement mystmnt = conn.createStatement();
            String sqlcode = "Insert into store (Compartment_ID,Quantity,Pro_ID)"
            + "values('"+CID+"','"+jTextField24.getText()+"','"+jTextField23.getText()+"') ";
            mystmnt.executeUpdate(sqlcode);
            updatetbl();

        }catch (SQLException ex) {Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        currentDateTime();
        PreparedStatement pst1 = null;
        ResultSet rs1 = null;

        try
        {Statement mystmnt1 = conn.createStatement();
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            String CID = null;
            String PID = jTextField26.getText();
            String Act = "Product Removed";
            String date = year+"-"+month+"-"+day;
            String time = hour+":"+minute+":"+second;
            String PreQ = "0" ;
            String EID = "Not_found";
            String NewQ = "0";

            pst1=(PreparedStatement) conn.prepareStatement("Select * from store where Pro_ID ='"+PID+"';");
            rs1 = pst1.executeQuery();
            if (rs1.next())
            {

                PreQ = rs1.getString("Quantity");CID = rs1.getString("Compartment_ID");

                mystmnt1.executeUpdate("Insert into store_history (Compartment_ID,Pro_ID,Action,Date,Time,Previous_Quantity,New_Quantity,Emp_ID)"
                    + "values('"+CID+"','"+PID+"','"+Act+"','"+date+"','"+time+"','"+PreQ+"','"+NewQ+"','"+ Login.id +"')");

                /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                mystmnt1.executeUpdate("delete from store where Pro_ID ='"+PID+"';") ;
                updatetbl();
            }
            else{jLabel102.setText("Wrong Product ID ! Try Again");}
        }

        catch (SQLException ex) {Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_jButton38ActionPerformed

    private void jTextField27KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField27KeyReleased
        PreparedStatement pst1 = null;
        ResultSet rs1 = null;
        String PID = jTextField27.getText();String CID=null;
        try {
            pst1=(PreparedStatement) conn.prepareStatement("Select * from store where Pro_ID ='"+PID+"';");
            rs1 = pst1.executeQuery();
            if (rs1.next())
            {
                CID = rs1.getString("Compartment_ID");
                jTextField28.setText(CID);

            }
            else jTextField28.setText("??");
        }
        catch (SQLException ex) {Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_jTextField27KeyReleased

    private void jTextField28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField28ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField28ActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        currentDateTime();
        PreparedStatement pst1 = null;
        ResultSet rs1,rs2 = null;

        String CID = null;
        String PID = jTextField27.getText();
        String Act = "Compartment changed from ";
        String date = year+"-"+month+"-"+day;
        String time = hour+":"+minute+":"+second;
        String PreQ = "0" ;
        String EID = "Not_found";
        String NewQ = null;
        String newCID = jTextField29.getText();
        try {
            pst1=(PreparedStatement) conn.prepareStatement("Select * from store where Pro_ID ='"+PID+"';");
            rs1 = pst1.executeQuery();
            if (rs1.next())
            {

                PreQ = rs1.getString("Quantity");
                CID = rs1.getString("Compartment_ID");
                NewQ=PreQ;

                String sql = "SELECT * FROM `store` WHERE `Compartment_ID` = ?;";
                pst = (PreparedStatement) conn.prepareStatement(sql);
                pst.setString(1, newCID);
                rs = pst.executeQuery();
                if(rs.next()){
                    Statement mystmnt2= conn.createStatement();
                    mystmnt2.executeUpdate("Update store set Compartment_ID ='"+newCID+"' where Pro_ID='"+PID+"';");
                    updatetbl();
                }else{
                    String sql1 = "INSERT INTO `store`(`Compartment_ID`, `Quantity`, `Pro_ID`) VALUES (?,?,?);";
                    pst = (PreparedStatement) conn.prepareStatement(sql1);
                    pst.setString(1, newCID);
                    pst.setString(2, PreQ);
                    pst.setString(3, PID);
                    pst.execute();
                }

                Statement mystmnt1 = conn.createStatement();
                mystmnt1.executeUpdate("Insert into store_history (Compartment_ID,Pro_ID,Action,Date,Time,Previous_Quantity,New_Quantity,Emp_ID)"
                    + "values('"+CID+"','"+PID+"','"+Act+CID+" to "+newCID+"','"+date+"','"+time+"','"+PreQ+"','"+NewQ+"','"+Login.id+"')");
            }
            else{jLabel106.setText("Wrong Product ID ! Try Again");}

        }
        catch (SQLException ex) {Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);}
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jTextField29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField29ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField29ActionPerformed

    private void jTextField30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField30ActionPerformed

    private void jTextField30KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField30KeyReleased
        searchtbl();
    }//GEN-LAST:event_jTextField30KeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        int row = jTable1.getSelectedRow();
        
        String cid = (String) jTable1.getModel().getValueAt(row, 3);
        
        jTextField4.setText(cid);

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jTextField2.setText("O");
        jTextField4.setText("C");
        model.setRowCount(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton50ActionPerformed


        PdfWriter myWriter = null;
        try {
            
            
            Document mydoc = new Document();
            
            
                myWriter = PdfWriter.getInstance(mydoc,new FileOutputStream("report.pdf"));
            
            mydoc.open();
            
                mydoc.add(new Paragraph("Deema Baby Fair",FontFactory.getFont(FontFactory.TIMES_BOLD,20,Font.BOLD)));
            
            mydoc.add(new Paragraph(String.format("Bill no : %s", jTextField1.getText()),FontFactory.getFont(FontFactory.TIMES_BOLD,15,Font.BOLD)));
            mydoc.add(new Paragraph(String.format("%s", Calendar.getInstance().getTime())));
            mydoc.add(new Paragraph("-----------------------------------------------------------------------------------------------------------"));
            mydoc.add(new Paragraph("      Product                           Qty                        Amount"));
            mydoc.add(new Paragraph("-----------------------------------------------------------------------------------------------------------"));
            int row = jTable9.getRowCount();
            for(int i =0 ; i < row ; i++){
                int x =   (int) jTable9.getValueAt(i, 2);
                double y =  (double) jTable9.getValueAt(i, 3);
            mydoc.add(new Paragraph(String.format(" %s %-30s%-30d%-30.2f", jTable9.getValueAt(i, 0),jTable9.getValueAt(i, 1),jTable9.getValueAt(i, 2),(double)x*y)));
            }
            mydoc.add(new Paragraph("-----------------------------------------------------------------------------------------------------------"));
            mydoc.add(new Paragraph("-----------------------------------------------------------------------------------------------------------"));
            mydoc.add(new Paragraph(String.format("Total Amount    : Rs %.2f", tot)));
            mydoc.add(new Paragraph(String.format("Cash Received : Rs %s", cash)));
            mydoc.add(new Paragraph(String.format("Balance            : Rs %.2f", change)));
            mydoc.add(new Paragraph());
            mydoc.add(new Paragraph("-----------------------------------------------------------------------------------------------------------"));
            
            
            
            
            mydoc.close();
            if (Desktop.isDesktopSupported()) {
                File myFile = new File("C:\\Users\\Charinda\\Documents\\NetBeansProjects\\DBFnew\\report.pdf");
                try {
                    Desktop.getDesktop().open(myFile);
                } catch (IOException ex) {
                    Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            
            myWriter.close();
            } catch (FileNotFoundException ex) {
            //Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Close the previous Bill to generate a new");
        }catch (DocumentException ex) {
                Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
            }

        
        
        /*
        try {

            MessageFormat header = new MessageFormat("Bill No"+jTextField1.getText());
            MessageFormat footer = new MessageFormat(String.format("Total = "+tot+" Cash reveived = "+cash+" Balance = "+change));
            jTable9.print(JTable.PrintMode.FIT_WIDTH, header, footer);

        } catch (PrinterException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        */
    }//GEN-LAST:event_jButton50ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton51ActionPerformed
        setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jButton51ActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox jComboBox31;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPasswordField jPasswordField3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JTabbedPane jTabbedPane7;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable13;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}

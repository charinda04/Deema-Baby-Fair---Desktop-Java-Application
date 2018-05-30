/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deemababyfairtest.ui;

import com.deemababyfairtest.connecor.JavaConnect;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.print.*;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import static org.hsqldb.HsqlDateTime.e;


/**
 *
 * @author Charinda
 */
public class AdminScreen extends javax.swing.JFrame {

    /**
     * Creates new form AdminScreen
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
    ArrayList<List<String>> paySalary = new ArrayList<>();
    
    DefaultTableModel model; 
    
    public AdminScreen() {
        try {
            initComponents();
            conn = JavaConnect.ConnectorDb();
            
            currentDateTime();
            updateProductsTable();
            updateProductsTable1();
            checkProductId();
            updateSalesTable1();
            checkSalesId();
            updateSupplierTable();
            checkSupplierId();
            updateOrderTable1();
            checkOrderId();
            fillSupplier();
            updateRejectedOrderTable();
            updateReturnedSaleTable();
            updatePaySalaryTable();
            updatetbl();
            updatetbl1();        
            updateEmployeeTable();
            jLabel32.setText(Login.id);
            employeeId();
            
        jPanel1.setBackground(new Color(0,0,0,0));
        jPanel2.setBackground(new Color(0,0,0,0));
        jPanel3.setBackground(new Color(0,0,0,0));
      /*jPanel4.setBackground(new Color(0,0,0,0));  
        jPanel7.setBackground(new Color(0,0,0,0));
        jPanel8.setBackground(new Color(0,0,0,0));
        jPanel9.setBackground(new Color(0,0,0,0));
        jPanel10.setBackground(new Color(0,0,0,0));
        jPanel11.setBackground(new Color(0,0,0,0));
        jPanel12.setBackground(new Color(0,0,0,0));
        jPanel6.setBackground(new Color(0,0,0,0));
        jPanel5.setBackground(new Color(0,0,0,0));
        jPanel14.setBackground(new Color(0,0,0,0));
        jPanel15.setBackground(new Color(0,0,0,0));
        jPanel16.setBackground(new Color(0,0,0,0));
        jPanel17.setBackground(new Color(0,0,0,0));
        jPanel18.setBackground(new Color(0,0,0,0));
        jPanel19.setBackground(new Color(0,0,0,0));
        jPanel20.setBackground(new Color(0,0,0,0));
        jPanel21.setBackground(new Color(0,0,0,0));
        jPanel22.setBackground(new Color(0,0,0,0));
        jPanel23.setBackground(new Color(0,0,0,0));
        jPanel24.setBackground(new Color(0,0,0,0));
        jPanel25.setBackground(new Color(0,0,0,0));
        jPanel26.setBackground(new Color(0,0,0,0));
        jPanel27.setBackground(new Color(0,0,0,0));
        jPanel28.setBackground(new Color(0,0,0,0));
        jPanel29.setBackground(new Color(0,0,0,0));
        jPanel30.setBackground(new Color(0,0,0,0));
        jPanel31.setBackground(new Color(0,0,0,0));
        jPanel32.setBackground(new Color(0,0,0,0));
        jPanel33.setBackground(new Color(0,0,0,0));
        jPanel34.setBackground(new Color(0,0,0,0));
        jPanel35.setBackground(new Color(0,0,0,0));
        jPanel36.setBackground(new Color(0,0,0,0));
        jPanel37.setBackground(new Color(0,0,0,0));
        jPanel38.setBackground(new Color(0,0,0,0));
        jPanel39.setBackground(new Color(0,0,0,0));
        jPanel40.setBackground(new Color(0,0,0,0));
        jPanel41.setBackground(new Color(0,0,0,0));
        jPanel42.setBackground(new Color(0,0,0,0));
        jPanel43.setBackground(new Color(0,0,0,0));
        jPanel44.setBackground(new Color(0,0,0,0));
        jPanel45.setBackground(new Color(0,0,0,0));
        jPanel46.setBackground(new Color(0,0,0,0));
        jPanel47.setBackground(new Color(0,0,0,0));
        jPanel48.setBackground(new Color(0,0,0,0));
        jPanel49.setBackground(new Color(0,0,0,0));
        jPanel50.setBackground(new Color(0,0,0,0));
        jPanel51.setBackground(new Color(0,0,0,0));
        jPanel52.setBackground(new Color(0,0,0,0));
        jPanel53.setBackground(new Color(0,0,0,0));
        jPanel54.setBackground(new Color(0,0,0,0));
        jPanel55.setBackground(new Color(0,0,0,0));
        jPanel56.setBackground(new Color(0,0,0,0));
        jPanel57.setBackground(new Color(0,0,0,0));
        jPanel58.setBackground(new Color(0,0,0,0));
        jPanel59.setBackground(new Color(0,0,0,0));
        jPanel60.setBackground(new Color(0,0,0,0));
        jPanel61.setBackground(new Color(0,0,0,0));*/
        setBackground(new Color(0,0,0,0));
        background.setBackground(new Color(0,0,0,0));
        
        } catch (Exception ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
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
    
    private void updatetbl1()
    { 
        try{
        pst = (PreparedStatement) conn.prepareStatement("select Pro_ID,Compartment_ID,Action,Date,Time,Previous_Quantity,New_Quantity,Emp_ID from store_history Order by date,time ");
        rs   = pst.executeQuery();
        jTable14.setModel(DbUtils.resultSetToTableModel(rs));
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
    
    public void updatePaySalaryTable(){
        try {
            
            String eno=null,efn=null,eln=null,es=null;
            String sql = "SELECT * FROM `employee` WHERE `Is_A_Admin` = '0' ;";
            pst = (PreparedStatement) conn.prepareStatement(sql);
            
            rs   = pst.executeQuery();
            
            while(rs.next()){
                
                eno = rs.getString("Emp_ID");
                efn = rs.getString("First_Name");
                eln = rs.getString("Last_Name");
                es = rs.getString("Salary");
                String sql1 = "SELECT `Bonus` FROM `employee_salary` WHERE `Emp_ID` = ?;";
                pst = (PreparedStatement) conn.prepareStatement(sql1);
                pst.setString(1, eno);
                ResultSet rs1 = pst.executeQuery();
                if(rs1.next()){
                    
                    String bn = rs1.getString("Bonus");
                    paySalary.add(Arrays.asList(eno,efn,eln,es,bn));
                }else{
                    //System.out.println("test");
                    paySalary.add(Arrays.asList(eno,efn,eln,es,"0"));
                }
            }
            DefaultTableModel model1 = (DefaultTableModel) jTable8.getModel();
               model1.setRowCount(0);
               Object rawdata[] = new Object[5];
               for (int i = 0; i<paySalary.size();i++){
                   rawdata[0] = paySalary.get(i).get(0);
                   rawdata[1] = paySalary.get(i).get(1);
                   rawdata[2] = paySalary.get(i).get(2);
                   rawdata[3] = paySalary.get(i).get(3);
                   rawdata[4] = paySalary.get(i).get(4);
                   model1.addRow(rawdata);
               }
               paySalary.removeAll(paySalary);
        } catch (SQLException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    
    public void fillProductIdName(){
        
        
        try {
            jComboBox3.removeAllItems();
            jComboBox16.removeAllItems();
            ResultSet rs1;
            String sql = "SELECT * FROM `products` ";
            pst = (PreparedStatement) conn.prepareStatement(sql);
            rs1=pst.executeQuery();
            
            
            String id,name;
            while(rs1.next()){
                id = rs1.getString("Pro_ID");
                name = rs1.getString("Product_Name");
                jComboBox3.addItem(id);
                jComboBox16.addItem(name);
            }
            
            
            /*sql = "SELECT `Product_Name` FROM `products` ";
            pst = conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            while(rs.next()){
            String id = rs.getString("Product_Name");
            jComboBox2.addItem(id);
            }*/
        } catch (SQLException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void fillSupplier() throws SQLException{
         jComboBox2.removeAllItems();
        String sql = "SELECT `Sup_ID` FROM `supplier` ";
        pst = (PreparedStatement) conn.prepareStatement(sql);
        rs=pst.executeQuery();
        
        while(rs.next()){
            String id = rs.getString("Sup_ID");
            jComboBox2.addItem(id);
        }
    }
    
     
    private void updateEmployeeTable() throws SQLException{
        String sql = "SELECT * FROM `employee`";
        pst = (PreparedStatement) conn.prepareStatement(sql);
        rs   = pst.executeQuery();
        jTable11.setModel(DbUtils.resultSetToTableModel(rs));
       // System.out.println("test");
    }

     
     public void checkOrderId() throws SQLException{
        try {
            
            
            
            String id=null;
            String sql1 = "SELECT Order_ID FROM `order`";
            pst = (PreparedStatement) conn.prepareStatement(sql1);
            rs = pst.executeQuery();
            String id1=null;
            int x = 0,max=0;
            while (rs.next()){
                id = rs.getString("Order_ID");
                id1=id.substring(1);
                x = Integer.parseInt(id1);
                if(x>max)
                    max = x;         
            }
            
            
            
            
            max+=1;
            //System.out.println(x);
            orderIdTxt.setText("O"+max);
        } catch (Exception ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void checkProductId() throws SQLException{
        try {
            
            
           
            String id=null;
            String sql1 = "select Pro_ID from Products";
            pst = (PreparedStatement) conn.prepareStatement(sql1);
            rs = pst.executeQuery();
            String id1=null;
            int x=0,max=0;
            while (rs.next()){
                id = rs.getString("Pro_ID");
                id1=id.substring(1);
                x = Integer.parseInt(id1);
                if(x>max)
                    max = x;
                
            }
            
            
            
            max+=1;
            
            productIdTxt.setText("P"+max);
            productIdTxt1.setText("P"+max);
        } catch (Exception ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    public void checkSupplierId() throws SQLException{
        try {
            //Connector con = new Connector();
            //PreparedStatement myStmt ;
            //ResultSet rs;
            String id=null;
            String sql1 = "select Sup_ID from Supplier";
            pst = (PreparedStatement) conn.prepareStatement(sql1);
            rs = pst.executeQuery();
            int x=0,max=0;
            String id1=null;
            while (rs.next()){
                id = rs.getString("Sup_ID");
                id1=id.substring(1);
                x = Integer.parseInt(id1);
                if (x>max)
                    max = x;
            }
            
            
            
            max+=1;
            
            supplierIdTxt4.setText("S"+max);
        } catch (Exception ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    
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
    
    public void employeeId() throws SQLException{
        try {
            
            
            
            String id=null;
            String sql1 = "SELECT * FROM `employee` WHERE `Is_A_Admin` = '0' ;";
            pst = (PreparedStatement) conn.prepareStatement(sql1);
            rs = pst.executeQuery();
            String id1=null;
            int x = 0,max=0;
            while (rs.next()){
                id = rs.getString("Emp_ID");
                id1=id.substring(1);
                x = Integer.parseInt(id1);
                if(x>max)
                    max = x;         
            }
            max+=1;
            //System.out.println(x);
            employeeIdTxt.setText("E"+max);
            
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
        
        
        jLabel47.setText(String.format("%d", year));
        jLabel48.setText(String.format("%d", month));
        jLabel54.setText(day+"/"+month+"/"+year);
        jLabel35.setText(day+"/"+month+"/"+year);
        jLabel50.setText(day+"/"+month+"/"+year);
       // System.out.println(year+" "+month+" "+day);
        //System.out.println(hour+" "+minute+" "+second);
    }
    
     private void updateRejectedOrderTable() throws SQLException{
        String sql = "SELECT `Date`,`Order_ID`,rejected_orders.`Pro_ID`,`Product_Name`,rejected_orders.`Quantity`,`Discription` "
                + "FROM `rejected_orders`,`products` WHERE rejected_orders.`Pro_ID` = products.`Pro_ID`;";
        pst = (PreparedStatement) conn.prepareStatement(sql);
        rs   = pst.executeQuery();
        jTable12.setModel(DbUtils.resultSetToTableModel(rs));
        //System.out.println("test");
    }
    
    private void updateReturnedSaleTable() throws SQLException{
        String sql = "SELECT `Date`,`Sales_ID`,returned_sales.`Pro_ID`,`Product_Name`,returned_sales.`Quantity`,`Discription` "
                + "FROM `returned_sales`,`products` WHERE returned_sales.`Pro_ID` = products.`Pro_ID`";
        pst = (PreparedStatement) conn.prepareStatement(sql);
        rs   = pst.executeQuery();
        jTable10.setModel(DbUtils.resultSetToTableModel(rs));
        //System.out.println("test");
    }
    
    private void updateSalesTable1() throws SQLException{
        String sql = "select * from sales";
        pst = (PreparedStatement) conn.prepareStatement(sql);
        rs   = pst.executeQuery();
        jTable1.setModel(DbUtils.resultSetToTableModel(rs));
    } 
    
    private void updateOrderTable() throws SQLException{
        String sql = "SELECT * FROM `order`";
        pst = (PreparedStatement) conn.prepareStatement(sql);
        rs   = pst.executeQuery();
        jTable4.setModel(DbUtils.resultSetToTableModel(rs));
        //System.out.println("test");
    }
    
    
    void updateOrderTable1() throws SQLException{
        String sql = "SELECT * FROM `order_product` Where Order_ID = ?";
        pst = (PreparedStatement) conn.prepareStatement(sql);
        pst.setString(1, orderIdTxt.getText());
        rs   = pst.executeQuery();
        jTable5.setModel(DbUtils.resultSetToTableModel(rs));
       // System.out.println("test");
    }
    
     public void updateSupplierTable() throws SQLException{
        String sql = "select * from supplier";
        pst = (PreparedStatement) conn.prepareStatement(sql);
        rs   = pst.executeQuery();
        jTable6.setModel(DbUtils.resultSetToTableModel(rs));
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
    private void updateProductsTable() throws SQLException{
        String sql = "select * from products";
        pst = (PreparedStatement) conn.prepareStatement(sql);
        rs   = pst.executeQuery();
        jTable3.setModel(DbUtils.resultSetToTableModel(rs));
    } 
     
     private void updateProductsTable1() throws SQLException{
        String sql = "SELECT `Pro_ID`, `Product_Name`, `Unit_Price`, `Discount` FROM `products` ";
        pst = (PreparedStatement) conn.prepareStatement(sql);
        rs   = pst.executeQuery();
        jTable2.setModel(DbUtils.resultSetToTableModel(rs));
    } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jButton27 = new javax.swing.JButton();
        jButton51 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton20 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        productIdTxt = new javax.swing.JTextField();
        productNameTxt = new javax.swing.JTextField();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jLabel107 = new javax.swing.JLabel();
        productNameTxt2 = new javax.swing.JTextField();
        jPanel23 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField5 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel57 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jDateChooser7 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
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
        jPanel34 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTable10 = new javax.swing.JTable();
        jPanel36 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jPanel38 = new javax.swing.JPanel();
        jTextField15 = new javax.swing.JTextField();
        jComboBox27 = new javax.swing.JComboBox<>();
        jLabel44 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jComboBox28 = new javax.swing.JComboBox<>();
        jLabel53 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel18 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jButton15 = new javax.swing.JButton();
        jTextField7 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jPanel26 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        orderIdTxt = new javax.swing.JTextField();
        discountTxt = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jPanel27 = new javax.swing.JPanel();
        jButton17 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel28 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        priceTxt = new javax.swing.JTextField();
        quantityTxt = new javax.swing.JTextField();
        productNameTxt1 = new javax.swing.JTextField();
        productIdTxt1 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jDateChooser8 = new com.toedter.calendar.JDateChooser();
        jPanel29 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        priceTxt1 = new javax.swing.JTextField();
        quantityTxt1 = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox16 = new javax.swing.JComboBox<>();
        jCheckBox2 = new javax.swing.JCheckBox();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel22 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jPanel33 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jButton24 = new javax.swing.JButton();
        jTextField13 = new javax.swing.JTextField();
        jButton26 = new javax.swing.JButton();
        jPanel46 = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable12 = new javax.swing.JTable();
        jPanel48 = new javax.swing.JPanel();
        jPanel49 = new javax.swing.JPanel();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jPanel50 = new javax.swing.JPanel();
        jComboBox29 = new javax.swing.JComboBox<>();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jComboBox30 = new javax.swing.JComboBox<>();
        jLabel68 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jRadioButton7 = new javax.swing.JRadioButton();
        jPanel9 = new javax.swing.JPanel();
        jTabbedPane9 = new javax.swing.JTabbedPane();
        jPanel39 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jTextField6 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        supplierIdTxt4 = new javax.swing.JTextField();
        supplierContactTxt4 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        supplierAddressTxt4 = new javax.swing.JTextField();
        supplierNameTxt4 = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jPanel42 = new javax.swing.JPanel();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel51 = new javax.swing.JPanel();
        jComboBox31 = new javax.swing.JComboBox();
        jLabel69 = new javax.swing.JLabel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
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
        jPanel56 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTable14 = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jTabbedPane10 = new javax.swing.JTabbedPane();
        jPanel43 = new javax.swing.JPanel();
        jPanel63 = new javax.swing.JPanel();
        jTextField12 = new javax.swing.JTextField();
        jComboBox32 = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable11 = new javax.swing.JTable();
        jPanel44 = new javax.swing.JPanel();
        jPanel64 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        employeeIdTxt = new javax.swing.JTextField();
        firstNameTxt = new javax.swing.JTextField();
        lastNameTxt = new javax.swing.JTextField();
        nicNoTxt = new javax.swing.JTextField();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        contactNoTxt = new javax.swing.JTextField();
        addressTxt = new javax.swing.JTextField();
        salaryTxt = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        passwordTxt = new javax.swing.JTextField();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
        jPanel65 = new javax.swing.JPanel();
        jButton63 = new javax.swing.JButton();
        jButton64 = new javax.swing.JButton();
        jPanel45 = new javax.swing.JPanel();
        jPanel67 = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        firstNameTxt1 = new javax.swing.JTextField();
        lastNameTxt1 = new javax.swing.JTextField();
        nicNoTxt1 = new javax.swing.JTextField();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        contactNoTxt1 = new javax.swing.JTextField();
        addressTxt1 = new javax.swing.JTextField();
        salaryTxt1 = new javax.swing.JTextField();
        jLabel95 = new javax.swing.JLabel();
        passwordTxt1 = new javax.swing.JTextField();
        jComboBox26 = new javax.swing.JComboBox<>();
        jDateChooser6 = new com.toedter.calendar.JDateChooser();
        jPanel68 = new javax.swing.JPanel();
        jButton66 = new javax.swing.JButton();
        jButton67 = new javax.swing.JButton();
        jPanel66 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        jButton23 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jPanel62 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel33 = new javax.swing.JLabel();
        jPasswordField2 = new javax.swing.JPasswordField();
        jLabel34 = new javax.swing.JLabel();
        jPasswordField3 = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        jPanel58 = new javax.swing.JPanel();
        jButton41 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jButton45 = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Deema Baby Fair - Admin");
        setUndecorated(true);
        getContentPane().setLayout(null);

        jButton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close.png"))); // NOI18N
        jButton27.setContentAreaFilled(false);
        jButton27.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close - light.png"))); // NOI18N
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton27);
        jButton27.setBounds(1240, 0, 40, 40);

        jButton51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/minimize.png"))); // NOI18N
        jButton51.setContentAreaFilled(false);
        jButton51.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/minimize - light.png"))); // NOI18N
        jButton51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton51ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton51);
        jButton51.setBounds(1220, 0, 30, 40);

        jPanel2.setPreferredSize(new java.awt.Dimension(201, 661));

        jButton10.setText("Supplier");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton6.setText("Product");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Sales");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton9.setText("Store");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton8.setText("Order");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton12.setText("Change U/P");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("Log Out");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton11.setText("Employee");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton25.setText("Exit");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jButton40.setText("Reports");
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton40, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jButton12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton10, jButton11, jButton12, jButton13, jButton25, jButton7, jButton8, jButton9});

        jPanel3.setLayout(new java.awt.CardLayout());

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

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

        jButton20.setText("Remove Procuct");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
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
                .addGap(122, 122, 122)
                .addComponent(jButton20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton20))
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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1109, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Search", jPanel5);

        jLabel1.setText("Product ID");

        jLabel2.setText("Product Name");

        jButton18.setText("Add");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setText("Clear");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jLabel107.setText("Quantity");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel107))
                .addGap(71, 71, 71)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jButton18)
                        .addGap(18, 18, 18)
                        .addComponent(jButton19)
                        .addGap(0, 825, Short.MAX_VALUE))
                    .addComponent(productIdTxt)
                    .addComponent(productNameTxt)
                    .addComponent(productNameTxt2))
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(productIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(productNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel107)
                    .addComponent(productNameTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(98, 98, 98)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton19)
                    .addComponent(jButton18))
                .addContainerGap(324, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Add", jPanel6);

        jLabel3.setText("Selling Price");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel9.setText("Discount ");

        jButton14.setText("Enter");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jLabel10.setText("Search by");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Product Id", "Product Name" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField2)
                    .addComponent(jComboBox1, 0, 164, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(55, 55, 55)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jButton14))
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14))
                .addContainerGap(35, Short.MAX_VALUE))
        );

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
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 478, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Selling Price & Discount", jPanel23);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.add(jPanel4, "card2");

        jPanel7.setPreferredSize(new java.awt.Dimension(1093, 645));

        jTabbedPane6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane6MouseClicked(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jLabel13.setText("From");

        jLabel57.setText("To");

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Remove");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jDateChooser7.setDateFormatString("dd-MM-yyyy");

        jDateChooser2.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(jPanel57);
        jPanel57.setLayout(jPanel57Layout);
        jPanel57Layout.setHorizontalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel57))
                .addGap(64, 64, 64)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooser7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                .addGap(137, 137, 137)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(529, 529, 529))
        );
        jPanel57Layout.setVerticalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel57Layout.createSequentialGroup()
                        .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel57Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel13))
                            .addComponent(jButton1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3)
                            .addGroup(jPanel57Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel57))))
                    .addGroup(jPanel57Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jDateChooser7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel57, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane6.addTab("View", jPanel14);

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 545, Short.MAX_VALUE)
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
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel60, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
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
            .addComponent(jButton47, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
            .addComponent(jButton48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel61Layout.setVerticalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addComponent(jButton46)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton47)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton48)
                .addGap(26, 26, 26)
                .addComponent(jButton50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton49)
                .addContainerGap(56, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(jLabel64)
                .addGap(52, 52, 52)
                .addComponent(jLabel65)
                .addContainerGap(605, Short.MAX_VALUE))
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
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 906, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        jTabbedPane6.addTab("Add", jPanel15);

        jTable10.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane12.setViewportView(jTable10);

        jButton28.setText("Add");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jButton29.setText("Delete");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton29, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton28)
                .addGap(18, 18, 18)
                .addComponent(jButton29)
                .addGap(52, 52, 52))
        );

        jTextField15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField15ActionPerformed(evt);
            }
        });

        jComboBox27.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Customer Preferance", "Faulty Product", "Broken Seal", "Expired", " ", " " }));
        jComboBox27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox27ActionPerformed(evt);
            }
        });

        jLabel44.setText("Sales ID");

        jLabel49.setText("Product ID");

        jLabel50.setText("Date");

        jLabel51.setText("Reason");

        jLabel52.setText("Date");

        jLabel53.setText("Quantity");

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(jLabel49)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel38Layout.createSequentialGroup()
                                .addComponent(jLabel44)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel38Layout.createSequentialGroup()
                                .addComponent(jLabel53)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                                .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel38Layout.createSequentialGroup()
                                .addComponent(jLabel51)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox27, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel38Layout.createSequentialGroup()
                                .addComponent(jLabel52)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel38Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jComboBox28, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31))))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(jComboBox28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(jLabel52))
                .addGap(18, 18, 18)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(jComboBox27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(199, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(570, Short.MAX_VALUE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 29, Short.MAX_VALUE))
        );

        jTabbedPane6.addTab("Retured ", jPanel34);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1093, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 1044, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(39, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 656, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(jTabbedPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel7, "card3");

        jPanel8.setPreferredSize(new java.awt.Dimension(1093, 645));

        jTabbedPane2.setMaximumSize(new java.awt.Dimension(1111, 570));
        jTabbedPane2.setMinimumSize(new java.awt.Dimension(1111, 570));
        jTabbedPane2.setPreferredSize(new java.awt.Dimension(1111, 570));
        jTabbedPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane2MouseClicked(evt);
            }
        });

        jPanel18.setPreferredSize(new java.awt.Dimension(1106, 580));

        jButton15.setText("Search");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField7KeyReleased(evt);
            }
        });

        jLabel11.setText("Enter Order ID");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField7)
                .addGap(18, 18, 18)
                .addComponent(jButton15)
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton15))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1087, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("View", jPanel18);

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(jTable5);

        jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder("Order Details"));

        jLabel12.setText("Order ID");

        jLabel15.setText("Order Date");

        jLabel16.setText("Due Date");

        jLabel17.setText("Paymet Status");

        jLabel18.setText("Discount Recieved");

        jLabel19.setText("Supplier ID");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Paid");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Not Paid");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jDateChooser3.setDateFormatString("dd-MM-yyyy");

        jDateChooser4.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addGap(38, 38, 38)
                                .addComponent(jRadioButton2))
                            .addComponent(orderIdTxt)))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(discountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel19)
                        .addComponent(jLabel16)))
                .addGap(22, 22, 22)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser4, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                .addGap(226, 226, 226))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15)
                            .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16)
                            .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(orderIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(discountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jButton17.setText("Update Product");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton21.setText("Delete Product");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton22.setText("Confirm Order");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton16.setText("Add Product");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jButton16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton22)
                .addContainerGap())
        );

        jTabbedPane3.setBorder(javax.swing.BorderFactory.createTitledBorder("Product Details"));

        jLabel23.setText("Pro ID");

        jLabel24.setText("Product Name");

        jLabel25.setText("Quantity");

        jLabel26.setText("Unit Price");

        productIdTxt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productIdTxt1ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Expiry Date");

        jDateChooser8.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jCheckBox1))
                .addGap(30, 30, 30)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(productIdTxt1, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(productNameTxt1, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(jDateChooser8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(121, 121, 121)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26))
                .addGap(39, 39, 39)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(priceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 465, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productIdTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel25)
                    .addComponent(quantityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(productNameTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(priceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1)
                    .addComponent(jDateChooser8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1089, Short.MAX_VALUE)
            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 153, Short.MAX_VALUE)
            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("New Product", jPanel28);

        jLabel28.setText("Pro ID");

        jLabel29.setText("Product Name");

        jLabel30.setText("Quantity");

        jLabel31.setText("Unit Price");

        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jComboBox16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox16ActionPerformed(evt);
            }
        });

        jCheckBox2.setText("Expiry Date");

        jDateChooser1.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox16, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(jCheckBox2)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(118, 118, 118)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(60, 60, 60)
                        .addComponent(quantityTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(priceTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 460, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(quantityTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jComboBox16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(priceTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox2)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1089, Short.MAX_VALUE)
            .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 153, Short.MAX_VALUE)
            .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Old Product", jPanel29);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 858, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(77, Short.MAX_VALUE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        jTabbedPane2.addTab("Add", jPanel19);

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product Name", "Quantity", "Compartment ID"
            }
        ));
        jTable7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable7MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTable7);

        jLabel27.setText("Employee ID");

        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jButton4.setText("Reset");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel32.setText("ID");

        jLabel35.setText("Date");

        jLabel36.setText("Date");

        jLabel37.setText("Order ID");

        jButton24.setText("Confirm");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jTextField13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField13ActionPerformed(evt);
            }
        });

        jButton26.setText("Save to Compartment");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37)
                            .addComponent(jLabel27)
                            .addComponent(jLabel36))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField8)
                            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jTextField13, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel32))
                .addGap(18, 18, 18)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36))
                .addGap(37, 37, 37)
                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 271, Short.MAX_VALUE)
                .addComponent(jButton24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Receive", jPanel22);

        jTable12.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane10.setViewportView(jTable12);

        jButton30.setText("Add");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        jButton31.setText("Delete");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton31)
                .addGap(45, 45, 45))
        );

        jComboBox29.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Faulty Product", "Broken Seal", "Expired" }));

        jLabel54.setText("Date");

        jLabel55.setText("Quantity");

        jLabel56.setText("Product ID");

        jLabel66.setText("Reason");

        jLabel67.setText("Order ID");

        jTextField17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField17ActionPerformed(evt);
            }
        });

        jComboBox30.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Null" }));

        jLabel68.setText("Date");

        jTextField18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField18ActionPerformed(evt);
            }
        });

        jRadioButton7.setText("All the Products");

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel50Layout.createSequentialGroup()
                        .addComponent(jLabel66)
                        .addGap(55, 55, 55)
                        .addComponent(jComboBox29, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel50Layout.createSequentialGroup()
                        .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel67)
                            .addComponent(jLabel56)
                            .addComponent(jLabel68)
                            .addComponent(jLabel55))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField18)
                            .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField17)
                            .addGroup(jPanel50Layout.createSequentialGroup()
                                .addComponent(jComboBox30, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addComponent(jRadioButton7))))))
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel67))
                .addGap(22, 22, 22)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(jComboBox30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68)
                    .addComponent(jLabel54))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66)
                    .addComponent(jComboBox29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(193, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(583, Short.MAX_VALUE))
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Rejected", jPanel46);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1089, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.add(jPanel8, "card3");

        jPanel40.setBorder(javax.swing.BorderFactory.createTitledBorder("Search Details"));

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField6KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });

        jLabel38.setText("Enter Supply Name ");

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel38)
                .addGap(42, 42, 42)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(737, Short.MAX_VALUE))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6)
                    .addComponent(jLabel38))
                .addGap(261, 261, 261))
        );

        jPanel41.setBorder(javax.swing.BorderFactory.createTitledBorder("Supplier Details"));

        jLabel39.setText("Contact No");

        jLabel40.setText("Supplier Name");

        jLabel41.setText("Address");

        jLabel42.setText("Supplier ID");

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42)
                    .addComponent(jLabel40))
                .addGap(58, 58, 58)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(supplierNameTxt4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                    .addComponent(supplierIdTxt4, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(50, 50, 50)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39)
                    .addComponent(jLabel41))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(supplierContactTxt4, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(supplierAddressTxt4))
                .addGap(85, 85, 85))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(supplierIdTxt4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39)
                    .addComponent(supplierContactTxt4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(supplierNameTxt4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addComponent(supplierAddressTxt4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(jTable6);

        jButton32.setText("Delete");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        jButton33.setText("Update");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });

        jButton34.setText("Add ");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton33, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jButton34, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton32)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel40, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel39Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel41, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(170, Short.MAX_VALUE))
        );

        jTabbedPane9.addTab("Supplier", jPanel39);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1154, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTabbedPane9)
                    .addContainerGap()))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 661, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        jPanel3.add(jPanel9, "card3");

        jTabbedPane4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane4MouseClicked(evt);
            }
        });

        jComboBox31.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Product ID", "Compartment ID" }));
        jComboBox31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox31ActionPerformed(evt);
            }
        });

        jLabel69.setText("Search by");

        jTabbedPane5.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jPanel52.setBackground(new java.awt.Color(153, 153, 255));
        jPanel52.setLayout(null);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel52.add(jSeparator1);
        jSeparator1.setBounds(309, 3, 20, 90);

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
        jButton36.setBounds(507, 43, 110, 40);
        jPanel52.add(jTextField19);
        jTextField19.setBounds(70, 30, 80, 30);
        jPanel52.add(jTextField20);
        jTextField20.setBounds(70, 60, 80, 30);
        jPanel52.add(jTextField21);
        jTextField21.setBounds(380, 30, 80, 30);
        jPanel52.add(jTextField22);
        jTextField22.setBounds(380, 60, 80, 30);

        jLabel70.setText("Product ID");
        jPanel52.add(jLabel70);
        jLabel70.setBounds(10, 30, 70, 30);

        jLabel71.setText("Quantity");
        jPanel52.add(jLabel71);
        jLabel71.setBounds(20, 60, 60, 30);

        jLabel72.setText("Product ID");
        jPanel52.add(jLabel72);
        jLabel72.setBounds(320, 30, 70, 30);

        jLabel73.setText("Quantity");
        jPanel52.add(jLabel73);
        jLabel73.setBounds(330, 60, 60, 30);

        jLabel74.setForeground(new java.awt.Color(102, 102, 102));
        jLabel74.setText("Retrive products from store");
        jLabel74.setName(""); // NOI18N
        jPanel52.add(jLabel74);
        jLabel74.setBounds(340, 0, 170, 30);

        jLabel75.setForeground(new java.awt.Color(102, 102, 102));
        jLabel75.setText("Add products \nto store");
        jLabel75.setName(""); // NOI18N
        jPanel52.add(jLabel75);
        jLabel75.setBounds(30, 0, 120, 30);

        jTabbedPane5.addTab("Update the Store", jPanel52);

        jPanel53.setBackground(new java.awt.Color(153, 153, 255));
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

        jTabbedPane5.addTab("Add new products to the Store", jPanel53);

        jPanel54.setBackground(new java.awt.Color(153, 153, 255));
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

        jTabbedPane5.addTab("Delete Product", jPanel54);

        jPanel55.setBackground(new java.awt.Color(153, 153, 255));

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

        jTabbedPane5.addTab("Change Compartment", jPanel55);

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
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel51Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jComboBox31, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(490, Short.MAX_VALUE))
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
                .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(123, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("View", jPanel51);

        jTable14.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Compartment ID", "Product ID", "Action", "Previous Quantity", "New Quantity", "Date", "Time", "Emp_ID"
            }
        ));
        jScrollPane14.setViewportView(jTable14);

        javax.swing.GroupLayout jPanel56Layout = new javax.swing.GroupLayout(jPanel56);
        jPanel56.setLayout(jPanel56Layout);
        jPanel56Layout.setHorizontalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 948, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(191, Short.MAX_VALUE))
        );
        jPanel56Layout.setVerticalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                .addGap(62, 62, 62))
        );

        jTabbedPane4.addTab("History", jPanel56);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.add(jPanel10, "card3");

        jTabbedPane10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane10MouseClicked(evt);
            }
        });
        jTabbedPane10.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                jTabbedPane10ComponentMoved(evt);
            }
        });

        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });
        jTextField12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField12KeyReleased(evt);
            }
        });

        jComboBox32.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Employee ID", "First Name", "Last Name" }));

        jLabel22.setText("Search from");

        javax.swing.GroupLayout jPanel63Layout = new javax.swing.GroupLayout(jPanel63);
        jPanel63.setLayout(jPanel63Layout);
        jPanel63Layout.setHorizontalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel22)
                .addGap(32, 32, 32)
                .addComponent(jComboBox32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jTextField12, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
                .addGap(85, 85, 85))
        );
        jPanel63Layout.setVerticalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel63Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(25, 25, 25))
        );

        jTable11.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane11.setViewportView(jTable11);

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel63, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane11))
                .addContainerGap())
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel63, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(249, Short.MAX_VALUE))
        );

        jTabbedPane10.addTab("Search", jPanel43);

        jLabel76.setText("Emp ID");

        jLabel77.setText("First Name");

        jLabel78.setText("Last Name");

        jLabel79.setText("Gender");

        jLabel80.setText("NIC No");

        jLabel81.setText("Concact No");

        jLabel82.setText("DOB");

        jLabel83.setText("Address");

        jLabel84.setText("Salary");

        employeeIdTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeIdTxtActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setText("Male");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setText("Female");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        salaryTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaryTxtActionPerformed(evt);
            }
        });

        jLabel85.setText("Password");

        jDateChooser5.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout jPanel64Layout = new javax.swing.GroupLayout(jPanel64);
        jPanel64.setLayout(jPanel64Layout);
        jPanel64Layout.setHorizontalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel64Layout.createSequentialGroup()
                        .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel64Layout.createSequentialGroup()
                                    .addComponent(jRadioButton3)
                                    .addGap(18, 18, 18)
                                    .addComponent(jRadioButton4))
                                .addComponent(employeeIdTxt)
                                .addComponent(firstNameTxt)
                                .addComponent(lastNameTxt)
                                .addComponent(nicNoTxt)
                                .addComponent(contactNoTxt)
                                .addComponent(addressTxt)
                                .addComponent(salaryTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))
                            .addComponent(jDateChooser5, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel64Layout.createSequentialGroup()
                        .addComponent(jLabel85)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel64Layout.setVerticalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel76)
                    .addComponent(employeeIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel77)
                    .addComponent(firstNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel78)
                    .addComponent(lastNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel79)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addGap(18, 18, 18)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel80)
                    .addComponent(nicNoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel81)
                    .addComponent(contactNoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel82)
                    .addComponent(jDateChooser5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel83)
                    .addComponent(addressTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel84)
                    .addComponent(salaryTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel85)
                    .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(186, Short.MAX_VALUE))
        );

        jButton63.setText("Add");
        jButton63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton63ActionPerformed(evt);
            }
        });

        jButton64.setText("Reset");
        jButton64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton64ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel65Layout = new javax.swing.GroupLayout(jPanel65);
        jPanel65.setLayout(jPanel65Layout);
        jPanel65Layout.setHorizontalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton64, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel65Layout.setVerticalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton63)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton64)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 320, Short.MAX_VALUE)
                .addComponent(jPanel65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane10.addTab("Add", jPanel44);

        jLabel86.setText("Emp ID");

        jLabel87.setText("First Name");

        jLabel88.setText("Last Name");

        jLabel89.setText("Gender");

        jLabel90.setText("NIC No");

        jLabel91.setText("Concact No");

        jLabel92.setText("DOB");

        jLabel93.setText("Address");

        jLabel94.setText("Salary");

        buttonGroup3.add(jRadioButton5);
        jRadioButton5.setText("Male");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        buttonGroup3.add(jRadioButton6);
        jRadioButton6.setText("Female");
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });

        salaryTxt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaryTxt1ActionPerformed(evt);
            }
        });

        jLabel95.setText("Password");

        jComboBox26.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox26ItemStateChanged(evt);
            }
        });
        jComboBox26.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox26PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jComboBox26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox26ActionPerformed(evt);
            }
        });

        jDateChooser6.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout jPanel67Layout = new javax.swing.GroupLayout(jPanel67);
        jPanel67.setLayout(jPanel67Layout);
        jPanel67Layout.setHorizontalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel67Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel67Layout.createSequentialGroup()
                        .addGroup(jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel67Layout.createSequentialGroup()
                                    .addComponent(jRadioButton5)
                                    .addGap(18, 18, 18)
                                    .addComponent(jRadioButton6))
                                .addComponent(firstNameTxt1)
                                .addComponent(lastNameTxt1)
                                .addComponent(nicNoTxt1)
                                .addComponent(contactNoTxt1)
                                .addComponent(addressTxt1)
                                .addComponent(salaryTxt1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                                .addComponent(jComboBox26, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jDateChooser6, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel67Layout.createSequentialGroup()
                        .addComponent(jLabel95)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(passwordTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel67Layout.setVerticalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel67Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel86)
                    .addComponent(jComboBox26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel87)
                    .addComponent(firstNameTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel88)
                    .addComponent(lastNameTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel89)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton6))
                .addGap(18, 18, 18)
                .addGroup(jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel90)
                    .addComponent(nicNoTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel91)
                    .addComponent(contactNoTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel92)
                    .addComponent(jDateChooser6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel93)
                    .addComponent(addressTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel94)
                    .addComponent(salaryTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel95)
                    .addComponent(passwordTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(180, Short.MAX_VALUE))
        );

        jButton66.setText("Update");
        jButton66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton66ActionPerformed(evt);
            }
        });

        jButton67.setText("Reset");
        jButton67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton67ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel68Layout = new javax.swing.GroupLayout(jPanel68);
        jPanel68.setLayout(jPanel68Layout);
        jPanel68Layout.setHorizontalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel68Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton67, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel68Layout.setVerticalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel68Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton66)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton67)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel67, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 320, Short.MAX_VALUE)
                .addComponent(jPanel68, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane10.addTab("Update", jPanel45);

        jLabel43.setText("Enter Bonus amount per sale :");

        jLabel45.setText("Year :");

        jLabel46.setText("Month :");

        jLabel47.setText("Year");

        jLabel48.setText("Month");

        jButton5.setText("Calculate");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTable8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee ID", "First Name", "Last Name", "Salary", "Bonus"
            }
        ));
        jScrollPane8.setViewportView(jTable8);

        jButton23.setText("Pay Salary");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel66Layout = new javax.swing.GroupLayout(jPanel66);
        jPanel66.setLayout(jPanel66Layout);
        jPanel66Layout.setHorizontalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel66Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 796, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel66Layout.createSequentialGroup()
                        .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel43)
                            .addComponent(jLabel45)
                            .addComponent(jLabel46))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel48)
                            .addComponent(jLabel47)
                            .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel66Layout.createSequentialGroup()
                                    .addComponent(jButton5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton23))
                                .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(323, Short.MAX_VALUE))
        );
        jPanel66Layout.setVerticalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel66Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(jLabel47))
                .addGap(18, 18, 18)
                .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(jLabel48))
                .addGap(28, 28, 28)
                .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton23))
                .addGap(69, 69, 69)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE))
        );

        jTabbedPane10.addTab("Pay Salary", jPanel66);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1154, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTabbedPane10)
                    .addContainerGap()))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 661, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        jPanel3.add(jPanel11, "card3");

        jLabel20.setText("Enter your current password");

        jLabel33.setText("Enter your new password");

        jLabel34.setText("Renter your new password");

        jButton2.setText("Confirm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel62Layout = new javax.swing.GroupLayout(jPanel62);
        jPanel62.setLayout(jPanel62Layout);
        jPanel62Layout.setHorizontalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel62Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel62Layout.createSequentialGroup()
                            .addComponent(jLabel20)
                            .addGap(84, 84, 84)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel62Layout.createSequentialGroup()
                            .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel33)
                                .addComponent(jLabel34))
                            .addGap(92, 92, 92)
                            .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPasswordField3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(257, Short.MAX_VALUE))
        );
        jPanel62Layout.setVerticalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel62Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addGap(34, 34, 34)
                .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addGap(43, 43, 43)
                .addComponent(jButton2)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jPanel62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(459, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jPanel62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(307, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel12, "card3");

        jPanel58.setMinimumSize(new java.awt.Dimension(1154, 661));
        jPanel58.setPreferredSize(new java.awt.Dimension(1093, 645));

        jButton41.setText("Employee monthly salary report");
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });

        jButton42.setText("Employee monthly sales  report");
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });

        jButton43.setText("Stock report");
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });

        jButton44.setText("Product Expiry Dates");
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton44ActionPerformed(evt);
            }
        });

        jButton45.setText("Employee Yearly Sales Report");
        jButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton45ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel58Layout = new javax.swing.GroupLayout(jPanel58);
        jPanel58.setLayout(jPanel58Layout);
        jPanel58Layout.setHorizontalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton45, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(203, 203, 203)
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton43, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton44, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(375, Short.MAX_VALUE))
        );
        jPanel58Layout.setVerticalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton43, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton44, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addComponent(jButton45, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(214, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel58, "card10");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1083, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1300, 680);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/adminScreen.png"))); // NOI18N
        background.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                backgroundMouseDragged(evt);
            }
        });
        background.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backgroundMousePressed(evt);
            }
        });
        getContentPane().add(background);
        background.setBounds(0, -15, 1350, 740);

        setSize(new java.awt.Dimension(1320, 717));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

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

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        try {
            // TODO add your handling code here:
            if(productNameTxt.getText().isEmpty())
                JOptionPane.showMessageDialog(null,"Enter a product name first", "", WARNING_MESSAGE);
            else if (productNameTxt1.getText().isEmpty()){
                String sql = "insert into products (Pro_ID,Product_name,Quantity) values (?,?,?)";

                pst = (PreparedStatement) conn.prepareStatement(sql);

                pst.setString(1, productIdTxt.getText());
                pst.setString(2, productNameTxt.getText());
                pst.setString(3, productNameTxt2.getText());

                pst.execute();
                updateProductsTable();

                JOptionPane.showMessageDialog(null,"Saved");
                productIdTxt.setText("");
                productNameTxt.setText("");
                productNameTxt2.setText("");

                checkProductId();
            }else{
                String sql = "insert into products (Pro_ID,Product_name,Quantity) values (?,?,?)";

                pst = (PreparedStatement) conn.prepareStatement(sql);

                pst.setString(1, productIdTxt.getText());
                pst.setString(2, productNameTxt.getText());
                pst.setString(3, productNameTxt1.getText());
                

                pst.execute();
                updateProductsTable();

                JOptionPane.showMessageDialog(null,"Saved");
                productIdTxt.setText("");
                productNameTxt.setText("");
                productNameTxt1.setText("");

                checkProductId();            
            
            }
            

            

        } catch (Exception ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        productIdTxt.setText("");
        productNameTxt.setText("");
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            // TODO add your handling code here:
            updateProductsTable1();
            updateProductsTable();
            currentDateTime();
            jPanel3.removeAll();
            jPanel3.repaint();
            jPanel3.revalidate();   
            jPanel3.add(jPanel4);
            jPanel3.repaint();
            jPanel3.revalidate();
         
        } catch (Exception ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        try {
            // TODO add your handling code here:
            String sql = "SELECT * FROM `sales` WHERE `Date` BETWEEN ? AND ? ;";

            pst = (PreparedStatement) conn.prepareStatement(sql);
            String date1 =  (jDateChooser7.getDate().getYear()+1900)+"-"+(jDateChooser7.getDate().getMonth()+1)+"-"+jDateChooser7.getDate().getDate();
            String date2 = (jDateChooser2.getDate().getYear()+1900)+"-"+(jDateChooser2.getDate().getMonth()+1)+"-"+jDateChooser2.getDate().getDate();
            
            
            pst.setString(1, date1);
            pst.setString(2, date2);
            // pst.setString(3, (String) jComboBox9.getSelectedItem());
            //pst.setString(4, (String) jComboBox10.getSelectedItem());
            // pst.setString(5, (String) jComboBox11.getSelectedItem());
            // pst.setString(6, (String) jComboBox12.getSelectedItem());

            //System.out.println(date1);
            // System.out.println(date2);
            rs = pst.executeQuery();
            //int count =1;
            while(rs.next()){
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));

            }

            // System.out.println(count++);

        } catch (SQLException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            // TODO add your handling code here:
            int row = jTable1.getSelectedRow();
            String sid = (String) jTable1.getModel().getValueAt(row, 0);
            //String pid = (String) jTable1.getModel().getValueAt(row, 1);
            String sql = "DELETE FROM `sales` WHERE `Sales_ID` = ? ";

            pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, sid);
            //pst.setString(2, pid);
            int r = pst.executeUpdate();
            //list.remove(row);
            updateSalesTable1();
        } catch (SQLException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton46ActionPerformed
        
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
                pst.setString(4, jLabel7.getText());

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
                        String Q = rs2.getString("Quantity");
                        String newQ = Integer.toString(Integer.parseInt(Q)- Integer.parseInt(jTextField10.getText()));
                        String s1 = "UPDATE `products` SET `Quantity`=? WHERE `Pro_ID` = ?;";
                        PreparedStatement pst =  (PreparedStatement) conn.prepareStatement(s1);
                        pst.setString(1, newQ);
                        pst.setString(2, jTextField9.getText());
                        pst.execute();
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
               // pst.execute();
                
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
            sum =0;
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
           // String sid = (String) jTable9.getModel().getValueAt(row, 0);
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
           // String sid = (String) jTable9.getModel().getValueAt(row, 0);
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
        }
    }//GEN-LAST:event_jButton48ActionPerformed

    private void jButton49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton49ActionPerformed
        try {
            // TODO add your handling code here:
            tot = 0;
            sum=0;
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

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            // TODO add your handling code here:
            updateReturnedSaleTable();
            updateSalesTable1();
            currentDateTime();
            jLabel7.setText(Login.id);
            jLabel5.setText(day+"/"+month+"/"+year);
            jLabel6.setText(hour+":"+minute+":"+second);
            jPanel3.removeAll();
            jPanel3.repaint();
            jPanel3.revalidate();
            jPanel3.add(jPanel7);
            jPanel3.repaint();
            jPanel3.revalidate();
        } catch (Exception ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try {
            // TODO add your handling code here:
            updateOrderTable();
            fillProductIdName();
            currentDateTime();
            checkProductId();
            fillSupplier();
            jPanel3.removeAll();
            jPanel3.repaint();
            jPanel3.revalidate();
            jPanel3.add(jPanel8);
            jPanel3.repaint();
            jPanel3.revalidate();
        } catch (SQLException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        updatetbl();
        updatetbl1();
        currentDateTime();
        jPanel3.removeAll();
        jPanel3.repaint();
        jPanel3.revalidate();
        jPanel3.add(jPanel10);
        jPanel3.repaint();
        jPanel3.revalidate();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        try {
            // TODO add your handling code here:
            updateSupplierTable();
            currentDateTime();
            jPanel3.removeAll();
            jPanel3.repaint();
            jPanel3.revalidate();  
            jPanel3.add(jPanel9);
            jPanel3.repaint();
            jPanel3.revalidate();
        } catch (SQLException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        try {
            // TODO add your handling code here:
            updateEmployeeTable();
            currentDateTime();
            jPanel3.removeAll();
            jPanel3.repaint();
            jPanel3.revalidate();
            jPanel3.add(jPanel11);
            jPanel3.repaint();
            jPanel3.revalidate();
        } catch (SQLException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        currentDateTime();
        jPanel3.removeAll();
        jPanel3.repaint();
        jPanel3.revalidate();   
        jPanel3.add(jPanel12);
        jPanel3.repaint();
        jPanel3.revalidate();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            int row = jTable6.getSelectedRow();
            String sid = (String) jTable6.getModel().getValueAt(row, 0);
            //String pid = (String) jTable6.getModel().getValueAt(row, 1);
            String sql = "DELETE FROM `supplier` WHERE `Sup_ID` = ? ";

            pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, sid);
            //pst.setString(2, pid);
            int r = pst.executeUpdate();
            //list.remove(row);
            updateSupplierTable();
            checkSupplierId();
        } catch (SQLException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }catch (ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(null,"Select a row first","",WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        try {
            // TODO add your handling code here:
            updateSupplier++;
            row = jTable6.getSelectedRow();
            String sid = (String) jTable6.getModel().getValueAt(row, 0);
            //String pid = (String) jTable1.getModel().getValueAt(row, 1);
            //int qty =  (int) jTable1.getModel().getValueAt(row, 2);
            //double up = (double) jTable1.getModel().getValueAt(row, 3);
            //double dg = (double) jTable1.getModel().getValueAt(row, 4);
            String name=null;
            String cn=null ;
            String ad=null ;
            
            
            
            
            
            String sql = "SELECT * FROM `supplier` WHERE `Sup_ID` = ? ";
            
            pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, sid);
            //pst.setString(2, pid);
            rs = pst.executeQuery();
            if(rs.next()){
                //sid = rs.getString("Sales_ID");
                name = rs.getString("Sup_Name");
                cn = rs.getString("Contact_No");
                ad = rs.getString("Address");
                //dg = rs.getString("Discount_Given");
            }
            supplierIdTxt4.setText(sid);
            supplierNameTxt4.setText(name);
            supplierContactTxt4.setText(cn);
            supplierAddressTxt4.setText(ad);
        } catch (SQLException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }catch (ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(null,"Select a row first","",WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        // TODO add your handling code here:
        if(supplierIdTxt4.getText().isEmpty() || supplierNameTxt4.getText().isEmpty() ||supplierContactTxt4.getText().isEmpty() || supplierAddressTxt4.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Fill suppier details","",WARNING_MESSAGE);
        }else{
            try {
                if(updateSupplier==0){
                    String sql = "insert into supplier (Sup_ID,Sup_Name,Contact_No,Address) values (?,?,?,?)";
            
                    pst = (PreparedStatement) conn.prepareStatement(sql);
            
            pst.setString(1, supplierIdTxt4.getText());
            pst.setString(2, supplierNameTxt4.getText());
            pst.setString(3, supplierContactTxt4.getText());
            pst.setString(4, supplierAddressTxt4.getText());
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null,"Saved"); 
            //viewSupplier views = new viewSupplier();
            
                }else{
                    String sql = "UPDATE `supplier` SET `Sup_Name`=?,`Contact_No`=?,`Address`=? WHERE `Sup_ID` = ?";
                    
                    pst = (PreparedStatement) conn.prepareStatement(sql);
                    pst.setString(1, supplierNameTxt4.getText());
                    pst.setString(2, supplierContactTxt4.getText());
                    pst.setString(3, supplierAddressTxt4.getText());
                    pst.setString(4, supplierIdTxt4.getText());
                    
                    int r = pst.executeUpdate();
                }
            
            updateSupplierTable();
            
            supplierIdTxt4.setText("");
            supplierNameTxt4.setText("");
            supplierContactTxt4.setText("");
            supplierAddressTxt4.setText("");
            checkSupplierId();
            updateSupplier=0;
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        
        
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void employeeIdTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeIdTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeIdTxtActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        gender = "M";
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
        gender = "F";
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void salaryTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salaryTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salaryTxtActionPerformed

    private void jButton63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton63ActionPerformed
        // TODO add your handling code here:
        //saveEmploee();
        String date = String.format("%d", jDateChooser5.getDate().getDate());
        String month = String.format("%d", jDateChooser5.getDate().getMonth()+1);
        String year = String.format("%d", jDateChooser5.getDate().getYear()+1900);
        
        
        if (employeeIdTxt.getText().isEmpty() ||
            firstNameTxt.getText().isEmpty() ||
            lastNameTxt.getText().isEmpty() ||
            jDateChooser5.getDate().getDate() < 0 ||
            jDateChooser5.getDate().getMonth()+1 <0 ||
            jDateChooser5.getDate().getYear()+1900 < 0 ||
            (jRadioButton3.isSelected() &&
            jRadioButton4.isSelected()) ||
            nicNoTxt.getText().isEmpty() ||
            contactNoTxt.getText().isEmpty() ||
            addressTxt.getText().isEmpty() ||
            salaryTxt.getText().isEmpty() ||
            passwordTxt.getText().isEmpty() ){
        
            JOptionPane.showMessageDialog(null, "fill all employee details first");
            
        }else{
        
            try{
                String sql = "INSERT INTO `deemababyfair`.`employee` (`Emp_ID`, `First_Name`, `Last_Name`, `Gender`, `DOB`, `Age`, `NIC_No`, `Contact_No`, `Address`, `Salary`, `Password`) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?);";


                pst = (PreparedStatement) conn.prepareStatement(sql);

                pst.setString(1,employeeIdTxt.getText() );
                pst.setString(2, firstNameTxt.getText());
                pst.setString(3, lastNameTxt.getText());
                pst.setString(4, gender);
                String y = String.format("%d", jDateChooser5.getDate().getYear()+1900);
                String m = String.format("%d", jDateChooser5.getDate().getMonth()+1);
                String d = String.format("%d", jDateChooser5.getDate().getDate());

                int age  = this.year - Integer.parseInt(y);

                pst.setString(5, y+"-"+m+"-"+d);
                pst.setInt(6, age);
                pst.setString(7, nicNoTxt.getText());
                pst.setInt(8, Integer.parseInt(contactNoTxt.getText()));
                pst.setString(9, addressTxt.getText());
                pst.setDouble(10, Double.parseDouble(salaryTxt.getText()));
                pst.setString(11, passwordTxt.getText());
                //pst.setString(11, sql);

                pst.execute();

                JOptionPane.showMessageDialog(null,"Saved");

                employeeIdTxt.setText("");
                firstNameTxt.setText("");
                lastNameTxt.setText("");
                
                jRadioButton3.setSelected(false);
                jRadioButton4.setSelected(false);
                nicNoTxt.setText("");
                contactNoTxt.setText("");
                addressTxt.setText("");
                salaryTxt.setText("");
                passwordTxt.setText("");
                employeeId();
            }
            catch(Exception ex){
                Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        

    }//GEN-LAST:event_jButton63ActionPerformed

    private void jButton64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton64ActionPerformed
        // TODO add your handling code here:
                employeeIdTxt.setText("");
                firstNameTxt.setText("");
                lastNameTxt.setText("");
                //jComboBox21.setSelectedIndex(0);
                //jComboBox20.setSelectedIndex(0);
                //jComboBox19.setSelectedIndex(0);
                jRadioButton3.setSelected(false);
                jRadioButton4.setSelected(false);
                nicNoTxt.setText("");
                contactNoTxt.setText("");
                addressTxt.setText("");
                salaryTxt.setText("");
                passwordTxt.setText("");
        
    }//GEN-LAST:event_jButton64ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        paymentStatus = "Paid";
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        paymentStatus = "Not Paid";
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        try {
            if (orderIdTxt.getText().isEmpty() || discountTxt.getText().isEmpty() ){
                JOptionPane.showMessageDialog(null, "Fill oder details first","",WARNING_MESSAGE);

            }else{
                if (count1==0 ){

                    // TODO add your handling code here:
                    //orderid = orderIdTxt.getText();
                    String orderdate = String.format("%d", jDateChooser4.getDate().getDate());
                    String ordermonth = String.format("%d", jDateChooser4.getDate().getMonth()+1);
                    String orderyear = String.format("%d", jDateChooser4.getDate().getYear()+1900);
                    String duedate = String.format("%d", jDateChooser4.getDate().getDate());
                    String duemonth = String.format("%d", jDateChooser4.getDate().getMonth()+1);
                    String dueyear = String.format("%d", jDateChooser4.getDate().getYear()+1900);




                    String sql = "INSERT INTO `deemababyfair`.`order` (`Order_ID`, `Order_Date`, `Payment_Status`, `Due_Date`, `Discount_Recieved`, `Sup_ID`) "
                    + "VALUES (?, ?, ?, ?, ?, ?);";

                    pst = (PreparedStatement) conn.prepareStatement(sql);

                    pst.setString(1, orderIdTxt.getText());
                    pst.setString(2, orderyear+"-"+ordermonth+"-"+orderdate);
                    pst.setString(3, paymentStatus);
                    pst.setString(4, dueyear+"-"+duemonth+"-"+duedate);
                    pst.setString(5, discountTxt.getText());
                    pst.setString(6, (String) jComboBox2.getSelectedItem());

                    pst.execute();
                    count1++;

                }
                if(updateOrderProduct==0){
                    if ((productIdTxt1.getText().isEmpty() || productNameTxt1.getText().isEmpty() || quantityTxt.getText().isEmpty() || priceTxt.getText().isEmpty()) &&
                         (quantityTxt1.getText().isEmpty() || priceTxt1.getText().isEmpty())){
                        JOptionPane.showMessageDialog(null, "Fill product details first","",WARNING_MESSAGE);
                    }
                    else {
                        if (productIdTxt1.getText().isEmpty() || productNameTxt1.getText().isEmpty() || quantityTxt.getText().isEmpty() || priceTxt.getText().isEmpty()){

                        }else{
                            String sql = "insert into products (Pro_ID,Product_name) values (?,?)";


                            pst = (PreparedStatement) conn.prepareStatement(sql);

                            pst.setString(1, productIdTxt1.getText());
                            pst.setString(2, productNameTxt1.getText());

                            pst.execute();

                            //JOptionPane.showMessageDialog(null,"Saved");  

                            sql = "INSERT INTO `deemababyfair`.`order_product` (`Order_ID`, `Pro_ID`, `Quantity`, `Unit_Price`, `Expiriy_Date`) "
                                    + "VALUES (?, ?, ?, ?, ?);";
                            
                            String expirydate = null;
                            String expirymonth = null;                
                            String expiryyear = null;
                            pst = (PreparedStatement) conn.prepareStatement(sql);
                            if(jCheckBox1.isSelected()){
                             expirydate = String.format("%d", jDateChooser8.getDate().getDate());
                             expirymonth = String.format("%d", jDateChooser8.getDate().getMonth()+1);
                             expiryyear = String.format("%d", jDateChooser8.getDate().getYear()+1900);
                            }

                            pst.setString(1, orderIdTxt.getText());
                            pst.setString(2, productIdTxt1.getText());
                            pst.setString(3, quantityTxt.getText());
                            pst.setString(4, priceTxt.getText());
                            if(jCheckBox1.isSelected())
                                pst.setString(5, expiryyear+"-"+expirymonth+"-"+expirydate);
                            else
                                pst.setString(5, null);

                            pst.execute();

                            JOptionPane.showMessageDialog(null,"Saved");  
                            updateOrderTable1();
                            checkProductId();
                            //productIdTxt1.setText("");
                            productNameTxt1.setText("");
                            quantityTxt.setText("");
                            priceTxt.setText("");
                        }
                   
                        if (quantityTxt1.getText().isEmpty() || priceTxt1.getText().isEmpty()){
                    
                        }else{
                            String sql = "INSERT INTO `deemababyfair`.`order_product` (`Order_ID`, `Pro_ID`, `Quantity`, `Unit_Price`, `Expiriy_Date`) "
                            + "VALUES (?, ?, ?, ?, ?);";

                            
                            String expirydate = null;
                            String expirymonth = null ;
                            String expiryyear = null;
                            
                            pst = (PreparedStatement) conn.prepareStatement(sql);
                            if(jCheckBox2.isSelected()){
                             expirydate = String.format("%d", jDateChooser1.getDate().getDate());
                             expirymonth = String.format("%d", jDateChooser1.getDate().getMonth()+1);
                             expiryyear = String.format("%d", jDateChooser1.getDate().getYear()+1900);

                            }
                            pst.setString(1, orderIdTxt.getText());
                            pst.setString(2, (String) jComboBox3.getSelectedItem());
                            pst.setString(3, quantityTxt1.getText());
                            pst.setString(4, priceTxt1.getText());
                            if(jCheckBox2.isSelected())
                                pst.setString(5, expiryyear+"-"+expirymonth+"-"+expirydate);
                            else
                                pst.setString(5, null);

                            pst.execute();

                            JOptionPane.showMessageDialog(null,"Saved");
                            updateOrderTable1();
                            quantityTxt1.setText("");
                            priceTxt1.setText("");
                        }
                    }
                }else{
                    String sql = "UPDATE `order_product` SET `Quantity`=?,`Unit_Price`=?,`Expiriy_Date`=? "
                            + "WHERE `Order_ID` = ? AND `Pro_ID` = ?;";
                    
                    pst = (PreparedStatement) conn.prepareStatement(sql);
                    
                    String expirydate = String.format("%d", jDateChooser8.getDate().getDate());
                    String expirymonth = String.format("%d", jDateChooser8.getDate().getMonth()+1);
                    String expiryyear = String.format("%d", jDateChooser8.getDate().getYear()+1900);
                    
                    pst.setString(1, quantityTxt.getText());
                    pst.setString(2, priceTxt.getText());
                    if(jCheckBox1.isSelected())
                        pst.setString(3, expiryyear+"-"+expirymonth+"-"+expirydate);
                    else
                        pst.setString(3, null);
                    
                    pst.setString(4, orderIdTxt.getText());
                    pst.setString(5, productIdTxt1.getText());
                    
                    int r = pst.executeUpdate();
                   
                
                    JOptionPane.showMessageDialog(null,"Saved");  
                    updateOrderTable1();
                    checkProductId();
                            //productIdTxt1.setText("");
                    productNameTxt1.setText("");
                    quantityTxt.setText("");
                    priceTxt.setText("");
                
                    
                }
                jCheckBox1.setSelected(false);
                jCheckBox2.setSelected(false);
                //jComboBox13.setSelectedIndex(0);
                ///jComboBox14.setSelectedIndex(0);
                //jComboBox15.setSelectedIndex(0);
            }   
        } catch (Exception ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            updateOrderProduct++;
            //sum=0;
            row = jTable5.getSelectedRow();
            String oid = (String) jTable5.getModel().getValueAt(row, 0);
            String pid = (String) jTable5.getModel().getValueAt(row, 1);
            //int qty =  (int) jTable1.getModel().getValueAt(row, 2);
            //double up = (double) jTable1.getModel().getValueAt(row, 3);
            //double dg = (double) jTable1.getModel().getValueAt(row, 4);
            String qty=null;
            String up=null ;
            String name=null ;

            String sql = "SELECT order_product.`Quantity`, order_product.`Unit_Price`, `Product_Name` FROM `order_product`, `products` "
                    + "WHERE `Order_ID` = ? AND products.`Pro_ID` = ? AND order_product.`Pro_ID` = products.`Pro_ID` ";

            pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, oid);
            pst.setString(2, pid);
            rs = pst.executeQuery();
            if(rs.next()){
                //sid = rs.getString("Sales_ID");
                //pid = rs.getString("Pro_ID");
                qty = rs.getString("Quantity");
                up = rs.getString("Unit_Price");
                name = rs.getString("Product_Name");
            }
            productIdTxt1.setText(pid);
            productNameTxt1.setText(name);
            quantityTxt.setText(qty);
            priceTxt.setText(up);

            //System.out.println(sid+" "+pid+" "+qty+" "+up+" "+dg);

            //addSalesProduct asp = new addSalesProduct(sid,pid,qty,up,dg,addSales.this,row);
            //asp.setVisible(true);

        
        }catch(SQLException ex){
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(null,"Select a row first","",WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
         try {
            // TODO add your handling code here:
            int row = jTable5.getSelectedRow();
            String oid = (String) jTable5.getModel().getValueAt(row, 0);
            String pid = (String) jTable5.getModel().getValueAt(row, 1);
            String sql = "DELETE FROM `order_product` WHERE `Order_ID` = ? AND `Pro_ID` = ? ";

            pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, oid);
            pst.setString(2, pid);
            int r = pst.executeUpdate();
            //list.remove(row);
            updateOrderTable1();
        } catch (SQLException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }catch (ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(null,"Select a row first","",WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        try {
            // TODO add your handling code here:
            checkOrderId();
            discountTxt.setText("");
            updateOrderTable1();
            fillProductIdName();
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton22ActionPerformed

    private void productIdTxt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productIdTxt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productIdTxt1ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        try {
            // TODO add your handling code here:

            String sql = "select Product_Name from Products where Pro_ID = ?";

            pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, (String) jComboBox3.getSelectedItem());
            rs   = pst.executeQuery();

            String name=null;
            String id=null;
            if(rs.next()){
                // id = rs.getString("Pro_ID");
                name = rs.getString("Product_Name");
                jComboBox16.setSelectedItem(name);
            }
            //System.out.println(id);
            //System.out.println(name);

        } catch (Exception ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox16ActionPerformed
        try {
            // TODO add your handling code here:
            String sql = "select Pro_Id from Products where Product_Name = ?";

            pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, (String) jComboBox16.getSelectedItem());
            rs   = pst.executeQuery();

            String name=null;
            String id=null;
            if(rs.next()){
                id = rs.getString("Pro_ID");
                //name = rs.getString("Product_Name");
                jComboBox3.setSelectedItem(id);
            }
            //System.out.println(id);
            //System.out.println(name);

        } catch (SQLException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jComboBox16ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        
        try {
            if (jTextField2.getText().isEmpty() || jTextField4.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Select a row first", "", WARNING_MESSAGE);
            }
            else{
                String sql = "UPDATE `products` SET `Unit_Price`=?,`Discount`=? WHERE `Pro_ID` = ?;";
            
                pst = (PreparedStatement) conn.prepareStatement(sql);

                pst.setString(1,jTextField2.getText());
                pst.setString(2,jTextField4.getText());
                pst.setString(3,pid);

                int r = pst.executeUpdate();
                updateProductsTable1();
                jTextField2.setText("");
                jTextField4.setText("");
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Enter correct data", "", WARNING_MESSAGE);
            //Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            int row = jTable2.getSelectedRow();
            
            pid = (String) jTable2.getModel().getValueAt(row, 0);
           
            
            String Sql = "SELECT * FROM `products` WHERE `Pro_ID` = ? ";
            
            pst = (PreparedStatement) conn.prepareStatement(Sql);
            
            pst.setString(1, pid);
            
            ResultSet rs1;
            rs1 = pst.executeQuery();
            
            if(rs1.next()){
                
                String price = rs1.getString("Unit_Price");
                String discount = rs1.getString("Discount");
                jTextField2.setText(price);
                jTextField4.setText(discount);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextField5KeyTyped

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
        // TODO add your handling code here:
        try {
        if (jComboBox1.getSelectedIndex()==0){
            
                String sql = "select * from products where Pro_ID like ?";
                pst = (PreparedStatement) conn.prepareStatement(sql);
                pst.setString(1,jTextField5.getText()+"%");
               // System.out.println(0);
            
        }
        else if (jComboBox1.getSelectedIndex()==1){
            
                String sql = "select * from products where Product_Name like ?";
                pst = (PreparedStatement) conn.prepareStatement(sql);
                pst.setString(1,jTextField5.getText()+"%");
                //System.out.println(1);
            
        }
            ResultSet rs1 = pst.executeQuery();
            
            //while(rs1.next())
            jTable2.setModel(DbUtils.resultSetToTableModel(rs1));
            
            if (jTextField5.getText().isEmpty()){
                //System.out.println("test12");
                updateProductsTable1();
            }
        } catch (SQLException ex) {
                Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jTextField5KeyReleased

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        try {
            // TODO add your handling code here:
            int row = jTable3.getSelectedRow();
            
            pid = (String) jTable3.getModel().getValueAt(row, 0);
            
            
            String Sql = "DELETE FROM `products` WHERE `Pro_ID` =?;";
            
            pst = (PreparedStatement) conn.prepareStatement(Sql);
            
            pst.setString(1, pid);
            
            
            int r = pst.executeUpdate();
            updateProductsTable();
        } catch (SQLException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(null, "Select a row first", "",WARNING_MESSAGE);
            
        }
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jTextField6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextField6KeyPressed

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
        // TODO add your handling code here:
         try {
            
           // String productName = jTextField1.getText();
            String sql = "select * from supplier where Sup_Name like ?";
            pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1,jTextField6.getText()+"%");
            rs=pst.executeQuery();
            jTable6.setModel(DbUtils.resultSetToTableModel(rs));
            
            if (jTextField6.getText().isEmpty()){
                //System.out.println("test12");
                updateSupplierTable();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextField6KeyReleased

    private void jTextField7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyReleased
        // TODO add your handling code here:
        try {

            String orderrId = jTextField7.getText();
            String sql = "SELECT * FROM `order` WHERE Order_ID like ? ";
            pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1,jTextField7.getText()+"%");
            rs=pst.executeQuery();
            jTable4.setModel(DbUtils.resultSetToTableModel(rs));
            String x = jTextField7.getText();
            //System.out.print(x);
            if (x.isEmpty()){
                //System.out.println("test12");
                updateOrderTable();
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextField7KeyReleased

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        try {
            // TODO add your handling code here:
            this.dispose();
            Login ls = new Login();
            ls.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        //System.out.println(orderReceivedCount);
        if(orderReceivedCount==0){
            try {
                orderReceivedCount++;
                
               // TODO add your handling code here:
               String sql = "SELECT `Order_ID`, order_product.`Pro_ID`, order_product.`Quantity`, `Product_Name` FROM `order_product`,`products` "
                       + "WHERE `Order_ID` = ? AND order_product.`Pro_ID` = products.`Pro_ID` ";

               pst = (PreparedStatement) conn.prepareStatement(sql);
               pst.setString(1, jTextField8.getText());

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

               model = (DefaultTableModel) jTable7.getModel();
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

    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        try {
            // TODO add your handling code here:
            currentDateTime();
            int rows = jTable7.getRowCount();
            int Quantity = 0,ComId=0;
            

            
            String sql4 = "SELECT * FROM `order` WHERE `Order_ID` = ?;";
            pst = (PreparedStatement) conn.prepareStatement(sql4);
            pst.setString(1, jTextField8.getText());
            rs =pst.executeQuery();
            
            if (jTable7.getRowCount()>0 ){
                for(int i =0; i < jTable7.getRowCount() ; i++){
                   String p = (String) jTable7.getValueAt(i,3);
                   if(p.equals("Not Given"))
                        ComId++;
                }               
                if(ComId==0){
                    if(rs.next()){
                        String status = rs.getString("Receive_Status");
                        if(Integer.parseInt(status)==0){
                            for(int i =0 ; i<rows;i++){
                                try {

                                    cid = (String) jTable7.getModel().getValueAt(i, 3);
                                    String qty = (String) jTable7.getModel().getValueAt(i, 2);
                                    String pid = (String) jTable7.getModel().getValueAt(i, 0);

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
                                    pst.setString(4, "0");
                                    pst.setString(5, qty);
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
                                    }
                                    */





                                } catch (SQLException ex) {
                                    Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            String sql3 = "UPDATE `order` SET `Receive_Status`=? WHERE `Order_ID` = ?;";
                            pst = (PreparedStatement) conn.prepareStatement(sql3);
                            pst.setString(1, "1");
                            pst.setString(2, jTextField8.getText());
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
                jTextField8.setText("");
            }
            
            //System.out.println(rows);
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        // TODO add your handling code here:
        int row = jTable7.getSelectedRow();
        jTable7.setValueAt(jTextField13.getText(), row, 3);
        jTextField13.setText("");
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void salaryTxt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salaryTxt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salaryTxt1ActionPerformed

    private void jButton66ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton66ActionPerformed

        String jdate = String.format("%d", jDateChooser6.getDate().getDate());
        String jmonth = String.format("%d", jDateChooser6.getDate().getMonth()+1);
        String jyear = String.format("%d", jDateChooser6.getDate().getYear()+1900);
        
        if (firstNameTxt1.getText().isEmpty() ||
            lastNameTxt1.getText().isEmpty() ||
            
            (jRadioButton5.isSelected() &&
            jRadioButton6.isSelected()) ||
            nicNoTxt1.getText().isEmpty() ||
            contactNoTxt1.getText().isEmpty() ||
            addressTxt1.getText().isEmpty() ||
            salaryTxt1.getText().isEmpty() ||
            passwordTxt1.getText().isEmpty() ){
        
            JOptionPane.showMessageDialog(null, "fill all employee details first");
            
        }else{
            try {
                
                String sql = "UPDATE `employee` SET `First_Name`=?,`Last_Name`=?,`Gender`=?,`DOB`=?,`Age`=?,"
                        + "`NIC_No`=?,`Contact_No`=?,`Address`=?,`Salary`=?,`Password`=? WHERE `Emp_ID` = ?;";
                pst = (PreparedStatement) conn.prepareStatement(sql);
                
                
                pst.setString(1, firstNameTxt1.getText());
                pst.setString(2, lastNameTxt1.getText());
                if(jRadioButton5.isSelected())
                    pst.setString(3, "M");
                else
                    pst.setString(3, "F");
                
                
                String y = String.format("%d", jDateChooser6.getDate().getYear()+1900);
                String m = String.format("%d", jDateChooser6.getDate().getMonth()+1);
                String d = String.format("%d", jDateChooser6.getDate().getDate());

                int age  = year - Integer.parseInt(y);

                pst.setString(4, y+"-"+m+"-"+d);
                pst.setInt(5, age);
                pst.setString(6, nicNoTxt1.getText());
                pst.setInt(7, Integer.parseInt(contactNoTxt1.getText()));
                pst.setString(8, addressTxt1.getText());
                pst.setDouble(9, Double.parseDouble(salaryTxt1.getText()));
                pst.setString(10, passwordTxt1.getText());
                pst.setString(11, (String) jComboBox26.getSelectedItem());

                pst.execute();

                JOptionPane.showMessageDialog(null,"Saved");

                //employeeIdTxt.setText("");
                firstNameTxt1.setText("");
                lastNameTxt1.setText("");
                
                jRadioButton5.setSelected(false);
                jRadioButton6.setSelected(false);
                nicNoTxt1.setText("");
                contactNoTxt1.setText("");
                addressTxt1.setText("");
                salaryTxt1.setText("");
                passwordTxt1.setText("");
            } catch (SQLException ex) {
                Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

    }//GEN-LAST:event_jButton66ActionPerformed

    private void jButton67ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton67ActionPerformed
        // TODO add your handling code here:
        
              
                firstNameTxt1.setText("");
                lastNameTxt1.setText("");
                
                jRadioButton5.setSelected(false);
                jRadioButton6.setSelected(false);
                nicNoTxt1.setText("");
                contactNoTxt1.setText("");
                addressTxt1.setText("");
                salaryTxt1.setText("");
                passwordTxt1.setText("");
  
    }//GEN-LAST:event_jButton67ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
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
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            mydoc.add(new Paragraph(String.format("Balance            :Rs %.2f", change)));
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
                
                MessageFormat header = new MessageFormat("Bill No"+jTextField1.getText()+"/Date:"+jLabel5.getText());
                MessageFormat footer = new MessageFormat(String.format("Total = "+tot+" Cash reveived = "+cash+" Balance = "+change));
                jTable9.print(JTable.PrintMode.FIT_WIDTH, header, footer);
                
                
                
            } catch (PrinterException ex) {
                Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        */
    }//GEN-LAST:event_jButton50ActionPerformed

    private void jTable7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable7MouseClicked
        // TODO add your handling code here:
        int row = jTable7.getSelectedRow();
        
        String cid = (String) jTable7.getModel().getValueAt(row, 3);
        
        jTextField13.setText(cid);
    }//GEN-LAST:event_jTable7MouseClicked

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        try {
            // TODO add your handling code here:
            String sql = "INSERT INTO `deemababyfair`.`returned_sales` (`Pro_ID`, `Sales_ID`, `Date`, `Discription`, `Quantity`) "
            + "VALUES (?, ?, ?, ?, ?);";

            pst = (PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, (String) jComboBox28.getSelectedItem());
            pst.setString(2, jTextField15.getText());
            pst.setString(3, year+"-"+month+"-"+day);
            pst.setString(4, (String) jComboBox27.getSelectedItem());
            pst.setString(5, jTextField16.getText());

            pst.execute();
            updateReturnedSaleTable();
            jTextField15.setText("");
            jTextField16.setText("");

        } catch (SQLException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        try {
            // TODO add your handling code here:
            int row = jTable10.getSelectedRow();
            String pid = (String) jTable10.getModel().getValueAt(row, 2);
            String sid = (String) jTable10.getModel().getValueAt(row, 1);

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
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jTextField15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField15ActionPerformed
        try {
            // TODO add your handling code here:
            jComboBox28.removeAllItems();
            String sql = "SELECT * FROM `sales_product` WHERE `Sales_ID` = ? ";
            pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, jTextField15.getText());
            rs = pst.executeQuery();

            while(rs.next()){
                String pid = rs.getString("Pro_ID");
                jComboBox28.addItem(pid);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextField15ActionPerformed

    private void jComboBox27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox27ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox27ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        try {
            // TODO add your handling code here:

            if(jRadioButton7.isSelected()){
                String sql1 = "SELECT * FROM `order_product` WHERE `Order_ID` = ? ";
                pst = (PreparedStatement) conn.prepareStatement(sql1);
                pst.setString(1, jTextField17.getText());
                rs = pst.executeQuery();

                while(rs.next()){
                    String pid = rs.getString("Pro_ID");
                    String qty = rs.getString("Quantity");
                    String sql = "INSERT INTO `deemababyfair`.`rejected_orders` (`Pro_ID`, `Order_ID`, `Date`, `Discription`, `Quantity`) "
                    + "VALUES (?, ?, ?, ?, ?);";

                    pst = (PreparedStatement) conn.prepareStatement(sql);

                    pst.setString(1, pid);
                    pst.setString(2, jTextField17.getText());
                    pst.setString(3, year+"-"+month+"-"+day);
                    pst.setString(4, (String) jComboBox29.getSelectedItem());
                    pst.setString(5, qty);

                    pst.execute();
                }
            }else{
                String sql = "INSERT INTO `deemababyfair`.`rejected_orders` (`Pro_ID`, `Order_ID`, `Date`, `Discription`, `Quantity`) "
                + "VALUES (?, ?, ?, ?, ?);";

                pst = (PreparedStatement) conn.prepareStatement(sql);
                pst.setString(1, (String) jComboBox30.getSelectedItem());
                pst.setString(2, jTextField17.getText());
                pst.setString(3, year+"-"+month+"-"+day);
                pst.setString(4, (String) jComboBox29.getSelectedItem());
                pst.setString(5, jTextField18.getText());

                pst.execute();
            }
            updateRejectedOrderTable();
            jTextField17.setText("");
            jTextField18.setText("");
            jRadioButton7.setSelected(false);
            jComboBox29.setSelectedIndex(0);
            jComboBox30.removeAll();
            //jComboBox1.removeAllItems();
        } catch (SQLException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        try {
            // TODO add your handling code here:
            int row = jTable12.getSelectedRow();
            String pid = (String) jTable12.getModel().getValueAt(row, 0);
            String oid = (String) jTable12.getModel().getValueAt(row, 1);

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
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jTextField17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField17ActionPerformed
        try {
            // TODO add your handling code here:
            jComboBox30.removeAllItems();
            String sql = "SELECT * FROM `order_product` WHERE `Order_ID` = ? ";
            pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, jTextField17.getText());
            rs = pst.executeQuery();

            while(rs.next()){
                String pid = rs.getString("Pro_ID");
                jComboBox30.addItem(pid);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextField17ActionPerformed

    private void jTextField18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField18ActionPerformed

    private void jTextField13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        jTextField8.setText("O");
        jTextField13.setText("C");
        model.setRowCount(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            
            if (jTextField14.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Enter a Bonus amount per sale");
            }else{
                double bps = Double.parseDouble(jTextField14.getText());
                double bonus = 0;
                int countEmpSales = 0;
                int i = 0;
                String sql = "SELECT * FROM `employee` WHERE `Is_A_Admin` = '0' ;";
                pst = (PreparedStatement) conn.prepareStatement(sql);
                rs = pst.executeQuery();
                while(rs.next()){
                    countEmpSales = 0;
                    String eid = rs.getString("Emp_ID");
                    sql = "SELECT * FROM `sales` WHERE `Emp_ID` = ? AND `Date` BETWEEN ? AND ?;";
                    String date1 = year+"-"+month+"-"+"01";
                    String date2 = year+"-"+month+"-"+"31";
                    pst = (PreparedStatement) conn.prepareStatement(sql);
                    pst.setString(1, eid);
                    pst.setString(2, date1);
                    pst.setString(3, date2);
                    ResultSet rs1 = pst.executeQuery();
                    while(rs1.next()){
                       countEmpSales++; 


                    }
                    bonus = (double)bps*countEmpSales;
                    jTable8.setValueAt(bonus, i, 4);
                    i++;

                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        try {
            String sql = "SELECT * FROM `employee`;";
            int i = 0;
            pst = (PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();
                while(rs.next()){
                    
                    String eid = rs.getString("Emp_ID");
                    sql = "SELECT * FROM `employee_salary` WHERE `Emp_ID` = ? AND `Month` = ? AND `Year` = ?;";
                    //String date1 = year+"-"+month+"-"+"01";
                    //String date2 = year+"-"+month+"-"+"31";
                    pst = (PreparedStatement) conn.prepareStatement(sql);
                    pst.setString(1, eid);
                    pst.setString(2, String.format("%d",month));
                    pst.setString(3, String.format("%d",year));
                    ResultSet rs1 = pst.executeQuery();
                    if(rs1.next()){
                       while(rs1.next())
                           i++;
                    }else{
                        //System.out.println("x");
                        String sql1 = "INSERT INTO `employee_salary`(`Emp_ID`, `Month`, `Year`, `Bonus`) "
                                + "VALUES (?,?,?,?);";
                        pst = (PreparedStatement) conn.prepareStatement(sql1);
                        pst.setString(1, eid);
                        pst.setString(2, String.format("%d",month));
                        pst.setString(3, String.format("%d",year));
                        pst.setString(4,  String.format("%f",jTable8.getValueAt(i, 4)));
                        pst.execute();
                        i++;
                    }
                }
                JOptionPane.showMessageDialog(null, "Saved");
                updatePaySalaryTable();
                
        } catch (SQLException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton23ActionPerformed

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
                //System.out.println("test");
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
            String NewQ = jTextField24.getText();
            String EID = "Not_found";

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

                mystmnt1.executeUpdate("Insert into store_history (Compartment_ID,Pro_ID,Action,Date,Time,Quantity,Emp_ID)"
                    + "values('"+CID+"','"+PID+"','"+Act+"','"+date+"','"+time+"','"+PreQ+"','"+ Login.id +"')");

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
                mystmnt1.executeUpdate("Insert into store_history (Compartment_ID,Pro_ID,Action,Date,Time,Prevoius_Quantity,New_Quantity,Emp_ID)"
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

    private void jTextField12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyReleased
        // TODO add your handling code here:
        try {
        if (jComboBox32.getSelectedIndex()==0){
            
                String sql = "select * from employee where Emp_ID like ?";
                pst = (PreparedStatement) conn.prepareStatement(sql);
                pst.setString(1,jTextField12.getText()+"%");
               // System.out.println(0);
            
        }
        else if (jComboBox32.getSelectedIndex()==1){
            
                String sql = "select * from employee where First_Name like ?";
                pst = (PreparedStatement) conn.prepareStatement(sql);
                pst.setString(1,jTextField12.getText()+"%");
                //System.out.println(1);
            
        }
        else if (jComboBox32.getSelectedIndex()==2){
            
                String sql = "select * from employee where Last_Name like ?";
                pst = (PreparedStatement) conn.prepareStatement(sql);
                pst.setString(1,jTextField12.getText()+"%");
                //System.out.println(1);
            
        }

            ResultSet rs1 = pst.executeQuery();
            
            //while(rs1.next())
            jTable11.setModel(DbUtils.resultSetToTableModel(rs1));
            
            if (jTextField12.getText().isEmpty()){
              //  System.out.println("test12");
                updateEmployeeTable();
            }
        } catch (SQLException ex) {
                Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jTextField12KeyReleased

    private void jTabbedPane10ComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTabbedPane10ComponentMoved
 
    }//GEN-LAST:event_jTabbedPane10ComponentMoved

    private void jTabbedPane10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane10MouseClicked
        // TODO add your handling code here:
        
         
        try {
            // TODO add your handling code here:
           // System.out.println("t");
            updateEmployeeTable();
            updatePaySalaryTable();
           jComboBox26.removeAllItems();
            String sql = "SELECT * FROM `employee` ;";
            pst = (PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                String e = rs.getString("Emp_ID");
                jComboBox26.addItem(e);
            }
            updateEmployeeTable();
        } catch (SQLException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jTabbedPane10MouseClicked

    private void jComboBox26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox26ActionPerformed
       
    }//GEN-LAST:event_jComboBox26ActionPerformed

    private void jComboBox26ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox26ItemStateChanged

    }//GEN-LAST:event_jComboBox26ItemStateChanged

    private void jTabbedPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane2MouseClicked
        try {
            fillSupplier();
            updateOrderTable();
            updateOrderTable1();
            updateRejectedOrderTable();
        } catch (SQLException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTabbedPane2MouseClicked

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        try {
            // TODO add your handling code here:
            updateProductsTable();
            updateProductsTable1();
        } catch (SQLException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jTabbedPane6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane6MouseClicked
        try {
            // TODO add your handling code here:
            updateReturnedSaleTable();
            updateSalesTable1();
        } catch (SQLException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTabbedPane6MouseClicked

    private void jTabbedPane4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane4MouseClicked
        // TODO add your handling code here:
        updatetbl();
        updatetbl1();
    }//GEN-LAST:event_jTabbedPane4MouseClicked

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
        
        jPanel3.removeAll();
            jPanel3.repaint();
            jPanel3.revalidate();
            jPanel3.remove(jPanel4);
            jPanel3.remove(jPanel8);
            jPanel3.remove(jPanel9);
            jPanel3.remove(jPanel10);
            jPanel3.remove(jPanel11);
            jPanel3.remove(jPanel12);
            jPanel3.remove(jPanel7);
            jPanel3.add(jPanel58);
            //jPanel3.repaint();
            //jPanel3.revalidate();
        
    }//GEN-LAST:event_jButton40ActionPerformed

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        try {
         
            String reportSource="C:\\Users\\Charinda\\Documents\\NetBeansProjects\\DBFnew\\reports\\EmployeeMonthlySalary.jrxml";
            
            
            Map<String, Object> params= new HashMap<>(); 
            JasperReport jasperReport= JasperCompileManager.compileReport(reportSource);
            JasperPrint jasperPrint= JasperFillManager.fillReport(jasperReport,params,conn);
            JasperViewer.viewReport(jasperPrint, false);
            
        } catch (JRException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton41ActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        try {
            String reportSource="C:\\Users\\Charinda\\Documents\\NetBeansProjects\\DBFnew\\reports\\EmployeeMonthlySales.jrxml";
            //JasperDesign jd = JRXmlLoader.load("‪C:\\Users\\Charinda\\Documents\\JaspersoftWorkSpace\\MyReports\\EmployeeMonthlySalary.jrxml");
            
            //String sql = "SELECT deemababyfair.employee.`Last_Name`, deemababyfair.employee.`First_Name`, deemababyfair.employee.`Salary`, deemababyfair.employee_salary.`Year`, deemababyfair.employee_salary.`Bonus`, deemababyfair.employee_salary.`Month`, deemababyfair.employee_salary.`Emp_ID` FROM deemababyfair.employee_salary, deemababyfair.employee WHERE deemababyfair.employee_salary.`Month` ="+month+" AND deemababyfair.employee_salary.`Year` = "+year+" AND deemababyfair.employee.`Emp_ID` = deemababyfair.employee_salary.`Emp_ID` ";
            //JRDesignQuery newQuery = new JRDesignQuery();
            //newQuery.setText(sql);
            //jd.setQuery(newQuery);
            
            Map<String, Object> params= new HashMap<String, Object>(); 
            JasperReport jasperReport= JasperCompileManager.compileReport(reportSource);
            JasperPrint jasperPrint= JasperFillManager.fillReport(jasperReport,params,conn);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
        try {
            String reportSource="C:\\Users\\Charinda\\Documents\\NetBeansProjects\\DBFnew\\reports\\StockReport.jrxml";
            //JasperDesign jd = JRXmlLoader.load("‪C:\\Users\\Charinda\\Documents\\JaspersoftWorkSpace\\MyReports\\EmployeeMonthlySalary.jrxml");
            
            //String sql = "SELECT deemababyfair.employee.`Last_Name`, deemababyfair.employee.`First_Name`, deemababyfair.employee.`Salary`, deemababyfair.employee_salary.`Year`, deemababyfair.employee_salary.`Bonus`, deemababyfair.employee_salary.`Month`, deemababyfair.employee_salary.`Emp_ID` FROM deemababyfair.employee_salary, deemababyfair.employee WHERE deemababyfair.employee_salary.`Month` ="+month+" AND deemababyfair.employee_salary.`Year` = "+year+" AND deemababyfair.employee.`Emp_ID` = deemababyfair.employee_salary.`Emp_ID` ";
            //JRDesignQuery newQuery = new JRDesignQuery();
            //newQuery.setText(sql);
            //jd.setQuery(newQuery);
            
            Map<String, Object> params= new HashMap<String, Object>(); 
            JasperReport jasperReport= JasperCompileManager.compileReport(reportSource);
            JasperPrint jasperPrint= JasperFillManager.fillReport(jasperReport,params,conn);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton43ActionPerformed

    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
        try {
            String reportSource="C:\\Users\\Charinda\\Documents\\NetBeansProjects\\DBFnew\\reports\\ex1.jrxml";
            //JasperDesign jd = JRXmlLoader.load("‪C:\\Users\\Charinda\\Documents\\JaspersoftWorkSpace\\MyReports\\EmployeeMonthlySalary.jrxml");
            
            //String sql = "SELECT deemababyfair.employee.`Last_Name`, deemababyfair.employee.`First_Name`, deemababyfair.employee.`Salary`, deemababyfair.employee_salary.`Year`, deemababyfair.employee_salary.`Bonus`, deemababyfair.employee_salary.`Month`, deemababyfair.employee_salary.`Emp_ID` FROM deemababyfair.employee_salary, deemababyfair.employee WHERE deemababyfair.employee_salary.`Month` ="+month+" AND deemababyfair.employee_salary.`Year` = "+year+" AND deemababyfair.employee.`Emp_ID` = deemababyfair.employee_salary.`Emp_ID` ";
            //JRDesignQuery newQuery = new JRDesignQuery();
            //newQuery.setText(sql);
            //jd.setQuery(newQuery);
            
            Map<String, Object> params= new HashMap<String, Object>(); 
            JasperReport jasperReport;
           
                jasperReport = JasperCompileManager.compileReport(reportSource);
            
                
            JasperPrint jasperPrint= JasperFillManager.fillReport(jasperReport,params,conn);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton44ActionPerformed

    private void jButton45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton45ActionPerformed
        try {
            String reportSource="C:\\Users\\Charinda\\Documents\\NetBeansProjects\\DBFnew\\reports\\EmployeeYearlySales.jrxml";
            //JasperDesign jd = JRXmlLoader.load("‪C:\\Users\\Charinda\\Documents\\JaspersoftWorkSpace\\MyReports\\EmployeeMonthlySalary.jrxml");
            
            //String sql = "SELECT deemababyfair.employee.`Last_Name`, deemababyfair.employee.`First_Name`, deemababyfair.employee.`Salary`, deemababyfair.employee_salary.`Year`, deemababyfair.employee_salary.`Bonus`, deemababyfair.employee_salary.`Month`, deemababyfair.employee_salary.`Emp_ID` FROM deemababyfair.employee_salary, deemababyfair.employee WHERE deemababyfair.employee_salary.`Month` ="+month+" AND deemababyfair.employee_salary.`Year` = "+year+" AND deemababyfair.employee.`Emp_ID` = deemababyfair.employee_salary.`Emp_ID` ";
            //JRDesignQuery newQuery = new JRDesignQuery();
            //newQuery.setText(sql);
            //jd.setQuery(newQuery);
            
            Map<String, Object> params= new HashMap<String, Object>(); 
            JasperReport jasperReport= JasperCompileManager.compileReport(reportSource);
            JasperPrint jasperPrint= JasperFillManager.fillReport(jasperReport,params,conn);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton45ActionPerformed

    private void jComboBox26PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox26PopupMenuWillBecomeInvisible
         try {
            String sql = "SELECT * FROM `employee` WHERE `Emp_ID` = ?;";
            String item = (String) jComboBox26.getSelectedItem();
            pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, item);
            rs = pst.executeQuery();
            if(rs.next()){
                //employeeIdTxt1.setText(rs.getString("Emp_ID"));
                firstNameTxt1.setText(rs.getString("First_Name"));
                lastNameTxt1.setText(rs.getString("Last_Name"));
                String g = rs.getString("Gender");
                if (g.equals("M"))
                    jRadioButton5.setSelected(true);
                else
                    jRadioButton6.setSelected(true);
                jDateChooser6.setDate(rs.getDate("DOB"));
                //jRadioButton5.setSelected(false);
                
                nicNoTxt1.setText(rs.getString("NIC_No"));
                contactNoTxt1.setText(rs.getString("Contact_No"));
                addressTxt1.setText(rs.getString("Address"));
                salaryTxt1.setText(rs.getString("Salary"));
                passwordTxt1.setText(rs.getString("Password"));
            
            }else{
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBox26PopupMenuWillBecomeInvisible

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton51ActionPerformed
        setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jButton51ActionPerformed
   int pX,pY ; 
    private void backgroundMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backgroundMouseDragged
        int x1,y1;
        
       x1 =this.getLocation().x + evt.getX()- pX;
       y1 =this.getLocation().y + evt.getY()- pY;
       this.setLocation(x1,y1);        // TODO add your handling code here:
    }//GEN-LAST:event_backgroundMouseDragged

    private void backgroundMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backgroundMousePressed
             pX=evt.getX();
       pY=evt.getY();
    }//GEN-LAST:event_backgroundMousePressed

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
            java.util.logging.Logger.getLogger(AdminScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressTxt;
    private javax.swing.JTextField addressTxt1;
    private javax.swing.JLabel background;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JTextField contactNoTxt;
    private javax.swing.JTextField contactNoTxt1;
    private javax.swing.JTextField discountTxt;
    private javax.swing.JTextField employeeIdTxt;
    private javax.swing.JTextField firstNameTxt;
    private javax.swing.JTextField firstNameTxt1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton63;
    private javax.swing.JButton jButton64;
    private javax.swing.JButton jButton66;
    private javax.swing.JButton jButton67;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox16;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox26;
    private javax.swing.JComboBox<String> jComboBox27;
    private javax.swing.JComboBox<String> jComboBox28;
    private javax.swing.JComboBox<String> jComboBox29;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox30;
    private javax.swing.JComboBox jComboBox31;
    private javax.swing.JComboBox<String> jComboBox32;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private com.toedter.calendar.JDateChooser jDateChooser5;
    private com.toedter.calendar.JDateChooser jDateChooser6;
    private com.toedter.calendar.JDateChooser jDateChooser7;
    private com.toedter.calendar.JDateChooser jDateChooser8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
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
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
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
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JPanel jPanel68;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPasswordField jPasswordField3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane10;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JTabbedPane jTabbedPane9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable10;
    private javax.swing.JTable jTable11;
    private javax.swing.JTable jTable12;
    private javax.swing.JTable jTable13;
    private javax.swing.JTable jTable14;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable8;
    private javax.swing.JTable jTable9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
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
    private javax.swing.JTextField lastNameTxt;
    private javax.swing.JTextField lastNameTxt1;
    private javax.swing.JTextField nicNoTxt;
    private javax.swing.JTextField nicNoTxt1;
    private javax.swing.JTextField orderIdTxt;
    private javax.swing.JTextField passwordTxt;
    private javax.swing.JTextField passwordTxt1;
    private javax.swing.JTextField priceTxt;
    private javax.swing.JTextField priceTxt1;
    private javax.swing.JTextField productIdTxt;
    private javax.swing.JTextField productIdTxt1;
    private javax.swing.JTextField productNameTxt;
    private javax.swing.JTextField productNameTxt1;
    private javax.swing.JTextField productNameTxt2;
    private javax.swing.JTextField quantityTxt;
    private javax.swing.JTextField quantityTxt1;
    private javax.swing.JTextField salaryTxt;
    private javax.swing.JTextField salaryTxt1;
    private javax.swing.JTextField supplierAddressTxt4;
    private javax.swing.JTextField supplierContactTxt4;
    private javax.swing.JTextField supplierIdTxt4;
    private javax.swing.JTextField supplierNameTxt4;
    // End of variables declaration//GEN-END:variables
}

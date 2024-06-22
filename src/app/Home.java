/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.awt.*;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Mohamed
 */

public class Home extends JFrame implements ActionListener{

    public static void main(String[] args) {
        new Home();
    }
//    ##############################
    JMenu supplier,Customer,Installment,delegates,Items,sales,Purchases,prices,reports,cash_register,Warehouse;
    JMenuItem suppliers,s_statment,s_report;
//    ##############################
    public Home(){
         super("Super Market");
//##############################################################################
       JMenuBar bar = new JMenuBar();
       supplier = new JMenu("Suppliers");
       Customer = new  JMenu("Customer");
       Installment = new JMenu("Installment");
       delegates = new JMenu("The delegates");
       Items = new JMenu("Items");
       sales = new JMenu("Sales");
       Purchases = new JMenu("Purchases");
       prices = new JMenu("Prices");
       reports = new JMenu("Reports");
       cash_register = new JMenu("Cash Register");
       Warehouse = new JMenu("Warehouse");
//##############################################################################
       bar.add(supplier);
       bar.add(Customer);
       bar.add(Installment);
       bar.add(Items);
       bar.add(sales);
       bar.add(Purchases);
       bar.add(prices);
       bar.add(reports);
       bar.add(cash_register);
       bar.add(Warehouse);
       
//       suppliers = new JMenuItem("Suppliers");
//       suppliers.addActionListener(this);
//       s_statment = new JMenuItem("Suppliers account statement");
//       s_statment.addActionListener(this);
//       s_report= new JMenuItem("Supplier account report");
//       s_report.addActionListener(this);
       this.setJMenuBar(bar);
//       bar.add(supplier);
//       bar.add(Customer);
//       supplier.add(suppliers);
//       supplier.add(s_statment);
//       supplier.add(s_report);
       
//##############################################################################
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        ImageIcon super_market = new ImageIcon(ClassLoader.getSystemResource("Media/super_market.png"));
        Image logo = super_market.getImage().getScaledInstance(screen.width, screen.height , Image.SCALE_DEFAULT);
        ImageIcon f_logo = new ImageIcon(logo);
        JLabel photo = new JLabel(f_logo);
        
        this.add(photo);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setIconImage(super_market.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == suppliers) {
//          this.setVisible(false);
//            new New_customer();
        }else if (e.getSource()== s_statment) {
//            this.setVisible(false);
//            new Edit_customer();
        }else if(e.getSource()== s_report){
//            this.setVisible(false);
//            new Delete_customer();
//        }else if(e.getSource()== search){
//            this.setVisible(false);
//            new Search_Customers();
        }
       
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

/**
 *a
 * @author Mohamed
 */
public class LogIn extends JFrame implements ActionListener , KeyListener{
    JLabel user_lab , password_lab;
    JTextField user ;
    JPasswordField password ;
    JButton login;
    JCheckBox remember ;

    public LogIn(){
        
        super("Super Market");
//##############################################################################
        
//##############################################################################
        ImageIcon super_market = new ImageIcon(ClassLoader.getSystemResource("Media/super_market.png"));
        Image logo = super_market.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon f_logo = new ImageIcon(logo);
        JLabel photo = new JLabel(f_logo);
       
//##############################################################################
        user_lab = new JLabel("User ID");
        user_lab.setForeground(Color.BLACK);
        user_lab.setFont(new Font("AvantGarde", Font.BOLD, 22));
        user_lab.setBounds(30, 45, 90, 75);
        this.add(user_lab);
//##############################################################################
        password_lab = new JLabel("Password");
        password_lab.setForeground(Color.BLACK);
        password_lab.setFont(new Font("AvantGarde", Font.BOLD, 22));
        password_lab.setBounds(30, 120, 110, 75);
        this.add(password_lab);
        
//##############################################################################
        user = new JTextField();
        user.setBounds(170, 65, 270, 30);
        user.setFont(new Font("Arial", Font.BOLD, 14));
        user.addKeyListener(this);
        user.requestFocusInWindow();
        this.add(user);
        try {
            
                Conection cont = new Conection();
                Statement stmt = cont.statement;

                String selectQuery = "SELECT last_user_id FROM last_login  "; // استبدل بالاستعلام المناسب
                ResultSet rs = stmt.executeQuery(selectQuery);

                String username = ""; // قيمة افتراضية

                if (rs.next()) {
                    username = rs.getString("last_user_id");
                    user.setText(username);
                }
                
                 cont.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
       
//##############################################################################
        password = new JPasswordField();
        password.setBounds(170, 140, 270, 30);
        password.setFont(new Font("Arial", Font.BOLD, 14));
        this.add(password);
         try {
            
                Conection cont = new Conection();
                Statement stmt = cont.statement;

                String selectQuery = "SELECT last_user_pass FROM last_login "; // استبدل بالاستعلام المناسب
                ResultSet rs = stmt.executeQuery(selectQuery);

                String username = ""; // قيمة افتراضية

                if (rs.next()) {
                    username = rs.getString("last_user_pass");
                    password.setText(username);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        
//##############################################################################
        login = new JButton("Log In");
        login.setFont(new Font("Arial", Font.BOLD, 14));
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.setBounds(250, 250, 100, 30);
        login.addActionListener(this);
        login.addKeyListener(this);
        this.add(login);
//##############################################################################
        remember = new JCheckBox("Remember Me");
        remember.setFont(new Font("Arial", Font.PLAIN, 14));
        remember.setBounds(170, 180, 150, 30);
        remember.addActionListener(this);
        this.add(remember);
        
        
//##############################################################################
        this.add(photo);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setIconImage(super_market.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
        this.setSize(600, 400);
        this.pack();
        this.setLocation(250,167);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String use = user.getText();
        String pass = password.getText();
        
        try {
            if(e.getSource()== login)
            {
                if(remember.isSelected())
                {
                 Conection reme = new Conection();
                 String m = "delete from last_login ";
                 reme.statement.executeUpdate(m);
                 String q = "insert into last_login(last_user_id,last_user_pass) values('"+use+"','"+pass+"')";
                 reme.statement.executeUpdate(q);
                }else
                {
                 Conection remember = new Conection();
                 String q = "delete from last_login ";
                 remember.statement.executeUpdate(q);
                }
              Conection c = new Conection();
              String q = "select * from login where user_id = '"+use+"' and user_pass = '"+pass+"'";
               ResultSet resultSet = c.statement.executeQuery(q);
               if(resultSet.next())
               {
                   setVisible(false);
//                   new Home();
               }
               else
               {
                   JOptionPane.showMessageDialog(null, "Incorrect User ID or Password");
               }
            }
            
        }catch (Exception E)
        {
            E.printStackTrace();
        }
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_TAB)
        {
            password.requestFocusInWindow();
             if(e.getKeyCode()== KeyEvent.VK_ENTER)
        {
        String use = user.getText();
        String pass = password.getText();
        
        try {
           
              Conection c = new Conection();
              String q = "select * from login where user_id = '"+use+"' and user_pass = '"+pass+"'";
               ResultSet resultSet = c.statement.executeQuery(q);
               if(resultSet.next())
               {
                   setVisible(false);
                   new LogIn();
               }
               else
               {
                   JOptionPane.showMessageDialog(null, "Incorrect User ID or Password");
               }
            
            
        }catch (Exception E)
        {
            E.printStackTrace();
        }
        }
        }
       
        
    }
    

    @Override
    public void keyReleased(KeyEvent e) {

    }
    
    
    
}

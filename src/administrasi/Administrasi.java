/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrasi;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ADAM ARDI
 */
public class Administrasi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //GUI g = new GUI();
        //ViewAdmin v = new ViewAdmin();
        MVC mvc = new MVC();
    }
    
}

class GUI extends JFrame {
    String pass="admin";
   final JTextField fuser = new JTextField(10);
   final JPasswordField fpass = new JPasswordField(10);

   JLabel luser = new JLabel(" Username ");
   JLabel lpass = new JLabel(" Password ");
   JButton btnOk = new JButton("Login");
   //JButton btnCancel = new JButton("Cancel");

public GUI() {
    
setTitle("LOGIN");
	setDefaultCloseOperation(3);
	setSize(350,200);
        setLocation(500,275);
setLayout(null);
	add(luser);
	add(fuser);
        add(lpass);
	add(fpass);
        add(btnOk);
        //add(btnCancel);
luser.setBounds(10,15,120,20);
fuser.setBounds(140,10,150,30);
lpass.setBounds(10,55,120,20);
fpass.setBounds(140,50,150,30);
btnOk.setBounds(130,100,100,30);

//btnCancel.setBounds(50,130,100,20);
//btnCancel.setBackground(new java.awt.Color(255,0,0));

        
btnOk.addActionListener((ActionEvent e) -> {
    if(fuser.getText().equalsIgnoreCase("admin") && pass.equalsIgnoreCase(fpass.getText()))
    {   JOptionPane.showMessageDialog(null, "Berhasil Login");
        MVC mvc = new MVC();
        //mvc.setVisible(true);
        
        dispose();}
    else 
    {
        JOptionPane.showMessageDialog(null, "username atau password salah");
    }
    
});
        setVisible(true);
}
}
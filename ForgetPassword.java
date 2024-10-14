
package travel.management.system1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class ForgetPassword extends JFrame implements  ActionListener{
    
  JTextField lfusername,lfname,lfquestion,lfanswer,lfpassword;
    JButton search,retrieve,back;
    ForgetPassword()
    {
    setBounds(350,200,850,380);
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
    Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(580,70,200,200);
    add(image);
    
    
    
    JPanel p1=new JPanel();
    p1.setLayout(null);
    p1.setBounds(30,30,500,280);
    add(p1);
    
    JLabel lbusername=new JLabel ("Username");
    lbusername.setBounds(40,20,100,25);
    lbusername.setFont(new Font("Tahoma",Font.BOLD,14));
    p1.add(lbusername);
    
   lfusername=new JTextField();
   lfusername.setBounds(220,20,150,25);
   lfusername.setBorder(BorderFactory.createEmptyBorder());
   p1.add(lfusername);
   
    
    
   JLabel lbname=new JLabel ("Name");
    lbname.setBounds(40,60,100,25);
    lbname.setFont(new Font("Tahoma",Font.BOLD,14));
    p1.add(lbname);
    
   lfname=new JTextField();
   lfname.setBounds(220,60,150,25);
   lfname.setBorder(BorderFactory.createEmptyBorder());
   p1.add(lfname);
   
    JLabel lbquestion=new JLabel ("Security Question");
    lbquestion.setBounds(40,100,100,25);
    lbquestion.setFont(new Font("Tahoma",Font.BOLD,14));
    p1.add(lbquestion);
    
   lfquestion=new JTextField();
   lfquestion.setBounds(220,100,150,25);
   lfquestion.setBorder(BorderFactory.createEmptyBorder());
   p1.add(lfquestion);
   
   JLabel lbanswer=new JLabel ("Answer");
    lbanswer.setBounds(40,140,150,25);
    lbanswer.setFont(new Font("Tahoma",Font.BOLD,14));
    p1.add(lbanswer);
    
   lfanswer=new JTextField();
   lfanswer.setBounds(220,140,150,25);
   lfanswer.setBorder(BorderFactory.createEmptyBorder());
   p1.add(lfanswer);
   
   search=new JButton("Search");
   search.setBackground(Color.GRAY);
   search.setForeground(Color.WHITE);
   search.setBounds(380,20,100,25);
    search.addActionListener(this);
   p1.add(search);
   
   retrieve=new JButton("Retrieve");
   retrieve.setBackground(Color.GRAY);
   retrieve.setForeground(Color.WHITE);
   retrieve.setBounds(380,140,100,25);
   retrieve.addActionListener(this);
   p1.add(retrieve);
   
back=new JButton("Back");
   back.setBackground(Color.GRAY);
   back.setForeground(Color.WHITE);
   back.setBounds(150,230,100,25);
    back.addActionListener(this);
   p1.add(back);
    
   JLabel lbpassword=new JLabel ("Password");
    lbpassword.setBounds(40,180,150,25);
    lbpassword.setFont(new Font("Tahoma",Font.BOLD,14));
    p1.add(lbpassword);
    
   lfpassword=new JTextField();
   lfpassword.setBounds(220,180,150,25);
   lfpassword.setBorder(BorderFactory.createEmptyBorder());
   p1.add(lfpassword); 
    
    
    
    setVisible(true);
    
    
    }
    
    public  void actionPerformed(ActionEvent ae)
    {
        
        if (ae.getSource() == search) {
    try {
        String query = "SELECT * FROM account WHERE username='" + lfusername.getText() + "'";
        Conn c = new Conn();

        ResultSet rs = c.s.executeQuery(query);
        if (rs.next()) {
            lfname.setText(rs.getString("name"));
            lfquestion.setText(rs.getString("security"));  // Assuming this is the column name
        } else {
            JOptionPane.showMessageDialog(null, "Username not found");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
   else if (ae.getSource() == retrieve) {
    try {
        String query = "SELECT * FROM account WHERE username='" + lfusername.getText() + "' AND answer='" + lfanswer.getText() + "'";
        Conn c = new Conn();
        
        ResultSet rs = c.s.executeQuery(query);
        if (rs.next()) {
            lfpassword.setText(rs.getString("password"));  // Assuming this is the column name for the password
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect answer");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
   }
   else if(ae.getSource()==back)
   {
       setVisible(false);
       new Login();
   }
}
    public static void main(String[] args)
    {
    
        new ForgetPassword();   
    
    }
    
}


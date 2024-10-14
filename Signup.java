
package travel.management.system1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Signup extends JFrame implements ActionListener {
    
    JButton create,back;
    Choice security;
    JTextField lfname,lfusername,lfpassword,lfanswer;
    Signup()
    {
    setBounds(350,200,900,360);
      getContentPane().setBackground(Color.WHITE);
    
    setLayout(null);
    
    JPanel p1=new JPanel();
    p1.setBackground(new Color(133,193,233));
    p1.setBounds(0,0,500,400);
    p1.setLayout(null);
    add(p1);
    
    JLabel lbusername=new JLabel("Username");
    lbusername.setFont(new Font("Tahoma",Font.BOLD,14));
    lbusername.setBounds(50,20,125,25);
    p1.add(lbusername);
    
   lfusername=new JTextField();
    lfusername.setBounds(190,20,180,25);
    lfusername.setBorder(BorderFactory.createEmptyBorder());
    p1.add(lfusername);
    
  
    
    JLabel lbname=new JLabel("Name");
    lbname.setFont(new Font("Tahoma",Font.BOLD,14));
    lbname.setBounds(50,60,125,25);
    p1.add(lbname);
    
   lfname=new JTextField();
    lfname.setBounds(190,60,180,25);
    lfname.setBorder(BorderFactory.createEmptyBorder());
    p1.add(lfname);
    
 JLabel lbpassword=new JLabel("Password");
    lbpassword.setFont(new Font("Tahoma",Font.BOLD,14));
    lbpassword.setBounds(50,100,125,25);
    p1.add(lbpassword);
    
     lfpassword=new JTextField();
    lfpassword.setBounds(190,100,180,25);
    lfpassword.setBorder(BorderFactory.createEmptyBorder());
    p1.add(lfpassword);
    
    JLabel lbsecurity=new JLabel("Security Question");
    lbsecurity.setFont(new Font("Tahoma",Font.BOLD,14));
    lbsecurity.setBounds(50,140,125,25);
    p1.add(lbsecurity);
    
     security=new Choice();
    security.add("Fav character froom the boys");
    security.add("Fav Marvel Hero");
    security.add("Your Lucky Number");
    security.setBounds(190,140,180,25);
    p1.add(security);   
    
    JLabel lbanswer=new JLabel("Answer");
    lbanswer.setFont(new Font("Tahoma",Font.BOLD,14));
    lbanswer.setBounds(50,180,125,25);
    p1.add(lbanswer);
    
     lfanswer=new JTextField();
    lfanswer.setBounds(190,180,180,25);
    lfanswer.setBorder(BorderFactory.createEmptyBorder());
    p1.add(lfanswer);
    
    create=new JButton("Create");
    create.setBackground(Color.WHITE);
    create.setForeground(new Color(133,193,233));
    create.setFont(new Font("Tahoma",Font.BOLD,14));
    create.setBounds(80,250,100,30);
    create.addActionListener(this);
    p1.add(create);
    
 back=new JButton("Back");
    back.setBackground(Color.WHITE);
    back.setForeground(new Color(133,193,233));
    back.setFont(new Font("Tahoma",Font.BOLD,14));
    back.setBounds(250,250,100,30);
    back.addActionListener(this);
    p1.add(back);
    
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
    Image i2=i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(580,50,250,250);
  add(image);
    
    
  
            
      setVisible(true);      
            }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
    if(ae.getSource()==create)
    {
        String username=lfusername.getText();
         String name=lfname.getText();
          String password=lfpassword.getText();
           String question=security.getSelectedItem();
           String answer=lfanswer.getText();
           
           String query="insert into account values('"+username+"','"+name+"','"+password+"','"+question+"','"+answer+"')";
           try{
                 Conn c=new Conn();
                 c.s.executeUpdate(query);
                 
                 JOptionPane.showMessageDialog(null, "Account created Successfully");
                 setVisible(false);
                 new Login();
                 
           }
           catch(Exception e)
           {
     e.printStackTrace();
           }
           
        
        
        
    }
    else if(ae.getSource()==back)
    {
    setVisible(false);
    new Login();
    }
    }
    
    public static void main(String [] args)
    {
    new Signup();
    }
    
}

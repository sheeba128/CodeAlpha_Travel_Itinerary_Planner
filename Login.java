
package travel.management.system1;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame implements ActionListener{
     JButton login,signup,password;
    Login()
    {
        JButton login,signup,password;
    setSize(900,400);
    setLocation(350,200);
    setLayout(null);
    
    getContentPane().setBackground(Color.WHITE);
     
    
    JPanel p1=new JPanel();
    p1.setBackground(new Color(131,193,233));
    p1.setBounds(0,0,400,400);
    add(p1);
    
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
    Image i2=i1.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(100,120,200,200);
    p1.add(image);
    
    JPanel p2=new JPanel();
    p2.setLayout(null);
    p2.setBounds(400,30,450,300);
    add(p2);
    
    JLabel lbusername=new JLabel("Username");
    lbusername.setBounds(60,20,100,25);
    lbusername.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
    p2.add(lbusername);
    
    JLabel lbpassword=new JLabel("Password");
    lbpassword.setBounds(60,110,100,25);
    lbpassword.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
    p2.add(lbpassword);
    
    JTextField lfusername=new JTextField();
    lfusername.setBounds(60,60,300,30);
    lfusername.setBorder(BorderFactory.createEmptyBorder());
    p2.add(lfusername);
    
    JTextField lfpassword=new JTextField();
    lfpassword.setBounds(60,150,300,30);
    lfpassword.setBorder(BorderFactory.createEmptyBorder());
    p2.add(lfpassword);
    
    
    login=new JButton("Login");
    login.setBounds(60,200,130,30);
    login.setBackground(new Color(133,193,233));
    login.setForeground(Color.WHITE);
    login.setBorder(new LineBorder(new Color(133,193,233)));
    login.addActionListener(this);
    p2.add(login);
            
   signup=new JButton("SignUp");
   signup.setBounds(230,200,130,30);
   signup.setBackground(new Color(133,193,233));
    signup.setForeground(Color.WHITE);
    signup.setBorder(new LineBorder(new Color(133,193,233)));
    signup.addActionListener(this);
    p2.add(signup);
    
     password=new JButton("Forget Password");
    password.setBounds(130,250,130,30);
    password.setBackground(new Color(133,193,233));
    password.setForeground(Color.WHITE);
    password.setBorder(new LineBorder(new Color(133,193,233)));
    password.addActionListener(this);
    p2.add(password);
    
    JLabel text=new JLabel("Trouble in login......");
    text.setBounds(300,250,150,20);
    text.setForeground(Color.RED);
    p2.add(text);
            
            
    
    setVisible(true);
            }
    public void actionPerformed(ActionEvent ae) 
    {
        if (ae.getSource() == login) {
    
        } else if (ae.getSource() ==signup) {
            setVisible(false);
            new Signup();
        } else  {
           setVisible(false);
           new ForgetPassword();
        }
    }
    public static void main(String[] args)
    {
    new Login();
            }
}

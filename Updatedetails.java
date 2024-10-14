
package travel.management.system1;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Updatedetails extends JFrame implements ActionListener{
    String username;
    JLabel lbusername,labelname,labelusername;
    JComboBox comboid;
    JTextField lfid,lfnumber,lfcountry,lfgender,lfaddress,lfphone,lfemail;
    JRadioButton rmale,rfemale;
    JButton add,back;
Updatedetails(String username){
    setBounds(500,200,850,550);
setLayout(null);
getContentPane().setBackground(Color.WHITE);

JLabel text=new JLabel("UPDATE CUSTOMER DETAILS");
text.setBounds(50,0,300,25);
text.setFont(new Font("Tahoma",Font.PLAIN,20));
add(text);

 lbusername=new JLabel("Username");
lbusername.setBounds(30,50,150,25);
add(lbusername);

labelusername=new JLabel();
labelusername.setBounds(220,90,150,25);
add(labelusername);


JLabel lbid=new JLabel("Id");
lbid.setBounds(30,90,150,25);
add(lbid);

lfid=new JTextField();
lfid.setBounds(220,90,150,25);
add(lfid);


JLabel lbnumber=new JLabel("Number");
lbnumber.setBounds(30,130,150,25);
add(lbnumber);

lfnumber=new JTextField();
lfnumber.setBounds(220,130,150,25);
add(lfnumber);

JLabel lbname=new JLabel("Name");
lbname.setBounds(30,170,150,25);
add(lbname);

labelname=new JLabel();
labelname.setBounds(220,170,150,25);
add(labelname);

lfgender=new JTextField();
lfgender.setBounds(220,210,150,25);
add(lfgender);


JLabel lbgender=new JLabel("Gender");
lbgender.setBounds(30,210,150,25);
add(lbgender);


JLabel lbcountry=new JLabel("Country");
lbcountry.setBounds(30,250,150,25);
add(lbcountry);

lfcountry=new JTextField();
lfcountry.setBounds(220,250,150,25);
add(lfcountry);

JLabel lbaddress=new JLabel("Address");
lbaddress.setBounds(30,290,150,25);
add(lbaddress);

lfaddress=new JTextField();
lfaddress.setBounds(220,290,150,25);
add(lfaddress);

JLabel lbphone=new JLabel("Phone");
lbphone.setBounds(30,330,150,25);
add(lbphone);

lfphone=new JTextField();
lfphone.setBounds(220,330,150,25);
add(lfphone);

JLabel lbemail=new JLabel("E-mail");
lbemail.setBounds(30,370,150,25);
add(lbemail);

lfemail=new JTextField();
lfemail.setBounds(220,370,150,25);
add(lfemail);

add=new JButton ("Update");
add.setBackground(Color.BLACK);
add.setForeground(Color.WHITE);
add.setBounds(70,430,100,25);
add.addActionListener(this);
add(add);

back=new JButton("Back");
back.setBackground(Color.BLACK);
back.setForeground(Color.WHITE);
back.setBounds(220,430,100,25);
back.addActionListener(this);
add(back);

ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
Image i2=i1.getImage().getScaledInstance(250, 300, Image.SCALE_DEFAULT);
ImageIcon i3=new ImageIcon(i2);
JLabel image =new JLabel(i3);
image.setBounds(400,100,450,300);
add(image);

try{
  Conn c=new Conn();
ResultSet rs=c.s.executeQuery("select*from customer where username='"+username+"'");
while(rs.next())
{
labelusername.setText(rs.getString("username"));
labelname.setText(rs.getString("name"));
lfid.setText(rs.getString("number"));
lfid.setText(rs.getString("gender"));
lfid.setText(rs.getString("country"));

lfid.setText(rs.getString("address"));

lfid.setText(rs.getString("phone"));

lfid.setText(rs.getString("email"));



}

}catch(Exception e){
    e.printStackTrace();
}



    setVisible(true);
}

public void actionPerformed(ActionEvent ae)
{
    if(ae.getSource()==add)
    {
        String username=labelusername.getText();
        String id=lfid.getText();
        String number=lfnumber.getText();
        String name=labelname.getText();
        String gender=null;
        if(rmale.isSelected())
        {
            gender="Male";
        }
        else
        {
            gender="Female";
        }
        String country=lfcountry.getText();
        String address=lfaddress.getText();
        String phone=lfphone.getText();
        String email=lfemail.getText();
        
        try{
            Conn c=new Conn();
String query = "UPDATE customer set username='"+username+"',id='"+id+"',number='"+number+"',name='"+name+"',gender='"+gender+"', country='"+country+"', address='"+address+"', phone='"+phone+"', email='"+email+"')"; 
                c.s.executeUpdate(query);
c.s.executeUpdate(query);
JOptionPane.showMessageDialog(null,"Customer Deatils Updated successfully");
setVisible(false);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
                
                
    }}
public static void main(String[] args)
{
new Updatedetails("sharukh");
}
}
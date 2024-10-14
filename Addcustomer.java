
package travel.management.system1;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Addcustomer extends JFrame implements ActionListener{
    String username;
    JLabel lbusername,labelname,labelusername;
    JComboBox comboid;
    JTextField lfnumber,lfcountry,lfaddress,lfphone,lfemail;
    JRadioButton rmale,rfemale;
    JButton add,back;
Addcustomer(String username){
    setBounds(450,200,850,550);
setLayout(null);
getContentPane().setBackground(Color.WHITE);

 lbusername=new JLabel("Username");
lbusername.setBounds(30,50,150,25);
add(lbusername);

labelusername=new JLabel(username);
labelusername.setBounds(220,90,150,25);
add(labelusername);


JLabel lbid=new JLabel("Id");
lbid.setBounds(30,90,150,25);
add(lbid);

comboid=new JComboBox(new String[]{"Passport","Aadhar Card","Pan Card","Ration Card"});
comboid.setBounds(220,90,150,25);
comboid.setBackground(Color.WHITE);
add(comboid);

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

rmale=new JRadioButton("Male");
rmale.setBounds(220,210,70,25);
rmale.setBackground(Color.WHITE);
add(rmale);

rfemale=new JRadioButton("Female");
rfemale.setBounds(300,210,70,25);
rfemale.setBackground(Color.WHITE);
add(rfemale);

ButtonGroup bg=new ButtonGroup();
bg.add(rmale);
bg.add(rfemale);



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

add=new JButton ("Add");
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

ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
Image i2=i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
ImageIcon i3=new ImageIcon(i2);
JLabel image =new JLabel(i3);
image.setBounds(400,40,450,420);
add(image);

try{
  Conn c=new Conn();
ResultSet rs=c.s.executeQuery("select * from account where username='"+this.username+"'");
while(rs.next())
{
labelusername.setText(rs.getString("username"));
labelname.setText(rs.getString("name"));
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
        String id=(String)comboid.getSelectedItem();
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
String query = "INSERT INTO customer (username, id, number, name, gender, country, address, phone, email) VALUES ('" 
                + username + "', '" 
                + id + "', '" 
                + number + "', '" 
                + name + "', '" 
                + gender + "', '" 
                + country + "', '" 
                + address + "', '" 
                + phone + "', '" 
                + email + "');";
c.s.executeUpdate(query);
JOptionPane.showMessageDialog(null,"Customer Deatils added successfully");
setVisible(false);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
       
    }
 else
        {
                setVisible(false);
                }}
public static void main(String[] args)
{
new Addcustomer("sheeba07");
}
}
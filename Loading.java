package travel.management.system1;
import javax.swing.*;
import java.awt.*;
public class Loading extends JFrame implements Runnable {
    JProgressBar bar;
    Thread t;
    String username;
    public void run()
    {
        try
        {
            for(int i=1;i<=101;i++)
            {
            int max=bar.getMaximum();
            int value=bar.getValue();
            if(value<max)
            {
                bar.setValue(bar.getValue()+1);
            }
            else
            {
                setVisible(false);
                new Dashboard(username);
                
            }
            }
        }
        catch(Exception e)
        { 
            e.printStackTrace();
        }
    }
    
    
    Loading()
    {
    t=new Thread(this);
    setBounds(500,200,650,400);
    getContentPane().setBackground(Color.WHITE);
 setLayout(null);
    
  JLabel text=new JLabel ("Loading..Please Wait");
    text.setBounds(120,60,400,40);
    text.setForeground(Color.RED);
    text.setFont(new Font("Raleway",Font.BOLD,35));
    add(text);
    
     JLabel username=new JLabel ("Welcome Sheeba");
    username.setBounds(20,310,400,40);
    username.setForeground(Color.RED);
    username.setFont(new Font("Raleway",Font.BOLD,35));
    add(username);
    
 bar=new JProgressBar();
    bar.setBounds(150,120,300,35);
    bar.setStringPainted(true);
    bar.setMaximum(100);
    add(bar);
    
    
    
    
    
    
    t.start();
    
    
    
    
    
    
    
    
    
    
    
    
    setVisible(true);
    
    
    }
    public static void main(String[] args)
    {
    
    
    new Loading();
    
    
    
    
    
    }
    
}

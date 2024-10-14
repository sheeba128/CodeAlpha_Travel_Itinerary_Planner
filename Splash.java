package travel.management.system1;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {
    Thread thread;
    
    Splash() {
        // Set the initial size and location
        setSize(1200, 600);
        setLocation(200, 100);
        
        // Load the splash image and add it to the frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        setVisible(true);
        
        // Start the thread
        thread = new Thread(this);
        thread.start();
    }
    
    public void run() {
        try {
            // Sleep for 7 seconds before closing the splash screen
            Thread.sleep(7000);
            // Close the splash screen
            setVisible(false);
            // After the splash screen, you could instantiate another window here
            // For example: new Login(); to show the login screen
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        Splash frame = new Splash();
        int x = 1;
        for (int i = 1; i <= 500; x += 7, i += 6) {
            // Use setBounds to set both location and size in one go
            frame.setBounds(750 - (x + i) / 2, 400 - i / 2, x + i, i);
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

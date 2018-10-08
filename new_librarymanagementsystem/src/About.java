import javax.swing.*;
import java.awt.*;

public class About extends JPanel{
    
    public About(){
        
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("images/ab.jpg"));
        
        //Create Lable and ImageIcon setting
        
        JLabel lbl = new JLabel(icon);
        //add Label to the Panel
        this.add(lbl);
        
        JLabel lbl2 = new JLabel("<html><b><h>Find Your Book</h2><br><br><b><p>Developed By:</p><p>Sakar Kardekar</p><p>     Sanya Taraiya</p><p>    Samyak Jain</p><br>"
                + " <font size=\"3\"></font> </li></html>"
             );
        
        lbl2.setFont(new Font("Tahoma",Font.PLAIN,12));
        this.add(lbl2);
                
    }
}

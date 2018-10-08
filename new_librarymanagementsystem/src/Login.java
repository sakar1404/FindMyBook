import javax.swing.JButton;
import javax.swing.JFrame;  
	public class Login {
	public static void main(String[] args) {  
	JFrame f=new JFrame(); 
	          
	JButton b=new JButton("Login "); 
	JButton c=new JButton("Registration"); 
	b.setBounds(130,100,100, 40);  
	c.setBounds(130,200,100,40);          
	f.add(b);
	f.add(c);
	          
	f.setSize(400,400);  
	f.setLayout(null);  
	f.setVisible(true);  
	}  
	}  

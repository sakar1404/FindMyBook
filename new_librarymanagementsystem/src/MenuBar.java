import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.management.JMException;

public class MenuBar extends JMenuBar{
    
    public JMenu file,  book,  search,  loan,help, sell ;
    public JMenuItem   exit,  addBook,  listBook,about, buyBook,listsell;
    public JMenuItem  searchBooks,  borrowBook,  returnBook ,sellBook;
    
    public ImageIcon[] icons;
    
    public String[] imgName1 = {"images/x.gif", "images/f.gif",
        "images/g.gif", "images/c.gif",
        "images/aa.gif", "images/b.gif",
        "images/c.gif", "images/aa.gif",
        "images/b.gif", "images/f.gif","images/a.gif","images/Help1.gif"};
    
    public MenuBar(){
        
        //add book,search,loan,Buy & help Menus to the MenuBar
        
        this.add(file = new JMenu("File"));
        this.add(book = new JMenu("Books"));
        this.add(search = new JMenu("Search"));
        this.add(loan = new JMenu("Loan"));
        this.add(sell = new JMenu("Sell"));
        this.add(help = new JMenu("Help"));
        //File menu shorcut keyword using Mnemonic
        
        file.setMnemonic('f');
        book.setMnemonic('b');
        sell.setMnemonic('m');
        search.setMnemonic('s');
        loan.setMnemonic('l');
        
        //set Image Icons
        
        icons = new ImageIcon[14];
        
        for(int i=0;i<imgName1.length;i++){
            
            icons[i] = new ImageIcon(ClassLoader.getSystemResource(imgName1[i]));
        }
        
        file.add(exit = new JMenuItem("Exit",icons[0]));
        
        book.add(addBook = new JMenuItem("Add Book To Lend",icons[1]));
        book.add(listBook = new JMenuItem("List All Books",icons[2]));
        
        search.add(searchBooks = new JMenuItem("Search",icons[6]));
        
        loan.add(borrowBook = new JMenuItem("Borrow Books",icons[7]));
        loan.add(returnBook = new JMenuItem("Return Books",icons[8]));
        
         help.add(about = new JMenuItem("About"));
        
        sell.add(sellBook = new JMenuItem("Add Book To Sell",icons[9]));
        sell.add(buyBook = new JMenuItem("Buy Book ",icons[10]));
        
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,ActionEvent.ALT_MASK));
        searchBooks.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
        
        addBook.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
        
        sellBook.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        buyBook.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
        
        listBook.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
        
        borrowBook.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
        returnBook.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
        
        about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,ActionEvent.CTRL_MASK));
    }
}

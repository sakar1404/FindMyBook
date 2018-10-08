import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Library extends JFrame implements ActionListener {

   
   
    private JPanel searchPanel = new JPanel();
   
    private JToolBar searchToolBar = new JToolBar();
   
    private JLabel searchLabel = new JLabel("Book title: ");
   
    private JTextField searchTextField = new JTextField(15);
    
    private JButton goButton = new JButton("Go");

    private JDesktopPane desktop = new JDesktopPane();
    private JSplitPane splitPane;
    private JScrollPane desktopScrollPane;
    private JScrollPane treeScrollPane;
    
    private MenuBar menu;
    private Toolbar toolbar;
    private Statusbar statusbar = new Statusbar();
    private ListBooks listBooks;
    private ListBooksToSell listBooksToSell;
    private AddBooks addBooks;
    private SellBooks sellBooks;
    private BuyBooks buyBooks;
    private BorrowBooks borrowBooks;
    private ReturnBooks returnBooks;
    private ListMembers listMembers;
    private SearchBooksAndMembers search;
    private ListBooksToSell listsells;

    
    public Library() {
        
        super("Find Your Book");
        //for setting the size
        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
      // setSize(screenSize.width, screenSize.height - 30);
       setExtendedState(JFrame.MAXIMIZED_BOTH);

        
        
        
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image image = kit.getImage(ClassLoader.getSystemResource("images/l.gif"));
        setIconImage(image);

        menu = new MenuBar();
        toolbar = new Toolbar();
             
        
        setJMenuBar(menu);
        menu.exit.addActionListener(this);
        menu.addBook.addActionListener(this);
        menu.listBook.addActionListener(this);
       /* menu.addMember.addActionListener(this);*/
       /* menu.listMember.addActionListener(this);*/
        menu.searchBooks.addActionListener(this);
        menu.borrowBook.addActionListener(this);
        menu.returnBook.addActionListener(this);
        menu.about.addActionListener(this);
        menu.sellBook.addActionListener(this);
        menu.buyBook.addActionListener(this);
      //  menu.listsell.addActionListener(this);
        //get the graphical user interface components display the desktop
        Container cp = getContentPane();
        desktop.setBackground(Color.BLACK);
        cp.add("Center", desktop);
        
        searchLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        
        searchTextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
        goButton.setFont(new Font("Tahoma", Font.BOLD, 9));
        
        searchToolBar.add(searchLabel);
       
        searchToolBar.add(searchTextField);
        
        searchToolBar.add(goButton);
        
        goButton.addActionListener(this);
        
        searchPanel.setLayout(new BorderLayout());
        
        searchPanel.add("North", toolbar);
       
        cp.add("East", searchPanel);
        
        cp.add("West", statusbar);

        for (int i = 0; i < toolbar.imgName5.length; i++) {
            //for adding the action to the button
            toolbar.btn[i].addActionListener(this);
        }

        //for adding WindowListener to the program
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        //show the program
        show();
    }

    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menu.addBook || e.getSource() == toolbar.btn[0]) {
            Thread runner = new Thread() {

                public void run() {
                    addBooks = new AddBooks();
                    desktop.add(addBooks);
                    try {
                        addBooks.setSelected(true);
                    } catch (java.beans.PropertyVetoException e) {
                    }
                }
            };
            runner.start();
            }
            
            if (e.getSource() == menu.sellBook || e.getSource() == toolbar.btn[1]) {
                Thread runner = new Thread() {

                    public void run() {
                        sellBooks = new SellBooks();
                        desktop.add(sellBooks);
                        try {
                            sellBooks.setSelected(true);
                        } catch (java.beans.PropertyVetoException e) {
                        }
                    }
                };
                runner.start();
        }
            if (e.getSource() == menu.buyBook || e.getSource() == toolbar.btn[3]) {
                Thread runner = new Thread() {

                    public void run() {
                        buyBooks = new BuyBooks();
                        desktop.add(buyBooks);
                        try {
                            buyBooks.setSelected(true);
                        } catch (java.beans.PropertyVetoException e) {
                        }
                    }
                };
                runner.start();
            }
            
        if (e.getSource() == menu.listBook || e.getSource() == toolbar.btn[4]) {
            Thread runner = new Thread() {

                public void run() {
                    listBooks = new ListBooks();
                    desktop.add(listBooks);
                    try {
                        listBooks.setSelected(true);
                    } catch (java.beans.PropertyVetoException e) {
                    }
                }
            };
            runner.start();
        }
      /*if (e.getSource() == menu.addMember || e.getSource() == toolbar.btn[2]) {
            Thread runner = new Thread() {

                public void run() {
                    addMembers = new AddMembers();
                    desktop.add(addMembers);
                    try {
                        addMembers.setSelected(true);
                    } catch (java.beans.PropertyVetoException e) {
                    }
                }
            };
            runner.start();
        }
        if (e.getSource() == menu.listMember || e.getSource() == toolbar.btn[3]) {
            Thread runner = new Thread() {

                public void run() {
                    listMembers = new ListMembers();
                    desktop.add(listMembers);
                    try {
                        listMembers.setSelected(true);
                    } catch (java.beans.PropertyVetoException e) {
                    }
                }
            };
            runner.start();
        }*/
        if (e.getSource() == menu.searchBooks || e.getSource() == toolbar.btn[6]) {
            Thread runner = new Thread() {

                public void run() {
                    search = new SearchBooksAndMembers();
                    desktop.add(search);
                    try {
                        search.setSelected(true);
                    } catch (java.beans.PropertyVetoException e) {
                    }
                }
            };
            runner.start();
        }
        if (e.getSource() == menu.borrowBook || e.getSource() == toolbar.btn[2]) {
            Thread runner = new Thread() {

                public void run() {
                    borrowBooks = new BorrowBooks();
                    desktop.add(borrowBooks);
                    try {
                        borrowBooks.setSelected(true);
                    } catch (java.beans.PropertyVetoException e) {
                    }
                }
            };
            runner.start();
        }
        if (e.getSource() == menu.returnBook || e.getSource() == toolbar.btn[7]) {
            Thread runner = new Thread() {

                public void run() {
                    returnBooks = new ReturnBooks();
                    desktop.add(returnBooks);
                    try {
                        returnBooks.setSelected(true);
                    } catch (java.beans.PropertyVetoException e) {
                    }
                }
            };
            runner.start();
        }
        
        if (e.getSource() == menu.exit || e.getSource() == toolbar.btn[8]) {
            dispose();
            System.exit(0);
        }
        if (e.getSource() == menu.listsell || e.getSource() == toolbar.btn[5]) {
            Thread runner = new Thread() {

                public void run() {
                    listsells = new ListBooksToSell();
                    desktop.add(listsells);
                    try {
                        listsells.setSelected(true);
                    } catch (java.beans.PropertyVetoException e) {
                    }
                }
            };
            runner.start();
        }
        
        if(e.getSource() == menu.about || e.getSource() == toolbar.btn[9]){
            
            Thread runner = new Thread(){
          
              public void run(){
                  
                  JOptionPane.showMessageDialog(null, new About(),"About us..!!",JOptionPane.PLAIN_MESSAGE);
              }
          };
          runner.start();
        }
    }
}

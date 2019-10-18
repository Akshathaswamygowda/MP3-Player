/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmp30;

import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JOptionPane;
import java.awt.dnd.DropTarget;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import static java.lang.Math.random;
import static java.lang.System.out;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Selector;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import org.xml.sax.SAXException;
import javax.swing.Timer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerListener;
import javazoom.spi.mpeg.sampled.file.MpegAudioFileReader;
import org.tritonus.share.sampled.file.TAudioFileFormat;


/**
 *
 * @author karth
 */
public class GUI {
    boolean c;
    JFrame jFrame;
    JFrame jFrame2;
    JPanel jPanel1;
    JPanel jPanel2;
    JPanel jPanel3;
    JMenu jMenu;
    JMenu jMenu2;
    JButton play;
    JButton pause;
    JButton resume;
    JButton stop;
    JButton next;
    JButton previous;
    JTable jTable;
    JTable jTable2;
    JMenuBar jmb;
    JMenuItem add;
    JMenuItem add1;
    JMenuItem open;
    JMenuItem delete;
    JMenuItem delete1;
    JMenuItem exit;   
    JMenuItem pl;
    JMenuItem pl2;
    JMenuItem openpl;
    JMenuItem delpl;
    JMenuItem jm;
    
    JMenuItem mplay;
    JMenuItem mnext;
    JMenuItem mprevious;
    JMenuItem mcs;
    
    JMenuItem incvol;
    JMenuItem decvol;
    
    JCheckBoxMenuItem shuffle;
    JCheckBoxMenuItem repeat;
    
    long duration;
    long lmp3;
    //JMenuItem mplay;
    //JMenuItem mplay;
    
    Timer timer;
    JProgressBar jbar;
    Timer timer2;
    
    String mc = null;
    static BasicPlayerListener bplListener;
    static BasicPlayer player1;
    String cursong;
    
    JMenu addpl;
    JPopupMenu jPopup;
    JPopupMenu jPopup2;
    
    JPopupMenu popupMenu;
    JLabel jLabel;
    JLabel jLabel3;
    JFileChooser chooser;
    JTree jTree1;
    JTree jTree2;
    ButtonListener b1;
    ButtonListener b2;
    ButtonListener b3;
    ButtonListener b4;
    ButtonListener b5;
    ButtonListener b6;
    
    BasicPlayerListener bpl;
    BasicPlayer player;
    int CurrentSelectedRow;
    String url;
    JScrollPane scrollPane; 
    JScrollPane scrollPane2; 
    URL a;
    KeyListener m1;
    KeyListener m2;
    String path123;
    Boolean del = true;
    DefaultMutableTreeNode playlists;
    DefaultMutableTreeNode dmn;
    String plist="Library";
    JMenuItem jm2;
    JSlider slider;
    JTable jt2;
    float aud = (float) 0.85;
    String playli;
    Boolean set = false;
    Boolean shuf = false;
    Boolean rep = false;
    Object k = null;
    int playing = 0;
    JMenu recent;
    JLabel timer1;
    JLabel timer12;
    Long byteDuration;
    
    Boolean cAlbum = false;
    Boolean cArtist = false;
    Boolean cYear = false; 
    Boolean cGenre= false;
    Boolean cComment = false;
    
    String spl;
    
    int svst;
    
    public GUI() throws IOException, SQLException {
        player = new BasicPlayer() ;
        try {
            player.setGain(aud);
        } catch (BasicPlayerException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        jFrame = new JFrame("My iTunes");
        //jFrame.setLayout(new FlowLayout());
        
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        
        

        jTable2 = new JTable();
        jMenu = new JMenu("Options");
        jMenu2 = new JMenu("Controls");
        
        m1 = new Key();
        m2 = new Key();
        
       /* add.addActionListener((ActionListener) m1);
        delete.addActionListener((ActionListener) m2);*/
        
        bpl = new BasicPlayerTest();
                
        b1 = new ButtonListener();
        b2 = new ButtonListener();
        b3 = new ButtonListener();
        b4 = new ButtonListener();
        b5 = new ButtonListener();
        b6 = new ButtonListener();
        
        chooser = new JFileChooser("C:\\Users\\karth\\Music");
        
        
        play = new JButton("Play");
        pause = new JButton("Pause");
        resume = new JButton("Resume");
        stop = new JButton("Stop");
        previous = new JButton("Previous");
        next = new JButton("Next");
        jTable = new JTable();
        
        jTable.setModel(new DefaultTableModel(
            
            new Object [] {
                "Title", "Album", "Artist", "Year", "Genre", "Comment", "Path"
            },7
        ));
        jTable.setDefaultEditor(Object.class,null);
        
         popupMenu = new JPopupMenu();
         JCheckBoxMenuItem Album = new JCheckBoxMenuItem("Album",true);
         Album.addActionListener(new dishead());
         popupMenu.add(Album);
         
         JCheckBoxMenuItem Artist = new JCheckBoxMenuItem("Artist",true);
         Artist.addActionListener(new dishead());
         popupMenu.add(Artist);
         
         JCheckBoxMenuItem Comment = new JCheckBoxMenuItem("Comment",true);
         Comment.addActionListener(new dishead());
         popupMenu.add(Comment);
         
         JCheckBoxMenuItem Year = new JCheckBoxMenuItem("Year",true);
         Year.addActionListener(new dishead());
         popupMenu.add(Year);
         
         JCheckBoxMenuItem Genre = new JCheckBoxMenuItem("Genre",true);
         Genre.addActionListener(new dishead());
         popupMenu.add(Genre);
        
        jTable.getTableHeader().addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent me) {
            if (SwingUtilities.isRightMouseButton(me))
               popupMenu.show(jTable.getTableHeader(), me.getX(), me.getY());
         }
      });
        jmb = new JMenuBar();
        //pause.setEnabled(false);
        
        c = false;
        
        jmb.add(jMenu);
        jmb.add(jMenu2);
        jMenu.setMnemonic(KeyEvent.VK_A);
        jMenu.getAccessibleContext().setAccessibleDescription("Add,Remove");
        
        add = new JMenuItem("Add Song",KeyEvent.VK_T); 
        add.addActionListener(new Options());
        add.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
        jMenu.add(add);
        
     
        javax.swing.KeyStroke left = javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_LEFT, java.awt.event.InputEvent.CTRL_MASK);
        jTable.getInputMap(javax.swing.JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(left, "none");
        
        javax.swing.KeyStroke right = javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_RIGHT, java.awt.event.InputEvent.CTRL_MASK);
        jTable.getInputMap(javax.swing.JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(right, "none");
        
        javax.swing.KeyStroke space = javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_SPACE, 0);
        jTable.getInputMap(javax.swing.JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(space, "none");
        
        
        
        open = new JMenuItem("Open Song",KeyEvent.VK_T); 
        open.addActionListener(new Options());
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
        jMenu.add(open);
        
        delete = new JMenuItem("Delete Song",KeyEvent.VK_T); 
        delete.addActionListener(new Options());
        delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
        
        add1 = new JMenuItem("Add Song",KeyEvent.VK_T); 
        add1.addActionListener(new Options());
        add1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
        
        pl = new JMenuItem("Create Playlist",KeyEvent.VK_T);
        pl.addActionListener(new Options());
        pl.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
        
        pl2 = new JMenuItem("Create Playlist",KeyEvent.VK_T);
        pl2.addActionListener(new Options());
        pl2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
        
        openpl = new JMenuItem("Open Playlist",KeyEvent.VK_T); 
        openpl.addActionListener(new Options());
        openpl.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
        
        
        delpl = new JMenuItem("Delete Playlist",KeyEvent.VK_T); 
        delpl.addActionListener(new Options());
        delpl.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
        
        mplay = new JMenuItem("Play",KeyEvent.VK_T); 
        mplay.addActionListener(new Options());
        mplay.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0));
        jMenu2.add(mplay);
        
        mnext = new JMenuItem("Next",KeyEvent.VK_T); 
        mnext.addActionListener(new Options());
        mnext.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, ActionEvent.CTRL_MASK));
        jMenu2.add(mnext);
        
        mprevious = new JMenuItem("Previous",KeyEvent.VK_T); 
        mprevious.addActionListener(new Options());
        mprevious.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, ActionEvent.CTRL_MASK));
        jMenu2.add(mprevious);
        
        mcs = new JMenuItem("Go To Current Song",KeyEvent.VK_T); 
        mcs.addActionListener(new Options());
        mcs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        jMenu2.add(mcs);
        
        recent = new JMenu("Recently Added");
        jMenu2.add(recent);
        createRecent();
        
        
        
        jMenu2.addSeparator();
        
        incvol = new JMenuItem("Increase Volume",KeyEvent.VK_T); 
        incvol.addActionListener(new Options());
        incvol.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
        jMenu2.add(incvol);
        
        decvol = new JMenuItem("Decrease Volume",KeyEvent.VK_T); 
        decvol.addActionListener(new Options());
        decvol.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        jMenu2.add(decvol);
        
        
        jMenu2.addSeparator();
        
        shuffle = new JCheckBoxMenuItem("Shuffle");
        shuffle.addActionListener(new Options());
        jMenu2.add(shuffle);
        
        repeat = new JCheckBoxMenuItem("Repeat");
        repeat.addActionListener(new Options());
        jMenu2.add(repeat);
        
        
        exit = new JMenuItem("Exit");
        exit.addActionListener(new exitApp());
        
        delete1 = new JMenuItem("Delete a Song"); 
        delete1.addActionListener(new Options());
       
        
        addpl = new JMenu("Add to Playlist"); 
        addpl.addActionListener(new Options());
        
        
        
        jMenu.add(pl);
        jMenu.add(delete1);
        jMenu.add(exit);
        
        
        jPopup = new JPopupMenu();
        jPopup2 = new JPopupMenu();
        
        
        //jPopup.add(add);
        jPopup.add(delete);    
        jPopup.add(add1);
        jPopup.add(addpl);
        
        
       
        //jTable.setComponentPopupMenu(jPopup);
        
        jPopup2.add(openpl);
        jPopup2.add(delpl);
        
        String text = "Hello";
       
        
        jLabel = new JLabel();
        jLabel3 = new JLabel();
        //File img = new File("C:\\Users\\karth\\Documents\\NetBeansProjects\\ProjectMp30\\img\\empty.png");
        
        ImageIcon icon = new ImageIcon("C:\\Users\\karth\\Documents\\NetBeansProjects\\ProjectMp30\\img\\empty.png"); 
        jLabel3.setSize(100,100);
        jLabel3.setIcon(icon);
        


        
        
        

        
        play.addActionListener((ActionListener) b1);
        pause.addActionListener((ActionListener) b2);
        stop.addActionListener((ActionListener) b3);
        next.addActionListener((ActionListener) b4);
        previous.addActionListener((ActionListener) b5);
        resume.addActionListener((ActionListener) b6);
        

        MouseListener mouseListener = new MouseAdapter() {
            
            
       
            public void mousePressed(MouseEvent e)
            {
                CurrentSelectedRow =jTable.getSelectedRow();
                        url = jTable.getModel().getValueAt(CurrentSelectedRow, 6).toString();
                        System.out.println(url);
                        System.out.println("Selected index = " + CurrentSelectedRow); 
            }
            
          public void mouseReleased(MouseEvent me)
            {
                
                /*if(SwingUtilities.isLeftMouseButton(me) == true)
                    {
                        CurrentSelectedRow =jTable.getSelectedRow();
                        url = jTable.getModel().getValueAt(CurrentSelectedRow, 6).toString();
                        System.out.println(url);
                        System.out.println("Selected index = " + CurrentSelectedRow); 
                    }
                
                if(SwingUtilities.isRightMouseButton(me) == true)
                    {
                        /*CurrentSelectedRow = jTable.getSelectedRow();
                        url = jTable.getModel().getValueAt(CurrentSelectedRow, 6).toString();
                        System.out.println(url);
                        System.out.println("Selected index = " + CurrentSelectedRow); 
                        //jTable.setComponentPopupMenu(jPopup);*/
                        
                
               
                    Point point = me.getPoint();
        int row1 = jTable.rowAtPoint(point);
        if (me.getClickCount() == 2 && jTable.getSelectedRow() != -1) {
            // your valueChanged overridden method 
             pause.setText("Pause");
                 System.out.println(CurrentSelectedRow);
                
                System.out.println(CurrentSelectedRow);
                System.out.println("Playing");
                try {
                    url = jTable.getModel().getValueAt(CurrentSelectedRow, 6).toString();
                    System.out.println(CurrentSelectedRow);
                    a = new File(url).toURI().toURL();
                    
                } catch (MalformedURLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
 
             try {
                player.open(a);
                player.play();
                
                String sa = "Now Playing : " + jTable.getModel().getValueAt(CurrentSelectedRow, 0).toString();
                jLabel.setText(sa);
                
                Mp3File mp3file = new Mp3File(url);
                if (mp3file.hasId3v2Tag()) {
                       ID3v2 id3v2Tag = mp3file.getId3v2Tag();
                       byte[] img = id3v2Tag.getAlbumImage();
                       if (img == null) {
                              ImageIcon icon = new ImageIcon("C:\\Users\\karth\\Documents\\NetBeansProjects\\ProjectMp30\\img\\empty.png"); 
                                jLabel3.setSize(100,100);
                                jLabel3.setIcon(icon);
                        }
                       else{
                       BufferedImage image = ImageIO.read(new ByteArrayInputStream(img)); 
                       jLabel3.setSize(100,100);
                       Image dimg = image.getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(),Image.SCALE_SMOOTH);
                       ImageIcon icon = new ImageIcon(dimg);
                       jLabel3.setIcon(icon);
                       }
                        
                
                
            }
                
            }   catch (javazoom.jlgui.basicplayer.BasicPlayerException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedTagException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidDataException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
                    if (me.isPopupTrigger())
                {
                    CurrentSelectedRow =jTable.getSelectedRow();
                        url = jTable.getModel().getValueAt(CurrentSelectedRow, 6).toString();
                        System.out.println(url);
                        System.out.println("Selected index = " + CurrentSelectedRow); 
                    JTable source = (JTable)me.getSource();
                    int row = source.rowAtPoint( me.getPoint() );
                    int column = source.columnAtPoint( me.getPoint() );

                    if (! source.isRowSelected(row))
                        source.changeSelection(row, column, false, false);

                    jPopup.show(me.getComponent(), me.getX(), me.getY());
                }
                
                        
                    }
            //}
         
        };
        
        
       
        
        
         jTable.removeColumn(jTable.getColumnModel().getColumn(6));

        DefaultMutableTreeNode lib =  new DefaultMutableTreeNode("Library");
        
        
        playlists =  new DefaultMutableTreeNode("Playlists");
        createNodes();
        
        
        dmn = new DefaultMutableTreeNode();
        dmn.add(lib);
        dmn.add(playlists);
        //jTree1 = new JTree(lib);
        jTree2 = new JTree(dmn);
        jTree2.getSelectionModel().addTreeSelectionListener(new Selector());
        jTree2.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        
        //jTree1.getSelectionModel().addTreeSelectionListener(new Selector1());
        //jTree1.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        
         DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer) jTree2.getCellRenderer();
        renderer.setLeafIcon(null);
        renderer.setClosedIcon(null);
        renderer.setOpenIcon(null);
        

        
        
        
        /*jPanel3.add(jTree1);
        jPanel3.add(jTree2);
        
        jPanel3.setLayout(new BorderLayout());     
        jPanel3.add(jTree1, BorderLayout.NORTH);
        jPanel3.add(jTree2, BorderLayout.NORTH);
    */
        /*
        jPanel3.setLayout(new BorderLayout());     
        //jPanel3.add(jTree1, BorderLayout.NORTH);
        jPanel3.add(jTree2, BorderLayout.NORTH);
*/
        jPanel3.add(jTree2);
        //jPanel3.setPreferredSize(new Dimension(100, 500));
        
        jTree2.setRootVisible(false);
        jTree2.setShowsRootHandles(true);
        
         MouseListener m2 = new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {

                if (SwingUtilities.isRightMouseButton(e)) {

                int row = jTree2.getRowForLocation(e.getX(), e.getY());
                jTree2.setSelectionRow(row);
                jPopup2.show(e.getComponent(), e.getX(), e.getY());
                
    }
}
        };
        
        jTree2.addMouseListener(m2);
        
        scrollPane = new JScrollPane(jTable);
        //tableCheck();
        //assign the listener
        jTable.addMouseListener(mouseListener);
        
        
        
        jTable.setDragEnabled(true);
        jTable.setAutoCreateRowSorter(true);

        jTable.setDropMode(DropMode.INSERT_ROWS);
        
        slider = new JSlider();
        System.out.println(slider.getValue());
         slider.setMinimum(0);
         slider.setMaximum(100);
            slider.setValue(85);
            slider.addChangeListener(new MyChangeAction());
        
        
        //jPanel1.add(jTable);
        jLabel.setSize(700,30);
        jLabel.setText("No Song Playing");
        jLabel.setHorizontalAlignment(JLabel.CENTER);
        jLabel3.setHorizontalAlignment(JLabel.CENTER);
        //jPanel2.add(jLabel);
        jPanel1.add(previous);
        jPanel1.add(play);
        jPanel1.add(pause);
        //jPanel1.add(resume);
        jPanel1.add(stop);
        jPanel1.add(next);
        jPanel1.add(slider);
        
        int sizex = scrollPane.getWidth();
        int sizey = scrollPane.getHeight();
        
        scrollPane2 = new JScrollPane(jPanel3);
        
        //scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        

        
        
        //scrollPane.setLayout(null);
        //jPanel2.setLayout(null);
        //jFrame.add(jPanel2);
        //jFrame.add(scrollPane);
        
        jPanel2.setLayout(new BorderLayout());     
        jPanel2.add(jLabel, BorderLayout.NORTH);
        jPanel2.add(jLabel3, BorderLayout.CENTER);
        jPanel2.add(jPanel1, BorderLayout.SOUTH);
        //jPanel3.setSize(150,500);
        Container contentPane=jFrame.getContentPane();   
        contentPane.setLayout(new BorderLayout());
        jFrame.setJMenuBar(jmb);
        JPanel jp23 = new JPanel();
        jbar = new JProgressBar();
        
        
        timer1 = new JLabel("00:00:00");
        timer12 = new JLabel("00:00:00");
        jp23.add(timer1);
        jp23.add(jbar);
        jp23.add(timer12);
        contentPane.add(jp23, BorderLayout.NORTH);
        
        contentPane.add(scrollPane, BorderLayout.CENTER);
        contentPane.add(scrollPane2, BorderLayout.WEST);
        //contentPane.add(jPanel3, BorderLayout.WEST);
        contentPane.add(jPanel2, BorderLayout.SOUTH);
        
        showAlbum();
        
        //this.add(jPanel1);
       // this.add(jPanel2);
       //this.add(scrollPane);
       //this.setSize(700,500);
        
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
        }
        public void go() throws IOException{
        jFrame.setSize(700,500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        CallDragMp3();
        
        
    }
        
        public void CallDragMp3() throws IOException{
        DragMp3 d = new DragMp3(jTable, plist, jTable);
        new DropTarget(jFrame,d);


    }
        
         public void createNodes() throws SQLException {
            playlists.removeAllChildren();
            Connection con = DatabaseConnect.getConnection();
            Statement st = null;   
            ResultSet rs = null;
            st = con.createStatement();
            String qr = "Select name from playlists";
            rs = st.executeQuery(qr);
            jPopup.remove(addpl);
            addpl = new JMenu("Add to Playlist"); 
            jPopup.add(addpl);
            while(rs.next()){
                DefaultMutableTreeNode playlist = new DefaultMutableTreeNode(rs.getString("name"));
                playlists.add(playlist);
                
                jm = new JMenuItem(rs.getString("name"),KeyEvent.VK_T);
                jm.addActionListener(new Options1());
                jm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
                addpl.add(jm);
                
            }
            
            
            
    
    
    
}
         
         public void createRecent()
         {
             
        try {
            
            
            
            Connection con = DatabaseConnect.getConnection();   
            Statement st = null;
            ResultSet rs = null;
            st = con.createStatement();
            String qr = "Select name from recent";
            rs = st.executeQuery(qr);
            
            int c = 0;
            while(rs.next()){
                if(c<10){
                JMenuItem jm1 = new JMenuItem(rs.getString("name"),KeyEvent.VK_T);
                jm1.addActionListener(new Options2());
                //jm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
                recent.add(jm1);
                c++;
                }   
            }
        } catch (SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
         
         
         
         public void createNodes2() throws SQLException {
            playlists.removeAllChildren();
            Connection con = DatabaseConnect.getConnection();
            Statement st = null;   
            ResultSet rs = null;
            st = con.createStatement();
            String qr = "Select name from playlists";
            rs = st.executeQuery(qr);
            while(rs.next()){
                DefaultMutableTreeNode playlist = new DefaultMutableTreeNode(rs.getString("name"));
                JMenuItem jm = new JMenuItem(rs.getString("name"));
                addpl.add(jm);
                
                playlists.add(playlist);
                
            }
            
            
            
    
    
    
}
        
        

          
         public ArrayList<DisplayAlbum> callDisplayAlbum()
    {
        ArrayList<DisplayAlbum> da = new ArrayList<>();
        
        Connection con= null;
        Statement st = null;
        
        try
          {
            con=DatabaseConnect.getConnection();
            
            String qr = "select * from library";
            st=con.createStatement();
            ResultSet rs = st.executeQuery(qr);
            
            DisplayAlbum dac;
            while(rs.next()){
                dac = new DisplayAlbum(rs.getString("Title"),rs.getString("Album"),rs.getString("Artist"),rs.getString("Year"),rs.getString("Genre"),rs.getString("Comment"),rs.getString("Path"));
                System.out.println(rs.getString("Title"));
                da.add(dac);
            }
            
     
           }
        catch(Exception e)
           {
            System.out.println(e.getMessage());
           }
        return da;
        
    }
         public void showAlbum(){
         System.out.println("Arey Enti ra");
         
                 
       
         
         
         ArrayList<DisplayAlbum> list = callDisplayAlbum();
         System.out.println(list);
         DefaultTableModel model = (DefaultTableModel)jTable.getModel();
         model.setRowCount(0);
         Object[] row = new Object[7];
         
         for(int i=0;i<list.size();i++){
             row[0] = list.get(i).getTitle();
             row[1] = list.get(i).getAlbum();
             row[2] = list.get(i).getArtist();
             row[3] = list.get(i).getYear();
             row[4] = list.get(i).getGenre();
             row[5] = list.get(i).getComment();
             row[6] = list.get(i).getPath();
             model.addRow(row);
             
         }
         


         
         jTable.changeSelection(0,0,false,false);
         jTree2.setSelectionRow(0);
     }
         
         
         
         public void showAlbum2(){
             
        
         
         
         ArrayList<DisplayAlbum> list = new ArrayList<>();
        
        Connection con= null;
        Statement st = null;
        
        try
          {
            con=DatabaseConnect.getConnection();
            String qr=null;
            if(plist == "Library"){
                qr = "select `b`.`Title`, `b`.`Album`, `b`.`Artist`, `b`.`Year`, `b`.`Genre`, `b`.`Comment`, `b`.`Path` from spl a left outer join library b on b.Path = a.song where a.playist = \""+plist+"\"";
            }
            else {
                qr = "select `b`.`Title`, `b`.`Album`, `b`.`Artist`, `b`.`Year`, `b`.`Genre`, `b`.`Comment`, `b`.`Path` from spl a left outer join library b on b.Path = a.song where a.playist = \""+plist+"\"";
            }
            st=con.createStatement();
            ResultSet rs = st.executeQuery(qr);
            
            DisplayAlbum dac;
            while(rs.next()){
                dac = new DisplayAlbum(rs.getString("Title"),rs.getString("Album"),rs.getString("Artist"),rs.getString("Year"),rs.getString("Genre"),rs.getString("Comment"),rs.getString("Path"));
                System.out.println(rs.getString("Title"));
                list.add(dac);
            }
            
     
           }
        catch(Exception e)
           {
            System.out.println(e.getMessage());
           }
         System.out.println(list);
         DefaultTableModel model = (DefaultTableModel)jTable.getModel();
         model.setRowCount(0);
         Object[] row = new Object[7];
         
         for(int i=0;i<list.size();i++){
             row[0] = list.get(i).getTitle();
             row[1] = list.get(i).getAlbum();
             row[2] = list.get(i).getArtist();
             row[3] = list.get(i).getYear();
             row[4] = list.get(i).getGenre();
             row[5] = list.get(i).getComment();
             row[6] = list.get(i).getPath();
             model.addRow(row);
             
         }

         
         jTable.changeSelection(0,0,false,false);
         }
         
         public void showAlbum22(){
             
       
         
         
         ArrayList<DisplayAlbum> list = new ArrayList<>();
        
        Connection con= null;
        Statement st = null;
        
        try
          {
              String qr = null;
            con=DatabaseConnect.getConnection();
            if (plist !="Library")
            {
                qr = "select `b`.`Title`, `b`.`Album`, `b`.`Artist`, `b`.`Year`, `b`.`Genre`, `b`.`Comment`, `b`.`Path` from spl a left outer join library b on b.Path = a.song where a.playist = \""+plist+"\"";
            }
            
            else
            {
                qr = "select * from library";
            }

            st=con.createStatement();
            ResultSet rs = st.executeQuery(qr);
            
            DisplayAlbum dac;
            while(rs.next()){
                dac = new DisplayAlbum(rs.getString("Title"),rs.getString("Album"),rs.getString("Artist"),rs.getString("Year"),rs.getString("Genre"),rs.getString("Comment"),rs.getString("Path"));
                System.out.println(rs.getString("Title"));
                list.add(dac);
            }
            
     
           }
        catch(Exception e)
           {
            System.out.println(e.getMessage());
           }
         System.out.println(list);
         DefaultTableModel model = (DefaultTableModel)jTable.getModel();
         model.setRowCount(0);
         Object[] row = new Object[7];
         
         for(int i=0;i<list.size();i++){
             row[0] = list.get(i).getTitle();
             row[1] = list.get(i).getAlbum();
             row[2] = list.get(i).getArtist();
             row[3] = list.get(i).getYear();
             row[4] = list.get(i).getGenre();
             row[5] = list.get(i).getComment();
             row[6] = list.get(i).getPath();
             model.addRow(row);
             
         }

         
         jTable.changeSelection(0,0,false,false);
         }
         
          public void showAlbum23(){
              
              
             
        
         
         
         ArrayList<DisplayAlbum> list = new ArrayList<>();
        
        Connection con= null;
        Statement st = null;
        
        try
          {
              String qr = null;
            con=DatabaseConnect.getConnection();
            if (playli !="Library")
            {
                qr = "select `b`.`Title`, `b`.`Album`, `b`.`Artist`, `b`.`Year`, `b`.`Genre`, `b`.`Comment`, `b`.`Path` from spl a left outer join library b on b.Path = a.song where a.playist = \""+playli+"\"";
            }
            
            else
            {
                qr = "select * from library";
            }

            st=con.createStatement();
            ResultSet rs = st.executeQuery(qr);
            
            DisplayAlbum dac;
            while(rs.next()){
                dac = new DisplayAlbum(rs.getString("Title"),rs.getString("Album"),rs.getString("Artist"),rs.getString("Year"),rs.getString("Genre"),rs.getString("Comment"),rs.getString("Path"));
                System.out.println(rs.getString("Title"));
                list.add(dac);
            }
            
     
           }
        catch(Exception e)
           {
            System.out.println(e.getMessage());
           }
         System.out.println(list);
         DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
         model.setRowCount(0);
         Object[] row = new Object[7];
         
         for(int i=0;i<list.size();i++){
             row[0] = list.get(i).getTitle();
             row[1] = list.get(i).getAlbum();
             row[2] = list.get(i).getArtist();
             row[3] = list.get(i).getYear();
             row[4] = list.get(i).getGenre();
             row[5] = list.get(i).getComment();
             row[6] = list.get(i).getPath();
             model.addRow(row);
             
         }

         
         jTable2.changeSelection(0,0,false,false);
         
        
         
      
         
         
         
         
         
         
          
                 
         }
          
          
         
         public class Selector implements TreeSelectionListener {
                public void valueChanged(TreeSelectionEvent event) { 
                    
                    TreePath tp = event.getNewLeadSelectionPath();  
                        if (tp != null) {
                            plist = tp.getLastPathComponent().toString();
                            System.out.println(plist);
                        }
                    
               /* Object obj = event.getNewLeadSelecfshowtionPath().getLastPathComponent();
                 plist = obj.toString();
                 System.out.println("Show Album");
                */
                if(plist=="Library"){
                    showAlbum();
                    DragMp3 d3 = new DragMp3(jTable, plist, jTable);
                    new DropTarget(jFrame,d3);
                } 
                else{
                 
                 showAlbum2();
                 DragMp3 d2 = new DragMp3(jTable, plist, jTable);
                 new DropTarget(jFrame,d2);
            }
                
                }   
                
                
                
                 
      
        }
         
         
         class dishead implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            JTable jhg = new JTable();
            jhg = jTable;
            int sizea = (scrollPane.getWidth())/6;
            Connection con;
            
           String upcheck = null;
                  
               
            
            if("Album".equals(e.getActionCommand())){
                       AbstractButton aButton = (AbstractButton)e.getSource();
                        boolean selected = aButton.getModel().isSelected();
                        
                        if(!selected){
                            
                             jTable.getColumnModel().getColumn(1).setMinWidth(0);
                             jTable.getColumnModel().getColumn(1).setMaxWidth(0);
                             upcheck = "update table1 set Album = \"false\"";

                        }
                        if(selected){
                            jTable.getColumnModel().getColumn(1).setMaxWidth(sizea);
                            jTable.getColumnModel().getColumn(1).setMinWidth(sizea);
                            upcheck = "update table1 set Album = \"true\"";
                        }
                        
                   }
            if("Artist".equals(e.getActionCommand())){
                       AbstractButton aButton = (AbstractButton)e.getSource();
                        boolean selected = aButton.getModel().isSelected();
                        
                        if(!selected){
                            
                             jTable.getColumnModel().getColumn(2).setMinWidth(0);
                             jTable.getColumnModel().getColumn(2).setMaxWidth(0);
                             upcheck = "update table1 set Artist = \"false\"";

                        }
                        if(selected){
                            jTable.getColumnModel().getColumn(2).setMaxWidth(sizea);
                            jTable.getColumnModel().getColumn(2).setMinWidth(sizea);
                            upcheck = "update table1 set Artist = \"true\"";
                        }
                        
                   }
            if("Year".equals(e.getActionCommand())){
                       AbstractButton aButton = (AbstractButton)e.getSource();
                        boolean selected = aButton.getModel().isSelected();
                        
                        if(!selected){
                            
                             jTable.getColumnModel().getColumn(3).setMinWidth(0);
                             jTable.getColumnModel().getColumn(3).setMaxWidth(0);
                             upcheck = "update table1 set Year = \"false\"";

                        }
                        if(selected){
                            jTable.getColumnModel().getColumn(3).setMaxWidth(sizea);
                            jTable.getColumnModel().getColumn(3).setMinWidth(sizea);
                            upcheck = "update table1 set Year = \"true\"";
                        }
                        
                   }
            if("Genre".equals(e.getActionCommand())){
                       AbstractButton aButton = (AbstractButton)e.getSource();
                        boolean selected = aButton.getModel().isSelected();
                        
                        if(!selected){
                            
                             jTable.getColumnModel().getColumn(4).setMinWidth(0);
                             jTable.getColumnModel().getColumn(4).setMaxWidth(0);
                             upcheck = "update table1 set Genre = \"false\"";

                        }
                        if(selected){
                            jTable.getColumnModel().getColumn(2).setMaxWidth(sizea);
                            jTable.getColumnModel().getColumn(2).setMinWidth(sizea);
                            upcheck = "update table1 set Genre = \"true\"";
                        }
                        
                   }
            if("Comment".equals(e.getActionCommand())){
                       AbstractButton aButton = (AbstractButton)e.getSource();
                        boolean selected = aButton.getModel().isSelected();
                        
                        if(!selected){
                            
                             jTable.getColumnModel().getColumn(5).setMinWidth(0);
                             jTable.getColumnModel().getColumn(5).setMaxWidth(0);
                             upcheck = "update table1 set Comment = \"false\"";

                        }
                        if(selected){
                            jTable.getColumnModel().getColumn(5).setMaxWidth(sizea);
                            jTable.getColumnModel().getColumn(5).setMinWidth(sizea);
                            upcheck = "update table1 set Comment = \"true\"";
                        }
                        
                   }
            
            con=null;
                            PreparedStatement ps=null;
                            con=DatabaseConnect.getConnection();
                            try {
                                
                                ps=con.prepareStatement(upcheck);
                                ps.executeUpdate();
                                
                                
                                
                            } catch (SQLException ex) {
                                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
            
        }
             
         }
         
         
         
         
          class Options implements ActionListener{
              
              
              
              
            Actions ac = new Actions();
                
                public void actionPerformed(ActionEvent e) {
                    
                   if("Add Song".equals(e.getActionCommand())){
                       ac.add(chooser,jTable,plist);
                       
                       if(plist=="Library"){
                    showAlbum();
                    } 
                        else{
                 
                        showAlbum2();
                        showAlbum23();
                        


            }
                   }
                   
                   if("Open Song".equals(e.getActionCommand())){
                       try {
                           ac.open(chooser, player, jLabel, jLabel3);    
                           
                       } catch (UnsupportedTagException ex) {
                           Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                       } catch (InvalidDataException ex) {
                           Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                       }
                    }
        
                   if("Delete Song".equals(e.getActionCommand())){
                        CurrentSelectedRow =jTable.getSelectedRow();
                        
                        if(plist=="Library"){
                            ac.delete(jTable,CurrentSelectedRow, plist);
                            showAlbum();
                        } 
                            else{
                            ac.delete1(jTable,CurrentSelectedRow, plist);
                            showAlbum2();
                            showAlbum23();
            }
                        
       }
                    
                    if("Delete a Song".equals(e.getActionCommand())){
                        CurrentSelectedRow =jTable.getSelectedRow();
                        ac.delete(jTable,CurrentSelectedRow,plist);
                        
                        
                        
                        if(plist=="Library"){
                            ac.delete(jTable,CurrentSelectedRow, plist);
                            showAlbum();
                        } 
                            else{
                            ac.delete1(jTable,CurrentSelectedRow, plist);
                            showAlbum2();
                            
            }
                       
                        
                   
       }
                    
                    if("Create Playlist".equals(e.getActionCommand())){
                        DefaultMutableTreeNode root = null;
                        try {
                            String newpl = JOptionPane.showInputDialog(jFrame,"Enter Playlist name");
                            Connection con=null;
                            PreparedStatement ps=null;
                            con=DatabaseConnect.getConnection();
                            try {
                                DefaultTreeModel model = (DefaultTreeModel)jTree2.getModel();
                                root = (DefaultMutableTreeNode)model.getRoot();
                                ps=con.prepareStatement ("insert into playlists (name) values (?)");
                                ps.setString(1,newpl);
                                ps.executeUpdate();
                                model.reload(root);
                                
                                
                            } catch (SQLException ex) {
                                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                           
                            createNodes();
                            plist = newpl;
                            showAlbum2();
                            TreePath path1 = find(jTree2,plist);
                            jTree2.setSelectionPath(path1);
                      
                        } catch (SQLException ex) {
                            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        
                           
       }                
                    
                    if("Delete Playlist".equals(e.getActionCommand())){
                        System.out.println("Deleyte Clicked");
                        DefaultMutableTreeNode root = null;
                        Connection con=null;
                        PreparedStatement ps=null;
                        con=DatabaseConnect.getConnection();
                        try {
                            DefaultTreeModel model = (DefaultTreeModel)jTree2.getModel();
                            root = (DefaultMutableTreeNode)model.getRoot();
                            ps=con.prepareStatement ("delete from playlists where name=\""+plist+"\"");
                            ps.executeUpdate();
                            ps=con.prepareStatement ("delete from spl where playist=\""+plist+"\"");
                            ps.executeUpdate();
                            model.reload(root);
                            
                            
                        } catch (SQLException ex) {
                            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        showAlbum();
                       try {
                           createNodes();
                       } catch (SQLException ex) {
                           Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                       }
                        setNodeExpandedState(jTree2,root,true);
                       set = false;
                       jFrame2.dispose();
                        
                           
       } 
                    
                    if("Open Playlist".equals(e.getActionCommand())){
                        set = true;
                       try {
                           GUI3 g = new GUI3(plist, CurrentSelectedRow, jTable);
                           jFrame2 = g.go();
                           jFrame2.setVisible(true);
                       } catch (IOException ex) {
                           Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                       }
                       showAlbum();
                        
                           
       }
                    
                    if("Play".equals(e.getActionCommand())){
                
                pause.setText("Pause");
                 System.out.println(CurrentSelectedRow);
                
                System.out.println(CurrentSelectedRow);
                System.out.println("Playing");
                try {
                    CurrentSelectedRow =jTable.getSelectedRow();
                    url = jTable.getModel().getValueAt(CurrentSelectedRow, 6).toString();
                    System.out.println(CurrentSelectedRow);
                    a = new File(url).toURI().toURL();
                    
                } catch (MalformedURLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
 
             try {
                svst = CurrentSelectedRow;
                player.open(a);
                player.play();
                
                
                
                
                String sa = "Now Playing : " + jTable.getModel().getValueAt(CurrentSelectedRow, 0).toString();
                jLabel.setText(sa);
                
                Mp3File mp3file = new Mp3File(url);
                if (mp3file.hasId3v2Tag()) {
                       ID3v2 id3v2Tag = mp3file.getId3v2Tag();
                       byte[] img = id3v2Tag.getAlbumImage();
                       if (img == null) {
                              ImageIcon icon = new ImageIcon("C:\\Users\\karth\\Documents\\NetBeansProjects\\ProjectMp30\\img\\empty.png"); 
                                jLabel3.setSize(100,100);
                                jLabel3.setIcon(icon);
                        }
                       else{
                       BufferedImage image = ImageIO.read(new ByteArrayInputStream(img)); 
                       jLabel3.setSize(100,100);
                       Image dimg = image.getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(),Image.SCALE_SMOOTH);
                       ImageIcon icon = new ImageIcon(dimg);
                       jLabel3.setIcon(icon);
                       lmp3 = mp3file.getLengthInSeconds();
                       }
                        if(!shuf){
                    //recent = new JMenu("Recently Played");
                Connection con=null;
                            PreparedStatement ps=null;
                            con=DatabaseConnect.getConnection();
                            try {
                                
                                ps=con.prepareStatement ("insert into recent (name,path) values (?,?)");
                                ps.setString(1,jTable.getModel().getValueAt(CurrentSelectedRow, 0).toString());
                                ps.setString(2,url);
                                ps.executeUpdate();
                                
                                recent.add(jTable.getModel().getValueAt(CurrentSelectedRow, 0).toString());
                                
                            } catch (SQLException ex) {
                                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                           
                //createRecent();
                }
                
                
            }
                
            }   catch (javazoom.jlgui.basicplayer.BasicPlayerException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedTagException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidDataException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                    
                    if("Next".equals(e.getActionCommand())){
                 pause.setText("Pause");
                System.out.println("Next");
                CurrentSelectedRow = CurrentSelectedRow+1;
                if(CurrentSelectedRow==jTable.getRowCount()){
                    CurrentSelectedRow = 0;
                    
                }
                
                jTable.changeSelection(CurrentSelectedRow,0,false,false);
                url = jTable.getModel().getValueAt(CurrentSelectedRow, 6).toString();
                System.out.println(CurrentSelectedRow);
                try {
                    a = new File(url).toURI().toURL();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                try {
                player.open(a);
                player.play();
                String sa = "Now Playing : " + jTable.getModel().getValueAt(CurrentSelectedRow, 0).toString();
                    jLabel.setText(sa);
                    
                    Mp3File mp3file = new Mp3File(url);
                if (mp3file.hasId3v2Tag()) {
                       ID3v2 id3v2Tag = mp3file.getId3v2Tag();
                       byte[] img = id3v2Tag.getAlbumImage();
                       if (img == null) {
                              ImageIcon icon = new ImageIcon("C:\\Users\\karth\\Documents\\NetBeansProjects\\ProjectMp30\\img\\empty.png"); 
                                jLabel3.setSize(100,100);
                                jLabel3.setIcon(icon);
                        }
                       else{
                       BufferedImage image = ImageIO.read(new ByteArrayInputStream(img)); 
                       jLabel3.setSize(100,100);
                       Image dimg = image.getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(),Image.SCALE_SMOOTH);
                       ImageIcon icon = new ImageIcon(dimg);
                       jLabel3.setIcon(icon);
                       }
                       lmp3 = mp3file.getLengthInSeconds();
                        
                
                
            }
                System.out.println("Next playing");
            }   catch (javazoom.jlgui.basicplayer.BasicPlayerException ex) {   
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedTagException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidDataException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }   
            }
             
             if("Previous".equals(e.getActionCommand())){
                 pause.setText("Pause");
                System.out.println("Previous entered");
                CurrentSelectedRow = CurrentSelectedRow-1;
                if(CurrentSelectedRow== -1){
                    CurrentSelectedRow = jTable.getRowCount() - 1;
                    
                }
                jTable.changeSelection(CurrentSelectedRow,0,false,false);
                url = jTable.getModel().getValueAt(CurrentSelectedRow, 6).toString();
                System.out.println(CurrentSelectedRow);
                try {
                    a = new File(url).toURI().toURL();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                try {
                    player.open(a);
                    String sa = "Now Playing : " + jTable.getModel().getValueAt(CurrentSelectedRow, 0).toString();
                    jLabel.setText(sa);
                    Mp3File mp3file = new Mp3File(url);
                if (mp3file.hasId3v2Tag()) {
                       ID3v2 id3v2Tag = mp3file.getId3v2Tag();
                       byte[] img = id3v2Tag.getAlbumImage();
                       if (img == null) {
                             ImageIcon icon = new ImageIcon("C:\\Users\\karth\\Documents\\NetBeansProjects\\ProjectMp30\\img\\empty.png"); 
                                jLabel3.setSize(100,100);
                                jLabel3.setIcon(icon);
                        }
                       else{
                       BufferedImage image = ImageIO.read(new ByteArrayInputStream(img)); 
                       jLabel3.setSize(100,100);
                       Image dimg = image.getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(),Image.SCALE_SMOOTH);
                       ImageIcon icon = new ImageIcon(dimg);
                       jLabel3.setIcon(icon);
                       }
                        if(!shuf){
                 Connection con=null;
                            PreparedStatement ps=null;
                            con=DatabaseConnect.getConnection();
                            try {
                                
                                ps=con.prepareStatement ("insert into recent (name,path) values (?,?)");
                                ps.setString(1,jTable.getModel().getValueAt(CurrentSelectedRow, 0).toString());
                                ps.setString(2,url);
                                ps.executeUpdate();
                                
                                recent.add(jTable.getModel().getValueAt(CurrentSelectedRow, 0).toString());
                                
                            } catch (SQLException ex) {
                                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                           
                //createRecent();
                }
                
                
            }
                } catch (javazoom.jlgui.basicplayer.BasicPlayerException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedTagException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidDataException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    player.play();
                } catch (javazoom.jlgui.basicplayer.BasicPlayerException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Previous playing");
            }
             
             if("Increase Volume".equals(e.getActionCommand())){
                      
                       try {
                           int value = slider.getValue();
                           value = value + 10;
                           slider.setValue(value);
                           Float aud1 = (float)value/100;
                           player.setGain(aud1);
                       } catch (BasicPlayerException ex) {
                           Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                       }
                   }
             
             if("Decrease Volume".equals(e.getActionCommand())){
                      
                       try {
                           int value = slider.getValue();
                           value = value - 10;
                           slider.setValue(value);
                           Float aud1 = (float)value/100;
                           player.setGain(aud1);
                       } catch (BasicPlayerException ex) {
                           Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                       }
                   }
             
            
             
             
             if("Shuffle".equals(e.getActionCommand())){
                       AbstractButton aButton = (AbstractButton)e.getSource();
                        shuf = aButton.getModel().isSelected();
                        
                        if(shuf){
                            System.out.println("Selected");
                        }
                        else
                        System.out.println("Not Selected");
                       
                        int value = slider.getValue();
                     
                   }
             
             
                    
             if("Repeat".equals(e.getActionCommand())){
                       AbstractButton aButton = (AbstractButton)e.getSource();
                        rep = aButton.getModel().isSelected();
                        
                        if(rep){
                            System.out.println("Selected");
                        }
                        else
                        System.out.println("Not Selected");
                       
                     
                   }
             
             if("Go To Current Song".equals(e.getActionCommand())){
                 
                JViewport viewport = (JViewport)jTable.getParent();

                // This rectangle is relative to the table where the
                // northwest corner of cell (0,0) is always (0,0).
                Rectangle rect = jTable.getCellRect(svst, 0, true);

                // The location of the viewport relative to the table
                Point pt = viewport.getViewPosition();

                // Translate the cell location so that it is relative
                // to the view, assuming the northwest corner of the
                // view is (0,0)
                rect.setLocation(rect.x-pt.x, rect.y-pt.y);

                jTable.scrollRectToVisible(rect);
                 jTable.changeSelection(svst,0,false,false);
                 
                    
                   }
                    try {
            player.setGain(aud);
        } catch (BasicPlayerException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
                
                
                
                
                
          }
          
          
          int getRowByValue(TableModel model, String value) {
            for (int i = model.getRowCount() - 1; i >= 0; --i) {
                for (int j = model.getColumnCount() - 1; j >= 0; --j) {
                    if (model.getValueAt(i, j).equals(value)) {
                // what if value is not unique?
                        return i;
                    }
                }
            }
        return -1;
        }
          
          public void tableCheck(){
              
        try {   
            Connection con = DatabaseConnect.getConnection();
            Statement st = null;
            ResultSet rs = null;
            st = con.createStatement();
            String qr = "Select * from table1 ";
            rs = st.executeQuery(qr);
            String cal = null;
            String car = null;
            String cy = null;
            String cg = null;
            String cc = null;
            while(rs.next()){
                cal = rs.getString("Album");
                car = rs.getString("Artist");
                cy = rs.getString("Year");
                cg = rs.getString("Genre");
                cc = rs.getString("Comment");
            }
            System.out.println(cal);
            System.out.println(car);
            System.out.println(cy);
            System.out.println(cg);
            System.out.println(cc);
            if(cal.equals("true"))
                cAlbum = true;
           
            
            if(car.equals("true"))
                cArtist = true;
           
            
            if(cy.equals("true"))
                cYear = true;
           
            
            if(cg.equals("true"))
                cGenre = true;
            
            if(cc.equals("true"))
                cComment = true;
            
            System.out.println(cAlbum);
            System.out.println(cArtist);
            System.out.println(cYear);
            System.out.println(cGenre);
            System.out.println(cComment);
        } catch (SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
            int sizea = (scrollPane.getWidth())/6;
            
                        if(!cAlbum){
                            
                             jTable.getColumnModel().getColumn(1).setMinWidth(0);
                             jTable.getColumnModel().getColumn(1).setMaxWidth(0);
                        }
                        if(cAlbum){
                            jTable.getColumnModel().getColumn(1).setMaxWidth(sizea);
                            jTable.getColumnModel().getColumn(1).setMinWidth(sizea);
                            
                        }
                        
                        if(!cArtist){
                            
                             jTable.getColumnModel().getColumn(2).setMinWidth(0);
                             jTable.getColumnModel().getColumn(2).setMaxWidth(0);
                        }
                        if(cArtist){
                            jTable.getColumnModel().getColumn(2).setMaxWidth(sizea);
                            jTable.getColumnModel().getColumn(2).setMinWidth(sizea);
                            
                        }
                        
                        if(!cYear){
                            
                             jTable.getColumnModel().getColumn(3).setMinWidth(0);
                             jTable.getColumnModel().getColumn(3).setMaxWidth(0);
                        }
                        if(cYear){
                            jTable.getColumnModel().getColumn(3).setMaxWidth(sizea);
                            jTable.getColumnModel().getColumn(3).setMinWidth(sizea);
                            
                        }
                        
                        if(!cGenre){
                            
                             jTable.getColumnModel().getColumn(4).setMinWidth(0);
                             jTable.getColumnModel().getColumn(4).setMaxWidth(0);
                        }
                        if(cGenre){
                            jTable.getColumnModel().getColumn(4).setMaxWidth(sizea);
                            jTable.getColumnModel().getColumn(4).setMinWidth(sizea);
                            
                        }
                        
                        if(!cComment){
                            
                             jTable.getColumnModel().getColumn(5).setMinWidth(0);
                             jTable.getColumnModel().getColumn(5).setMaxWidth(0);
                        }
                        if(cComment){
                            jTable.getColumnModel().getColumn(5).setMaxWidth(sizea);
                            jTable.getColumnModel().getColumn(5).setMinWidth(sizea);
                            
                        }
        
              
          }
          
          
          public  void resetBpl()
    {
        /*
        if(bplListener != null)
        {
            player.removeBasicPlayerListener(bplListener);
            
        }
        

        
        player.addBasicPlayerListener(bplListener = new BasicPlayerListener() {
            @Override
            public void opened(Object stream, Map properties) {
               System.out.println(stream);
                //System.out.println((String)stream);
                
                Object g = properties.get("duration");
                long microsec = Long.valueOf(g.toString());
                long lenSec = Math.round(microsec / 1000000);
                
                System.out.println(lenSec);
                
                    
            }

    
               

            

            public void stateUpdated(BasicPlayerEvent event) {
            }

            public void setController(BasicController controller) {
            }

           @Override
           public void progress(int i, long l, byte[] bytes, Map properties) {
               
               if(properties.get("mp3.position.microseconds") != null)
                {
                    duration = l;
                    Object sMicroSeconds = properties.get("mp3.position.microseconds");
                    long microsec = Long.valueOf(sMicroSeconds.toString());
                    long lenSec = Math.round(microsec / 1000000);
                    
                    Date d = new Date(lenSec * 1000L);
                    SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss"); // HH for 0-23
                    df.setTimeZone(TimeZone.getTimeZone("GMT"));
                    String time = df.format(d);
                    
                    timer1.setText(time);
                    
                    System.out.println(properties.toString());
                    System.out.println(i);
                    System.out.println(l);
                   // System.out.println(properties.toString());
                    
                    int lengthSeconds = Math.round(duration / 1000000);
                    long remsec = Math.round(lengthSeconds-lenSec);
                    Date d2 = new Date(remsec * 1000L);
                    SimpleDateFormat df2 = new SimpleDateFormat("HH:mm:ss"); // HH for 0-23
                    df2.setTimeZone(TimeZone.getTimeZone("GMT"));
                    String time2 = df2.format(d2);
                    
                    timer12.setText(time2);
                    
                }
                
                

           }
        }); 
        */
    }
          
          
          
          class Options2 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
                    
                    JMenuItem menuItem = (JMenuItem)e.getSource();
                    String abc123 = menuItem.getText();
                    
                    
                    try {
            
            
            
            Connection con = DatabaseConnect.getConnection();   
            Statement st = null;
            ResultSet rs = null;
            st = con.createStatement();
            String qr = "Select path from recent where name = \"" + abc123 + "\"";
            rs = st.executeQuery(qr);
            
            String playto=null;
            while(rs.next()){
                
                 playto = rs.getString("path");
                System.out.println(playto);
                 
            }
            
            
            
                pause.setText("Pause");
                 System.out.println(CurrentSelectedRow);
                
                System.out.println(CurrentSelectedRow);
                System.out.println("Playing");
                try {
                    CurrentSelectedRow =jTable.getSelectedRow();
                    url = playto;
                    System.out.println(CurrentSelectedRow);
                    a = new File(url).toURI().toURL();
                    
                } catch (MalformedURLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
 
             try {
                svst = CurrentSelectedRow; 
                player.open(a);
                player.play();
                
                
                
                
                
                System.out.println(player.getListeners());
                
                String sa = "Now Playing : " + jTable.getModel().getValueAt(CurrentSelectedRow, 0).toString();
                jLabel.setText(sa);
                
                Mp3File mp3file = new Mp3File(url);
                if (mp3file.hasId3v2Tag()) {
                       ID3v2 id3v2Tag = mp3file.getId3v2Tag();
                       byte[] img = id3v2Tag.getAlbumImage();
                       if (img == null) {
                              ImageIcon icon = new ImageIcon("C:\\Users\\karth\\Documents\\NetBeansProjects\\ProjectMp30\\img\\empty.png"); 
                                jLabel3.setSize(100,100);
                                jLabel3.setIcon(icon);
                        }
                       else{
                       BufferedImage image = ImageIO.read(new ByteArrayInputStream(img)); 
                       jLabel3.setSize(100,100);
                       Image dimg = image.getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(),Image.SCALE_SMOOTH);
                       ImageIcon icon = new ImageIcon(dimg);
                       jLabel3.setIcon(icon);
                       lmp3 = mp3file.getLengthInSeconds();
                       System.out.println("Length of this mp3 is: " + mp3file.getLengthInSeconds() + " seconds");
                       }
                       
                       if(!shuf){
                  con=null;
                            PreparedStatement ps=null;
                            con=DatabaseConnect.getConnection();
                            try {
                                
                                ps=con.prepareStatement ("insert into recent (name,path) values (?,?)");
                                ps.setString(1,jTable.getModel().getValueAt(CurrentSelectedRow, 0).toString());
                                ps.setString(2,url);
                                ps.executeUpdate();
                                
                                recent.add(jTable.getModel().getValueAt(CurrentSelectedRow, 0).toString());
                                
                            } catch (SQLException ex) {
                                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                           
                //createRecent();
                }
                        
                
                
            }
                
            }   catch (javazoom.jlgui.basicplayer.BasicPlayerException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedTagException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidDataException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
        } catch (SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
          
                }
          }
          
          
         
          
          
          class Options1 implements ActionListener{
              
              
              
              
                Actions ac = new Actions();
                
                
                public void actionPerformed(ActionEvent e) {
                    
                    JMenuItem menuItem = (JMenuItem)e.getSource();
                    String abc123 = menuItem.getText();
                    System.out.println(abc123);
                    CurrentSelectedRow =jTable.getSelectedRow();
                    url = jTable.getModel().getValueAt(CurrentSelectedRow, 6).toString();
                    ac.addpl(url,abc123);
                    showAlbum23();
                    TreePath path1 = find(jTree2,abc123);
                    
                    if(set == true){
                        jTree2.setSelectionPath(path1);
                    }
                    else 
                        jTree2.setSelectionRow(0);
                    
                
          }
                
                
                
                
                   
        
          }
          
          static class exitApp implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }
          
          
          public class BasicPlayerTest implements BasicPlayerListener
{
  private PrintStream out = null;

  /**
   * Entry point.
   * @param args filename to play.
   */
  

    /**
     * Contructor.
     */
  public BasicPlayerTest()
     {
      player.addBasicPlayerListener(this);
      out = System.out;
     }

  public void play(String filename)
     {
       // Instantiate BasicPlayer.
      BasicPlayer player = new BasicPlayer();
      // BasicPlayer is a BasicController.
      BasicController control = (BasicController) player;
      // Register BasicPlayerTest to BasicPlayerListener events.
      // It means that this object will be notified on BasicPlayer
      // events such as : opened(...), progress(...), stateUpdated(...)
      player.addBasicPlayerListener(this);

  try
     { 
      // Open file, or URL or Stream (shoutcast, icecast) to play.
      control.open(new File(filename));

      // control.open(new URL("http://yourshoutcastserver.com:8000"));

      // Start playback in a thread.
      control.play();

      // If you want to pause/resume/pause the played file then
      // write a Swing player and just call control.pause(),
      // control.resume() or control.stop(). 
      // Use control.seek(bytesToSkip) to seek file
      // (i.e. fast forward and rewind). seek feature will
      // work only if underlying JavaSound SPI implements
      // skip(...). True for MP3SPI and SUN SPI's
      // (WAVE, AU, AIFF).

      // Set Volume (0 to 1.0).
      control.setGain(0.85);
      // Set Pan (-1.0 to 1.0).
      control.setPan(0.0);
    }
    catch (BasicPlayerException e)
    {
      e.printStackTrace();
    }
  }

  /**
   * Open callback, stream is ready to play.
   *
   * properties map includes audio format dependant features such as
   * bitrate, duration, frequency, channels, number of frames, vbr flag, ... 
   *
   * @param stream could be File, URL or InputStream
   * @param properties audio stream properties.
   */
  public void opened(Object stream, Map properties)
  {
    // Pay attention to properties. It's useful to get duration, 
    // bitrate, channels, even tag such as ID3v2.
      spl = stream.toString();
      
   
    
  }

  /**
   * Progress callback while playing.
   * 
   * This method is called severals time per seconds while playing.
   * properties map includes audio format features such as
   * instant bitrate, microseconds position, current frame number, ... 
   * 
   * @param bytesread from encoded stream.
   * @param microseconds elapsed (<b>reseted after a seek !</b>).
   * @param pcmdata PCM samples.
   * @param properties audio stream parameters.
  */
  public void progress(int bytesread, long microseconds, byte[] pcmdata, Map properties)
  {
    // Pay attention to properties. It depends on underlying JavaSound SPI
    // MP3SPI provides mp3.equalizer.
    //display("progress : "+properties.toString());
      //long value = bytesread / (byteDuration / 1000);
      
               
                
                
                    
                    
                    if(properties.get("mp3.position.microseconds") != null)
                {
                    
                    Object sMicroSeconds = properties.get("mp3.position.microseconds");
                    long microsec = Long.valueOf(sMicroSeconds.toString());
                    long lenSec = Math.round(microsec / 1000000);
                    
                    Date d = new Date(lenSec * 1000L);
                    SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss"); // HH for 0-23
                    df.setTimeZone(TimeZone.getTimeZone("GMT"));
                    String time = df.format(d);
                    
                    timer1.setText(time);
                    //jbar.setMin(0);
                    
                            
                    jbar.setValue((int)lenSec);
                    
                    //System.out.println(properties.toString());
                    
                   // System.out.println(properties.toString());
                    jbar.setMinimum(0);
                    jbar.setMaximum((int)lmp3);
                    long remsec = Math.round(lmp3-lenSec);
                    Date d2 = new Date(remsec * 1000L);
                    SimpleDateFormat df2 = new SimpleDateFormat("HH:mm:ss"); // HH for 0-23
                    df2.setTimeZone(TimeZone.getTimeZone("GMT"));
                    String time2 = df2.format(d2);
                    
                    
                    
                    timer12.setText(time2);
                    
                }
                   
                
  }

  /**
   * Notification callback for basicplayer events such as opened, eom ...
   * 
   * @param event
   */
  public void stateUpdated(BasicPlayerEvent event)
  {
    // Notification of BasicPlayer states (opened, playing, end of media, ...)
    display("stateUpdated : "+event.toString());
    
    if(event.toString().equals("STOPPED:-1")){
        jbar.setValue(0);
        timer1.setText("00:00:00");
        timer12.setText("00:00:00");
        
    }
    
  }

  /**
   * A handle to the BasicPlayer, plugins may control the player through
   * the controller (play, stop, ...)
   * @param controller : a handle to the player
   */ 
  public void setController(BasicController controller)
  {
    display("setController : "+controller);
  }

  public void display(String msg)
  {
    if (out != null) out.println(msg);
  }
}
          

    class ButtonListener implements ActionListener {

        public ButtonListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e)  {
            try {
                //url = jTable.getModel().getValueAt(CurrentSelectedRow, 6).toString();
                int value = slider.getValue();
                System.out.println(value + "value");
                aud = (float)value/100;
                player.setGain(aud);
            } catch (BasicPlayerException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            if("Play".equals(e.getActionCommand())){
                
                pause.setText("Pause");
                 System.out.println(CurrentSelectedRow);
                
                System.out.println(CurrentSelectedRow);
                System.out.println("Playing");
                try {
                    CurrentSelectedRow =jTable.getSelectedRow();
                    url = jTable.getModel().getValueAt(CurrentSelectedRow, 6).toString();
                    System.out.println(CurrentSelectedRow);
                    a = new File(url).toURI().toURL();
                    
                } catch (MalformedURLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
 
             try {
                svst = CurrentSelectedRow; 
                player.open(a);
                player.play();
                
                
                
                
                
                System.out.println(player.getListeners());
                
                String sa = "Now Playing : " + jTable.getModel().getValueAt(CurrentSelectedRow, 0).toString();
                jLabel.setText(sa);
                
                Mp3File mp3file = new Mp3File(url);
                if (mp3file.hasId3v2Tag()) {
                       ID3v2 id3v2Tag = mp3file.getId3v2Tag();
                       byte[] img = id3v2Tag.getAlbumImage();
                       if (img == null) {
                              ImageIcon icon = new ImageIcon("C:\\Users\\karth\\Documents\\NetBeansProjects\\ProjectMp30\\img\\empty.png"); 
                                jLabel3.setSize(100,100);
                                jLabel3.setIcon(icon);
                        }
                       else{
                       BufferedImage image = ImageIO.read(new ByteArrayInputStream(img)); 
                       jLabel3.setSize(100,100);
                       Image dimg = image.getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(),Image.SCALE_SMOOTH);
                       ImageIcon icon = new ImageIcon(dimg);
                       jLabel3.setIcon(icon);
                       lmp3 = mp3file.getLengthInSeconds();
                       System.out.println("Length of this mp3 is: " + mp3file.getLengthInSeconds() + " seconds");
                       }
                       
                       if(!shuf){
                 Connection con=null;
                            PreparedStatement ps=null;
                            con=DatabaseConnect.getConnection();
                            try {
                                
                                ps=con.prepareStatement ("insert into recent (name,path) values (?,?)");
                                ps.setString(1,jTable.getModel().getValueAt(CurrentSelectedRow, 0).toString());
                                ps.setString(2,url);
                                ps.executeUpdate();
                                
                                recent.add(jTable.getModel().getValueAt(CurrentSelectedRow, 0).toString());
                                
                            } catch (SQLException ex) {
                                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                           
                //createRecent();
                }
                        
                
                
            }
                
            }   catch (javazoom.jlgui.basicplayer.BasicPlayerException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedTagException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidDataException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if("Pause".equals(e.getActionCommand())){
                pause.setText("Resume");
                System.out.println("Paused");
                /*try {
                    //url = jTable.getModel().getValueAt(CurrentSelectedRow, 4).toString();
                    a = new File(url).toURI().toURL();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }*/
                try {
                //player.open(a);
                player.pause();
            }   catch (javazoom.jlgui.basicplayer.BasicPlayerException ex) {   
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }   
            }
            if("Resume".equals(e.getActionCommand())){
                pause.setText("Pause");
                System.out.println("Resumed");
                /*try {
                   // url = jTable.getModel().getValueAt(CurrentSelectedRow, 4).toString();
                    a = new File(url).toURI().toURL();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }*/

                try {
                    player.resume();
                    Mp3File mp3file = new Mp3File(url);
                ID3v2 id3v2Tag = mp3file.getId3v2Tag();
                String sa = "Now Playing : " + id3v2Tag.getTitle();
                    
                    jLabel.setText(sa);
                } catch (javazoom.jlgui.basicplayer.BasicPlayerException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedTagException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidDataException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Resumed");
            }
            
             if("Stop".equals(e.getActionCommand())){
                 pause.setText("Pause");
                 jbar.setValue(0);
                 //url = jTable.getModel().getValueAt(CurrentSelectedRow, 4).toString();
                System.out.println(CurrentSelectedRow);
                /* try {
                    a = new File(url).toURI().toURL();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }*/
                try {
               // player.open(a);
                player.stop();
                jLabel.setText("No Song Playing");
                timer1.setText("00:00:00");
                ImageIcon icon = new ImageIcon("C:\\Users\\karth\\Documents\\NetBeansProjects\\ProjectMp30\\img\\empty.png"); 
                jLabel3.setSize(100,100);
                jLabel3.setIcon(icon);
                    jLabel.setHorizontalAlignment(JLabel.CENTER);
                System.out.println(CurrentSelectedRow);
                System.out.println("Stopped");
                
            }   catch (javazoom.jlgui.basicplayer.BasicPlayerException ex) {   
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }   
                //System.out.println("Malformed url");
                   
            }
             
             if("Next".equals(e.getActionCommand())){
                 pause.setText("Pause");
                System.out.println("Next");
                
                if(shuf){
                    if(rep){
                        CurrentSelectedRow = CurrentSelectedRow;
                if(CurrentSelectedRow==jTable.getRowCount()){
                    CurrentSelectedRow = 0;
                    
                }
                
                jTable.changeSelection(CurrentSelectedRow,0,false,false);
                url = jTable.getModel().getValueAt(CurrentSelectedRow, 6).toString();
                System.out.println(CurrentSelectedRow);
                try {
                    a = new File(url).toURI().toURL();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                try {
                player.open(a);
                player.play();
                String sa = "Now Playing : " + jTable.getModel().getValueAt(CurrentSelectedRow, 0).toString();
                    jLabel.setText(sa);
                    
                    Mp3File mp3file = new Mp3File(url);
                if (mp3file.hasId3v2Tag()) {
                       ID3v2 id3v2Tag = mp3file.getId3v2Tag();
                       byte[] img = id3v2Tag.getAlbumImage();
                       if (img == null) {
                              ImageIcon icon = new ImageIcon("C:\\Users\\karth\\Documents\\NetBeansProjects\\ProjectMp30\\img\\empty.png"); 
                                jLabel3.setSize(100,100);
                                jLabel3.setIcon(icon);
                        }
                       else{
                       BufferedImage image = ImageIO.read(new ByteArrayInputStream(img)); 
                       jLabel3.setSize(100,100);
                       Image dimg = image.getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(),Image.SCALE_SMOOTH);
                       ImageIcon icon = new ImageIcon(dimg);
                       jLabel3.setIcon(icon);
                       
                       }
                       lmp3 = mp3file.getLengthInSeconds();
                        
                
                
            }
                System.out.println("Next playing");
            }   catch (javazoom.jlgui.basicplayer.BasicPlayerException ex) {   
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedTagException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidDataException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } 
                
                
                    }
                    
                    else 
                    {
                        Random random = new Random();
                      int randomInteger = random.nextInt(jTable.getRowCount()-1); 
                      CurrentSelectedRow = randomInteger;
                if(CurrentSelectedRow==jTable.getRowCount()){
                    CurrentSelectedRow = 0;
                    
                }
                
                jTable.changeSelection(CurrentSelectedRow,0,false,false);
                url = jTable.getModel().getValueAt(CurrentSelectedRow, 6).toString();
                System.out.println(CurrentSelectedRow);
                try {
                    a = new File(url).toURI().toURL();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                try {
                player.open(a);
                player.play();
                String sa = "Now Playing : " + jTable.getModel().getValueAt(CurrentSelectedRow, 0).toString();
                    jLabel.setText(sa);
                    
                    Mp3File mp3file = new Mp3File(url);
                if (mp3file.hasId3v2Tag()) {
                       ID3v2 id3v2Tag = mp3file.getId3v2Tag();
                       byte[] img = id3v2Tag.getAlbumImage();
                       if (img == null) {
                              ImageIcon icon = new ImageIcon("C:\\Users\\karth\\Documents\\NetBeansProjects\\ProjectMp30\\img\\empty.png"); 
                                jLabel3.setSize(100,100);
                                jLabel3.setIcon(icon);
                        }
                       else{
                       BufferedImage image = ImageIO.read(new ByteArrayInputStream(img)); 
                       jLabel3.setSize(100,100);
                       Image dimg = image.getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(),Image.SCALE_SMOOTH);
                       ImageIcon icon = new ImageIcon(dimg);
                       jLabel3.setIcon(icon);
                       }
                       lmp3 = mp3file.getLengthInSeconds();
                        
                
                
            }
                System.out.println("Next playing");
            }   catch (javazoom.jlgui.basicplayer.BasicPlayerException ex) {   
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedTagException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidDataException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } 
                    }
                }
                else if(rep){
                    CurrentSelectedRow = CurrentSelectedRow;
                if(CurrentSelectedRow==jTable.getRowCount()){
                    CurrentSelectedRow = 0;
                    
                }
                
                jTable.changeSelection(CurrentSelectedRow,0,false,false);
                url = jTable.getModel().getValueAt(CurrentSelectedRow, 6).toString();
                System.out.println(CurrentSelectedRow);
                try {
                    a = new File(url).toURI().toURL();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                try {
                player.open(a);
                player.play();
                String sa = "Now Playing : " + jTable.getModel().getValueAt(CurrentSelectedRow, 0).toString();
                    jLabel.setText(sa);
                    
                    Mp3File mp3file = new Mp3File(url);
                if (mp3file.hasId3v2Tag()) {
                       ID3v2 id3v2Tag = mp3file.getId3v2Tag();
                       byte[] img = id3v2Tag.getAlbumImage();
                       if (img == null) {
                              ImageIcon icon = new ImageIcon("C:\\Users\\karth\\Documents\\NetBeansProjects\\ProjectMp30\\img\\empty.png"); 
                                jLabel3.setSize(100,100);
                                jLabel3.setIcon(icon);
                        }
                       else{
                       BufferedImage image = ImageIO.read(new ByteArrayInputStream(img)); 
                       jLabel3.setSize(100,100);
                       Image dimg = image.getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(),Image.SCALE_SMOOTH);
                       ImageIcon icon = new ImageIcon(dimg);
                       jLabel3.setIcon(icon);
                       }
                       lmp3 = mp3file.getLengthInSeconds();
                        
                
                
            }
                System.out.println("Next playing");
            }   catch (javazoom.jlgui.basicplayer.BasicPlayerException ex) {   
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedTagException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidDataException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } 
                }
                
                else{
                   CurrentSelectedRow = CurrentSelectedRow+1;
                if(CurrentSelectedRow==jTable.getRowCount()){
                    CurrentSelectedRow = 0;
                    
                }
                
                jTable.changeSelection(CurrentSelectedRow,0,false,false);
                url = jTable.getModel().getValueAt(CurrentSelectedRow, 6).toString();
                System.out.println(CurrentSelectedRow);
                try {
                    a = new File(url).toURI().toURL();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                try {
                player.open(a);
                player.play();
                String sa = "Now Playing : " + jTable.getModel().getValueAt(CurrentSelectedRow, 0).toString();
                    jLabel.setText(sa);
                    
                    Mp3File mp3file = new Mp3File(url);
                if (mp3file.hasId3v2Tag()) {
                       ID3v2 id3v2Tag = mp3file.getId3v2Tag();
                       byte[] img = id3v2Tag.getAlbumImage();
                       if (img == null) {
                              ImageIcon icon = new ImageIcon("C:\\Users\\karth\\Documents\\NetBeansProjects\\ProjectMp30\\img\\empty.png"); 
                                jLabel3.setSize(100,100);
                                jLabel3.setIcon(icon);
                        }
                       else{
                       BufferedImage image = ImageIO.read(new ByteArrayInputStream(img)); 
                       jLabel3.setSize(100,100);
                       Image dimg = image.getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(),Image.SCALE_SMOOTH);
                       ImageIcon icon = new ImageIcon(dimg);
                       jLabel3.setIcon(icon);
                       }
                       lmp3 = mp3file.getLengthInSeconds();
                        if(!shuf){
                 Connection con=null;
                            PreparedStatement ps=null;
                            con=DatabaseConnect.getConnection();
                            try {
                                
                                ps=con.prepareStatement ("insert into recent (name,path) values (?,?)");
                                ps.setString(1,jTable.getModel().getValueAt(CurrentSelectedRow, 0).toString());
                                ps.setString(2,url);
                                ps.executeUpdate();
                                
                                recent.add(jTable.getModel().getValueAt(CurrentSelectedRow, 0).toString());
                                
                            } catch (SQLException ex) {
                                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                           
                //createRecent();
                }
                
                
            }
                System.out.println("Next playing");
            }   catch (javazoom.jlgui.basicplayer.BasicPlayerException ex) {   
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedTagException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidDataException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }  
                }
                  
            }
             
             if("Previous".equals(e.getActionCommand())){
                 pause.setText("Pause");
                System.out.println("Previous entered");
                
                if(shuf){
                    if(rep){
                        CurrentSelectedRow = CurrentSelectedRow;
                if(CurrentSelectedRow== -1){
                    CurrentSelectedRow = jTable.getRowCount() - 1;
                    
                }
                jTable.changeSelection(CurrentSelectedRow,0,false,false);
                url = jTable.getModel().getValueAt(CurrentSelectedRow, 6).toString();
                System.out.println(CurrentSelectedRow);
                try {
                    a = new File(url).toURI().toURL();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                try {
                    player.open(a);
                    String sa = "Now Playing : " + jTable.getModel().getValueAt(CurrentSelectedRow, 0).toString();
                    jLabel.setText(sa);
                    Mp3File mp3file = new Mp3File(url);
                if (mp3file.hasId3v2Tag()) {
                       ID3v2 id3v2Tag = mp3file.getId3v2Tag();
                       byte[] img = id3v2Tag.getAlbumImage();
                       if (img == null) {
                             ImageIcon icon = new ImageIcon("C:\\Users\\karth\\Documents\\NetBeansProjects\\ProjectMp30\\img\\empty.png"); 
                                jLabel3.setSize(100,100);
                                jLabel3.setIcon(icon);
                        }
                       else{
                       BufferedImage image = ImageIO.read(new ByteArrayInputStream(img)); 
                       jLabel3.setSize(100,100);
                       Image dimg = image.getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(),Image.SCALE_SMOOTH);
                       ImageIcon icon = new ImageIcon(dimg);
                       jLabel3.setIcon(icon);
                       }
                        lmp3 = mp3file.getLengthInSeconds();
                
                
            }
                } catch (javazoom.jlgui.basicplayer.BasicPlayerException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedTagException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidDataException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    player.play();
                } catch (javazoom.jlgui.basicplayer.BasicPlayerException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Previous playing");
                    }
                    
                    else
                    {   
                      Random random = new Random();
                      int randomInteger = random.nextInt(jTable.getRowCount()-1); 
                      CurrentSelectedRow = randomInteger;
                if(CurrentSelectedRow== -1){
                    CurrentSelectedRow = jTable.getRowCount() - 1;
                    
                }
                jTable.changeSelection(CurrentSelectedRow,0,false,false);
                url = jTable.getModel().getValueAt(CurrentSelectedRow, 6).toString();
                System.out.println(CurrentSelectedRow);
                try {
                    a = new File(url).toURI().toURL();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                try {
                    player.open(a);
                    String sa = "Now Playing : " + jTable.getModel().getValueAt(CurrentSelectedRow, 0).toString();
                    jLabel.setText(sa);
                    Mp3File mp3file = new Mp3File(url);
                if (mp3file.hasId3v2Tag()) {
                       ID3v2 id3v2Tag = mp3file.getId3v2Tag();
                       byte[] img = id3v2Tag.getAlbumImage();
                       if (img == null) {
                             ImageIcon icon = new ImageIcon("C:\\Users\\karth\\Documents\\NetBeansProjects\\ProjectMp30\\img\\empty.png"); 
                                jLabel3.setSize(100,100);
                                jLabel3.setIcon(icon);
                        }
                       else{
                       BufferedImage image = ImageIO.read(new ByteArrayInputStream(img)); 
                       jLabel3.setSize(100,100);
                       Image dimg = image.getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(),Image.SCALE_SMOOTH);
                       ImageIcon icon = new ImageIcon(dimg);
                       jLabel3.setIcon(icon);
                       }
                        lmp3 = mp3file.getLengthInSeconds();
                
                
            }
                } catch (javazoom.jlgui.basicplayer.BasicPlayerException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedTagException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidDataException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    player.play();
                } catch (javazoom.jlgui.basicplayer.BasicPlayerException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Previous playing");
                    }
                    
                }
                
                else if(rep){
                    CurrentSelectedRow = CurrentSelectedRow;
                if(CurrentSelectedRow== -1){
                    CurrentSelectedRow = jTable.getRowCount() - 1;
                    
                }
                jTable.changeSelection(CurrentSelectedRow,0,false,false);
                url = jTable.getModel().getValueAt(CurrentSelectedRow, 6).toString();
                System.out.println(CurrentSelectedRow);
                try {
                    a = new File(url).toURI().toURL();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                try {
                    player.open(a);
                    String sa = "Now Playing : " + jTable.getModel().getValueAt(CurrentSelectedRow, 0).toString();
                    jLabel.setText(sa);
                    Mp3File mp3file = new Mp3File(url);
                if (mp3file.hasId3v2Tag()) {
                       ID3v2 id3v2Tag = mp3file.getId3v2Tag();
                       byte[] img = id3v2Tag.getAlbumImage();
                       if (img == null) {
                             ImageIcon icon = new ImageIcon("C:\\Users\\karth\\Documents\\NetBeansProjects\\ProjectMp30\\img\\empty.png"); 
                                jLabel3.setSize(100,100);
                                jLabel3.setIcon(icon);
                        }
                       else{
                       BufferedImage image = ImageIO.read(new ByteArrayInputStream(img)); 
                       jLabel3.setSize(100,100);
                       Image dimg = image.getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(),Image.SCALE_SMOOTH);
                       ImageIcon icon = new ImageIcon(dimg);
                       jLabel3.setIcon(icon);
                       }
                        lmp3 = mp3file.getLengthInSeconds();
                
                
            }
                } catch (javazoom.jlgui.basicplayer.BasicPlayerException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedTagException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidDataException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    player.play();
                } catch (javazoom.jlgui.basicplayer.BasicPlayerException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Previous playing");
                }
                
                else
                {
                   CurrentSelectedRow = CurrentSelectedRow-1;
                if(CurrentSelectedRow== -1){
                    CurrentSelectedRow = jTable.getRowCount() - 1;
                    
                }
                jTable.changeSelection(CurrentSelectedRow,0,false,false);
                url = jTable.getModel().getValueAt(CurrentSelectedRow, 6).toString();
                System.out.println(CurrentSelectedRow);
                try {
                    a = new File(url).toURI().toURL();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                try {
                    player.open(a);
                    String sa = "Now Playing : " + jTable.getModel().getValueAt(CurrentSelectedRow, 0).toString();
                    jLabel.setText(sa);
                    Mp3File mp3file = new Mp3File(url);
                if (mp3file.hasId3v2Tag()) {
                       ID3v2 id3v2Tag = mp3file.getId3v2Tag();
                       byte[] img = id3v2Tag.getAlbumImage();
                       if (img == null) {
                             ImageIcon icon = new ImageIcon("C:\\Users\\karth\\Documents\\NetBeansProjects\\ProjectMp30\\img\\empty.png"); 
                                jLabel3.setSize(100,100);
                                jLabel3.setIcon(icon);
                        }
                       else{
                       BufferedImage image = ImageIO.read(new ByteArrayInputStream(img)); 
                       jLabel3.setSize(100,100);
                       Image dimg = image.getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(),Image.SCALE_SMOOTH);
                       ImageIcon icon = new ImageIcon(dimg);
                       jLabel3.setIcon(icon);
                       }
                        lmp3 = mp3file.getLengthInSeconds();
                if(!shuf){
                 Connection con=null;
                            PreparedStatement ps=null;
                            con=DatabaseConnect.getConnection();
                            try {
                                
                                ps=con.prepareStatement ("insert into recent (name,path) values (?,?)");
                                ps.setString(1,jTable.getModel().getValueAt(CurrentSelectedRow, 0).toString());
                                ps.setString(2,url);
                                ps.executeUpdate();
                                
                                recent.add(jTable.getModel().getValueAt(CurrentSelectedRow, 0).toString());
                                
                            } catch (SQLException ex) {
                                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                           
                //createRecent();
                }
                
            }
                } catch (javazoom.jlgui.basicplayer.BasicPlayerException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedTagException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidDataException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    player.play();
                } catch (javazoom.jlgui.basicplayer.BasicPlayerException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Previous playing"); 
                }
                
            }
             

//create if, output and url assignment statements for the other two channels
            
        
        }
        
        

    }
    
    public class MyChangeAction implements ChangeListener{
     public void stateChanged(ChangeEvent ce){
         int value = slider.getValue();
         aud = (float)value/100;
         try {
             player.setGain(aud);
         } catch (BasicPlayerException ex) {
             Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
         }
        
     }

        
   }
    
    public static void setNodeExpandedState(JTree tree, DefaultMutableTreeNode node, boolean expanded) {
      ArrayList<DefaultMutableTreeNode> list = Collections.list(node.children());
      for (DefaultMutableTreeNode treeNode : list) {
          setNodeExpandedState(tree, treeNode, expanded);
      }
      if (!expanded && node.isRoot()) {
          return;
      }
      TreePath path = new TreePath(node.getPath());
      if (expanded) {
          tree.expandPath(path);
      } else {
          tree.collapsePath(path);
      }
      
     
      
  }
    
    private TreePath find(JTree tree, String s) {
    @SuppressWarnings("unchecked")
            
            DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
           DefaultMutableTreeNode root = (DefaultMutableTreeNode)model.getRoot();
    Enumeration<DefaultMutableTreeNode> e = root.depthFirstEnumeration();
    while (e.hasMoreElements()) {
        DefaultMutableTreeNode node = e.nextElement();
        if (node.toString().equalsIgnoreCase(s)) {
            return new TreePath(node.getPath());
        }
    }
    return null;
}
    
    public JTable getTable(){
        
        return jTable;
    }
  
    public String getPlist(){
        return plist;
    }
    
    public JFrame reload1(){
        return jFrame;
    }
    
    public void reload(){
        
    }
    
    public class Key implements ActionListener, MenuListener, KeyListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void menuSelected(MenuEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void menuDeselected(MenuEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void menuCanceled(MenuEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyTyped(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyPressed(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyReleased(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
    
    public class GUI3 {
    boolean c;
    JFrame jFrame;
    JPanel jPanel1;
    JPanel jPanel2;
    JPanel jPanel3;
    JMenu jMenu;
    JButton play;
    JButton pause;
    JButton resume;
    JButton stop;
    JButton next;
    JButton previous;
    
    JMenuBar jmb;
    JMenuItem add;
    JMenuItem add1;
    JMenuItem open;
    JMenuItem delete;
    JMenuItem delete1;
    JMenuItem exit;   
    JPopupMenu jPopup;
    JPopupMenu jPopup2;
    JPopupMenu jPopup3;
    JLabel jLabel;
    JLabel jLabel3;
    JFileChooser chooser;
    ButtonListener b1;
    ButtonListener b2;
    ButtonListener b3;
    ButtonListener b4;
    ButtonListener b5;
    ButtonListener b6;
    BasicPlayer player;
    int CurrentSelectedRow;
    String url;
    JScrollPane scrollPane; 
    URL a;
    KeyListener m1;
    KeyListener m2;
    String path123;
    Boolean del = true;
    
    int csr;
    Container contentPane;
    JSlider slider;
    JTable jTable27;
    GUI gui;
            
    public GUI3(String abc, int m, JTable jt7) throws IOException {
        try {
            gui = new GUI();
        } catch (SQLException ex) {
            Logger.getLogger(GUI3.class.getName()).log(Level.SEVERE, null, ex);
        }
        playli = abc;
        player = new BasicPlayer() ;
        jFrame = new JFrame(playli);
        //jFrame.setLayout(new FlowLayout());
        
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jMenu = new JMenu("Options");
        
        m1 = new Key();
        m2 = new Key();
        csr = m;
        
        
       /* add.addActionListener((ActionListener) m1);
        delete.addActionListener((ActionListener) m2);*/
        
        
        b1 = new ButtonListener();
        b2 = new ButtonListener();
        b3 = new ButtonListener();
        b4 = new ButtonListener();
        b5 = new ButtonListener();
        b6 = new ButtonListener();
        
        chooser = new JFileChooser("C:\\Users\\karth\\Music");
        
        
        play = new JButton("Play");
        pause = new JButton("Pause");
        resume = new JButton("Resume");
        stop = new JButton("Stop");
        previous = new JButton("Previous");
        next = new JButton("Next");
        
        jTable2.setDefaultEditor(Object.class, null);
        jmb = new JMenuBar();
        //pause.setEnabled(false);
        
        c = false;
        
        jmb.add(jMenu);
        jMenu.setMnemonic(KeyEvent.VK_A);
        jMenu.getAccessibleContext().setAccessibleDescription("Add,Remove");
        
        add = new JMenuItem("Add Song",KeyEvent.VK_T); 
        add.addActionListener(new Options());
        add.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
        jMenu.add(add);
        
        
        open = new JMenuItem("Open Song",KeyEvent.VK_T); 
        open.addActionListener(new Options());
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
        jMenu.add(open);
        
        delete = new JMenuItem("Delete Song",KeyEvent.VK_T); 
        delete.addActionListener(new Options());
        delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
        
        add1 = new JMenuItem("Add Song",KeyEvent.VK_T); 
        add1.addActionListener(new Options());
        add1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
        
        exit = new JMenuItem("Exit");
        exit.addActionListener(new exitApp());
        
        delete1 = new JMenuItem("Delete a Song",KeyEvent.VK_T); 
        delete1.addActionListener(new Options());
        delete1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
        
        jMenu.add(delete1);
        jMenu.add(exit);
        
        
        jPopup = new JPopupMenu();
        jPopup3 = new JPopupMenu();
        
        
        //jPopup.add(add);
        jPopup.add(delete);    
        jPopup.add(add1);
        //jTable2.setComponentPopupMenu(jPopup);
        
        String text = "Hello";
       
        
        jLabel = new JLabel();
        jLabel3 = new JLabel();
        //File img = new File("C:\\Users\\karth\\Documents\\NetBeansProjects\\ProjectMp30\\img\\empty.png");
        
        ImageIcon icon = new ImageIcon("C:\\Users\\karth\\Documents\\NetBeansProjects\\ProjectMp30\\img\\empty.png"); 
        jLabel3.setSize(100,100);
        jLabel3.setIcon(icon);
        


        
        
        

        
        play.addActionListener((ActionListener) b1);
        pause.addActionListener((ActionListener) b2);
        stop.addActionListener((ActionListener) b3);
        next.addActionListener((ActionListener) b4);
        previous.addActionListener((ActionListener) b5);
        resume.addActionListener((ActionListener) b6);
        

        MouseListener mouseListener = new MouseAdapter() {
            
            
       
            public void mousePressed(MouseEvent e)
            {
                CurrentSelectedRow =jTable2.getSelectedRow();
                        url = jTable2.getModel().getValueAt(CurrentSelectedRow, 6).toString();
                        System.out.println(url);
                        System.out.println("Selected index = " + CurrentSelectedRow); 
            }
            
          public void mouseReleased(MouseEvent me)
            {
                
                
         
                
                /*if(SwingUtilities.isLeftMouseButton(me) == true)
                    {
                        CurrentSelectedRow =jTable2.getSelectedRow();
                        url = jTable2.getModel().getValueAt(CurrentSelectedRow, 6).toString();
                        System.out.println(url);
                        System.out.println("Selected index = " + CurrentSelectedRow); 
                    }
                
                if(SwingUtilities.isRightMouseButton(me) == true)
                    {
                        /*CurrentSelectedRow = jTable2.getSelectedRow();
                        url = jTable2.getModel().getValueAt(CurrentSelectedRow, 6).toString();
                        System.out.println(url);
                        System.out.println("Selected index = " + CurrentSelectedRow); 
                        //jTable2.setComponentPopupMenu(jPopup);*/
                        
                
               
                    Point point = me.getPoint();
        int row1 = jTable2.rowAtPoint(point);
        if (me.getClickCount() == 2 && jTable2.getSelectedRow() != -1) {
            // your valueChanged overridden method 
             pause.setText("Pause");
                 System.out.println(CurrentSelectedRow);
                
                System.out.println(CurrentSelectedRow);
                System.out.println("Playing");
                try {
                    url = jTable2.getModel().getValueAt(CurrentSelectedRow, 6).toString();
                    System.out.println(CurrentSelectedRow);
                    a = new File(url).toURI().toURL();
                    
                } catch (MalformedURLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
 
             try {
                player.open(a);
                player.play();
                
                String sa = "Now Playing : " + jTable2.getModel().getValueAt(CurrentSelectedRow, 0).toString();
                jLabel.setText(sa);
                
                Mp3File mp3file = new Mp3File(url);
                if (mp3file.hasId3v2Tag()) {
                       ID3v2 id3v2Tag = mp3file.getId3v2Tag();
                       byte[] img = id3v2Tag.getAlbumImage();
                       if (img == null) {
                              ImageIcon icon = new ImageIcon("C:\\Users\\karth\\Documents\\NetBeansProjects\\ProjectMp30\\img\\empty.png"); 
                                jLabel3.setSize(100,100);
                                jLabel3.setIcon(icon);
                        }
                       else{
                       BufferedImage image = ImageIO.read(new ByteArrayInputStream(img)); 
                       jLabel3.setSize(100,100);
                       Image dimg = image.getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(),Image.SCALE_SMOOTH);
                       ImageIcon icon = new ImageIcon(dimg);
                       jLabel3.setIcon(icon);
                       }
                        
                
                
            }
                
            }   catch (javazoom.jlgui.basicplayer.BasicPlayerException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedTagException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidDataException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
                    if (me.isPopupTrigger())
                {
                    CurrentSelectedRow =jTable2.getSelectedRow();
                        url = jTable2.getModel().getValueAt(CurrentSelectedRow, 6).toString();
                        System.out.println(url);
                        System.out.println("Selected index = " + CurrentSelectedRow); 
                    JTable source = (JTable)me.getSource();
                    int row = source.rowAtPoint( me.getPoint() );
                    int column = source.columnAtPoint( me.getPoint() );

                    if (! source.isRowSelected(row))
                        source.changeSelection(row, column, false, false);

                    jPopup.show(me.getComponent(), me.getX(), me.getY());
                }
                
                        
                    }
            //}
         
        };
        
        scrollPane = new JScrollPane(jTable2);
        
        //assign the listener
        jTable2.addMouseListener(mouseListener);
        


        slider = new JSlider();
         slider.setMinimum(0);
         slider.setMaximum(100);
            slider.setValue(85);
            slider.addChangeListener(new GUI3.MyChangeAction());

        

        
        
        

        
        
        //jPanel1.add(jTable2);
        jLabel.setSize(700,30);
        jLabel.setText("No Song Playing");
        jLabel.setHorizontalAlignment(JLabel.CENTER);
        jLabel3.setHorizontalAlignment(JLabel.CENTER);
        //jPanel2.add(jLabel);
        jPanel1.add(previous);
        jPanel1.add(play);
        jPanel1.add(pause);
        //jPanel1.add(resume);
        jPanel1.add(stop);
        jPanel1.add(next);
        jPanel1.add(slider);
        
        jLabel3.setSize(100,100);
        
        jTable2.setDragEnabled(true);
        jTable2.setDropMode(DropMode.INSERT_ROWS);
        
        
        //scrollPane.setLayout(null);
        //jPanel2.setLayout(null);
        //jFrame.add(jPanel2);
        //jFrame.add(scrollPane);
        
        jPanel2.setLayout(new BorderLayout());     
        jPanel2.add(jLabel, BorderLayout.NORTH);
        jPanel2.add(jLabel3, BorderLayout.CENTER);
        jPanel2.add(jPanel1, BorderLayout.SOUTH);
        
        contentPane=jFrame.getContentPane();   
        contentPane.setLayout(new BorderLayout());
        jFrame.setJMenuBar(jmb);
        contentPane.add(new JScrollPane(jTable2), BorderLayout.CENTER);
        //contentPane.add(jLabel, BorderLayout.CENTER);
        contentPane.add(jPanel2, BorderLayout.SOUTH);
        

       
        showAlbum2();
        
        //this.add(jPanel1);
       // this.add(jPanel2);
       //this.add(scrollPane);
       //this.setSize(700,500);
        
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
        }
        public JFrame go() throws IOException{
        
            jFrame.setSize(700,500);
            jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            CallDragMp3();
            return jFrame;
            
            
            //jFrame.dispose();
        
        
        
    }
        
        
        public void CallDragMp3() throws IOException{
        DragMp3 d = new DragMp3(jTable2, playli, jTable);
        new DropTarget(jFrame,d);
        


    }
        
        

          
         public ArrayList<DisplayAlbum> callDisplayAlbum()
    {
        ArrayList<DisplayAlbum> da = new ArrayList<>();
        
        Connection con= null;
        Statement st = null;
        
        try
          {
            con=DatabaseConnect.getConnection();
            
            String qr = "select `b`.`Title`, `b`.`Album`, `b`.`Artist`, `b`.`Year`, `b`.`Genre`, `b`.`Comment`, `b`.`Path` from spl a left outer join library b on b.Path = a.song where a.playist = \""+playli+"\"";
            st=con.createStatement();
            ResultSet rs = st.executeQuery(qr);
            
            DisplayAlbum dac;
            while(rs.next()){
                dac = new DisplayAlbum(rs.getString("Title"),rs.getString("Album"),rs.getString("Artist"),rs.getString("Year"),rs.getString("Genre"),rs.getString("Comment"),rs.getString("Path"));
                System.out.println(rs.getString("Title"));
                da.add(dac);
            }
            
     
           }
        catch(Exception e)
           {
            System.out.println(e.getMessage());
           }
        return da;
        
    }
         public void showAlbum(){
         System.out.println("Show Album");
         
                 
        jTable2.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new Object [] {
                "Title", "Album", "Artist", "Year", "Genre", "Comment", "Path"
            }
        ));
         
         
         ArrayList<DisplayAlbum> list = callDisplayAlbum();
         System.out.println(list);
         DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
         model.setRowCount(0);
         Object[] row = new Object[7];
         
         for(int i=0;i<list.size();i++){
             row[0] = list.get(i).getTitle();
             row[1] = list.get(i).getAlbum();
             row[2] = list.get(i).getArtist();
             row[3] = list.get(i).getYear();
             row[4] = list.get(i).getGenre();
             row[5] = list.get(i).getComment();
             row[6] = list.get(i).getPath();
             model.addRow(row);
             
         }

         
         jTable2.changeSelection(0,0,false,false);
     }
         
         public void showAlbum13(){
             
        jTable2.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new Object [] {
                "Title", "Album", "Artist", "Year", "Genre", "Comment", "Path"
            }
        ));
         
         
         ArrayList<DisplayAlbum> list = new ArrayList<>();
        
        Connection con= null;
        Statement st = null;
        
        try
          {
            con=DatabaseConnect.getConnection();
            System.out.println(playli);
            String qr = "select `b`.`Title`, `b`.`Album`, `b`.`Artist`, `b`.`Year`, `b`.`Genre`, `b`.`Comment`, `b`.`Path` from spl a left outer join library b on b.Path = a.song where a.playist = \""+playli+"\"";
            st=con.createStatement();
            ResultSet rs = st.executeQuery(qr);
            System.out.println("1");
            DisplayAlbum dac;
            while(rs.next()){
                dac = new DisplayAlbum(rs.getString("Title"),rs.getString("Album"),rs.getString("Artist"),rs.getString("Year"),rs.getString("Genre"),rs.getString("Comment"),rs.getString("Path"));
                System.out.println(rs.getString("Title"));
                list.add(dac);
                System.out.println(rs.getString("Title") + "List");
            }
            
            System.out.println("2");
           }
        catch(Exception e)
           {
            System.out.println(e.getMessage());
           }
        
         System.out.println(list.size() + "Size");
         DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
         model.setRowCount(0);
         Object[] row = new Object[7];
         
         for(int i=0;i<list.size();i++){
             System.out.println(i);
             row[0] = list.get(i).getTitle();
             row[1] = list.get(i).getAlbum();
             row[2] = list.get(i).getArtist();
             row[3] = list.get(i).getYear();
             row[4] = list.get(i).getGenre();
             row[5] = list.get(i).getComment();
             row[6] = list.get(i).getPath();
             model.addRow(row);
             
         }
         
         model.fireTableDataChanged();

         System.out.println("3");
         jTable2.changeSelection(0,0,false,false);
     }
         
         
         
         public void showAlbum2(){
             
        jTable2.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title", "Album", "Artist", "Year", "Genre", "Comment", "Path"
            }
        ));
         
         
         ArrayList<DisplayAlbum> list = new ArrayList<>();
        
        Connection con= null;
        Statement st = null;
        
        try
          {
            con=DatabaseConnect.getConnection();
            System.out.println(playli);
            String qr = "select `b`.`Title`, `b`.`Album`, `b`.`Artist`, `b`.`Year`, `b`.`Genre`, `b`.`Comment`, `b`.`Path` from spl a left outer join library b on b.Path = a.song where a.playist = \""+playli+"\"";
            st=con.createStatement();
            ResultSet rs = st.executeQuery(qr);
            System.out.println("1");
            DisplayAlbum dac;
            while(rs.next()){
                dac = new DisplayAlbum(rs.getString("Title"),rs.getString("Album"),rs.getString("Artist"),rs.getString("Year"),rs.getString("Genre"),rs.getString("Comment"),rs.getString("Path"));
                System.out.println(rs.getString("Title"));
                list.add(dac);
                System.out.println(rs.getString("Title") + "List");
            }
            
            System.out.println("2");
           }
        catch(Exception e)
           {
            System.out.println(e.getMessage());
           }
        
         System.out.println(list.size() + "Size");
         DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
         model.setRowCount(0);
         Object[] row = new Object[7];
         
         for(int i=0;i<list.size();i++){
             System.out.println(i);
             row[0] = list.get(i).getTitle();
             row[1] = list.get(i).getAlbum();
             row[2] = list.get(i).getArtist();
             row[3] = list.get(i).getYear();
             row[4] = list.get(i).getGenre();
             row[5] = list.get(i).getComment();
             row[6] = list.get(i).getPath();
             model.addRow(row);
             
         }
         
         model.fireTableDataChanged();

         System.out.println("3");
         jTable2.changeSelection(0,0,false,false);
         }
         
          class Options implements ActionListener{
              
              Actions ac = new Actions();
                public void actionPerformed(ActionEvent e) {
                   if("Add Song".equals(e.getActionCommand())){
                       ac.add(chooser,jTable2,playli);
                       showAlbum2();
                       plist = playli;
                       System.out.println(plist);
                       showAlbum22();
                   }
                   
                   if("Open Song".equals(e.getActionCommand())){
                       try {
                           ac.open(chooser, player, jLabel, jLabel3);                          
                       } catch (UnsupportedTagException ex) {
                           Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                       } catch (InvalidDataException ex) {
                           Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                       }
                    }
        
                   if("Delete Song".equals(e.getActionCommand())){
                        CurrentSelectedRow =jTable2.getSelectedRow();
                        
                        if(playli=="Library"){
                            ac.delete(jTable2,CurrentSelectedRow, playli);
                            showAlbum();
                        } 
                            else{
                            ac.delete1(jTable2,CurrentSelectedRow, playli);
                            showAlbum2();
                            showAlbum22();
            }
                        
       }
                   
                   
                   if("Delete a Song".equals(e.getActionCommand())){
                        CurrentSelectedRow =jTable2.getSelectedRow();
                        ac.delete(jTable2,CurrentSelectedRow,playli);
                        
                        
                        if(playli=="Library"){
                            ac.delete(jTable2,CurrentSelectedRow, playli);
                            showAlbum();
                        } 
                            else{
                            ac.delete1(jTable2,CurrentSelectedRow, playli);
                            showAlbum2();
            }
                   
       }
                }      
          }
          
          class exitApp implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }

    class ButtonListener implements ActionListener {

        public ButtonListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e)  {
            //url = jTable2.getModel().getValueAt(CurrentSelectedRow, 6).toString();
            
            if("Play".equals(e.getActionCommand())){
                
                pause.setText("Pause");
                 System.out.println(CurrentSelectedRow);
                
                System.out.println(CurrentSelectedRow);
                System.out.println("Playing");
                try {
                    CurrentSelectedRow =jTable2.getSelectedRow();
                    url = jTable2.getModel().getValueAt(CurrentSelectedRow, 6).toString();
                    System.out.println(CurrentSelectedRow);
                    a = new File(url).toURI().toURL();
                    
                } catch (MalformedURLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
 
             try {
                 playing = CurrentSelectedRow;
                player.open(a);
                player.play();
                
                String sa = "Now Playing : " + jTable2.getModel().getValueAt(CurrentSelectedRow, 0).toString();
                jLabel.setText(sa);
                
                Mp3File mp3file = new Mp3File(url);
                if (mp3file.hasId3v2Tag()) {
                       ID3v2 id3v2Tag = mp3file.getId3v2Tag();
                       byte[] img = id3v2Tag.getAlbumImage();
                       if (img == null) {
                              ImageIcon icon = new ImageIcon("C:\\Users\\karth\\Documents\\NetBeansProjects\\ProjectMp30\\img\\empty.png"); 
                                jLabel3.setSize(100,100);
                                jLabel3.setIcon(icon);
                        }
                       else{
                       BufferedImage image = ImageIO.read(new ByteArrayInputStream(img)); 
                       jLabel3.setSize(100,100);
                       Image dimg = image.getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(),Image.SCALE_SMOOTH);
                       ImageIcon icon = new ImageIcon(dimg);
                       jLabel3.setIcon(icon);
                       lmp3 = mp3file.getLengthInSeconds();
                       }
                        
                
                
            }
                
            }   catch (javazoom.jlgui.basicplayer.BasicPlayerException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedTagException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidDataException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if("Pause".equals(e.getActionCommand())){
                pause.setText("Resume");
                System.out.println("Paused");
                /*try {
                    //url = jTable2.getModel().getValueAt(CurrentSelectedRow, 4).toString();
                    a = new File(url).toURI().toURL();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }*/
                try {
                //player.open(a);
                player.pause();
            }   catch (javazoom.jlgui.basicplayer.BasicPlayerException ex) {   
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }   
            }
            if("Resume".equals(e.getActionCommand())){
                pause.setText("Pause");
                System.out.println("Resumed");
                /*try {
                   // url = jTable2.getModel().getValueAt(CurrentSelectedRow, 4).toString();
                    a = new File(url).toURI().toURL();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }*/

                try {
                    player.resume();
                    Mp3File mp3file = new Mp3File(url);
                ID3v2 id3v2Tag = mp3file.getId3v2Tag();
                String sa = "Now Playing : " + id3v2Tag.getTitle();
                    
                    jLabel.setText(sa);
                } catch (javazoom.jlgui.basicplayer.BasicPlayerException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedTagException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidDataException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Resumed");
            }
            
             if("Stop".equals(e.getActionCommand())){
                 pause.setText("Pause");
                 jbar.setValue(0);
                 //url = jTable2.getModel().getValueAt(CurrentSelectedRow, 4).toString();
                System.out.println(CurrentSelectedRow);
                /* try {
                    a = new File(url).toURI().toURL();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }*/
                try {
               // player.open(a);
                player.stop();
                jLabel.setText("No Song Playing");
                ImageIcon icon = new ImageIcon("C:\\Users\\karth\\Documents\\NetBeansProjects\\ProjectMp30\\img\\empty.png"); 
                jLabel3.setSize(100,100);
                jLabel3.setIcon(icon);
                    jLabel.setHorizontalAlignment(JLabel.CENTER);
                System.out.println(CurrentSelectedRow);
                System.out.println("Stopped");
                
            }   catch (javazoom.jlgui.basicplayer.BasicPlayerException ex) {   
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }   
                //System.out.println("Malformed url");
                   
            }
             
             if("Next".equals(e.getActionCommand())){
                 pause.setText("Pause");
                System.out.println("Next");
                CurrentSelectedRow = CurrentSelectedRow+1;
                if(CurrentSelectedRow==jTable2.getRowCount()){
                    CurrentSelectedRow = 0;
                    
                }
                
                jTable2.changeSelection(CurrentSelectedRow,0,false,false);
                url = jTable2.getModel().getValueAt(CurrentSelectedRow, 6).toString();
                System.out.println(CurrentSelectedRow);
                try {
                    a = new File(url).toURI().toURL();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                try {
                player.open(a);
                player.play();
                String sa = "Now Playing : " + jTable2.getModel().getValueAt(CurrentSelectedRow, 0).toString();
                    jLabel.setText(sa);
                    
                    Mp3File mp3file = new Mp3File(url);
                if (mp3file.hasId3v2Tag()) {
                       ID3v2 id3v2Tag = mp3file.getId3v2Tag();
                       byte[] img = id3v2Tag.getAlbumImage();
                       if (img == null) {
                              ImageIcon icon = new ImageIcon("C:\\Users\\karth\\Documents\\NetBeansProjects\\ProjectMp30\\img\\empty.png"); 
                                jLabel3.setSize(100,100);
                                jLabel3.setIcon(icon);
                        }
                       else{
                       BufferedImage image = ImageIO.read(new ByteArrayInputStream(img)); 
                       jLabel3.setSize(100,100);
                       Image dimg = image.getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(),Image.SCALE_SMOOTH);
                       ImageIcon icon = new ImageIcon(dimg);
                       jLabel3.setIcon(icon);
                       lmp3 = mp3file.getLengthInSeconds();
                       }
                        if(!shuf){
                 Connection con=null;
                            PreparedStatement ps=null;
                            con=DatabaseConnect.getConnection();
                            try {
                                
                                ps=con.prepareStatement ("insert into recent (name,path) values (?,?)");
                                ps.setString(1,jTable.getModel().getValueAt(CurrentSelectedRow, 0).toString());
                                ps.setString(2,url);
                                ps.executeUpdate();
                                
                                recent.add(jTable.getModel().getValueAt(CurrentSelectedRow, 0).toString());
                                
                            } catch (SQLException ex) {
                                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                           
                //createRecent();
                }
                
                
            }
                System.out.println("Next playing");
            }   catch (javazoom.jlgui.basicplayer.BasicPlayerException ex) {   
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedTagException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidDataException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }   
            }
             
             if("Previous".equals(e.getActionCommand())){
                 pause.setText("Pause");
                System.out.println("Previous entered");
                CurrentSelectedRow = CurrentSelectedRow-1;
                if(CurrentSelectedRow== -1){
                    CurrentSelectedRow = jTable2.getRowCount() - 1;
                    
                }
                jTable2.changeSelection(CurrentSelectedRow,0,false,false);
                url = jTable2.getModel().getValueAt(CurrentSelectedRow, 6).toString();
                System.out.println(CurrentSelectedRow);
                try {
                    a = new File(url).toURI().toURL();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                try {
                    player.open(a);
                    String sa = "Now Playing : " + jTable2.getModel().getValueAt(CurrentSelectedRow, 0).toString();
                    jLabel.setText(sa);
                    Mp3File mp3file = new Mp3File(url);
                if (mp3file.hasId3v2Tag()) {
                       ID3v2 id3v2Tag = mp3file.getId3v2Tag();
                       byte[] img = id3v2Tag.getAlbumImage();
                       if (img == null) {
                             ImageIcon icon = new ImageIcon("C:\\Users\\karth\\Documents\\NetBeansProjects\\ProjectMp30\\img\\empty.png"); 
                                jLabel3.setSize(100,100);
                                jLabel3.setIcon(icon);
                        }
                       else{
                       BufferedImage image = ImageIO.read(new ByteArrayInputStream(img)); 
                       jLabel3.setSize(100,100);
                       Image dimg = image.getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(),Image.SCALE_SMOOTH);
                       ImageIcon icon = new ImageIcon(dimg);
                       jLabel3.setIcon(icon);
                       }
                        lmp3 = mp3file.getLengthInSeconds();
                
                
            }
                } catch (javazoom.jlgui.basicplayer.BasicPlayerException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedTagException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidDataException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    player.play();
                } catch (javazoom.jlgui.basicplayer.BasicPlayerException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Previous playing");
            }
             

//create if, output and url assignment statements for the other two channels
            

        }

    }
    
    public JTable trigger(String abc, JTable jt){
        playli = abc;
        jTable = jt;
        System.out.println("Hi trigger");
        
        jTable.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new Object [] {
                "Title", "Album", "Artist", "Year", "Genre", "Comment", "Path"
            }
        ));
         
         
         ArrayList<DisplayAlbum> list = new ArrayList<>();
        
        Connection con= null;
        Statement st = null;
        
        try
          {
            con=DatabaseConnect.getConnection();
            
            String qr = "select `b`.`Title`, `b`.`Album`, `b`.`Artist`, `b`.`Year`, `b`.`Genre`, `b`.`Comment`, `b`.`Path` from spl a left outer join library b on b.Path = a.song where a.playist = \""+playli+"\"";
            st=con.createStatement();
            ResultSet rs = st.executeQuery(qr);
            System.out.println("1");
            DisplayAlbum dac;
            while(rs.next()){
                dac = new DisplayAlbum(rs.getString("Title"),rs.getString("Album"),rs.getString("Artist"),rs.getString("Year"),rs.getString("Genre"),rs.getString("Comment"),rs.getString("Path"));
                System.out.println(rs.getString("Title"));
                list.add(dac);
                System.out.println(rs.getString("Title") + "List");
            }
            
            System.out.println("2");
           }
        catch(Exception e)
           {
            System.out.println(e.getMessage());
           }
        
         System.out.println(list.size() + "Size");
         DefaultTableModel model = (DefaultTableModel)jTable.getModel();
         model.setRowCount(0);
         Object[] row = new Object[7];
         
         for(int i=0;i<list.size();i++){
             System.out.println(i);
             row[0] = list.get(i).getTitle();
             row[1] = list.get(i).getAlbum();
             row[2] = list.get(i).getArtist();
             row[3] = list.get(i).getYear();
             row[4] = list.get(i).getGenre();
             row[5] = list.get(i).getComment();
             row[6] = list.get(i).getPath();
             model.addRow(row);
             
         }
         
         model.fireTableDataChanged();

         System.out.println("3");
         jTable.changeSelection(0,0,false,false);
         return jTable;
    }
    
     public class MyChangeAction implements ChangeListener{
     public void stateChanged(ChangeEvent ce){
         int value = slider.getValue();
         float aud = (float)value/100;
         try {
             player.setGain(aud);
         } catch (BasicPlayerException ex) {
             Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
         }
        
     }

        
   }
     
     public void close(){
         jFrame.dispatchEvent(new WindowEvent(jFrame, WindowEvent.WINDOW_CLOSING));
     }
     
    public final JFrame getMainFrame(){
        showAlbum2();
        return jFrame;
    }
    
    
         
    
    
    
    public class Key implements ActionListener, MenuListener, KeyListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void menuSelected(MenuEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void menuDeselected(MenuEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void menuCanceled(MenuEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyTyped(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyPressed(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyReleased(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
   
    
}
    
    
    
    
    
    
   
    
}
    

    
    


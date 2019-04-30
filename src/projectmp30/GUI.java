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
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Selector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
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
    JMenu addpl;
    JPopupMenu jPopup;
    JPopupMenu jPopup2;
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
        
        m1 = new Key();
        m2 = new Key();
        
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
        jTable = new JTable();
        jTable.setDefaultEditor(Object.class, null);
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
        //assign the listener
        jTable.addMouseListener(mouseListener);
        
        
        
        jTable.setDragEnabled(true);
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
        
        scrollPane2.setSize(sizex/8,sizey);
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
        contentPane.add(new JScrollPane(jTable), BorderLayout.CENTER);
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
         
                 
        jTable.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title", "Album", "Artist", "Year", "Genre", "Comment", "Path"
            }
        ));
         
         
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
             
        jTable.setModel(new DefaultTableModel(
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
             
        jTable.setModel(new DefaultTableModel(
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
                    
                    try {
            player.setGain(aud);
        } catch (BasicPlayerException ex) {
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
            new String [] {
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
    

    
    


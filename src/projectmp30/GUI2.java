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
import java.awt.Image;
import java.awt.Point;

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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import org.xml.sax.SAXException;


/**
 *
 * @author karth
 */
public class GUI2 {
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
    JTable jTable;
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
    String playli;
    int csr;
    Container contentPane;
    JSlider slider;
    JTable jTable7;
    GUI gui;
            
    public GUI2(String abc, int m, JTable jt7) throws IOException {
        try {
            gui = new GUI();
        } catch (SQLException ex) {
            Logger.getLogger(GUI2.class.getName()).log(Level.SEVERE, null, ex);
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
        //jTable.setComponentPopupMenu(jPopup);
        
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
        
        scrollPane = new JScrollPane(jTable);
        //assign the listener
        jTable.addMouseListener(mouseListener);
        


        slider = new JSlider();
         slider.setMinimum(0);
         slider.setMaximum(100);
            slider.setValue(85);
            slider.addChangeListener(new GUI2.MyChangeAction());

        

        
        
        

        
        
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
        
        jLabel3.setSize(100,100);
        
        jTable.setDragEnabled(true);
        jTable.setDropMode(DropMode.INSERT_ROWS);
        
        
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
        contentPane.add(new JScrollPane(jTable), BorderLayout.CENTER);
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
        DragMp3 d = new DragMp3(jTable, playli, jTable7);
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
         }
         
          class Options implements ActionListener{
              
              Actions ac = new Actions();
                public void actionPerformed(ActionEvent e) {
                   if("Add Song".equals(e.getActionCommand())){
                       ac.add(chooser,jTable,playli);
                       showAlbum2();
                       gui.showAlbum();
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
                        
                        if(playli=="Library"){
                            ac.delete(jTable,CurrentSelectedRow, playli);
                            showAlbum();
                        } 
                            else{
                            ac.delete1(jTable,CurrentSelectedRow, playli);
                            showAlbum2();
            }
                        
       }
                   
                   
                   if("Delete a Song".equals(e.getActionCommand())){
                        CurrentSelectedRow =jTable.getSelectedRow();
                        ac.delete(jTable,CurrentSelectedRow,playli);
                        
                        
                        if(playli=="Library"){
                            ac.delete(jTable,CurrentSelectedRow, playli);
                            showAlbum();
                        } 
                            else{
                            ac.delete1(jTable,CurrentSelectedRow, playli);
                            showAlbum2();
            }
                   
       }
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
            //url = jTable.getModel().getValueAt(CurrentSelectedRow, 6).toString();
            
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
    

    
    


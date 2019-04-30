/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmp30;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javazoom.jlgui.basicplayer.BasicPlayer;
import org.xml.sax.SAXException;

/**
 *
 * @author karth
 */
public class Actions {
    JFileChooser chooser;
    JTable jTable;
    String path123;
    String url;
    URL a;
    BasicPlayer player = new BasicPlayer();
    JLabel jLabel = new JLabel();
    JLabel jLabel3 = new JLabel();
    int CurrentSelectedRow;
    String plist;
    String Title = "";
    String Album = "";
    String Artist = "";
    String Year = "";
    String Genre = "";
    String Comment = "";
    String path="";
    String que;
    
    
    public void add(JFileChooser ch, JTable jt, String pli){
        chooser = new JFileChooser();
        chooser = ch;
        plist = pli;
        jTable = new JTable();
        jTable = jt;
         FileNameExtensionFilter filter = new FileNameExtensionFilter("Mp3 Files", "mp3");
         chooser.setFileFilter(filter);
         chooser.setMultiSelectionEnabled(true);
         int returnVal = chooser.showOpenDialog(null);
         if(returnVal == JFileChooser.APPROVE_OPTION) {
            File[] files = chooser.getSelectedFiles();
            path123 = chooser.getSelectedFile().toString();  
            
            try {
                
                for(File file : files)
                   {
                    path = file.getPath();
                    Mp3File mp3file = new Mp3File(path);
                    if (mp3file.hasId3v1Tag()) {
                    ID3v1 id3v1Tag = mp3file.getId3v1Tag();
                    Title = id3v1Tag.getTitle();
                    Album = id3v1Tag.getAlbum();
                    Artist = id3v1Tag.getArtist();
                    Year = id3v1Tag.getYear();
                    Genre = id3v1Tag.getGenreDescription();
                    Comment = id3v1Tag.getComment() ;

                    System.out.println("Track: " + id3v1Tag.getTrack());
                    System.out.println("Artist: " + id3v1Tag.getArtist());
                    System.out.println("Title: " + id3v1Tag.getTitle());
                    System.out.println("Album: " + id3v1Tag.getAlbum());
                    System.out.println("Year: " + id3v1Tag.getYear());
                    System.out.println("Genre: " + id3v1Tag.getGenre() + " (" + id3v1Tag.getGenreDescription() + ")");
                    System.out.println("Comment: " + id3v1Tag.getComment());
                
            }
                    System.out.println(plist);

          
            Connection con=null;
            PreparedStatement ps=null; 
            Statement pn = null;
            PreparedStatement ps1 = null;
            ResultSet rs;
            int c = 0;
            
            
            try
                {
                    
                    
                con=DatabaseConnect.getConnection();
                System.out.println(plist);
                if(plist=="Library"){
                    que = "insert into library (Title,Album,Artist,Year,Genre,Comment,Path) values (?,?,?,?,?,?,?)";
                    ps=con.prepareStatement (que);

                    ps.setString(1,Title);
                    ps.setString(2,Album);
                    ps.setString(3,Artist);
                    ps.setString(4,Year);
                    ps.setString(5, Genre);
                    ps.setString(6,Comment);
                    ps.setString(7,path);
                    ps.executeUpdate();
                }
                
                else{
                    pn = con.createStatement();
                    String abc = "Select * from library where Title =\'"+Title+"\'";
                    System.out.println(abc);
                    

                    rs = pn.executeQuery(abc);
                    System.out.println(rs);
                    while(rs.next()){
                        c++;
                    }
                    System.out.println(c);
                    
                    if(c==0){
                        
                        que = "insert into library (Title,Album,Artist,Year,Genre,Comment,Path) values (?,?,?,?,?,?,?)";
                         ps=con.prepareStatement (que);

                ps.setString(1,Title);
                ps.setString(2,Album);
                ps.setString(3,Artist);
                ps.setString(4,Year);
                ps.setString(5, Genre);
                ps.setString(6,Comment);
                ps.setString(7,path);
                ps.executeUpdate();
                    }
                    else
                    {
                        System.out.println("Undi ra rey");
                        
                    }
                    
                    String me = "insert into spl (playist,song) values (?,?)";
                    ps1 = con.prepareStatement(me);
                    ps1.setString(1,plist);
                    ps1.setString(2,path);
                    ps1.executeUpdate();
                    
                    
                    
                }
                
                
                
               
                DefaultTableModel m1 = (DefaultTableModel)jt.getModel();
                m1.setRowCount(0);
                
                
                
                    



                            

                  
                }
            catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }
                   }
                } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedTagException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidDataException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
                    
        }
    }
    
    public void addpl(String url, String pli){
        
        plist = pli;
        
           
            
            try {
                
                
                   
                    path = url;
                    Mp3File mp3file = new Mp3File(path);
                    if (mp3file.hasId3v1Tag()) {
                    ID3v1 id3v1Tag = mp3file.getId3v1Tag();
                    Title = id3v1Tag.getTitle();
                    Album = id3v1Tag.getAlbum();
                    Artist = id3v1Tag.getArtist();
                    Year = id3v1Tag.getYear();
                    Genre = id3v1Tag.getGenreDescription();
                    Comment = id3v1Tag.getComment() ;

                    System.out.println("Track: " + id3v1Tag.getTrack());
                    System.out.println("Artist: " + id3v1Tag.getArtist());
                    System.out.println("Title: " + id3v1Tag.getTitle());
                    System.out.println("Album: " + id3v1Tag.getAlbum());
                    System.out.println("Year: " + id3v1Tag.getYear());
                    System.out.println("Genre: " + id3v1Tag.getGenre() + " (" + id3v1Tag.getGenreDescription() + ")");
                    System.out.println("Comment: " + id3v1Tag.getComment());
                
            }
                    System.out.println(plist);

          
            Connection con=null;
            PreparedStatement ps=null; 
            Statement pn = null;
            PreparedStatement ps1 = null;
            ResultSet rs;
            int c = 0;
            
            
            try
                {
                    
                    
                con=DatabaseConnect.getConnection();
                System.out.println(plist);
                if(plist=="Library"){
                    que = "insert into library (Title,Album,Artist,Year,Genre,Comment,Path) values (?,?,?,?,?,?,?)";
                    ps=con.prepareStatement (que);

                    ps.setString(1,Title);
                    ps.setString(2,Album);
                    ps.setString(3,Artist);
                    ps.setString(4,Year);
                    ps.setString(5, Genre);
                    ps.setString(6,Comment);
                    ps.setString(7,path);
                    ps.executeUpdate();
                }
                
                else{
                    pn = con.createStatement();
                    String abc = "Select * from library where Title =\'"+Title+"\'";
                    System.out.println(abc);
                    

                    rs = pn.executeQuery(abc);
                    System.out.println(rs);
                    while(rs.next()){
                        c++;
                    }
                    System.out.println(c);
                    
                    if(c==0){
                        
                        que = "insert into library (Title,Album,Artist,Year,Genre,Comment,Path) values (?,?,?,?,?,?,?)";
                         ps=con.prepareStatement (que);

                ps.setString(1,Title);
                ps.setString(2,Album);
                ps.setString(3,Artist);
                ps.setString(4,Year);
                ps.setString(5, Genre);
                ps.setString(6,Comment);
                ps.setString(7,path);
                ps.executeUpdate();
                    }
                    else
                    {
                        System.out.println("Undi ra rey");
                        
                    }
                    
                    String me = "insert into spl (playist,song) values (?,?)";
                    ps1 = con.prepareStatement(me);
                    ps1.setString(1,plist);
                    ps1.setString(2,path);
                    ps1.executeUpdate();
                    
                    
                    
                }
                
              
               
                
                
                
               
                
                
                
                
                    



                            

                  
                }
            catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }
                   
                } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedTagException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidDataException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
                    
        
    }

    public void open(JFileChooser ch1, BasicPlayer bp, JLabel jl1, JLabel jl2) throws UnsupportedTagException, InvalidDataException{
        ch1 = new JFileChooser();
        
        jLabel = jl1;
        jLabel3 = jl2;
        player = bp;
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Mp3 Files", "mp3");
                         ch1.setFileFilter(filter);
                    int returnVal = ch1.showOpenDialog(null);
                    if(returnVal == JFileChooser.APPROVE_OPTION) {
                    url = ch1.getSelectedFile().toString(); 
                    try {
                    a = new File(url).toURI().toURL();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
 
             try {
                player.open(a);
                player.play();
                Mp3File mp3file = new Mp3File(url);
                ID3v2 id3v2Tag = mp3file.getId3v2Tag();
                String sa = "Now Playing : " + id3v2Tag.getTitle();
                jLabel.setText(sa);
                
                //Mp3File mp3file = new Mp3File(url);
                if (mp3file.hasId3v2Tag()) {
                       byte[] img = id3v2Tag.getAlbumImage();
                       BufferedImage image = ImageIO.read(new ByteArrayInputStream(img)); 
                       jLabel3.setSize(100,100);
                       Image dimg = image.getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(),Image.SCALE_SMOOTH);
                       ImageIcon icon = new ImageIcon(dimg);
                       jLabel3.setIcon(icon);
                        
                
                
            }
                
            }   catch (javazoom.jlgui.basicplayer.BasicPlayerException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }           catch (IOException ex) {
                                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                    
                    
                    
        }
        
        
        
        
    }
    
    public void delete(JTable jt,int cs, String play123) {
        jTable = jt;
        CurrentSelectedRow = cs;
        String pl123 = play123;
        
        url = jTable.getModel().getValueAt(CurrentSelectedRow, 6).toString();
        String path123 = jTable.getModel().getValueAt(CurrentSelectedRow, 6).toString();
        System.out.println(path123);
        url = url.replace("\\", "\\\\");
        path123 = path123.replace("\\", "\\\\");
        System.out.println(path123);
                        Connection con = DatabaseConnect.getConnection();
                        Statement st = null;  
                        Statement st1 = null;
                       try {
                           st = con.createStatement();
                       } catch (SQLException ex) {
                           Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                       }
                        String qr = "DELETE FROM `projectmp3`.`library` WHERE (`Path` = \'" +url+ "\');";
                        String qr1 = "DELETE FROM `projectmp3`.`spl` WHERE (`song` = \'"+path123+"\');";
                        System.out.println(qr1);
                        
                        System.out.println(qr);
                       try {
                           st.executeUpdate(qr);
                           st.executeUpdate(qr1);
                       } catch (SQLException ex) {
                           Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                       }
        
    }
    
    public void delete1(JTable jt,int cs, String play123) {
        jTable = jt;
        CurrentSelectedRow = cs;
        String pl123 = play123;
        
        url = jTable.getModel().getValueAt(CurrentSelectedRow, 0).toString();
        String path123 = jTable.getModel().getValueAt(CurrentSelectedRow, 6).toString();
        path123 = path123.replace("\\", "\\\\");
                        Connection con = DatabaseConnect.getConnection();
                        Statement st = null;  
                      
                       try {
                           st = con.createStatement();
                       } catch (SQLException ex) {
                           Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                       }
                        
                        String qr1 = "DELETE FROM `projectmp3`.`spl` WHERE (`playist` = \'" +pl123+ "\' && song = \'"+path123+"\');";
                        System.out.println(qr1);
                       
                    
                       try {
                           
                           st.executeUpdate(qr1);
                       } catch (SQLException ex) {
                           Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                       }
        
    }
    
    
    
}

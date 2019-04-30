
package projectmp30;



import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import java.util.List;
import java.awt.datatransfer.*;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.File;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;

import org.xml.sax.SAXException;

/**
 *
 * @author karth
 */
public class DragMp3 implements DropTargetListener{
                String Title = "";
                String Album = "";
                String Artist = "";
                String Year = "";
                String Genre = "";
                String Comment = "";
                JFrame frame = new JFrame();
                JTable jt = new JTable();
                String plist;
                String que;
                JTree jTree;
                int csr;
                String path123;
                JTable jt7;
                

    DragMp3(JTable jTable, String pli, JTable jTable7) {
        jt = jTable;
        plist = pli;
        jt7 = jTable7;
        
        System.out.println(plist);
        System.out.println("Ammanra");
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
             System.out.println("Show Album");
             jt7.setModel(new DefaultTableModel(
                     new Object [][] {
                         
                     },
                     new String [] {
                         "Title", "Album", "Artist", "Year", "Genre", "Comment", "Path"
                     }
             ));
             ArrayList<DisplayAlbum> list = callDisplayAlbum();
             System.out.println(list);
             DefaultTableModel model = (DefaultTableModel)jt7.getModel();
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
             jt7.changeSelection(0,0,false,false);
         
     }
         
         public void showAlbum2(){
             
        jt.setModel(new DefaultTableModel(
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
            
            String qr = "select `b`.`Title`, `b`.`Album`, `b`.`Artist`, `b`.`Year`, `b`.`Genre`, `b`.`Comment`, `b`.`Path` from spl a left outer join library b on b.Path = a.song where a.playist = \""+plist+"\"";
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
         DefaultTableModel model = (DefaultTableModel)jt.getModel();
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

         
         jt.changeSelection(0,0,false,false);
         }
         
         public void showAlbum22(){
             jt7.setModel(new DefaultTableModel(
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
            if (plist =="Library")
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
         DefaultTableModel model = (DefaultTableModel)jt7.getModel();
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

         
         jt7.changeSelection(0,0,false,false);
         }
    
    
    @Override
    public void dragEnter(DropTargetDragEvent dtde) {
    }

    @Override
    public void dragOver(DropTargetDragEvent dtde) {
    }

    @Override
    public void dropActionChanged(DropTargetDragEvent dtde) {

    }
    

    @Override
    public void dragExit(DropTargetEvent dte) {
    }

    @Override
    public void drop(DropTargetDropEvent ev) {
        ev.acceptDrop(DnDConstants.ACTION_COPY);
        Transferable t = ev.getTransferable();
        int c =0;
        DataFlavor[] df=t.getTransferDataFlavors();
        for(DataFlavor f:df)
        {
            try
            {
                if(f.isFlavorJavaFileListType())
                {
                    List<File> files =(List<File>) t.getTransferData(f);
                    System.out.println(files);
                    
                    for(File file : files)
                    {
                        getSong(file.getPath());
                    }
                    
                }
                
                else
                {
                    
                    String data = (String)t.getTransferData(DataFlavor.stringFlavor);
                    String[] rowData = data.split("C:");
                    String path = rowData[1];
                    path123 = "C:"+path;
                    System.out.println(path);
                    getSong(path123);
                }
                
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        
        
        

             
    }
    
    public void getSong(String path) throws FileNotFoundException, IOException, SAXException, UnsupportedTagException, InvalidDataException
    {  

        
        


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
                    
                    DefaultTableModel m1 = (DefaultTableModel)jt.getModel();
                m1.setRowCount(0);
                showAlbum();
                showAlbum2();
                }
                
                else{
                    pn = con.createStatement();
                    String path1 = path.replace("\\","\\\\");
                    String abc = "Select * from library where Path =\'"+path1+"\'";
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
                    DefaultTableModel m1 = (DefaultTableModel)jt.getModel();
                m1.setRowCount(0);
                showAlbum2();
                showAlbum22();
                    
                    
                    
                }
                
               
                
                
                
                    



                            

                  
                }
            catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }
                

                
        }
   
    
         
    
}
         

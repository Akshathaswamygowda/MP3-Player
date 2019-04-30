/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmp30;

/**
 *
 * @author karth
 */
public class DisplayAlbum {
    
    private String Title = "";
    private String Album = "";
    private String Artist = "";
    private String Year = "";
    private String Genre = "";
    private String Comment = "";
    private String Path = "";
    
    public DisplayAlbum(String Title, String Album, String Artist, String Year, String Genre, String Comment, String Path)
    {
        this.Title = Title;
        this.Album = Album;
        this.Artist = Artist;
        this.Year = Year;
        this.Genre = Genre;
        this.Comment = Comment;
        this.Path = Path;
    }
    
    public String getTitle(){
        return Title;
    }
    
    public String getAlbum(){
        return Album;
    }
        
    public String getArtist(){
        return Artist;
    }
            
    public String getYear(){
        return Year;
    }
       
     public String getGenre(){
        return Genre;
    }
       
     public String getComment(){
        return Comment;
    }
       
    public String getPath(){
        return Path;
    }

    
}

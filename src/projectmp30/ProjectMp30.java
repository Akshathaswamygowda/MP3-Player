/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmp30;

import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author karth
 */
public class ProjectMp30 {
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
              
        try {
            GUI g = new GUI();
            g.go();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectMp30.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}

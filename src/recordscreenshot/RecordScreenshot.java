/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recordscreenshot;

import frames.MainUI;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Salah
 */
public class RecordScreenshot extends MainUI{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
        // TODO code application logic here
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {           
                //installing Jtatto theme
                UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");     
        }
            MainUI.getObj().setVisible(true);
            MainUI.getObj().setLocationRelativeTo(null);
        } catch (IOException ex) {
            Logger.getLogger(RecordScreenshot.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
                Logger.getLogger(RecordScreenshot.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
                Logger.getLogger(RecordScreenshot.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
                Logger.getLogger(RecordScreenshot.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(RecordScreenshot.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}

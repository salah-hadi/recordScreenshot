/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recordscreenshot;

import frames.FullSc;
import frames.MainUI;
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
        // TODO code application logic here
//         writtingToWord wr=new writtingToWord();
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            try {
                //installing Jtatto theme
                UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
                

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
        MainUI mu=new MainUI();
        mu.setVisible(true);
        mu.setLocationRelativeTo(null);
    }
    
}

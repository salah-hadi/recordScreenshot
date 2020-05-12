/*
/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
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

    
    
//    public boolean isUnlocked(String fileName){
//        
//        boolean isFileUnlocked = false;
//        try {
//            File verify=new File(fileName);
//            org.apache.commons.io.FileUtils.touch(verify);
//            isFileUnlocked = true;
//        } catch (IOException e) {
//            isFileUnlocked = false;
//        }
//        return isFileUnlocked;
//    }
//    
//    
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

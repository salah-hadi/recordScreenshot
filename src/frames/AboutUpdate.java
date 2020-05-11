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
package frames;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.ini4j.Wini;

/**
 *
 * @author hp
 */
public class AboutUpdate extends javax.swing.JFrame {

    /**
     * Creates new form AboutUpdate
     */
    public AboutUpdate() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        update = new javax.swing.JButton();
        ver = new javax.swing.JLabel();
        buildNo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pix = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Version");

        jLabel2.setText("Build No:");

        update.setText("check for update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        ver.setText("V 1.2.3");

        buildNo.setText("1.2");

        jLabel3.setText("Pixelitor");

        pix.setText("V 2.4.3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(update)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pix)
                            .addComponent(buildNo)
                            .addComponent(ver, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(update)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ver))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(buildNo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pix))
                .addContainerGap(153, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            // TODO add your handling code here:
            MainUI.getObj().setAlwaysOnTop(true);
            MainUI.getObj().setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(AboutUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        try {
            // TODO add your handling code here:
            checkUpdate();
        } catch (IOException ex) {
            Logger.getLogger(AboutUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }//GEN-LAST:event_updateActionPerformed

    
    private void checkUpdate() throws IOException{
        String version=ver.getText();
        String build=buildNo.getText();
        String pixV=pix.getText();
        
        String release[]=readIni();
        if(release[0].equals("Error connecting to server")){
            JOptionPane.showMessageDialog(null, "Error connecting to server");

        }else{
            if((!version.equals(release[0])||(!build.equals(release[1]))||(!pixV.equals(release[3])))){
                JOptionPane.showMessageDialog(null, "New release is available.");
                int result=JOptionPane.showConfirmDialog(null, "New release is available, do you want to start download now?","Confirm Update", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE );
                if(result==JOptionPane.YES_OPTION){
                    MainUI.getObj().close();
                    long pid = ProcessHandle.current().pid();
   //                 System.out.println("pid:"+pid);
                    String editorPath=new File("updaterV1.1.jar").getAbsolutePath();
                   ProcessBuilder builder = new ProcessBuilder(
                           "cmd.exe", "/c", "java -jar "+editorPath+" "+""+release[2]+""+" "+pid+" "+""+release[4]+"");
                   builder.redirectErrorStream(true);
                   Process p = builder.start();

                   BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
                   String line;
                   while (true) {
                       line = r.readLine();
                       if (line == null) { break; }                   
                   }
                }
                 
            }else{
                JOptionPane.showMessageDialog(null, "There's no avilable updates.");
            }
        }          
    }
    
    private String[] readIni(){
        String[] release= new String[5];
        try {
            URL nnn=new URL("http://127.0.0.1/update.ini");
//            URL nnn=new URL("https://egyptandmiddleeastit-my.sharepoint.com/personal/selhady_emeit_com/_layouts/15/download.aspx?SourceUrl=%2Fpersonal%2Fselhady%5Femeit%5Fcom%2FDocuments%2Fupdate%2Eini");
            ReadableByteChannel rbc = Channels.newChannel(nnn.openStream());
            FileOutputStream fos = new FileOutputStream("update.ini");
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            
            Wini ini = new Wini(new File("update.ini"));
    
            String version = ini.get("Update", "Version", String.class);           
            String build = ini.get("Update", "Build", String.class);
            String newVersionUrl=ini.get("Update", "URL", String.class);            
            String pixV=ini.get("Pixelitor","Version", String.class);
            String pixUrl=ini.get("Pixelitor","URL", String.class);
            
//            System.out.println("version"+version+" build:"+build);
            if(version==null||build==null||pixV==null){
                release[0]="Error connecting to server";
            }else{
                release[0]=version;
                release[1]=build;
                release[2]=newVersionUrl;
                release[3]=pixV;
                release[4]=pixUrl;
            }
            
        } catch (ConnectException ex) {
            Logger.getLogger(AboutUpdate.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error in connecting, Kindly check your internet.");
          } catch (MalformedURLException ex) {
            Logger.getLogger(AboutUpdate.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AboutUpdate.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AboutUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return release;
    }
    
    public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEve­ntQueue().postEvent(winClosingEvent);     
    }
    

    
  
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AboutUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AboutUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AboutUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AboutUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AboutUpdate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel buildNo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel pix;
    private javax.swing.JButton update;
    private javax.swing.JLabel ver;
    // End of variables declaration//GEN-END:variables
}


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
 * under the License. */
package imageViewer;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import recordscreenshot.StoringCommShots;
import frames.MainUI;
import java.awt.FileDialog;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.UIManager;
import recordscreenshot.FileFormat;
/**
 *
 * @author Salah
 */
public class ImgView extends javax.swing.JFrame {

    int pagesNO;
    public static ImgView iv=null;
    
    
    public ImgView() throws IOException {
        MainUI.getObj().loadingtheme();
        initComponents();
        //check if there're no screenshots show message only
        if(getNoShots()==0){
            JOptionPane.showMessageDialog(null, "There're no added images to preview");
            WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
            Toolkit.getDefaultToolkit().getSystemEve­ntQueue().postEvent(winClosingEvent);

        }else{
            //open the first image
            settingIco(StoringCommShots.arr[0][0]);
            comments.setText(StoringCommShots.arr[1][0]);//get the first comment
            currPage.setText("1"); //set current page
        }

        if(noOpages.getText().equals(currPage.getText())){
            nxtbtn.setEnabled(false); //if there's only one screenshot lock the navigation
        }
        bkBtn.setEnabled(false);//disable nvigate back button
        this.setLocationRelativeTo(null);
        
    }

    
     public static ImgView getObj() throws IOException{
        if(iv==null){
            iv=new ImgView();
        }
        return iv;
    }
    
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        imgPreviewLbl = new javax.swing.JLabel();
        saveAsbtn = new javax.swing.JButton();
        nxtbtn = new javax.swing.JButton();
        bkBtn = new javax.swing.JButton();
        delBtn = new javax.swing.JButton();
        noOpages = new javax.swing.JLabel();
        currPage = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        comments = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        updateComments = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        editApp = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Preview Screenshots");
        setPreferredSize(new java.awt.Dimension(1265, 603));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        saveAsbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/floppy_disk_edit.png"))); // NOI18N
        saveAsbtn.setText("Save as");
        saveAsbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsbtnActionPerformed(evt);
            }
        });

        nxtbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow_right_blue.png"))); // NOI18N
        nxtbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nxtbtnActionPerformed(evt);
            }
        });

        bkBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow_left_blue.png"))); // NOI18N
        bkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkBtnActionPerformed(evt);
            }
        });

        delBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete.png"))); // NOI18N
        delBtn.setText("Delete");
        delBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delBtnActionPerformed(evt);
            }
        });

        noOpages.setText("jLabel2");

        currPage.setText("jLabel1");

        jLabel1.setText("of");

        comments.setColumns(20);
        comments.setRows(5);
        jScrollPane2.setViewportView(comments);

        jLabel2.setText("Comments");

        updateComments.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/floppy_disk_ok.png"))); // NOI18N
        updateComments.setText("update comments");
        updateComments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateCommentsActionPerformed(evt);
            }
        });

        edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit.png"))); // NOI18N
        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        editApp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MS paint", "Pixelitor" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(imgPreviewLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(currPage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(noOpages)
                        .addGap(32, 32, 32)
                        .addComponent(bkBtn)
                        .addGap(18, 18, 18)
                        .addComponent(nxtbtn)
                        .addGap(100, 100, 100)
                        .addComponent(delBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(updateComments)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(saveAsbtn)
                        .addGap(30, 30, 30)
                        .addComponent(edit)
                        .addGap(18, 18, 18)
                        .addComponent(editApp, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(237, 237, 237))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(imgPreviewLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(updateComments))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(noOpages)
                            .addComponent(currPage)
                            .addComponent(jLabel1)
                            .addComponent(bkBtn)
                            .addComponent(nxtbtn)
                            .addComponent(delBtn))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(saveAsbtn)
                            .addComponent(edit)
                            .addComponent(editApp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        jScrollPane1.setViewportView(jPanel1);

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Update comments");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Delete");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1049, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveAsbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsbtnActionPerformed
        //copy the selected image to the selected location
        FileDialog fDialog = new FileDialog(this,"Save", FileDialog.SAVE);
        fDialog.setFile("*.png");
        fDialog.setVisible(true);
        
        String fileName=fDialog.getFile();
       
        String dir = fDialog.getDirectory();
        String path=dir+fileName;
        FileFormat format=new FileFormat();
        if(format.getFormat(fileName).equals("doesn't have an extension")){
            copyPasteImg(StoringCommShots.arr[0][Integer.parseInt(currPage.getText())-1], path+".png");
        }else if(format.getFormat(fileName).equals("png")){
            copyPasteImg(StoringCommShots.arr[0][Integer.parseInt(currPage.getText())-1], path);
        }else{
            JOptionPane.showMessageDialog(null, "Kindly select a file with 'png' format.");
        }

    }//GEN-LAST:event_saveAsbtnActionPerformed

    private void nxtbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nxtbtnActionPerformed
        try {
            next();
        } catch (IOException ex) {
            Logger.getLogger(ImgView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_nxtbtnActionPerformed

    private void bkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkBtnActionPerformed
        try {
            bk();
        } catch (IOException ex) {
            Logger.getLogger(ImgView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }//GEN-LAST:event_bkBtnActionPerformed

    private void delBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delBtnActionPerformed
        try {
            delete();
        } catch (IOException ex) {
            Logger.getLogger(ImgView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }

        
    }//GEN-LAST:event_delBtnActionPerformed

    private void updateCommentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateCommentsActionPerformed
        saveComments();
    }//GEN-LAST:event_updateCommentsActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            ImgView.iv=null;
            MainUI.getObj().setAlwaysOnTop(true);
        } catch (IOException ex) {
            Logger.getLogger(ImgView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            delete();
        } catch (IOException ex) {
            Logger.getLogger(ImgView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);    
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        saveComments();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        try {
            File testing= new File(StoringCommShots.arr[0][Integer.parseInt(currPage.getText())-1]);
            String fullPath=testing.getAbsolutePath();
            
            String app=editApp.getSelectedItem().toString();
            if(app.equals("MS paint")){
                painter(fullPath);
            }else if(app.equals("Pixelitor")){
                imageEditor(fullPath);
            }
            
            settingIco(StoringCommShots.arr[0][Integer.parseInt(currPage.getText())-1]);
        } catch (IOException ex) {
            Logger.getLogger(ImgView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_editActionPerformed

    /**Delete screenshot and its comment then shift the array
     @throws IOException*/
    private void delete() throws IOException{
        StoringCommShots cs=new StoringCommShots();
        File img=new File(StoringCommShots.arr[0][Integer.parseInt(currPage.getText())-1]);
        
        if(noOpages.getText().equals("1")){
            WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
            Toolkit.getDefaultToolkit().getSystemEve­ntQueue().postEvent(winClosingEvent);
            img.delete();
            StoringCommShots.arr[0][0]=null;
            StoringCommShots.arr[1][0]=null;
            ImgView.iv=null;
            
        }else{
            img.delete();
            
            //shifting array after delete
            int currPageindex=Integer.parseInt(currPage.getText())-1;
            int lastIndex=cs.getLastIndex();
            
            if(currPageindex==lastIndex){
                StoringCommShots.arr[0][lastIndex]=null;
                StoringCommShots.arr[1][lastIndex]=null;
            }else{
                for(int i=Integer.parseInt(currPage.getText())-1;i<199;i++){
                    StoringCommShots.arr[0][i]=StoringCommShots.arr[0][i+1];
                    StoringCommShots.arr[1][i]=StoringCommShots.arr[1][i+1];
                    if(i==198){
                        StoringCommShots.arr[0][199]=null;
                        StoringCommShots.arr[1][199]=null;
                    }
                }
            }
            //after shifting get previous screenshot if available, if not get next one
            if(bkBtn.isEnabled()){
                bk();
            }else if(!bkBtn.isEnabled()&&nxtbtn.isEnabled()){
                next();
            }

            //modify total no of pages
            noOpages.setText(Integer.toString(Integer.parseInt(noOpages.getText())-1));
            
            if(noOpages.getText().equals("1")){
                bkBtn.setEnabled(false);
                nxtbtn.setEnabled(false);
            }
        }
        MainUI.shotName=MainUI.shotName-1;
        MainUI.isFileSaved=false;
    }
    
    /**update the saved comments*/
    private void saveComments(){
        StoringCommShots.arr[1][Integer.parseInt(currPage.getText())-1]=comments.getText();
        MainUI.isFileSaved=false;
    }
    
    /**get No of stored images
     @return No of images*/
    private int getNoShots(){
        StoringCommShots cs=new StoringCommShots();
        int pages=cs.imgsNum();
        noOpages.setText(Integer.toString(pages));
        pagesNO=pages;
        return pages;
    }
    
    /**Setting ICON to label
     @throws IOException*/
    private void settingIco(String resource) throws IOException{
        InputStream img=null;
        int iconW=0;
        int iconH=0;
        try {
            int lblW=imgPreviewLbl.getWidth();
            int lblH=imgPreviewLbl.getHeight();
            
            img= Files.newInputStream(Paths.get(new File(resource).getAbsolutePath()));
            BufferedImage bimg = ImageIO.read(img);
            int resourceW= bimg.getWidth();
            int resourceH= bimg.getHeight();
  
            if(resourceW>=lblW){
                iconW=lblW;
            }else if(resourceW<lblW){
                iconW=resourceW;
            }
            
            if(resourceH>=lblH){
                iconH=lblH;
            }else if(resourceH<lblH){
                iconH=resourceH;
            }
            
            imgPreviewLbl.setIcon(new ImageIcon(new ImageIcon(resource).getImage().getScaledInstance(iconW, iconH, Image.SCALE_SMOOTH)));
            imgPreviewLbl.setHorizontalAlignment(imgPreviewLbl.CENTER);

        } catch (IOException ex) {
            Logger.getLogger(ImgView.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            img.close();
        }
    }
    
    /**opening the previous screenshot and enable/disable navigators
     @throws IOException*/
    private void bk() throws IOException{
        StoringCommShots cs=new StoringCommShots();
        currPage.setText(Integer.toString(Integer.parseInt(currPage.getText())-1));
        if(nxtbtn.isEnabled()==false&&!currPage.getText().equals(Integer.toString(cs.imgsNum()))){
            nxtbtn.setEnabled(true);
        
        }
        //setting icon
        settingIco(StoringCommShots.arr[0][Integer.parseInt(currPage.getText())-1]);
        if(currPage.getText().equals("1")){
            bkBtn.setEnabled(false);
        }
        //setting comment
        comments.setText(StoringCommShots.arr[1][Integer.parseInt(currPage.getText())-1]);
    }
    /***open next screenshot and enable or disable navigator
     @throws  IOException*/
    private void next() throws IOException{
        StoringCommShots cs=new StoringCommShots();
         if(bkBtn.isEnabled()==false && !noOpages.getText().equals("1")){
            bkBtn.setEnabled(true);
        }
        if(!currPage.getText().equals(Integer.toString(cs.imgsNum()))){
            currPage.setText(Integer.toString(Integer.parseInt(currPage.getText())+1));  
        }
//setting icon        
        settingIco(StoringCommShots.arr[0][Integer.parseInt(currPage.getText())-1]);
        if(noOpages.getText().equals(currPage.getText())||currPage.getText().equals(Integer.toString(cs.imgsNum()))){
            nxtbtn.setEnabled(false);        
        }
        //setting comments
        comments.setText(StoringCommShots.arr[1][Integer.parseInt(currPage.getText())-1]);
    }
    
    /**Copy and paste image in specific location
     @param imgin  IMG src
     @param  imgOut  IMG will be saved to*/
    private void copyPasteImg(String imgin, String imgOut){
        try {
            FileInputStream in = new FileInputStream(imgin);
            FileOutputStream ou = new FileOutputStream(imgOut);
            BufferedInputStream bin = new BufferedInputStream(in);
            BufferedOutputStream bou = new BufferedOutputStream(ou);
            int b=0;
            while(b!=-1){
                b=bin.read();
                bou.write(b);
            }
            bin.close();
            bou.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImgView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ImgView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //open last image
    public void openLast() throws IOException{
        currPage.setText(noOpages.getText());
        settingIco(StoringCommShots.arr[0][Integer.parseInt(currPage.getText())-1]);
        comments.setText(StoringCommShots.arr[1][Integer.parseInt(currPage.getText())-1]);
        nxtbtn.setEnabled(false);
        if(!noOpages.getText().equals("1")){
            bkBtn.setEnabled(true);
        } 
    }
    
    //open painter
    private void painter(String imgPath){
        try {
            ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe", "/c", "mspaint \""+imgPath+"\"");
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while (true) {
                line = r.readLine();
                if (line == null) { break; }
//                System.out.println(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(ImgView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Image editor
    public void imageEditor(String imgPath){
           try {
               String editorPath=new File("Pixelitor-4.2.4.jar").getAbsolutePath();
                ProcessBuilder builder = new ProcessBuilder(
                        "cmd.exe", "/c", "java -jar \""+editorPath+"\" \""+imgPath+"\"");
                builder.redirectErrorStream(true);
                Process p = builder.start();
                BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line;
                while (true) {
                    line = r.readLine();
                    if (line == null) { break; }
    //                System.out.println(line);
                }
        } catch (IOException ex) {
            Logger.getLogger(ImgView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * 
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
                UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ImgView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImgView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImgView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImgView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ImgView().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(ImgView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bkBtn;
    private javax.swing.JTextArea comments;
    private javax.swing.JLabel currPage;
    private javax.swing.JButton delBtn;
    private javax.swing.JButton edit;
    private javax.swing.JComboBox<String> editApp;
    private javax.swing.JLabel imgPreviewLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel noOpages;
    private javax.swing.JButton nxtbtn;
    private javax.swing.JButton saveAsbtn;
    private javax.swing.JButton updateComments;
    // End of variables declaration//GEN-END:variables
}

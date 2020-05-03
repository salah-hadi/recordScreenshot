/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import imageViewer.ImgView;
import java.awt.AWTException;
import java.awt.FileDialog;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import recordscreenshot.StoringCommShots;
import recordscreenshot.writtingToWord;

/**
 *
 * @author Salah
 */
public class MainUI extends javax.swing.JFrame {

    public static int shotName=0;
    public StoringCommShots storing;
    public static boolean isFileSaved=true;
    /**
     * Creates new form MainUI
     */
    public MainUI() {
        initComponents();
        storing=new StoringCommShots();
        //Jcheckboxes used to validate if fields has the correct data(When selected) or not.
        wBox.setVisible(false); //width field
        hBox.setVisible(false);  //Hight field
        fileBox.setVisible(false);   //File name field
        
        delete.setVisible(false);   //Hidding New session button
        
        commentsJtxtArea.setVisible(false); //hidding comments field by default
        commentsScPane.setVisible(false);
        this.setSize(176, 211);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        hTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        wTxt = new javax.swing.JTextField();
        fileNameTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        wBox = new javax.swing.JCheckBox();
        hBox = new javax.swing.JCheckBox();
        fileBox = new javax.swing.JCheckBox();
        browseFileName = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        commentBtn = new javax.swing.JButton();
        commentsScPane = new javax.swing.JScrollPane();
        commentsJtxtArea = new javax.swing.JTextArea();
        captureBtn = new javax.swing.JButton();
        save = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        previewBtn = new javax.swing.JButton();
        erroLbl = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        previewMenu = new javax.swing.JMenuItem();
        newSessionMenu = new javax.swing.JMenuItem();
        saveMenu = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Screenshots recorder");
        setAlwaysOnTop(true);
        setPreferredSize(new java.awt.Dimension(733, 211));
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        hTxt.setText("500");
        hTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                hTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                hTxtKeyReleased(evt);
            }
        });

        jLabel3.setText("H:");

        jLabel2.setText("W:");

        wTxt.setText("500");
        wTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                wTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                wTxtKeyReleased(evt);
            }
        });

        fileNameTxt.setEditable(false);

        jLabel1.setText("File Name:");

        wBox.setSelected(true);
        wBox.setEnabled(false);

        hBox.setSelected(true);
        hBox.setEnabled(false);

        browseFileName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/folder.png"))); // NOI18N
        browseFileName.setText("Browse");
        browseFileName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseFileNameActionPerformed(evt);
            }
        });

        jLabel4.setText(".docx");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(wTxt)
                            .addComponent(hTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(browseFileName))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(fileNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(wBox)
                    .addComponent(hBox)
                    .addComponent(fileBox))
                .addGap(1, 1, 1))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(browseFileName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fileNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(fileBox, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(wTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wBox))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hBox)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(hTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel1.setPreferredSize(new java.awt.Dimension(634, 160));

        commentBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/form_blue_add.png"))); // NOI18N
        commentBtn.setText("Comment");
        commentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commentBtnActionPerformed(evt);
            }
        });

        commentsJtxtArea.setColumns(20);
        commentsJtxtArea.setRows(5);
        commentsJtxtArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                commentsJtxtAreaKeyPressed(evt);
            }
        });
        commentsScPane.setViewportView(commentsJtxtArea);

        captureBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/1486395877-camera_80616.png"))); // NOI18N
        captureBtn.setText("Capture");
        captureBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                captureBtnActionPerformed(evt);
            }
        });

        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/floppy_disks.png"))); // NOI18N
        save.setText("save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        delete.setText("New session");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        previewBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/folder_movie.png"))); // NOI18N
        previewBtn.setText("preview");
        previewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(save)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(captureBtn)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(previewBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(commentBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(delete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(commentsScPane, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(commentBtn)
                            .addComponent(captureBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(previewBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(15, 15, 15)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(commentsScPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        erroLbl.setForeground(new java.awt.Color(255, 51, 51));
        erroLbl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jMenu1.setText("File");

        previewMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        previewMenu.setText("Preview");
        previewMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewMenuActionPerformed(evt);
            }
        });
        jMenu1.add(previewMenu);

        newSessionMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newSessionMenu.setText("New session");
        newSessionMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newSessionMenuActionPerformed(evt);
            }
        });
        jMenu1.add(newSessionMenu);

        saveMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveMenu.setText("Save");
        saveMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuActionPerformed(evt);
            }
        });
        jMenu1.add(saveMenu);

        jMenuItem1.setText("capture specific");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(erroLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(erroLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here: 
        save();
        
    }//GEN-LAST:event_saveActionPerformed

    private void captureBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_captureBtnActionPerformed
        // TODO add your handling code here:     
        this.setState(1);//minimize the window
        validateComment(Integer.toString(shotName)); //validating comments and take screenshot
        //restore the window
        this.setState(0); 
    }//GEN-LAST:event_captureBtnActionPerformed

    private void commentsJtxtAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_commentsJtxtAreaKeyPressed
        // TODO add your handling code here:
        //clear error label
        erroLbl.setText(""); 
    }//GEN-LAST:event_commentsJtxtAreaKeyPressed

    private void commentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commentBtnActionPerformed
        // TODO add your handling code here:
        /**This will hide or show "Comments" field and resize the Jframe*/
        MainUI muu=new MainUI();
        erroLbl.setText("");

        if(commentsJtxtArea.isVisible()){      
            commentsJtxtArea.setVisible(false);
            commentsScPane.setVisible(false);
            this.setSize(176, 211);
        }else{
            commentsScPane.setVisible(true);
            commentsJtxtArea.setVisible(true);
            jPanel1.revalidate();
            jPanel1.repaint();
            this.setSize(469, 211);
        }
    }//GEN-LAST:event_commentBtnActionPerformed

    /**On pressing any key in 'W' field, will clear the error label.*/
    private void wTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_wTxtKeyPressed
        // TODO add your handling code here:
      
            erroLbl.setText("");
     
    }//GEN-LAST:event_wTxtKeyPressed
/**On pressing any key in 'H' field, will clear the error label.*/
    private void hTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hTxtKeyPressed
        // TODO add your handling code here:
        erroLbl.setText("");
    }//GEN-LAST:event_hTxtKeyPressed

    /**on releasing any key in "W" field, will validate if the data is Integers or not.
     and select/deselect the related check box*/
    private void wTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_wTxtKeyReleased
        // TODO add your handling code here:
        if(!validateInt(wTxt.getText())){
            erroLbl.setText("Kindly fill 'W' field with Integres");
            wBox.setSelected(false);
        }else{
            wBox.setSelected(true);
        }
    }//GEN-LAST:event_wTxtKeyReleased

    /**on releasing any key in "H" field, will validate if the data is Integers or not.
     and select/deselect the related check box*/
    private void hTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hTxtKeyReleased
        // TODO add your handling code here:
        if(!validateInt(hTxt.getText())){
            erroLbl.setText("Kindly fill 'H' field with Integres");
            hBox.setSelected(false);
        }else{
            hBox.setSelected(true);
        }
    }//GEN-LAST:event_hTxtKeyReleased

    private void previewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewBtnActionPerformed
        // TODO add your handling code here:
      this.setAlwaysOnTop(false);
        preview();
      

    }//GEN-LAST:event_previewBtnActionPerformed

    private void previewMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewMenuActionPerformed
        // TODO add your handling code here:
        this.setAlwaysOnTop(false);
        preview();
    }//GEN-LAST:event_previewMenuActionPerformed

    private void newSessionMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newSessionMenuActionPerformed
        // TODO add your handling code here:
        newSession();
    }//GEN-LAST:event_newSessionMenuActionPerformed

    private void saveMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuActionPerformed
        // TODO add your handling code here:
        save();
    }//GEN-LAST:event_saveMenuActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        newSession();

    }//GEN-LAST:event_deleteActionPerformed

    /**On closing window will check if there's unsaved screenshots or not and show confirmation message*/
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if(isFileSaved==true){
            newSession(); //delete all screenshots and reset the storing array
            System.exit(0);
        }else{
            this.setAlwaysOnTop(false);
            int result=JOptionPane.showConfirmDialog(null, "There are unsaved screenshots, Are you sure to exit?","Confirm Exit", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE );
            if(result==JOptionPane.YES_OPTION){
                newSession();
                System.exit(0);
            }else{
                this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            }
        }
        
    }//GEN-LAST:event_formWindowClosing

    /**Browsing to get where to save word file*/
    private void browseFileNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseFileNameActionPerformed
        // TODO add your handling code here:
        this.setAlwaysOnTop(false);
        FileDialog fDialog = new FileDialog(this,"Save", FileDialog.SAVE);
        fDialog.setFile("Word File");
        fDialog.setVisible(true);
        //validate if the file name has extension or not.
        //if not, get the file directory and select file name check box 
        String fileName=fDialog.getFile();
        if(fileName.contains(".")){
            this.setAlwaysOnTop(false);
            JOptionPane.showMessageDialog(null, "you can't insert '.' in File Name");
            fileNameTxt.setText("");
            fileBox.setSelected(false);
        }else{
            String dir = fDialog.getDirectory();
            String path=dir+fileName;
            fileNameTxt.setText(path);
            fileBox.setSelected(true);
        }
    }//GEN-LAST:event_browseFileNameActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
        this.setAlwaysOnTop(true);
    }//GEN-LAST:event_formWindowGainedFocus

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        
         try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FullSc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FullSc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FullSc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FullSc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
//        FullSc ss=new FullSc();
       

        
//        System.out.println("Decorated?!"+ss.isUndecorated());
         this.setAlwaysOnTop(false);
         this.setState(1);
        FullSc.getObj().setVisible(true);
        
//        this.setState(0);
//        this.foc
//        FloatingOnArea fa=new FloatingOnArea();
//        fa.setVisible(true);
//         ss.setUndecorated(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**Taking the screenshot and save it as png file.
     @param  shotNameString Screenshot name
     @exception AWTException 
     @exception  HeadlessException
     @exception  IOException*/
    
    public void takingShot(String shotNameString){
        try{
            
            Robot robot = new Robot();
 
            Rectangle rectangle = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage bufferedImage = robot.createScreenCapture(rectangle);
            File file = new File(shotName+".png");           
            boolean status = ImageIO.write(bufferedImage, "png", file);
            
            erroLbl.setText("Captured");
            shotName=shotName+1; //increase shot name counter
            isFileSaved=false; //marked as there's unsaved data
        }catch(AWTException | HeadlessException | IOException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    /**Will check if comment is displayed and has the correct data or not
     @param  shotName Screenshot name*/
    public void validateComment(String shotName){
        if(commentsJtxtArea.isVisible()){
            String commentV=commentsJtxtArea.getText();
            System.out.println("Comment is: "+commentsJtxtArea.getText());
            if(commentV.isEmpty()){
                erroLbl.setText("you can't take screenshot without entering a comment.");
            }else{
                String comments=commentsJtxtArea.getText();
                storing.setArr(shotName+".png", comments, Integer.parseInt(shotName));
                takingShot(shotName);
                
            }
        }else{
            storing.setArr(shotName+".png", "", Integer.parseInt(shotName));
            takingShot(shotName);
            
        }
    }
    
    /**Validate if the value is Integer or not, by trying to parse to Int
     @param  validateV  the value to be validated
     @return boolean*/
    public boolean validateInt(String validateV){
        boolean validInt=false;
        try{
            if(!validateV.isEmpty()){
                 Integer.parseInt(validateV);
            }
            validInt=true;
        }catch(Exception e){
            validInt=false;
        }
        return validInt;
    }
    
    /**creating new session by deleting all taken screenshot, reset the storing array
     reset shot name counter and marked as all data is saved.*/
    public void newSession(){
         storing.arrayValidator();
            for(int j=0;j<200;j++){
                File shotFile=new File(StoringCommShots.arr[0][j]);
                shotFile.delete();
            }
            erroLbl.setText("New session started.");
            commentsJtxtArea.setText("");
            storing.resetArr();
            shotName=0;
            isFileSaved=true;
            ImgView.iv=null;
    }
   
    /**Saving screenshot and Its comments to word file
     * will validate file name, W and H fields then calling the method which write to word.
     */
    public void save(){
         this.setSize(733, 211);
        String fileName=fileNameTxt.getText();
            String w=wTxt.getText();
            String h=hTxt.getText();
            if(fileName.isEmpty()){
                erroLbl.setText("Kindly fill 'File Name' field");
                return;
            }else if(w.isEmpty()){
              
                erroLbl.setText("Kindly Fill 'W' Field");
                return;
            }else if(h.isEmpty()){
            
                erroLbl.setText("Kindly Fill 'H' field");
                return;
            }
        if(hBox.isSelected()&&wBox.isSelected()&&fileBox.isSelected()){

            writtingToWord wt=new writtingToWord(fileName,Integer.parseInt(w),Integer.parseInt(h));
            erroLbl.setText("Word File is created successfully.");
            isFileSaved=true;
            newSession();
            erroLbl.setText("Word file has been created and new session started.");
        }else if(!hBox.isSelected()){
            erroLbl.setText("Kindly fill 'H' field with Integres");
        }else if(!wBox.isSelected()){
            erroLbl.setText("Kindly fill 'W' field with Integres");
        }else if(!fileBox.isSelected()){
            erroLbl.setText("'Field Name' field has invalid value");
        }
    }
    
    /**open Img preview JFrame and IF it's open, It will be bring to front.*/
    public void preview(){
          ImgView.getObj().setVisible(true);      
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
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
               UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");

//            }
           
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseFileName;
    private javax.swing.JButton captureBtn;
    private javax.swing.JButton commentBtn;
    private javax.swing.JTextArea commentsJtxtArea;
    private javax.swing.JScrollPane commentsScPane;
    private javax.swing.JButton delete;
    private javax.swing.JLabel erroLbl;
    private javax.swing.JCheckBox fileBox;
    private javax.swing.JTextField fileNameTxt;
    private javax.swing.JCheckBox hBox;
    private javax.swing.JTextField hTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JMenuItem newSessionMenu;
    private javax.swing.JButton previewBtn;
    private javax.swing.JMenuItem previewMenu;
    private javax.swing.JButton save;
    private javax.swing.JMenuItem saveMenu;
    private javax.swing.JCheckBox wBox;
    private javax.swing.JTextField wTxt;
    // End of variables declaration//GEN-END:variables
}

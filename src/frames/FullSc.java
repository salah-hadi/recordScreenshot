/*
will capture full screen and user can select which area to capture.
 */

package frames;

import imageViewer.ImgView;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;
import recordscreenshot.StoringCommShots;

/**
 *
 * @author hp
 */
public class FullSc extends javax.swing.JFrame {

    /**
     * Creates new form FullSc
     */
    public FullSc() {
        try {
            setUndecorated(true);
            initComponents();
            setExtendedState(this.MAXIMIZED_BOTH);
            fullScImg.setOpaque(false);
            x = y = x2 = y2 = 0; //
            MainUI.getObj().setState(1);
            takingShot();
            MainUI.getObj().setState(0);
            MainUI.getObj().setAlwaysOnTop(false);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            imgLbl.setIcon(new ImageIcon(new ImageIcon("fullScreen.png").getImage().getScaledInstance(fullScImg.getWidth(), fullScImg.getHeight(), Image.SCALE_SMOOTH)));
            imgLbl.setSize((int)screenSize.getWidth(), (int)screenSize.getHeight());
        } catch (IOException ex) {
            Logger.getLogger(FullSc.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(null, ex);
        }

    }
    int x, y, x2, y2, pw, ph;
    int cx,cy,cx2,cy2,cw,ch;
    
    public static FullSc area=null;
     public static FullSc getObj(){
        if(area==null){
            area=new FullSc();
        }
        return area;
    }
     
     public int xValue(){
         return x;
         
     }
      public int yValue(){
         return y;
         
     }
       public int pwValue(){
         return pw;
         
     }
        public int phValue(){
         return ph;
         
     }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fullScImg = new javax.swing.JPanel();
        imgLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        fullScImg.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                fullScImgMouseDragged(evt);
            }
        });
        fullScImg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fullScImgMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                fullScImgMouseReleased(evt);
            }
        });

        imgLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        imgLbl.setPreferredSize(new java.awt.Dimension(1366, 768));

        javax.swing.GroupLayout fullScImgLayout = new javax.swing.GroupLayout(fullScImg);
        fullScImg.setLayout(fullScImgLayout);
        fullScImgLayout.setHorizontalGroup(
            fullScImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fullScImgLayout.createSequentialGroup()
                .addComponent(imgLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        fullScImgLayout.setVerticalGroup(
            fullScImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fullScImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fullScImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        File img=new File("fullScreen.png");
        img.delete();
              

    }//GEN-LAST:event_formWindowClosing

    private void fullScImgMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fullScImgMouseReleased
        setEndPoint(evt.getX(), evt.getY());
        repaint();
        PopUpDemo menu = new PopUpDemo();
        menu.show(fullScImg, x2, y2);
        

    }//GEN-LAST:event_fullScImgMouseReleased

    private void fullScImgMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fullScImgMousePressed
        setStartPoint(evt.getX(), evt.getY());
    }//GEN-LAST:event_fullScImgMousePressed

    private void fullScImgMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fullScImgMouseDragged
        setEndPoint(evt.getX(), evt.getY());
        repaint();
    }//GEN-LAST:event_fullScImgMouseDragged

     public void setStartPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setEndPoint(int x, int y) {
            x2 = (x);
            y2 = (y);
        }

        public void drawPerfectRect(Graphics g, int x, int y, int x2, int y2) {
            int px = Math.min(x,x2);
            int py = Math.min(y,y2);
            pw=Math.abs(x-x2);
            ph=Math.abs(y-y2);
            g.setColor(Color.RED);
            g.drawRect(px, py, pw, ph);
        }

        public void clearRect(){
            cx=x;
            cy=y;
            cx2=x2;
            cy2=y2;
            cw=pw;
            ch=ph;
            x=y=x2=y2=0;
            repaint();
            
        }
 
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(x==0&&y==0&x2==0&&y2==0){
            g.drawRect(x, y, x2, y2);
            
        }else{
            drawPerfectRect(g, x, y, x2, y2);
        }
    }
    
    private void takingShot(){
        try{
            
            Robot robot = new Robot();
 
            Rectangle rectangle = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage bufferedImage = robot.createScreenCapture(rectangle);
            File file = new File("fullScreen.png");           
            boolean status = ImageIO.write(bufferedImage, "png", file);

        }catch(AWTException  | IOException e){
            this.setAlwaysOnTop(false);
//            JOptionPane.showMessageDialog(null, e);
                int result=JOptionPane.showConfirmDialog(null, e.toString(),"Error", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE );
                if(result==JOptionPane.OK_OPTION){
                    FullSc.getObj().close();
                }else{
                        FullSc.getObj().close();
                }
        }
    }
   
    public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEve­ntQueue().postEvent(winClosingEvent);
        area=null;
        
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
                UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FullSc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel fullScImg;
    public javax.swing.JLabel imgLbl;
    // End of variables declaration//GEN-END:variables
}

class PopUpDemo extends JPopupMenu {
    public PopUpDemo() {
        JMenuItem save = new JMenuItem("Save");
        save.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
//                    throw new IOException();
                    
                    File shotFile=new File("fullScreen.png");
                    InputStream shotFile1=Files.newInputStream(Paths.get(shotFile.getAbsolutePath()));
                    BufferedImage bufferedImage = ImageIO.read(shotFile1);
                    BufferedImage crooped=bufferedImage.getSubimage(FullSc.getObj().xValue(), FullSc.getObj().yValue(), FullSc.getObj().pwValue(), FullSc.getObj().phValue()); 
                    ImageIO.write(crooped, "png", new File(MainUI.shotName+".png"));
                    shotFile1.close();
                    StoringCommShots storing=new StoringCommShots();
                    storing.setArr(MainUI.shotName+".png", "", MainUI.shotName);
                    MainUI.shotName=MainUI.shotName+1; //increase shot name counter
                    MainUI.isFileSaved=false; //marked as there's unsaved data
                   
                    FullSc.getObj().close();
                    
                    ImgView.getObj().setVisible(true);
                    ImgView.getObj().openLast();
                    
                } catch (IOException ex) {
                    Logger.getLogger(PopUpDemo.class.getName()).log(Level.SEVERE, null, ex);
                    FullSc.getObj().setAlwaysOnTop(false);
                     int result=JOptionPane.showConfirmDialog(null, ex.toString(),"Error", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE );
                     if(result==JOptionPane.OK_OPTION){
                         FullSc.getObj().close();
                     }else{
                         FullSc.getObj().close();
                     }
                }
            }
            
        });
        
        JMenuItem reCapture = new JMenuItem("Recapture");
        reCapture.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FullSc.getObj().clearRect();
            }
        });
        
        
        
        JMenuItem cancel = new JMenuItem("Cancel");
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FullSc.getObj().close();
                    MainUI.getObj().setAlwaysOnTop(true);
                } catch (IOException ex) {
                    Logger.getLogger(PopUpDemo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
//        JMenuItem email = new JMenuItem("Send By E-mail");
        add(save);
        add(reCapture);
        add(cancel);
//        add(email);
        
    }
    
    
}

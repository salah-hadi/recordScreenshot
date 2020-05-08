/*
 *Writting to word file
 */
package recordscreenshot;

import frames.MainUI;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/**
 *
 * @author Salah
 */
public class writtingToWord extends MainUI{
    
    /**Will create or update word document
     @param fileName Word file name
     @param w Image width in word
     @param h Image Hight in word
     * @throws java.io.IOException*/
    public writtingToWord(String fileName,int w,int h) throws IOException{
        try{
            storing.arrayValidator();
            XWPFDocument document=null;
            File f=new File(fileName);
            boolean existing=f.exists();
            if(existing==true){
                document = new XWPFDocument(OPCPackage.open(fileName));
            }else{
                document = new XWPFDocument(); 
            }

            FileOutputStream out = new FileOutputStream( new File(fileName+"1"));
            XWPFParagraph pa=document.createParagraph();
            XWPFRun run=pa.createRun();
//            run.setText("Start document");
            run.addCarriageReturn();
            File imgFile;
            String imgFileName;
            FileInputStream sl=null;
            String arrayVal0;
            String arrayVal1;
                for(int j=0;j<200;j++){
                    storing.arrayValidator();
                    arrayVal0=StoringCommShots.arr[0][j];
                    arrayVal1=StoringCommShots.arr[1][j];
                   
                        if(arrayVal1.isEmpty()&&!arrayVal0.isEmpty()){
                            imgFile=new File(arrayVal0);
                            imgFileName=imgFile.getName();
                            sl=new FileInputStream(imgFile);
                            run.addPicture(sl, XWPFDocument.PICTURE_TYPE_PNG, imgFileName, Units.toEMU(w), Units.toEMU(h));
                             run.addCarriageReturn();

                        }else if(!arrayVal1.isEmpty()&&!arrayVal0.isEmpty()){

                            if(arrayVal1.contains("\n")){
                                String[] stringsOnNewLines = arrayVal1.split( "\n" );
                                for ( int i = 0; i < stringsOnNewLines.length; i++ ) {

                                    // For every run except last one, add a carriage return.
                                    String textForLine = stringsOnNewLines[i];
                                    if ( i < stringsOnNewLines.length - 1 ) {
                                        run.setText(textForLine);
                                        run.addCarriageReturn();
                                    }
                                    else {
                                        run.setText(textForLine);
                                        run.addCarriageReturn();
                                    }
                                }
                            }else{
                                run.setText(arrayVal1);
                            }

                            run.addCarriageReturn();

                            imgFile=new File(arrayVal0);
                            imgFileName=imgFile.getName();
                            sl=new FileInputStream(imgFile);
                            run.addPicture(sl, XWPFDocument.PICTURE_TYPE_PNG, imgFileName, Units.toEMU(w), Units.toEMU(h));
                             run.addCarriageReturn();
                        }
                    }
               
//            run.setText("END of Doc.");

            document.write(out);
            out.close();
            sl.close();
            document.close();
            File f3=new File(fileName+"1");
           if(f3.exists()){
               File f5=new File(fileName);
               if(f5.exists()){
                   f5.delete();
               }
               
               //renaming file after finising
               File f4=new File(fileName);
               if(f3.renameTo(f4)){
               }

               
           }
            storing.afterArrValidator();
        }catch(FileNotFoundException e){
            MainUI.getObj().setAlwaysOnTop(false);
            JOptionPane.showMessageDialog(null, e);
            MainUI.getObj().setAlwaysOnTop(true);
        }catch(IOException | InvalidFormatException io){
             MainUI.getObj().setAlwaysOnTop(false);
            JOptionPane.showMessageDialog(null, io);
            MainUI.getObj().setAlwaysOnTop(true);
        }
        
    }
}

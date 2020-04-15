/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recordscreenshot;

import frames.MainUI;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/**
 *
 * @author Salah
 */
public class writtingToWord extends MainUI{
    
    public writtingToWord(){
        try{
            storing.arrayValidator();
            XWPFDocument document = new XWPFDocument(); 		
            //Write the Document in file system
            FileOutputStream out = new FileOutputStream( new File("createdocumentv3.docx"));
            XWPFParagraph pa=document.createParagraph();
            XWPFRun run=pa.createRun();
            run.setText("Start document");
            run.addCarriageReturn();
            //looping this section
            File imgFile;
            String imgFileName;
            FileInputStream sl=null;
            String arrayVal0;
            String arrayVal1;
//            for(int i=0;i<2;i++){
                for(int j=0;j<100;j++){
//                    storing.displayArr();
                    storing.arrayValidator();
                    arrayVal0=StoringCommShots.arr[0][j];
                    arrayVal1=StoringCommShots.arr[1][j];
                   
                        if(arrayVal1.isEmpty()&&!arrayVal0.isEmpty()){
                            imgFile=new File(arrayVal0);
                            imgFileName=imgFile.getName();
                            sl=new FileInputStream(imgFile);
                            run.addPicture(sl, XWPFDocument.PICTURE_TYPE_PNG, imgFileName, Units.toEMU(500), Units.toEMU(500));
                             run.addCarriageReturn();

                        }else if(!arrayVal1.isEmpty()&&!arrayVal0.isEmpty()){
                            run.setText(arrayVal1);
                            run.addCarriageReturn();

                            imgFile=new File(arrayVal0);
                            imgFileName=imgFile.getName();
                            sl=new FileInputStream(imgFile);
                            run.addPicture(sl, XWPFDocument.PICTURE_TYPE_PNG, imgFileName, Units.toEMU(500), Units.toEMU(500));
                             run.addCarriageReturn();
                        }
//                        sl.close();
                    }
                
//            }
//            File imgFile1=new File("0.png");
//            String imgFile=imgFile1.getName();
            
//              BufferedImage bimg1 = ImageIO.read(imgFile1);
//              int width = bimg1.getWidth();
//              int height = bimg1.getHeight();
            
//            FileInputStream sl=new FileInputStream(imgFile1);
            
//            run.addCarriageReturn();
//            run.setText("test 22");
            
//            run.addPicture(sl, XWPFDocument.PICTURE_TYPE_PNG, imgFile, Units.toEMU(500), Units.toEMU(500));
//            sl.close();
//            run.a
///End of loop
//            run.addCarriageReturn();
            run.setText("END of Doc.");

            document.write(out);
            
            out.close();
            sl.close();
            document.close();
//            System.out.println("createdocument.docx written successully");
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException io){
            System.out.println(io);
        }catch(InvalidFormatException oo){
            System.out.println(oo);
        }
        
    }
//    public void addImg(){}
    
}

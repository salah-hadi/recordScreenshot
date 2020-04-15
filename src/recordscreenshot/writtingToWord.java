/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recordscreenshot;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.text.Document;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/**
 *
 * @author Salah
 */
public class writtingToWord{
    static{
        try{
            XWPFDocument document = new XWPFDocument(); 		
            //Write the Document in file system
            FileOutputStream out = new FileOutputStream( new File("createdocument.docx"));
            XWPFParagraph pa=document.createParagraph();
            XWPFRun run=pa.createRun();
            run.setText("hello paragraph");
            
            File imgFile1=new File("0.png");
            String imgFile=imgFile1.getName();
            
              BufferedImage bimg1 = ImageIO.read(imgFile1);
              int width = bimg1.getWidth();
              int height = bimg1.getHeight();
            
            FileInputStream sl=new FileInputStream(imgFile1);
            
            run.addCarriageReturn();
//            run.setText("test 22");
            
            run.addPicture(sl, XWPFDocument.PICTURE_TYPE_PNG, imgFile, Units.toEMU(500), Units.toEMU(500));
//            sl.close();
//            run.a
run.addCarriageReturn();
run.setText("helllo");

            document.write(out);
            
            out.close();
            sl.close();
            document.close();
            System.out.println("createdocument.docx written successully");
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException io){
            System.out.println(io);
        }catch(InvalidFormatException oo){
            System.out.println(oo);
        }
        
    }
    
}

/*
This will extract file format from its name */
package recordscreenshot;

/**
 *
 * @author Salah
 */
public class FileFormat {
    
    private String format(String name){
        String fileName=name.toLowerCase();
        String extension="doesn't have an extension";
        if(fileName.equals("png")){
            extension="png";
        }else if(fileName.equals("jpeg")){
            extension="jpeg";
        }else if(fileName.equals("gif")){
            extension="gif";
        }else if(fileName.equals("ico")){
            extension="ico";
        }else if(fileName.equals("jpg")){
            extension="jpg";
        }else if(fileName.equals("ps")){
            extension="ps";
        }else if(fileName.equals("psd")){
            extension="psd";
        }else if(fileName.equals("svg")){
            extension="svg";
        }else if(fileName.equals("tif")){
            extension="tif";
        }else if(fileName.equals("tiff")){
            extension="tiff";
        }else if(fileName.equals("mp3")){
            extension="mp3";
        }else if(fileName.equals("mpa")){
            extension="mpa";
        }else if(fileName.equals("ogg")){
            extension="ogg";
        }else if(fileName.equals("wav")){
            extension="wav";
        }else if(fileName.equals("avi")){
            extension="avi";
        }else if(fileName.equals("flv")){
            extension="flv";
        }else if(fileName.equals("m4v")){
            extension="m4v";
        }else if(fileName.equals("mkv")){
            extension="mkv";
        }else if(fileName.equals("mp4")){
            extension="mp4";
        }else if(fileName.equals("mpg")){
            extension="mpg";
        }else if(fileName.equals("mpeg")){
            extension="mpeg";
        }else if(fileName.equals("wmv")){
            extension="wmv";
        }else if(fileName.equals("doc")){
            extension="doc";
        }else if(fileName.equals("docx")){
            extension="docx";
        }else if(fileName.equals("odt")){
            extension="odt";
        }else if(fileName.equals("pdf")){
            extension="pdf";
        }else if(fileName.equals("tex")){
            extension="tex";
        }else if(fileName.equals("txt")){
            extension="txt";
        }else if(fileName.equals("wpd")){
            extension="wpd";
        }else if(fileName.equals("ods")){
            extension="ods";
        }else if(fileName.equals("xls")){
            extension="xls";
        }else if(fileName.equals("xlsm")){
            extension="xlsm";
        }else if(fileName.equals("xlsx")){
            extension="xlsx";
        }else if(fileName.equals("key")){
            extension="key";
        }else if(fileName.equals("odp")){
            extension="odp";
        }else if(fileName.equals("pps")){
            extension="pps";
        }else if(fileName.equals("ppt")){
            extension="ppt";
        }else if(fileName.equals("pptx")){
            extension="pptx";
        }else if(fileName.equals("php")){
            extension="php";
        }else if(fileName.equals("xhtml")){
            extension="xhtml";
        }else if(fileName.equals("asp")){
            extension="asp";
        }else if(fileName.equals("aspx")){
            extension="aspx";
        }else if(fileName.equals("csv")){
            extension="csv";
        }else if(fileName.equals("xml")){
            extension="xml";
        }else if(fileName.equals("iso")){
            extension="iso";
        }else if(fileName.equals("zip")){
            extension="zip";
        }else if(fileName.equals("rpm")){
            extension="rpm";
        }else if(fileName.equals("rar")){
            extension="rar";
        }else if(fileName.equals("7z")){
            extension="7z";
        }
        return extension;
    }
    
    /*return the format*/
    public String getFormat(String fileName){
        String extension="doesn't have an extension";
        if(fileName.contains(".")){
            int length=fileName.length();
            int pointIndex=0;
            for(int i=length-1;i>0;i--){
                if(fileName.charAt(i)=='.'){
                    pointIndex=i;
                    break;
                }
            }   
            if(pointIndex!=0||pointIndex!=length-1){
                extension=format(fileName.substring(pointIndex+1,length));
            }else{
                extension ="Enter a valid file";
            }            
            
            
        }
           return extension;
    }
    
}

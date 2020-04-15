/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recordscreenshot;

/**
 *
 * @author Salah
 */
public class StoringCommShots {
    public static String[][] arr=new String[2][100];
    public void setArr(String shot, String comment, int i){
        arr[0][i]=shot;
        arr[1][i]=comment;
    }
    public void displayArr(){
        for(int i=0;i<2;i++){
            for(int j=0;j<100;j++){
                System.out.println(arr[i][j]);
            }
        }
    }
    
    public void arrayValidator(){
        for(int i=0;i<2;i++ ){
            for(int j=0;j<100;j++){
                if(isNull(arr[i][j])){
                    arr[i][j]="";
                }
                
                
            }
        }
    }
    public boolean isNull(String validate){
        boolean nn=false;
        try{
            if(validate.equals(null)){
                nn=true;
            }else{
                nn=false;
            }
            
        }catch(NullPointerException n){
            nn=true;
            
        }
        return nn;
    }
    
    
}

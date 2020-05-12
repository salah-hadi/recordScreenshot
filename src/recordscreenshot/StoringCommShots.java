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
 * under the License. */
package recordscreenshot;

/**
 *
 * @author Salah
 */
public class StoringCommShots {
    
    public static String[][] arr=new String[2][200]; //2D storing array to store screenshots on row 0 and comments on row 1
    
    /**Passing value to array
     @param shot Screenshot name
     @param  comment Comment name*/
    public void setArr(String shot, String comment, int i){
        arr[0][i]=shot;
        arr[1][i]=comment;
    }
    
    /**display the stored array to console.*/
    public void displayArr(){
        for(int i=0;i<2;i++){
            for(int j=0;j<200;j++){
                System.out.println(arr[i][j]);
            }
        }
    }
    
    /**Remove all every null from the array and replace it with an empty value.*/
    public void arrayValidator(){
        for(int i=0;i<2;i++ ){
            for(int j=0;j<200;j++){
                if(isNull(arr[i][j])){
                    arr[i][j]="";
                }
                
                
            }
        }
    }
    
    /**will reset the array after the operation needs arrayValidator has passed by setting all empty values to null*/
    public void afterArrValidator(){
        
            for(int j=0;j<200;j++){
                if(arr[0][j].isEmpty()){// if screenshot row is empty then make comments and screenshots row null
                    arr[0][j]=null;
                    arr[1][j]=null;
                }
                
                
            }
        
    }
    /**check if the entered value equal null or not
     @param  validate  the value you want to validate
     @return null or not*/
    private boolean isNull(String validate){
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
    
    /**will return number of screenshots by checking the null value in screenshots row
     @return  No stored images.*/
    public int imgsNum(){
        int noOfimgs=0;
        for(int i=0;i<200;i++){
            if(isNull(arr[0][i])){
                noOfimgs=i;
                break;
            }else if(i==199){
                noOfimgs=i+1;
            }
            
        }
        return noOfimgs;
    }
    
    /**retrun the last index in array
     @return  arrayIndex*/
    public int getLastIndex(){
        return imgsNum()-1;
    }
    
    /**clear all array data and reset it to null*/
    public void resetArr(){
        for(int i=0;i<2;i++){
            for(int j=0;j<200;j++)
            {
                arr[i][j]=null;
            }
        }
    }
    
}

package com.easyjob.utils;
import   java.io.InputStreamReader;  
import   java.io.BufferedReader;  
public class TestUrl {
	
	   
      public   static   void   main(String[]   args)   {  
          String   str=getMacOnWindow();  
          System.out.println("---"+str+"++++");  
      }  
      private   static   String   getMacOnWindow()   {  
          String   s   =   "";  
          try{  
        	  String s1 = "ipconfig   /all";  
        	  Process   process   =   Runtime.getRuntime().exec(s1);  
        	  BufferedReader bufferedreader  =  new BufferedReader(  
                          new InputStreamReader(process.getInputStream()));  
        	  String   nextLine;  
        	  for(String line = bufferedreader.readLine();line != null;line=nextLine){  
                  nextLine   =   bufferedreader.readLine();  
                  if(line.indexOf("Physical   Address")<=0){  
                	  continue;  
                  }  
                  int i = line.indexOf("Physical   Address") + 36;  
                  s=line.substring(i);  
                  break;  
              }  
              bufferedreader.close();  
              process.waitFor();  
          }catch(Exception e){  
        	  e.printStackTrace();
        	  s = "";  
          }  
          return s.trim();  
      }  
	   

}

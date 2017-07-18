package com.test.utilities;

import java.io.*;

public class FileIO {
	
	public static String getFileDataFromResources(String fileName){
    	ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    	InputStream is = classloader.getResourceAsStream(fileName);
    	ByteArrayOutputStream result = new ByteArrayOutputStream();
    	String s = "";
    	byte[] buffer = new byte[1024];
    	int length;
    	try {
			while ((length = is.read(buffer)) != -1) {
			    result.write(buffer, 0, length);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    	try {
			s = result.toString("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    	
    	return s;		
	}
	
    public static String readBatchTextFile(String fileName) {
        String line = null;
        StringBuilder sb = new StringBuilder();

        try {
            FileReader fileReader = 
                new FileReader(fileName);

             BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }   

            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(ex);                  
        }
        
        return sb.toString();
    }
    
    public static void writeBatchTextFile(String fileName, String data) {
        try {
            FileWriter fileWriter =
                new FileWriter(fileName);

            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);

            bufferedWriter.write(data);
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
        }
    }    
}
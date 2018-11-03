package com.test.utilities;

import org.springframework.stereotype.Component;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.FileNotFoundException;

@Component
public class IOUtils {
	
	public String getFileDataFromResources(String fileName){
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
	
	// ".//src//main//resources//Outfile.txt" will be read from resources, and etc.
    public String readBatchTextFile(String fileName) {
        String line = null;
        StringBuilder sb = new StringBuilder();

        try {
            FileReader fileReader = 
                new FileReader(fileName);

             BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
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
    
    // ".//src//main//resources//Outfile.txt" will be written to resources, and etc.
    public void writeBatchTextFile(String fileName, String data) {
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
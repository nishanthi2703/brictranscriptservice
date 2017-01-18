package com.fmr.bric.transcriptservice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

public class FileUtils {
	
	TranscriptService transcriptService;
	
    public FileUtils() { }

    /**
     * The number of bytes in a kilobyte.
     */
    public static final long ONE_KB = 1024;

    /**
     * The number of bytes in a megabyte.
     */
    public static final long ONE_MB = ONE_KB * ONE_KB;

    /**
     * The number of bytes in a gigabyte.
     */
    public static final long ONE_GB = ONE_KB * ONE_MB;
    
   /* public void base64Encode() {
    	File audioFile = new File("C:\\HackathonVideo\\r.wav");
    	byte[] bytes = readContentIntoByteArray(audioFile);
    	
    	//byte[] bytes = FileUtils.readFileToByteArr(audioFile);
    	String encode = Base64.encodeBase64String(bytes);
    	transcriptService.convertTranscriptFile(encode);
    	
    }*/

    
    public static byte[] readContentIntoByteArray(File file)
	{
		FileInputStream fileInputStream = null;
		byte[] bFile = new byte[(int) file.length()];
		try
		{
			//convert file into array of bytes
			fileInputStream = new FileInputStream(file);
			fileInputStream.read(bFile);
			fileInputStream.close();
			for (int i = 0; i < bFile.length; i++)
			{
				//bFile[i];
				System.out.print((char) bFile[i]);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return bFile;
	}


    public static String readFileToString(
            File file, String encoding) throws IOException {
        InputStream in = new java.io.FileInputStream(file);
        try {
            return IOUtils.toString(in, encoding);
        } finally {
            IOUtils.closeQuietly(in);
        }
    }
    
    public static byte[] readFileToByteArr(File file) throws IOException {
           InputStream in = null;
    	 try {
    	             in = new FileInputStream(file);
    	             return IOUtils.toByteArray(in);
    	         } finally {
    	             IOUtils.closeQuietly(in);
    	         }
    	    }

    
    
    private static String getStringFromInputStream(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

               br = new BufferedReader(new InputStreamReader(is));
               while ((line = br.readLine()) != null) {
                     sb.append(line);
               }

        } catch (IOException e) {
               e.printStackTrace();
        } finally {
               if (br != null) {
                     try {
                            br.close();
                     } catch (IOException e) {
                            e.printStackTrace();
                     }
               }
        }

        return sb.toString();

 }



    }


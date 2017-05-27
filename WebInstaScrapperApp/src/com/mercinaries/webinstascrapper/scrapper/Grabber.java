package com.mercinaries.webinstascrapper.scrapper;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Grabber {
	
	public static String grab(String link) throws IOException{
		String baseUrl="https://instagram.com/";
		URL url = new URL(baseUrl+link);
		URLConnection conn = url.openConnection();
		BufferedReader connReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line ="";
		StringBuilder content = new StringBuilder();
		
		while((line=connReader.readLine())!= null){
			content.append(line+"\r\n");
		}
		return content.toString();
	}
	
//	public static String regg(String content) throws IOException{
//		
//		return null;
//	}
	
	public static void downloadImag(String path,String fileName) throws IOException{
		URL url = new URL (path);
		URLConnection conn = url.openConnection();
		
		InputStream is = conn.getInputStream();
		FileOutputStream os = new FileOutputStream(fileName);
		
		byte[] data = new byte[1024];
		int i =0;
		while ((i=is.read(data))!= -1){
			os.write(data, 0, i);
		}
		os.close();
		is.close();
		
	}

}

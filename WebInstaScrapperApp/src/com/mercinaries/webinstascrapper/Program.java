package com.mercinaries.webinstascrapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mercinaries.webinstascrapper.scrapper.Grabber;

public class Program {

	public static void main(String[] args) {
		
		System.out.println("Instagram picture scrapping");
		System.out.println("For Educational purpose only");
		System.out.println("******************************************************");
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the user name: ");
			String link = reader.readLine();
			String content = Grabber.grab(link);
			System.out.println("Downloading ..............");
			String box = content;
			String regEx= "https://(.*?).jpg";
			
			Pattern pattern = Pattern.compile(regEx);
			Matcher match = pattern.matcher(box);
			while(match.find()){
				String imgpath = match.group(0);
				String path = (imgpath);
				
				String[] tokens = path.split("/");
				
				File file1 = new File("d:/javatest/insta/");
				if(!file1.isDirectory()){
					file1.mkdirs();
				}
				File file2 = new File("d:/javatest/insta/"+link);
				if(!file2.isDirectory()){
					file2.mkdirs();
				}
				Grabber.downloadImag(path,"d:/javatest/insta/"+link+"/"+tokens[tokens.length-1] );
				
				
			System.out.println("Done");
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

}

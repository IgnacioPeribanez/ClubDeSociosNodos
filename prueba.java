package clubDeSocios;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class prueba {
	public static void main(String[] arg) {
		 try {
			  
	            // Create a file object
	            File f = new File("C:\\Users\\Salesianos\\Desktop\\1ºGS\\PROGRAMACIÓN\\PRACTICANODO");
	  
	            // Get all the names of the files present
	            // in the given directory
	            File[] files = f.listFiles();
	  
	            System.out.println("Files are:");
	  
	            // Display the names of the files
	            for (int i = 0; i < files.length; i++) {
	                System.out.println(files[i].getName());
	            }
	        }
	        catch (Exception e) {
	            System.err.println(e.getMessage());
	        }
	    }
	}


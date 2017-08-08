/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrary.dao;

import com.mycompany.dvdlibrary.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author KylePackard
 */
public class DVDDao {
    
    ArrayList<DVD> myDVDCollection = new ArrayList<DVD>();
    public static final String DVD_FILE = "dvd.txt";
    public static final String DELIMITER = "::";
    
    public void addDvdToLibrary(DVD newDvd){
        myDVDCollection.add(newDvd);
        
        
    }
    
    //Returns **All** Current DVD's in myDVDCollection
    public ArrayList returnDVDList(){
        ArrayList<DVD> listToReturn = new ArrayList<DVD>();
        
        
        for(DVD d : myDVDCollection){
            DVD add = new DVD();
            add = d;
            listToReturn.add(add);
            
            
        }
        return listToReturn;
        
    }
    //Returns a DVD List of all DVD's with a specitic title
    //----usefull for multiple entries with same title
    public ArrayList<DVD> returnDVDListByTitle(String title){
        ArrayList<DVD> list = new ArrayList<DVD>();
        list = returnDVDList();
        ArrayList<DVD> listByTitle = new ArrayList<DVD>();
        
        for(DVD l: list){
            if (title.equals(l.getTitle())){
                listByTitle.add(l);
            }
         
        }
        return listByTitle;
    }
    
    public void deleteDVD(int i){
        myDVDCollection.remove(i);
         }
    
    public void editDVD(int indexToDelete, DVD editedDvd){
        deleteDVD( indexToDelete);
        addDvdToLibrary(editedDvd);
        
        
    }
    
    public void loadDVD() throws DVDException {
	    Scanner scanner;
	    
	    try {
	        scanner = new Scanner(
	                new BufferedReader(
	                        new FileReader(DVD_FILE)));
	    } catch (FileNotFoundException e) {
	        throw new DVDException(
	                "-_- Could not load roster data into memory.", e);
	    }
	    
	    String currentLine;
	

	    String[] currentTokens;
	
	    while (scanner.hasNextLine()) {
	      
	        currentLine = scanner.nextLine();
	     
	        currentTokens = currentLine.split(DELIMITER);
	      
	        DVD currentDVD = new DVD();
	       
                
                currentDVD.setTitle(currentTokens[0]);
                currentDVD.setDirectiorName(currentTokens[1]);
                currentDVD.setStudio(currentTokens[2]);
                currentDVD.setRating(currentTokens[3]);
                currentDVD.setReleaseDate(currentTokens[4]);
                currentDVD.setUserRating(currentTokens[5]);

	        myDVDCollection.add(currentDVD);
	    }

	    scanner.close();
	}
	public void writeDVD() throws DVDException {
	    // NOTE FOR APPRENTICES: We are not handling the IOException - but
	    // we are translating it to an application specific exception and 
	    // then simple throwing it (i.e. 'reporting' it) to the code that
	    // called us.  It is the responsibility of the calling code to 
	    // handle any errors that occur.
	    PrintWriter out;
	    
	    try {
	        out = new PrintWriter(new FileWriter(DVD_FILE));
	    } catch (IOException e) {
	        throw new DVDException(
	                "Could not save DVD data.", e);
	    }
	    
	    // Write out the Student objects to the roster file.
	    // NOTE TO THE APPRENTICES: We could just grab the student map,
	    // get the Collection of Students and iterate over them but we've
	    // already created a method that gets a List of Students so
	    // we'll reuse it.

	    for (DVD currentDVD : myDVDCollection) {
	        // write the Student object to the file
	        out.println(currentDVD.getTitle() + DELIMITER
	                + currentDVD.getDirectiorName() + DELIMITER 
	                + currentDVD.getStudio() + DELIMITER
	                + currentDVD.getRating() + DELIMITER
                        + currentDVD.getReleaseDate() + DELIMITER
                        + currentDVD.getUserRating());
	        
	        out.flush();
            }
	    out.close();
	}
    
}

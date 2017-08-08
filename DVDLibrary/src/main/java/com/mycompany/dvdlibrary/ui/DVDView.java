/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrary.ui;

import com.mycompany.dvdlibrary.dto.DVD;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author KylePackard
 */
public class DVDView {

    //UserIO IO = new UserIOImpl();

    private UserIO IO;

    public DVDView(UserIO IO) {
    this.IO = IO;
}

    public int userMenuSelection() {
        //IO.print("Welcome to the DVD Library");
        IO.print("**** Main Menu ****");
        IO.print("1. Add a new DVD to the Library");
        IO.print("2. Remove a DVD from the Library");
        IO.print("3. Edit an existing DVD");
        IO.print("4. List all DVD's");
        IO.print("5. Find DVD by Title");
        IO.print("6. List all Info of DVD");
        IO.print("7. Load DVD's from file");
        IO.print("8. Save");
        IO.print("9. Exit");
        int answer = IO.readInt("Choose your option", 1, 9);
        IO.print("");
        return answer;
    }

    public void printWelcomeMenu() {
        IO.print("Welcome to the DVD Library\n");
    }

    public DVD getDvdToAdd() {
        DVD dvdToAdd = new DVD();
        String title = IO.readString("Title: ");
        String releaseDate = IO.readString("Release Date: ");
        String rating = IO.readString("MPAA Rating: ");
        String directorName = IO.readString("Director: ");
        String studio = IO.readString("Studio: ");
        String userRating = IO.readString("What is your rating of this movie (Comments Welcome)");

        dvdToAdd.setDirectiorName(directorName);
        dvdToAdd.setReleaseDate(releaseDate);
        dvdToAdd.setStudio(studio);
        dvdToAdd.setTitle(title);
        dvdToAdd.setUserRating(userRating);
        dvdToAdd.setRating(rating);
        IO.print("");
        return dvdToAdd;
    }

    public void printAddedDvdMenu() {
        IO.print("DVD Sucessfully Added to Library...\n");
    }

    public void printAllDVDTitles(ArrayList<DVD> list) {

        if (list.isEmpty()) {
            IO.print("** No DVD's with that title **");
        } else {
            IO.print("DVD Title:");
            for (DVD l : list) {
                IO.print(l.getTitle());
            }
        }
        IO.print("");
    }

    public void printDVDTitleMenu() {
        IO.print("** All DVD's in your library **");
    }

    public String titleSearch() {
        return IO.readString("Search By Title: ");
    }



    public int pickDVDFromList(ArrayList<DVD> list) {
        String userSearch = titleSearch();
        int i, option;
        option = 1;
        int j = list.size();
        HashMap map = new HashMap();

        if (list.isEmpty()){
            IO.print("ERROR: No DVD's witht that title..");
            return -1;
        }
        else{

        for (i = 0; i < j; i++) {
            if (userSearch.equals(list.get(i).getTitle())) {
                IO.print(option + ". " + list.get(i).getTitle());
                map.put(option, i);
                option++;
            }
        }
        }

        if (option != 1){

        int userChoice = IO.readInt("Select: (1-" + (option - 1) + ")", 1, (option - 1));
        Object pickedDVD = map.get(userChoice);
        String pickedDVDString = pickedDVD.toString();
        int index = Integer.parseInt(pickedDVDString);
        //Formatting print
        IO.print("");
        return index;
        }
        else {
            IO.print("** No Dvd's with that title **");
            return -1;
        }
    }


    public void printDeleteMenu() {
        IO.print("** Pick the DVD you wish to Delete **");
    }

    public void printDeletedDVD() {
        IO.print("** DVD sucessfully deleted **\n");
    }

    public void editDVDMenu() {
        IO.print("** Pick the DVD you wish to Edit **");
    }

    public void editDVDMenuEdit() {
        IO.print("* Enter new information for the edited DVD *");

    }

    public void getDVDToAddMenu() {
        IO.print("** Create new DVD in library **");
    }

    public void displayDVDInfo(ArrayList<DVD> dvdArray, int indexToDisplay) {

        IO.print("Title: " + dvdArray.get(indexToDisplay).getTitle());
        IO.print("MPAA Rating: " + dvdArray.get(indexToDisplay).getRating());
        IO.print("Director: " + dvdArray.get(indexToDisplay).getDirectiorName());
        IO.print("Studio: " + dvdArray.get(indexToDisplay).getStudio());
        IO.print("Relsease Date: " + dvdArray.get(indexToDisplay).getReleaseDate());
        IO.print("User Rating: " + dvdArray.get(indexToDisplay).getUserRating() + "\n");

    }

    public void DVDInfoMenu() {
        IO.print("****DVD Information****");
    }

    public void printNoDVD() {
        IO.print("No DVD's of that title");
    }
}

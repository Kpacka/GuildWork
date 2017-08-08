/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrary.controller;

import com.mycompany.dvdlibrary.dao.DVDDao;
import com.mycompany.dvdlibrary.dto.DVD;
import com.mycompany.dvdlibrary.ui.DVDView;
import com.mycompany.dvdlibrary.ui.UserIO;
import com.mycompany.dvdlibrary.ui.UserIOImpl;
import java.util.ArrayList;

/**
 *
 * @author KylePackard
 */
public class DVDController {

    UserIO IO = new UserIOImpl();
    DVDView view;
    DVDDao dao;

    public DVDController(DVDDao dao, DVDView view) {
        this.dao = dao;
        this.view = view;
    }

    public void executable() throws Exception {
        view.printWelcomeMenu();
        boolean again = true;

        while (again) {

            int userChoice = view.userMenuSelection();
            switch (userChoice) {
                case 1:
                    addDVD();
                    break;
                case 2:
                    deleteDVD();
                    break;
                case 3:
                    editDVD();
                    break;
                case 4:
                    printDvdTitles();
                    break;
                case 5:
                    returnDVDByTitle();
                    break;
                case 6:
                    listDVDInfo();
                    break;
                case 7:
                    loadDVDLibrary();
                    break;
                case 8:
                    saveDVDLibrary();
                    break;
                case 9:
                    again = false;
                    break;
            }
        }
        IO.print("Exiting Program..");
    }

    public void addDVD() {
        DVD newDVD = new DVD();
        view.getDVDToAddMenu();
        newDVD = view.getDvdToAdd();
        dao.addDvdToLibrary(newDVD);
        view.printAddedDvdMenu();
    }

    public void printDvdTitles() {
        view.printDVDTitleMenu();
        view.printAllDVDTitles(dao.returnDVDList());

    }

    public void returnDVDByTitle() {

        view.printAllDVDTitles(dao.returnDVDListByTitle(view.titleSearch()));

    }

    public void deleteDVD() {

        view.printDeleteMenu();

        ArrayList dvdList = new ArrayList();
        dvdList = dao.returnDVDList();
        int indexToDelete = view.pickDVDFromList(dvdList);
        if (indexToDelete != -1) {

            dao.deleteDVD(indexToDelete);
            view.printDeletedDVD();
        }

    }

    public void editDVD() {

        ArrayList dvdList = new ArrayList();
        dvdList = dao.returnDVDList();

        view.editDVDMenu();

        int indexToDelete = view.pickDVDFromList(dvdList);

        if (indexToDelete != -1) {

        
            view.editDVDMenuEdit();

            DVD EditedDVD = new DVD();
            EditedDVD = view.getDvdToAdd();

            dao.editDVD(indexToDelete, EditedDVD);
        }

    }

    public void listDVDInfo() {

        ArrayList dvdList = new ArrayList();
        dvdList = dao.returnDVDList();
        int indexToDisplay = view.pickDVDFromList(dvdList);
        if (indexToDisplay == -1) {

        } else {
            view.DVDInfoMenu();

            view.displayDVDInfo(dvdList, indexToDisplay);
        }
    }

    public void saveDVDLibrary() throws Exception {
        dao.writeDVD();
    }

    public void loadDVDLibrary() throws Exception {
        dao.loadDVD();

    }
}

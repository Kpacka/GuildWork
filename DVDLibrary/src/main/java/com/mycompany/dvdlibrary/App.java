/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrary;

import com.mycompany.dvdlibrary.controller.DVDController;
import com.mycompany.dvdlibrary.dao.DVDDao;
import com.mycompany.dvdlibrary.ui.DVDView;
import com.mycompany.dvdlibrary.ui.UserIO;
import com.mycompany.dvdlibrary.ui.UserIOImpl;

/**
 *
 * @author KylePackard
 */
public class App {

    public static void main(String[] args) throws Exception {

        UserIO myIo = new UserIOImpl();
        DVDView myView = new DVDView(myIo);
        DVDDao myDao = new DVDDao();
        DVDController controller
                = new DVDController(myDao, myView);
        controller.executable();

    }

}

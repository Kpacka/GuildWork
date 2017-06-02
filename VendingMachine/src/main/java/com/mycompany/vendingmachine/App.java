/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine;

import com.mycompany.vendingmachine.controller.VendingMachineController;
import com.mycompany.vendingmachine.dao.VendingMachineDao;
import com.mycompany.vendingmachine.dao.VendingMachineDaoImpl;
import com.mycompany.vendingmachine.service.VendingLogic;
import com.mycompany.vendingmachine.service.VendingLogicImpl;
import com.mycompany.vendingmachine.view.UserIO;
import com.mycompany.vendingmachine.view.UserIOImpl;
import com.mycompany.vendingmachine.view.View;

/**
 *
 * @author KylePackard
 */
public class App {

    public static void main(String[] args) {
        UserIO myIo = new UserIOImpl();
        View myView = new View(myIo);
        VendingMachineDao myDao = new VendingMachineDaoImpl();
        VendingLogic myLogic = new VendingLogicImpl(myDao);
        VendingMachineController controller
                = new VendingMachineController(myLogic, myView);

        controller.execute();

    }

}

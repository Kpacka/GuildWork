/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.controller;

import com.mycompany.vendingmachine.dao.VendingMachinePersistenceException;
import com.mycompany.vendingmachine.service.InsufficientFundsException;
import com.mycompany.vendingmachine.service.InsufficientStockException;
import com.mycompany.vendingmachine.service.VendingLogic;
import com.mycompany.vendingmachine.view.View;


/**
 *
 * @author KylePackard
 */
public class VendingMachineController {

    View view;
    VendingLogic logic;

    public VendingMachineController(VendingLogic logic, View view) {
        this.logic = logic;
        this.view = view;
    }

    public void execute() {

        try {
            boolean again = true;
            boolean userAgain;
            while (again) {
                
                userAgain = true;

                view.prinTopMenu();
                view.printInventory(logic.getInventory());
                view.printExit();
                view.printCurrentMoney(logic.currentMoney());
                view.printBottomLine();
              
                while (userAgain) {
                    try {
                        logic.saveMoney(view.getInsertedMoney());
                        userAgain = false;
                    } catch (Exception e) {
                        userAgain = true;
                    }
                }
                
                int selection = view.getUserSelection();
                if (selection == view.getMax()) {
                    again = false;
                    continue;
                }
                
                logic.getUserSelection(selection);

                try {
                    
                    runConditionals();
                    
                } catch (InsufficientFundsException | InsufficientStockException e) {
                    view.displayErrorMessage(e.getMessage());
                }

            }
        } catch (VendingMachinePersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }

    }

    private void runConditionals() throws VendingMachinePersistenceException,
            InsufficientFundsException,
            InsufficientStockException {
        if (logic.getIndex() == -1) {

            logic.resetPrice();
            view.printChange(logic.returnChange());
            logic.resetMoney();

        } else if (logic.sufficentFunds() && logic.sufficientStock()) {

            view.printChange(logic.returnChange());
            logic.updateInventory();
            view.printEnjoyItem();
            logic.resetMoney();

        } else if (!logic.sufficentFunds() && logic.sufficientStock()) {

            throw new InsufficientFundsException("Not Enough Money");

        } else {

            throw new InsufficientStockException("Item is out of stock");

        }
    }

}

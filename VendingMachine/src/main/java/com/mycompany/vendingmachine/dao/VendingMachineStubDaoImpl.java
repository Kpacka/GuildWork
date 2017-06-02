/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.dao;

import com.mycompany.vendingmachine.dto.Inventory;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author KylePackard
 */
public class VendingMachineStubDaoImpl implements VendingMachineDao {
    
    ArrayList<Inventory> stubList = new ArrayList();
    Inventory newItem = new Inventory();
    
    public VendingMachineStubDaoImpl(){
    newItem.setItemName("KitKat");
    newItem.setPricePerUnit(BigDecimal.ZERO);
    newItem.setStockQuantity(1);
    stubList.add(newItem);
    }
    @Override
    public ArrayList getInventory() throws VendingMachinePersistenceException {
        return stubList;
    }

    @Override
    public Inventory getInventoryItem(int index) throws VendingMachinePersistenceException {
        return stubList.get(index);
    }

    @Override
    public void updateInventoryByOne(int index) throws VendingMachinePersistenceException {
        stubList.get(index).setStockQuantity(stubList.get(index).getStockQuantity() - 1);
    }

    @Override
    public void createInventory(Inventory item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

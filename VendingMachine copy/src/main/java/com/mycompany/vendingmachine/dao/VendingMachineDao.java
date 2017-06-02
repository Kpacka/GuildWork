/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.dao;

import com.mycompany.vendingmachine.dto.Inventory;
import java.util.ArrayList;

/**
 *
 * @author KylePackard
 */
public interface VendingMachineDao {
    
    ArrayList<Inventory> currentList = new ArrayList();
    
    public ArrayList getInventory() throws VendingMachinePersistenceException;
    public Inventory getInventoryItem(int index) throws VendingMachinePersistenceException;
    public void updateInventoryByOne(int index) throws VendingMachinePersistenceException;
    public void createInventory(Inventory item);

    
    
    
}

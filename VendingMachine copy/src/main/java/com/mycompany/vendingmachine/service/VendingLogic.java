/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.service;

import com.mycompany.vendingmachine.dao.VendingMachinePersistenceException;
import com.mycompany.vendingmachine.dto.CoinReturn;
import com.mycompany.vendingmachine.dto.Inventory;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author
 */
public interface VendingLogic {

    BigDecimal currentMoney = BigDecimal.valueOf(0);

    public ArrayList getInventory() throws VendingMachinePersistenceException;

    public void saveMoney(BigDecimal moneyInput);

    public void getInventoryItem(int index) throws VendingMachinePersistenceException;

    public boolean sufficentFunds();

    public CoinReturn returnChange();

    public void resetMoney();

    public BigDecimal getMoney();

    public BigDecimal currentMoney();

    public boolean sufficientStock();

    public void updateInventory() throws VendingMachinePersistenceException;

    public void getUserSelection(int answer) throws VendingMachinePersistenceException;

    public int getIndex();

    public void resetPrice();
    
    public void setPrice(BigDecimal price);

    public Inventory returnInventoryItem();
    
    public BigDecimal getPrice();

}

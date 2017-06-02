/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.service;

import com.mycompany.vendingmachine.dao.VendingMachineDao;
import com.mycompany.vendingmachine.dao.VendingMachinePersistenceException;
import com.mycompany.vendingmachine.dao.VendingMachineStubDaoImpl;
import com.mycompany.vendingmachine.dto.CoinReturn;
import com.mycompany.vendingmachine.dto.Inventory;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jenniferbliss
 */
public class VendingLogicTest {
    
    private VendingLogic service;
   
    public VendingLogicTest() {
        
    VendingMachineDao dao = new VendingMachineStubDaoImpl();
    service = new VendingLogicImpl(dao);
}
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInventory method, of class VendingLogic.
     */
    @Test
    public void testGetInventory() throws Exception {
        
        ArrayList<Inventory> list = service.getInventory();
        assertEquals(1, list.size());
        assertEquals("KitKat", list.get(0).getItemName());
    }

    /**
     * Test of saveMoney method, of class VendingLogic.
     */
    @Test
    public void testSaveMoney() {
        service.saveMoney(BigDecimal.valueOf(1.0));
        BigDecimal money = service.currentMoney();
        assertEquals(BigDecimal.valueOf(1.0), money);
    }

    /**
     * Test of getInventoryItem method, of class VendingLogic.
     */
    @Test
      public void testGetInventoryItem() throws Exception {
        Inventory newItem = new Inventory();
       newItem.setItemName("KitKat");
        newItem.setPricePerUnit(BigDecimal.ZERO);
        newItem.setStockQuantity(1);
        service.getInventoryItem(0);
        Inventory itemToTest = service.returnInventoryItem();
        assertEquals(newItem.getItemName(), itemToTest.getItemName());
        assertEquals(newItem.getPricePerUnit(), itemToTest.getPricePerUnit());
        assertEquals(newItem.getStockQuantity(), itemToTest.getStockQuantity());
        //test sufficientStock
        assertTrue(service.sufficientStock());
        //test updateInventory
        service.updateInventory();
        assertEquals(0, service.returnInventoryItem().getStockQuantity());
    }


    /**
     * Test of returnChange method, of class VendingLogic.
     */
    @Test
    public void testReturnChange() {
        
        service.saveMoney(BigDecimal.valueOf(1.26));
        service.setPrice(BigDecimal.valueOf(1.00));
        
        
        CoinReturn test = service.returnChange();
        
        assertEquals(1, test.getQuarters());
        assertEquals(0, test.getDimes());
        assertEquals(0, test.getNickels());
        assertEquals(1, test.getPennies());
      
    }

    /**
     * Test of resetMoney method, of class VendingLogic.
     */
    @Test
    public void testResetMoney() {
        service.setPrice(BigDecimal.valueOf(1.45));
        service.resetMoney();
        assertEquals(BigDecimal.valueOf(0.0), service.getMoney());
    }

    /**
     * Test of getUserSelection method, of class VendingLogic.
     */
    @Test
    public void testGetUserSelection() throws Exception {
        service.getUserSelection(0);
        assertEquals(0, service.getIndex());
    }

    /**
     * Test of getIndex method, of class VendingLogic.
     */
    @Test
    public void testGetIndex() {
        assertEquals(-1, service.getIndex());
    }

    /**
     * Test of resetPrice method, of class VendingLogic.
     */
    @Test
    public void testResetPrice() {
        service.setPrice(BigDecimal.valueOf(1.00));
        service.resetPrice();
        assertEquals(BigDecimal.valueOf(0.00), service.getPrice());
    }

  
    
}

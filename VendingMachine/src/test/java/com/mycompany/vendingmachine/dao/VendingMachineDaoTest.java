/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.dao;

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
public class VendingMachineDaoTest {
    
    VendingMachineDao dao = new VendingMachineDaoStubImplForDaoTest();
    
    ArrayList<Inventory> list = new ArrayList();
    
    public VendingMachineDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws VendingMachinePersistenceException {
        
            list = dao.getInventory();

    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInventory method, of class VendingMachineDao.
     */
    
    @Test
    public void testGetName() throws VendingMachinePersistenceException{
        Inventory item = dao.getInventoryItem(0);
        assertEquals("Poptart", item.getItemName());
    }
    @Test
    public void testGetter() throws Exception {
        
        Inventory item = new Inventory();
        item.setItemName("KitKat");
        
        assertEquals("KitKat", item.getItemName());
    }
    
    @Test
    public void testReduceInventory() throws VendingMachinePersistenceException{
        ///Must Reset inventory.txt Item at index[0]-stockQuantity to 1
        //private method writeInventory() is the culpurit
        dao.updateInventoryByOne(0);  
        assertEquals(0, dao.getInventoryItem(0).getStockQuantity());
    }
    

    /**
     * Test of getInventoryItem method, of class VendingMachineDao.
     */
    @Test
    public void testGetInventoryItem() throws Exception {
        
        
        Inventory item = new Inventory();
        item = dao.getInventoryItem(1);
        assertEquals(item, dao.getInventoryItem(1));
        
    }

    /**
     * Test of updateInventoryByOne method, of class VendingMachineDao.
     */
    @Test
    public void testUpdateInventoryByOne() throws Exception {
    }

    /**
     * Test of createInventory method, of class VendingMachineDao.
     */
    @Test
    public void testCreateInventory() {
    }


    
}

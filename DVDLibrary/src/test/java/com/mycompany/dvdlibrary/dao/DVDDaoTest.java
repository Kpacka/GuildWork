/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrary.dao;

import com.mycompany.dvdlibrary.dto.DVD;
import static java.util.Collections.list;
import java.util.HashSet;
import java.util.List;
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
public class DVDDaoTest {
    
    DVDDao dao = new DVDDao();
    
    public DVDDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        List<DVD> dvdList = dao.returnDVDList();
        for (DVD dvd: dvdList){
            dvdList.remove(dvd);
        }
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addDvdToLibrary method, of class DVDDao.
     */
    @Test
    public void testAddDvdToLibrary() {
        DVD dvd1 = new DVD();
        dvd1.setTitle("Hello");
        dvd1.setStudio("World");
        dvd1.setDirectiorName("This");
        dvd1.setReleaseDate("Is");
        dvd1.setUserRating("Kyle");
        dvd1.setRating("Packard");
        
        dao.addDvdToLibrary(dvd1);
        DVD dvdtotest = dao.myDVDCollection.get(0);
        int size = dao.myDVDCollection.size();
        
        assertEquals(dvd1, dvdtotest);
        assertEquals(1, size);
        
        
    }

    /**
     * Test of returnDVDList method, of class DVDDao.
     */
    @Test
    public void testReturnDVDList() {
        DVD dvd1 = new DVD();
        dvd1.setTitle("Hello");
        dvd1.setStudio("World");
        dvd1.setDirectiorName("This");
        dvd1.setReleaseDate("Is");
        dvd1.setUserRating("Kyle");
        dvd1.setRating("Packard");
        
        dao.addDvdToLibrary(dvd1);
        
        DVD dvd2 = new DVD();
        dvd2.setTitle("Hello");
        dvd2.setStudio("World");
        dvd2.setDirectiorName("This");
        dvd2.setReleaseDate("Is");
        dvd2.setUserRating("Kyle");
        dvd2.setRating("Packard");
        
        dao.addDvdToLibrary(dvd2);
        List<DVD> list = dao.returnDVDListByTitle("Hello");
        assertEquals(2,list.size());
    }

    /**
     * Test of returnDVDListByTitle method, of class DVDDao.
     */
    @Test
    public void testReturnDVDListByTitle() {
    }

    /**
     * Test of deleteDVD method, of class DVDDao.
     */
    @Test
    public void testDeleteDVD() {
    }

    /**
     * Test of editDVD method, of class DVDDao.
     */
    @Test
    public void testEditDVD() {
    }

    /**
     * Test of loadDVD method, of class DVDDao.
     */
    @Test
    public void testLoadDVD() throws Exception {
    }

    /**
     * Test of writeDVD method, of class DVDDao.
     */
    @Test
    public void testWriteDVD() throws Exception {
    }
    
}

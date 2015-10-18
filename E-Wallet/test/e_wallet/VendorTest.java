/* Class to test the function in class Vendor
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package e_wallet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sam
 */
public class VendorTest {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
   
    @Test
    public void testGetId() {
        System.out.println("getId");
        Vendor instance = new Vendor();
        instance.setId(10);
        int expResult = 10;
        int result = instance.getId();
        
        assertEquals(expResult, result);
        
    }

    
    /**
     * Test of getName method, of class Vendor.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Vendor instance = new Vendor();
        instance.setName("borkars");
        String expResult = "borkars";
        String result = instance.getName();
        assertEquals(expResult, result);
       
    }

    
    /**
     * Test of getUname method, of class Vendor.
     */
    @Test
    public void testGetUname() {
        System.out.println("getUname");
        Vendor instance = new Vendor();
        instance.setUname("bk123");
        String expResult = "bk123";
        String result = instance.getUname();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPassword method, of class Vendor.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Vendor instance = new Vendor();
        instance.setPassword("2222");
        String expResult = "2222";
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEwbalance method, of class Vendor.
     */
    @Test
    public void testGetEwbalance() {
        System.out.println("getEwbalance");
        Vendor instance = new Vendor();
        instance.setEwbalance(2000);
        double expResult = 2000;
        double result = instance.getEwbalance();
        assertEquals(expResult, result, 0.05);
    }



   
}

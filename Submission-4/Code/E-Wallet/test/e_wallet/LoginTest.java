/*
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
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Sam
 */
public class LoginTest {
    
    public LoginTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        Controller.db.create("mongi", "mg", "1234");
        Controller.db.create("ram", "0000", "2222", 3333);
    }
    
    @AfterClass
    public static void tearDownClass() {
        Controller.db.delete(1,"0000");
        Controller.db.delete(2,"mg");
    }
    
    Login l,lv;
    
    @Before
    public void setUp() {
     
    
    l =  new Login("0000",Controller.toHash("2222"));
    lv = new Login("mg", Controller.toHash("1234"));
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of resultStudent method, of class Login.
     */
    @Test
    public void testResultStudent() {

        System.out.println("resultStudent");
        
       
        assertTrue(l.resultStudent());
       
    }

    /**
     * Test of resultVendor method, of class Login.
     */
    @Test
    public void testResultVendor() {
        System.out.println("resultVendor");
       
         assertTrue(lv.resultVendor());
    }

    /**
     * Test of getStudentName method, of class Login.
     */
    @Test
    public void testGetStudentName() {
        System.out.println("getStudentName");
        
        String expResult = "ram";
        String result = l.getStudentName();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getVendorName method, of class Login.
     */
    @Test
    public void testGetVendorName() {
        System.out.println("getVendorName");
        
        String expResult = "mongi";
        String result = lv.getVendorName();
        assertEquals(expResult, result);
        
    }
    
}

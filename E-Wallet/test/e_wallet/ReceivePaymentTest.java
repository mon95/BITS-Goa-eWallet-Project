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

/**
 *
 * @author Sam
 */
public class ReceivePaymentTest {
    
    public ReceivePaymentTest() {
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
    
    ReceivePayment rpo;
    
    @Before
    public void setUp() {
        rpo = new ReceivePayment("mg", 120);
        
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of checkAmount method, of class ReceivePayment.
     */
    @Test
    public void testCheckAmount() {
        System.out.println("checkAmount");
        
        double amount = 100.0;
        Student student = Controller.db.getStudent("0000");
        assertFalse(rpo.checkAmount(amount, student));
    }

    /**
     * Test of transferAmount method, of class ReceivePayment.
     */
    @Test
    public void testTransferAmount() {
        System.out.println("transferAmount");
        
        Student student = Controller.db.getStudent("0000");
        double amount = 100.0;
        int pin = 3333;
        Double oldEwBalance = rpo.vendor.getEwbalance();
        String result = rpo.transferAmount(student, amount, pin);
        assertEquals(oldEwBalance+100.0, rpo.vendor.getEwbalance(), 0.05);
        
    }
    
}

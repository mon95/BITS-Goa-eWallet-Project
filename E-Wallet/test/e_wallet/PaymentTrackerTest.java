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
public class PaymentTrackerTest {
    
    public PaymentTrackerTest() {
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
    PaymentTracker ps;
    PaymentTracker pv;
    @Before
    public void setUp() {
        ps = new PaymentTracker("0000");
        pv = new PaymentTracker("mg");
    }
    
    @After
    public void tearDown() {
        
    }

    /**
     * Test of initiateTransaction method, of class PaymentTracker.
     */
    @Test
    public void testInitiateTransaction() {
        System.out.println("initiateTransaction");
        double amount = 120.0;
      //  PaymentTracker instance = new PaymentTracker();
        ReceivePayment expResult = new ReceivePayment("mg",120.0);
        ReceivePayment result = pv.initiateTransaction(amount);
        
        assertEquals(expResult.vendor.getEwbalance(), result.vendor.getEwbalance(), 0.05);
        Controller.db.deleteLog(Controller.transactionID);
        Controller.db.deleteLog(Controller.transactionIDStudent);
    }
    

    /**
     * Test of initiateRecharge method, of class PaymentTracker.
     */
    @Test
    public void testInitiateRecharge() {
        System.out.println("initiateRecharge");
        double amount = 500;
        //PaymentTracker instance = new PaymentTracker();
        Recharge expResult = new Recharge("0000");
        Recharge result = ps.initiateRecharge(amount);
        //assertEquals(expResult, result);
        assertEquals(expResult.student.getEWBalance(), result.student.getEWBalance(), 0.05);
        Controller.db.deleteLog(Controller.transactionIDStudent);
    }
    
}

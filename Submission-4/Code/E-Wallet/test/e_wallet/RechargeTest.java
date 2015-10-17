/**
 * 
 */
package e_wallet;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import e_wallet.Controller;
/**
 * @author mon
 *
 */
public class RechargeTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
                Controller.db.create("mongi", "mg", "1234");
		Controller.db.create("ram", "0000", "2222", 3333);
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
            Controller.db.delete(1,"0000");
            Controller.db.delete(2,"mg");
	}
        
	/**
	 * @throws java.lang.Exception
	 */
	
	Recharge r;
	
	@Before
	public void setUp() throws Exception {
		//r = new Recharge("1111");
            r = new Recharge("0000");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
            
	}

	
	 /**
	 * Test method for {@link e_wallet.Recharge#checkAmount(int)}.
	 */
	@Test
	public final void testCheckAmount() {
			assertTrue(r.checkAmount(0));
	}
        
	/**
	 * Test method for {@link e_wallet.Recharge#checkCreditAmount(int)}.
	 */
	@Test
	public final void testCheckCreditAmount() {
		assertFalse(r.checkCreditAmount(50000));
	}

	/**
	 * Test method for {@link e_wallet.Recharge#rechargeAccount(int, int)}.
	 */
	@Test
	public final void testRechargeAccount() {
                Double oldEwbalance = r.student.ewbalance;
		//String result = r.rechargeAccount(10, 1234);
                String result = r.rechargeAccount(10, 3333);
		String expected = "The new E-Wallet Balance for "+"0000"+" is Rs."+Double.toString(oldEwbalance + 10)+"\nReturning back to the main menu.\n";
		assertEquals(expected, result);
		         
	}

	/**
	 * Test method for {@link e_wallet.Recharge#takeCredit(int, int)}.
	 */
	@Test
	public final void testTakeCredit() {
		
        Double oldBalance = r.student.ewbalance;
	//String result = r.takeCredit(3, 1234);
	String result = r.takeCredit(11000, 3333);
        
	String expected = "The new E-Wallet Balance for "+"0000"+" is Rs."+Double.toString(oldBalance+11000)+"\nReturning back to the main menu.\n";
	assertEquals(expected, result);
        
        
	}
        
       


}

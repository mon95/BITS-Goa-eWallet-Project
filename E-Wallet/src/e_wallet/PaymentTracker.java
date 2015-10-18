package e_wallet;

import java.util.*;

/**
 *
 * @author Sam
 */
public class PaymentTracker {
	
	String lcred;
	int balance;
	int amount;

	Student student;
	Vendor vendor;
	
        /**
        *
        */
        public PaymentTracker(){
	}
        
    /**
     *
     * @param lcred
     */
        public PaymentTracker(String lcred){
		this.lcred = lcred;
	}
	
    /**
     *
     * @param amount
     * @return
     */
        public ReceivePayment initiateTransaction(double amount){
		vendor = Controller.db.getVendor(lcred);
		Controller.transactionID = Controller.db.createLog(lcred,amount, new Date(),1);
		ReceivePayment rpobject = new ReceivePayment(lcred, amount);
		return rpobject;
		
	}

    /**
     *
     * @param amount
     * @return
     */
    public Recharge initiateRecharge(double amount){
		student = Controller.db.getStudent(lcred);
		Controller.transactionIDStudent = Controller.db.createLog(lcred, amount, new Date(),0);
		Recharge robject = new Recharge(lcred);
		return robject;
	}
}

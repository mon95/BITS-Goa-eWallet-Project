/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package e_wallet;

import java.util.Date;

/**
 *
 * @author Sam
 */
public class ReceivePayment {
    
    	private String bits_id;
	private String lcred;
	private String password;
	private double amount;
	private int pin;
	Vendor vendor;
	Student student;
	String update;

    /**
     *
     * @param lcred
     * @param amount
     */
    public ReceivePayment(String lcred, double amount){
                Controller.trycount=0;
		this.lcred=lcred;
		this.amount=amount;
		this.vendor = Controller.db.getVendor(lcred);
		
	}
        
    /**
     *
     * @param amount
     * @param student
     * @return
     */
    public boolean checkAmount(double amount,Student student){
            return amount<=student.ewbalance;
        }
        
    /**
     *
     * @param student
     * @param amount
     * @param pin
     * @return
     */
    public String transferAmount(Student student,double amount,int pin){
            PaymentTracker pt = new PaymentTracker();
                    if(Controller.db.verifyPIN(student,pin)){
                            student.loyaltyBonus+=(int)(amount/100);
                            student.ewbalance-=amount;
                            vendor.ewbalance+=amount;
                            Controller.db.updateBalance(student.bits_id, student.ewbalance, student.swdbalance);
                            Controller.db.updatelb(student.bits_id, student.loyaltyBonus);
                            Controller.db.updateLog(Controller.transactionID,student.bits_id,new Date(),1);
                            Controller.db.updateLog(Controller.transactionID,"Amount Transferred", new Date(),vendor.ewbalance);
                            Controller.trycount=10;
                            Controller.warning=0;
                            Controller.transactionIDStudent = Controller.db.createLog(student.bits_id, amount, new Date(), 1);
                            Controller.db.updateLog(Controller.transactionIDStudent,vendor.uname,new Date(),1);
                            Controller.db.updateLog(Controller.transactionIDStudent,"Amount Transferred", new Date(), student.ewbalance);
                            return Controller.db.updateBalance(lcred, vendor.ewbalance);
                            
                            
                        }
                    else{
                            update = " Incorrect pin input x"+(++Controller.trycount);
                            Controller.db.updateLog(Controller.transactionID,update, new Date(),vendor.ewbalance);
                            Controller.warning = 1;
                            return "The Entered PIN is incorrect.You have"+(3-Controller.trycount)+" tries left";
                    }
        }
}
    


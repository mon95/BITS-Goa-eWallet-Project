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
    public class Recharge {
    
        private String bits_id;
	private double amount;
	private int pin;
	Student student;
	
	String update;
        boolean valid=true;
	
    /**
     *
     * @param bits_id
     */
    public Recharge(String bits_id){
                Controller.trycount=0;
		this.bits_id=bits_id;
		this.student = Controller.db.getStudent(bits_id);
	}
        
    /**
     *
     * @param amount
     * @return
     */
    public boolean checkAmount(double amount){
            return amount<=student.swdbalance;
        }
        
    /**
     *
     * @param amount
     * @return
     */
    public boolean checkCreditAmount(double amount){
            return (amount-student.swdbalance)<=student.credit_avail;
        }
        
    /**
     *
     * @param amount
     * @param pin
     * @return
     */
    public String rechargeAccount(double amount,int pin){
            
            PaymentTracker pt = new PaymentTracker();
            if(Controller.db.verifyPIN(student,pin)){
                    student.ewbalance+=amount;
                    student.swdbalance-=amount;
                    //update = "\nRecharge for Rs."+amount+" successfully completed.\nNew Balance: Rs."+student.ewbalance;
                    Controller.db.updateLog(Controller.transactionIDStudent,null,new Date(), 1);
                    Controller.db.updateLog(Controller.transactionIDStudent,"From SWD", new Date(), student.ewbalance);
                    Controller.trycount=10;
                    Controller.warning = 0;
                    return Controller.db.updateBalance(student.bits_id, student.ewbalance, student.swdbalance);
                    
            }   
            else{
                    update = " Incorrect pin input x"+Controller.trycount+1;
                    Controller.db.updateLog(Controller.transactionIDStudent,update, new Date(), student.ewbalance);
                    Controller.trycount++;
                    Controller.warning = 1;
                    return "The Entered PIN is incorrect.You have"+(3-Controller.trycount)+" tries left";
                                
            }
        }

    /**
     *
     * @param amount
     * @param pin
     * @return
     */
    public String takeCredit(double amount,int pin){
            
            PaymentTracker pt = new PaymentTracker();
            if(Controller.db.verifyPIN(student,pin)){
                student.ewbalance+=amount;
                /*Controller.db.deleteLog();
                Controller.transactionID = Controller.db.createLog(student.bits_id,student.swdbalance, new Date(),0);
                Controller.db.updateLog(Controller.transactionID,null,new Date(),1);
                Controller.db.updateLog(Controller.transactionID,"From SWD", new Date());*/
                amount-=student.swdbalance;
		student.swdbalance=0;
		student.credit_avail-=amount;
		//update = "\nCredits Availed Rs."+amount+".\nNew Balance: Rs."+student.ewbalance;
                Controller.db.updateLog(Controller.transactionIDStudent,null,new Date(),1);
                Controller.db.updateLog(Controller.transactionIDStudent,"Credit Availed Rs."+amount, new Date(), student.ewbalance);
		Controller.trycount = 10;
                Controller.warning=0;
                return Controller.db.updateBalance(student.bits_id, student.ewbalance, student.swdbalance, student.credit_avail);
            }   
            else{
                
                update = " Incorrect pin input x"+(++Controller.trycount);
                Controller.db.updateLog(Controller.transactionIDStudent,update, new Date(), student.ewbalance);
                Controller.warning=1;
                return "The Entered PIN is incorrect.You have"+(3-Controller.trycount)+" tries left";
            }   
        }
}

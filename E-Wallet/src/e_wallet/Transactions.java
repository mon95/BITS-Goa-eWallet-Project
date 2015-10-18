/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package e_wallet;

/**
 *
 * @author Sam
 */


public class Transactions {
	public int id;
	public String from;
	public String to;
        double amount;
	public String start;
	public String end;
        public int type;
        public double balance;
        String comments;
        int completion;
		
        public int getId() {
	return id;
	}
	public void setId(int id) {
	this.id = id;
	}
	public String getFrom() {
	return from;
	}
	public void setFrom(String from) {
	this.from = from;
	}
	public String getTo() {
	return to;
	}
	public void setTo(String to) {
	this.to = to;
	}
        public double getAmount() {
	return amount;
	}
	public void setAmount(double amount) {
	this.amount = amount;
	}
	public String getStart() {
	return start;
	}
	public void setStart(String start) {
	this.start = start;
	}
	public String getEnd() {
	return end;
	}
	public void setEnd(String end) {
	this.end = end;
	}
	public int getType() {
	return type;
	}
	public void setType(int type) {
	this.type = type;
	}
        public double getBalance() {
	return balance;
	}
	public void setBalance(double balance) {
	this.balance = balance;
	}
        public String getComments() {
	return comments;
	}
	public void setComments(String comments) {
	this.comments = comments;
	}
        public int getCompletion() {
	return completion;
	}
	public void setCompletion(int completion) {
	this.completion = completion;
	}
}



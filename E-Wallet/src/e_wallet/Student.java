package e_wallet;

public class Student {
	public int id;
	public String name;
	public String bits_id;
	public String password;
	public int pin;
	public double ewbalance;
	public double credit_avail;
	public double swdbalance;
	public int loyaltyBonus;
	
	public int getLoyaltyBonus() {
		return loyaltyBonus;
	}
	public void setLoyaltyBonus(int loyaltyBonus) {
		this.loyaltyBonus = loyaltyBonus;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBits_id() {
		return bits_id;
	}
	public void setBits_id(String bits_id) {
		this.bits_id = bits_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPIN() {
		return pin;
	}
	public void setPIN(int pin) {
		this.pin = pin;
	}
	public double getEWBalance() {
		return ewbalance;
	}
	public void setEWBalance(double ewbalance) {
		this.ewbalance = ewbalance;
	}
	public double getCredit_avail() {
		return credit_avail;
	}
	public void setCredit_avail(double credit_avail) {
		this.credit_avail = credit_avail;
	}
	public double getSwdbalance() {
		return swdbalance;
	}
	public void setSwdbalance(double swdbalance) {
		this.swdbalance = swdbalance;
	}
	
}

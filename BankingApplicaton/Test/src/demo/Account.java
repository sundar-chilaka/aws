package demo;

public class Account {

	public String name;
	private Double balance=100.11;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the balance
	 */
	public Double getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 * @return 
	 */
	public Double setBalance(Double balance) {
		return this.balance = balance;
	}
	
}

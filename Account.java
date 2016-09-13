public class Account{
	private int accountNumber;
	private double balance;

	public Account(int aN, double b){
		accountNumber = aN;
		balance = b;
	}

	public Account(int aN){
		accountNumber = aN;
		balance = 0.0;
	}

	public int getAccountNumber(){
		return accountNumber;
	}

	public double getBalance(){
		return balance;
	}

	public void setBalance(double b){
		balance = b;
	}

	public void credit(double amount){
		balance += amount;
	}

	public void debit(double amount){
		if(balance>=amount){
			balance -= amount;
		}
		else{
			throw new IllegalArgumentException("Amount withdrawn exceeds current balance!");
		}
	}

	public String toString(){
		return String.format("A/C no:%d, Balance=$%.02f",accountNumber,balance);
	}
}
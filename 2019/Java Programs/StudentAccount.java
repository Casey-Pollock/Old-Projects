/* @author Casey Pollock
 *         Assignment 2
 *         CSCI 2540
 *
 * This class creates and uses StudentAccounts
 * these StudentAccounts are used to keep track of
 * the number of active students, each students account
 * number, and each students account balance.  The number
 * of active accounts will be automatically updated for each
 * new StudentAccount created.  The balance of the accounts 
 * is modifiable.  They can have their balance increased, 
 * decreased, or have some amount transfered between any two 
 * accounts.
*/
package assg3_Pollockc;

public class StudentAccount{

	private long accountNo;
	private double balance;
	private static long activeAcc=0;
	
	/* This method creates a new object that consist of a 
	 * double number and a long number.  The object's long
	 * number will be the account number and the double number
	 * is the balance on the account.  This object will corispond
	 * to a student's account.
	*/
	public StudentAccount(){
	
		this.balance=0;
		this.accountNo=++activeAcc;
	
	}
	/* This method creates a new object that consist of a 
	 * double number and a long number.  The object's long
	 * number will be the account number and the double number
	 * is the balance on the account.  This object will corispond
	 * to a student's account.
	 *
	 * @param bal   this will be the starting balance on the account.
	*/
  	public StudentAccount(double bal){
	
		this.balance=bal;
		this.accountNo=++activeAcc;
	
	}
	/* This method will return a long that will be retrieved
	 * from a StudentAccount.  This long will corrispond to 
	 * the an account number.
	 *
	 * @return  the account number of a given account.
	 * @see     StudentAccount
	*/
	public long getAcctNo(){
	
		return this.accountNo;
	
	}
	/* This method will return a double that will be retrieved
	 * from a StudentAccount.  This double will corrispond to 
	 * the balance on the account.
	 *
	 * @return  the balance fo a given account.
	 * @see     StudentAccount
	*/
	public double getBalance(){
	
		return this.balance;
	
	}
	/* This method will return a long that will be retrieved
	 * from a StudentAccount.  This long will corrispond to 
	 * the number of currently active accounts.
	 *
	 * @return  the numbe of active accounts.
	 * @see     StudentAccount
	*/
	public long getCounter(){
	
		return this.activeAcc;
	
	}
	/* This method will take a double that will become a part
	 * of a given StudentAccount.  This double will become 
	 * the new balance for the account.
	 *
	 * @param bal  the new balance for the StudentAccount.
	 * @see        StudentAccount
	*/
	public void setBalance(double bal){
	
		this.balance=bal;
	
	}
	/* This method will take a positive double and add that to a 
	 * given StudentAccount's account balance.
	 *
	 * @param deposit  a double that will be added to the current
	 *                 account's balance
	 * @see            StudentAccount
	*/
	public void deposit(double deposit){
	
		if(deposit>0){
		
			this.balance=this.balance+deposit;
		
		}
		else{
		
			System.out.println("Error: Invalid value entered.");
		
		}
	
	}
	/* This method will take a positive double and subtract that 
	 * from a given StudentAccount's account balance.
	 *
	 * @param charge  a double that will be subtracted from the 
	 *                current account's balance
	 * @see           StudentAccount
	*/
	public void charge(double charge){
	
		if(charge>0){
		
			this.balance=this.balance-charge;
		
		}
		else{
		
			System.out.println("Error: Invalid value could not be charged");
		
		}
	
	}
	/* This method will take a positive double and transfer it to
	 * the current account from a provided StudentAccount.
	 *
	 * @param amount        a double that will be transfered between
	 *                      two StudentAccount balances.
	 * @param tempStudent   this will be the StudentAccount that the
	 *                      amount will be taken from.
	 * @see                 StudentAccount
	*/
	public void transferIn(StudentAccount tempStudent, double amount){
		
		if(amount>0){
			
			this.deposit(amount);
			tempStudent.charge(amount);
			
		}
		
	}
	/* This method will take a positive double and transfer it from
	 * the current account to a provided StudentAccount.
	 *
	 * @param amount        a double that will be transfered between
	 *                      two StudentAccount balances.
	 * @param tempStudent   this will be the StudentAccount that the
	 *                      amount is recieved by.
	 * @see                 StudentAccount
	*/
	public void transferOut(StudentAccount tempStudent, double amount){
		
		if(amount>0){
			
			this.charge(amount);
			tempStudent.deposit(amount);
		
		}
		
	}
	/* This method will return the String of a StudentAccount. 
	 * The String will consist of the account number and the 
	 * balance on the account.
	 *
	 * @return      the String of a StudentAccount's information.
	 * @override    toString
	 * @see         StudentAccount
	*/
	public String toString(){
	
		return ("Account number:  "+this.accountNo+"\nCurrent Balance: "+this.balance);
	
	}
	/* This method will print out a StudentAccount's information. 
	 * The information will consist of the account number and the 
	 * balance on the account.
	 *
	 * @see         StudentAccount
	*/
	public void printInfo(){
	
		System.out.println("Account number:  "+this.accountNo);
		System.out.println("Current Balance: "+this.balance);
	
	}

}
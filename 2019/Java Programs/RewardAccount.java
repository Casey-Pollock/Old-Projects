/* @author Casey Pollock
 *         Assignment 2
 *         CSCI 2540
 *
 * This class creates and RewardAccounts and extends
 * StudentAccounts.  RewardAccounts are used to keep 
 * track of the number of active students, each students 
 * account number, each students account balance, and
 * each reward accounts balance. The number of active
 * accounts will be automatically updated for each
 * new account created.  The balance of the accounts 
 * is modifiable.  They can have their balance increased, 
 * decreased, or have some amount transfered between any two 
 * accounts.  The reward balance is modified whenever 100 or 
 * more is added to the balance. The reward balance can later 
 * be added to the current balance.
 *
 * @see StudentAccount
*/
package assg3_Pollockc;

public class RewardAccount extends StudentAccount{

	private double reward;
	
	/* This method creates a new object that consist of two 
	 * doubles and a long number.  The object's long
	 * number will be the account number, one of the double numbers
	 * is the balance on the account, and the other double is a reward 
	 * balance.  This object will corispond to a student's reward account.
	 * If the starting balance is 100 or more 5 dollars will be added to
	 * to the reward balance.
	 *
	 * @param bal   this will be the starting balance on the account.
	*/
	public RewardAccount(double bal){
	
		super(bal);
		if(bal<100){
		
			this.reward=0;
		
		}
		else{
		
			this.reward=5;
		
		}
	
	}
	/* This method creates a new object that consist of two 
	 * doubles and a long number.  The object's long
	 * number will be the account number, one of the double numbers
	 * is the balance on the account, and the other double is a reward 
	 * balance.  This object will corispond to a student's reward account.
	*/
	public RewardAccount(){
	
		super();
		this.reward=0;
	
	}
	/* This method will return a double that will be retrieved
	 * from a RewardAccount.  This double will corrispond to 
	 * the reward balance on the account.
	 *
	 * @return  the reward balance fo a given account.
	 * @see     StudentAccount
	*/
	public double getReward(){
	
		return this.reward;
	
	}
	/* This method will add the reward balance to the account's
	 * current balance and resetting the reward balance if the 
	 * reward balance is 25 or more.
	 *
	 * @see   RewardAccount
	*/
	public void redeemReward(){
	
		if(this.reward<25.0){
		
			System.out.println("Error: Insufficient funds to claim reward");
		
		}
		else{
		
			this.setBalance(this.getBalance()+this.reward);
			this.reward=0;
		
		}
	
	}
	/* This method will return the String of a StudentAccount. 
	 * The String will consist of the account number, the 
	 * balance on the account, and the current reward balance. 
	 *
	 * @return      the String of a RewardAccount's information.
	 * @override    toString
	 * @see         RewardAccount
	*/
	public String toString(){
	
		return ("Account number:  "+this.getAcctNo()+"\nCurrent Balance: "+this.getBalance()+"\nReward Balance:  "+this.reward);
	
	}
	/* This method will take a positive double and add that to a 
	 * given StudentAccount's account balance.  If the double is
	 * 100 or more 5 will be added to the reward balance.
	 *
	 * @param deposit  a double that will be added to the current
	 *                 account's balance
	 * @override       deposit
	 * @see            StudentAccount
	*/
	public void deposit(double deposit){
	
    if(deposit>0)
    {
		  this.setBalance(this.getBalance()+deposit);
		  if(deposit>=100){
        
			  this.reward=this.reward+5.0;
		
		  }

    }
		
	
	}
	/* This method will print out a RewardAccount's information. 
	 * The information will consist of the account number, the 
	 * balance on the account, and the current reward balance. 
	 *
	 * @override    printInfo
	 * @see         RewardAccount
	*/
	public void printInfo(){
	
		System.out.println("Account number:  "+this.getAcctNo()+"\nCurrent Balance: "+this.getBalance()+"\nReward Balance:  "+this.reward);
	
	}

}
/* @author Casey Pollock
 *         Assignment 2
 *         CSCI 2540
 *
 *         This is a demo class that will test the functions
 *         and methods of the StudentAccount Class and the 
 *         RewardAccount Class.
*/
package assg3_Pollockc;

public class StudentAccountDemo{

  public static void main(String[] args){

    System.out.println("Welcome to the Demo for the Reward Account Class and the Student Account Class.");
    System.out.println("This first half will test the Student Account Class.");
    System.out.println("The first test will be to ensure that the constructors and information printers operate correctly."); 
    
    StudentAccount eric=new StudentAccount(25);
    StudentAccount lisa=new StudentAccount();
    eric.printInfo();
    System.out.println(lisa);

    System.out.println("Now to test that all information can be gathered.");
    System.out.println("This is a balance: "+eric.getBalance()+"\nThis is an account number:  "+eric.getAcctNo()+"\nThis is the number of active accounts:  "+eric.getCounter());

    System.out.println("Now account 2 will have its balance set to 50.24.");

    lisa.setBalance(50.24);
    lisa.printInfo();

    System.out.println("Now to test the deposit and charge functions.\nThe first two line should be errors, then an amount of 41.43 will be added to account 1, then another two erros should be printed, and finally an amount of 16.43 should be removed from account 1.");

    eric.deposit(41.43);
    eric.deposit(0);
    eric.deposit(-21);
    eric.printInfo();
    eric.charge(16.43);
    eric.charge(0);
    eric.charge(-21.43);
    eric.printInfo();

    System.out.println("This will be a test of the two transfer functions.\n  50 will be transfered from account 1 to account 2 and 25 will be transfered from account 2 to account 1.");

    eric.transferOut(lisa,50);
    eric.transferOut(lisa,0);
    eric.transferOut(lisa,-2);
    eric.printInfo();
    lisa.printInfo();
    eric.transferIn(lisa,25);
    eric.transferIn(lisa,0);
    eric.transferIn(lisa,-.23);
    eric.printInfo();
    lisa.printInfo();

    System.out.println("\n\nNow will begin the test of the Rewards Account Class.");
    System.out.println("Now to test each constructor case and the information printers.");

    RewardAccount bill=new RewardAccount(55);
    RewardAccount phil=new RewardAccount(100);
    RewardAccount will=new RewardAccount();
    bill.printInfo();
    System.out.println(will);
    phil.printInfo();

    System.out.println("Now to test the deposit function for reward accounts.");

    bill.deposit(0);
    phil.deposit(100);
    will.deposit(50);
    bill.deposit(-5);
    bill.printInfo();
    phil.printInfo();
    will.printInfo();

    System.out.println("Now account 4 will have its reward value lifted and printed.");

    phil.deposit(100);
    phil.deposit(100);
    phil.deposit(100);
    phil.charge(300);
    System.out.println("Account 4's reward value is now: "+phil.getReward());

    System.out.println("Now the rewards will be redeemed.");

    bill.redeemReward();
    phil.redeemReward();
    will.redeemReward();
    bill.printInfo();
    phil.printInfo();
    will.printInfo();

  
  }

}
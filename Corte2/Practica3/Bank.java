package bank;
public class Bank{
  private CheckingAccount accountOne;
  private CheckingAccount accountTwo;
  private CheckingAccount accountThree;
  private CheckingAccount accountFour;

  public Bank(){
    accountOne = new CheckingAccount("Zeus", 100, "1");
    accountTwo = new CheckingAccount("Hades", 200, "2");
    accountThree = new CheckingAccount("Kratos", 500, "3");
    accountFour = new CheckingAccount("Eren", 900, "4");
    
  }

  public static void main(String[] args){
    Bank bankOfGods = new Bank();
    System.out.println(bankOfGods.accountOne.getName());
    bankOfGods.accountOne.setBalance(5000);
    System.out.println(bankOfGods.accountOne.getBalance());
    System.out.println(bankOfGods.accountOne.getId());
    
    System.out.println(bankOfGods.accountTwo.getName());
    bankOfGods.accountTwo.setBalance(12);
    System.out.println(bankOfGods.accountTwo.getBalance());
    System.out.println(bankOfGods.accountTwo.getId());
  
    System.out.println(bankOfGods.accountThree.getName());
    bankOfGods.accountThree.setBalance(10200120);
    System.out.println(bankOfGods.accountThree.getBalance());
    System.out.println(bankOfGods.accountThree.getId());
  
  
    bankOfGods.accountFour.setName("Medusa");
    System.out.println(bankOfGods.accountFour.getName());
    bankOfGods.accountFour.setBalance(10200120);
    System.out.println(bankOfGods.accountFour.getBalance());
    bankOfGods.accountFour.setId("Harry Potter");
    System.out.println(bankOfGods.accountFour.getId());
  
  
  
  
  
  }
}

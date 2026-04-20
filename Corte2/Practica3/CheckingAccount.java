package bank;
public class CheckingAccount{
  private String name;
  private int balance;
  private String id;
  
  public CheckingAccount(String inputName, int inputBalance, String inputId){
    name = inputName;
    balance = inputBalance;
    id = inputId;
  }

    public String getName() {
        return name;
    }
    public String setName(String newName){
        return name = newName;
    }
    public int getBalance() {
    return balance;
  }

    public void setBalance(int newBalance) {
    balance = newBalance;
  }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

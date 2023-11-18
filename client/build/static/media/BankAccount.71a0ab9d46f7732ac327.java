import java.util.Scanner;
class Account{
    double balance;
    String name,address,acc_Type;
    int transactions;
    String accountNumber;
 Account(String name,String acc_Type,String address,double balance,int accountCounter){
    this.name=name;
    this.acc_Type=acc_Type;
    this.address=address;
    this.balance=balance;
    accountNumber="BA"+accountCounter;
 }
 double deposit(double amount){
    this.transactions++;
    this.balance+=amount;
     return balance;
 }
 double withdraw(double amount){
    this.transactions++;
    this.balance-=amount;
    return balance;
 }
 void update_address(String address){
  this.address=address;
 }
 void print(){
    System.out.println("Name : "+name);
    System.out.println("Address : "+address);
    System.out.println("Account Type : "+acc_Type);
    System.out.println("balance : "+balance);
    System.out.println("Account Number : "+accountNumber);
 }
}
public class BankAccount{
static int accountCounter=1000;
static int totalTransaction=0;
void creat_Acc(Account acc[],Scanner cin){

        for(int i=0;i<acc.length;i++){
          cin.nextLine();
          System.out.println("Enter the Name : ");
          String name = cin.nextLine();
          System.out.println("Enter the Account Type : ");
          String acc_Type = cin.nextLine();
          System.out.println("Enter the Address : ");
          String address = cin.nextLine();
          System.out.println("Enter the Balance : ");
          double balance = cin.nextDouble();
          acc[i]=new Account(name, acc_Type, address, balance, accountCounter);
          accountCounter++;
        }
}
public static void main(String[] args) {
        BankAccount Bank = new BankAccount();
        Scanner cin = new Scanner(System.in);
        System.out.println("Enter the Numer of Depositor : ");
        int depositer = cin.nextInt();
        Account acc[] = new Account[depositer];
        Bank.creat_Acc(acc,cin);
        System.out.println("Deposit amount press  : 1");
        System.out.println("withdraw amount press  : 2");
        System.out.println("Update address press  : 3");
        System.out.println("Display profile press  : 4");
        System.out.println("Number of transaction by user press  : 5");
        System.out.println("Total Number of transaction performed by Bank press  : 6");
        System.out.println("Exit press  : 7");
        while (true) {
        int index=-1;
        System.out.println("Choice option : ");  
        int choice = cin.nextInt();
        cin.nextLine();
        System.out.println("Your name : ");
        String name = cin.nextLine();
        System.out.println("____________________");   
        for(int i=0;i<acc.length;i++){
            if(acc[i].name.equals(name)){
              index=i;
              break;
            }
            if(i==acc.length-1){
                System.out.println("Account Not Found");
                return;
            }
        }
            switch (choice) {
                case 1:
                System.out.println("Enter Amount for Deposit : ");
                double amount = cin.nextDouble();
                acc[index].deposit(amount);
                totalTransaction++;
                System.out.println("*************Deposit amount successfully************");
                break;
                case 2:
                System.out.println("Enter Amount for Withdraw : ");
                double amt = cin.nextDouble();
                acc[index].withdraw(amt);
                totalTransaction++;
                System.out.println("*************Withdraw amount successfully************");
                break;
                case 3:
                System.out.println("Enter Updated Address : ");
                String address = cin.nextLine();
                acc[index].update_address(address);
                System.out.println("*************Updated address successfully************");
                break;
                case 4:
                acc[index].print();
                break;
                case 5:
                System.out.println("Number of Transaction by : "+acc[index].name+" : "+acc[index].transactions);
                break;
                case 6:
                 System.out.println("Total Number of Transaction by Bank : "+BankAccount.totalTransaction);
                break;
                case 7:
                return;
                default:
                break;
        } 
        System.out.println("____________________");   
    }
 }   
}
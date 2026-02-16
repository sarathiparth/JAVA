package scenario;
import java.util.Scanner;
class details{
    private int acct_num = 138982364;
    private int balance;
    void set_balance(int x){
        this.balance=x;
    }
    int get_balance(){
        return balance;
    }
    void update(){
        int choice;
        do{
        int money;
        System.out.println("----select the options----");
        System.out.print("1.Withdrawal");
        System.out.println("");
        System.out.print("2.deposit");
        System.out.println("");

        System.out.print("3.Exit");
        System.out.println("");

        System.out.print("enter the option: ");
        System.out.println("");

        Scanner sc =new Scanner(System.in);
         choice = sc.nextInt();
        switch(choice){
            case 1: System.out.print("enter the amount to be withdrawn: ");
                   

                    money = sc.nextInt();
                    if(money>get_balance()){
                        System.out.println("InSufficient balance");
                        
                    } 
                    if(money<0){
                        System.out.println("enter valid money to be withdrawn");
                        break;
                    }
                    else{
                        System.out.println(money +" is withdrawn from your account");
                        set_balance(get_balance()-money);
                        System.out.println("current balance is: "+get_balance());
                        

                    }
                    break;
                case 2: System.out.println("enter the amount to be deposited");
                        money =sc.nextInt();
                        set_balance(get_balance()+money);
                        System.out.println("your current balance is: "+get_balance());
                        break;
                case 3: System.out.println("---------EXITING------");
                        break;
                default : System.out.println("INVLAID CHOICE");
                        break;
        }
    }while(choice!=3);


    }
}
public class bank {
    public static void main(String[] args) {
        details d =new details();
        d.set_balance(25000);
        d.update();
    }
    
}


import java.util.Scanner;

public class SoftwareSalesDiscount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double costDefault = 99.0;
        
        System.out.print("Please enter the number of packages you purchased: ");
        int packages = scanner.nextInt();
        double costPay = packages*costDefault;
        if(packages < 10){
            System.err.println("This is no discount. ");
            System.err.println("Total amount of purchase would be:" + costPay);
        }else if(packages >= 10 && packages <= 19){
            System.err.println("Total amount of purchase would be:" + (costPay - costPay*20/100));
        }else if (packages >= 20 && packages <= 49) {
            System.err.println("Total amount of purchase would be:" + (costPay - costPay*30/100)); 
        }else if (packages >= 50 && packages <= 99) {
            System.err.println("Total amount of purchase would be:" + (costPay - costPay*40/100)); 
        }else{
            System.err.println("Total amount of purchase would be:" + (costPay - costPay*50/100));    
        }
    }
}

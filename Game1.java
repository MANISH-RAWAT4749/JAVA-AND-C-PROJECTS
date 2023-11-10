import java.util.Scanner;

public class Game1 {
    public static void main(String[] args) {
        //MINI PROJECT
        //generating random numbers
Scanner sc=new Scanner(System.in);
        int myNumber=(int)(Math.random()*100);
        int userNumber=0;
        do{
            System.out.println("Guess my Number: ");
              userNumber=sc.nextInt();
            if(userNumber==myNumber){
                System.out.println("WOOOHOOOO CORRECT NUMBER");
                break;

            }
            else if(userNumber>myNumber)
            {
                System.out.println("Your number is too LARGE");
            }
            else{
                System.out.println("Your number is too small");
            }
        }while(userNumber>=0); // code will run untill number is greater than 0

System.out.println("My number was: ");
System.out.println(myNumber);




    }
}

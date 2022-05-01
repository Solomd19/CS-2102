import java.util.Scanner;

public class PrecinctProgram {

    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
//
//        System.out.println("hello, world");
//
//        String message = "hello, world";
//        System.out.println(message);
//
//        int day;
//        day = 17;
//        System.out.println("Today is Wed, Nov " + day + ".");
//
//        Precinct worcester12;
//        worcester12 = new Precinct("Worcester12", "130 Winter Street", 1673);
//        System.out.println(worcester12);
//
//        System.out.print("Enter population growth amount: ");
//        int amount = keyboard.nextInt();
//        System.out.println(worcester12.grow(amount));
//
//        day = 7;
//        System.out.println("Here's today's date:" + "Nov" + day + "," + "2010");
//
//        day = 7;
//        System.out.println("Here's today's date: " + "Nov " + day + ", " +" 2010");
//
//        int num1;
//        int num2;
//
//        System.out.print("Enter num1 and num2: ");
//        num1 = keyboard.nextInt();
//        num2 = keyboard.nextInt();

        String name;
        String address;
        int population;

        System.out.print("Enter name: ");
        name = keyboard.nextLine();
        System.out.print("Enter address: ");
        address = keyboard.nextLine();
        System.out.print("Enter population: ");
        population = keyboard.nextInt();

        Precinct worcesterNew;
        worcesterNew = new Precinct(name, address, population);
        System.out.println(worcesterNew);
    }

}

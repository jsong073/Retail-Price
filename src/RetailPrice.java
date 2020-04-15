import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class RetailPrice {
    public static void main (String[] args) {
        /*
        Set up variables
        Cost, retail, and rate
        Cost for the wholesale cost
        Rate is 2.5
        Retail is the product of rate and cost
        boolean quit is used as a loop guard
        cont is used to store the user's answer

         */
        String cont;
        double cost, retail, rate;
        rate = 2.5;
        boolean quit = false;
        DecimalFormat df = new DecimalFormat("#.##");       //Not sure how DecimalFormat or RoundingMode works
        df.setRoundingMode(RoundingMode.HALF_UP);

        Scanner keybd = new Scanner(System.in);

        /*
        This loop asks the user to enter a wholesale cost
        If quit is entered, then boolean quit is set to true, which will break the loop
        Otherwise, it should take the response from the user and turn it into a double so the retail value can be
        calculated.
        If the value is neither a double or quit, it will send an error message
         */
        do {
            System.out.print("Enter the wholesale cost, or type \"quit\": ");
            cont = keybd.nextLine();
            if (cont.equalsIgnoreCase("quit")) {
                quit = true;
            } else {
                try {
                    cost = Double.parseDouble(cont);
                    retail = cost * rate;
                    System.out.println("Retail price: $" + df.format(retail));
                } catch (NumberFormatException e) {
                    quit = true;
                    System.out.println("Invalid input detected. Shutting down.");
                }

            }
        }while (quit == false);

        if (cont.equalsIgnoreCase("quit")) {
            System.out.println("Quitting now. Thank you.");
        }

    }
}

import java.util.Scanner;

public class PokerCaculator
{

private double outs;
private double potSize;
private double betSize;
private double potOdds;
private double chanceToWinHand;

   private double caculateProfitability
   {
      
   }
   
   public static void main(String[] args)
   {
      Scanner scnr = new Scanner(System.in);
      PokerCaculator run = new PokerCaculator();
      
      System.out.println("This Texas Hold'em poker caculator tells you if it is profitable to call a bet.");
      System.out.println("Pot odds determine your breakeven point. How many times you can miss a poker \"out\" and still remain profitable.");
      System.out.println("A poker \"out\" is an unseen card that if delt, will give you the winning hand");
      System.out.println("Common outs for flush draw = 9. Open ended straight = 8. Top pair = 3.");
      System.out.print("First, how many outs do you have? ");
      run.outs = scnr.nextInt();
      System.out.print("Second, what is the pot size? ");
      run.potSize = scnr.nextInt();
      System.out.print("Lastly, what is the size of the bet you must call? ");
      run.betSize = scnr.nextInt();
      System.out.println(run.caculateProfitability());
   }
}
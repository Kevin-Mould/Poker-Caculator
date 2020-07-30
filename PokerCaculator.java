import java.util.Scanner;

public class PokerCaculator
{

private String bettingRound = new String();
private double outs;
private double potSize;
private double betSize;
private double potOdds;
private double chanceToWinHand;

   private double caculateChanceToWinHand(double outs, String bettingRound)
   {
      try
      {
         if (getBettingRound().equals("flop"))
         {
            chanceToWinHand = (outs * 4);
         }
         else if (getBettingRound().equals("turn"))
         {
            chanceToWinHand = (outs * 2);
         }
         else
         {
            throw new IllegalArgumentException("Error, not flop or turn");
         }
      }
      catch (IllegalArgumentException e)
      {
          e.getMessage();
      }
      return chanceToWinHand;
   }
   
   
   private double caculatePotOdds(double potSize, double betSize)
   {
      return 100 / (potSize / betSize + 1);
   }
   
   
   private void setBettingRound(String bettingRound)
   {
      this.bettingRound = bettingRound;
   }
   
   private String getBettingRound()
   {
      return bettingRound;
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
      run.outs = scnr.nextDouble();
      System.out.print("Second, what is the pot size? ");
      run.potSize = scnr.nextDouble();
      System.out.print("Thrid, what is the size of the bet you must call? ");
      run.betSize = scnr.nextDouble();
      System.out.print("Lastly, what betting round are you on [flop or turn]?");
      run.bettingRound = scnr.next();
      run.setBettingRound(run.bettingRound);
      System.out.println(run.caculateChanceToWinHand(run.outs, run.getBettingRound()));
      System.out.println(run.caculatePotOdds(run.potSize, run.betSize));
   }
}

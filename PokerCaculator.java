import java.util.Scanner;

public class PokerCaculator
{
   
   // declare global variables
   static PokerCaculator pokerBrain = new PokerCaculator(0.0, 0.0, 0.0, "");
   static Scanner scnr = new Scanner(System.in);
   private static String bettingRound = new String();
   private static double outs;
   private static double potSize;
   private static double betSize;
   private static double potOdds;
   private static double chanceToWinHand;

   // constructor
   public PokerCaculator(double outs, double potSize, double betSize, String bettingRound)
   {
      this.outs = outs;
      this.potSize = potSize;
      this.betSize = betSize;
      this.bettingRound = bettingRound;
   }
   
   // gather information method
   // TODO
   // implement exception handling
   private static void gatherInformation()
   {
      System.out.print("First, how many outs do you have? ");
      outs = scnr.nextDouble();
      System.out.print("Second, what is the pot size? ");
      potSize = scnr.nextDouble();
      System.out.print("Thrid, what is the size of the bet you must call? ");
      betSize = scnr.nextDouble();
      System.out.print("Lastly, what betting round are you on [flop or turn]?");
      bettingRound = scnr.next();
      PokerCaculator pokerBrain = new PokerCaculator(outs, potSize, betSize, bettingRound);
   }
   
   // caculate methods
   // TODO
   // remove exception handling here. Exception handle at user input.
   // change output to percentage
   private static double caculateChanceToWinHand(double outs, String bettingRound) throws Exception
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
            throw new Exception();
         }
      }
      catch (Exception e)
      {
         System.out.println("Error, not flop or turn.");
      }
      return chanceToWinHand;
   }
   
   
   // TODO
   // change output to percentage
   private static double caculatePotOdds(double potSize, double betSize)
   {
      return 100 / (potSize / betSize + 1);
   }
   
   
   // setter and getter methods
   private static void setOuts(double outs)
   {
      outs = outs;
   }
   
   private static double getOuts()
   {
      return outs;
   }
   
   private static void setPotSize(double potSize)
   {
      potSize = potSize;
   }
   
   private static double getPotSize()
   {
      return potSize;
   } 
   
   private static void setBetSize(double betSize)
   {
      betSize = betSize;
   }
   
   private static double getBetSize()
   {
      return betSize;
   }
   
   private static void setBettingRound(String bettingRound)
   {
      bettingRound = bettingRound;
   }
   
   private static String getBettingRound()
   {
      return bettingRound;
   }
   
   // main method
   // TODO
   // add loop
   public static void main(String[] args) throws Exception
   {  
      System.out.println("This Texas Hold'em poker caculator tells you if it is profitable to call a bet.");
      System.out.println("Pot odds determine your breakeven point. How many times you can miss a poker \"out\" and still remain profitable.");
      System.out.println("A poker \"out\" is an unseen card that if delt, will give you the winning hand");
      System.out.println("Common outs for flush draw = 9. Open ended straight = 8. Top pair = 3.");
      
      gatherInformation();
      System.out.println(caculateChanceToWinHand(pokerBrain.getOuts(), pokerBrain.getBettingRound()));
      System.out.println(caculatePotOdds(pokerBrain.getPotSize(), pokerBrain.getBetSize()));
   }
}

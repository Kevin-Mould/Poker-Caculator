import java.util.*;

public class PokerCalculator
{
   
   // declare global variables
   static PokerCalculator pokerBrain = new PokerCalculator(0.0, 0.0, 0.0, "");
   static Scanner scnr = new Scanner(System.in);
   private static String bettingRound = new String();
   private static double outs;
   private static double potSize;
   private static double betSize;
   private static double potOdds;
   private static double chanceToWinHand;
   private static int option;
   private static boolean exit;


   // constructor
   public PokerCalculator(double outs, double potSize, double betSize, String bettingRound)
   {
      this.outs = outs;
      this.potSize = potSize;
      this.betSize = betSize;
      this.bettingRound = bettingRound;
   }
  
   
   // gather information method with input validation
   private static void gatherInformation() throws InputMismatchException
   {
      option = 1;
      exit = false;
      while (true)
      {
         try
          {
            if (option == 1)
            {
               System.out.print("First, how many outs do you have? Type 0 to terminate program. ");
               outs = scnr.nextDouble();
               if (outs == 0.0)
               {
                  exit = true;
                  break;
               }
               if (outs < 0.0)
               {
                  System.out.println("Error, you can't have negative outs. Outs > 0.");
                  option = 1;
                  continue;
               }
               option++;
            }
            if (option == 2)
            {
               System.out.print("Second, what is the pot size? ");
               potSize = scnr.nextDouble();
               if (potSize <= 0)
               {
                  System.out.println("Error, pot size can't be less than or equal to 0.");
                  option = 2;
                  continue;
               }
               option++;
            }
            if (option == 3)
            {
               System.out.print("Thrid, what is the size of the bet you must call? ");
               betSize = scnr.nextDouble();
               if (betSize <= 0)
               {
                  System.out.println("Error, bet size can't be less than or equal to 0.");
                  option = 3;
                  continue;
               }
               option++;
            }
            if (option == 4)
            {
               System.out.print("Lastly, what betting round are you on [flop or turn]? ");
               bettingRound = scnr.next();
               setBettingRound(bettingRound);
               if (getBettingRound().equals("flop") ^ getBettingRound().equals("turn"))
               {
                  PokerCalculator pokerBrain = new PokerCalculator(outs, potSize, betSize, bettingRound);
                  break;
               }
               System.out.println("Error, betting round not flop or turn.");
               option = 4;
               continue;
            }
         }
         catch (InputMismatchException e)
         {
            System.out.println("Error, make sure you are entering the correct input type (number or letter)");
            scnr.next();
            continue;
         }
      }
   }
   
   
   // caculate methods
   private static double calculateChanceToWinHand(double outs, String bettingRound)
   {
      if (getBettingRound().equals("flop"))
      {
         if (outs >= 8.0) // more percise equity number for large number of outs
         {
            chanceToWinHand = (outs * 4) - (outs - 8);
         }
         else
         {
            chanceToWinHand = (outs * 4);
         }
      }
      else if (getBettingRound().equals("turn"))
      {
         chanceToWinHand = (outs * 2);
      }
      return Math.round(chanceToWinHand * 10) / 10.0;
   }
   
   
   private static double calculatePotOdds(double potSize, double betSize)
   {
      return Math.round((100 / (potSize / betSize + 1)) * 10) / 10.0;
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
   public static void main(String[] args) throws InputMismatchException
   {  
      System.out.println("This Texas Hold'em poker calculator tells you if it is profitable to call a bet.");
      System.out.println("Pot odds determine your breakeven point. How many times you can miss a poker \"out\" and still remain profitable.");
      System.out.println("A poker \"out\" is an unseen card that if delt, will give you the winning hand");
      System.out.println("Common outs for flush draw = 9. Open ended straight = 8. Top pair = 3.");
      
      while (true)
      {
         gatherInformation();
         
         if (exit)
         {
            break;
         }
         
         System.out.println("Chance to win hand = " + calculateChanceToWinHand(pokerBrain.getOuts(), pokerBrain.getBettingRound()) + "%");
         System.out.println("Pot odds = " + calculatePotOdds(pokerBrain.getPotSize(), pokerBrain.getBetSize()) + "%");
         
         if (calculateChanceToWinHand(pokerBrain.getOuts(), pokerBrain.getBettingRound()) >= calculatePotOdds(pokerBrain.getPotSize(), pokerBrain.getBetSize()))
         {
            System.out.println("Call");
         }
         else
         {
            System.out.println("Fold");
         }
      }
   }
}
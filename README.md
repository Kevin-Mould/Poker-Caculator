# Poker-Caculator.java
## What problem does this program solve?

Picture this, you're playing a friendly poker home game with your friends and hold 2 pocket clubs. On the flop, 2 additional clubs are dealt and your heart starts pumping, your chasing a flush draw! However, your opponent is not going to let you see cards for free, and bets $5 making the total pot worth $20 dollars. The decision is yours, do you call?

## How fish process this decision. 
There are 4 possible suits (club, diamond, spade and heart), thats 2, 25% chances to win the pot, so 50%! Thats not a lot of money to risk to win the pot, I'll call and see another card because I'm feeling lucky!

## How sharks (and PokerCaculator.java) process this decision. 
First, determine your chance to win: A flush draw means I have 9 outs (13 clubs - 4 displayed clubs). on the flop I multiple my outs by 4 so my chance to hit a club is 9 * 4 = 36%.

Second, determine the pot odds: You face a $5 bet into a $20 dollar pot. Take the $20 pot and divide it by your bet (20 / 5 = 4) then add 1 (your bet if you call), making your odds 4 + 1 = 5. Divide 100 by 5 to determine the pot odds 100 / 5 = 20%.

Third, combine steps 1 and 2.
Chance to win hand = 36%
Pot Odds = 20%
Your chance to win is greater than the pot odds, you CALL this bet everytime.

## Remember
Poker is not based on pure luck, it is a game of probabilities, there are a certain number of cards in the deck and a certain probability that outcomes will occur. So we can use this in our decision making process.

Every time we make a decision in Poker it is a mathematical gamble, what we have to make sure is that we only take the gamble when the odds are on in our favour. As long as we do this, in the long term we will always come out on top.

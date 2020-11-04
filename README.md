# PokerCalculator.java
## What problem does this program solve?

Picture this, you're playing a poker hand with your friends and are dealt 2 pocket clubs. The flop contains 2 additional clubs and your heart starts pumping, your chasing a flush draw! However, your opponent called the villain, is not going to let you see cards for free, and bets $5 dollars to make the total pot $20 dollars. The decision is yours, do you fold, call or raise?

## How fish process this decision. 
I just need 1 more card to hit my draw. This seems like a good value proposition, I'll call and see another card because I'm feeling lucky!

## How sharks (and PokerCalculator.java) process this decision. 
First, caculate your outs to determine your chance to win. Formula: Chance to win(flop) = 4(outs). Chance to win(turn) = 2(outs).

A flush draw means you have 9 outs (13 clubs - 4 displayed clubs). on the flop you multiple your outs by 4 so the chance to hit a club is 9 * 4 = 36%.

Second, determine the pot odds. Formula: Pot odds = 100 / (pot / bet + 1).

You face a $5 bet into a $20 dollar pot. Take the $20 pot and divide it by the required bet (20 / 5 = 4) then add 1 (your bet if you call), making your odds 4 + 1 = 5. Divide 100 by your odds to determine the pot odds 100 / 5 = 20%.

Third, compare steps 1 and 2.

Chance to win hand = 36%

Pot Odds = 20%

Since your chance to win is greater than the pot odds, you CALL.

If your chance to win is less than the pot odds, you FOLD or raise.

## 10,000 Foot Overview
Poker is complex and decisions are not black and white. Strictly speaking, calling the flop at 4(outs) odds and folding every time you miss the out on the turn is negative expected value (-EV). However, it is important to remember that you can still win the pot EVEN if you miss your out. Poker strategy concepts such as fold equity, implied odds, hand ranges and the tendencies of the villain are impossible to quantify, but positively contribute to your EV. This is why the formula encourages taking more risk on the flop compared to the turn.

Every street, you face 3 options - fold, check/call or raise. The more options you consider, the greater chance to make a mistake. You should limit the number of choices. Take the above example, you have correct pot odds to call 36% to 20%, the fold option is a mistake and the raise option is not optimal. Why raise yourself out of profitable decision? Just call.

Take the opposite example, say you have incorrect pot odds, 22% chance to win with 28% pot odds. The fold option is correct to protect your chip stack from -EV plays. The call option is a mistake. However, the raise option is an acceptable play in certain scenarios. This is a semi-bluff that combines the poker concepts highlighted above with your chance to win hand to estimate a +EV play (and disguise your hand range) even in the face of incorrect pot odds. In summary, never call incorrect pot odds, fold or raise are your only 2 options.

## Tips
A good default option when being the first to act out of position (OOP) is to just check your entire range. 

Being aggressive in poker (raising) is never the wrong play, but might be sub-optimal compared to other options.

Project inspired by: http://www.pokerprofessor.com/university/how-to-win-at-poker/poker-math

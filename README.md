# Wheel-of-Fortune-
Code for the simulation of Wheel of Fortune 

Wheel of Fortune simulation

The purpose of this project is to create a simulation for Wheel of Fortune. Although the real
Wheel of Fortune has two players compete against each other, this program only allows the user 
to play against the computer. 

The game starts by asking the player what his/her name is. It then records the name and picks a 
random number from the scores text file. This is supposed to simulate the reader spinning the 
wheel in the actual game show. If the user spins a positive number, the user gets to either
guess the phrase that is hidden or pick a letter. If the letter that the user picks is contained
in the phrase, the player is awarded the amount he/she spinned multiplied by the number of occurences in 
the letter. For example if the user spins a 650 and picks a letter that shows up 3 time in the word, 
the player is awarded 1950 points. 

On the other hand, if the user picks a letter and it is not in the phrase, the user looses his/her turn 
and it becomes the computer's turn. Additionally, if the user spins a negative number one of two things 
will happen. If the score that the user has subtracted from the number that they got from the spin is 
positive, the user's score changes to that number. If that number is negative, then the user's score becomes 
zero. 

If is becomes the computer's turn, the same rules apply for the computer as it does for the computer. Instead
of somebody manually inputing letters, the computer randomly guesses a letter until it either looses its 
turn or wins the game. 

When all of the letters are guessed, the person that was most recent to input a value wins the game. For example
if the user was the person who picked the last letter correctly, then the user wins. Additionally, if the 
computer manages to guess all of the letters then it wins. Lastly, if the player tries to guess the phrase
and gets it correctly, then he/she wins the game

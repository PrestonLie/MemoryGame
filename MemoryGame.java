/**
 * Project 3.6.5
 *
 * The Memory Game shows a random sequence of "memory strings" in a variety of buttons.
 * After wathcing the memory strings appear in the buttons one at a time, the
 * player recreates the sequence from memory.
 */
import java.util.Random;
public class MemoryGame
{
  // Create a list of randomly ordered integers with no repeats, the length
  public static int[] sequenceRandomizer(int[] sequence)
  {
      //Fisheryates shuffle algorithm taken from geeksforgeeks
    Random r = new Random();
         
    // Start from the last element and swap one by one. We don't
    // need to run for the first element that's why i > 0
    for (int i = sequence.length-1; i > 0; i--) {
         
        // Pick a random index from 0 to i
        int j = r.nextInt(i+1);
         
        // Swap arr[i] with the element at random index
        int temp = sequence[i];
        sequence[i] = sequence[j];
        sequence[j] = temp;
    }
      return sequence;
  }
 
  public static void main(String[] args) {
    int total = 0;
    int score = 0;
    // Create the "memory strings" - an array of single character strings to 
    String[] memory = {"a" , "b", "c"};
    // show in the buttons, one element at a time. This is the sequence
    // the player will have to remember
    // Create a new array that will contain the randomly ordered memory strings.
    int[] randomSeq = {0,1,2};
    int[] buttonSeq = {0,1,2};
    MemoryGameGUI m = new MemoryGameGUI(); 
    // Create the game and gameboard. Configure a randomized board with 3 buttons.
    m.createBoard(3,true);
    do{
        // show in the buttons, one element at a time. This is the sequence
        // the player will have to remember
        buttonSeq = sequenceRandomizer(buttonSeq);
        randomSeq = sequenceRandomizer(randomSeq);
        // Play one sequence, delaying half a second for the strings to show
        // in the buttons. Save the player's guess. 
        if(m.playSequence(memory, 0.5, randomSeq, buttonSeq))
        {
            // If match, increase score, and signal a match, otherwise, try again.
       // Determine if player's guess matches all elements of the random sequence.

            m.matched(); 
            // If match, increase score, and signal a match, otherwise, try again.
            score++;
        }
        total++;
    }   
    // Ask if user wants to play another round of the game 
    // and track the number of games played.
    while (m.playAgain());
    // When done playing, show score and end the game.
    m.showScore(score, total);
     // Play the game until user wants to quit.
    m.quit();
  }
}
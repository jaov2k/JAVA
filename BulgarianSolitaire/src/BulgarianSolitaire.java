/*
 * JOSE ORTIZ
 * 10/20/2020
 * FALL 2020
 * CIS016 #71514
 * ASSIGNMENT 08B - "BULGARIAN SOLITAIRE" (PART 2)
 */

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class BulgarianSolitaire
{
	final int packOfCards = 45;	
	ArrayList<Integer> Piles = new ArrayList<Integer>();
	boolean isDuplicate = false;
	
	public static void main(String[] args)
	{
		BulgarianSolitaire NewGame = new BulgarianSolitaire();
	}
	
	public BulgarianSolitaire()
	{
		System.out.print("Size of card stack is: " + packOfCards + "\n");
		InitPiles();		
		while(!isDuplicate)
			GenPiles();		
	}
	
	//Creates the initial pile of cards using random numbers.
	public void InitPiles() 
	{
		Random randomNo = new Random();
		boolean isPackRemaining = true;
		int index = 0, total = 0;
		
		//Loop while there're cards in the Pack of Cards.
		while(isPackRemaining)
		{
			if (total < packOfCards)
			{
				//Add a random number of cards to the Piles list
				Piles.add(randomNo.nextInt(packOfCards - total) + 1);
				total = total + Piles.get(index);
				index++;
			}
			else
				isPackRemaining = false;
		}
		PrintPiles();
	}
	
	//Handles subsequent piles until triangular distribution is achieved. 
	public void GenPiles()
	{
		// Clone of the Pile to compare at the end of the method
		ArrayList<Integer> oldPiles = new ArrayList<Integer>(Piles);
		
		//New pile of cards after pulling one from the existing piles
		int newPileSize = Piles.size();
		
		//Remove a card from the existing piles
		for (int i = 0; i < Piles.size(); i++)
			Piles.set(i, (Piles.get(i) - 1));
		
		//Add the new pile to the end of the piles
		Piles.add(newPileSize);
		
		//Remove any pile slots that contain no cards.
		for (int j = 0; j < Piles.size(); j++)
		{
			if (Piles.get(j) < 1)
			{
				Piles.remove(j);
				j--;
			}				
		}
		
		//Sort both piles prior to comparison and update loop flag .
		Collections.sort(oldPiles);
		Collections.sort(Piles);
		isDuplicate = oldPiles.equals(Piles);
		
		//Printing the contents of the Pile here avoids a duplicate print at the end.
		if(!isDuplicate)
			PrintPiles();
	}
	
	//Simple utility routine to print the array list, Piles
	public void PrintPiles()
	{
		Collections.sort(Piles);
		System.out.print("\n");
		for (int i : Piles)
			System.out.print(i + " ");
	}
}
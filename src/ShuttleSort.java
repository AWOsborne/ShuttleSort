import java.util.Random;

/**
 * Simple program for running a ShuttleSort Algorithm
 * 
 * Worst case - O = n^2. Best case - O = n.
 * 
 * The comparisons and swaps needed are related to the randomness of position.
 * 
 * Shuttle sort is about middle of the road in regards to sorting algorithms. It
 * is definitely better than bubble sort, but more random than an insertion
 * sort. It can hold a lot of data, however, so it has its advantages.
 * 
 * @author Drew Osborne
 *
 */
public class ShuttleSort
{
	private static Random rn;
	private static int randSize;
	private final static int randLimit = 1000;
	private static int[] randNums;
	private int[] sortNums;
	private static ShuttleSort sorter;
	private int checks;
	private int swaps;


	/**
	 * Constructor
	 * 
	 * @param list
	 */
	public ShuttleSort(int[] randNums)
	{
		sortNums = randNums;
		checks = 0;
		swaps = 0;
	}


	/**
	 * Returns the number of checks made.
	 * 
	 * @return Number of Comparisons.
	 */
	public int getChecks()
	{
		return checks;
	}


	/**
	 * Returns the number of swaps made.
	 * 
	 * @return Number of swaps.
	 */
	public int getSwaps()
	{
		return swaps;
	}


	/**
	 * Method for sorting the array.
	 */
	public void sort()
	{
		for (int i = 0; i < sortNums.length - 1; i++)
		{
			checkSort(i, i + 1);
		}
	}


	/**
	 * Recursive method for comparing and switching.
	 * 
	 * @param x
	 *           First number to compare.
	 * @param y
	 *           Second number to compare.
	 */
	private void checkSort(int x, int y)
	{
		checks++;
		if (sortNums[x] > sortNums[y])
		{
			swaps++;
			int tmp = sortNums[x];
			sortNums[x] = sortNums[y];
			sortNums[y] = tmp;
			x--;
			y--;

			// Recursively checks and sorts previous.
			if (x != -1)
			{
				checkSort(x, y);
			}
		}
	}


	/**
	 * Print Method
	 */
	public void printList()
	{
		for (int i : sortNums)
		{
			System.out.println(i + " ");
		}
	}


	/**
	 * Main Method for Demo Purposes
	 * 
	 * @param args
	 *           Size of list to sort as integer.
	 */
	public static void main(String[] args)
	{
		rn = new Random();
		randSize = 0;

		// Checks user input for int.
		try
		{
			randSize = Integer.parseInt(args[0]);
			randNums = new int[randSize];

			// Fills the list with random numbers from 0 - 999.
			for (int i = 0; i < randSize; i++)
			{
				randNums[i] = rn.nextInt(randLimit);
			}

			sorter = new ShuttleSort(randNums);
			System.out.println("------------------\nBefore sorting.\n------------------\n");
			sorter.printList();
			System.out.println("\n------------------\nAfter sorting.\n------------------\n");
			sorter.sort();
			sorter.printList();
			System.out.println("\n------------------");
			System.out.println("Comparisons: " + sorter.getChecks());
			System.out.println("Swaps: " + sorter.getSwaps());
		}
		catch (Exception e)
		{
			System.out.println("Could not understand argument.\nPlease run again with an integer value.");
		}
	}

}

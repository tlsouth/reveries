package lab1;

import java.util.Random;

public class MersGenerator
{
	public static void main(String[] args)
	{
//		creates a counter variable for counting the occurrence of specific sequences (part 2 of lab)
		float counter = 0;
//		this for loop runs 1000 times, allowing us to generate random sequences 1000 times
		for(int x=0; x <= 1000000; x++) 
		{
//		following four lines are to print random integers, as shown on slide 3
		Random random = new Random();
	
//		creates variable containing all the bases, and a blank variable to which random bases will be added
//		String bases = "ATCG";
		String seq = "";
		
//		for loop iterates through the length of the variable bases (1-4), and selects a random position. It then selects the character (A, T, C, or G) at that position and adds it to the string s until s contains three characters
//		###########BELOW WORKS FOR PART 1##########
//			for(; seq.length() < 3; seq = seq + bases.charAt(random.nextInt(4)));
//				if (seq.equals("AAA"))
//						counter = counter + 1;
//				System.out.println(seq);
//		############################################		
		
		
//#######################BELOW IS FOR PART 2################
		while(seq.length() < 3)
		{
		float f = random.nextFloat();
//			System.out.println(f);

		String amino = "";
		
		if(f <= 0.12)
			amino = "A";
		else if(f >= 0.13 && f <= 0.50)
			amino = "T";
		else if(f >= 0.51 && f <= 0.89)
			amino = "C";
		else if(f >= 0.90) 
			amino = "G";
		seq = seq + amino;
		
		if (seq.length() == 3)
//		System.out.println(seq);
		
		if (seq.equals("AAA"))
		counter = counter + 1;
		}
	}
//		prints the number of times a specific sequence occurs (part 2 of lab)
		System.out.println("AAA occurred " + counter + " times.");
//		we would expect to see AAA occur with a probability of 1.56%. This is roughly the result Java gives as well, typically ranging from 1.1% to 2.3% at 1,000 runs. At 1,000,000 runs, it is almost always within 0.02% of 1.56%.
		System.out.println("That is " + (counter / 1000000) * 100 + "% of the time");
		
//		For part 2, I expect to see AAA 0.173% of the time. Running the program 1000000 times results in an occurrence at around 0.1839%.
	}

}

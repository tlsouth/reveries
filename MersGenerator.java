package lab1;

import java.util.Random;

public class MersGenerator
{
	public static void main(String[] args)
	{
//		creates two counter variables for counting the occurrence of specific sequences (part 2 of lab)
//		one each for the weighted and unweighted base selection probability
		float unweightedCounter = 0;
		float weightedCounter = 0;
//		this for loop runs 1,000 allowing us to generate random sequences 1,000 times
		for(int x=0; x <= 1000; x++) 
		{
//		allows us to generate random numbers
		Random random = new Random();
	
//		creates variable containing all the bases, and a blank variable each for the weighted and unweighted portions of this project to which random bases will be added
		String bases = "ATCG";
		String seq1 = "";
		String seq2 = "";

//		###########CODE FOR PART 1##########
//		for loop iterates through the length of the variable bases (1-4), and selects a random position. It then selects the character (A, T, C, or G) at that position and adds it to the string s until s contains three characters
		{	
		for(; seq1.length() < 3; seq1 = seq1 + bases.charAt(random.nextInt(4)));
//		if the sequence is AAA, the unweighted counter is increased by 1		
		if (seq1.equals("AAA"))
					unweightedCounter = unweightedCounter + 1;
//		code for printing the sequence if the user wishes
//				System.out.println(seq);
		}
//		####################################	
		
		
//      ###########CODE FOR PART 2##########
//		while loop to execute following code while the sequence is incomplete
		while(seq2.length() < 3)
		{
//		generates random float between 0 and 1
		float f = random.nextFloat();
//		code for printing the sequence if the user wishes
//			System.out.println(f);

//		creates empty string that will be used to store bases that will be added to seq2
		String amino = "";
//		if statements to set up a range so the sampling of amino acids for the sequence is not uniform
		if(f <= 0.12)
			amino = "A";
		else if(f >= 0.13 && f <= 0.50)
			amino = "T";
		else if(f >= 0.51 && f <= 0.89)
			amino = "C";
		else if(f >= 0.90) 
			amino = "G";
		seq2 = seq2 + amino;
//		below is optional code for printing the sequence; used in testing
//		if (seq.length() == 3)
//		System.out.println(seq);
		
//		if the sequence is AAA, the weighted counter is increased by 1
		if (seq2.equals("AAA"))
		weightedCounter = weightedCounter + 1;
		} 
//		####################################	
	}

//		we would expect to see AAA occur with a probability of 1.56% if each base has a uniform sampling probability. This is roughly the result Java gives as well, typically ranging from 1.1% to 2.3% at 1,000 runs. At 1,000,000 runs, it is almost always within 0.02% of 1.56%..
		System.out.println("AAA occurred " + unweightedCounter + " times with equal base selection probability.");
		System.out.println("That is " + (unweightedCounter / 1000) * 100 + "% of the time.");

		
//		when using weighted selection probability, we would expect to see AAA occur with a probability of 0.173%. When run 1,000 times, the observed is not consistently close to the expected. However, when run 1,000,000, the observed is within 0.02% of 0.173% most of the time
		System.out.println("AAA occurred " + weightedCounter + " times with unequal base selection probability.");
		System.out.println("That is " + (weightedCounter / 1000) * 100 + "% of the time.");
	}

}

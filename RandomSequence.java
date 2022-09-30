package lab3;

import java.util.Random;

public class RandomSequence 
{

	public static String generateRandomSequence(char[] alphabet, float[] weights, int length) 
		throws Exception
	{
		//setting up variables to be used later
		String randomSequence = "";
		float sum = 0;
		//allows generation of random floats later on
		Random random = new Random();
		float f = random.nextFloat();
		//summing all the weights for later use to make sure the total is 1
		for(int i = 0; i < weights.length; i++) 
			{
				sum = sum + weights[i];			
			}
		//next three lines are all checks to ensure preconditions are met. if not met, the accompanying exception message is printed
		if(Math.abs(sum - 1) > 0.001) throw new Exception("Sum not equal to 1.");
		if(alphabet.length != weights.length) throw new Exception("Alphabet and weight lengths not equal.");
		if(length < 0) throw new Exception("Length is less than 0");
		//loop that iterates over the length of 'length'
			for(int x = 0; x < length; x++)
				{
					//generates new random float for each instance in length
					f = random.nextFloat();
					//resets counter used for indexing for each instance in length
					int count = 0;
					//resets cumulative_weight similar to count
					float cumulative_weight = 0;
					//resets selection in each instance, which is the alphabet character selected
					char selection = 0;
					//for loop that runs while the cumulative_weight is less than the randomly generated float. this allows us to perform weighted selection
					for(int i = 0; f > cumulative_weight; i++)
					{
							//adds up the weights so that when cumulative_weight > f, the loop breaks and a character is selected
							cumulative_weight += weights[i];
							//ups the counter each time a weight is added to cumulative_weight, so we know the index of the last weight added
							count = count + 1;
							//assigns the alphabet character in the same index as the last added weight to selection
							selection = alphabet[count - 1];
						}
					//appends the alphabet character that was selected using weights to the randomSequence
					randomSequence += selection;
				}
			//returns the randomSequence to the user
			return randomSequence;
			
	}
	public static void main(String[] args) throws Exception
	{
		float[] dnaWeights = { .3f, .3f, .2f, .2f };
		char[] dnaChars = { 'A', 'C', 'G', 'T'  };
		
		// a random DNA 30 mer
		System.out.println(generateRandomSequence(dnaChars, dnaWeights, 30));
		
		float proteinBackground[] =
			{0.072658f, 0.024692f, 0.050007f, 0.061087f,
		        0.041774f, 0.071589f, 0.023392f, 0.052691f, 0.063923f,
		        0.089093f, 0.023150f, 0.042931f, 0.052228f, 0.039871f,
		        0.052012f, 0.073087f, 0.055606f, 0.063321f, 0.012720f,
		        0.032955f}; 
			

		char[] proteinResidues = 
				new char[] { 'A', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T',
							 'V', 'W', 'Y' };
		
//		// a random protein with 30 residues
		System.out.println(generateRandomSequence(proteinResidues, proteinBackground, 30));
		
	}

}

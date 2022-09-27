package lab3;

import java.util.Random;

public class RandomSequence 
{
	public static String generateRandomSequence(char[] alphabet, float[] weights, int length) 
		throws Exception
		
	{
		String randomSequence = "";
		float sum = 0;
		Random random = new Random();
		for(int i = 0; i < weights.length; i++) 
			{
				sum = sum + weights[i];
			}
		//if can break this somehow, add && weights.length >= 0
		if(alphabet.length == weights.length && length >= 0 && sum <= 1.0)
			{
			for (int i = 0; i < alphabet.length; i++)
				{
				char c = alphabet[random.nextInt(alphabet.length)];
				randomSequence += c;
				}
		return randomSequence;
		}
		else
		{
			throw new Exception("Pre-condition failed. Check your parameters.");
		}
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
		
		// a random protein with 30 residues
		System.out.println(generateRandomSequence(proteinResidues, proteinBackground, 30));
		
	}

}

package lab2;

import java.util.Random;
import java.util.Scanner;

public class AminoQuiz {

public static void main(String[] args)
{

/**
 * this is JavaDoc notation	
 */
	
Random random = new Random();	
	
String acid = "";
int index = 0;
Double start = (double) System.currentTimeMillis();
Scanner quizTime = new Scanner (System.in);
System.out.println("How long would you like this quiz to run?");
Double timer = quizTime.nextDouble();
Double stop = start + timer * 1000;
//Double elapsed = (System.currentTimeMillis() - start) * 0.001;
int score = 0;
//	name and single letter code are at the same index
String[] SHORT_NAMES = 
{ "A","R", "N", "D", "C", "Q", "E",
"G",  "H", "I", "L", "K", "M", "F", 
"P", "S", "T", "W", "Y", "V" };

String[] FULL_NAMES = 
{"alanine","arginine", "asparagine", 
"aspartic acid", "cysteine",
"glutamine",  "glutamic acid",
"glycine" ,"histidine","isoleucine",
"leucine",  "lysine", "methionine", 
"phenylalanine", "proline", 
"serine","threonine","tryptophan", 
"tyrosine", "valine"};

while(System.currentTimeMillis() <= stop)
{
//selects random integer between 0 and 19, which is the number of indices in the FULL_NAMES array
index = random.nextInt(19);
//selects the amino acid in array FULL_NAMES based on the value of index
acid = FULL_NAMES[index];
//prints out the full name of the amino acid
System.out.println(acid);

//prompts user to input the single letter code for the amino acid
String code = System.console().readLine().toUpperCase();
//if the user inputs the correct one letter code for the amino acid, the score is increased by 1
if (code.equals(SHORT_NAMES[index])) 
{
	Long elapsed = (long) ((System.currentTimeMillis() - start) * 0.001);
	score ++;
	System.out.println("Correct! Your score is: " + score + ". Time elapsed: " + elapsed + " seconds out of 30.");
}
else if (code.equals("QUIT"))
{
	System.out.println("You have opted to quit. Your final score is " + score + ".");
	return;
}
//if the user inputs the wrong one letter code, the program stops
else
{
	System.out.println("Incorrect. Your final score is " + score + ".");
	return;
}
}
System.out.println("Your score is " + score + ".");
}
}
package lab2;

import java.util.Random;
import java.util.Scanner;

public class AminoQuiz {

public static void main(String[] args)
{
//allows generation of random numbers
Random random = new Random();	
//empty string for adding the full name of the amino acid to
String acid = "";
//empty integer for storing index that will be used to store index of amino acid
int index = 0;
//casts type double on the system time of the machine so it can be used in calculation later
Double start = (double) System.currentTimeMillis();
//allows the program to read in numeric values input by the user
Scanner quizTime = new Scanner (System.in);
//asks the user how long they want the quiz to run (EXTRA CREDIT)
System.out.println("How long would you like this quiz to run?");
//sets double equal to the time input by the user for quiz time
Double timer = quizTime.nextDouble();
//converts stop time to seconds
Double stop = start + timer * 1000;
//sets empty int variable to store the user's score
int score = 0;
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

//while loop that runs until the timer is up
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
	//casts long time on the time elapsed since quiz started in seconds and sets it to a variable to be returned to the user
	Long elapsed = (long) ((System.currentTimeMillis() - start) * 0.001);
	score ++;
	//prints score and time elapsed since quiz started
	System.out.println("Correct! Your score is: " + score + ". Time elapsed: " + elapsed + " seconds out of " + timer + '.');
}
//allows the user to type quit instead of amino acid code to terminate the program. not case sensitive since readLine is always reading upper case
else if (code.equals("QUIT"))
{
	System.out.println("You have opted to quit. Your final score is " + score + ".");
	return;
}
//if the user inputs the wrong one letter code, the program stops and returns a final score
else
{
	System.out.println("Incorrect. Your final score is " + score + ".");
	return;
}
}
System.out.println("Your score is " + score + ".");
}
}

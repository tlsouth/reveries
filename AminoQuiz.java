package lab5;

import java.awt.BorderLayout;
import java.awt.Desktop.Action;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AminoGUI extends JFrame
{
	private static final long serialVersionUID = 1975L;
	static int correctCount = 0;
	static int incorrectCount = 0;
	static int index = 0;
	private JTextField prompt = new JTextField();
	private JTextField input = new JTextField("");
	private JTextField correct = new JTextField("Correct\n" + correctCount);
	private JTextField incorrect = new JTextField("Incorrect\n" + incorrectCount);
	private JTextField time = new JTextField("Time");
	private JButton start = new JButton("Start Quiz");
	private JButton space = new JButton("");
	private JButton cancel = new JButton("Cancel Quiz");
	
	private class StartListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			Random random = new Random();
			String acid = "";

			String[] FULL_NAMES = 
			{"alanine","arginine", "asparagine", 
			"aspartic acid", "cysteine",
			"glutamine",  "glutamic acid",
			"glycine" ,"histidine","isoleucine",
			"leucine",  "lysine", "methionine", 
			"phenylalanine", "proline", 
			"serine","threonine","tryptophan", 
			"tyrosine", "valine"};
				
			index = random.nextInt(19);
			acid = FULL_NAMES[index];
			updateTextField(acid);

		}
	}	

	private class CancelListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}
	
	private class inputListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String answer = input.getText();
			String[] SHORT_NAMES = 
				{ "A","R", "N", "D", "C", "Q", "E",
				"G",  "H", "I", "L", "K", "M", "F", 
				"P", "S", "T", "W", "Y", "V" };
			//prints out correct index, so index is accessible here
			System.out.println(index);
			if (answer.equals(SHORT_NAMES[index])) 
				{
					correctCount ++;
				}
			else
				{
					incorrectCount ++;
				}
			//updates counters correctly
//			System.out.println(correctCount);
			//now we need to make it generate a new amino acid after enter is hit
		}
	}
	
	private void updateTextField(String text)
	{
		prompt.setText(text);
		validate();
	}

/////
	
	private JPanel startCancel()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,3));
		panel.add(start);
		panel.add(space);
		panel.add(cancel);
		
		start.addActionListener(new StartListener());
		
		cancel.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					String cancelText = "hit cancel";
					updateTextField(cancelText);
				}
			}
		);
		return panel;
	}
	
	private JPanel promptTime()
	{
		JPanel pt = new JPanel();
		pt.setLayout(new GridLayout(2,0));
		pt.add(time);
		pt.add(prompt);
		return pt;
	}
	
	public AminoGUI()
	{
		super("Amino Acid Quiz");
		setLocationRelativeTo(null);
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(startCancel(), BorderLayout.SOUTH);
		start.addActionListener(new StartListener());
		cancel.addActionListener(new CancelListener());
		getContentPane().add(promptTime(), BorderLayout.NORTH);
		getContentPane().add(input, BorderLayout.CENTER);
		getContentPane().add(correct, BorderLayout.WEST);
		getContentPane().add(incorrect, BorderLayout.EAST);
		
		input.addActionListener(new inputListener());
		setVisible(true);
	}	
	public static void main(String[] args)
	{
		new AminoGUI();
	}
}

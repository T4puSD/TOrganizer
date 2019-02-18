import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TOrganizerGUI{
	public static void main(String[] args) {
		//PatternMatcher p = new PatternMatcher();

		JFrame jf = new JFrame("TOrganizer");

		jf.setSize(450,300);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.getContentPane().setBackground(new Color(30,150,100));


		jf.setLayout(null); //we are not using any layout manager

		JLabel label_Title = new JLabel("<html><font color=#ffffdd>File Organizer</font>");
		JTextField textField_Directory= new JTextField("Enter The Directory Path",400);
		JButton button_Submit = new JButton("Submit");
		JButton button_Reset = new JButton("Reset");

		jf.add(label_Title);
		jf.add(textField_Directory);
		jf.add(button_Submit);
		jf.add(button_Reset);

		label_Title.setBounds(170,20,200,20);
		textField_Directory.setBounds(15,50,400,30);
		button_Submit.setBounds(165,100,100,40);
		button_Reset.setBounds(165,150,100,40);

		//Action Listener
		button_Submit.addActionListener(new ActionListener()
			{
			  public void actionPerformed(ActionEvent e)
			  {
			  	// JDialog d = new JDialog(jf, "Done", true);
			   //  d.setLocationRelativeTo(jf);
			  	//System.out.println("button pressed: "+e);

			    String directory = textField_Directory.getText();

			    try{
			    	new PatternMatcher().GenerateFileList(directory); //using the PatternMathcer CLass that i created earlier and calling it's method
					button_Submit.setLabel("Done");
					button_Submit.setEnabled(false);
				}catch(Exception ex){
					textField_Directory.setText("Please Enter Valid Absolute Directory Path! Ex:(C:\\Users\\Downloads).");
					button_Submit.setLabel("Error!");
					button_Submit.setEnabled(false); //disabling submit button (making it unclickable)
					System.out.println("Exception now in t organizer "+ex);
					//as GenerateFileList throw exception explicitly we need to handle it here
					//and this way we can handle error in gui easly
				}	
			  }
		});

		button_Reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				button_Submit.setLabel("Submit");
				button_Submit.setEnabled(true);
				textField_Directory.setText("Enter The Directory Path");
			}
		});

		jf.setVisible(true);

	}
}
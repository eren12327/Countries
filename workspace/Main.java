// Name: Eren
// Date: 1/22/25
// Description: This file creates the GUI components and renders the questions that the user will be asked in the game.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Main
{


  private Country[] countryArray = new Country[10];  

  private int index = 0;

  // GUI elements
  private JFrame jFrame = new JFrame("Countries");
  private ImageIcon img;
  private JLabel imageLabel;
  private JLabel outputLabel;
  private JTextField textField;

  private JTextField input;
 

    // Precondition: makes the gui
  // Postcondition: initializes the post condition
  public static void main(String[] args) {
    Main gui = new Main();
    gui.loadCountries();
    gui.showCountry();
  }



  // Precondition: Country obj has an img file defined. 
  // Postcondition: creates a country class for every single country listed in the countries-data.csv data file.
  /* loadCountries() reads in the data from the countries-data.csv file and fills in the countryArray with data. You need to add the loop that reads in the country data into the array. */
  public void loadCountries()
  {

    File file = new File("/workspaces/Countries/workspace/countries-data.csv");
    Scanner scan = null;
    try {
      scan = new Scanner(file);
    } catch(FileNotFoundException e) {
        System.out.println("File not found");    
    }

    for (int i=0; i<countryArray.length; i++) {
      String input = scan.nextLine();
      String[] data = input.split(",");
      countryArray[i] = new Country(data[0],data[1],data[2],data[3]);
    }
     
     
   
  }

 



    // Precondition: Index is an int and is defined. 
  // Postcondition: Sets the image of the currentCountry being asked about. 
  public void showCountry() {

    Country currentCountry = countryArray[index];

    String imagefile = currentCountry.getImageFile();
 
    img = new ImageIcon("/workspaces/Countries/workspace/"+imagefile);
    imageLabel.setIcon(img);
  }
 

 
  // Precondition: Index is defined + int
  // post condition: Sets the question being asked and calls showCountry method.
  public void nextButtonClick()
  {
    if (index > 9) {
      index = 0;
    } else {
      index++;
    }

    Country currentCountry = countryArray[index];
    int random = (int) Math.random()*3;
    if (random == 1) {
      outputLabel.setText("What country is this called?");
    } else if (random == 2) {
      outputLabel.setText("What is the capital of this nation?");
    }
    textField.setText("");
    showCountry();
   
  }
 
 
  public void reviewButtonClick()
  {
    outputLabel.setText(countryArray[index].toString());
  }

  public void quizButtonClick()
  {
    Country currentCountry = countryArray[index];

    if (outputLabel.getText().indexOf("capital") > 0) {

      // This means that we need to check if it has the same capital
      if (textField.getText().toLowerCase().equals(currentCountry.getCapital().toLowerCase())) {
        outputLabel.setText("Good job! Click next to continue.");

      } else {
        outputLabel.setText("incorrect try again! :(");
      }




    } else {

      if (textField.getText().toLowerCase().equals(currentCountry.getName().toLowerCase())) {
        outputLabel.setText("Good job! Click next to continue.");

      } else {
        outputLabel.setText("incorrect try again! :(");
      }
   
    }

   
   
   
  }





public Main() {
    jFrame.setLayout(new FlowLayout());
    jFrame.setSize(500, 360);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton reviewButton = new JButton("Review");
        JButton quizButton = new JButton("Quiz");
        JButton newButton = new JButton("Next");
       


        jFrame.add(reviewButton);
        jFrame.add(quizButton);
        jFrame.add(newButton);
       
        // create a new image icon
        img = new ImageIcon("worldmap.jpg");
        // create a label to display image
        imageLabel = new JLabel(img);

        // and one for output
        outputLabel = new JLabel();
        jFrame.add(imageLabel);

        outputLabel.setText("Click next to start!");
  
        jFrame.add(outputLabel);

        textField = new JTextField(20);
        jFrame.add(textField);
        jFrame.setVisible(true);
        reviewButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e)
    {
      reviewButtonClick();
    }
        });
    quizButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e)
    {
      quizButtonClick();
    }
    });
   
   newButton.addActionListener(new ActionListener()  {
    public void actionPerformed(ActionEvent e)
    {
      nextButtonClick();
    }
   });
}
 

}

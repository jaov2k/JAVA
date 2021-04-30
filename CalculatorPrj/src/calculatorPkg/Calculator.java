/*
 * JOSE ORTIZ
 * 2020-11-18
 * CIS016 #71514
 * FALL 2020
 * ASSIGNMENT 12 - CALCULATOR PART 2
 * DESCRIPTION: BASIC CALCULATOR APPLICATION.
 * OFFERS MOUSE AND KEYBOARD INPUTS, AND A FEW HIGHER LEVEL FUNCTIONS.
*/
package calculatorPkg;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Calculator extends Application
{
	double numA = 0, numB = 0;
	String operation = ""; //Used to SwitchCase what operand to use
	
	//The Calculator Layout
	Pane pane = new Pane();
	Pane displayPane = new Pane();
	Pane tempPane = new Pane();
	GridPane gridPane = new GridPane();
	Label displayLabel = new Label(); //Primary display showing current input
	Label tempDisplay = new Label(); //Input log
	
	//The Buttons
	//First row of buttons	
	Button btnPercent = new Button("%");
	Button btnClear = new Button("CE");
	Button btnCancel = new Button("C");
	Button btnBS = new Button("<--");
	//Second row of buttons
	Button btnRcpr = new Button("1/x");
	Button btnSq = new Button("x^2");
	Button btnSqrt = new Button("x^1/2");		
	Button btnDiv = new Button("/");
	//Third row of buttons
	Button btnSeven = new Button("7");
	Button btnEight = new Button("8");
	Button btnNine = new Button("9");
	Button btnProd = new Button("X");
	//Fourth row of buttons
	Button btnFour = new Button("4");
	Button btnFive = new Button("5");
	Button btnSix = new Button("6");
	Button btnMinus = new Button("-");
	//Fifth row of buttons
	Button btnOne = new Button("1");
	Button btnTwo = new Button("2");
	Button btnThree = new Button("3");
	Button btnAdd = new Button("+");
	//Sixth row of buttons
	Button btnSign = new Button("+/-");
	Button btnZero = new Button("0");
	Button btnPoint = new Button(".");
	Button btnEqual = new Button("=");		
	
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) throws Exception
	{
		FormatLayout(); //Creates, formats, and arranges the panes and labels
		ArrangeButtons(); //Places buttons in the appropriate location
		ButtonActions(); //Assigns actions to the buttons for mouse clickers
		KeyActions(); //Assigns actions to the Numpad and NumKeys for keyboard entry
		
		//Output
		Scene scene = new Scene(pane,475,717);
		primaryStage.setTitle("Java Calculator"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.setResizable(false);
		primaryStage.show(); // Display the stage	
		
		displayLabel.requestFocus();
	}
	
	//Base layout
	public void FormatLayout() 
	{
		//Parent Pane to hold the other two panes		
		pane.setTranslateX(0);
		pane.setTranslateY(0);
		pane.setStyle("-fx-Background-Color: black");
		
		//Pane for the display
		displayPane.setTranslateX(5);
		displayPane.setTranslateY(40);
		displayPane.setStyle("-fx-Background-Color: #2F4F4F");
		displayPane.getChildren().add(displayLabel);
		
		//Pane for the tempDisplay
		tempPane.setTranslateX(5);
		tempPane.setTranslateY(5);
		tempPane.setStyle("-fx-Background-Color: #2F4F4F");
		tempPane.getChildren().add(tempDisplay);
		
		//Formatting the display
		displayLabel.setFont(Font.font("Courier",FontWeight.BOLD,FontPosture.REGULAR,48));
		displayLabel.setTextFill(Color.GREENYELLOW);
		displayLabel.setAlignment(Pos.BASELINE_RIGHT); // align text to the right side of the label.
		displayLabel.setPrefSize(465, 60); // set the width and height of the label
		displayLabel.setPadding(new Insets(5,5,5,5));		
		displayLabel.setText("");
		
		//Formatting the tempDisplay
		tempDisplay.setFont(Font.font("Courier",FontPosture.ITALIC,18));
		tempDisplay.setTextFill(Color.WHITE);
		tempDisplay.setAlignment(Pos.BASELINE_RIGHT); // align text to the right side of the label.
		tempDisplay.setPrefSize(465, 40); // set the width and height of the label
		tempDisplay.setPadding(new Insets(5,5,5,5));		
		tempDisplay.setText("");
		
		//Pane for the buttons
		gridPane.setTranslateX(0);
		gridPane.setTranslateY(105);
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setGridLinesVisible(true);
		gridPane.setPadding(new Insets(5,5,5,5));
		
		pane.getChildren().addAll(tempPane,displayPane,gridPane);
	}
	
	//Places buttons and labels
	public void ArrangeButtons()
 
	{
		//First row of buttons		
		btnPercent.setPrefHeight(100);
		btnPercent.setPrefWidth(116);
		gridPane.add(btnPercent, 0, 0);
		btnClear.setPrefHeight(100);
		btnClear.setPrefWidth(116);
		gridPane.add(btnClear, 1, 0);
		btnCancel.setPrefHeight(100);
		btnCancel.setPrefWidth(116);
		gridPane.add(btnCancel, 2, 0);
		btnBS.setPrefHeight(100);
		btnBS.setPrefWidth(116);
		gridPane.add(btnBS, 3, 0);
		
		//Second row of buttons
		btnRcpr.setPrefHeight(100);
		btnRcpr.setPrefWidth(116);
		gridPane.add(btnRcpr, 0, 1);
		btnSq.setPrefHeight(100);
		btnSq.setPrefWidth(116);
		gridPane.add(btnSq, 1, 1);
		btnSqrt.setPrefHeight(100);
		btnSqrt.setPrefWidth(116);
		gridPane.add(btnSqrt, 2, 1);
		btnDiv.setPrefHeight(100);
		btnDiv.setPrefWidth(116);
		gridPane.add(btnDiv, 3, 1);
		
		//Third row of buttons
		btnSeven.setPrefHeight(100);
		btnSeven.setPrefWidth(116);
		gridPane.add(btnSeven, 0, 2);		
		btnEight.setPrefHeight(100);
		btnEight.setPrefWidth(116);
		gridPane.add(btnEight, 1, 2);
		btnNine.setPrefHeight(100);
		btnNine.setPrefWidth(116);
		gridPane.add(btnNine, 2, 2);
		btnProd.setPrefHeight(100);
		btnProd.setPrefWidth(116);
		gridPane.add(btnProd, 3, 2);	
		
		//Fourth row of buttons
		btnFour.setPrefHeight(100);
		btnFour.setPrefWidth(116);		
		gridPane.add(btnFour, 0, 3);		
		btnFive.setPrefHeight(100);
		btnFive.setPrefWidth(116);
		gridPane.add(btnFive, 1, 3);
		btnSix.setPrefHeight(100);
		btnSix.setPrefWidth(116);
		gridPane.add(btnSix, 2, 3);
		btnMinus.setPrefHeight(100);
		btnMinus.setPrefWidth(116);
		gridPane.add(btnMinus, 3, 3);		
		
		//Fifth row of buttons
		btnOne.setPrefHeight(100);
		btnOne.setPrefWidth(116);		
		gridPane.add(btnOne, 0, 4);
		btnTwo.setPrefHeight(100);
		btnTwo.setPrefWidth(116);
		gridPane.add(btnTwo, 1, 4);
		btnThree.setPrefHeight(100);
		btnThree.setPrefWidth(116);
		gridPane.add(btnThree, 2, 4);
		btnAdd.setPrefHeight(100);
		btnAdd.setPrefWidth(116);
		gridPane.add(btnAdd, 3, 4);		
		
		//Sixth row of buttons
		btnSign.setPrefHeight(100);
		btnSign.setPrefWidth(116);		
		gridPane.add(btnSign, 0, 5);
		btnZero.setPrefHeight(100);
		btnZero.setPrefWidth(116);
		gridPane.add(btnZero, 1, 5);
		btnPoint.setPrefHeight(100);
		btnPoint.setPrefWidth(116);
		gridPane.add(btnPoint, 2, 5);
		btnEqual.setPrefHeight(100);
		btnEqual.setPrefWidth(116);
		gridPane.add(btnEqual, 3, 5);
	}
	
	//Button Events via mouse clicks
	public void ButtonActions() 
	{
		//Calculator functions		
		btnCancel.setOnAction (e -> {displayLabel.setText(""); tempDisplay.setText(""); displayLabel.requestFocus();}); //Cancels the operation
		btnClear.setOnAction (e -> {displayLabel.setText(""); displayLabel.requestFocus();}); //Clears last input.
		btnEqual.setOnAction(e-> {Equals();displayLabel.requestFocus();}); //Perform the operation on two inputs.
		//Percent
		btnPercent.setOnAction (e -> {
			displayLabel.setText(String.valueOf((Double.parseDouble(displayLabel.getText()) / 100)));
			displayLabel.requestFocus();
		});		
		//Reciprocal
		btnRcpr.setOnAction (e -> {
			displayLabel.setText(String.valueOf((1 / Double.parseDouble(displayLabel.getText()))));
			displayLabel.requestFocus();
		});	
		//Square
		btnSq.setOnAction (e -> {
			displayLabel.setText(String.valueOf(Math.pow(Double.parseDouble(displayLabel.getText()),2)));
			displayLabel.requestFocus();
		});
		//Square Root
		btnSqrt.setOnAction (e -> {
			displayLabel.setText(String.valueOf(Math.sqrt(Double.parseDouble(displayLabel.getText()))));
			displayLabel.requestFocus();
		});		
		//Division
		btnDiv.setOnAction (e -> {
			operation = "div";
			numA = Double.parseDouble(displayLabel.getText());
			tempDisplay.setText(fmt(numA) + " / ");
			displayLabel.setText("");
			displayLabel.requestFocus();
		 });		
		//Multiplication
		btnProd.setOnAction (e ->{
			operation = "prod";
			numA = Double.parseDouble(displayLabel.getText());
			tempDisplay.setText(fmt(numA) + " x ");
			displayLabel.setText("");
			displayLabel.requestFocus();
			displayLabel.requestFocus();
		});		
		//Subtraction
		btnMinus.setOnAction (e -> {
			operation = "sub";
			numA = Double.parseDouble(displayLabel.getText());
			tempDisplay.setText(fmt(numA) + " - ");	
			displayLabel.setText("");
			displayLabel.requestFocus();
		});
		//Addition
		btnAdd.setOnAction (e -> {
			operation = "add";
			numA = Double.parseDouble(displayLabel.getText());
			tempDisplay.setText(fmt(numA) + " + ");
			displayLabel.setText("");
			displayLabel.requestFocus();
		});

		//Numbers
		btnOne.setOnAction (e -> {displayLabel.setText(displayLabel.getText() + "1"); displayLabel.requestFocus();});
		btnTwo.setOnAction (e -> {displayLabel.setText(displayLabel.getText() + "2"); displayLabel.requestFocus();});
		btnThree.setOnAction (e -> {displayLabel.setText(displayLabel.getText() + "3"); displayLabel.requestFocus();});
		btnFour.setOnAction (e -> {displayLabel.setText(displayLabel.getText() + "4"); displayLabel.requestFocus();});
		btnFive.setOnAction (e -> {displayLabel.setText(displayLabel.getText() + "5"); displayLabel.requestFocus();});
		btnSix.setOnAction (e -> {displayLabel.setText(displayLabel.getText() + "6"); displayLabel.requestFocus();});
		btnSeven.setOnAction (e -> {displayLabel.setText(displayLabel.getText() + "7"); displayLabel.requestFocus();});
		btnEight.setOnAction (e -> {displayLabel.setText(displayLabel.getText() + "8"); displayLabel.requestFocus();});
		btnNine.setOnAction (e -> {displayLabel.setText(displayLabel.getText() + "9"); displayLabel.requestFocus();});
		btnZero.setOnAction (e -> {displayLabel.setText(displayLabel.getText() + "0"); displayLabel.requestFocus();});
		btnPoint.setOnAction (e -> {displayLabel.setText(displayLabel.getText() + "."); displayLabel.requestFocus();}); //TODO Data validation of multiple points
		btnSign.setOnAction (e -> {displayLabel.setText("-" + displayLabel.getText()); displayLabel.requestFocus();}); // Changes sign to negative		
		
		//TODO Make a backspace function.
		btnBS.setOnAction (e -> {displayLabel.setText(""); tempDisplay.setText("");displayLabel.requestFocus();}); //Clears the display
	}
	
	//Keyboard Events	
	public void KeyActions() 
	{
		displayLabel.setOnKeyPressed(e ->
		{
			switch (e.getCode()) 
			{
				//Number Keys
				case DIGIT0: displayLabel.setText(displayLabel.getText() + "0"); break;
			    case DIGIT1: displayLabel.setText(displayLabel.getText( )+ "1"); break;
			    case DIGIT2: displayLabel.setText(displayLabel.getText() + "2"); break;
			    case DIGIT3: displayLabel.setText(displayLabel.getText() + "3"); break;
			    case DIGIT4: displayLabel.setText(displayLabel.getText() + "4"); break;
			    case DIGIT5: displayLabel.setText(displayLabel.getText() + "5"); break;
			    case DIGIT6: displayLabel.setText(displayLabel.getText() + "6"); break;
			    case DIGIT7: displayLabel.setText(displayLabel.getText() + "7"); break;
			    case DIGIT8: displayLabel.setText(displayLabel.getText() + "8"); break;
			    case DIGIT9: displayLabel.setText(displayLabel.getText() + "9"); break;
			    case PERIOD: displayLabel.setText(displayLabel.getText() + "."); break;			    
			    
			    //Numpad Keys
			    case NUMPAD0: displayLabel.setText(displayLabel.getText() + "0"); break;
			    case NUMPAD1: displayLabel.setText(displayLabel.getText( )+ "1"); break;
			    case NUMPAD2: displayLabel.setText(displayLabel.getText() + "2"); break;
			    case NUMPAD3: displayLabel.setText(displayLabel.getText() + "3"); break;
			    case NUMPAD4: displayLabel.setText(displayLabel.getText() + "4"); break;
			    case NUMPAD5: displayLabel.setText(displayLabel.getText() + "5"); break;
			    case NUMPAD6: displayLabel.setText(displayLabel.getText() + "6"); break;
			    case NUMPAD7: displayLabel.setText(displayLabel.getText() + "7"); break;
			    case NUMPAD8: displayLabel.setText(displayLabel.getText() + "8"); break;
			    case NUMPAD9: displayLabel.setText(displayLabel.getText() + "9"); break;
			    case DECIMAL: displayLabel.setText(displayLabel.getText() + "."); break;
			    
			    //Math Operations
			    case SLASH:
			    	operation = "div";
			    	numA = Double.parseDouble(displayLabel.getText());
			    	tempDisplay.setText(fmt(numA) + " / ");
			    	displayLabel.setText("");
			    	break;			
			    case DIVIDE: //Numpad
			    	operation = "div";
			    	numA = Double.parseDouble(displayLabel.getText());
			    	tempDisplay.setText(fmt(numA) + " / ");
					displayLabel.setText("");
			    	break;
			    case MULTIPLY: //Numpad; TODO ASTARISK requires 'Shift+8'
			    	operation = "prod";
			    	numA = Double.parseDouble(displayLabel.getText());
			    	tempDisplay.setText(fmt(numA) + " * ");
					displayLabel.setText("");
			    	break;
			    case ADD: //Numpad; TODO 'Shift++' requires modifier
			    	operation = "add";
					numA = Double.parseDouble(displayLabel.getText());
					tempDisplay.setText(fmt(numA) + " + ");
					displayLabel.setText("");
					break;
			    case SUBTRACT: //Numpad; TODO fix Exception when used to change the first number's sign to negative.
			    	operation = "sub";
			    	numA = Double.parseDouble(displayLabel.getText());
					tempDisplay.setText(fmt(numA) + " - ");
					displayLabel.setText("");
			    	break;			    	
			    	
			    //Other Function Keys
			    case EQUALS: Equals(); break; //Equal key next to Backspace
			    case ENTER: Equals(); break; //Numpad and KB
			    case ESCAPE: displayLabel.setText(""); tempDisplay.setText(""); break;
			    case MINUS: //Used to change sign; this is the key on the KB between '0' and '='; TODO Data validation for consecutive dashes.
			    	operation="sub";
			    	displayLabel.setText("-" + displayLabel.getText());
			    	displayLabel.requestFocus();
			    	break;
			    
			    //Not used keys clear the input
			    default: displayLabel.setText("");
			}
	    });
	}
	
	//This performs the arithmetic calculations
	public void Equals()
	{
		tempDisplay.setText(tempDisplay.getText() + displayLabel.getText() + " =");
		numB = Double.parseDouble(displayLabel.getText());
		switch (operation) 
		{
			case "add": displayLabel.setText(fmt(numA + numB)); break;
			case "sub": displayLabel.setText(fmt(numA - numB)); break;
			case "prod": displayLabel.setText(fmt(numA * numB)); break;
			case "div": displayLabel.setText(fmt(numA / numB)); break;
			default: displayLabel.setText("UNKNOWN OPERATION"); break;		
		}		
	}
	
	//Handles decimal formatting to use what is only needed
	public static String fmt(double d)
	{
	    if(d == (long) d)
	        return String.format("%d",(long)d);
	    else
	        return String.format("%s",d);
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}
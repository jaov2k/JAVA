/*
 * JOSE ORTIZ
 * 2020-11-08
 * CIS016 #71514
 * FALL 2020
 * ASSIGNMENT 11 - GUI ELEMENTS CALCULATOR PART 1
 * DESCRIPTION: BASIC CALCULATOR APPLICATION
 */

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
import javafx.stage.StageStyle;

public class MyJavaFX extends Application 
{
	double numA = 0, numB = 0;
	String operation = ""; //Used to SwitchCase what operand to use
	
	//The Calculator Layout
	Pane pane = new Pane();
	Pane displayPane = new Pane();
	GridPane gridPane = new GridPane();
	Label displayLabel = new Label();
	
	//The Buttons
	//First row of buttons	
	Button btnPercent = new Button("%");
	Button btnCE = new Button("CE");
	Button btnClr = new Button("C");
	Button btnBS = new Button("<--");
	//Second row of buttons
	Button btnRcpr = new Button("1/x");
	Button btnSq = new Button("x^2");
	Button btnSqrt = new Button("x^1/2");		
	Button btnDiv = new Button("/");
	//Third row of buttons
	
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) throws Exception
	{
		FormatLayout();
		ArrangeButtons();
		
		//Top function button Actions
		//TODO add percent
		//TODO add backspace
		//TODO add 1/x
		//TODO add x^2
		//TODO add SqRt
		btnCE.setOnAction (e -> displayLabel.setText("")); //Clears the display
		btnClr.setOnAction (e -> displayLabel.setText("")); //Also clears the display
		btnSign.setOnAction (e -> displayLabel.setText("-" + displayLabel.getText())); // Change sign to negative
		btnEqual.setOnAction(e-> calc()); // Calls calc() to perform the operation
		
		//Division
		btnDiv.setOnAction (e ->
		{
			operation = "div";
			numA = Double.parseDouble(displayLabel.getText());
			displayLabel.setText(numA + " / ");
		});
		
		//Multiplication
		btnProd.setOnAction (e ->
		{
			operation = "prod";
			numA = Double.parseDouble(displayLabel.getText());
			displayLabel.setText(numA + " x ");
		});
		
		//Subtraction
		btnMinus.setOnAction (e ->
		{
			operation = "sub";
			numA = Double.parseDouble(displayLabel.getText());
			displayLabel.setText(numA + " - ");
		});
		
		//Addition
		btnAdd.setOnAction (e ->
		{
			operation = "add";
			numA = Double.parseDouble(displayLabel.getText());
			displayLabel.setText(numA + " + ");
		});

		//Number Pad
		btnOne.setOnAction (e -> displayLabel.setText(displayLabel.getText() + "1"));
		btnTwo.setOnAction (e -> displayLabel.setText(displayLabel.getText() + "2"));
		btnThree.setOnAction (e -> displayLabel.setText(displayLabel.getText() + "3"));
		btnFour.setOnAction (e -> displayLabel.setText(displayLabel.getText() + "4"));
		btnFive.setOnAction (e -> displayLabel.setText(displayLabel.getText() + "5"));
		btnSix.setOnAction (e -> displayLabel.setText(displayLabel.getText() + "6"));
		btnSeven.setOnAction (e -> displayLabel.setText(displayLabel.getText() + "7"));
		btnEight.setOnAction (e -> displayLabel.setText(displayLabel.getText() + "8"));
		btnNine.setOnAction (e -> displayLabel.setText(displayLabel.getText() + "9"));
		btnZero.setOnAction (e -> displayLabel.setText(displayLabel.getText() + "0"));
		btnPoint.setOnAction (e -> displayLabel.setText(displayLabel.getText() + "."));

		//Output
		Scene scene = new Scene(pane,475,717);
		primaryStage.setTitle("MyJavaFX"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.setResizable(false);
		primaryStage.show(); // Display the stage
	}
	
	public void FormatLayout() 
	{
		//Parent Pane to hold the other two panes		
		pane.setTranslateX(0);
		pane.setTranslateY(0);
		pane.setStyle("-fx-Background-Color: black");
		
		//Pane for the display
		displayPane.setTranslateX(5);
		displayPane.setTranslateY(5);
		displayPane.setStyle("-fx-Background-Color: #2F4F4F");
		displayPane.getChildren().add(displayLabel);
		
		//Formatting the display
		displayLabel.setFont(Font.font("Courier",FontWeight.BOLD,FontPosture.REGULAR,48));
		displayLabel.setTextFill(Color.GREENYELLOW);
		displayLabel.setStyle("-fx-border-color: blue;");
		displayLabel.setAlignment(Pos.BASELINE_RIGHT); // align text to the right side of the label.
		displayLabel.setPrefSize(465, 100); // set the width and height of the label
		displayLabel.setPadding(new Insets(5,5,5,5));		
		displayLabel.setText("");
		
		//Pane for the buttons
		gridPane.setTranslateX(0);
		gridPane.setTranslateY(105);
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setGridLinesVisible(true);
		gridPane.setPadding(new Insets(5,5,5,5));
		
		pane.getChildren().addAll(displayPane,gridPane);
	}
	
	public void ArrangeButtons() 
	{
		//First row of buttons		
		btnPercent.setPrefHeight(100);
		btnPercent.setPrefWidth(116);
		gridPane.add(btnPercent, 0, 0);
		btnCE.setPrefHeight(100);
		btnCE.setPrefWidth(116);
		gridPane.add(btnCE, 1, 0);
		btnClr.setPrefHeight(100);
		btnClr.setPrefWidth(116);
		gridPane.add(btnClr, 2, 0);
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
		Button btnSeven = new Button("7");
		btnSeven.setPrefHeight(100);
		btnSeven.setPrefWidth(116);
		gridPane.add(btnSeven, 0, 2);
		Button btnEight = new Button("8");
		btnEight.setPrefHeight(100);
		btnEight.setPrefWidth(116);
		gridPane.add(btnEight, 1, 2);
		Button btnNine = new Button("9");
		btnNine.setPrefHeight(100);
		btnNine.setPrefWidth(116);
		gridPane.add(btnNine, 2, 2);
		Button btnProd = new Button("X");
		btnProd.setPrefHeight(100);
		btnProd.setPrefWidth(116);
		gridPane.add(btnProd, 3, 2);		
		
		//Fourth row of buttons
		Button btnFour = new Button("4");
		btnFour.setPrefHeight(100);
		btnFour.setPrefWidth(116);		
		gridPane.add(btnFour, 0, 3);
		Button btnFive = new Button("5");
		btnFive.setPrefHeight(100);
		btnFive.setPrefWidth(116);
		gridPane.add(btnFive, 1, 3);
		Button btnSix = new Button("6");
		btnSix.setPrefHeight(100);
		btnSix.setPrefWidth(116);
		gridPane.add(btnSix, 2, 3);
		Button btnMinus = new Button("-");
		btnMinus.setPrefHeight(100);
		btnMinus.setPrefWidth(116);
		gridPane.add(btnMinus, 3, 3);		
		
		//Fifth row of buttons
		Button btnOne = new Button("1");
		btnOne.setPrefHeight(100);
		btnOne.setPrefWidth(116);		
		gridPane.add(btnOne, 0, 4);
		Button btnTwo = new Button("2");
		btnTwo.setPrefHeight(100);
		btnTwo.setPrefWidth(116);
		gridPane.add(btnTwo, 1, 4);
		Button btnThree = new Button("3");
		btnThree.setPrefHeight(100);
		btnThree.setPrefWidth(116);
		gridPane.add(btnThree, 2, 4);
		Button btnAdd = new Button("+");
		btnAdd.setPrefHeight(100);
		btnAdd.setPrefWidth(116);
		gridPane.add(btnAdd, 3, 4);		
		
		//Sixth row of buttons
		Button btnSign = new Button("+/-");
		btnSign.setPrefHeight(100);
		btnSign.setPrefWidth(116);		
		gridPane.add(btnSign, 0, 5);
		Button btnZero = new Button("0");
		btnZero.setPrefHeight(100);
		btnZero.setPrefWidth(116);
		gridPane.add(btnZero, 1, 5);
		Button btnPoint = new Button(".");
		btnPoint.setPrefHeight(100);
		btnPoint.setPrefWidth(116);
		gridPane.add(btnPoint, 2, 5);
		Button btnEqual = new Button("=");
		btnEqual.setPrefHeight(100);
		btnEqual.setPrefWidth(116);
		gridPane.add(btnEqual, 3, 5);
	}
	
	public void calc() 
	{
		numB = Double.parseDouble(displayLabel.getText());
		switch (operation) 
		{
			case "add": displayLabel.setText(String.valueOf(numA + numB)); break;
			case "sub": displayLabel.setText(String.valueOf(numA - numB)); break;
			case "prod": displayLabel.setText(String.valueOf(numA * numB)); break;
			case "div": displayLabel.setText(String.valueOf(numA / numB)); break;
			default: displayLabel.setText("UNKNOWN OPERATION"); break;		
		}		
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}
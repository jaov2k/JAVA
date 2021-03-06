package KeyEventPKG;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class KeyEventDemo extends Application 
{
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) 
  {
    // Create a pane and set its properties
    Pane pane = new Pane();
    Text text = new Text(20, 20, "A");

    pane.getChildren().add(text);
    text.setOnKeyPressed(e -> // register the KeyPressed event handler with the text "A".
    {          
      switch (e.getCode()) { // now when a key is pressed check and see if it's any of the 4 arrow keys.
        case DOWN: text.setY(text.getY() + 10); break; // move the text down.
        case UP:  text.setY(text.getY() - 10); break;  // move the text up.
        case LEFT: text.setX(text.getX() - 10); break; // move the text left.
        case RIGHT: text.setX(text.getX() + 10); break;// move the text right.
        default: // if a non-arrow key is pressed, display it.
          if (Character.isLetterOrDigit(e.getText().charAt(0)))
            text.setText(e.getText());
      }
    });
    
    // Create a scene and place the pane in the stage
    Scene scene = new Scene(pane);
    primaryStage.setTitle("KeyEventDemo"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.setHeight(400);
    primaryStage.setWidth(400);
    primaryStage.show(); // Display the stage
    
    // only a focused node can recieve key events.
    text.requestFocus(); // text is focused to receive key input
  } // start

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) 
  {
    launch(args);
  } // main
  
} // KeyEventDemo

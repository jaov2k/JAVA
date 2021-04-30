/*JOSE ORTIZ
 * 11/03/2020
 * CIS016 #71514
 * FALL 2020
 * ASSIGNMENT 10 - DRAW SOMETHING 
 * DESCRIPTION: ATTEMPT AT RECREATING THE NINTENDO GAMEBOY FACADE USING BASIC SHAPES AND MULTIMEDIA.
 */
package drawSomethingPkg;

import java.nio.file.Paths;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class DrawSomething extends Application
{
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		//Rectangles
		Rectangle housing = new Rectangle(0,0,597,985);
		housing.setFill(Color.LIGHTGREY);
		housing.setArcHeight(30);
		housing.setArcWidth(30);
		Rectangle screenBezel = new Rectangle(43,82,505,385);
		screenBezel.setFill(Color.DARKGRAY);
		screenBezel.setArcHeight(30);
		screenBezel.setArcWidth(30);
		Rectangle screen = new Rectangle(142,129,319,289);
		screen.setFill(Color.GREENYELLOW);
		Rectangle DPadUpDown = new Rectangle(95,597,54,149);
		DPadUpDown.setFill(Color.BLACK);
		DPadUpDown.setArcHeight(15);
		DPadUpDown.setArcWidth(15);
		Rectangle DPadLeftRight = new Rectangle(49,644,149,54);
		DPadLeftRight.setFill(Color.BLACK);
		DPadLeftRight.setArcHeight(15);
		DPadLeftRight.setArcWidth(15);
		Rectangle btnSelectMid = new Rectangle(0,0,54,17);
		btnSelectMid.setFill(Color.DARKGRAY);
		btnSelectMid.setRotate(-24);
		btnSelectMid.setX(188);
		btnSelectMid.setY(808);
		Rectangle btnStartMid = new Rectangle(0,0,54,17);
		btnStartMid.setFill(Color.DARKGRAY);
		btnStartMid.setRotate(-24);
		btnStartMid.setX(293);
		btnStartMid.setY(808);
		
		//Circles
		Circle btnB = new Circle();
		btnB.setCenterX(420);
		btnB.setCenterY(687);
		btnB.setRadius(36);
		btnB.setFill(Color.RED);
		btnB.setStroke(Color.BLACK);
		btnB.setStrokeWidth(3);
		Circle btnA = new Circle();
		btnA.setCenterX(518);
		btnA.setCenterY(642);
		btnA.setRadius(36);
		btnA.setFill(Color.RED);
		btnA.setStroke(Color.BLACK);
		btnA.setStrokeWidth(3);
		Circle batLED = new Circle();
		batLED.setCenterX(84);
		batLED.setCenterY(228);
		batLED.setRadius(9);
		batLED.setFill(Color.RED);
		Circle btnSelect1 = new Circle();
		btnSelect1.setCenterX(192);
		btnSelect1.setCenterY(827);
		btnSelect1.setRadius(9);
		btnSelect1.setFill(Color.DARKGRAY);
		Circle btnSelect2 = new Circle();
		btnSelect2.setCenterX(241);
		btnSelect2.setCenterY(804);
		btnSelect2.setRadius(9);
		btnSelect2.setFill(Color.DARKGRAY);
		Circle btnStart1 = new Circle();
		btnStart1.setCenterX(293);
		btnStart1.setCenterY(828);
		btnStart1.setRadius(9);
		btnStart1.setFill(Color.DARKGRAY);
		Circle btnStart2 = new Circle();
		btnStart2.setCenterX(343);
		btnStart2.setCenterY(806);
		btnStart2.setRadius(9);
		btnStart2.setFill(Color.DARKGRAY);
		
		//Lines
		Line LongRedLine = new Line(64,102,198,102);
		LongRedLine.setStroke(Color.RED);
		LongRedLine.setStrokeWidth(3);
		Line LongBlackLine = new Line(64,113,198,113);
		LongBlackLine.setStroke(Color.BLACK);
		LongBlackLine.setStrokeWidth(3);
		Line ShortRedLine = new Line(471,102,528,102);
		ShortRedLine.setStroke(Color.RED);
		ShortRedLine.setStrokeWidth(3);
		Line ShortBlackLine = new Line(471,113,528,113);
		ShortBlackLine.setStroke(Color.BLACK);
		ShortBlackLine.setStrokeWidth(3);
		
		//Images
		Image logo = new Image("images/nintendoLogo.png");
		ImageView ivLogo = new ImageView(logo);
		
		//Animation
		TranslateTransition tt = new TranslateTransition();
		tt.setDuration(Duration.seconds(2));
		tt.setNode(ivLogo);
		tt.setFromX(204);
		tt.setFromY(129);
		tt.setToX(204);
		tt.setToY(259);
		
		//Audio
		Media media = new Media(Paths.get("src/audio/audioStartup.wav").toUri().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		MediaView mediaView = new MediaView(mediaPlayer);
		
		//Labels render nicer than Text objects
		Font font = Font.loadFont(Paths.get("src/font/NES_Controller_MrShrike.ttf").toUri().toString(),20);
		Font font2 = Font.loadFont(Paths.get("src/font/NES_Controller_MrShrike.ttf").toUri().toString(),30);
		Label lblBattery = new Label("BATTERY");
		lblBattery.setFont(Font.font("Arial",12));
		lblBattery.setTextFill(Color.WHITE);
		lblBattery.setTranslateX(62);
		lblBattery.setTranslateY(255);
		Label lblHeader = new Label("DOT MATRIX WITH STEREO SOUND");
		lblHeader.setFont(Font.font("Futura",FontWeight.BOLD,14));
		lblHeader.setTextFill(Color.WHITE);
		lblHeader.setTranslateX(210);
		lblHeader.setTranslateY(102);
		Label lblSelect = new Label("SELECT");
		lblSelect.setFont(font);
		lblSelect.setTextFill(Color.BLUE);
		lblSelect.setTranslateX(195);
		lblSelect.setTranslateY(825);
		lblSelect.setRotate(-24);
		Label lblStart = new Label("START");
		lblStart.setFont(font);
		lblStart.setTextFill(Color.BLUE);
		lblStart.setTranslateX(300);
		lblStart.setTranslateY(825);
		lblStart.setRotate(-24);
		Label lblNintendo = new Label("NINTENDO");
		lblNintendo.setFont(font2);
		lblNintendo.setTextFill(Color.BLUE);
		lblNintendo.setTranslateX(43);
		lblNintendo.setTranslateY(491);
		Label lblGameboy = new Label("GAMEBOY");
		lblGameboy.setFont(Font.font("Gill Sans",FontPosture.ITALIC,40));
		lblGameboy.setTextFill(Color.BLUE);
		lblGameboy.setTranslateX(167);
		lblGameboy.setTranslateY(465);
		Label lblBtnB = new Label("B");
		lblBtnB.setFont(font);
		lblBtnB.setTextFill(Color.BLUE);
		lblBtnB.setTranslateX(430);
		lblBtnB.setTranslateY(735);
		lblBtnB.setRotate(-24);
		Label lblBtnA = new Label("A");
		lblBtnA.setFont(font);
		lblBtnA.setTextFill(Color.BLUE);
		lblBtnA.setTranslateX(530);
		lblBtnA.setTranslateY(690);
		lblBtnA.setRotate(-24);
		
		//Panes
		Pane pane = new Pane();
		pane.setStyle("-fx-background-color: BLACK");
		pane.getChildren().add(housing);
		pane.getChildren().add(screenBezel);
		pane.getChildren().add(lblHeader);
		pane.getChildren().add(LongRedLine);
		pane.getChildren().add(LongBlackLine);
		pane.getChildren().add(ShortRedLine);
		pane.getChildren().add(ShortBlackLine);
		pane.getChildren().add(screen);
		pane.getChildren().add(DPadUpDown);
		pane.getChildren().add(DPadLeftRight);
		pane.getChildren().add(btnA);
		pane.getChildren().add(btnB);
		pane.getChildren().add(batLED);
		pane.getChildren().add(lblBattery);
		pane.getChildren().add(btnSelect1);
		pane.getChildren().add(btnSelect2);
		pane.getChildren().add(btnSelectMid);
		pane.getChildren().add(btnStart1);
		pane.getChildren().add(btnStart2);
		pane.getChildren().add(btnStartMid);
		pane.getChildren().add(lblSelect);
		pane.getChildren().add(lblStart);
		pane.getChildren().add(lblNintendo);
		pane.getChildren().add(lblGameboy);
		pane.getChildren().add(lblBtnB);
		pane.getChildren().add(lblBtnA);
		pane.getChildren().add(ivLogo);
		pane.getChildren().add(mediaView);
		
		//Scene and Stage
		tt.play();
		mediaPlayer.play();
		Scene scene = new Scene(pane,597,985);
		primaryStage.setTitle("Draw Something");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args)
	{
		launch(args);
	}

}
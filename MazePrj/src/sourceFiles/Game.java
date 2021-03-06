// Example game.
// Modify it to:
// 1. Use Abstract Class(s)
// 2. Use Interfaces
// 3. more inheritance.
// 4. background music
// 5. add enemies
// 6. add score
// 7. collision detection between player and walls
//    between player bullets and enemies
//    between enemy bullets and player
// 8. Use the MVC paradigm (Model, View, Controller)
// 9. health bar, when get hit by enemy bullet it decreases.
// 10. treasure that increases health
// 11. multiple levels (go out through a door in current level to get to next level)
//     or kill all enemies in current level, or reach a certain score etc.
// 12. game over screen.
// 13. victory screen.
// 14. whatever else you'd like.

/**
 * http://stackoverflow.com/questions/29057870/in-javafx-how-do-i-move-a-sprite-across-the-screen
 * http://silveiraneto.net/2008/12/08/javafx-how-to-create-a-rpg-like-game/
 */

package sourceFiles;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Stage;

public class Game extends Application {

    Random rnd = new Random();

    Pane playfieldLayer;
    Pane scoreLayer; 

    Image playerImage = new Image("images/Player_560x372.png");
    Image playerAttackImage = new Image("images/PlayerAttack_70x373.png");
	Image playerBubbleImage = new Image("images/Player_Bubble_52x104.png");
    Image enemyImage = new Image("images/Enemy1_160x368.png");
    Image maze01  = new Image("images/Room1_1900x998.png");
    
    Player player;
    Input input;

    List<Item> items = new ArrayList<>();
    List<Item> weapons = new ArrayList<>();
    

    Text scoreText = new Text();

    int score = 0;
    
    Scene scene;

    int currentScene = 1;
    Group root;
    ImageView mazeView;
        
    AnimationTimer gameLoop;
    
    @Override
    public void start(Stage primaryStage) {    	
    	
        root = new Group();
        
        mazeView = new ImageView(maze01);
       
        //obstacles = obstacles01;
            
        // create layers
        playfieldLayer = new Pane();
        scoreLayer = new Pane();
        
        playfieldLayer.getChildren().add(mazeView);
           
        root.getChildren().add( playfieldLayer);
        root.getChildren().add( scoreLayer);

        scene = new Scene( root, Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);
             
        primaryStage.setScene(scene);
        primaryStage.show();
        
        // player input
        input = new Input(scene);

        // register input listeners
        input.addListeners(); // TODO: remove listeners on game over

        // create player
        player = new Player(playfieldLayer, playerImage, 128, 543, 0, 0, 0, 0, Settings.PLAYER_HEALTH, Settings.PLAYER_DAMAGE, Settings.PLAYER_SPEED, input,playerBubbleImage,playerAttackImage);
        player.setSpriteAnimation();
        
        createScoreLayer();
        
        addEnemy(701, 723, enemyImage);
                              
        gameLoop = new AnimationTimer() {
        	
            private long lastUpdate = 0 ;
            @Override
            public void handle(long now) {

                // player input
                player.processInput();
                
                // movement
                player.move();
                weapons.forEach(sprite -> sprite.move());
                
                player.attack(weapons);
                player.reloadSword();
                
                // check collisions
                checkCollisions();
                
                checkDamage();
                
                changeScene(primaryStage);

                // update sprites in scene
                player.updateUI();
                weapons.forEach(sprite -> sprite.updateUI());

                // check if sprite can be removed

                // remove removables from list, layer, etc
                removeSprites( weapons);
                removeSprites( items);

                // update score, health, etc
                updateScore();
                
                gameOver(primaryStage);
                victory(primaryStage);
            }

        };
        gameLoop.start();

    }
   

    private void createScoreLayer() {

    }
    
    
    private void addEnemy(double x, double y, Image enemyImage) {
    	
    }
    
    private void addEnemyFly(double x, double y, Image enemyImage) {
    	
    }

    private void spawnEnemies( boolean random) {

    }

    private void removeSprites(  List<? extends SpriteBase> spriteList) {
        Iterator<? extends SpriteBase> iter = spriteList.iterator();
        while( iter.hasNext()) {
            SpriteBase sprite = iter.next();

            if( sprite.isRemovable()) {

                // remove from layer
                sprite.removeFromLayer();

                // remove from list
                iter.remove();
                
            }
        }
    }
    
    private void dropItem(double x, double y, Image image) {
    }

    private void checkCollisions() {

 
    }
    
    private void checkDamage() {
    }
    
    // go to a different level by exiting/entering through a door on the current level
    private void changeScene(Stage primaryStage) {
    }
    
    private void moveToScene01(double x, double y, Stage primaryStage) {
    	currentScene = 1;
    	root = new Group();
        playfieldLayer = new Pane();   	        
        scoreLayer = new Pane();  
		root.getChildren().addAll(playfieldLayer,scoreLayer);
        mazeView = new ImageView(maze01);   	           	        
        playfieldLayer.getChildren().add(mazeView);   	               
        scene = new Scene(root,Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);
        primaryStage.setScene(scene);
        createScoreLayer();
        player.setX(x);
        player.setY(y);
        player.setLayer(playfieldLayer);
        player.addToLayer();
        input.setScene(scene);
        input.addListeners();
        items.clear();
        addEnemy(701, 723, enemyImage);

    }
    
    private void moveToScene02(double x, double y, Stage primaryStage) {
        
    }
    
    private void moveToScene03(double x, double y, Stage primaryStage) {
    }
    
    private void moveToScene04(double x, double y, Stage primaryStage) {
    }
    
    private void updateScore() {
    }
    
    private void gameOver(Stage primaryStage) {
    }
    
    private void victory(Stage primaryStage) {
    }

    public static void main(String[] args) {
        launch(args);
    }

}
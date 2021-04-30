package sourceFiles;

import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Enemy extends SpriteBase {

    HealthBar healthBar;

    double healthMax;
    
    SpriteAnimation enemy_animation;

    public Enemy(Pane layer, Image image, double x, double y, double r, double dx, double dy, double dr, double health, double damage) {

        super(layer, image, x, y, r, dx, dy, dr, health, damage);

        healthMax = Settings.ENEMY_HEALTH;

        setHealth(healthMax);

    }

    @Override
    public void checkRemovability() {

        if( Double.compare( getY(), Settings.SCENE_HEIGHT) > 0) {
            setRemovable(true);
        }

    }

    public void addToLayer() {

        super.addToLayer();

        // create health bar; has to be created here because addToLayer is called in super constructor
        // and it wouldn't exist yet if we'd create it as class member
        healthBar = new HealthBar();

        this.layer.getChildren().add(this.healthBar);

    }

    public void removeFromLayer() {

        super.removeFromLayer();

        this.layer.getChildren().remove(this.healthBar);

    }

    /**
     * Health as a value from 0 to 1.
     * @return
     */
    public double getRelativeHealth() {
        return getHealth() / healthMax;
    }


    public void updateUI() {

        super.updateUI();

        // update health bar
        healthBar.setValue( getRelativeHealth());

        // locate healthbar above enemy, centered horizontally
        healthBar.relocate(x + (imageView.getBoundsInLocal().getWidth() - healthBar.getBoundsInLocal().getWidth()) / 2, y - healthBar.getBoundsInLocal().getHeight() - 4);      
    }
    
    public void setSpriteAnimation() {
        imageView.setViewport(new Rectangle2D(Settings.EoffsetX, Settings.EoffsetY, Settings.Ewidth, Settings.Eheight));
        enemy_animation = new SpriteAnimation(
        		imageView,
                Duration.millis(900),
                Settings.Ecount, Settings.Ecolumns,
                Settings.EoffsetX, Settings.EoffsetY,
                Settings.Ewidth, Settings.Eheight
        );
        enemy_animation.setCycleCount(Animation.INDEFINITE);
        enemy_animation.setOffsetY(Settings.Pheight);
        enemy_animation.play();// sets animation to run indefinitely
    }
}
package sourceFiles;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MySounds {

	protected static final String AudioPlayer = null;
	
	public Clip Background  = loadClip("/sounds/Main_BGM.wav");
	public Clip PlayerAttack  = loadClip("/sounds/Player_attack.wav");
	public Clip BossBackground  = loadClip("/sounds/Boss_BGM.wav");
	public Clip BossAttack  = loadClip("/sounds/Boss_attack.wav");
	public Clip VictoryBackground = loadClip("/sounds/VictoryScreen_BGM.wav");
	
	
	/**
	 * Create the frame.
	 */
	public MySounds() {
		
	} // MySounds constructor

	public Clip loadClip(String filename)
	{
		Clip clip = null;
		
		try
		{
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(getClass().getResource(filename));
			clip = AudioSystem.getClip();
			clip.open( audioIn );
		}// try
		catch (Exception e)
		{
			e.printStackTrace();
		}// catch
		
		return(clip);
		
	} // Clip
	
	public void playClip( int index )
	{
		if (index == 1) {
		   stopClip(1);
		   Background.loop(-1);
		   Background.start();
		}
		else if (index == 2) {
		   if (!PlayerAttack.isRunning()) {
		      stopClip(2);
		      PlayerAttack.start();
		   }
		}
		else if (index == 3) {
			   if (!BossBackground.isRunning()) {
			      stopClip(3);
			      BossBackground.loop(-1);
			      BossBackground.start();
			   }
			}
		else if (index == 4) {
			   if (!BossAttack.isRunning()) {
			      stopClip(4);
			      BossAttack.start();
			   }
			}
		else if (index == 5) {
			   if (!VictoryBackground.isRunning()) {
			      stopClip(5);
			      VictoryBackground.loop(-1);
			      VictoryBackground.start();
			   }
			}
	} // playClip
	
	public void stopClip( int index )
	{
		if (index == 1) {
		   if (Background.isRunning() )
			   Background.stop();
		   Background.setFramePosition(0);
		}
		else if (index == 2) {
		   if (PlayerAttack.isRunning() )
			   PlayerAttack.stop();
		   PlayerAttack.setFramePosition(0);
		}
		else if (index == 3) {
			   if (BossBackground.isRunning() )
				   BossBackground.stop();
			   BossBackground.setFramePosition(0);
			}
		else if (index == 4) {
			   if (BossAttack.isRunning() )
				   BossAttack.stop();
			   BossAttack.setFramePosition(0);
			}
		else if (index == 5) {
			   if (VictoryBackground.isRunning() )
				   VictoryBackground.stop();
			   VictoryBackground.setFramePosition(0);
			}
		
	} // stopClip
	
} // MySounds class

package pacman;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class PowerPellet extends Pellet {
	
	private int x;
	private int y;
	
	public PowerPellet(int x, int y) throws SlickException {
		// TODO Auto-generated constructor stub
		super(x, y);
		this.x = x;
		this.y = y;
		pelletAnimation = new Animation(new SpriteSheet("animations/powerPellet.png", 8, 8), 100);
	}
	
	public void draw() {
		pelletAnimation.draw(this.x * 8, this.y * 8);
	}
	
	String pelletType() {
		return "powerPellet";
	}

}

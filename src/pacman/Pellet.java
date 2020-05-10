package pacman;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Pellet {

	private int x;
	private int y;
	protected Animation pelletAnimation;
	
	public Pellet(int x, int y) throws SlickException {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		pelletAnimation = new Animation(new SpriteSheet("animations/pellet.png", 2, 2), 100);
	}
	
	public void draw() {
		pelletAnimation.draw(this.x * 8 + 3, this.y * 8 + 3);
	}
	
	int getX() {
		return this.x;
	}
	
	int getY() {
		return this.y;
	}
	
	String pelletType() {
		return "normalPellet";
	}
	
	boolean checkEat(int pacX, int pacY) {
		if (this.getX() == pacX && this.getY() == pacY) {
			return true;
		}
		else {
			return false;
		}
	}
}

package pacman;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class MapAnimation {

	private Animation mapAnimation;
	
	public MapAnimation() throws SlickException {
		// TODO Auto-generated constructor stub
		this.mapAnimation = new Animation(new SpriteSheet("map/mapAnimation.png", 224, 248), 200);
		this.mapAnimation.stopAt(0);
	}
	
	void draw() {
		mapAnimation.draw(0, 0);
	}
	
	void play() throws SlickException {
		this.mapAnimation = new Animation(new SpriteSheet("map/mapAnimation.png", 224, 248), 200);
	}
	
	void singleFrame() {
		this.mapAnimation.stopAt(0);
	}
}

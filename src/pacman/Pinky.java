package pacman;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Pinky extends Ghost implements Reset {

	public Pinky(Map map, int x, int y) throws SlickException {
		// TODO Auto-generated constructor stub
		super(map, x , y);
		moveRight = new SpriteSheet("animations/pinkyRight.png", 8, 8);
		moveLeft = new SpriteSheet("animations/pinkyLeft.png", 8, 8);
		moveUp = new SpriteSheet("animations/pinkyUp.png", 8, 8);
		moveDown = new SpriteSheet("animations/pinkyDown.png", 8, 8);
		this.initializeAnimation();
		this.setDirection("right");
	}

	@Override
	public int resetCharacterX() throws SlickException {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int resetCharacterY() throws SlickException {
		// TODO Auto-generated method stub
		return 1;
	}
}

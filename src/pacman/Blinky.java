package pacman;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Blinky extends Ghost implements Reset {

	public Blinky(Map map, int x, int y) throws SlickException {
		// TODO Auto-generated constructor stub
		super(map, x, y);
		moveRight = new SpriteSheet("animations/blinkyRight.png", 8, 8);
		moveLeft = new SpriteSheet("animations/blinkyLeft.png", 8, 8);
		moveUp = new SpriteSheet("animations/blinkyUp.png", 8, 8);
		moveDown = new SpriteSheet("animations/blinkyDown.png", 8, 8);
		this.initializeAnimation();
		this.setDirection("left");
	}

	@Override
	public int resetCharacterX() throws SlickException {
		// TODO Auto-generated method stub
		return 26;
	}

	@Override
	public int resetCharacterY() throws SlickException {
		// TODO Auto-generated method stub
		return 1;
	}

}

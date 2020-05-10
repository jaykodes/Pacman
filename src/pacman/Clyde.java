package pacman;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Clyde extends Ghost implements Reset {

	public Clyde(Map map, int x, int y) throws SlickException {
		// TODO Auto-generated constructor stub
		super(map, x, y);
		moveRight = new SpriteSheet("animations/clydeRight.png", 8, 8);
		moveLeft = new SpriteSheet("animations/clydeLeft.png", 8, 8);
		moveUp = new SpriteSheet("animations/clydeUp.png", 8, 8);
		moveDown = new SpriteSheet("animations/clydeDown.png", 8, 8);
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
		return 29;
	}
}

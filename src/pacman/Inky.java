package pacman;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Inky extends Ghost implements Reset {

	public Inky(Map map, int x, int y) throws SlickException {
		// TODO Auto-generated constructor stub
		super(map, x, y);
		moveRight = new SpriteSheet("animations/inkyRight.png", 8, 8);
		moveLeft = new SpriteSheet("animations/inkyLeft.png", 8, 8);
		moveUp = new SpriteSheet("animations/inkyUp.png", 8, 8);
		moveDown = new SpriteSheet("animations/inkyDown.png", 8, 8);
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
		return 29;
	}
}

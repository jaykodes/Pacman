package pacman;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Pacman extends Character implements Reset {
	
	public Pacman(int x, int y) throws SlickException {
		// TODO Auto-generated constructor stub
		super(x, y);
		moveRight = new SpriteSheet("animations/pacmanRight.png", 8, 8);
		moveLeft = new SpriteSheet("animations/pacmanLeft.png", 8, 8);
		moveUp = new SpriteSheet("animations/pacmanUp.png", 8, 8);
		moveDown = new SpriteSheet("animations/pacmanDown.png", 8, 8);
		this.initializeAnimation();
		this.setDirection("right");
	}
	
	void draw() {
		this.draw(this.getXPos(), this.getYPos());
	}
	
	void die() throws SlickException {
		this.currentAnimation = new Animation(new SpriteSheet("animations/pacmanDie.png", 8, 8), 100);
		currentAnimation.setLooping(false);
	}
	
	void win() throws SlickException {
		this.currentAnimation = new Animation(new SpriteSheet("animations/pacmanWin.png", 8, 8), 100);
		currentAnimation.setLooping(false);
	}

	@Override
	public int resetCharacterX() throws SlickException {
		// TODO Auto-generated method stub
		return 13;
	}

	@Override
	public int resetCharacterY() throws SlickException {
		// TODO Auto-generated method stub
		return 17;
	}
	
}

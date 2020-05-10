package pacman;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SpriteSheet;

public class Character {
	
	private String direction;
	private int x,y;
	
	protected SpriteSheet moveRight;
	protected SpriteSheet moveLeft;
	protected SpriteSheet moveUp;
	protected SpriteSheet moveDown;

	private Animation moveRightAnimation;
	private Animation moveLeftAnimation;
	private Animation moveUpAnimation;
	private Animation moveDownAnimation;
	protected Animation currentAnimation;
	
	Character(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	void initializeAnimation() {
		this.moveRightAnimation = new Animation(moveRight, 100);
		this.moveLeftAnimation = new Animation(moveLeft, 100);
		this.moveUpAnimation = new Animation(moveUp, 100);
		this.moveDownAnimation = new Animation(moveDown, 100);
		this.currentAnimation = moveRightAnimation;
	}
	
	void draw(float x, float y) {
		currentAnimation.draw(this.x * 8, this.y * 8);
	}
	
	void goRight() {
		this.currentAnimation = this.moveRightAnimation;
	}
	
	void goLeft() {
		this.currentAnimation = this.moveLeftAnimation;
	}
	
	void goUp() {
		this.currentAnimation = this.moveUpAnimation;
	}
	
	void goDown() {
		this.currentAnimation = this.moveDownAnimation;
	}
	
	void setDirection(String direction) {
		this.direction = direction;
	}
	
	String getDirection() {
		return this.direction;
	}
	
	int getXPos() {
		return this.x;
	}
	int getYPos() {
		return this.y;
	}
	void setXPos(int x) {
		this.x = x;
	}
	void setYPos(int y) {
		this.y = y;
	}
	void updateXPos(int x) {
		this.x += x;
	}
	void updateYPos(int y) {
		this.y += y;
	}
}

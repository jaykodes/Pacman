package pacman;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Ghost extends Character implements Scatter {
	
	private Map map;
	private boolean invincible;
	
	public Ghost(Map map, int x, int y) {
		super(x, y);
		this.map = map;
		this.invincible = false;
	}
	
	void draw() {
		this.draw(this.getXPos(), this.getYPos());
	}
	
	String findShortestPath(int pacX, int pacY, int ghostX, int ghostY) {
		int vertical = ghostY - pacY;
		int horizontal = ghostX - pacX;
		
		if (Math.abs(vertical) >= Math.abs(horizontal)) {
			if (vertical <= 0) {//want to do downwards
				if (map.checkDown(ghostX, ghostY) && !(this.getDirection().equals("up"))) {
					return "down";
				}
				else if (map.checkLeft(ghostX, ghostY) && !(this.getDirection().equals("right"))) {
					return "left";
				}
				else if (map.checkRight(ghostX, ghostY) && !(this.getDirection().equals("left"))) {
					return "right";
				}
				else {
					return "up";
				}
			}
			else {//want to go upwards
				if (map.checkUp(ghostX, ghostY) && !(this.getDirection().equals("down"))) {
					return "up";
				}
				else if (map.checkLeft(ghostX, ghostY) && !(this.getDirection().equals("right"))) {
					return "left";
				}
				else if (map.checkRight(ghostX, ghostY) && !(this.getDirection().equals("left"))) {
					return "right";
				}
				else {
					return "down";
				}
			}
		}
		else {
			if (horizontal <= 0) {//want to do rightwards
				if (map.checkRight(ghostX, ghostY) && !(this.getDirection().equals("left"))) {
					return "right";
				}
				else if (map.checkUp(ghostX, ghostY) && !(this.getDirection().equals("down"))) {
					return "up";
				}
				else if (map.checkDown(ghostX, ghostY) && !(this.getDirection().equals("up"))) {
					return "down";
				}
				else {
					return "left";
				}
			}
			else {//want to go leftwards
				if (map.checkLeft(ghostX, ghostY) && !(this.getDirection().equals("right"))) {
					return "left";
				}
				else if (map.checkUp(ghostX, ghostY) && !(this.getDirection().equals("down"))) {
					return "up";
				}
				else if (map.checkDown(ghostX, ghostY) && !(this.getDirection().equals("up"))) {
					return "down";
				}
				else {
					return "right";
				}
			}
		}
	}
	
	@Override
	public int scatter() throws SlickException {
		// TODO Auto-generated method stub
		return -1;
	}
	
	void runAway() throws SlickException {
		this.currentAnimation = new Animation(new SpriteSheet("animations/ghostScared.png", 8, 8), 100);
	}
	
	void setInvincible(boolean state) {
		this.invincible = state;
	}
	
	boolean getInvincible() {
		return this.invincible;
	}
}

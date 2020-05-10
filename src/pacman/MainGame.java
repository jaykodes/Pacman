/*
 * The mainGame class
 * runs the pacman game
 */

package pacman;

import java.util.ArrayList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

//the MainGame extends the BasicGame and therefore takes some of the functions
public class MainGame extends BasicGameState {

	private int ID;
	private Pacman pacman;// holds pacman object
	private Map map;// holds map object
	private MapAnimation mapAni;// holds mapAnimation object
	private Blinky blinky;// holds blinky object
	private Pinky pinky;// holds pinky object
	private Inky inky;// holds inky object
	private Clyde clyde;// holds clyde object
	private ArrayList<Pellet> pellets = new ArrayList<Pellet>();// holds a list of pellets
	private int score = 0;// holds player score
	private int lives = 3;// holds the number of lives
	private boolean paused = true;// holds if the game is paused
	private int timer = 0;// counter to check how much time has passed by
	private int powerTimer = 0;// counter to check how much time has passed by
	private int updateCounter = 0;// counter to check if the number of updates
	private int blinkyModulus = 7;// counter to check how many times blinky will be updated
	private boolean notDoneSixth = true;// counter to check if only a sixth of the pellets are left
	private boolean notDoneTenth = true;// counter to check if only a tenth of the pellets are left
	private boolean win = true;// boolean to check if player won
	private boolean invincible = false;//checks if player ate power pellet
	
	//MainGame takes in a title; the title of the game
	public MainGame(int ID) throws SlickException {//makes a MainGame function
		this.ID = ID; 
		// TODO Auto-generated constructor stub
	}
	
	//pacmanMovement takes in a GameContainer so that player can input key; will be able to move pacman around; takes no parameters and returns nothing
	public void pacmanMovement(GameContainer container) {
		String input = pacman.getDirection();//gets the current direction of pacman
		Input gameInput = container.getInput();//gets the key input from the keyboard
		
		if (gameInput.isKeyDown(Input.KEY_RIGHT) && map.checkRight(pacman.getXPos(), pacman.getYPos())) {//checks if player presses right arrow key and going right is possible in the map
			pacman.setDirection("right");//set pacman direction to be right
		}
		else if (gameInput.isKeyDown(Input.KEY_LEFT) && map.checkLeft(pacman.getXPos(), pacman.getYPos())) {//checks if player presses left arrow key and going left is possible in the map
			pacman.setDirection("left");//set pacman direction to be left
		}
		else if (gameInput.isKeyDown(Input.KEY_UP) && map.checkUp(pacman.getXPos(), pacman.getYPos())) {//checks if player presses up arrow key and going up is possible in the map
			pacman.setDirection("up");//set pacman direction to be up
		}
		else if (gameInput.isKeyDown(Input.KEY_DOWN) && map.checkDown(pacman.getXPos(), pacman.getYPos())) {//checks if player presses down arrow key and going down is possible in the map
			pacman.setDirection("down");//set pacman direction to be down
		}
		
		if (pacman.getDirection().equals("right")) {//checks if the current pacman direction is right
			if (map.checkRight(pacman.getXPos(), pacman.getYPos())) {//checks if pacman can go right in the map
				pacman.goRight();//calls the goRight function from the pacman object
				pacman.updateXPos(1);//add to the pacman x position
			}
			else {//going right is not possible
				pacman.setDirection(input);//sets direction back to the inital direction before
			}
		}
		else if (pacman.getDirection().equals("left")) {//checks if the current pacman direction is left
			if (map.checkLeft(pacman.getXPos(), pacman.getYPos())) {//checks if pacman can go left in the map
				pacman.goLeft();//calls the goLeft function from the pacman object
				pacman.updateXPos(-1);//decreases to the pacman x position
			}
			else {//going left is not possible
				pacman.setDirection(input);//sets direction back to the inital direction before
			}
		}
		else if (pacman.getDirection().equals("up")) {//checks if the current pacman direction is up
			if (map.checkUp(pacman.getXPos(), pacman.getYPos())) {//checks if pacman can go up in the map
				pacman.goUp();//calls the goUp function from the pacman object
				pacman.updateYPos(-1);//decreases to the pacman y position
			}
			else {//going up is not possible
				pacman.setDirection(input);//sets direction back to the inital direction before
			}
		}
		else if (pacman.getDirection().equals("down")) {//checks if the current pacman direction is down
			if (map.checkDown(pacman.getXPos(), pacman.getYPos())) {//checks if pacman can go down in the map
				pacman.goDown();//calls the goDown function from the pacman object
				pacman.updateYPos(1);//adds to the pacman y position
			}
			else {//going down is not possible
				pacman.setDirection(input);//sets direction back to the inital direction before
			}
		}
	}
	
	//ghostMovement takes in a ghost and a string; the ghost will be changing direction depending on the move string; returns nothing
	void ghostMovement(Ghost ghost, String move) {
		//System.out.println(move);
		if (move.equals("right")) {//checks if ghost needs to move left
			if (map.checkRight(ghost.getXPos(), ghost.getYPos())) {//checks if ghost can go right in the map
				ghost.goRight();//calls the goRight function from the ghost object
				ghost.setDirection("right");//sets ghost direction to be right
				ghost.updateXPos(1);//adds to ghost x position
			}
		}
		else if (move.equals("left")) {//checks if ghost needs to move left
			if (map.checkLeft(ghost.getXPos(), ghost.getYPos())) {//checks if ghost can go left in the map
				ghost.goLeft();//calls the goLeft function from the ghost object
				ghost.setDirection("left");//sets ghost direction to be left
				ghost.updateXPos(-1);//subtracts from ghost x position
			}
		}
		else if (move.equals("up")) {//checks if ghost needs to move up
			if (map.checkUp(ghost.getXPos(), ghost.getYPos())) {//checks if ghost can go up in the map
				ghost.goUp();//calls the goUp function from the ghost object
				ghost.setDirection("up");//sets ghost direction to be up
				ghost.updateYPos(-1);//subtracts from ghost y position
			}
		}
		else if (move.equals("down")) {//checks if ghost needs to move down
			if (map.checkDown(ghost.getXPos(), ghost.getYPos())) {//checks if ghost can go down in the map
				ghost.goDown();//calls the goDown function from the ghost object
				ghost.setDirection("down");//sets ghost direction to be down
				ghost.updateYPos(1);//adds to ghost y position
			}
		}
	}
	
	//blinkyMovement will be able to move blinky around autonomously; takes no parameters and returns nothing
	public void blinkyMovement() throws SlickException {
		String blinkyMove;
		
		if (blinky.getInvincible()) {
			blinkyMove = blinky.findShortestPath(26, 1, blinky.getXPos(), blinky.getYPos());
			ghostMovement(blinky, blinkyMove);
			blinky.runAway();
		}
		else {
			blinkyMove = blinky.findShortestPath(pacman.getXPos(), pacman.getYPos(), blinky.getXPos(), blinky.getYPos());//will find the direction to the shortest path from blinky to pacman
			ghostMovement(blinky, blinkyMove);
		}
	}
	
	//pinkyMovement will be able to move pinky around autonomously; takes no parameters and returns nothing
	public void pinkyMovement() throws SlickException {
		String pinkyMove;//will gold the direction to the shortest path from pinky to pacman
		
		if (pinky.getInvincible()) {
			pinkyMove = pinky.findShortestPath(1, 1, pinky.getXPos(), pinky.getYPos());
			ghostMovement(pinky, pinkyMove);
			pinky.runAway();
		}
		else if (pacman.getDirection().equals("right")) {//checks if pacman current direction is right
			pinkyMove = pinky.findShortestPath((pacman.getXPos() + 4), pacman.getYPos(), pinky.getXPos(), pinky.getYPos());//will find the direction to the shortest path from pinky to pacman if pacman's direction is right
			ghostMovement(pinky, pinkyMove);
		}
		else if (pacman.getDirection().equals("left")) {//checks if pacman current direction is left
			pinkyMove = pinky.findShortestPath((pacman.getXPos() - 4), pacman.getYPos(), pinky.getXPos(), pinky.getYPos());//will find the direction to the shortest path from pinky to pacman if pacman's direction is left
			ghostMovement(pinky, pinkyMove);
		}
		else if (pacman.getDirection().equals("down")) {//checks if pacman current direction is down
			pinkyMove = pinky.findShortestPath(pacman.getXPos(), (pacman.getYPos() + 4), pinky.getXPos(), pinky.getYPos());//will find the direction to the shortest path from pinky to pacman if pacman's direction is down
			ghostMovement(pinky, pinkyMove);
		}
		else if (pacman.getDirection().equals("up")) {//checks if pacman current direction is up
			pinkyMove = pinky.findShortestPath((pacman.getXPos() - 4), (pacman.getYPos() - 4), pinky.getXPos(), pinky.getYPos());//will find the direction to the shortest path from pinky to pacman if pacman's direction is up
			ghostMovement(pinky, pinkyMove);
		}
	}
	
	//inkyMovement will be able to move inky around autonomously; takes no parameters and returns nothing
	public void inkyMovement() throws SlickException {
		String inkyMove;//will gold the direction to the shortest path from pinky to pacman
		int hori, vert;//will hold the manipulated horizontal and vertical position from inky to pacman
		
		if (inky.getInvincible()) {
			inkyMove = inky.findShortestPath(26, 29, inky.getXPos(), inky.getYPos());
			ghostMovement(inky, inkyMove);
			inky.runAway();
		}
		else if (pacman.getDirection().equals("right")) {//checks if pacman current direction is right
			hori = Math.abs((pacman.getXPos()  + 2) - blinky.getXPos());//calculates the horizontal distance from inky to pacman
			vert = Math.abs(pacman.getYPos() - blinky.getYPos());//calculates the veritcal distance from inky to pacman
			
			if ((pacman.getXPos()  + 4) <= blinky.getXPos() && pacman.getYPos() <= blinky.getYPos()) {//inky's go to position will be in the top left corner
				inkyMove = inky.findShortestPath(((pacman.getXPos()  + 2) - hori), (pacman.getYPos() - vert), inky.getXPos(), inky.getYPos());//will find the direction to the shortest path from pinky to pacman if pacman's direction is right
			}
			else if ((pacman.getXPos()  + 4) > blinky.getXPos() && pacman.getYPos() <= blinky.getYPos()) {//inky's go to position will be in the top right corner
				inkyMove = inky.findShortestPath(((pacman.getXPos()  + 2) + hori), (pacman.getYPos() - vert), inky.getXPos(), inky.getYPos());//will find the direction to the shortest path from pinky to pacman if pacman's direction is right
			}
			else if ((pacman.getXPos()  + 4) <= blinky.getXPos() && pacman.getYPos() > blinky.getYPos()) {//inky's go to position will be in the bottom left corner
				inkyMove = inky.findShortestPath(((pacman.getXPos()  + 2) - hori), (pacman.getYPos() + vert), inky.getXPos(), inky.getYPos());//will find the direction to the shortest path from pinky to pacman if pacman's direction is right
			}
			else {//inky's go to position will be in the bottom right corner
				inkyMove = inky.findShortestPath(((pacman.getXPos()  + 2) + hori), (pacman.getYPos() + vert), inky.getXPos(), inky.getYPos());//will find the direction to the shortest path from pinky to pacman if pacman's direction is right
			}
			
			ghostMovement(inky, inkyMove);
		}
		else if (pacman.getDirection().equals("left")) {//checks if pacman current direction is left
			hori = Math.abs((pacman.getXPos()  - 2) - blinky.getXPos());//calculates the horizontal distance from inky to pacman
			vert = Math.abs(pacman.getYPos() - blinky.getYPos());//calculates the vertical distance from inky to pacman
			
			if ((pacman.getXPos()  + 4) <= blinky.getXPos() && pacman.getYPos() <= blinky.getYPos()) {//inky's go to position will be in the top left corner
				inkyMove = inky.findShortestPath(((pacman.getXPos()  - 2) - hori), (pacman.getYPos() - vert), inky.getXPos(), inky.getYPos());//will find the direction to the shortest path from pinky to pacman if pacman's direction is left
			}
			else if ((pacman.getXPos()  + 4) > blinky.getXPos() && pacman.getYPos() <= blinky.getYPos()) {//inky's go to position will be in the top right corner
				inkyMove = inky.findShortestPath(((pacman.getXPos()  - 2) + hori), (pacman.getYPos() - vert), inky.getXPos(), inky.getYPos());//will find the direction to the shortest path from pinky to pacman if pacman's direction is left
			}
			else if ((pacman.getXPos()  + 4) <= blinky.getXPos() && pacman.getYPos() > blinky.getYPos()) {//inky's go to position will be in the bottom left corner
				inkyMove = inky.findShortestPath(((pacman.getXPos()  - 2) - hori), (pacman.getYPos() + vert), inky.getXPos(), inky.getYPos());//will find the direction to the shortest path from pinky to pacman if pacman's direction is left
			}
			else {//inky's go to position will be in the bottom right corner
				inkyMove = inky.findShortestPath(((pacman.getXPos()  - 2) + hori), (pacman.getYPos() + vert), inky.getXPos(), inky.getYPos());//will find the direction to the shortest path from pinky to pacman if pacman's direction is left
			}
			
			ghostMovement(inky, inkyMove);
		}
		else if (pacman.getDirection().equals("down")) {//checks if pacman current direction is down
			hori = Math.abs(pacman.getXPos()  - blinky.getXPos());//calculates the horizontal distance from inky to pacman
			vert = Math.abs((pacman.getYPos() + 2) - blinky.getYPos());//calculates the vertical distance from inky to pacman
			
			if ((pacman.getXPos()  + 4) <= blinky.getXPos() && pacman.getYPos() <= blinky.getYPos()) {//inky's go to position will be in the top left corner
				inkyMove = inky.findShortestPath((pacman.getXPos()  - hori), ((pacman.getYPos() + 2) - vert), inky.getXPos(), inky.getYPos());//will find the direction to the shortest path from pinky to pacman if pacman's direction is down
			}
			else if ((pacman.getXPos()  + 4) > blinky.getXPos() && pacman.getYPos() <= blinky.getYPos()) {//inky's go to position will be in the top right corner
				inkyMove = inky.findShortestPath((pacman.getXPos()  + hori), ((pacman.getYPos() + 2) - vert), inky.getXPos(), inky.getYPos());//will find the direction to the shortest path from pinky to pacman if pacman's direction is down
			}
			else if ((pacman.getXPos()  + 4) <= blinky.getXPos() && pacman.getYPos() > blinky.getYPos()) {//inky's go to position will be in the bottom left corner
				inkyMove = inky.findShortestPath((pacman.getXPos()  - hori), ((pacman.getYPos() + 2) + vert), inky.getXPos(), inky.getYPos());//will find the direction to the shortest path from pinky to pacman if pacman's direction is down
			}
			else {//inky's go to position will be in the bottom right corner
				inkyMove = inky.findShortestPath((pacman.getXPos()  + hori), ((pacman.getYPos() + 2) + vert), inky.getXPos(), inky.getYPos());//will find the direction to the shortest path from pinky to pacman if pacman's direction is down
			}
			
			ghostMovement(inky, inkyMove);
		}
		else if (pacman.getDirection().equals("up")) {//checks if pacman current direction is up
			hori = Math.abs((pacman.getXPos()  - 2) - blinky.getXPos());//calculates the horizontal distance from inky to pacman
			vert = Math.abs((pacman.getYPos() - 2) - blinky.getYPos());//calculates the vertical distance from inky to pacman
			
			if ((pacman.getXPos()  + 4) <= blinky.getXPos() && pacman.getYPos() <= blinky.getYPos()) {//inky's go to position will be in the top left corner
				inkyMove = inky.findShortestPath(((pacman.getXPos()  - 2) - hori), ((pacman.getYPos() - 2) - vert), inky.getXPos(), inky.getYPos());//will find the direction to the shortest path from pinky to pacman if pacman's direction is up
			}
			else if ((pacman.getXPos()  + 4) > blinky.getXPos() && pacman.getYPos() <= blinky.getYPos()) {//inky's go to position will be in the top right corner
				inkyMove = inky.findShortestPath(((pacman.getXPos()  - 2) + hori), ((pacman.getYPos() - 2) - vert), inky.getXPos(), inky.getYPos());//will find the direction to the shortest path from pinky to pacman if pacman's direction is up
			}
			else if ((pacman.getXPos()  + 4) <= blinky.getXPos() && pacman.getYPos() > blinky.getYPos()) {//inky's go to position will be in the bottom left corner
				inkyMove = inky.findShortestPath(((pacman.getXPos()  - 2) - hori), ((pacman.getYPos() - 2) + vert), inky.getXPos(), inky.getYPos());//will find the direction to the shortest path from pinky to pacman if pacman's direction is up
			}
			else {//inky's go to position will be in the bottom right corner
				inkyMove = inky.findShortestPath(((pacman.getXPos()  - 2) + hori), ((pacman.getYPos()  - 2) + vert), inky.getXPos(), inky.getYPos());//will find the direction to the shortest path from pinky to pacman if pacman's direction is up
			}
			
			ghostMovement(inky, inkyMove);
		}
	}
	
	//clydeMovement will be able to move clyde around autonomously; takes no parameters and returns nothing
	public void clydeMovement() throws SlickException {
		int hori = Math.abs(pacman.getXPos() - clyde.getXPos());//will hold the manipulated horizontal position from clyde to pacman
		int vert = Math.abs(pacman.getYPos()  - clyde.getYPos());//will hold the manipulated vertical position from clyde to pacman
		String clydeMove;
		
		if (clyde.getInvincible()) {
			clydeMove = clyde.findShortestPath(1, 29, clyde.getXPos(), clyde.getYPos());
			ghostMovement(clyde, clydeMove);
			clyde.runAway();
		}
		else if (Math.sqrt(Math.pow(hori, 2) + Math.pow(vert, 2)) > 8) {//checks if clyde is 8 tiles within of pacman's square
			clydeMove = clyde.findShortestPath(pacman.getXPos() , pacman.getYPos() , clyde.getXPos(), clyde.getYPos());//will find the direction to the shortest path from clyde to pacman
			ghostMovement(clyde, clydeMove);
		}
		else {
			clydeMove = clyde.findShortestPath(1, 29, clyde.getXPos(), clyde.getYPos());//will find the direction to the shortest path from clyde to the bottom left corner
			ghostMovement(clyde, clydeMove);
		}
	}
	
	//make pellets will make a add a new pellet to the pellets array; makes a pellet for every square that's not apart of the map; takes no parameters and returns nothing
	public void makePellets() throws SlickException {
		for (int i = 0; i < 28; i++) {//loops 28 times; the width of the map
			for (int j = 0; j < 31; j++) {//loops 31 times; the height of the map
				if (map.checkRight(i - 1, j)) {//checks if the current position is taken by the map
					pellets.add(new Pellet(i, j));//makes a new pellet object with a specific position and adds to the array
				}
			}
		}
		
		pellets.add(new PowerPellet(6, 5));
		pellets.add(new PowerPellet(21, 5));
		pellets.add(new PowerPellet(6, 23));
		pellets.add(new PowerPellet(21, 23));
	}
	
	//pelletEat will check if the pacman character intersects with a pellet; takes no parameters and returns nothing
	public void pelletEat() throws SlickException {
		for (int i = 0; i < pellets.size(); i++) {//will loop through all the pellets in the pellets array
			if (pellets.get(i).checkEat(pacman.getXPos(), pacman.getYPos())) {//checks if pacman x and y position is the same of the pellet's x and y position
				if (pellets.get(i).pelletType().equals("powerPellet")) {//checks if power pellet was eaten
					powerTimer = 0;
					invincible = true;//sets invisible to true
					blinky.setInvincible(true);
					pinky.setInvincible(true);
					inky.setInvincible(true);
					clyde.setInvincible(true);
				}
				pellets.remove(i);//will remove the that pellet from the pellets array
				score += 10;//adds ten to the score
			}
		}
		
		if (pellets.size() <= 60 && notDoneSixth) {//checks if the pellet array size is less than 60 and the blinky modulus has not changed yet
			blinkyModulus--;//decreases the blinky modulus
			notDoneSixth = false;//makes the boolean check false so blinky's modulus doesn't keep on decreasing
		}
		if (pellets.size() <= 30 && notDoneTenth) {//checks if the pellet array size is less than 30 and the blinky modulus has not changed yet
			blinkyModulus--;//decreases the blinky modulus
			notDoneTenth = false;//makes the boolean check false so blinky's modulus doesn't keep on decreasing
		}
		if (pellets.size() == 0) {//checks if the pellet array size is 0
			invincible = false;
			blinky.setInvincible(false);
			pinky.setInvincible(false);
			inky.setInvincible(false);
			clyde.setInvincible(false);
			scatter();//calls the scatter function
			pacman.win();//calls the win function from the pacman object
			mapAni.play();//calls the play function from the mapAni object
			win = true;//set the win boolean to true; player has beat the level
			paused = true;//sets the pause boolean to true so the game will be paused momentarily
		}
		
	}
	
	//the rest function resets the character's x and y position; takes no parameters and returns nothing
	void reset() throws SlickException {
		pacman.setXPos(pacman.resetCharacterX());//sets the pacman x position to the reset x position
		pacman.setYPos(pacman.resetCharacterY());//sets the pacman y position to the reset y position
		blinky.setXPos(blinky.resetCharacterX());//sets the blinky x position to the reset x position
		blinky.setYPos(blinky.resetCharacterY());//sets the blinky y position to the reset y position
		pinky.setXPos(pinky.resetCharacterX());//sets the pinky x position to the reset x position
		pinky.setYPos(pinky.resetCharacterY());//sets the pinky y position to the reset y position
		inky.setXPos(inky.resetCharacterX());//sets the inky x position to the reset x position
		inky.setYPos(inky.resetCharacterY());//sets the inky y position to the reset y position
		clyde.setXPos(clyde.resetCharacterX());//sets the clyde x position to the reset x position
		clyde.setYPos(clyde.resetCharacterY());//sets the clyde y position to the reset y position
	}
	
	//the scatter function sets the ghost's x and y position to be out of the map to signify; takes no parameters and returns nothing
	void scatter() throws SlickException {
		blinky.setInvincible(false);
		pinky.setInvincible(false);
		inky.setInvincible(false);
		clyde.setInvincible(false);
		blinky.setXPos(blinky.scatter());//sets the blinky x position to the reset x position
		blinky.setYPos(blinky.scatter());//sets the blinky y position to the reset y position
		pinky.setXPos(pinky.scatter());//sets the pinky x position to the reset x position
		pinky.setYPos(pinky.scatter());//sets the pinky y position to the reset y position
		inky.setXPos(inky.scatter());//sets the inky x position to the reset x position
		pinky.setYPos(inky.scatter());//sets the inky y position to the reset y position
		clyde.setXPos(clyde.scatter());//sets the clyde x position to the reset x position
		clyde.setYPos(clyde.scatter());//sets the clyde y position to the reset y position
	}
	
	//the checkDie function checks if pacman collides with the one of the ghosts; takes no parameters and returns nothing
	void checkDie(StateBasedGame game) throws SlickException {
		if (!blinky.getInvincible() && pacman.getXPos() == blinky.getXPos() && pacman.getYPos() == blinky.getYPos()) {
			die(game);
		}
		if (!pinky.getInvincible() && pacman.getXPos() == pinky.getXPos() && pacman.getYPos() == pinky.getYPos()) {
			die(game);		
		}
		if (!inky.getInvincible() && pacman.getXPos() == inky.getXPos() && pacman.getYPos() == inky.getYPos()) {
			die(game);
		}
		if (!clyde.getInvincible() && pacman.getXPos() == clyde.getXPos() && pacman.getYPos() == clyde.getYPos()) {
			die(game);
		}
		if (blinky.getInvincible() && pacman.getXPos() == blinky.getXPos() && pacman.getYPos() == blinky.getYPos()) {
			score += 750;
			blinky.setInvincible(false);
			blinky.setXPos(blinky.resetCharacterX());
			blinky.setYPos(blinky.resetCharacterY());
			paused = true;
		}
		if (pinky.getInvincible() && pacman.getXPos() == pinky.getXPos() && pacman.getYPos() == pinky.getYPos()) {
			score += 750;
			pinky.setInvincible(false);
			pinky.setXPos(pinky.resetCharacterX());
			pinky.setYPos(pinky.resetCharacterY());
			paused = true;
		}
		if (inky.getInvincible() && pacman.getXPos() == inky.getXPos() && pacman.getYPos() == inky.getYPos()) {
			score += 750;
			inky.setInvincible(false);
			inky.setXPos(inky.resetCharacterX());
			inky.setYPos(inky.resetCharacterY());
			paused = true;
		}
		if (clyde.getInvincible() && pacman.getXPos() == clyde.getXPos() && pacman.getYPos() == clyde.getYPos()) {
			score += 750;
			clyde.setInvincible(false);
			clyde.setXPos(clyde.resetCharacterX());
			clyde.setYPos(clyde.resetCharacterY());
			paused = true;
		}
	}
	
	void die(StateBasedGame game) throws SlickException {
		invincible = false;
		scatter();//calls the scatter function
		pacman.die();//calls the die function from the pacman object
		lives--;//decreases the number of lives
		if (lives <= 0) {
			makePellets();
			reset();
			score = 0;
			lives = 3;
			invincible = false;
			blinky.setInvincible(false);
			pinky.setInvincible(false);
			inky.setInvincible(false);
			clyde.setInvincible(false);
			paused = true;
			game.enterState(Start.endStateID, new FadeOutTransition(org.newdawn.slick.Color.black), new FadeInTransition(org.newdawn.slick.Color.black));
		}
		paused = true;//sets the pause boolean to true so the game will be paused momentarily
	}

	//init function takes in a GameContainer. the code block below executes everything before the game starts; returns nothing
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		// TODO Auto-generated method stub
		map = new Map();//makes a new map object
		mapAni = new MapAnimation();//makes a new mapAnimation object
		pacman = new Pacman(13, 17);//makes a new pacman object
		blinky = new Blinky(map, 26, 1);//makes a new blinky object
		pinky = new Pinky(map, 1, 1);//makes a new pinky object
		inky = new Inky(map, 26, 29);//makes a new inky object
		clyde = new Clyde(map, 1, 29);//makes a new clyde object
	}

	//render function takes in a GameContainer so that the sprites will update; graphics will allow text to be written; returns nothing
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		map.makeMap();//draws the tiled map 
		mapAni.draw();//draws the animated map
		pacman.draw();//draws pacman
		blinky.draw();//draws blinky
		pinky.draw();//draws pinky
		inky.draw();//draws inky
		clyde.draw();//draws clyde
		for (int i = 0; i < pellets.size(); i ++) {//loops through all of the pellets
			pellets.get(i).draw();//makes a new pellet
		}
		g.drawString("Lives: " + lives + "; Score: " + score, 0, 260);//displays a string with lives and score
	}
	
	//the update function takes in a GameContainer, StatebBasedGame and delta; the game container is to update the game; the delta is used to check how much time is differed from each update function call
	//the update function updates the character and the map; returns nothing
	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		// TODO Auto-generated method stub
		updateCounter++;//adds to the update counter
		
		if (!paused) {//checks if the game is currently paused
			if (invincible) {
				powerTimer += delta;
				if (powerTimer > 20000) {
					powerTimer = 0;
					invincible = false;
					blinky.setInvincible(false);
					pinky.setInvincible(false);
					inky.setInvincible(false);
					clyde.setInvincible(false);
				}
			}
			if (updateCounter % 5 == 0) {//checks if updateCounter is divisible by 5
				pacmanMovement(container);//calls the pacmanMovement function
			}
			if (updateCounter % blinkyModulus == 0) {//checks if updateCounter is divisible by the blinky modulus
				blinkyMovement();//calls the blinkyMovement function
			}
			if (updateCounter % 7 == 0) {//checks if updateCounter is divisible by 7
				pinkyMovement();//calls the pinkyMovement function
				inkyMovement();//calls the inkyMovement function
				clydeMovement();//calls the clydeMovement function
			}
			pelletEat();//calls the pelletEat function
			checkDie(game);//calls the checkDie function
		}
		else {//the game is currently paused
			timer += delta;//adds delta to the timer counter
			if (timer > 3000 && win) {//checks if the timer is greater than 2000 if the player has won
				makePellets();//calls the makePellets function to put all the pellets back
				reset();//calls the reset function to reset the x and y position of the characters
				timer = 0;//resets the timer
				blinkyModulus = 7;//reset the blinkyModulus
				mapAni.singleFrame();//put the mapAni object to the first frame of its animation
				pacman.setDirection("right");//sets the pacman direction to be right
				win = false;//sets the win boolean to be false as the player moves onto the next level
				paused = false;//sets the paused boolean to be false so the game can be played again
			}
			if (timer > 500 && invincible) {
				timer = 0;
				paused = false;
			}
			else if (timer > 3000) {//checks if the timer is greater than 2000
				reset();//calls the reset function to reset the x and y position of the characters
				timer = 0;//resets the timer
				pacman.setDirection("right");//sets the pacman direction to be right
				paused = false;//sets the paused boolean to be false so the game can be played again
			}
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return this.ID;
	}

}

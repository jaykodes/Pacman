package pacman;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Start extends StateBasedGame {

	public static final int menuStateID = 0;
	public static final int playStateID = 1;
	public static final int endStateID = 2;
	
	public Start(String name) throws SlickException {
		// TODO Auto-generated constructor stub
		super(name);
		this.addState(new Menu(Start.menuStateID));
		this.addState(new MainGame(Start.playStateID));
		this.addState(new GameOver(Start.endStateID));
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		// TODO Auto-generated method stub
		this.getState(Start.menuStateID).init(container, this);
		this.getState(Start.playStateID).init(container, this);
		this.getState(Start.endStateID).init(container, this);
		this.enterState(Start.menuStateID);
	}
	
	public static void beginGame() {
		AppGameContainer container;//makes a AppGameContainer object
		try{//try to complete the code block below
			container = new AppGameContainer(new Start("Pacman"));
			container.setDisplayMode(224, 278, false);//sets the display to have a width of 224 pixels and height of 278 pixels
			container.setTargetFrameRate(60);//sets the frame rate to be 60
			container.setVSync(true);//syncs the frames so less lag
			container.setShowFPS(false);//makes sure that player can't see the current fps
			container.start();//starts the game
		} catch(SlickException e){e.printStackTrace();}//catches any problems with the loading of the game
	}
	
	public static void main(String[] args) {
		beginGame();
	}
	
}

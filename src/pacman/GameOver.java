package pacman;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class GameOver extends BasicGameState {

	private StateBasedGame game;
	private int ID;
	private Image endScreen;
	
	public GameOver(int ID) throws SlickException {
		this.ID=ID;
	}
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		// TODO Auto-generated method stub
		this.game = game;
		endScreen = new Image("animations/gameOver.png");
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		endScreen.draw(22, 50);
		g.setColor((org.newdawn.slick.Color.red));
	    g.drawString("Push Space Key for Menu", 8, 190);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		// TODO Auto-generated method stub
	}
	
	public void keyReleased(int key, char c) {
        if(key == Input.KEY_SPACE) {
        	game.enterState(Start.menuStateID, new FadeOutTransition(org.newdawn.slick.Color.black), new FadeInTransition(org.newdawn.slick.Color.black));
        }
    }

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return this.ID;
	}

}

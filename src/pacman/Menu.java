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

public class Menu extends BasicGameState {
	
	private StateBasedGame game;
	private int ID;
	private Image title;
	private Image workCited;
	
	public Menu(int ID) throws SlickException {
		this.ID=ID;
	}

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		// TODO Auto-generated method stub
		this.game = game;
		title = new Image("animations/pacmanTitle.png");
		workCited = new Image("animations/workCited.png");
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		title.draw(28, 50);
		g.setColor((org.newdawn.slick.Color.cyan));
	    g.drawString("Push Space Key to Play", 13, 130);
	    workCited.draw(26, 200);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		// TODO Auto-generated method stub
	}
	
	public void keyReleased(int key, char c) {
        if(key == Input.KEY_SPACE) {
        	game.enterState(Start.playStateID, new FadeOutTransition(org.newdawn.slick.Color.black), new FadeInTransition(org.newdawn.slick.Color.black));
        }
    }

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return this.ID;
	}

}

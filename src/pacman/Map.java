package pacman;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class Map {

	private TiledMap map;
	private int blockLayer;
	
	public Map() throws SlickException {
		// TODO Auto-generated constructor stub
		this.map = new TiledMap("map/pacmanMap.tmx");
		this.blockLayer = map.getLayerIndex("mapBlocks");
		this.map.getTileId(0, 0, blockLayer);
	}
	
	//this map is used in case user wants to upload their own map and therefore will have its own layer
	public Map(String mapFile, String layerName) throws SlickException {
		this.map = new TiledMap(mapFile);
		this.blockLayer = map.getLayerIndex(layerName);
		this.map.getTileId(0, 0, blockLayer);
	}
	
	void makeMap() {
		map.render(0, 0);
	}
	
	boolean checkRight(int x, int y) {
		if (map.getTileId(x + 1, y, blockLayer) == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	boolean checkLeft(int x, int y) {
		if (map.getTileId(x - 1, y, blockLayer) == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	boolean checkUp(int x, int y) {
		if (map.getTileId(x, y - 1, blockLayer) == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	boolean checkDown(int x, int y) {
		if (map.getTileId(x, y + 1, blockLayer) == 0) {
			return true;
		}
		else {
			return false;
		}
	}
}

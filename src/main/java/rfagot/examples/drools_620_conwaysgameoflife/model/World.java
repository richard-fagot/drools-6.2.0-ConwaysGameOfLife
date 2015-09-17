package rfagot.examples.drools_620_conwaysgameoflife.model;

public final class World {
	private final int height;
	private final int width;
	
	private final Cell[] world;
	
	private  World(int width, int height) {
		this.width = width;
		this.height = height;
		
		world = new Cell[width*height];
	}
	
	public static World generateWorld(int width, int height, float preFilled) {
		World w = new World(width, height);
		
		if(width == 3 && height == 3){
			
			for(int y = 0 ; y < height; y++) {
				for(int x = 0 ; x < width; x++) {
					w.world[x + y*width] = new Cell(x, y, Cell.DEAD);
				}
			}
			
			w.world[3].setState(Cell.ALIVE);
			w.world[4].setState(Cell.ALIVE);
			w.world[5].setState(Cell.ALIVE);
			
		} else {
			
			for(int y = 0 ; y < height ; y++) {
				for(int x = 0 ; x < width ; x++) {
					boolean state = Cell.DEAD;
					if(Math.random() < preFilled) state = Cell.ALIVE;
					
					w.world[x + y*width] = new Cell(x, y, state);
				}
			}
			
		}
		
		return w;
	}
	
	public Cell[] getCells() {
		return world;
	}
	
	public void andTheLightWas() {
		for(int y = 0 ; y < height ; y++) {
			for(int x = 0 ; x < width ; x++) {
				System.out.print(world[x + y*width].isState()?"[*]":"[ ]");
			}
			System.out.println();
		}
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}
	
	
}

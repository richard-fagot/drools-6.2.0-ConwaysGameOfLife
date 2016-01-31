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
	
	public static World generateStaticWorld() {
		
		World world = new World(76, 36);
		for(int y = 0 ; y < world.height; y++) {
			for(int x = 0 ; x < world.width; x++) {
				world.world[x + y*world.width] = new Cell(x, y, Cell.DEAD);
			}
		}
		
		int[][] LWSS = {{1, 0, 0, 1, 0}
				     ,  {0, 0, 0, 0, 1}
				     ,  {1, 0, 0, 0, 1}
				     ,  {0, 1, 1, 1, 1}
				     };
		
		int[][] antBR = {{0,1,0}
		              ,{0,0,1}
		              ,{1,1,1}};
		
		int[][] antUR = {{0,1,1}
						,{1,0,1}
						,{0,0,1}};
		int[][] galaxy = {{1,1,0,1,1,1,1,1,1}
						 ,{1,1,0,1,1,1,1,1,1}
						 ,{1,1,0,0,0,0,0,0,0}
						 ,{1,1,0,0,0,0,0,1,1}
						 ,{1,1,0,0,0,0,0,1,1}
						 ,{1,1,0,0,0,0,0,1,1}
						 ,{0,0,0,0,0,0,0,1,1}
						 ,{1,1,1,1,1,1,0,1,1}
						 ,{1,1,1,1,1,1,0,1,1}};
		
		world.putAnimal(LWSS, 40, 21);
		world.putAnimal(antUR, 22, 15);
		world.putAnimal(antUR, 30, 10);
		world.putAnimal(galaxy, 57, 13);
		return world;
	}
	
	private void putAnimal(int[][] animal, int posX, int posY) {
		for (int w = 0 ; w < animal[0].length ; w++) {
			for(int h = 0 ; h < animal.length ; h++) {
				world[posX+w + (posY+h)*width].setState(animal[h][w]==1?true:false);
			}
		}
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
	
	public static World generateUWorld(int width, int height) {
		World w = new World(width, height);
		
		for(int y = 0 ; y < w.height; y++) {
			for(int x = 0 ; x < w.width; x++) {
				w.world[x + y*w.width] = new Cell(x, y, Cell.DEAD);
			}
		}
		
		
		int U[][] = {{1,0,1}
        			,{1,0,1}
        			,{1,1,1}};
		
		w.putAnimal(U, width/2, height/2);
		
		return w;
	}
	
}

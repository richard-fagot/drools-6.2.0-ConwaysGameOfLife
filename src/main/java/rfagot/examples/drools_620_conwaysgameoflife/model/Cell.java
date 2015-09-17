package rfagot.examples.drools_620_conwaysgameoflife.model;

public final class Cell {
	public static final boolean DEAD = false;
	public static final boolean ALIVE = true;
	
	private final int posX;
	private final int posY;
	
	private boolean state;

	public Cell(int x, int y, boolean state) {
		this.posX = x;
		this.posY = y;
		this.state = state;
	}
	
	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
	
	@Override
	public String toString() {
		return state?"[*]":"[ ]";
	}
}

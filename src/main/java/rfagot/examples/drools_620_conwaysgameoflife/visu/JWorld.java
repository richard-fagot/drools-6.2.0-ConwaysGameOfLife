package rfagot.examples.drools_620_conwaysgameoflife.visu;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import rfagot.examples.drools_620_conwaysgameoflife.model.Cell;
import rfagot.examples.drools_620_conwaysgameoflife.model.World;

public final class JWorld extends JPanel {
	private final World world;
	
	public JWorld(World world) {
		this.world = world;
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		g.setColor(Color.white);
		Cell[] cells = world.getCells();
		for(int y = 0 ; y < world.getHeight() ; y++){
			for(int x = 0 ; x < world.getWidth() ; x++){
				if(cells[x+y*world.getWidth()].isState()) {
					g.fillRect(x*10, y*10, 10, 10);
				}
			}
		}
	}
}

package rfagot.examples.drools_620_conwaysgameoflife.visu;

import javax.swing.JFrame;

import rfagot.examples.drools_620_conwaysgameoflife.model.World;

public final class JWindow extends JFrame {
	private final JWorld jWorld;

	public JWindow(World world) {
		jWorld = new JWorld(world);
		
		this.setTitle("Animation");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(jWorld);
		this.setVisible(true);
	}

	public void drawWorld() {
		jWorld.repaint();
	}
}

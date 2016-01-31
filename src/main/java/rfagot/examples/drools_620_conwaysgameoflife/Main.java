package rfagot.examples.drools_620_conwaysgameoflife;

import org.kie.api.builder.ReleaseId;

import rfagot.examples.drools_620_conwaysgameoflife.model.Cell;
import rfagot.examples.drools_620_conwaysgameoflife.model.World;
import rfagot.examples.drools_620_conwaysgameoflife.ruleutils.RuleException;
import rfagot.examples.drools_620_conwaysgameoflife.ruleutils.RuleSession;
import rfagot.examples.drools_620_conwaysgameoflife.visu.JWindow;

public class Main  {
	private static boolean NEXT = false;
	
	private RuleSession session;
	private World world;
	private JWindow jWindow;
	
	public static void main(String[] args) {
		(new Main()).run();
	}

	public void run() {
		
		int width = 100;
		int height = 100;
		
//		world = World.generateWorld(width, height, 0.10f);
//		world = World.generateStaticWorld();
		world = World.generateUWorld(width, height);
		jWindow = new JWindow(world);
//		jWindow.addKeyListener(new KeyListener() {
//			
//			public void keyTyped(KeyEvent e) {
//			}
//			
//			public void keyReleased(KeyEvent e) {
//				
//			}
//			
//			public void keyPressed(KeyEvent e) {
//				 if(e.getKeyCode() == KeyEvent.VK_SPACE){
//					 computeNext();
//				 }
//			}
//		});
		
		ReleaseId id = null;
		try {
			session = new RuleSession(id, "drools-gameoflifeKS", 0);
			while(true) {
				computeNext();
				Thread.sleep(100);
			}
		} catch (RuleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
//			try {
//				if(session != null)	session.closeKsession();
//			} catch (RuleException e1) {}
			
		}
	}

	private void computeNext()  {
		try {
			// insert objects into working memory
			Cell[] cells = world.getCells();
			for (Cell c : cells) {
				session.insertIntoWm(c);
			}
			session.fireAll(null);
			session.retractAll();
			jWindow.drawWorld();
			
		} catch (RuleException e) {}
	}
}

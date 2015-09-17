package rfagot.examples.drools_620_conwaysgameoflife;

import org.kie.api.builder.ReleaseId;

import rfagot.examples.drools_620_conwaysgameoflife.model.Cell;
import rfagot.examples.drools_620_conwaysgameoflife.model.World;
import rfagot.examples.drools_620_conwaysgameoflife.ruleutils.RuleException;
import rfagot.examples.drools_620_conwaysgameoflife.ruleutils.RuleSession;
import rfagot.examples.drools_620_conwaysgameoflife.visu.JWindow;

public class Main {

	public static void main(String[] args) {
		(new Main()).run();
	}

	public void run() {
		
		int width = 79;
		int height = 59;
		
		World world = World.generateWorld(width, height, 0.10f);
		JWindow jWindow = new JWindow(world);
		
		ReleaseId id = null;
		RuleSession session;
		try {
			session = new RuleSession(id, "drools-gameoflifeKS", 0);
			
			while(true) {
				// insert objects into working memory
				Cell[] cells = world.getCells();
				for (Cell c : cells) {
					session.insertIntoWm(c);
				}
				session.fireAll(null);
				session.retractAll();
				jWindow.drawWorld();
				if(!jWindow.isVisible()) break;
				try{
					Thread.sleep(100);
				} catch(InterruptedException e){}
			}
			
			session.closeKsession();
			
		} catch (RuleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

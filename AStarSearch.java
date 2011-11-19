//
// Copyright © 2011 by Bjørn Zenker
//

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;


public class AStarSearch {



	
	  public static void main(String[] args){
		  NPuzzle p = new NPuzzle(3);
		  p.shuffle(4);
//	    	System.out.println(p.move(NPuzzle.MOVE_LEFT));
//	    	System.out.println(p.move(NPuzzle.MOVE_LEFT));
//	    	System.out.println(p.move(NPuzzle.MOVE_UP));
//	    	System.out.println(p.move(NPuzzle.MOVE_RIGHT));
		  
		  System.out.println("Zu lösendes Puzzle");
		  System.out.println(p);
		  System.out.println("==============");
		  
		  NPuzzle[] solution = graphSearch(p);
		  
		  if(solution == null) return;
		  
		  System.out.println("Ziel gefunden!");
		  for(int i = 0; i < solution.length; i++){
			  System.out.println(solution[i]);
			  System.out.println("============");
		  }
	  }
	  
	  public static NPuzzle[] graphSearch(NPuzzle start){
		HashSet<NPuzzle> closed = new HashSet<NPuzzle>();
		PriorityQueue<OpenListEintrag> fringe = new PriorityQueue<OpenListEintrag>();
		fringe.add(new OpenListEintrag(start, null, Heuristics.h2(start)));

		OpenListEintrag current = fringe.poll();
		while(current != null) {
			if(current.destination.isSolved())
				return current.toArray();
			if(!closed.contains(current.destination)) {
				closed.add(current.destination);
				for(NPuzzle puz : current.destination.getSuccessors())
					fringe.add(new OpenListEintrag(puz, current, Heuristics.h2(puz)));
			}
			current = fringe.poll();
		}
		return null;
	  }
}

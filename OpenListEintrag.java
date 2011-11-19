//
// Copyright © 2011 by Bjørn Zenker
//

public class OpenListEintrag implements Comparable<OpenListEintrag> {

	public NPuzzle destination;
	public OpenListEintrag precessor;
	public int g;

	public OpenListEintrag(NPuzzle destination, OpenListEintrag precessor, int g) {
		super();
		this.destination = destination;
		this.precessor = precessor;
		this.g = g;
	}

	@Override
	public int compareTo(OpenListEintrag other) {

		int ha = other.g;;//TODO ...
		int hb = g; //TODO ...

		if (ha < hb) {
			return -1;
		}
		if (ha > hb) {
			return 1;
		}
		return 0;
	}

	public NPuzzle[] toArray() {
		int n = 0;
		OpenListEintrag tmp = this;
		while(tmp.precessor != null) {
			n++; tmp = tmp.precessor;
		}
		NPuzzle[] solution = new NPuzzle[n];
		tmp = this;
		for(int i = 0; i < n; i++) {
			solution[i] = tmp.destination;
			tmp = tmp.precessor;
		}
		return solution;
	}
}

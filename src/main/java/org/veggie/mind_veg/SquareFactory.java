package org.veggie.mind_veg;

import java.util.ArrayList;
import org.graphstream.graph.implementations.SingleGraph;

public class SquareFactory extends ShapeFactory {
	public SquareFactory(String nameOfGraph) {
		this.graph = new SingleGraph(nameOfGraph);
		this.graphSize = 4;
		this.labelNodes = new ArrayList<String>(4);
		this.nextPosition = 0;
		this.shapePrefix = "corner";
	}

	@Override
	public void makeShape() {
		this.createNodes();
		this.makeSquare();

	}

	private void makeSquare() {

		this.makeEdge(this.getNodeFrom(this.graph), this.getNodeFrom(this.graph));

	}

	@Override
	public String createNameOfNode(int index) {

		return this.shapePrefix.concat(new Integer(index).toString());
	}

}

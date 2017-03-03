package org.veggie.mind_veg;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

public class SimpleVisualitation {
	private Graph graph;
	private Node nodeA;

	public SimpleVisualitation() {
		this.graph = new SingleGraph("Tutorial 1");
	}

	public void createAndAddNodes() {
		this.graph.addNode("A");
		this.graph.addNode("B");
		this.graph.addNode("C");
		this.graph.addNode("D");
	}

	public void setLabel() {
		nodeA = graph.getNode("A");
		nodeA.setAttribute("ui.label", "Nodo A");
	}

	public void createSquare() {
		graph.addEdge("AB", "A", "B");
		graph.addEdge("BC", "B", "C");
		graph.addEdge("CD", "C", "D");
		graph.addEdge("DA", "D", "A");
	}

	public void displayGraph() {
		this.createAndAddNodes();
		this.setLabel();
		this.createSquare();
		this.graph.display();
	};
}

package org.veggie.mind_veg;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

public class Tutorial1 {

	public static void main(String args[]) {
		Graph graph = new SingleGraph("Tutorial 1");
		Node nodeA;
		graph.addNode("A");
		graph.addNode("B");
		graph.addNode("C");
		graph.addNode("D");
		nodeA = graph.getNode("A");
		nodeA.setAttribute("ui.label","Nodo A");
		graph.addEdge("AB", "A", "B");
		graph.addEdge("BC", "B", "C");
		graph.addEdge("CD", "C", "D");
		graph.addEdge("DA", "D", "A");

		graph.display();
	}
}

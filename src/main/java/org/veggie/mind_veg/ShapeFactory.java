package org.veggie.mind_veg;

import java.util.List;
import org.graphstream.graph.*;

public abstract class ShapeFactory {

	protected Graph graph;
	protected int graphSize;
	protected List<String> labelNodes;
	protected int nextPosition;
	protected String shapePrefix;

	public abstract String createNameOfNode(int index);

	public void createNameOfNodes() {
		for (int index = 0; index < this.graphSize; index++) {
			labelNodes.add(index, this.createNameOfNode(index));
		}
	}

	public void createNode(String label) {
		Node localNode;
		String nodeName = this.labelNodes.get(this.nextPosition);
		this.graph.addNode(nodeName);
		localNode = graph.getNode(nodeName);
		localNode.setAttribute("ui.label", label);
	}
    private String getNodeId(int index){
    	String nameOfNode = "";
    	try{this.labelNodes.get(index);
    		nameOfNode=this.labelNodes.get(index);
    	}
    	catch(IndexOutOfBoundsException indexOutOfBounds){
    		
    	}
    	return nameOfNode;
    }
    protected Node getNodeFrom(Graph aGraph){
    	Node returnNode;
    	returnNode=aGraph.getNode(this.getNodeId(nextPosition));
    	this.nextPosition=this.getNexPosition();
    	return returnNode;
    }
	public int getNexPosition() {
		int localPosition = nextPosition;
		try {
			this.labelNodes.get(nextPosition);

		} catch (IndexOutOfBoundsException i) {
			localPosition = nextPosition - 1;
		}
		return localPosition;
	}

	public void createNodes() {
		for (String labelNode : labelNodes) {
			this.createNode(labelNode);
		}
	}

	public void makeEdge(Node a, Node b) {
		String nameNodeA = a.getId();
		String nameNodeB = b.getId();
		String nameEdge = nameNodeA.concat(nameNodeB);
		this.graph.addEdge(nameEdge, nameNodeA, nameNodeB);
	}

	public abstract void makeShape();

	public void displayShape() {
		this.createNameOfNodes();
		this.makeShape();
		this.graph.display();

	}

}

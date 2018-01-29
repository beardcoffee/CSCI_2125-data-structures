/**
 * Dijkstra Algorithm object.
 * Made with a PriorityQueue for
 * easier sorting and dealing with
 * any connecting nodes.
 *
 * @author Brian
 * @version homework4
 */

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraAlgorithm{

	private boolean verbose = false; //for testing
	private int targetNode;
	private Node sourceNode;
	private PriorityQueue<Node> nodeList = new PriorityQueue<Node>();

	public DijkstraAlgorithm(Node sNode, int targetID){
		//this.verbose = verbose; //for testing purposes
		this.sourceNode = sNode;
		enqueue(this.sourceNode);
		this.targetNode = targetID;
		runAlgorithm(); //Dijkstra's
	}//end constructor

	/**
	 * Dijkstra's algorithm, made with a PriorityQueue
	 * to easily find the shortest path to all nodes
	 */
	private void runAlgorithm(){
		if(verbose){
			System.out.println("Dijkstra's Algorithm");
		}
		//ArrayList<Node> tempList = new ArrayList<Node>();

		while(nodeList.size() > 0){ //when the queue is empty there is no more node distance to be calculated

			if(verbose){System.out.println(nodeList.size());}

			Node tempNode = dequeue();
			ArrayList<Node.Edge> edges = new ArrayList<Node.Edge>();
			edges = tempNode.getEdges();
			// Iterating through all of the edges of the
			// dequeue'd node to calculate the cost to
			// to each adjacent node from the dequeue'd node 
			// and updating data in adjacent nodes if the 
			// minimal cost to said node is less than it's current
			for(int i = 0; i < edges.size(); i++){
				//System.out.println("WE DID IT?");
				/* getting data from the dequeue'd node and the adjacent node */
				Node eNode = edges.get(i).getConnected(); //get adjacent node (the egde node)
				int eCost = edges.get(i).getCost(); //cost from tempNode to the edgeNode
				if(verbose){System.out.println(eCost);}
				int tempCost = eCost + tempNode.getTentativeMin(); //Total cost from node to edgeNode
				if(verbose){
					System.out.print("enodecost: ");
					System.out.println(tempCost);}
				if(eNode.getTentativeMin() > tempCost){ //if we found new minimal cost to edgeNode update data of the node
					//if(verbose){System.out.println("Entering conditional");}
					removeNode(eNode);
					enqueue(updateNodeData(eNode, tempNode, tempCost)); //edge node added to queue
					if(verbose){System.out.println(nodeList.size());}
				}

			}
			//tempList.add(tempNode);

		}

	}//end method runAlgorithm


	/**
	 * Updates data of specified node so
	 * it can be enqueue'd
	 *
	 * @return Node updated node
	 */
	private Node updateNodeData(Node refNode, Node prevNode, int dist){
		Node temp = refNode;
		
		if(verbose){System.out.println("update");}

		temp.setPrev(prevNode);
		if(verbose){
			System.out.println("prev node " + temp.getPrev().getID());
		}		
		temp.setTentativeMin(dist);
		return temp;

	}//end method updateQueue

	/**
	 * Used to enqueue data.
	 * 
	 * @param node the node to enqueue 
	 */
	private void enqueue(Node node){
		this.nodeList.add(node);
	}//end method enqueue

	/**
	 * Will always return the closest node
	 * 
	 * @return Node the minimal element in the PriorityQueue
	 */
	private Node dequeue(){
		return this.nodeList.poll();
	}//end method dequeue

	/**
	 * @param node the node to be removed from the PriorityQueue
	 */
	private void removeNode(Node node){
		this.nodeList.remove(node);
	}//end method removeNode

}//end class DijkstraAlgorithm
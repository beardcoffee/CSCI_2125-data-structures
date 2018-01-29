/**
 * Node which will essentially hold the
 * vertex and any adjacent nodes.
 * Based off of LinkedList node from 2120.
 *
 * @author Brian
 * @version homework4
 */
import java.util.ArrayList;

public class Node implements Comparable<Node>{

	private int nodeID;
	private int tentativeMin = 100000; //tentative min dist
	private Node prev; //used for finding the route from targetID to sourceID.
	private ArrayList<Edge> edges = new ArrayList<Edge>();

	public Node(int id){
		this.nodeID = id;
	}//end constructor

	/* VARIOUS SETTERS AND GETTERS FOR NODE DATA */
	public void addEdge(Node node, int dist){
		Edge newEdge = new Edge(node, dist);
		edges.add(newEdge);
	}//end method addEdge

	public ArrayList<Edge> getEdges(){
		return this.edges;
	}//end method getEdges

	public void setTentativeMin(int dist){
		this.tentativeMin = dist;
	}//end method setMindDist

	public int getTentativeMin(){
		return this.tentativeMin;
	}

	public void setPrev(Node prevNode){
		this.prev = prevNode;
	}//end method setPrev

	public Node getPrev(){
		return this.prev;
	}//end method getPrev

	public int getID(){
		return this.nodeID;
	}//end method getID

	public int compareTo(Node id){
		if(this.nodeID < id.getID()){
			return 1;
		}else{
			return 2;
		}
	}//end compareTo implementation

	class Edge{
		private Node connectedNode;
		private int cost; //this is essentially the distance

		public Edge(Node node, int dist){
			this.connectedNode = node;
			this.cost = dist;
		}

		/* GETTERS */
		public Node getConnected(){
			return this.connectedNode;
		}

		public int getCost(){
			return this.cost;
		}
	}//end nested class
}//end class
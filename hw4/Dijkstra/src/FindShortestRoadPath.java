/**
 * Main class for hw4
 *
 * @author Brian
 * @version homework4
 */

import java.util.ArrayList;
import java.util.Hashtable;

public class FindShortestRoadPath{
    public static void main(String[] args) {
        if(args.length != 4){
            System.out.println("Usage: java FindShortestRoadPath inputFile.gr sourceID targetID outputFileName");
            System.exit(1);
        }

        /* misc */
        FileUtil util = new FileUtil(args[0]); //input file
        ArrayList<String> fileContent = new ArrayList<String>();
        fileContent = util.fileToArray();
        //fileContent.add(0, null);
        int sourceID = Integer.parseInt(args[1]);
        int targetID = Integer.parseInt(args[2]);

        /* Variables for setting up Dijkstra's algorithm */
        Hashtable<Integer, Node> nodes = new Hashtable<Integer, Node>(); //verticies
        Node temp, temp2;
        /* setting up all possible nodes for dijkstra's algorithm */
        for(int i = 0; i < fileContent.size(); i++){
            boolean bool = false; //temp boolean for making sure we run into no issues with adding edges.
            String[] tokens = fileContent.get(i).split(" ");
            temp = new Node(Integer.parseInt(tokens[1]));

            if(!nodes.containsKey(Integer.parseInt(tokens[1]))){
                bool = true;
                temp = new Node(Integer.parseInt(tokens[1]));
            }else{
                temp = nodes.get(Integer.parseInt(tokens[1]));
            }

            if(!nodes.containsKey(Integer.parseInt(tokens[2]))){
                temp2 = new Node(Integer.parseInt(tokens[2]));
                temp.addEdge(temp2, Integer.parseInt(tokens[3]));
                nodes.put(new Integer(tokens[2]), temp2);

            }else{
                temp.addEdge(nodes.get(Integer.parseInt(tokens[2])), Integer.parseInt(tokens[3]));
            }

            if(bool){
                nodes.put(new Integer(tokens[1]), temp);
                bool = false;
            }
        }
        //System.out.println("Unique nodes: " + nodes.size());

        //the minimum distance for the source will be 0
        nodes.get(sourceID).setTentativeMin(0);
        
        //PriorityQueue based dijkstra algorithm
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(nodes.get(sourceID), targetID);

        ArrayList<Node> tempList = new ArrayList<Node>();
        temp = nodes.get(new Integer(targetID)); //target node
        tempList.add(temp);

        //traversing backwards via the previous node of the target node
        //until we can no longer traverse, meaning we hit our source.
        while(temp.getPrev() != null){
            //System.out.println(temp.getID());
            tempList.add(temp.getPrev());
            temp = temp.getPrev();
        }

        System.out.println(nodes.get(new Integer(targetID)).getTentativeMin());

        /* preparing content for the output file */
        ArrayList<String> outputList = new ArrayList<String>();
        outputList.add("Cost to targetID " + targetID + " from sourceID " + sourceID + ": " + nodes.get(new Integer(targetID)).getTentativeMin());

        //outputting the list of nodes from templist in reverse, so the out can be
        //read from source node to destination node.
        for(int i = 0; i < tempList.size() - 1; i++){
                if(tempList.size() - i == 0){
                    outputList.add("Node " + tempList.get(0).getID() + " to Node " + tempList.get(1).getID());
                    //System.out.println("Node " + tempList.get(i).getID() + " to Node " + tempList.get(i + 1).getID());
                }else{
                    outputList.add("Node " + tempList.get(tempList.size() - (i + 1)).getID() + " to Node " + tempList.get(tempList.size() - (i + 2)).getID());
                }
            
        }

        //outputing the cost and path to file using my FileUtil.
        util.arrayToFile(outputList, args[3]);
    }
    
}

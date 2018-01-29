/**
 * ArrayList based heaplist for generics.
 *
 * @author Brian
 */
import java.util.ArrayList;

public class HeapSort<T extends Comparable<T>>{

	private ArrayList<T> origList;
	private ArrayList<T> heapList = new ArrayList<T>();
	private ArrayList<T> sortedList = new ArrayList<T>();
	private int origSize;
	private int pos;

    /**
     * @param list the ArrayList with objects you want sorted
     */
	public HeapSort(ArrayList<T> list){
		this.origList = list;
        	this.origSize = list.size();
		buildHeap();
		sortHeap();
	}//end constructor

	/**
	 * Converts the array of comparables into a array based heap
	 */
	private void buildHeap(){
		this.heapList.add(null);
        	this.heapList.add(origList.get(0));
        	while(this.heapList.size() < (origSize + 1)){
			updateCurrent(heapList.size());
            		this.heapList.add(origList.get(heapList.size() - 1));
			percolateUp();
        	}
	}//end method createHeap

	/**
	 * Sorts the heap built by buildHeap
	 */
	private void sortHeap(){
		int temp = (this.heapList.size() - 1); //while loop condition
		while(this.sortedList.size() < temp){
			this.sortedList.add(this.heapList.get(1));
			this.heapList.set(1, this.heapList.get(this.heapList.size() - 1));
			this.heapList.remove(this.heapList.size() - 1);
			updateCurrent(1);
			percolateDown();
		}
		
	}//end method sortHeap

	/**
 	 * Helper method for sortHeap
	 * when replacing root we must 
	 * follow the rules of having the max
	 * item as the root for the heap
	 * hence we percolate down 
	 */
	private void percolateDown(){
		boolean temp = true;
		while(temp){
			if(this.heapList.size() > 2){
				//System.out.println("heaplist; " + this.heapList.size() + " pos: " + this.pos + " case 1: " + (this.pos * 2) + " case 2: " + (this.pos * 2 + 1));
				if(notOutBound() != false){
					if(this.heapList.get(pos).compareTo(this.heapList.get(pos * 2)) < 0){
						T tempData = this.heapList.get(pos * 2);
						this.heapList.set(pos * 2, this.heapList.get(pos));
						this.heapList.set(pos, tempData);
						updateCurrent(pos * 2);
					}else if(this.heapList.size() == 3){
						temp = false;
					}else if(this.heapList.get(pos).compareTo(this.heapList.get((pos * 2) + 1)) < 0){
						T tempData = this.heapList.get((pos * 2) + 1);
						this.heapList.set((pos * 2) + 1, this.heapList.get(pos));
						this.heapList.set(pos, tempData);
						updateCurrent((pos * 2) + 1);
				
					}else{
						temp = false;
					}
				}else{
					temp = false;
				}
			}else{
				temp = false;
			}
		}
	}//end method percolateDown

	/**
	 * Helper method for buildHeap
	 * percolates the newest item to the top
	 * unless it is not greater than the parent
	 */
	private void percolateUp(){
		boolean temp = true;
		while(temp){
			if(this.heapList.get(pos).compareTo(this.heapList.get(pos/2)) > 0){
				T tempData = this.heapList.get(pos/2);
				this.heapList.set(pos/2, this.heapList.get(pos));
				this.heapList.set(pos, tempData);
				updateCurrent(pos/2);
			}else {
				temp = false;
				
			}
			
			if(pos == 1){
				temp = false;
			}
		}
	}//end method percolateUp

	private void updateCurrent(int p){
		this.pos = p; //current for keeping track of current
//		System.out.println(pos);
	}//end method updateCurrent

	private boolean notOutBound(){
		if(this.heapList.size() < pos * 2){
			return false;
		}else if(this.heapList.size() < (pos * 2 + 1)){
			return false;
		}
		return true;
	}//end method notOutBound

	public ArrayList<T> getHeap(){
		return this.heapList;
	}//end method getHeap

	public ArrayList<T> getSorted(){
        	return this.sortedList;
	}//end method sort



}//end class Queue

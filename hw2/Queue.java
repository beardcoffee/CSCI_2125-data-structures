/**
 * Array based queue for generics.
 * Features wrapping and no shifting.
 *
 * @author Brian
 */

public class Queue<T>{

	private T[] queue;
	private int head; //head of queue
	private int tail; //tail of queue
	private int size; //size of queue -1 for accurate representation of elements
	private int actualSize = 0; //for keeping track of element count

    /**
     * @param qSize the size of your array based queue
     */
	public Queue(int qSize){
		this.head = -1;
		this.tail = -1;
		this.size = qSize - 1;
		this.queue = (T[])new Object[qSize];
	}//end constructor

	/**
	 * checking if the queue through by checking
	 * for tail/head collision. 
	 *
	 * @return true if full, false if not.
	 */
	private boolean checkFull(){
		if(checkWrap()){
			if(this.queue[0] != null){
				return true;
			}else{
				return false;
			}
		}else if((this.queue[this.tail + 1] != null) || (this.queue[this.head] !=null)) {
			if(this.tail + 1 == this.head){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}//end method checkFull

	/**
	 * Checks if we need to wrap by
	 * comparing the tale with the size.
	 *
	 * @return true if wrap, false if not.
	 */
	private boolean checkWrap(){
		if(this.tail == this.size){
			return true;
		}
		return false;
	}//end method checkWrap

   /**
    * Enqueue method that supports wrapping
    */
	public void enqueue (T obj){

		if(this.head == -1){
			this.head++;
		}

		//two cases where we do not increment the tail normally.
		if(checkWrap() || checkFull()){
			if(queue[0] == null){
				this.tail = 0;
			}else{
				System.out.println("Queue is full.");
				return;
			}
		}else{
			this.tail++;
		}

		this.queue[this.tail] = obj;
		actualSize++; //helps keep track of element count
	}//end method enqueue

    /**
     * The dequeue method for a queue.
     * Sets the head to null to prevent 
     * all elements shifting every time
     * the method is called.
     *
     * @return element that is
     *         in head, null if
     *         nothing.
     */
	public T dequeue (){
		T tempData = queue[this.head];
		if(this.head != -1 && actualSize != 0){
			this.queue[this.head] = null;
			if(this.head == this.size){
				this.head = 0;
				actualSize--; //helps keep track of element count
			}else{
				this.head++;
				actualSize--; //helps keep track of element count
			}
		}else{
			System.out.println("Queue is empty.");
			return null;
		}

		return tempData;
	}//end method dequeue

	/**
	 * @return the amount of elements in the queue. 
	 */
	public int queueSize(){
		return actualSize;
	}//end method queueSize

}//end class Queue
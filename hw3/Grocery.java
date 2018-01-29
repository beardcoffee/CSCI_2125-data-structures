/**
 * A simple object for testing my
 * heapsort method
 *
 * @author Brian
 * @version homework3
 */

public class Grocery implements Comparable<Grocery>{

	private final int GREATER = 1;
	private final int LESS = -1;
	private String groceryItem;
	private int groceryItemLength;

	public Grocery(String itemName){
		this.groceryItem = itemName;
		this.groceryItemLength = itemName.length();
	}

	public String getGroceryItem(){
		return this.groceryItem;
	}

	public int getItemLength(){
		return this.groceryItemLength;
	}


    public String toString() {
        return "grocery name: " + this.groceryItem;
    }

    /**
     * @param gItem the item to compare to.
     */
    public int compareTo(Grocery gItem){
    	if(this.getItemLength() > gItem.getItemLength()){
    		return GREATER;
    	}else if(this.getItemLength() < gItem.getItemLength()){
    		return LESS;
    	}
    	return 0;
    }
}

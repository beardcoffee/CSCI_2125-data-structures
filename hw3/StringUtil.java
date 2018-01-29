/**
 * A simple util for testing my
 * heapsort method
 *
 * @author Brian
 * @version homework3
 */

public class StringUtil implements Comparable<StringUtil>{

	private final int GREATER = 1;
	private final int LESS = -1;
	private String str;
	private int strLen;

	public StringUtil (String s){
		this.str = s;
		this.strLen = s.length();
	}//end constructor

	/**
	 * @return getter for StringUtil's string.
	 */
	public String getStr(){
		return this.str;
	}//end method getStr

	/**
	 * @return getter for StringUtil's string len.
	 */
	public int getStrLen(){
		return this.strLen;
	}//end method getStrLen

    public String toString() {
        return "string len: " + this.strLen;
    }

    /**
     * @param gItem the item to compare to.
     */
    public int compareTo(StringUtil strUtil){
    	if(this.strLen > strUtil.strLen){
    		return GREATER;
    	}else if(this.strLen < strUtil.strLen){
    		return LESS;
    	}
    	return 0;
    }//end method compareTo
}

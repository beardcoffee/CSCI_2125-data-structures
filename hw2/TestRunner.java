import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * JUnit tester for testing
 * my array based Queue.
 *
 * @author Brian
 */

public class TestRunner {
	private Queue<String> queue;
	/**
	 * Initializes ComplexNumber's
	 * for various tests
	 */
	@Before
	public void setUp () {
		queue = new Queue<String>(50);
	}// end method setUp

	/**
	 * testSize
	 * 
	 * checks if the queue can accurately 
	 * keep track of how many elements that
	 * are not references to null are actually
	 * in the queue.
	 */
    @Test
    public void testSize() {
    	assertTrue(queue.queueSize() == 0);
    	//case one
    	fillTheQueue(50);
    	assertTrue(queue.queueSize() == 50);
    	//case two
    	exitTheQueue(5);
    	assertTrue(queue.queueSize() == 45);    	
    }

	/**
	 * testEnqueueDequeue
	 * 
	 * Enqueues a string then dequeues
	 * and tests for equality to see if
	 * both methods work.
	 */
    @Test
    public void testEnqueueDequque() {
    	queue.enqueue("mardi_gras");
    	assertTrue(queue.dequeue().equals(new String("mardi_gras")));
    }

	/**
	 * testWrap
	 * 
	 * tests to see if wrapping works.
	 */
    @Test
    public void testWrap() {
    	fillTheQueue(49);
    	exitTheQueue(1);
    	queue.enqueue("mardi_gras");
    	queue.enqueue("mardi_gras");
    	exitTheQueue(49);
    	assertTrue(queue.dequeue().equals(new String("mardi_gras")));

    }

    /**
     * Helper method for queueSize
     *
     * @param f the number of times we will loop
     */
	private void fillTheQueue(int f){
		for(int i = 0; i< f; i++){
			queue.enqueue("cat");
		}		
	}

    /**
     * Helper method for queueSize
     *
     * @param e the number of times we will loop
     */
	private void exitTheQueue(int e){
		for(int i = 0; i< e; i++){
			queue.dequeue();
		}		
	}	
}
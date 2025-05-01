import java.util.*;

public class CarQueue {
    private Queue<Integer> queue;
    private Random rand;
    
    public CarQueue() {
        queue = new LinkedList<>();
        rand = new Random();
        for (int i = 0; i < 6; i++) {
            queue.add(rand.nextInt(4));
        }
    }

   
    public void addToQueue() {
    	class r implements Runnable {	
    		@Override
            public void run() {
                try {
                    while (true) {
                        int direction = rand.nextInt(4); 
                        queue.add(direction);
                        Thread.sleep(500); 
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable runnable = new r(); 
        Thread t = new Thread(runnable);
        t.start();
    }

    public int deleteQueue() {
    	if (!queue.isEmpty()) {
    		return queue.remove();
        } else {
            return -1; 
        }
    }
}

package ChandyLamport;


/**
 * This is the simulation of a main algorithm that will run on processors P1, P2, P3
 * This could be a banking application, payroll application or any other distributed application
 */
public class Algorithm {

    /**
     * The processors which will participate in a distributed application
     */
    Processor processor1, processor2, processor3;

    public Algorithm(Processor processor1, Processor processor2, Processor processor3) {
    		this.processor1 = processor1;
    		this.processor2 = processor2;
    		this.processor3 = processor3;
    }



    public void executionPlan1 () throws InterruptedException{
        compute(processor1);
        compute(processor1);
        compute(processor1);
        compute(processor1);
        compute(processor1);
        compute(processor1);
        compute(processor1);
/**
 * TODO: Homework: Implement send message from processor1 to different processors. Add a time gap betweeen two different
 *                send events. Add computation events between two different sends.
 *      [Hint: Create a loop that kills time, sleep , wait on some value etc..]
 *
 */
        for(Buffer c : processor1.outChannels) {
        		Message m = new Message(MessageType.SEND);
        		processor1.sendMessgeTo(m, c);
        		compute(processor1);
        		Thread.sleep(200);
        }
    }

    // Write hard coded execution plan for processors
    public void executionPlanP1() {
    		for (Buffer c : processor1.outChannels) {
    			processor1.sendMessgeTo(new Message(MessageType.MARKER), c);
    			processor1.sendMessgeTo(new Message(MessageType.ALGORITHM), c);
    			processor1.sendMessgeTo(new Message(MessageType.COMPUTATION), c);
    			processor1.sendMessgeTo(new Message(MessageType.RECEIVE), c);
    			processor1.sendMessgeTo(new Message(MessageType.SEND), c);

    		}
    }

    // Write hard coded execution plan for processors
    public void executionPlanP2() {
		for (Buffer c : processor2.outChannels) {
			processor2.sendMessgeTo(new Message(MessageType.MARKER), c);
			processor2.sendMessgeTo(new Message(MessageType.ALGORITHM), c);
			processor2.sendMessgeTo(new Message(MessageType.COMPUTATION), c);
			processor2.sendMessgeTo(new Message(MessageType.RECEIVE), c);
			processor2.sendMessgeTo(new Message(MessageType.SEND), c);
		}


    }
    
    public void executionPlanP3() {
		for (Buffer c : processor3.outChannels) {
			processor3.sendMessgeTo(new Message(MessageType.MARKER), c);
			processor3.sendMessgeTo(new Message(MessageType.ALGORITHM), c);
			processor3.sendMessgeTo(new Message(MessageType.SEND), c);
			processor3.sendMessgeTo(new Message(MessageType.RECEIVE), c);
			processor3.sendMessgeTo(new Message(MessageType.COMPUTATION), c);
		}


    }

    /**
     * A dummy computation.
     * @param p
     */
    public void compute(Processor p) {
        System.out.println("Doing some computation on " + p.getClass().getSimpleName());
    }

    /**
     *
     * @param to processor to which message is sent
     * @param channel the incoming channel on the to processor that will receive this message
     */
    public void send(Processor to, Buffer channel) {
        to.sendMessgeTo(null, channel); // ALGORITHM
    }

}

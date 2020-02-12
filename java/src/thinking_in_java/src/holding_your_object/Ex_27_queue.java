package holding_your_object;

import java.util.LinkedList;
import java.util.Queue;

//TIJ4 Chapter Holding, Exercise 27, page 424
/* Write a class called Command that contains a String and has a method operation()
* that displays the String. Write a second class with a method that fills a Queue
* with Command objects and returns it. Pass the filled Queue to a method in a third
* class that consumes the objects in the Queue and calls their operation() methods.
*/

public class Ex_27_queue {

	public static void commandEater (Queue<Command> queue) {
		while (queue.peek() != null)
			queue.poll().operation();
	}
	
	public static void main(String[] args) {

		Build b = new Build();
		commandEater(b.build());
		
		
	}

}

class Command {
	
	private String command;
	
	Command (String command) {
		this.command = command;
	}
	
	public String operation () {
		return command;
	}

}

class Build {
	
	public Queue<Command> build () {
		Queue<Command> queue = new LinkedList<>();
		for (int i = 0; i < 10; i ++)
			queue.offer(new Command(i + " "));
		
		return queue;
	}
}






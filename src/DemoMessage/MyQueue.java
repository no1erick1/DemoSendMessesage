package DemoMessage;

public class MyQueue {
	int front, rear, capacity, size;
	String array[];

	public MyQueue(int capacity) 
	{
		this.capacity = capacity;
		front = this.size = 0;
		rear = capacity - 1;
		array = new String[this.capacity];
	}

	// Queue is full when size becomes equal to
	// the capacity
	boolean isFull(MyQueue queue) 
	{
		return (queue.size == queue.capacity);
	}

	// Queue is empty when size is 0
	boolean isEmpty(MyQueue myQueue) 
	{
		return (myQueue.size == 0);
	}

	// Method to add an item to the queue
	// It changes rear and size
	void enqueue(String item) 
	{
		if (isFull(this))
			return ;
		this.rear = (this.rear + 1) % this.capacity;
		try {
			this.array[this.rear] = item;
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			  System.out.println("Stack is full! OverFlow.");
			  e.printStackTrace();
		}
		this.size = this.size + 1;
		System.out.println(item + " ,Enqueued to queue");
	}

	// Method to remove an item from queue.
	// It changes front and size
	String dequeue() //increase the front extension to the front position to 1 and drop 1 at the top
	{
		if (isEmpty(this))
			return null;
		String item = this.array[this.front];
		this.front = (this.front + 1) % this.capacity;
		this.size = this.size - 1;
		return item;
	}

	// Method to get front of queue
	String front() 
	{
		if (isEmpty(this))
			return null;
		return this.array[this.front];
	}

	// Method to get rear of queue
	String rear() 
	{
		if (isEmpty(this))
			return null;
		return this.array[this.rear];
	}

	// this method split 25 characters of input
	public static String splitMessage(String message, int lenght) 
	{
		String messsplit = null;

		// if input length < 25 return message
		if (lenght < 25) 
		{
			return message;
		}
		
		// if >= 25, split 25 character form 0 to 25
		else if (lenght >= 25) 
		{
			messsplit = message.substring(0, 25);
			System.out.println("+ Current lenght is: " + lenght);
			System.out.print("+ Text split is: " + messsplit);
			message = message.substring(25);
			return messsplit;
		}	
		return messsplit;
	}

}

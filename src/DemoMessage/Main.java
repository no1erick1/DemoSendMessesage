package DemoMessage;

import java.util.Random;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		String message = Sender.getMessage();
		String message1 = Sender.getMessage1();
		String message2 = Sender.getMessage();
		Random random = new Random();
		@SuppressWarnings("unused")
		Sender sender = new Sender();
		Receiver receiver = new Receiver("", message);
		Receiver receiver1 = new Receiver("", message1);
		String messageofB = "";
		String messageofD = "";
		MyQueue queue = new MyQueue(1000);
		MyQueue queue1 = new MyQueue(1000);
		MyQueue queue2 = new MyQueue(1000);
		Stack stack = new Stack();
		Stack stack1 = new Stack();
		Stack stack2 = new Stack();
		int index = 25;
		while (true) {
			int n = random.nextInt(4);
			System.out.println("Now n is " + n);
			// n ==0 A send message

			if (n == 0) {
				int r = random.nextInt(2);
				// we must random 1 or 0 if r = zero A sent to B, if r = one A sent to D
				if (r == 0) {
					// if msg is null => send to B and set value new Message
					if (message.length() == 0) {
						queue.enqueue("End Conversation 1");
						message = message + Sender.getMessage();
					}
					// split message and enqueue
					else {
						queue.enqueue(MyQueue.splitMessage(message, message.length()));
						message = message.substring(index);
						// System.out.println("=====> Peek: " + queue.front());
					}
				} else {
					// if msg is null => send to B and set value new Message
					if (message2.length() == 0) {
						queue2.enqueue("End Conversation 3");
						message2 = message2 + Sender.getMessage();
					}
					// split message and enqueue
					else {
						queue2.enqueue(MyQueue.splitMessage(message2, message2.length()));
						message2 = message2.substring(index);
						// System.out.println("=====> Peek: " + queue.front());
					}
				}
			}

			else if (n == 2) {
				// if msg is null => send to C and set value new Message
				if (message1.length() == 0) {
					queue1.enqueue("End Conversation 2");
					message1 = message1 + Sender.getMessage1();
				}
				// split message and enqueue
				else {
					queue1.enqueue(MyQueue.splitMessage(message1, message1.length()));
					message1 = message1.substring(index);
				}
			}

			// n == 1, B receive packet from A
			else if (n == 1) {
				// If queue.front == End Conversation 1 => current message be end
				if (queue.front() == "End Conversation 1") {
					System.out.println("B print message: ");
					queue.dequeue();
					for (int i = 0; i < 10; i++) {
						messageofB = stack.peek() + messageofB;
						stack.pop();
					}
					receiver.setReceiveMessage(messageofB);
					System.out.println(receiver.getReceiveMessage());
					messageofB = "";
					System.out.println("-------------------------------------");
				} // If B not receiver => push packet into stack, remove current message
				else {
					if (!queue.isEmpty(queue)) {
						stack.push(queue.front());
						queue.dequeue();
						System.out.println("--------------------PUSHED--------------------");
					}
				}
			}

			//n == 3
			else {
				// If queue.front == End Conversation 2 => current message be end
				int r = random.nextInt(2);
				// we will random if r==0 , C receive packet from D 
				//if r==1 , A receive packet from D
				if (r == 0) {
					if (queue1.front() == "End Conversation 2") {
						System.out.println("D print message: ");
						queue1.dequeue();
						for (int i = 1; i < 10; i++) {
							messageofD = stack1.peek() + messageofD;
							stack1.pop();
						}
						receiver1.setReceiveMessage1(messageofD);
						System.out.println(receiver1.getReceiveMessage1());
						messageofD = "";
						System.out.println("-------------------------------------");
					} // If D not receiver => push packet into stack, remove current message
					else {
						if (!queue1.isEmpty(queue1)) {
							stack1.push(queue1.front());
							queue1.dequeue();
							System.out.println("--------------------PUSHED--------------------");
						}
					}
				} else {
					if (queue2.front() == "End Conversation 3") {
						System.out.println("D print message: ");
						queue2.dequeue();
						for (int i = 1; i < 10; i++) {
							messageofD = stack2.peek() + messageofD;
							stack2.pop();
						}
						receiver1.setReceiveMessage1(messageofD);
						System.out.println(receiver1.getReceiveMessage1());
						messageofD = "";
						System.out.println("-------------------------------------");
					} // If D not receiver => push packet into stack, remove current message
					else {
						if (!queue2.isEmpty(queue2)) {
							stack2.push(queue2.front());
							queue2.dequeue();
							System.out.println("--------------------PUSHED--------------------");
						}
					}
				}

			}
			Thread.sleep(500);
		}
	}
}

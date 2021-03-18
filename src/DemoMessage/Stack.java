package DemoMessage;

public class Stack {
	  static final int max =1000;
	  int top;
	  String a[] = new String [max];
	  boolean isEmpty()
	  {
		  return (top < 0);
	  }
	  boolean isFull()
	  {
		  return top == max;
	  }
	 public Stack() {
	    top = -1;
	  }

	  // push elements to the top of stack
	  boolean push(String x) {
	    if (top >= (max -1)) {
	      System.out.println("Stack is full! OverFlow.");
	      return false;
	    }

	    // insert element on top of stack
	    else {
	    a[++top] = x;
	    System.out.println(x + " pushed into stack");
	    return true;
	    }
	  }
	  
	  // pop elements from top of stack
	 public String pop() 
	  {
	    if (top<0) 
	    {
	      System.out.println("Stack is empty! Underflow condition.");
	      return null;
	    }
	    else 
	    {
	    	String x = a[top--]; //top-- is the top next next when the type of the first first time type
	    	return x;
	    }
	  }
	 public String peek()
	  {
		  if(top<0)
		  {
			  System.out.println("Stack is empty! Underflow condition.");
			  return null;
		  }
		  else
		  {
			  String x =a[top];
			  return x;
		  }
	  }
}

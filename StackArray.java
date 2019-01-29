package projects;

public class StackArray {
	// size of stack
	private int stackSize;
    private int[] stackArray;
    // top of stack
    private int stackTop;
 
    // Constructor
    public StackArray(int size) {
    	this.stackSize = size;
    	stackArray = new int[size];
    	stackTop = -1;
    }
    
    // push new element to stack top
    public void push(int value){
    	
    	// check if stack is full
        if(isFull()){
        	System.out.println("Stack is Full");
		    return;
        }
        
        stackArray[++stackTop] = value;
    }

    // delete an element from stack top
	public int pop() {
		
		if(isEmpty()){
			System.out.println("Stack is empty");
			return -1;
		}
		
		return stackArray[stackTop--];
	}

	// check if the stack is empty
	public boolean isEmpty() {
		
		return (stackTop == -1);

	}
 
	// check if the stack is full
	public boolean isFull() {
	
		return (stackTop == stackSize - 1);
	
	}
	
}





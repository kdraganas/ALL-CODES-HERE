import java.util.*;

public class StringStack{
	private String[] elements;
	private int count; 
	public static final int DEFAULT_SIZE=10;

	public StringStack(){
		this(DEFAULT_SIZE);
	}

	public StringStack(int size){
		if (size <=0){
			throw new IllegalArgumentException("Invalid Input!!");
		}
		else{
			elements = new String[size];
		}
	}

	public int getSize(){
		return count;
	}

	public void push(String item){
		if (count>=elements.length){
			expand();
		}
		elements[count++] = item;
	}

	public String pop(){
		return elements[--count];
	}

	public String pop(int n){
		if (n<=0 || n>=count){
			throw new IllegalArgumentException("Invalid!!");
		}
		else{
			for (;n!=1;n--){
				pop();
			}
		}

		return pop();
	}

	public String peek(){
		if (count == 0){
			return "EMPTY";
		}
		return elements[count-1];
	}

	public void expand(){
		String[] temp = new String[elements.length + DEFAULT_SIZE];
		for(int i = 0; i<elements.length; i++){
			temp[i] = elements[i];
		}

		elements = new String[temp.length];

		for(int i = 0; i<temp.length; i++){
			elements[i] = temp[i];
		}
	}

	public String toString(){
		String ans = "";

		if (count == 0){
			return "EMPTY";
		}
		else{
			for (int i = 0; i<count-1; i++){
				ans+=elements[i] + ", ";
			}
			ans+= elements[count-1];
			return ans;
		}
	}

public static void main(String[] args){
		StringStack myStack=new StringStack();
		myStack.push("pen");
		myStack.push("apple");
		myStack.push("applepen");
		System.out.println(myStack);
		System.out.println(myStack.pop(2));
		myStack.push("pineapple");
		myStack.push("pen");
		myStack.push("penpineapple");
		myStack.push("PPAP");
		myStack.push("IHaveAPen");
		myStack.push("JPOP");
		System.out.println(myStack);
		System.out.println(myStack.peek());
	}

}

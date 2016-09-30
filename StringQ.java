import java.util.*;

public class StringQ{
	private String[] elements;
	private int count; 
	public static final int DEFAULT_SIZE=10;

	public StringQ(){
		this(DEFAULT_SIZE);
	}

	public StringQ(int size){
		if (size <=0){
			throw new IllegalArgumentException("Invalid Input!!");
		}
		else{
			elements = new String[size];
		}
	}

	public void enqueue(String item){
		if (count>=elements.length){
			expand();
		}
		elements[count++] = item;
	}
	public String dequeue(){
	String remove = elements[0];
		for (int i = 0; i<count; i++){
			elements[i] = elements[i+1];
		}
		count--;
		return remove;
	}

	public String dequeue(int pos){
		if (pos<=0 || pos>=count){
			throw new IllegalArgumentException("Invalid!!");
		}
		else{
			for (;pos!=1;pos--){
				dequeue();
			}
		}

		return dequeue();
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

	public String peek(){
		if (count == 0){
			return "EMPTY";
		}
		return elements[0];
	}

	public void singit(int pos, String item){
		boolean flag = true;
		if (pos < 0){
			throw new IllegalArgumentException("Invalid Position!!");
		}
		else if (pos > count && count<elements.length){
			elements[count++] = item;
			flag = false;

		}
		else if (count>=elements.length){
			expand();
		}
		if (flag){
			for (int i = count; i>=pos; i--){
				elements[i] = elements[i-1];
			}
			elements[pos-1] = item;
			count++;
		}
	}

	public int getSize(){
		return count;
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

public static void main(String[] args){
		StringQ myQueue=new StringQ();
		myQueue.enqueue("pen");
		myQueue.enqueue("apple");
		myQueue.enqueue("applepen");
		System.out.println(myQueue);	
		System.out.println(myQueue.dequeue(2));
		myQueue.enqueue("pineapple");
		myQueue.enqueue("pen");
		myQueue.enqueue("penpineapple");
		myQueue.enqueue("9gag");
		myQueue.enqueue("loves");
		myQueue.enqueue("PPAP");
		System.out.println(myQueue);
		myQueue.singit(2,"penpineapplepen");
		System.out.println(myQueue);
		System.out.println(myQueue.peek());
	}

}

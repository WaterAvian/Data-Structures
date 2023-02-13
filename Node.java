package LinkedList;
public class Node <T> {
	private Node<T> forward;
	private Node<T> backward;
	
	Node(int size, Node<T> backward, Node<T> forward){
		Object data[] = new Object[size];		
		this.forward = forward;
		this.backward = backward;
	}
	Node(int size){
		Object data[] = new Object[size];
		this.forward = null;
		this.backward = null;
	}
	
	//updates Nodes references, returns 1 on success
	public int updateReferences(Node<T> backward, Node<T> forward)
	{
		this.backward = backward;
		this.forward = forward;
		return 1;
	}
	
	public Node<T> getReferencesForward()
	{
		return this.forward;
	}
	public Node<T> getReferencesBackward()
	{
		return this.backward;
	}
	
}

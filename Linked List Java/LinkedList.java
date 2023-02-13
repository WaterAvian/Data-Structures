package LinkedList;
class LinkedList<T> {
	Node<T> currentNode;
	Node<T> headNode;
	Node<T> lastNode;
	int sizeOfList;
	int mostAccessed[];
	int  defaultNodeSize;
	
	//Will generate a linkedList with Node sizes of a specific size.
	public LinkedList(int defaultNodeSize) {
	Node<T> node = new Node(defaultNodeSize);
	this.headNode = node;
	this.currentNode = this.headNode;
	this.lastNode = this.headNode;
	this.defaultNodeSize = defaultNodeSize;
	sizeOfList = 1;
	}
	
	//Node++ to the end of the list, returns 1 on success.
	public int addNode()
	{
		Node<T> newNode = (Node<T>) new Node(defaultNodeSize, this.lastNode, null);
		lastNode.updateReferences(lastNode.getReferencesBackward(), newNode);
		this.lastNode = newNode;
		sizeOfList++;
		return 1;
	}
	public Node<T> newNode()
	{
		Node<T> newNode = new Node(defaultNodeSize);
		return newNode;
	}
	//Inserts a supplied node at a given index.
	public int insertNode(int index, Node<T> newNode) {
		currentNode = newNode;
		Node<T> insertBeforeNode = findNode(index);
		if(insertBeforeNode == lastNode) {addNode();}
		currentNode.updateReferences(insertBeforeNode.getReferencesBackward(), insertBeforeNode);
		insertBeforeNode.updateReferences(currentNode, insertBeforeNode.getReferencesForward());
		return 1;
	}
	//Find node at a given index.
	public Node<T> findNode(int index)
	{
		Node<T> finderNode = headNode;
		for(int i = 0; i < index || i < sizeOfList; i++)
		{
			finderNode = finderNode.getReferencesForward();
		}
		return finderNode;
	}
	//Deletes the Node at a given index.
	public int deleteNode(int index)
	{
		Node<T> toBeDeleted = findNode(index);
		Node<T> backwardNode = toBeDeleted.getReferencesBackward();
		Node<T> forwardNode = toBeDeleted.getReferencesForward();
		
		backwardNode.updateReferences(backwardNode.getReferencesForward(), forwardNode);
		forwardNode.updateReferences(backwardNode, forwardNode.getReferencesForward());
		toBeDeleted.updateReferences(null, null);
		return 1;
	}
}

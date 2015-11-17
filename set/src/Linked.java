import java.util.Collection;
import java.util.Iterator;

/**
 * Basic implementation of a set, using a linked list
 *
 * @author HS
 * @version 2015.11.17
 * @param <Q> Type of data contained in node
 */
public class Linked<Q> implements Set151Interface<Q> {
	// The head of the list
	private Node head;
	
	// The length of the set
	private int length;
	
	/**
	 * Initialize the empty set
	 */
	public Linked() {
		// The clear method sets desired state
		this.clear();
	}
	
	/**
	 * Initialize the set with elements from the collection
	 * @param coll Items to add
	 */
	public Linked(Collection<? extends Q> coll) {
		this();
		
		checkForNull(coll);
		
		this.addAll(coll);
	}

	/**
	 * Return a new iterator to the set
	 */
	@Override
	public Iterator<Q> iterator() {
		return new NodeIterator();
	}

	/**
	 * Is the linked list empty
	 * @return True if empty
	 */
	@Override
	public boolean isEmpty() {
		return length == 0;
	}
	
	/**
	 * Get the size of the linked list
	 * @return Linked list size
	 */
	@Override
	public int size() {
		return length;
	}
	
	/**
	 * Reinitialize empty set
	 */
	@Override
	public void clear() {
		this.head = null;
		this.length = 0;
	}
	
	/**
	 * Throw exception if object is null
	 * @param o Object
	 */
	private void checkForNull(Object o) {
		if (o == null)
			throw new  IllegalArgumentException();
	}
	
	/**
	 * Get a node at the requested position in the linked list
	 * @param position Linked list position
	 * @return Node at position
	 */
	private Node getNodeAt(int position) {
		// The node which will eventually be returned
		Node walker = head;
		
		assert position > 0 && position <= length : "Invalid position requested";
		
		for (int i = 1; i < position; i++) {
			walker = walker.next;
		}
		
		return walker;
	}

	/**
	 * Add items from collection to the set
	 * @param coll Items to initialize
	 * @return True if items added
	 */
	@Override
	public boolean addAll(Collection<? extends Q> coll) {
		// Has the set been altered?
		boolean listChanged = false;
		
		// Iterator of items to be added
		Iterator<? extends Q> iter;
		
		checkForNull(coll);
		
		iter = coll.iterator();
		
		while (iter.hasNext()) {
			if (this.add((Q) iter.next()))
				listChanged = true;
		}
		
		return listChanged;
	}
	
	/**
	 * Determine if an element is contained in the set
	 * @param obj Element
	 * @return True if element exists
	 */
	@Override
	public boolean contains(Object obj) {
		// Data to search for
		Q data = (Q) obj;
		
		// Temporary node for walking list
		Node walker = head;
		
		// Does element already exist in set?
		boolean exists = false;
		
		checkForNull(obj);
		
		while (walker != null) {
			if (walker.getData().equals(data)) 
				exists = true;
			walker = walker.next;
		}
		
		return exists;
	}
	
	/**
	 * Add an element to the set
	 * @param data New element
	 * @return True if added
	 */
	@Override
	public boolean add(Q data) {
		// Node to be added to end of linked list 
		Node node;
		
		// Should this element be added to set? 
		boolean addElement = !this.contains(data);
		
		if (addElement) {
			 node = new Node(data);
			if (this.size() == 0) 
				head = node;
			else
				this.getNodeAt(length).next = node;
			length++;
		}
		
		return addElement;	
	}

	/**
	 * Return a string representation of the set
	 * @return Set description
	 */
	@Override
	public String toString() {
		// Node used to iterate through the list
		Node walker = head;
		
		// String to be returned
		StringBuilder retStr = new StringBuilder();
		
		while (walker != null) {
			retStr.append(", ").append(walker.getData());
			walker = walker.next;
		}
		
		// Remove the starting comma
		if (retStr.length() > 2)
			retStr.delete(0, 2);
		
		// Add the opening and closing brackets
		retStr.insert(0, '<');
		retStr.append('>');
		
		return retStr.toString();
	}
	
	/**
	 * Determine if elements are contained in set
	 * @param coll Elements
	 * @return True if all elements exist
	 */
	@Override
	public boolean containsAll(Collection<?> coll) {
		// Iterator of comparison collection
		Iterator<?> iterator;
		
		if (coll == null || coll.size() == 0)
			throw new IllegalArgumentException();
		
		if (coll.size() > this.size())
			return false;
		
		iterator = coll.iterator();	
		while (iterator.hasNext()) {
			if (!this.contains(iterator.next()))
				return false;		
		}	
		
		return true;
	}
	
	/**
	 * Remove an item from the set
	 * @param data Data of item to remove
	 * @return True if item removed
	 */
	@Override
	public boolean remove(Object data) {
		// The item which we'll remove
		Node walker = head;
		
		if (isEmpty() || data == null)
			throw new IllegalArgumentException();
		
		// Handle case where item is first in list
		if (walker.getData().equals((Q) data)) {
			if (this.size() == 1)
				this.clear();
			else {
				head = head.next;
				length--;
			}
			return true;
		}
		
		// Check items two through end of list
		if (this.size() > 1)
			while (walker.next != null) {
				if(walker.next.getData().equals((Q) data)) {
					walker.next = walker.next.next;
					length--;
					return true;
				}
				walker = walker.next;
			}
		
		return false;
	}

	/**
	 * Remove collection of elements from the set
	 * @param c Elements
	 * @return True if elements removed
	 */
	@Override
	public boolean removeAll(Collection<?> c) {
		// Starting size of the set
		int startSize = this.size();
		
		// Our iterator for the collection
		Iterator<?> iterator;
		
		if (!c.isEmpty()) {
			iterator = c.iterator();
			
			while (iterator.hasNext()) {
				this.remove(iterator.next());
			}
			
			return startSize != this.size();
		}
			
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// Starting size of our collection
		int startSize = this.size();
		
		// The current element in our list
		Node walker = head;
		
		while (walker != null) {
			if (!c.contains(walker.getData()))
				this.remove(walker.getData());
			walker = walker.next;
		}
		
		return !(startSize == this.size());
	}

	/**
	 * Not supported in our implementation
	 */
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not supported in our implementation
	 */
	@Override
	public <T> T[] toArray(T[] array) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Test if set is equal to another
	 * @return True if equal
	 */
	@Override
	public boolean equals(Object obj) {
		// Set to be compared
		Linked<Q> other;
		
		if (obj != null && obj instanceof Set151Interface) {
			other = (Linked<Q>) obj;
			
			return (this.size() == 0 || this.containsAll(other)) && 
					(other.size() == this.size());
		}
		
		return false;
	}	

	/**
	 * Basic implementation of a node for a linked list
	 */
	private class Node {
		// The next node in the linked list 
		private Node next;
		
		// The data contained in this node 
		private Q data;
		
		/**
		 * Initialize the node with data
		 * @param data Node data
		 */
		public Node(Q data) {
			this.data = data;
			this.next = null;
		}

		/**
		 * Get data from the current node
		 * @return Node data
		 */
		public Q getData() {
			return data;
		}
	}
	
	/**
	 * Iterator for collections of element type Q
	 */
	public class NodeIterator implements Iterator<Q> {
		// Current element of iteration
		Node current;
		
		/**
		 * Initialize the iterator
		 */
		private NodeIterator() {
			current = null;
		}
		
		/**
		 * Determine if elements exist past current
		 * @return True if further elements exist
		 */
		public boolean hasNext() {
			return (current == null && head != null) || current.next != null;
		}
		
		/**
		 * Return the next element in the collection
		 * @return Next element in list
		 */
		public Q next() {
			current = current == null ? head : current.next;
			return current.getData();
		}
	}
}

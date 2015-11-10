import java.util.Collection;
import java.util.Iterator;

/**
 * Basic implementation of a set, using a linked list
 *
 * @param <Q> Type of data contained in node
 */
public class Lset<Q> implements Set151Interface<Q> {
	/** The head of the linked list */
	private Node head;
	
	/** The length of the linked list */
	private int length;
	
	public Lset() {
		// The clear method sets desired state
		this.clear();
	}
	
	public Lset(Collection<? extends Q> coll) {
		this.addAll(coll);
	}
	
	public class NodeIterator implements Iterator<Q> {
		Node current;
		
		private NodeIterator() {
			current = null;
		}
		
		public boolean hasNext() {
			return (current == null && head != null) || current.next != null;
		}
		
		public Q next() {
			current = current == null ? head : current.next;
			return current.getData();
		}
	}
	
	@Override
	public Iterator<Q> iterator() {
		return new NodeIterator();
	}

	/**
	 * Get a node at the requested position in the linked list
	 * @param position Linked list position
	 * @return Node at position
	 */
	private Node getNodeAt(int position) {
		/** The node which will eventually be returned */
		Node walker = head;
		
		assert position > 0 && position <= length : "Invalid position requested";
		
		for (int i = 1; i < position; i++) {
			walker = walker.next;
		}
		
		return walker;
	}
	
	/**
	 * Add a node to the linked list
	 * @param data Data for new node
	 */
	@Override
	public boolean add(Q data) {
		/** Node to be added to end of linked list */
		Node node;
		
		/** Should this element be added to set? */
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

	/** Reinitialize the linked list to be empty */
	@Override
	public void clear() {
		this.head = null;
		this.length = 0;
	}

	@Override
	public boolean contains(Object obj) {
		Q data = (Q) obj;
		
		/** Temporary node variable for walking linked list */
		Node walker = head;
		
		/** Does new node already exist in linked list? */
		boolean exists = false;
		
		while (walker != null) {
			if (walker.getData().equals(data)) 
				exists = true;
			walker = walker.next;
		}
		
		return exists;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Is the linked list empty
	 * @return True if empty
	 */
	@Override
	public boolean isEmpty() {
		return length == 0;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Q> coll) {
		boolean listChanged = false;
		
		Iterator<? extends Q> iter = coll.iterator();
		while (iter.hasNext()) {
			if (this.add((Q) iter.next()))
				listChanged = true;
		}
		
		return listChanged;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Get the size of the linked list
	 * @return Linked list size
	 */
	@Override
	public int size() {
		return length;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] array) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		Node walker = head;
		
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
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Lset) {
			Lset<Q> other = (Lset<Q>) obj;
			Iterator<Q> iterator = other.iterator();
			while (iterator.hasNext()) {
				if (!this.contains(iterator.next()))
					return false;		
				if (this.size() == other.size())
					return true;
			}
			
		}
		return false;
	}
	
	/**
	 * Basic implementation of a node for a linked list
	 */
	private class Node {
		/** The next node in the linked list */
		private Node next;
		
		/** The data contained in this node */
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
	
}
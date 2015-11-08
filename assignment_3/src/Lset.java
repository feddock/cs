import java.util.Collection;
import java.util.Iterator;

public class Lset<Q> implements Set151Interface<Q> {
	/** The head of the linked list */
	private Node head;
	
	/** The length of the linked list */
	private int length;
	
	@Override
	public Iterator<Q> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Add a node to the linked list
	 * @param data Data for new node
	 */
	@Override
	public boolean add(Q data) {
		/** Node to be added to end of linked list */
		Node node = new Node(data);
		
		/** Does new node already exist in linked list? */
		boolean exists = false;
		
		/** Temporary node variable for walking linked list */
		Node walker = head;
		
		if (length == 0) {
			head = node;
			length++;
		} else {
			while (walker.next != null) {
				walker = walker.next;
				if (walker.getData().equals(data)) 
					exists = true;
			}
			
			if (!exists) {
				walker.next = node;
				length++;
			}
		}
		
		return !exists;
	}

	/** Reinitialize the linked list to be empty */
	@Override
	public void clear() {
		this.head = null;
		this.length = 0;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Q> c) {
		// TODO Auto-generated method stub
		return false;
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

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
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
	
	/**
	 * Basic implementation of a ndoe for a linked list
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
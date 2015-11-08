import java.util.Collection;
/**
 * This is an interface which models a Collection that contains <b>no</b> duplicate elements. It
 * models the mathematical <i>set</i> abstraction. This interface is based on the Java
 * <code>Set</code> interface, but there are substantial differences.
 *
 * An additional stipultation is that no constructor will construct a set containing duplicate
 * elements.
 * CS151, progect 2.
 * @author William Kreahling
 * @version 9/27/14.
 */
public interface Set151Interface<Q> extends Collection<Q>{

    /**
     * Adds the specified element to this set if it is not already present.
     * More formally, adds the specified element e to this set if the set contains no element e2
     * such that e != null &amp;&amp; e.equals(e2). If this set already contains the element,
     * the call leaves the set unchanged and returns false. In combination with the restriction on
     * constructors, this ensures that sets never contain duplicate elements.
     * @param q element to be added to this set.
     * @return true if the set did not already contain the element.
     * @throws IllegalArgumentException if the element to be added is null.
     */
    public boolean add(Q q);
    /**
     * Clears all data from this set.
     */
    public void clear();
    /**
     * Determine if a specific object is in the set.
     * @param o object to search for
     * @return true if the object is in the set, false otherwise.
     * @throws IllegalArgumentException generated if the object to search for is null.
     */
    public boolean contains(Object o);
    /**
     * Returns true if this set contains all of the elements of the specified collection. If the
     * specified collection is also a set, this method returns true if it is a subset of this set.
     * @param c collection to be checked for containment in this set.
     * @return true if this set contains all the elements of the specified collection.
     * @throws IllegalArgumentException If the specified collection is null or contains any null
     * elements.
     */
    public boolean containsAll(Collection<?> c);
    /**
     * Returns the hash code value for this set. The hash code of a set is defined to be the sum
     * of the hash codes of all the elements in the set. This ensures that s1.equals(s2) implies
     * that s1.hashCode() == s2.hashCode() for any two sets s1 and s2, as required by the general
     * contract of Object.hashCode(). <b>Note: hashcode exists in class Object.</b>
     */
    public int hashCode();
    /**
     * Determine if this set contains no elements.
     * @return true if this set contains no elements, false otherwise.
     */
    public boolean isEmpty();
    /**
     * Removes the specified element from this set if it is present. (This set will not contain
     * the element once the call returns.)
     * @return true if this set contained the element (or equivalently, if this set changed as a
     * result of the call). 
     * @throws IllegalArgumentException if the specified object is null.
     */
    public boolean remove(Object o);
    /**
     * Adds all of the elements in the specified collection to this set if they're not already
     * present (optional operation). If the specified collection is also a set, the addAll
     * operation effectively modifies this set so that its value is the union of the two sets. The
     * behavior of this operation is undefined if the specified collection is modified while the
     * operation is in progress.
     * @param c collection containing elements to be added to this set.
     * @return true if this set is changed because of this call, false otherwise.
     * @throws IllegalArgumentException if collection is null or contains a null element.
     */
    public boolean addAll(Collection<? extends Q> c);

    /**
     * Removes from this set all of its elements that are contained in the specified collection.
     * If the specified collection is also a set, this operation effectively
     * modifies this set so that its value is the asymmetric set difference of the two sets.
     * @param c collection containing elements to be removed from this set.
     * @return true if this set is changed because of this call, false otherwise.
     * @throws IllegalArgumentException if the specified collection is null.
     */
    public boolean removeAll(Collection<?> c);
    /**
     * Retains only the elements in this set that are contained in the specified collection.
     * In other words, removes from this set all of its elements that are
     * not contained in the specified collection. If the specified collection is also a set, this
     * operation effectively modifies this set so that its value is the intersection of the two
     * sets.
     * @param c collection containing elements to be retained in this set.
     * @return true if this set is changed because of this call, false otherwise.
     * @throws IllegalArgumentException if the specified collection is null.
     */
    public boolean retainAll(Collection<?> c);
    /**
     * Returns the number of elements in this set (its cardinality).
     * @return the number of elements in this set (tis cardinality).
     */
    public int size();
    /**
     * This operation is not supported in Aset.
     * @throws UnsupportedOperationException operation is not supported.
     */
    public Object[] toArray();
    /**
     * This operation is not supported in Aset.
     * @throws UnsupportedOperationException operation is not supported.
     */
    public <T> T[] toArray(T[] array);
}

import java.util.ArrayList;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Collection;
import java.lang.UnsupportedOperationException;
/**
 * Driver for the Aset class.
 * @author William Kreahling
 * @version 10/2/2014
 */

enum Type {ARRAY, LINKED};
public class SetTester {
    private int     passes;
    private int     failures;
    private Type    currentType;

    public void runTests() {
        passes   = 0;
        failures = 0;

        System.out.print("========================================");
        System.out.println("========================================");
        System.out.println("Testing sets built using: " + currentType + "               ");
        System.out.print("========================================");
        System.out.println("========================================");

        testConstruction();
        testAdd();
        testAddAll();
        testRemove();
        testContains();
        testEquals();
        testPreconditions();
        testRemoveAll();
        testRetainAll();

        System.out.print("========================================");
        System.out.println("========================================");
        System.out.println("Tests executed:    " + (passes + failures));
        System.out.println("     Successful:   " + passes);
        System.out.println("     Unsuccessful: " + failures);
    }

    private int getPasses() {
        return passes;
    }

    private int getFailures() {
        return failures;
    }

    /**
     * A helper method that increments the pass/fail counters and prints
     * an appropriate message based on the value of the specified condition.
     *
     * @param condition A condition for which to test.  If the condition is
     *        true, the test passed; otherwise, it fails.
     * @param message A message to print indicating the context for the test.
     */
    private void test(boolean condition, String message) {
        if (condition) {
            System.out.println("PASSED: " + message);
            passes = passes + 1;
        } else {
            System.out.println("FAILED: " + message);
            failures = failures + 1;
        }
    }

    private void testConstruction() {
        System.out.println("\nTesting Constructor");
        System.out.print("----------------------------------------");
        System.out.println("----------------------------------------");

        Set151Interface s = makeSet();

        test(s.size() == 0,
             "size() should return 0: " + s.size());
        test(s.toString().equals("<>"),
             "toString returns \"<>\": " + s.toString());


        ArrayList<String> temp = new ArrayList<String>();
        temp.add("Butterfinger");
        temp.add("Milky Way");
        temp.add("Kit Kat");
        temp.add("Three Muskateers");

        Set151Interface s3 = makeSet(temp);
        test(s3.size() == 4,
             "size should return 4: " + s3.size());
        test(s3.toString().equals("<Butterfinger, Milky Way, Kit Kat, Three Muskateers>"),
             "toString should return\n        "+
             "\"<Butterfinger, Milky Way, Kit Kat, Three Muskateers>\":\n       " 
             + s3.toString());

    }

    private void testAdd() {
        System.out.println("\nTesting add()");
        System.out.print("----------------------------------------");
        System.out.println("----------------------------------------");

        Set151Interface s = makeSet();
        s.add(new Double(1.1));

        test(s.toString().equals("<1.1>"),
             "After add(1.1), toString return <1.1>: " + s.toString());
        test(s.size() == 1,
             "size is 1: " + s.size());

        s.add(new Double(2.2));
        test(s.toString().equals("<1.1, 2.2>"),
               "After add(2.2), toString should return <1.1, 2.2>: " + s.toString());
        test(s.size() == 2,
             "size is 2: " + s.size());

        s.add(new Double(7.3));
        test(s.toString().equals("<1.1, 2.2, 7.3>"),
             "After add(3.3), toString returns <1.1, 2.2, 7.3>:\n" + "        " + s.toString());
        test(s.size() == 3,
             "size is 3: " + s.size());

        s.add(new Double(4.4));
        test(s.toString().equals("<1.1, 2.2, 7.3, 4.4>"),
             "After add(4.4), toString should return <1.1, 2.2, 7.3, 4.4>:\n" + "        " + 
             s.toString());
        test(s.size() == 4,
             "size is 4: " + s.size());

        s.add(new Double(5.5));
        test(s.toString().equals("<1.1, 2.2, 7.3, 4.4, 5.5>"),
             "After add(5.5), toString should return "
             + "<1.1, 2.2, 7.3, 4.4, 5.5>:\n" + "        " + s.toString());

        s.add(new Double(6.6));
        test(s.toString().equals("<1.1, 2.2, 7.3, 4.4, 5.5, 6.6>"),
               "After add(6.6), toString should return "
             + "<1.1, 2.2, 7.3, 4.4, 5.5, 6.6>:\n" + "        " + s.toString());

        s.add(new Double(7.7));
        s.add(new Double(8.8));
        s.add(new Double(9.9));
        s.add(new Double(1.2));
        test(s.toString().equals("<1.1, 2.2, 7.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9, 1.2>"),
             "After adding 4 more, toString should return\n        "
             + "<1.1, 2.2, 7.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9, 1.2>:\n"
             + "        " + s.toString());
        test(s.size() == 10,
             "size returns 10: " + s.size());


        s.add(new Double(2.3));
        test(s.toString().equals("<1.1, 2.2, 7.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9, 1.2, 2.3>"),
             "After adding 1 more, toString should return\n        "
             + "<1.1, 2.2, 7.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9, 1.2, 2.3>:\n"
             + "        " + s.toString());
        test(s.size() == 11,
             "size returns 11: " + s.size());
    }

    private void testRemove() {
        System.out.println("\nTesting Remove()");
        System.out.print("----------------------------------------");
        System.out.println("----------------------------------------");

        Set151Interface s = makeSet();
        s.add("one");
        s.add("two");
        s.add("three");
        s.add("four");
        s.add("five");
        s.add("six");
        s.add("seven");
        s.add("eight");

        s.remove("six");
        test(s.toString().equals("<one, two, three, four, five, seven, eight>"),
             "Removing \"six\" " +
             "toString should return <one, two, three, four, five, seven, eight>:\n" + 
             "                                              " + s.toString());
        test(s.size() == 7,
             "size should be 7: " + s.size());

        s.remove("three");
        test(s.toString().equals("<one, two, four, five, seven, eight>"),
             "Removing \"three \" " +
             "toString should return <one, two, four, five, seven, eight>:\n" + 
             "                                                 " + s.toString());
        test(s.size() == 6,
             "size should be 6: " + s.size());

        s.remove("one");
        test(s.toString().equals("<two, four, five, seven, eight>"),
             "Removing \"one\" " +
             "toString should return <two, four, five, seven, eight>:\n" + 
             "                                              " + s.toString());
        test(s.size() == 5,
             "size should be 5: " + s.size());

        s.remove("one");
        test(s.toString().equals("<two, four, five, seven, eight>"),
             "Removing \"nothing\" " +
             "toString should return <two, four, five, seven, eight>:\n" + 
             "                                                  " + s.toString());
        test(s.size() == 5,
             "size should be 5: " + s.size());

    }

    private void testAddAll() {
        System.out.println("\nTesting addAll()");
        System.out.print("----------------------------------------");
        System.out.println("----------------------------------------");

        Set151Interface s1 = makeSet();

        s1.add(1.1);
        s1.add(3.3);
        s1.add(2.2);

        Set151Interface s2 = makeSet();
        s2.add("banana");
        s2.add("ice cream");
        s2.add("sprinkles");

        s1.addAll(s2);
        test(s1.toString().equals("<1.1, 3.3, 2.2, banana, ice cream, sprinkles>"),
             "After addAll(s2), s1 should be\n" +
             "        <1.1, 3.3, 2.2, banana, ice cream, sprinkles>:\n" +
             "       " + s1.toString());
        test(s1.size() == 6,
             "s1's size is 6: " + s1.size());

        test(s2.toString().equals("<banana, ice cream, sprinkles>"),
             "After addAll(), s2 should be: <banana, ice cream, sprinkles> :\n" + 
             "                                      " + s2.toString());
        test(s2.size() == 3,
             "s2's size is 3: " + s2.size());

        s1.addAll(s1);
        test(s1.toString().equals(  "<1.1, 3.3, 2.2, banana, ice cream, sprinkles>"),
               "After addAll(s1), s1 should be:\n      " +
               "<1.1, 3.3, 2.2, banana, ice cream, sprinkles>:\n      " + s1.toString());
        test(s1.size() == 6,
             "s1's size is 6: " + s1.size());

    }
    private void testContains() {
        System.out.println("\nTesting Contains() / ContainsAll()");
        System.out.print("----------------------------------------");
        System.out.println("----------------------------------------");

        Set151Interface s1 = makeSet();

        s1.add(new Novel("Wuthering Heights", "Emily Bronte", "Fiction", 1847));
        s1.add(new Novel("Bourne Identity",   "Robert Ludlam", "Fiction", 1980));
        s1.add(new Novel("The Philosopher's Stone", "J.K. Rowling", "Young Adult", 2001));
        s1.add(new Novel("The Call of Cthulu", "H.P. Lovecraft", "Short Story", 1928));

        test(s1.toString().equals("<Wuthering Heights : Emily Bronte : Fiction : 1847., " +
                                  "Bourne Identity : Robert Ludlam : Fiction : 1980., " + 
                                  "The Philosopher's Stone : J.K. Rowling : Young Adult : 2001.,"
                                  + " The Call of Cthulu : H.P. Lovecraft : Short Story : 1928.>"),
             "After creation, s1 should be: <Wuthering Heights : Emily Bronte : Fiction : 1847.,"
             + " Bourne Identity : Robert Ludlam : Fiction : 1980.," + 
             " The Philosopher's Stone : J.K. Rowling : Young Adult : 2001.," + 
             " The Call of Cthulu : H.P. Lovecraft : Short Story : 1928.>  :\n" + 
             "                                      " + s1.toString());
        System.out.println();
        test(s1.size() == 4,
             "s1's size should be 4: " + s1.size());

        test(s1.contains(
        new Novel("The Philosopher's Stone", "J.K. Rowling", "Young Adult", 2001)) == true,
             "s1's should return true: " + s1.contains(new Novel("The Philosopher's Stone",                                                                          "J.K. Rowling", "Young Adult", 
                                                                 2001)));

        Set151Interface s3 = makeSet();
        s3.add('S');
        s3.add('t');
        s3.add('a');
        s3.add('R');
        s3.add(' ');
        s3.add('w');
        s3.add('A');
        s3.add('r');
        s3.add('s');
        s3.add('!');

        Collection<Character> all = new LinkedList<Character>();
        all.add('R');
        all.add('a');
        all.add('w');
        all.add('R');
        all.add('!');


        test(s3.containsAll(all),
             "s3's Should return true: " + all.toString() + " is contained in " + s3.toString());

        all.clear();
        all.add('s');
        all.add('t');
        all.add('a');
        all.add('r');
        test(s3.containsAll(all),
             "s3's Should return true: " + all.toString() + " is contained in " + s3.toString());
        all.clear();
        all.add('S');
        all.add('T');
        all.add('A');
        all.add('R');
        test(!s3.containsAll(all),
             "s3's Should return false: " + all.toString() + " is NOT contained in " + 
             s3.toString());

    }

    private void testEquals() {
        System.out.println("\nTesting equals()");
        System.out.print("----------------------------------------");
        System.out.println("----------------------------------------");

        Set151Interface s1 = makeSet();
        Set151Interface s2 = makeSet();
        Set151Interface s3 = makeSet();
        Set151Interface s4 = makeSet();
        Set151Interface s5 = makeSet();
        s3.add(1.1);
        s4.add(1.1);
        s5.add(1.1);
        s5.add(2.2);
       


        test(s1.equals(s1),
             "An empty sequence is equal to itself: " + s1.equals(s1));
        test(s1.equals(s2),
               "An empty sequence is equal to an empty sequence : "
             + s1.equals(s2));
        test(!s1.equals(s3),
             "An empty sequence is not equal to a non-empty one: (false): "
             + s1.equals(s3));
        test(s3.equals(s4),
             "Two non-empty equal sequences are equal: " + s3.equals(s4));
        test(s4.equals(s3),
                "Two non-empty equal sequences are equal: " + s4.equals(s3));
        test(!s3.equals(s5),
             "Two non-empty, non-equal sequences are equal (false): " + s3.equals(s5));


    }

    private void testPreconditions() {
        System.out.println("\nTesting preconditions");
        System.out.print("----------------------------------------");
        System.out.println("----------------------------------------");

        try {
            Set151Interface s = makeSet();
            s.addAll(null);
            test(false, "addAll(null) should throw a IAE");
        } catch (IllegalArgumentException ex) {
            test(true, "addAll(null) should throw a IAE: " + ex.getMessage());
        } catch (Throwable ex) {
            test(false, "addAll(null) should throw a IAE, got: "
                 + ex.getMessage());
            ex.printStackTrace();
        }
        try {
            Set151Interface s = makeSet();
            s.add(null);
            test(false, "add(null) should throw a IAE");
        } catch (IllegalArgumentException ex) {
            test(true, "add(null) should throw a IAE: " + ex.getMessage());
        } catch (Throwable ex) {
            test(false, "add(null) should throw a IAE, got: " + ex.getMessage());
            ex.printStackTrace();
        }
        try {
            Set151Interface s = makeSet();
            s.add(1.1);
            s.contains(null);
            test(false, "contains(null) should throw a IAE");
        } catch (IllegalArgumentException ex) {
            test(true, "contains(null) should throw a IAE: " + ex.getMessage());
        } catch (Throwable ex) {
            test(false, "contains(null) should throw a IAE, got: " + ex.getMessage());
            ex.printStackTrace();
        }

        try {
            Set151Interface s = makeSet(null);
            test(false, "creating an set with null as input should throw an IAE");
        } catch (IllegalArgumentException ex) {
            test(true, "creating an set with null as input should throw an IAE:\n"
                 + "        " + ex.getMessage());
        } catch (Throwable ex) {
            test(false, "constructor with null input should throw a IAE, got:\n"
                 + "        " + ex.getMessage());
            ex.printStackTrace();
        }
        try {
            Set151Interface s = makeSet();
            s.add(1.1);
            s.add(2.2);
            s.containsAll(null);
            test(false, "containsAll(null) should throw a IAE");
        } catch (IllegalArgumentException ex) {
            test(true, "containsAll(null) should throw a IAE: " + ex.getMessage());
        } catch (Throwable ex) {
            test(false, "containsAll(null) should throw a IAE, got: " + ex.getMessage());
            ex.printStackTrace();
        }
        try {
            Set151Interface s = makeSet();
            s.add(1.1);
            s.add(2.2);
            LinkedList<Double> all = new LinkedList<Double>();
            all.add(1.1);
            all.add(null);
            s.containsAll(all);
            test(false, "containsAll(set) should throw a IAE");
        } catch (IllegalArgumentException ex) {
            test(true, "containsAll(set) should throw a IAE: " + ex.getMessage());
        } catch (Throwable ex) {
            test(false, "containsAll(set) should throw a IAE, got: " + ex.getMessage());
            ex.printStackTrace();
        }
        try {
            Set151Interface s = makeSet();
            s.add(1.1);
            s.add(2.2);
            LinkedList<Double> all = new LinkedList<Double>();
            all.add(1.1);
            all.add(null);
            s.addAll(all);
            test(false, "addAll(set) should throw a IAE");
        } catch (IllegalArgumentException ex) {
            test(true, "addAll(set) should throw a IAE: " + ex.getMessage());
        } catch (Throwable ex) {
            test(false, "addAll(set) should throw a IAE, got: " + ex.getMessage());
            ex.printStackTrace();
        }
        try {
            LinkedList<Double> all = new LinkedList<Double>();
            all.add(1.1);
            all.add(null);
            Set151Interface s = makeSet(all);
            test(false, "constructor(set) should throw a IAE");
        } catch (IllegalArgumentException ex) {
            test(true, "constructor(set) should throw a IAE: " + ex.getMessage());
        } catch (Throwable ex) {
            test(false, "constructor(set) should throw a IAE, got: " + ex.getMessage());
            ex.printStackTrace();
        }

    }
    private void testRemoveAll() {
        System.out.println("\nTesting removeAll()");
        System.out.print("----------------------------------------");
        System.out.println("----------------------------------------");

        Set151Interface s1 = makeSet();

        s1.add("Lion");
        s1.add("Bear");
        s1.add("Tiger");
        s1.add("Frog");
        s1.add("Pea");

        Set151Interface s2 = makeSet();
        s2.add("Frog");
        s2.add("Princess");
        s2.add("Pea");
        s2.add("Dragon");
        s2.add("Charming");

        s1.removeAll(s2);
        test(s1.toString().equals("<Lion, Bear, Tiger>"),
             "After removeAll(s2), s1 should be" + " <Lion, Bear, Tiger>: " + s1.toString());
        test(s1.size() == 3,
             "s1's size should be 3: " + s1.size());

        System.out.println("**" + s1.toString());
        s1.add("Frog");
        s1.add("Pea");
        System.out.println("**" + s1.toString());
        s2.removeAll(s1);
        test(s2.toString().equals("<Princess, Dragon, Charming>"),
             "After removeAll(s1), s2 should be: <Princess, Dragon, Charming> :\n" + 
             "                                           " + s2.toString());
        test(s2.size() == 3,
             "s2's size should be 3: " + s2.size());

        Set151Interface s3 = makeSet(s1);
        s1.removeAll(s3);
        test(s1.toString().equals("<>"),
               "After removeAll(identical), s1 should be:      " + "<>: " + s1.toString());
        test(s1.size() == 0,
             "s1's size should be 0: " + s1.size());

    }
    private void testRetainAll() {
        System.out.println("\nTesting retainAll()");
        System.out.print("----------------------------------------");
        System.out.println("----------------------------------------");

        Set151Interface s1 = makeSet();

        s1.add("Lion");
        s1.add("Bear");
        s1.add("Tiger");
        s1.add("Frog");
        s1.add("Pea");

        Set151Interface s2 = makeSet();
        s2.add("Frog");
        s2.add("Princess");
        s2.add("Pea");
        s2.add("Dragon");
        s2.add("Charming");

        s1.retainAll(s2);
        test(s1.toString().equals("<Frog, Pea>"),
             "After retainAll(s2), s1 should be" + " <Frog, Pea>: " + s1.toString());
        test(s1.size() == 2,
             "s1's size should be 2: " + s1.size());

        s1.add("Charming");
        s1.add("Tiger");
        s2.retainAll(s1);
        test(s2.toString().equals("<Frog, Pea, Charming>"),
             "After retainAll(s1), s2 should be: <Frog, Pea, Charming> :\n" + 
             "                                           " + s2.toString());
        test(s2.size() == 3,
             "s2's size should be 3: " + s2.size());

        Set151Interface s3 = makeSet(s1);
        s2.retainAll(s3);
        test(s2.toString().equals("<Frog, Pea, Charming>"),
             "After reatinAll(s2), s2 should be: <Frog, Pea, Charming> :\n" +
             "                                           " + s2.toString());
        test(s2.size() == 3,
             "s2's size should be 3: " + s2.size());

    }

    public Set151Interface makeSet(Collection<?> o) {
        Set151Interface set = null;
        if(currentType == Type.ARRAY) {
            //set = new Aset(o);
        } else {
            set = new Lset(o);
        }
        return set;
    }
    public Set151Interface makeSet() {
        Set151Interface set = null;
        if(currentType == Type.ARRAY) {
            //set = new Aset();
        } else {
            set = new Lset();
        }
        return set;
    }

    /**
     * Annoying thing about IntelliJ it does not default to Java 8 behaviour even when it is
     * compiling with Java 8. DUMB Make sure to go to: file->Project Structure->Modules(tab) and
     * set Language level to Java 8. The driver will not compile until you do!
     * @param flag
     */
    public SetTester(String flag) {
        currentType = Type.LINKED;
        switch(flag) {
            case "a":
            case "aset":
            case "array":
                currentType=Type.ARRAY;
                System.out.println("ARRAYS");
                break;

        }
    }
    /**
     * Entry point into the tester.
     * @param args not used.
     */
    public static void main(String[] args) {
        Scanner scanIn = new Scanner(System.in);
        System.out.print("Test (A)set if (L)set? > ");
        String answer = scanIn.next();
        SetTester tester = new SetTester(answer.toLowerCase());
        tester.runTests();
    }
}

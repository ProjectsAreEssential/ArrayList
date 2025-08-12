public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.addAll(0, new ArrayList<>());  // test empty addAll
        
        // Add elements to list1
        list1.addAll(0, new ArrayList<>());
        list1.addAll(0, new ArrayList<>());
        
        // Add some elements manually
        list1.addAll(0, new ArrayList<>());
        list1.addAll(0, new ArrayList<>());
        
        // Let's add elements manually (you'll want an add method)
        list1.add("a");
        list1.add("b");
        list1.add("c");
        System.out.println("list1: " + java.util.Arrays.toString(list1.toArray())); // should print [a, b, c]

        // Create list2
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("b");
        list2.add("c");

        // Test containsAll
        System.out.println("list1 containsAll list2: " + list1.containsAll(list2)); // should be true

        // Test equals
        ArrayList<String> list3 = new ArrayList<>();
        list3.add("a");
        list3.add("b");
        list3.add("c");
        System.out.println("list1 equals list3: " + list1.equals(list3)); // should be true

        // Test lastIndexOf
        list1.add("b");
        System.out.println("lastIndexOf b: " + list1.lastIndexOf("b")); // should be index of last 'b'

        // Test remove
        list1.remove("b");
        System.out.println("list1 after removing b: " + java.util.Arrays.toString(list1.toArray()));

        // Test removeAll
        list1.removeAll(list2);
        System.out.println("list1 after removeAll list2: " + java.util.Arrays.toString(list1.toArray()));

        // Test retainAll
        list1.add("b");
        list1.add("c");
        list1.add("d");
        list1.retainAll(list2);
        System.out.println("list1 after retainAll list2: " + java.util.Arrays.toString(list1.toArray()));

        // Test toArray
        Object[] arr = list1.toArray();
        System.out.println("toArray output: " + java.util.Arrays.toString(arr));
    }
}

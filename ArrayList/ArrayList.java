import java.util.Arrays;

public class ArrayList<E> {
   
   // Constant fields
   private static final int DEFAULT_CAPACITY = 10;
   
   // Instance fields
   private E[] elementData;
   private int size;

   // Default Constructor
   public ArrayList() {
      this(DEFAULT_CAPACITY);
   }
   
   @SuppressWarnings("unchecked")
   // Constructor
   public ArrayList(int capacity) {
      if (capacity < 0) {
         throw new IllegalArgumentException("Capacity: " + capacity);
      }
      
      elementData = (E[]) new Object[capacity];
      size = 0;
   }  
   
   // Add
   public void add(E value) {
      if (size == elementData.length) {
          int newCapacity = elementData.length * 2 + 1;
          elementData = Arrays.copyOf(elementData, newCapacity);
      }
      elementData[size] = value;
      size++;
   }
   
   // Add all
   public void addAll(int index, ArrayList<E> list) {
      if (index < 0 || index > size) {
         throw new IndexOutOfBoundsException();
      }
      
      if (this.size + list.size > elementData.length) {
         int newCapacity = elementData.length * 2;
         elementData = (E[]) Arrays.copyOf(elementData, newCapacity);
      }
      
      for (int i = size - 1; i >= index; i--) {
         elementData[i + list.size] = elementData[i];
      }
      size += list.size;
      
      for (int i = 0; i < list.size; i++) {
         elementData[index + i] = list.elementData[i];
      }
   }

   // Contains all
   public boolean containsAll(ArrayList<E> list) {   
      for (int i = 0; i < list.size; i++) {
      boolean found = false;
         for (int j = 0; j < this.size; j++) {
            if (list.elementData[i].equals(this.elementData[j])) {
               found = true;
               break;
            }
         }
         if (!found) {
            return false;
         }
      }
      return true;
   }
   
   // Equals
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof ArrayList)) return false;
      
      ArrayList<E> other = (ArrayList<E>) o;
      
      if (this.size != other.size) return false;
      
      for (int i = 0; i < this.size; i++) {
         if (this.elementData[i] == null && other.elementData[i] == null) {
            continue;
         }
         if (this.elementData[i] == null || other.elementData[i] == null) {
            return false;
         }
         if (!this.elementData[i].equals(other.elementData[i])) {
            return false;
         }
      }
      return true;
   }
   
   // Last index of
   public int lastIndexOf(Object o) {
      for (int i = this.size - 1; i >= 0; i--) {
         if (o == null && elementData[i] == null || o.equals(this.elementData[i])) {
            return i;
         }
      }
      return -1;
   }
   
   // Remove
   public boolean remove(Object o) {
      for (int i = 0; i < size; i++) {
         if ((o == null && elementData[i] == null) || (o != null && o.equals(elementData[i]))) {
            for (int j = i; j < size - 1; j++) {
               elementData[j] = elementData[j + 1];
            }
            elementData[size - 1]= null;
            size--;
            return true;
         }
      }
      return false;
   }
   
   // Remove all
   public void removeAll(ArrayList<E> list) {
      for (int i = 0; i < size; i++) {
         boolean found = false;
         for (int j = 0; j < list.size; j++) {
            if ((elementData[i] == null && list.elementData[j] == null) ||
                (elementData[i] != null && elementData[i].equals(list.elementData[j]))) {
                found = true;
                break;
            }
         }
         if (found) {
            for (int k = i; k < size- 1; k++) {
               elementData[k] = elementData[k + 1];
            }   
            elementData[size - 1]= null;
            size--;
            i--;
         }
      }
   }
   
   // Retain all
   public void retainAll(ArrayList<E> list) {
      for (int i = 0; i < size; i++) {
          boolean found = false;
          for (int j = 0; j < list.size; j++) {
              if ((elementData[i] == null && list.elementData[j] == null) ||
                  (elementData[i] != null && elementData[i].equals(list.elementData[j]))) {
                  found = true;
                  break;
              }
          }
          if (!found) {
              for (int k = i; k < size - 1; k++) {
                  elementData[k] = elementData[k + 1];
              }
              elementData[size - 1] = null;
              size--;
              i--;
          }
       }
    }
   
   // To array
   public Object[] toArray() {
      Object[] o = new Object[this.size];
      for (int i = 0; i < this.size; i++) {
         o[i] = this.elementData[i];
      }
      return o;
   }
}
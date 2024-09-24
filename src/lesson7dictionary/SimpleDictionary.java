package lesson7dictionary;

import java.util.*;

public class SimpleDictionary<K, V> {

    private static final int DEFAULT_CAPACITY = 10;
    private Entry<K, V>[] entries;
    private int size = 0;

    public static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + " => " + value;
        }
    }

    @SuppressWarnings("unchecked")
    public SimpleDictionary(int capacity) {
        this.entries = new Entry[capacity];
    }

    //@SuppressWarnings("unchecked")
    public SimpleDictionary() {
        this(DEFAULT_CAPACITY);
    }

    public boolean remove(K key) {
        int hashcode = Objects.hashCode(key);
        int index = hashcode % entries.length;

        Entry<K, V> current = entries[index];
        Entry<K, V> previous = null;

        while (current != null) {
            if (Objects.equals(current.key, key)) {
                if (previous == null) {
                    entries[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    public Set<K> keys() {
        Set<K> keys = new HashSet<>();
        for (Entry<K, V> entry : entries) {
            while (entry != null) {
                keys.add(entry.key);
                entry = entry.next;
            }
        }
        return keys;
    }

    public Collection<V> values() {
        List<V> valueList = new ArrayList<>();
        for (Entry<K, V> entry : entries) {
            while (entry != null) {
                valueList.add(entry.value);
                entry = entry.next;
            }
        }
        return valueList;
    }

    public V put(K key, V value) {

        if (size >= entries.length) {
            Entry<K, V>[] oldEntries = entries;
            entries = new Entry[entries.length * 2];
            size = 0;

            for (Entry<K, V> entry : oldEntries) {
                while (entry != null) {
                    put(entry.key, entry.value);
                    entry = entry.next;
                }
            }
        }

        int hashCode = Objects.hashCode(key);

        int index = hashCode % entries.length;

        Entry<K, V> oldEntry = entries[index];

        if (oldEntry == null) {
            entries[index] = new Entry<>(key, value);
            size++;
            return value;
        }

        if (oldEntry.key.equals(key)) {
            V oldValue = oldEntry.value;
            oldEntry.value = value;
            return oldValue;
        }

        Entry<K, V> currentEntry = oldEntry;

        while (currentEntry.next != null) {
            currentEntry = currentEntry.next;
            if (Objects.equals(currentEntry.key, key)) {
                V oldValue = currentEntry.value;
                currentEntry.value = value;
                return oldValue;
            }
        }

        currentEntry.next = new Entry<>(key, value);
        size++;
        return value;
    }

    public V get(K key) {
        int hashCode = Objects.hashCode(key);
        int index = hashCode % entries.length;

        Entry<K, V> entry = entries[index];
        if (Objects.isNull(entry))
            return null;

        if (Objects.equals(key, entry.key))
            return entry.value;

        if (Objects.isNull(entry.next))
            return null;

        Entry<K, V> current = entry.next;

        while (Objects.nonNull(current) && !Objects.equals(current.key, key)) {
            current = current.next;
        }

        if (Objects.isNull(current))
            return null;

        return current.value;
    }

    @Override
    public String toString() {

        StringJoiner stringJoiner = new StringJoiner(",", "{", "}");

        for (Entry<K, V> entry : entries) {
            if (Objects.nonNull(entry)) {
                stringJoiner.add(entry.toString());

                Entry<K, V> currentEntry = entry.next;

                while (currentEntry != null) {
                    stringJoiner.add(currentEntry.toString());
                    currentEntry = currentEntry.next;
                }
            }
        }

        return stringJoiner.toString();
    }

    public static void main(String[] args) {
        /*SimpleDictionary<Integer, String> intMap = new SimpleDictionary<>();

        intMap.put(1, "Mushuk");
        intMap.put(2, "It");
        intMap.put(3, "Ot");
        intMap.put(13, "Kit");
        intMap.put(33, "Sigir");
        intMap.put(43, "Qo'y");*/
//        System.out.println("intMap.put(43, \"Echki\") = " + intMap.put(43, "Echki"));
//
//        System.out.println("intMap = " + intMap);
//        System.out.println("intMap.size = " + intMap.size);
//
//        String s = intMap.get(2);
//        System.out.println("s = " + s);
//
//        String s1 = intMap.get(43);
//        System.out.println("s1 = " + s1);

//        String str1 = "Aa";//65,97 -
//        String str2 = "BB";
//
//        System.out.println("Hash code of 'Aa': " + str1.hashCode());
//        System.out.println("Hash code of 'BB': " + str2.hashCode());


        /*SimpleDictionary<Student, String> studentMap = new SimpleDictionary<>();
        studentMap.put(new Student("Ali"), "1");
        studentMap.put(new Student("VAli"), "2");
        studentMap.put(new Student("Salim"), "3");
        studentMap.put(new Student("Halim"), "4");
        studentMap.put(new Student("Halim"), "5");

        System.out.println(studentMap);*/

        SimpleDictionary<Integer, String> dictionary = new SimpleDictionary<>(3);
        dictionary.put(1, "Brazil");
        dictionary.put(2, "France");
        dictionary.put(3, "Italy");
        dictionary.put(4, "Uzb");
        dictionary.put(13, "Hungary");
        System.out.println("dictionary = " + dictionary);

        System.out.println("dictionary.remove(3) = " + dictionary.remove(3));
        System.out.println("dictionary = " + dictionary);

        Set<Integer> keys = dictionary.keys();
        System.out.println("keys = " + keys);

        Student ali = Student.getInstance("Ali");

    }

    public static class Student implements Cloneable, Comparable<Student> {
        private final String name;

        private Student(String name) {
            this.name = name;
        }

        public static Student getInstance(String name) {
            return new Student(name);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return Objects.equals(name, student.name);
        }

        @Override
        public int hashCode() {
            return 0;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    '}';
        }

        @Override
        public Student clone() {
            try {
                return (Student) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }

        @Override
        public int compareTo(Student o) {
            return this.name.compareTo(o.name);
        }
    }
}

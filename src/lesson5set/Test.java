package lesson5set;

import java.io.Serializable;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.Vector;
import java.util.function.Function;

/**
 * Created by: Mehrojbek
 * DateTime: 14/08/24 19:11
 **/
public class Test {

    public static void main(String[] args) {


        Comparator<User> userComparator = Comparator.comparing(User::getAge).reversed();
        userComparator = userComparator.thenComparing(User::getFirstName);

        TreeSet<User> users = new TreeSet<>(userComparator);
        users.add(new User("Akmal",21));
        users.add(new User("Said",23));
        users.add(new User("Olim",17));
        users.add(new User("Ali",17));
        users.add(new User("Abror",15));

        Vector<Integer> integers = new Vector<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        Integer value = integers.get(2);
        System.out.println(value);

//        System.out.println(users);

    }



    public static class User
//            implements Comparable<User>
    {
        private String firstName;
        private int age;

        public User(String firstName, int age) {
            this.firstName = firstName;
            this.age = age;
        }

        public String getFirstName() {
            return firstName;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "firstName='" + firstName + '\'' +
                    ", age=" + age +
                    '}';
        }

//        @Override
//        public int compareTo(User user) {
//            return this.getFirstName().compareTo(user.getFirstName());
//        }
    }

}

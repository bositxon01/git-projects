package lesson6queue;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * Created by: Mehrojbek
 * DateTime: 14/08/24 21:01
 **/
public class PriorityQueueTest {

    public static void main(String[] args) {

        //enqueue()
        //dequeue()
        //isEmpty()
        //isFull()
        //peek()



//        ArrayDeque arrayDeque = new ArrayDeque()

        //for(User user: users){

        // }

    }

    private static void priorityQueue() {
        //        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//        priorityQueue.add(2);
//        priorityQueue.add(3);
//        priorityQueue.add(4);
//        priorityQueue.add(1);
//
//        System.out.println("priorityQueue = " + priorityQueue);
//        Integer element1 = priorityQueue.poll();
//        System.out.println("element1 = " + element1);
//        System.out.println("priorityQueue = " + priorityQueue);

        Comparator<Student> studentComparator = Comparator.comparing(student -> student.getName());
        PriorityQueue<Student> students = new PriorityQueue<>(studentComparator);
        students.add(new Student("VAli", 24));
        students.add(new Student("Sobir", 34));
        students.add(new Student("Ali", 22));
        students.add(new Student("Said", 19));

        System.out.println("students = " + students);
//        System.out.println("=======");
//        Student student = students.poll();
//        System.out.println("student = " + student);
//        System.out.println("=======");
//        System.out.println("students = " + students);
//        Student student1 = students.poll();
//        System.out.println("student1 = " + student1);
//        Student student2 = students.poll();
        Student student = students.peek();
        System.out.println("student1 = " + student);
        System.out.println("students = " + students);
    }


    public static class Student {
        private String name;
        private int course;

        public Student(String name, int course) {
            this.name = name;
            this.course = course;
        }

        public String getName() {
            return name;
        }

        public int getCourse() {
            return course;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setCourse(int course) {
            this.course = course;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", course=" + course +
                    '}';
        }
    }

}

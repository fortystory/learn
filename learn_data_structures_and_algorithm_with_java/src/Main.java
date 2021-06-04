
import java.util.Random;

import data_structures.queue.LinkedListQueue;
import data_structures.queue.LoopQueue;
import data_structures.queue.Queue;
import data_structures.stack.ArrayStack;

public class Main {
    public static void main(String[] args) {

        // Array<Student> arra = new Array<>(6);
        // arra.addLast(new Student("Alice1",200));
        // arra.addLast(new Student("Alice2",200));
        // arra.addLast(new Student("Alice3",200));
        // arra.addLast(new Student("Alice4",200));
        // arra.addLast(new Student("Alice5",200));
        // arra.addLast(new Student("Alice6",200));
        // System.out.println(arra);
        // arra.removeLast();
        // System.out.println(arra);


        // ArrayStack<Integer> arrayStack = new ArrayStack<>();
        // System.out.println(arrayStack.isEmpty());

        // arrayStack.push(2);
        // arrayStack.push(3);
        // arrayStack.push(3);
        // arrayStack.push(4);
        
        // int four = arrayStack.pop();

        // System.out.println(arrayStack);
        // System.out.println(arrayStack.isEmpty());
        // System.out.println(four);

        // String kh = "()";

        // boolean res = isValid(kh);

        // System.out.println(res);



        // ArrayQueue<Integer> queue = new ArrayQueue<>(20);
        
        // for (int i = 0; i < 10; i++) {
        //     queue.enqueue(i);
        //     System.out.println(queue.toString());
        //     if(i % 3 == 2){
        //         queue.dequeue();
        //         System.out.println(queue.toString());
        //     }
        // }
        int opCount = 100000;
        // Queue<Integer> array_queue = new ArrayQueue<>();
        Queue<Integer> loop_queue = new LoopQueue<>();
        Queue<Integer> linkedlist_queue = new LinkedListQueue<>();

        // double time1 = testQueue(array_queue, opCount);
        // System.out.println("ArrayQueue time     :" + time1 + "s");
        double time2 = testQueue(loop_queue, opCount);
        System.out.println("LoopQueue time      :" + time2 + "s");
        double time3 = testQueue(linkedlist_queue, opCount);
        System.out.println("LinkedlistQueue time:" + time3 + "s");



        // LinkedList<Integer> ll = new LinkedList<>();
        // for (int i = 0; i < 5; i++) {
        //     ll.addFirst(i);
        //     System.out.println(ll.toString());
        // }
        
        // ll.add(2,222);
        // System.out.println(ll.toString());
        // ll.remove(2);
        // System.out.println(ll.toString());
        // ll.removeFirst();
        // System.out.println(ll.toString());
        // ll.removeLast();
        // System.out.println(ll.toString());
        
        
        // Stack<Integer> ls = new LinkedListStack<>();
        // Stack<Integer> as = new ArrayStack<>();
        // int opCount = 100000;
        // // int opCount = 10000000;
        // double t1 = testStack(ls, opCount);
        // System.out.println("linkedliststack time:" + t1);
        // double t2 = testStack(as, opCount);
        // System.out.println("arraystack time     :" + t2);
    }

    public static boolean isValid(String s){
        if(s.length() % 2 != 0){
            return false;
        }
        ArrayStack<Character> stack = new ArrayStack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(c == '(' || c =='[' || c == '{'){
                stack.push(c);
            }else{
                if(c != ')' && c !=']' && c != '}'){
                    continue;
                }
                
                if(stack.isEmpty()){
                    return false;
                }

                char top = stack.pop();
                switch (c) {
                    case ')':
                        if(top != '('){
                            return false;
                        }
                        break;
                    case ']':
                        if (top != '[') {
                            return false;
                        }
                        break;
                    case '}':
                        if (top != '{') {
                            return false;
                        }
                        break;
                    default:
                        return false;
                }
            }
        }

        return stack.isEmpty();
    }

    /**
     * 测试队列性能方法
     * @param q
     * @param opCount
     * @return
     */
    private static double testQueue(Queue<Integer> q,int opCount) {
        Random random = new Random();
        long startTime = System.nanoTime();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));//获取随机数字
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    // private static double testStack(Stack<Integer> s,int opCount){
    //     Random random = new Random();
    //     long startTime = System.nanoTime();
    //     for (int i = 0; i < opCount; i++) {
    //         s.push(random.nextInt(Integer.MAX_VALUE));// 获取随机数字
    //     }
    //     for (int i = 0; i < opCount; i++) {
    //         s.pop();
    //     }
    //     long endTime = System.nanoTime();

    //     return (endTime - startTime) / 1000000000.0;
    // }
}

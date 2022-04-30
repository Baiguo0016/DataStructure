package leetcode.problem;
//import java.util.ArrayList;
import java.util.Stack;

public class NewStack {
    class CustomStack{

        Stack<Integer> stack;
        int[] increment;
        int sum;
        int size;

        public CustomStack(int maxsize) {
            this.size = maxsize;
            this.increment = new int[maxsize];
            this.stack = new Stack<>();
        }

        public void push(int x) {
            if (stack.size() < size) {
                stack.push(x);
            }
        }

        public int pop(){

            int result = -1;
            int currentSize = stack.size();

            if (currentSize <= 0) {
                return result;
            } else if (currentSize > 1) {
                increment[currentSize - 2] += increment[currentSize - 1];
            }

            if (currentSize > 0) {
                result = stack.pop() + increment[currentSize - 1];
                increment[currentSize - 1] = 0;
            }

            return result;
        }


        public void increment(int k, int val){
            int incrementK = (k > stack.size() ? stack.size() :k) - 1;
            if (incrementK >= 0) {
                increment[incrementK] += val;
                // sum += incrementK * val;
            }
        }

        public boolean empty() {
            return stack.empty();
        }

        public int peek(){
            int result = stack.peek();
            if (size <= 0) {
                return -1;
            } else {
                increment[size - 1] += increment[size];
            }

            result += increment[size - 1];
            increment[size - 1] = 0;

            return result;
        }

        public int sum(){
            return sum;
        }
    }
}

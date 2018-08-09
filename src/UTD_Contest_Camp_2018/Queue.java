package UTD_Contest_Camp_2018;

import java.util.*;
import java.io.*;

public class Queue {
    Stack stack1, stack2;
    int size;

    public Queue(int size){
        this.size = 0;
        stack1 = new Stack(size);
        stack2 = new Stack(size);
    }

    public void enqueue(int i){
        stack1.push(i);
        stack2 = stack1.rev();
    }

    public int dequeue(){
        int output = stack1.pop();
        stack2 = stack1.rev();
        return output;
    }


    public class Stack {
        int top;
        int[] stack;
        int size;

        public Stack(int size){
            stack = new int[size];
            top = -1;
            this.size = 0;
        }

        public void push(int i){
            if (size + 1 < stack.length){
                size++;
                top++;
                stack[top] = i;
            }
        }

        public int pop(){
            if (size > 0){
                top--;
                return stack[top+1];
            }

            return Integer.MAX_VALUE;
        }

        public Stack rev(){
            Stack output = new Stack(stack.length);
            for (int i = top; i > -1; i--){
                output.stack[i] = stack[i];
            }
            output.top = top;
            output.size = size;

            return output;
        }
    }
}

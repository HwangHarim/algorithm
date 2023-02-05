package stack;

import java.util.EmptyStackException;
import java.util.Scanner;

public class stack {
    private int max;
    private int ptr; // stack의 pointer
    private int[] stk;

    public static class EmptyIntStackException extends RuntimeException {
      public EmptyIntStackException(){};
    }

    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {};
    }

    public stack(int capacity){
        ptr =0;
        max = capacity;
        try{
            stk = new int[max];
        }catch (OutOfMemoryError e){
            max =0;
        }
    }

    public int push(int x) throws OverflowIntStackException{
        if(ptr>=max){
            throw new OverflowIntStackException();
        }
        return stk[ptr++] = x;
    }

    public int pop() throws EmptyStackException {
        if(ptr <= 0){
            throw new EmptyStackException();
        }
        return stk[--ptr];
    }

    public int peek() throws EmptyStackException{
        if(ptr <= 0){
            throw new EmptyStackException();
        }
        return stk[ptr-1];
    }

    public int indexOf(int x){
        for(int i =ptr; 0<i; i--){
            if(stk[i] == x){
                return i;
            }
        }
        return -1;
    }

    public void clear(){
        ptr = 0;
    }

    public int capacity(){
        return max;
    }

    public int size() {
      return ptr;
    }

    public boolean isEmpty(){
        return ptr<=0;
    }

    public boolean isFull(){
        return ptr>=max;
    }

    public void dump(){
        if(ptr<=0){
            System.out.println("스텍이 비어있습니다");
        }
        else{
            for(int i=0; i<ptr; i++){
                System.out.print(stk[i] +" ");
                System.out.println();
            }
        }
    }
}

class IntStackTester{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        stack s = new stack(64);
        while (true){
            System.out.println("현재 데이터 수 " + s.size() +" / "+ s.capacity());

            System.out.print("1.푸시 2.팝 3.피크 4.덤프 0.종료");

            int menu = sc.nextInt();
            if(menu == 0) break;
            int x;
            switch (menu) {
              case 1 :
                  System.out.println("데이터를 입력하세요");
                  x = sc.nextInt();
                  try{
                      s.push(x);
                  }catch (stack.OverflowIntStackException e) {
                      System.out.println("스텍이 가득 참");
                  }
                  break;
                case 2 :
                    try{
                        s.pop();
                    }catch (stack.EmptyIntStackException e) {
                        System.out.println("스텍이 비어 있습니다.");
                    }
                    break;
                case 3 :
                    try {
                      x= s.peek();
                        System.out.println("피크한 데이터는 " +x+" 입니다. ");
                    }catch (stack.EmptyIntStackException e) {
                        System.out.println("스텍이 비어 있습니다.");
                    }
                    break;
                case 4 :
                    s.dump();
                    break;
            }
        }
    }

}

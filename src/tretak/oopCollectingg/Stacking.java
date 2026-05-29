package tretak.oopCollectingg;

import java.util.EmptyStackException;

public class Stacking { //stack = kolekce, LIFO (last to go in is first to go out)
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push(8);
        stack.push(9);
        stack.push(7);
        stack.pop();
        stack.push(8);
        stack.pop();
    }
}

class ArrayStack {  //reprezentuje vlastní kolekci
    int[] data;
    int freeIndex;


    void expandArray(){
        int[] newOne = new int[data.length*2];
        for (int i = 0; i < data.length; i++) {
            newOne[i] = data[i];
        }
        data = newOne;
    }


    ArrayStack(int capacity){
        data = new int[capacity];
        freeIndex = 0;
    }

    void push(int toAdd){
        if (freeIndex < data.length){
            data[freeIndex] = toAdd;
            freeIndex++;
        } else {
            System.out.println("Out of capacity");
        }
    }

    int pop(){
        if (freeIndex > 0){
            int toReturn = data[freeIndex-1];
            freeIndex--;
            return freeIndex;
            //return data[freeIndex--];
        }
        return 0;
    }

    int peek(){
        if (freeIndex > 0){
            return data[freeIndex-1];
        }
        return -1;
    }
}

class Link{
    int data;
    Link next;  //kdo je další
}

class LinkStack{
    Link top;   //pamatuju si jenom vrchol zásobníku, jedu dokud mam next

    LinkStack(){
        top = null;
    }

    void push(int toAdd){
        //prvni prvek:
        if (top == null){
            top = new Link();
            top.data = toAdd;
        } //už tam něco je:
        else {
            Link newTop = new Link();
            newTop.data = toAdd;
            newTop.next = top;  //stary vrchol bude hned za novym
            top = newTop;   //prohlasim za novy vrchol zasobniku
        }
    }

    int pop(){
        if (top == null){
            //idealne hodit chybu
            throw new EmptyStackException();
        }
        int toReturn = top.data;
        top = top.next; //to, co bylo pod topem je nyni top, nemusi tam byt nic
        return toReturn;
    }

    int peek(){
        return top.data;
    }
}

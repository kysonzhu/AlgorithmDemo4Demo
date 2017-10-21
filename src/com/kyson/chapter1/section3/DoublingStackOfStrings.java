package com.kyson.chapter1.section3;

import java.util.Iterator;


import edu.princeton.cs.algs4.StdIn;

/***
 * 
 * 
 * 1.3.8 给定以下输入，给出DoublingStackOfStrings的数组的内容和大小。
 * it was - the best - of times - - - it was - the - -
 * 1.3.8 Give the contents and size of the array for DoublingStackOfStrings with the input
 * it was - the best - of times - - - it was - the - -
 *
 */
public class DoublingStackOfStrings<Item> implements Iterable<Item>{
	
	private int N;
	private Item[] items = (Item[])(new Object[1]);
	
	public void push(Item item)
	{
		if (items.length == N) resize(N * 2);
		items[N++] = item;
	}
	
	public Item pop()
	{
		
		Item item = items[--N];
		items[N] = null; 
        if (N > 0 && N == items.length / 4) resize(N * 2);  
		return item;
	}
	
	private void resize(int max)
	{
		Item[] items2 = (Item[])(new Object[max]);
		for (int i = 0; i < N; i++) {
			items2[i] = items[i];
		}
		items = items2;
	}
	
	public int arraySize()
	{
		return items.length;
	}
	
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ArrayIterator();
	}
	
	private class ArrayIterator implements Iterator<Item>{

		
		private int i = N;
		public boolean hasNext(){
			return i > 0;
		}
		
		public Item next(){
			return items[--i];
		}

	}	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        DoublingStackOfStrings<String> stack = new DoublingStackOfStrings<String>();  
        String[] inputs = StdIn.readAllStrings();  
        for (int i = 0; i < inputs.length; i++)  
        {  
            if (inputs[i].equals("-"))  
            {  
                stack.pop();  
            }  
            else  
            {  
                stack.push(inputs[i]);  
            }  
            
        }  
		
        for (String s : stack)  
        {  
            System.out.print(s + " ");  
        }  
        System.out.println();  
        System.out.println("ArraySize: " + stack.arraySize());  
        System.out.println();  
		
	}


	

	
	
}

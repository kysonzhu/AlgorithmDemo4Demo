package com.kyson;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;

public class Rank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] whitelist = In.readInts(args[0]);
		for(int i = 0; i < whitelist.length ; i++){
			System.out.println("i:  " + whitelist[i]);
		}
		Arrays.sort(whitelist);
		for(int i = 0; i < whitelist.length ; i++){
			System.out.println("j:  " + whitelist[i]);
		}

	}

}

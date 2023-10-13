package edu.ics211.h13;


import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class HashTable211<K, V> implements HashInterface<K, V> {
	private LinkedList[] table;
	private int keyCollisions;
	private int size;

	public HashTable211(int size) {
		table = new LinkedList[size];
		for (int i = 0; i < size; i++) {
			table[i] = new LinkedList<HashKeyValue>();
		}
		keyCollisions = 0;
		this.size = size;
	}

	private int getTableIndex(K key) {
		int tableIndex = key.hashCode() % size;
		if (tableIndex < 0) {
			tableIndex += size;
		}
		return tableIndex;
	}


	public void add(K key, V value) {


		int tableIndex = getTableIndex(key);
		if(table[tableIndex].size() > 0) {
			 V oldValue = find(key);
			 if(oldValue != null) {
				  System.out.println("Replacing value for " + key +
		                    ". Old value: " + oldValue + ", New value: " + value);
			 }
			 keyCollisions++;
		}
		table[tableIndex].addFirst(new HashKeyValue<K, V>(key, value));

	}

	public V find(K key) {

		int tableIndex = getTableIndex(key);
	    LinkedList<HashKeyValue<K, V>> linkedList = table[tableIndex];
		ListIterator<HashKeyValue<K, V>> iterator =linkedList.listIterator();
		while(iterator.hasNext()) {
			HashKeyValue head = (HashKeyValue) iterator.next();
			if(head.getKey() == key) {
				return (V) head.getValue();
				
			}
		}
		
		return null;
	}

	public int getKeyCollisions() {
		return keyCollisions;
	}
	public int getLongestList() {
		int longest = table[0].size();
		for (int i = 1; i < size; i++) {
			if (table[i].size() > longest) {
				longest = table[i].size();
			}
		}
		return longest;
	}
	public int getNumberEmptyLists() {
		int numEmptyLists = 0;
		for(LinkedList<HashKeyValue<K,V>> list : table) {
			if(list.isEmpty()) {
				numEmptyLists++;
			}
		}
		return numEmptyLists;
	}

	public String toString() {
		String temp = "";
		for (int i = 0; i < size; i++) {
			temp += "table[" + i + "] : " + table[i] + "\n";
		}
		return temp;
	}


	public static void main(String[] args) {
		HashTable211<String, Integer> table = new HashTable211<String, Integer>(500);
		File f = new File("words.txt");
		Random rand = new Random();
		Scanner infile = null;
		try {
			infile = new Scanner(f);
		}
		catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		int count = 0;
		ArrayList<String> words = new ArrayList<String>();
		while (infile.hasNext()) {
			String key = infile.next().trim();
			if (!key.equals("")) {
				words.add(key);
			}
		}for (int i = 0; i < 500; i++) {
			String key = words.get(rand.nextInt(0, words.size()));
			Integer value = rand.nextInt(0,101);
			table.add(key, value);
		}
		//System.out.print(table);
		System.out.println("Number of collisions is " + table.getKeyCollisions());
		Integer value = table.find("united");
		if (value != null) {
			System.out.println("Value for \"united\" is " + value);
		}
		else {
			System.out.println("The key \"united\" was not found");
		}
		value = table.find("states");
		if (value != null) {
			System.out.println("Value for \"states\" is " + value);
		}
		else {
			System.out.println("The key \"states\" was not found");
		}
		System.out.println("The longest link length is " + table.getLongestList());
		System.out.println("The number of empty lists is " + table.getNumberEmptyLists());

	}
}
package edu.pitt.cmpinf401.lab8;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class ScoreList 
{
/* The node class represents a single list element with a data item and reference to the next node in the list */
	private class Node 
	{
		// data held by this node
		StudentScore data;
		// reference to the next node in the list, or null if there is no such node
		// (i.e. this is the last node in the list)
		Node next;
		/**
		* Creates a node with the given data
		* @param dataValue data to hold in this node
		*/
		public Node(StudentScore dataValue) 
		{
			next = null;
			data = dataValue;
		}
	} //end class Node
	
	private Node head;
	
	/**
	* Initializes a linked list with a single "dummy" node (contains no real data)
	* to simplify code for the case of an empty list
	*/
		
	public ScoreList() 
	{
		head = new Node(null);
	}
	
	
	/**
	* Finds the index of the record with the given name in the
	list
	* @param name name to search for
	* @return index of name in list if found, -1 otherwise
	*/
	
	public int indexOf(String name) 
	{
		Node currentNode = head;
		int index = 0;
		// traverse through the list looking for our target node
		while (currentNode.next != null &&	!currentNode.next.data.getName().equals(name)) 
		{
			currentNode = currentNode.next;
			index++;
		}
	
		//we got to the end of the list without finding our target
		
		if (currentNode.next == null) 
			return -1;
		else return index;
	}
		
	/**
	* Adds the given item to the list, sorted by score (highest to
	lowest)
	* @param data data to add
	* @return the index the data was inserted at
	*/
	public int add(StudentScore data) 
	{
    int index = 0;
    Node node = head; 

	  while (node.next != null && node.data.getScore() > data.getScore()) {
      node = node.next;
      index++;
    }

    Node newNode = new Node(data);
    if (node.next != null)
      newNode.next = node.next;
		return index;
	}
	
	/**
	* Prints out each record in the list, one per line
	*/
	public void print() 
	{
		//note that we start from our first *real* node in this case (head.next, not our dummy head)
		Node currentNode = head.next;
		while (currentNode != null) 
		{
			System.out.println(currentNode.data.getName() + ", " + currentNode.data.getScore());
			currentNode = currentNode.next;
		}
		System.out.println();
	}
	
	/**
	* Write out the contents of the linked list to the given
	file, one entry per line
	* @param filename name of the file to write the list to
	*/
	
	public void writeToFile(String filename) 
	{
		//TODO
	}
}

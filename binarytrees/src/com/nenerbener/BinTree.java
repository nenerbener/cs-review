package com.nenerbener;

import java.util.ArrayList;
import java.util.List;

class BNode {

	public BNode leftBNode, rightBNode; // the nodes
	public AnyClass anyClass; // the AnyClass objext

	public BNode(AnyClass anyClass) {// constructor
		this.anyClass = anyClass;
		this.leftBNode = null;
		this.rightBNode = null;
	}

	public void show() {
		// calls the show method of the AnyClass
		System.out.print(anyClass.show());

	}
}

class AnyClass {
	String surname;
	AnyClass(String str) {
		surname = str;
	}

	String show() {
		return surname;
	}
}

public class BinTree {
    BNode theBTRootNode;

    public BinTree() // constructor
    {
        theBTRootNode = null;
    }

    // ------------------ Addition of the node to the BST-------------------
    protected BNode insertAB(BNode theRootNode, BNode myNewNode) {
        if (theRootNode == null) {
            theRootNode = myNewNode;
            //checks if the username is smaller than 
            //the root object, if smaller appends to the left
        } else if (myNewNode.anyClass.surname.compareTo(
                          theRootNode.anyClass.surname) < 0) {
            theRootNode.leftBNode = insertAB(theRootNode.leftBNode,myNewNode);
        } else {
            // else if bigger appends to the right
            theRootNode.rightBNode = 
               insertAB(theRootNode.rightBNode, myNewNode);
        }
        return theRootNode;
    }

    public void insertBST(AnyClass anyClass) {
        BNode anyClassBTNode = new BNode(anyClass);
        //calls insert above
        theBTRootNode = insertAB(theBTRootNode, anyClassBTNode);
    }

    // ------------------ InOrder traversal-------------------
    protected void inorder(BNode theRootNode) {
        if (theRootNode != null) {
            inorder(theRootNode.leftBNode);
            theRootNode.show();
            inorder(theRootNode.rightBNode);
        }
    }

    //calls the method to do in order
    public void inorderBST() {
        inorder(theBTRootNode);
    }

    // ----- Search for key name and  returns ref. 
    //              to BNode or null if not found--------
    protected BNode search(BNode theRootNode, String keyName) {
        //if the root is null returns null
        if (theRootNode == null) {
            return null;
        } else {
            //checks if they are equal
            if (keyName.compareTo(theRootNode.anyClass.surname) == 0) {
                return theRootNode;
            //checks id the key is smaller than the current
            //record  if smaller traverses to the left
            } else if (keyName.compareTo(theRootNode.anyClass.surname) < 0) {
                return search(theRootNode.leftBNode, keyName);
            } else {
                // if bigger traverses to the left
                return search(theRootNode.rightBNode, keyName);
            }
        }
    }

    //returns null if no result else returns 
    //the AnyClass object matched with the keyName
    public AnyClass searchBST(String keyName) {
        BNode temp = search(theBTRootNode, keyName);
        if (temp == null) {
      //noresults found
           return null;
        } else {
         //result found
           return temp.anyClass;
        }
    }
    
    //test driver
    public static void main(String[] args) {
    	List<AnyClass> listOfNames = new ArrayList<>();
    	listOfNames.add(new AnyClass("b"));
    	listOfNames.add(new AnyClass("c"));
    	listOfNames.add(new AnyClass("d"));
    	listOfNames.add(new AnyClass("e"));
    	listOfNames.add(new AnyClass("f"));
    	listOfNames.add(new AnyClass("g"));
    	listOfNames.add(new AnyClass("h"));
    	listOfNames.add(new AnyClass("i"));
    	listOfNames.add(new AnyClass("j"));
    	listOfNames.add(new AnyClass("a"));
    	BinTree bt = new BinTree();
    	
    	for (AnyClass ac:listOfNames) {
    		bt.insertBST(ac);
    	}
    	bt.inorderBST();
    }
}
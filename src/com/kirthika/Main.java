package com.kirthika;

import java.util.*;

class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}

public class Main {

    static void levelOrder(Node root){
        //Write your code here
        Queue<Node> BFSQueue=new LinkedList<Node>();
        BFSQueue.add(root);

        while(!BFSQueue.isEmpty()){
            Node currentNode = BFSQueue.remove();
            System.out.printf(currentNode.data+" ");
            if(currentNode.left!=null){
                BFSQueue.add(currentNode.left);
            }
            if(currentNode.right!=null){
                BFSQueue.add(currentNode.right);
            }
        }
    }

    public static Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        else{
            Node cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
	// write your code here
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        Node root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=insert(root,data);
        }
        levelOrder(root);
    }
}

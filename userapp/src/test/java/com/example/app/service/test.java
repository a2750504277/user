package com.example.app.service;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class test {


    List<Integer> nodes=new ArrayList<Integer>();
    public List<Node> children;

    @Test
    public void test1(){
        Node root =new Node(3,children);
        postorder(root);
    }


    public List<Integer> postorder(Node root) {

        List<List<Integer>> nodes=new ArrayList<List<Integer>>();
        if(root==null){

        }
        LinkedList<Node> queue=new LinkedList<Node>();
        queue.poll();
        return  null;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}

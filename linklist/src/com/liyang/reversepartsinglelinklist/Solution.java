package com.liyang.reversepartsinglelinklist;

import com.liyang.printcommonpart.Node;

//给定一个单链表head和起止位置from和to，只将from到to这一段节点反转
public class Solution {
    public static Node reversePartSingleLinklist(Node head, int from, int to){
        int len = 0;
        Node node1 = head;
        Node pre = null;
        Node next = null;
        while (node1 != null){
            len++;
            if (len == from - 1){
                pre = node1;  //找到from前面那一个节点
            }
            if (len == to + 1){
                next = node1;  //找到to后面那一个节点
            }
            node1 = node1.next;
        }
        if (from < 1 || to > len || from > to){
            return head;  //参数不合格，直接返回头节点
        }
        //if ()
        return null;
    }
}

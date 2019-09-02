package com.liyang.reverselist;

import com.liyang.printcommonpart.Node;
import com.liyang.removelastkthnode.DoubleNode;

//将单链表和双链表逆序，要求时间复杂度为线性
public class Solution {
    public static Node reverseSingleLinkList(Node head){
        //头插法
        Node pre = null;
        Node next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static DoubleNode reverseDoubleLinkList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}

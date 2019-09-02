package com.liyang.removemidnode;

import com.liyang.printcommonpart.Node;

public class Solution {
    public static Node removeMidNode(Node head){
        //删除链表中间的节点，pre每次移动一个单位，cur移动两个单位
        if (head == null || head.next == null){
            return head;
        }
        if (head.next.next == null){
            return head.next;
        }
        Node pre = head;
        Node cur = head.next.next;
        while (cur.next != null && cur.next.next != null){
            //cur移动两个节点，pre移动一个节点
            pre = pre.next;
            cur = cur.next.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    public static Node removeByRatio(Node head, int a, int b){
        //删除位于a/b的结点
        if (a < 1 || a > b){
            return head;
        }
        int n = 0;
        Node cur = head;
        //先统计一下有多少个结点
        while (cur != null){
            n++;
            cur = cur.next;
        }
        n = (int)Math.ceil((double)(a * n) /(double) b);  //算出要删除第几个节点
        if (n == 1){
            head = head.next;
        }
        if (n > 1){
            cur = head;
            while (--n != 1){
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }
}

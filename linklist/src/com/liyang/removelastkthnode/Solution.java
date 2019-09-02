package com.liyang.removelastkthnode;

import com.liyang.printcommonpart.Node;

//删除不带头节点的单链表和双链表的倒数第K个节点
//1、从head开始，每过一个节点就将lastkth的值减一，如果最终lastKth等于0，说明head就是倒数第lastKth个节点
//如果lastKth的值大于0说明没有这样的节点，小于0就从head开始遍历加一，直到lastKth等于0时的节点就是需要删除
//的节点的前一个节点
public class Solution {
    public static Node removeLastKthNodeOfSingleLinklist(Node head, int lastKth){
        if (head == null || lastKth < 1){
            return head;
        }
        Node cur = head;
        //Node del = null;
        while (cur != null){
            lastKth--;
            cur = cur.next;
        }
        if (lastKth < 0){
            cur = head;
            while (++lastKth !=0){
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }else if (lastKth == 0){
            //说明头节点就是倒数第lastKth个节点
            //del = head;
            head = head.next;
        }
        return head;
    }

    public static DoubleNode removeLastKthNodeOfDoubleLinklist(DoubleNode head, int lastKth){
        if (head == null || lastKth < 1){
            return head;
        }
        DoubleNode cur = head;
        while (cur != null){
            lastKth--;
            cur = cur.next;
        }
        if (lastKth == 0){
            head = head.next;
        }else if (lastKth < 0){
            cur = head;
            while (++lastKth != 0){
                cur = cur.next;
            }
            cur.next = cur.next.next;
            if (cur.next != null){
                cur.next.last = cur;
            }
        }
        return head;
    }
}

package com.liyang.printcommonpart;

//给定两个有序链表的头指针head1和head2，打印两个链表的公共部分
//1、由于两个链表都是有序链表，那么head1和head2那个结点的值小哪个就往下移动
//2、如果两个指针的值相等就打印出来,并且将两个指针都往下移动
public class PrintCommonPart {
    public static void printCommonPart(Node head1, Node head2){
        while (head1 != null && head2 != null){
            if (head1.value < head2.value){
                head1 = head1.next;
            }else if (head2.value < head1.value){
                head2 = head2.next;
            }else {
                System.out.println(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }
}

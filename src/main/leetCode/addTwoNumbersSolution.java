package main.leetCode;

import java.util.ArrayList;
import java.util.List;

/*
* 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
* 并且它们的每个节点只能存储 一位 数字。
如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
示例：
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
* */
public class addTwoNumbersSolution {

    public  static void main(String[] args){
        ListNode nodeA1 = new ListNode(2);
        ListNode nodeA2 = new ListNode(4);
        ListNode nodeA3 = new ListNode(3);
        nodeA1.next = nodeA2;
        nodeA2.next = nodeA3;

        ListNode nodeB1 = new ListNode(5);
        ListNode nodeB2 = new ListNode(6);
        ListNode nodeB3 = new ListNode(4);
        nodeB1.next = nodeB2;
        nodeB2.next = nodeB3;

        ListNode result = addTwoNumbersSolution.addTwoNumbers(nodeA1,nodeB1);
        while (result != null){
            System.out.print(result.val);
            result=result.next;
        }
    }


    public  static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //1、将ListNode转化为Long
        int a = nodeToLong(l1);
        int b = nodeToLong(l2);

        //2、两数相加
        int sum = a+b;
        //3、和转换成ListNode
        return longToNode(sum);
    }

    public static int nodeToLong(ListNode node){
        int digit = 0;
        int result = 0;
        ListNode curNode = node;
        if(curNode != null){
            digit++;
            curNode = curNode.next;
        }
        curNode = node;
        for(int i=digit; i>=1; i++){
            if(curNode != null){
                result += curNode.val*(int)Math.pow(10,i-1);
                curNode = curNode.next;
            }else{
                break;
            }
        }
        return result;
    }

    public static ListNode longToNode(int param){
        List<Integer> list = new ArrayList<Integer>();
        int cur = param;
        while(cur >= 10){
            int temp = cur%10;
            cur = cur / 10;
            list.add(temp);
        }
        list.add(cur);
        ListNode head = new ListNode(list.get(0));
        ListNode curNode = head;
        int i = 1;
        while(i < list.size()){
            ListNode tempNode = new ListNode(list.get(i));
            curNode.next = tempNode;
            curNode = tempNode;
            i++;
        }
        return head;
    }
}

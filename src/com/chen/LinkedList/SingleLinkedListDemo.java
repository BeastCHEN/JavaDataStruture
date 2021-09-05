package com.chen.LinkedList;

import jdk.jfr.BooleanFlag;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Stack;
import java.util.function.IntFunction;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode hero5 = new HeroNode(5, "5", "5");
        HeroNode hero6 = new HeroNode(6, "6", "6");
        HeroNode hero7 = new HeroNode(7, "7", "7");
        HeroNode hero8 = new HeroNode(8, "8", "8");

        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        SingleLinkedList singleLinkedList3 = new SingleLinkedList();

        //singleLinkedList.add(hero1);
        //singleLinkedList.add(hero4);
        //singleLinkedList.add(hero2);
        //singleLinkedList.add(hero3);

        singleLinkedList1.addByOrder(hero1);
        singleLinkedList1.addByOrder(hero7);
        singleLinkedList1.addByOrder(hero8);
        singleLinkedList1.addByOrder(hero3);
        singleLinkedList2.addByOrder(hero4);
        singleLinkedList2.addByOrder(hero5);
        singleLinkedList2.addByOrder(hero6);
        singleLinkedList2.addByOrder(hero2);
        System.out.println("------原链表------");
        singleLinkedList1.list();
        singleLinkedList2.list();
        System.out.println("------合并链表------");
        merge(singleLinkedList1.getHead(), singleLinkedList2.getHead(), singleLinkedList3.getHead());
        singleLinkedList3.list();
        System.out.println("------链表排序------");
        order(singleLinkedList3.getHead());
        singleLinkedList3.list();
        System.out.println("------逆序打印------");
        reversePrint(singleLinkedList1.getHead());
        System.out.println("------反转链表------");
        reverseList(singleLinkedList1.getHead());
        singleLinkedList1.list();
        System.out.println("-------链表------");
        //singleLinkedList.addByOrder(hero3);
        singleLinkedList1.list();
        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~~");
        singleLinkedList1.update(newHeroNode);
        System.out.println("------修改后的链表------");
        singleLinkedList1.list();
        //singleLinkedList.del(1);
        singleLinkedList1.del(3);
        singleLinkedList1.del(2);
        //singleLinkedList.del(4);
        System.out.println("------删除后的链表------");
        singleLinkedList1.list();
        System.out.println("有效的节点个数" + getLength(singleLinkedList1.getHead()));
        HeroNode res = findLastInderNode(singleLinkedList1.getHead(), 1);
        System.out.println("res=" + res);
    }

    /**
     * 逆序打印
     */
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return;
        }
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    /**
     * 链表发转
     */
    public static void reverseList(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");
        while (cur != null) {
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }

    /**
     * 查找单链表中倒数第k个节点
     */
    public static HeroNode findLastInderNode(HeroNode head, int index) {
        if (head.next == null) {
            return null;
        }
        int size = getLength(head);
        if (index <= 0 || index > size) {
            return null;
        }
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 获取单链表节点个数
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    public static void merge(HeroNode head1, HeroNode head2, HeroNode head3) {
        if (head1.next == null && head2.next == null) {
            return;
        }
        if (head1.next == null) {
            head3.next = head2.next;
        } else if (head2.next == null) {
            head3.next = head1.next;
        } else {
            head3.next = head1.next;
            HeroNode cur2 = head2.next;
            HeroNode cur3 = head3.next;
            while (cur3.next != null) {
                cur3 = cur3.next;
            }
            cur3.next = cur2;
        }
    }

    /**
     * 1 定义一个辅助节点aux，永远指向链表头结点，即aux.next=head;
     * 2 定义当前节点cur和它的上一个节点pre，如果pre.next<=cur.next,那么pre节点和cur节点同时向后移动
     * 3 如果pre.next>cur.next，切断pre节点和cur节点的引用关系，pre.next=cur.next，把cur节点插入前面恰当位置
     * 4 定义节点 node1=aux和node2=aux.next，同时向后移动node1和node2，当出现cur.val<node2.val时，把cur插入node1和node2之间
     * 5 cur节点变为pre.next
     */

    public static void order(HeroNode head) {
        if (head == null || head.next == null) {
            return;
        }
        HeroNode pre = head;
        HeroNode cur = head.next;
        HeroNode aux = new HeroNode(0, "", "");
        aux.next = head;
        while (cur != null) {
            if (cur.no < pre.no) {
                pre.next = cur.next;
                HeroNode heroNode1 = aux;
                HeroNode heroNode2 = aux.next;
                while (cur.no > heroNode2.no) {
                    heroNode1 = heroNode2;
                    heroNode2 = heroNode2.next;
                }
                heroNode1.next = cur;
                cur.next = heroNode2;
                cur = pre.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
    }
}

class SingleLinkedList {
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }


    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("准备插入的英雄的编号 %d 已存在，不能加入\n", heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    public void update(HeroNode newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.printf("没有找到编号 %d 的节点，不能修改\n", newHeroNode.no);
        }
    }

    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }
    }

    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickename) {
        this.no = no;
        this.name = name;
        this.nickname = nickename;
    }

    @Override
    public String toString() {
        return "HeroNode[no=" + no + ",name=" + name + ",nickname=" + nickname + "]";
    }
}
//
// 请你设计并实现一个满足 
// LRU (最近最少使用) 缓存 约束的数据结构。
// 
//
// 
// 实现 
// LRUCache 类：
// 
//
// 
// 
// 
// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 
//key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。 
// 
// 
// 
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 10⁵ 
// 最多调用 2 * 10⁵ 次 get 和 put 
// 
//
// Related Topics 设计 哈希表 链表 双向链表 👍 3054 👎 0

package com.leetcode.leetcode.editor.cn;

import java.util.HashMap;

public class LruCache {


    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {

        class DoubleNode {
            public int key;
            public int val;

            public DoubleNode last;
            public DoubleNode next;

            public DoubleNode(int k, int v) {
                key = k;
                val = v;
            }
        }

        class DoubleList {
            private DoubleNode head;
            private DoubleNode tail;

            public DoubleList() {
                head = null;
                tail = null;
            }

            // 添加新节点
            private void addNode(DoubleNode newNode) {
                // 判空
                if (newNode == null) {
                    return;
                }
                // 如果头为空说明链表为空，新节点既是链表的头，也是链表的尾
                if (head == null) {
                    head = newNode;
                    tail = newNode;
                } else { // 否则加入到尾部，新节点成为新的尾部
                    tail.next = newNode;
                    newNode.last = tail;
                    tail = newNode;
                }
            }

            // 将节点移动到尾部
            public void moveNodeToTail(DoubleNode node) {
                // 如果已经在尾部
                if (tail == node) {
                    return;
                }

                // 如果node在头部，将头部节点删除，node的下一个节点成为新头部
                if (head == node) {
                    head = node.next;
                    head.last = null;
                } else { // 如果node不在头部，则把node前后两个节点连起来
                    node.last.next = node.next;
                    node.next.last = node.last;
                }

                // 将node接到tail的后面，node成为新的tail
                node.last = tail;
                node.next = null;
                tail.next = node;
                tail = node;
            }

            // 删除头部节点
            public DoubleNode removeHead() {
                // 判空
                if (head == null) {
                    return null;
                }

                // 将头部节点删除
                DoubleNode ans = head;
                // 如果只有一个节点
                if (head == tail) {
                    head = null;
                    tail = null;
                } else { // head的下一个节点成为新头部
                    head = ans.next;
                    ans.next = null;
                    head.last = null;
                }
                return ans;
            }
        }

        private HashMap<Integer, DoubleNode> keyNodeMap;

        private DoubleList nodeList;

        private final int cap;

        public LRUCache(int capacity) {
            keyNodeMap = new HashMap<>();
            nodeList = new DoubleList();
            cap = capacity;
        }

        public int get(int key) {
            // 查找key对应的节点
            // 如果有则返回该key对应的节点的val，并把它放到链表的尾部
            if (keyNodeMap.containsKey(key)) {
                DoubleNode ans = keyNodeMap.get(key);
                nodeList.moveNodeToTail(ans);
                return ans.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            // 判断哈希表里是否已有该节点
            // 如果有，则更新该节点的val，并把它放到链表的尾部
            if (keyNodeMap.containsKey(key)) {
                DoubleNode node = keyNodeMap.get(key);
                node.val = value;
                nodeList.moveNodeToTail(node);
            } else {
                // 如果是新节点，则先检查链表是否已满
                // 如果已满，则删除头节点
                if (keyNodeMap.size() == cap) {
                    keyNodeMap.remove(nodeList.removeHead().key);
                }
                // 将节点插入到链表中
                DoubleNode newNode = new DoubleNode(key, value);
                keyNodeMap.put(key, newNode);
                nodeList.addNode(newNode);
            }
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
}
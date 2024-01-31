//请你设计一个用于存储字符串计数的数据结构，并能够返回计数最小和最大的字符串。 
//
// 实现 AllOne 类： 
//
// 
// AllOne() 初始化数据结构的对象。 
// inc(String key) 字符串 key 的计数增加 1 。如果数据结构中尚不存在 key ，那么插入计数为 1 的 key 。 
// dec(String key) 字符串 key 的计数减少 1 。如果 key 的计数在减少后为 0 ，那么需要将这个 key 从数据结构中删除。测试用例
//保证：在减少计数前，key 存在于数据结构中。 
// getMaxKey() 返回任意一个计数最大的字符串。如果没有元素存在，返回一个空字符串 "" 。 
// getMinKey() 返回任意一个计数最小的字符串。如果没有元素存在，返回一个空字符串 "" 。 
// 
//
// 注意：每个函数都应当满足 O(1) 平均时间复杂度。 
//
// 
//
// 示例： 
//
// 
//输入
//["AllOne", "inc", "inc", "getMaxKey", "getMinKey", "inc", "getMaxKey", 
//"getMinKey"]
//[[], ["hello"], ["hello"], [], [], ["leet"], [], []]
//输出
//[null, null, null, "hello", "hello", null, "hello", "leet"]
//
//解释
//AllOne allOne = new AllOne();
//allOne.inc("hello");
//allOne.inc("hello");
//allOne.getMaxKey(); // 返回 "hello"
//allOne.getMinKey(); // 返回 "hello"
//allOne.inc("leet");
//allOne.getMaxKey(); // 返回 "hello"
//allOne.getMinKey(); // 返回 "leet"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= key.length <= 10 
// key 由小写英文字母组成 
// 测试用例保证：在每次调用 dec 时，数据结构中总存在 key 
// 最多调用 inc、dec、getMaxKey 和 getMinKey 方法 5 * 10⁴ 次 
// 
//
// Related Topics 设计 哈希表 链表 双向链表 👍 315 👎 0


package com.leetcode.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

public class AllOoneDataStructure {
    //leetcode submit region begin(Prohibit modification and deletion)
    class AllOne {

        class Bucket {
            public HashSet<String> set;
            public int cnt;
            public Bucket last;
            public Bucket next;

            public Bucket(String s, int c) {
                set = new HashSet<>();
                set.add(s);
                cnt = c;
            }
        }

        // 在两个已有的桶之间插入一个新的桶
        private void insert(Bucket cur, Bucket pos) {
            cur.next.last = pos;
            pos.next = cur.next;
            cur.next = pos;
            pos.last = cur;
        }

        // 删除当前桶
        private void remove(Bucket cur) {
            cur.last.next = cur.next;
            cur.next.last = cur.last;
        }

        // 初始化首尾的两个桶
        Bucket head;
        Bucket tail;

        HashMap<String, Bucket> map;

        public AllOne() {
            head = new Bucket("", 0);
            tail = new Bucket("", Integer.MAX_VALUE);
            head.next = tail;
            tail.last = head;
            map = new HashMap<>();
        }

        // 词频增加
        public void inc(String key) {
            // 判断key是否存在于map中
            if (!map.containsKey(key)) { // 如果key是新的
                // 判断是否存在词频为1的桶
                if (head.next.cnt == 1) { // 如果存在则将key加入该桶
                    map.put(key, head.next);
                    head.next.set.add(key);
                } else { // 如果不存在，则新建一个桶，再将key加入
                    Bucket newBucket = new Bucket(key, 1);
                    map.put(key, newBucket);
                    insert(head, newBucket);
                }
            } else {// 如果key已在map中存在，则找到key所在的桶
                Bucket bucket = map.get(key);
                if (bucket.next.cnt == bucket.cnt + 1) { // 如果key所在的桶存在下一个桶
                    // 则直接把key放进下一个桶里
                    map.put(key, bucket.next);
                    bucket.next.set.add(key);
                } else { // 如果key所在的桶不存在下一个桶，则新建一个，把key放进去
                    Bucket newBucket = new Bucket(key, bucket.cnt + 1);
                    map.put(key, newBucket);
                    insert(bucket, newBucket);
                }
                // 要把key从原来的桶中删除
                bucket.set.remove(key);
                // 如果原来的桶里已经空了，则删除这个桶
                if (bucket.set.isEmpty()) {
                    remove(bucket);
                }
            }
        }

        // 词频减少
        public void dec(String key) { // 题目保证在调用该方法时，key一定存在
            // 先找key所在的桶
            Bucket bucket = map.get(key);
            if (bucket.cnt == 1) { // 词频为1的情况
                map.remove(key);
            } else { // 如果词频不为1
                if (bucket.last.cnt == bucket.cnt - 1) { // 如果key所在桶的前一个桶已经存在
                    // 则直接把key放进前一个桶里
                    map.put(key, bucket.last);
                    bucket.set.add(key);
                } else { // 如果key所在桶的前一个桶不存在，则新建一个桶，把key放进去
                    Bucket newBucket = new Bucket(key, bucket.cnt - 1);
                    map.put(key, newBucket);
                    insert(bucket.last, newBucket);
                }
            }
            // 要把key从原来的桶中删除
            bucket.set.remove(key);
            // 如果原来的桶里已经空了，则删除这个桶
            if (bucket.set.isEmpty()) {
                remove(bucket);
            }
        }

        // 返回计数最大的字符串。此时返回tail前面那个bucket里的字符串即可
        public String getMaxKey() {
            return tail.last.set.iterator().next();
        }

        // 返回计数最大的字符串。此时返回tail前面那个bucket里的字符串即可
        public String getMinKey() {
            return head.next.set.iterator().next();
        }
    }

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
//leetcode submit region end(Prohibit modification and deletion)
}
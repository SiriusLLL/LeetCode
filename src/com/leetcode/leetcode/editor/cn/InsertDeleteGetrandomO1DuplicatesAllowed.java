//RandomizedCollection 是一种包含数字集合(可能是重复的)的数据结构。它应该支持插入和删除特定元素，以及删除随机元素。 
//
// 实现 RandomizedCollection 类: 
//
// 
// RandomizedCollection()初始化空的 RandomizedCollection 对象。 
// bool insert(int val) 将一个 val 项插入到集合中，即使该项已经存在。如果该项不存在，则返回 true ，否则返回 false 。 
//
// bool remove(int val) 如果存在，从集合中移除一个 val 项。如果该项存在，则返回 true ，否则返回 false 。注意，如果 
//val 在集合中出现多次，我们只删除其中一个。 
// int getRandom() 从当前的多个元素集合中返回一个随机元素。每个元素被返回的概率与集合中包含的相同值的数量 线性相关 。 
// 
//
// 您必须实现类的函数，使每个函数的 平均 时间复杂度为 O(1) 。 
//
// 注意：生成测试用例时，只有在 RandomizedCollection 中 至少有一项 时，才会调用 getRandom 。 
//
// 
//
// 示例 1: 
//
// 
//输入
//["RandomizedCollection", "insert", "insert", "insert", "getRandom", "remove", 
//"getRandom"]
//[[], [1], [1], [2], [], [1], []]
//输出
//[null, true, false, true, 2, true, 1]
//
//解释
//RandomizedCollection collection = new RandomizedCollection();// 初始化一个空的集合。
//collection.insert(1);   // 返回 true，因为集合不包含 1。
//                        // 将 1 插入到集合中。
//collection.insert(1);   // 返回 false，因为集合包含 1。
//                        // 将另一个 1 插入到集合中。集合现在包含 [1,1]。
//collection.insert(2);   // 返回 true，因为集合不包含 2。
//                        // 将 2 插入到集合中。集合现在包含 [1,1,2]。
//collection.getRandom(); // getRandom 应当:
//                        // 有 2/3 的概率返回 1,
//                        // 1/3 的概率返回 2。
//collection.remove(1);   // 返回 true，因为集合包含 1。
//                        // 从集合中移除 1。集合现在包含 [1,2]。
//collection.getRandom(); // getRandom 应该返回 1 或 2，两者的可能性相同。 
//
// 
//
// 提示: 
//
// 
// -2³¹ <= val <= 2³¹ - 1 
// insert, remove 和 getRandom 最多 总共 被调用 2 * 10⁵ 次 
// 当调用 getRandom 时，数据结构中 至少有一个 元素 
// 
//
// Related Topics 设计 数组 哈希表 数学 随机化 👍 273 👎 0


package com.leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class InsertDeleteGetrandomO1DuplicatesAllowed {

    //leetcode submit region begin(Prohibit modification and deletion)
    class RandomizedCollection {
        public HashMap<Integer, HashSet<Integer>> map;
        public ArrayList<Integer> arr;

        public RandomizedCollection() {
            map = new HashMap<>();
            arr = new ArrayList<>();
        }

        public boolean insert(int val) {
            arr.add(val);
            // 查map中key为val的元素有没有set，如果没有就新建一个set
            HashSet<Integer> set = map.getOrDefault(val, new HashSet<Integer>());
            // 在这个set中添加arr的下标
            set.add(arr.size() - 1);
            map.put(val, set);

            // 题目要求，如果val已存在，则返回false，否则返回true
            return set.size() == 1;
        }

        public boolean remove(int val) {
            // 判空
            if (!map.containsKey(val)) {
                return false;
            }

            // 找到动态数组中最后一个元素
            int endValue = arr.get(arr.size() - 1);

            // 找出val在map中对应的set(set里面存了val的所有下标)
            HashSet<Integer> valueSet = map.get(val);
            // 找出valueSet中val对应的值（其中一个就可以），因为要将endValue的下标换成这个值
            int valueIndex = valueSet.iterator().next();

            // 如果要删除的这个val刚好位于动态数组的末尾，则直接删除即可
            if (val == endValue) {
                valueSet.remove(arr.size() - 1);
            } else {
                // 否则就在动态数组最后一位元素的下标集合中，添加已删除的val的下标，并且删除这个元素原有的下标（即替换）
                HashSet<Integer> endValueSet = map.get(endValue);
                endValueSet.add(valueIndex);
                // 动态数组同步修改
                arr.set(valueIndex, endValue);
                // 删除末尾元素原有的下标
                endValueSet.remove(arr.size() - 1);
                // 删除val的下标
                valueSet.remove(valueIndex);
            }

            // 在动态数组中删除末尾元素
            arr.remove(arr.size() - 1);

            // 如果删除的这个元素是最后一个(即valueSet是空的)
            if (valueSet.isEmpty()) {
                // 那么同时删除map中的这个元素
                map.remove(val);
            }

            return true;
        }

        public int getRandom() {
            return arr.get((int) (Math.random() * arr.size()));
        }
    }

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)
}
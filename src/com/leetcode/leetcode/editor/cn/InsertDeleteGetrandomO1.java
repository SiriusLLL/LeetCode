//实现RandomizedSet 类： 
//
// 
// 
// 
// RandomizedSet() 初始化 RandomizedSet 对象 
// bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。 
// bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。 
// int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。 
// 
// 
// 
//
// 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。 
//
// 
//
// 示例： 
//
// 
//输入
//["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", 
//"insert", "getRandom"]
//[[], [1], [2], [2], [], [1], [2], []]
//输出
//[null, true, false, true, 2, true, false, 2]
//
//解释
//RandomizedSet randomizedSet = new RandomizedSet();
//randomizedSet.insert(1); // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
//randomizedSet.remove(2); // 返回 false ，表示集合中不存在 2 。
//randomizedSet.insert(2); // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
//randomizedSet.getRandom(); // getRandom 应随机返回 1 或 2 。
//randomizedSet.remove(1); // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
//randomizedSet.insert(2); // 2 已在集合中，所以返回 false 。
//randomizedSet.getRandom(); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= val <= 2³¹ - 1 
// 最多调用 insert、remove 和 getRandom 函数 2 * 10⁵ 次 
// 在调用 getRandom 方法时，数据结构中 至少存在一个 元素。 
// 
//
// Related Topics 设计 数组 哈希表 数学 随机化 👍 770 👎 0


package com.leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;

public class InsertDeleteGetrandomO1 {
    //leetcode submit region begin(Prohibit modification and deletion)
    class RandomizedSet {

        public HashMap<Integer, Integer> map;
        public ArrayList<Integer> arr;

        // 用Map来存数组元素下标
        public RandomizedSet() {
            map = new HashMap<>();
            arr = new ArrayList<>();
        }

        // 插入
        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }

            map.put(val, arr.size());
            arr.add(val);
            return true;
        }

        // 删除元素
        // 用数组末尾的元素代替拟删除的元素，保证下标连续。
        // 对应修改map和arr
        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            int valIndex = map.get(val);
            int endValue = arr.get(arr.size() - 1);

            map.put(endValue, valIndex);
            arr.set(valIndex, endValue);
            map.remove(val);
            arr.remove(arr.size() - 1);
            return true;
        }

        // 随机获取元素
        public int getRandom() {
            return arr.get((int) (Math.random() * arr.size()));
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)
}
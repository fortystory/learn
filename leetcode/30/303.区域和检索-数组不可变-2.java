/*
 * @lc app=leetcode.cn id=303 lang=java
 *
 * [303] 区域和检索 - 数组不可变
 */

// @lc code=start
class NumArray {

    private  interface Merger<E>{
        E merge(E a, E b);
    }

    private class SegmentTree<E> {
        private E[] data;
        private E[] tree;
        private Merger<E> merger;

        @SuppressWarnings("unchecked")
        public SegmentTree(E[] arr, Merger<E> merger){
            this.merger = merger;
            data = (E[])new Object[arr.length];
            for (int i = 0; i < arr.length; i++) {
                data[i] = arr[i];
            }
            tree = (E[]) new Object[4 * data.length];
            buildSegmentTree(0, 0, data.length - 1);
        }

        private void buildSegmentTree(int treeIndex,int l, int r){
            //递归终止条件
            if(l == r){
                tree[treeIndex] = data[l];
                return;
            }

            int leftTreeIndex = leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);

            int mid = l + (r - l) / 2;
            buildSegmentTree(leftTreeIndex,l,mid);
            buildSegmentTree(rightTreeIndex,mid + 1,r);

            tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
        }

        public E get(int i){
            if(i < 0 || i > data.length){
                throw new IllegalArgumentException("index is illegal.");
            }
            return data[i];
        }

        /**
         * 获取左孩子的索引
         * @param i
         * @return
         */
        private int leftChild(int i){
            return 2 * i + 1;
        }

        /**
         * 获取右孩子的索引
         */
        private int rightChild(int i){
            return 2 * i + 2;
        }

        /**
         * 查询某个区间的数据
         * @param l
         * @param r
         * @return
         */
        public E query(int queryL, int queryR){
            if(queryL < 0 || queryR >= data.length || queryR < 0 || queryR >= data.length || queryL > queryR){
                throw new IllegalArgumentException("Index is illegal.");
            }
            return query(0,0,data.length - 1,queryL,queryR);
        }

        /**
         * 在以treeID为根的线段树中[l,r]的范围内,搜索区间[queryL,queryR]的值
         * @param treeIndex
         * @param r
         * @param l
         * @param queryL
         * @param queryR
         * @return
         */
        private E query(int treeIndex, int l, int r, int queryL, int queryR){
            //递归结束条件 两边的边界相等
            if(l == queryL && r == queryR){
                return tree[treeIndex];
            }

            int mid = l + (r - l) / 2;//子节点的分界
            int leftTreeIndex = leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);

            if(queryL >= mid + 1){
                return query(rightTreeIndex,mid + 1,r,queryL,queryR);
            }else if(queryR <= mid){
                return query(leftTreeIndex,l,mid,queryL,queryR);
            }

            E leftResult = query(leftTreeIndex,l,mid,queryL,mid);
            E rightResult = query(rightTreeIndex,mid + 1,r,mid + 1,queryR);

            return merger.merge(leftResult,rightResult);
        }


        @Override
        public String toString(){
            StringBuilder res = new StringBuilder();
            res.append("[");
            for (int i = 0; i < tree.length; i++) {
                if(tree[i] != null){
                    res.append(tree[i]);
                }else{
                    res.append("null");
                }
                
                if(i != tree.length - 1){
                    res.append(",");
                }
            }
            res.append("]");
            return res.toString();
        }
    }

    private SegmentTree segTree;
    public NumArray(int[] nums) {
        if(nums.length > 0){
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            segTree = new SegmentTree<>(data, (a, b) -> a + b);
        }
    }
    
    public int sumRange(int left, int right) {
        if(segTree == null){
            throw new IllegalArgumentException("segment tree is null");
        }

        return (int) segTree.query(left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
// @lc code=end


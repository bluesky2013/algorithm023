//package Week_02;

import java.util.*;

/**
 * Created by fuwenchao on 2021/1/9.
 */
//public class TopKFrequent {
//
//    public static int[] topKFrequent(int[] nums, int k) {/*
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//        for(int term : nums){
//            if(map.containsKey(term)){
//                map.put(term, map.get(term)+1);
//            }else{
//                map.put(term, 1);
//            }
//        }
//        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
//            public int compare(Integer o1, Integer o2) {
//                return map.get(o1)-map.get(o2);
//            }
//        });
//
//        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
//        while(it.hasNext()){
//            Integer key = it.next().getKey();
//            if(heap.size()<k){
//                heap.add(key);
//            }else{
//                if(map.get(key)>map.get(heap.peek())){
//                    heap.remove();
//                    heap.add(key);
//                }
//            }
//        }
//        int[] rsArray = new int[k];
//        Iterator<Integer> heapIt = heap.iterator();
//        int index = 0 ;
//        while(heapIt.hasNext()){
//            rsArray[index++] = heapIt.next();
//        }
//
//        return rsArray;
//    }
//
//    public static void main(String[] args) {
//        int[] nums = {1,1,1,2,2,3};
//        int k = 2;
//        System.out.println(topKFrequent(nums, k ));
//*/
////    }
//
//}

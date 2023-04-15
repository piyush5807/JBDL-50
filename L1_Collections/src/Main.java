import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Main {

  public static void main(String[] args) {

    Main obj = new Main();
    obj.toString();

//    List<Integer> list = new ArrayList<>();
//    list.add(1);
//    list.add(2);
//    list.add(3);
//    list.add(4);
//    list.add(5);
//    list.add(6);
//    list.add(7);
//    list.add(8);
//
//    for(int i = 0; i < list.size(); i++){
//      if(list.get(i) % 2 == 0){
//        list.remove(i);
//      }
//    }
//
//    System.out.println(list);

//    HashMap<Integer, Boolean> map = new HashMap<>();
//    map.put(1, true);
//    map.put(2, true);
//    map.put(3, true);
//    map.put(4, true);
//
//    Set<Map.Entry<Integer, Boolean>> entries = map.entrySet();
//    for(Map.Entry<Integer, Boolean> entry: entries){
//      if(entry.getKey() % 2 == 0){
//        map.remove(entry.getKey());
//      }
//    }
//
//    System.out.println(map);


    // Arrays - stores data in contiguous fashion
    // Lists - stores data in non-contiguous fashion
    // Sets - unordered data with no duplicates
    // Maps - key value store, keys cannot have duplicates

    /*
        Q1
        Given a List of integers and a target, you need to find a pair whose sum is equal to the target
        If no such pair exist, you can return -1

        L = [1, 2, 3, 4, 7, 5, 8, 10, 20]
        Target = 35
        -1

        Q2. Given a List of integers and a target, you need to count of all the pairs whose sum is equal to the target
        If no such pair exist, you can return 0

        L = [1, 2, 3, 4, 4, 5, 6, 7, 8, 9, 2, 5, 5, 5, 13]
        T = 10
        Count = [1, 9], [2, 8], [3, 7], [4, 6], [4, 6], [5, 5] = 6

        Q3. Given a list of integers and a value 'k', you need to find kth largest number
        L = [1, 2, 3, 4, 5, 4, 3, 6, 7, 8]
        K = 4
        Ans = 5

        Brute Force: Sort the array, list.get( n - k)  NlogN

         Min Heap
         1. Every parent should be less than their child nodes
         2. Top most node will be the minimum in the entire heap



                             3
                           5   4
                          4


              [5, 6, 7, 8]

              O(N*logK)

              // Lamuto partition


                  List
             /           |         \
            LinkedList   ArrayList  BlockingList


            int[][] arr = new int[m][n]

            List<List<Integer>> al = Arrays.asList(
              Arrays.asList(1, 2, 3, 4, 5),
              Arrays.asList(60, 70, 80, 90, 100),
              Arrays.asList(10, 20, 30, 40, 50)
            );

     */

    List<Integer> nums = Arrays.asList(1, 2, 3, 4, 4, 5, 6, 7, 8, 9, 2, 5, 5, 5, 5, 13);
    int target = 10;
    /*
      1 - 9 (1)
      2 - 8 (2)
      3 - 7 (1)
      4 - 6 (2)
      5 - 5 (10)
     */
//
//    System.out.println(countPairs(nums, target));

    System.out.println(findKthLargestElement(nums, 1));
    
  }

  /** Oops concepts
   * 1. Abstraction - achieved by abstract classes and interfaces
   * 2. Encapsulation - achieved by classes
   * 3. Polymorphism - achieved by function overloading and overriding
   * 4. Inheritance - achieved by extending classes
   */


  public static void findPair(List<Integer> nums, int target){
    Set<Integer> set = new HashSet<>();

    boolean found = false;
    List<Integer> result = new ArrayList<>();
    for(int i = 0; i < nums.size(); i++){
      int val = nums.get(i);
      int reqd = target - val;
      if(set.contains(reqd)){
        found = true;
        result.add(val);
        result.add(reqd);
        break;
      }
      set.add(val);
    }

    if(found){
      System.out.println(result);
    }else{
      System.out.println(-1);
    }
  }

  public static int countPairs(List<Integer> nums, int target){

    Map<Integer, Integer> map = new HashMap<>();

    int count = 0;

    // Setting the map
    for(Integer num : nums){
      if(map.containsKey(num)){
        map.put(num, map.get(num) + 1);
      }else{
        map.put(num, 1);
      }
    }

    // Iterating the map and updating the counts
    Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
    for(Map.Entry<Integer, Integer> entry : entries){
      int key = entry.getKey();
      Integer val = map.get(target - key);
      if(val != null && key * 2 != target){ // key = 6 and 4 is not present in map
        count += val * entry.getValue();
        entry.setValue(0);
        map.put(target - key, 0);
      }else if(key * 2 == target){
        count += (entry.getValue() * (entry.getValue() - 1)) / 2;
      }
    }

    return count;
  }

  public static int findKthLargestElement(List<Integer> nums, int k) {

    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2 - o1;
      }
    });

    for(int i = 0; i < nums.size(); i++){
      if(pq.size() < k){
        pq.add(nums.get(i));
      }else if(nums.get(i) > pq.peek()){
        pq.poll();
        pq.add(nums.get(i));
      }
    }

    return pq.peek();
  }


}
package javaDP;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class allSubArray {
  private static List<List<Integer>> allSubA(int[] a){
      List<List<Integer>> ans = new ArrayList<>();
      for (int i=0, n=a.length; i<n;i++){
        for (int j=n-1;j>=i;j--){
          int[] tmp = Arrays.copyOfRange(a, i, j+1);
          ans.add(new ArrayList<>( Arrays.stream(tmp).boxed().collect(Collectors.toList()) ));
        }
      }
      return ans;
  }

  private static List<List<Integer>> subarray(int[] nums, int k){
    int n = nums.length;
    if (k==0) return new ArrayList<>();
    // List<List<Integer>> ans = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();
    int[] a = Arrays.copyOfRange(nums, 0, k);
    LinkedList<Integer> slider = new LinkedList<>();
    for (int i: a ) slider.addLast(i);
    set.add( new ArrayList<>(slider));
    for (int i=1;i+k-1<n;i++){
      slider.removeFirst();
      slider.addLast(nums[i+k-1]);
      set.add(new ArrayList<>(slider));
    }
    return new ArrayList<>(set);
  }

  private static List<List<Integer>> subsetsWithoutDup(int[] nums){
    int n = nums.length;
    List<List<Integer>> finalans = new ArrayList<>();
    finalans.add(new ArrayList<>());
    for (int i =1; i<=n;i++){
      List<List<Integer>> ans = subarray(nums, i);
      finalans.addAll( new ArrayList<>(ans) );
    }

    return finalans;
  }

  public static void main(String[] args) {
    int[] a = {1,2,3,4,5};
    System.out.println( allSubA(a).toString() );
  }
}

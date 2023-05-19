package javaDP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class allSubSet {
  
  // all unique value in nums. Getting subset using recursion
  private static List<List<Integer>> subsets(int[] nums){
    List<List<Integer>> ans = new ArrayList<>();
    
    if (nums.length==0) return new ArrayList<>();
    if (nums.length==1) {
      ans.add(new ArrayList<>());
      ans.add( new ArrayList<>( Arrays.asList(nums[0])) );
      return ans;
    }

    List<List<Integer>> result = subsets( Arrays.copyOfRange(nums, 0, nums.length-1) ) ;
    for (int i=0, n = result.size(); i<n;i++ ){
      if (!result.get(i).isEmpty()) {
        List<Integer> temp = new ArrayList<>(result.get(i));
        temp.add( nums[nums.length-1] );
        result.add( new ArrayList<>(temp));
      }
    }
    result.add( Arrays.asList( nums[nums.length-1] ));
    ans = new ArrayList<>( result.stream()
                                  .map(ArrayList::new)
                                  .collect(Collectors.toList()) );

    return ans;
  }

  // dup value in nums. Getting subset using tabulation
  private static List<List<Integer>> subsetsWithDup(int[] nums){
    int n = nums.length;
    List<List<Integer>> finalans = new ArrayList<>();
    finalans.add(new ArrayList<>());
    if(n==0) return finalans;
    finalans.add( new ArrayList<>( Arrays.asList(nums[0])) );
    if(n==1) return finalans;
    List<List<Integer>> prev = new ArrayList<>(finalans.stream().map(ArrayList::new).collect(Collectors.toList()) );
    for (int i=1;i<n;i++){
      for (List<Integer> p : prev){
        p.add(nums[i]);
        finalans.add(new ArrayList<>(p));
      }
      prev = new ArrayList<>(finalans.stream().map(ArrayList::new).collect(Collectors.toList()));
    }
    Set<List<Integer>> set = new HashSet<>(finalans);
    Set<List<Integer>> setSorted = new HashSet<>();
    for (List<Integer> s :set ){
      s.sort((m1,m2)-> m1.compareTo(m2));
      setSorted.add( new ArrayList<>(s));
    }
    return new ArrayList<>(setSorted);
  }

}

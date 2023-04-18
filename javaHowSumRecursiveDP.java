package javaDP;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class javaHowSumRecursiveDP {
  
  static private List<List<Integer>> finalAns = new ArrayList<>();
  
  private List<List<Integer>> allCombination(int[] candidates, int target, List<Integer> ans){
    if (target <0) return null;
    if (target ==0) return new ArrayList<>();

    for (int i=0, n = candidates.length; i<n ; i++ ){
      int remainder = target - candidates[i];
      ans.add(candidates[i]);
      if (remainder <0) ans.remove(ans.size()-1);
      List<List<Integer>> result = new javaHowSumRecursiveDP().allCombination(candidates,remainder,new ArrayList<>(ans));
      if (result !=null){
        if ( remainder ==0){
          finalAns.add(new ArrayList<>(ans));
        }
        ans.remove(ans.size()-1);
        remainder = remainder + candidates[i];
      }
    }
    return finalAns;
  }

  static private Map<Integer,List<List<Integer>>> memo = new HashMap<>();
  private List<List<Integer>> allCombinationMemo(int[] candidates, int target, List<Integer> ans){
    if (target <0) return null;
    if (target ==0) return new ArrayList<>();
    if (memo.containsKey(target)) return memo.get(target);

    for (int i=0, n = candidates.length; i<n ; i++ ){
      int remainder = target - candidates[i];
      ans.add(candidates[i]);
      if (remainder <0) ans.remove(ans.size()-1);
      List<List<Integer>> result = new javaHowSumRecursiveDP().allCombination(candidates,remainder,new ArrayList<>(ans));
      if (result !=null){
        if ( remainder ==0){
          finalAns.add(new ArrayList<>(ans));
          System.out.println(target);
        }
        ans.remove(ans.size()-1);
        remainder = remainder + candidates[i];
      }
    }
    memo.put(target, finalAns);
    return finalAns;
  }

  public static void main(String[] args) {
    int[] candidates = {2,3,5};
    int target = 20;
    
    System.out.println(new javaHowSumRecursiveDP().allCombination(candidates, target, new ArrayList<>()) );
    // System.out.println(new javaHowSumRecursiveDP().allCombinationMemo(candidates, target, new ArrayList<>()) );
  }
}
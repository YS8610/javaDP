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

  static private List<List<Integer>> allCombinationDP(int[] candidates, int target, Map<Integer,List<List<Integer>>> memo ){
    List<List<Integer>> temp = new ArrayList<>();
    // Map<Integer,List<List<Integer>>> memo = new HashMap<>();
    
    if (target <0) return null;
    if (target ==0) {
      List<List<Integer>> ansSet = new ArrayList<>();
      ansSet.add(new ArrayList<>());
      return ansSet;
    }

    for (int i=0, n=candidates.length; i<n;i++){
      int remainder = target - candidates[i];
      List<List<Integer>> result = allCombinationDP(candidates, remainder,memo);
      if (result != null){
        for (int j =0, m=result.size(); j<m;j++) {
          result.get(j).add( Integer.valueOf(candidates[i]) );
        }
        temp.addAll(new ArrayList<>(result));
      }
    }
    memo.put(target, new ArrayList<>(temp));
    System.out.println(memo.toString());
    return temp;
  }



  public static void main(String[] args) {
    int[] candidates = {1,2,3};
    int target = 4;
    
    System.out.println(allCombinationDP(candidates, target, new HashMap<>()) );
  }
}
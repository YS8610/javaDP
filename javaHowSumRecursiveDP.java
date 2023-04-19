package javaDP;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    
    if (target <0) return null;
    if (target ==0) {
      List<List<Integer>> ansSet = new ArrayList<>();
      ansSet.add(new ArrayList<>());
      return ansSet;
    }
    if (memo.containsKey(target)) return memo.get(target);

    for (int i=0, n=candidates.length; i<n;i++){
      int remainder = target - candidates[i];
      List<List<Integer>> result = allCombinationDP(candidates, remainder,memo);
      if (result != null){
        for (int j =0, m=result.size(); j<m;j++) {
          result.get(j).add( candidates[i] );
        }
        temp.addAll(new ArrayList<>(result));
      }
    }
    memo.put(target, new ArrayList<>( temp.stream().map(ArrayList::new).collect(Collectors.toList()) ));
    return temp;
  }



  public static void main(String[] args) {
    int[] candidates = {2,3};
    int target = 20;
    
    System.out.println(allCombinationDP(candidates, target, new HashMap<>()) );
  }
}
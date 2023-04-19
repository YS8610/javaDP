package javaDP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class javaHowSumRecursiveUniqueDp {
  static private List<List<Integer>> allCombinationUniDP(int[] candidates, int target, Map<Integer,List<List<Integer>>> memo ){
    List<List<Integer>> temp = new ArrayList<>();
    
    if (target <0) return null;
    if (target ==0) {
      List<List<Integer>> ansSet = new ArrayList<>();
      ansSet.add(new ArrayList<>());
      return ansSet;
    }
    if (memo.containsKey(target)){
      return new ArrayList<>(memo.get(target).stream().map(ArrayList::new).collect(Collectors.toList()));
    } 

    for (int i=0, n=candidates.length; i<n;i++){
      int remainder = target - candidates[i];
      List<List<Integer>> result = allCombinationUniDP(candidates, remainder,memo);
      if (result != null){
        for (int j =0, m=result.size(); j<m;j++) {
          result.get(j).add( candidates[i] );
        }
        temp.addAll(new ArrayList<>(result));
      }
    }
    memo.put(target, new ArrayList<>( temp.stream().map(ArrayList::new).collect(Collectors.toList()) ));
    // System.out.println(memo.toString());
    return temp;
  }
  public static void main(String[] args) {
    int[] candidates = {1,2,3};
    int target = 4;

    System.out.println( allCombinationUniDP(candidates,target, new HashMap<>()));
  }
}

package javaDP;

import java.util.ArrayList;
import java.util.List;

public class javaHowSum {
  static private List<List<Integer>> finalAns = new ArrayList<>();
  
  private List<List<Integer>> allCombination(int[] candidates, int target, List<Integer> ans){
    if (target <0) return null;
    if (target ==0) return new ArrayList<>();

    for (int i=0, n = candidates.length; i<n ; i++ ){
      int remainder = target - candidates[i];
      ans.add(candidates[i]);
      if (remainder <0) ans.remove(ans.size()-1);
      List<List<Integer>> result = new javaHowSum().allCombination(candidates,remainder,new ArrayList<>(ans));
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

  public static void main(String[] args) {
    int[] candidates = {2,3};
    int target = 6;
    
    System.out.println( new javaHowSum().allCombination(candidates, target, new ArrayList<>()) );
  }
}

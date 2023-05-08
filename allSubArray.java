package javaDP;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

  public static void main(String[] args) {
    int[] a = {1,2,3,4,5};
    System.out.println( allSubA(a).toString() );
  }
}

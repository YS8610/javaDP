import java.util.Arrays;

public class QuickSort {
  private static void quickSort(int[] a, int start, int end){
    if (start==end) return ;
    int lp = start;
    int rp = end;
    int pivot = a[end];

    while( lp < rp){
      while( a[lp]<=pivot && lp <rp) lp++;
      while( a[rp]>=pivot && lp <rp) rp--;
      swap(a, lp, rp);
    }
    if (lp == rp){
      if(a[lp] > pivot ) swap(a, lp, end);
      quickSort(a,start,lp-1);
      quickSort(a,lp+1, end);
    }
  }

  private static void swap(int[] a, int p1, int p2 ){
    if (p1==p2) return;
    int tmp = a[p1];
    a[p1] = a[p2];
    a[p2] = tmp;
  }

  public static void main(String[] args) {
    int[] a = {51,51,52,6,2,3,-20,9,7,8};
    quickSort(a, 0, a.length-1);
    System.out.println(Arrays.toString(a));
  }
}

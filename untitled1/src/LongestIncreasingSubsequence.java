import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasingSubsequence {
    static void calculate(int arr[])
    {
        int max = 0;
        int LIS[] = new int[arr.length];
        LIS[0] = 1;

        for(int i = 1; i<arr.length;i++)
        {
            LIS[i]=1;
            int curr_ele = arr[i];
            for(int j=0;j<i;j++)
            {
                int temp = arr[j];
                if(temp<curr_ele)
                {
                    LIS[i] = Math.max(LIS[j]+1,LIS[i]);
                    max = Math.max(LIS[i],max);
                }
            }
        }
        System.out.println("LIS " + Arrays.toString(LIS));
        System.out.println("Max  " + max);
    }
    static ArrayList<Integer> init_AL(int data)
    {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(data);
        return al;
    }
    static void calculate1(int arr[])
    {
        int max = 0; String maxSeq = "";
        int LIS[] = new int[arr.length];
        LIS[0] = 1;
        ArrayList<Integer>[] al = new ArrayList[arr.length];
        al[0] = init_AL(arr[0]);
        for(int i = 1; i<arr.length;i++)
        {
            LIS[i]=1;
            al[i] = init_AL(arr[i]);
            int curr_ele = arr[i];
            //System.out.println("For i " + arr[i] + " OLD " + al);
            for(int j=0;j<i;j++)
            {
                int temp = arr[j];
                if(temp<curr_ele)
                {
                   // LIS[i] = Math.max(LIS[j]+1,LIS[i]);
                   // max = Math.max(LIS[i],max);
                    int res = LIS[j]+1;
                    if(LIS[i]<res)
                    {
                        LIS[i] = res;
                        ArrayList old = al[i];
                        ArrayList jval = al[j];
                        //System.out.println(" jval " + jval + "Old " + old );
                        ArrayList new1= new ArrayList();
                        new1.addAll(jval);
                        new1.add(arr[i]);
                        //System.out.println("new at i"+i+" = " + new1);
                        al[i] = new1;
                    }
                    if(LIS[i]>max)
                    {
                        max = LIS[i];
                        maxSeq= al[i].toString();
                    }
                }
            }
        }
        System.out.println("LIS " + Arrays.toString(LIS));
        System.out.println("Max  " + max + " Max Seq " + maxSeq);
        System.out.println("al = " + Arrays.toString(al));
    }
    static public void main(String args[])
    {
        int arr[] = new int[]{2, 1, 6, 5,4, 6, 7};
        calculate1(arr);
    }
}

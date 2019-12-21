import java.util.ArrayList;
import java.util.List;

public class PartitioningArrayImpl {
    class Partition{
        int start, end;
        Partition(int s,int e)
        {
            start =s; end =s;
        }
        public String toString()
        {
            return String.format("{%s,%s}",start,end);
        }
    }
    static void createPartition(int arr[],int start, int K, int N,String s)
    {
        //System.out.printf("\t\tcreatePartition(start=%d,K=%d, N=%d)\n",start,K,N);
        if(K>N) {
            System.out.println("Error");
            return;
        }
        K--;
        if(K==0)
        {
            s = s+String.format("{%d-%d}",start,arr.length-1);
            System.out.println(s);
            return;
        }
        int counter = N-K;
        for(int i = 0,j=start;i<counter;i++,j++)
        {
            createPartition(arr,j+1,K,(arr.length-1)-(j+1)+1,s+String.format("{%d-%d}",start,j));
        }
    }
    static public void main(String args[])
    {
        createPartition(new int[]{1,2,3,4,5},0,5,5,"");
    }
}

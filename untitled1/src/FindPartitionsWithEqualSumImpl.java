import java.util.Arrays;

public class FindPartitionsWithEqualSumImpl {
    /*Assumptions:
    * We use a prefix Sum Array here.
    * For any K, The totalsum of the array must be divisible by K eg: K=3 and totalsum=15.If not then array cannot be divided
    * pos indicates the end of the last partition. It is used to check Sum for Existing Partition
    * temp counts no of partitions
    *  */
    static boolean KpartitionsPossible(int arr[], int n, int K)
    {
        // Creating and filling prefix sum array
        System.out.printf("Input\t\t%s\n", Arrays.toString(arr));
        int prefix_sum[] = new int[n];
        prefix_sum[0] = arr[0];
        for (int i = 1; i < n; i++)
            prefix_sum[i] = prefix_sum[i - 1] + arr[i];
        System.out.printf("Prefix\t\t%s\n", Arrays.toString(prefix_sum));
        // return false if total_sum is not divisible by K
        int total_sum = prefix_sum[n-1];
        if (total_sum % K != 0)
            return false;

        // a temporary variable to check
        // there are exactly K partitions
        int temp = 0, pos = -1;

        for (int i = 0; i < n; i++)
        {
            System.out.printf("For i=%s arr[i] = %s temp=%s pos=%s\n",i,arr[i],temp,pos);
            // find suitable i for which first
            // partition have the required sum
            // and then find next partition and so on
            System.out.printf("\tprefix_sum[%s]=%s, (pos == -1 ? 0 :prefix_sum[pos])=%s\n",i,prefix_sum[i],(pos == -1 ? 0 :prefix_sum[pos]));
            System.out.printf("\tprefix_sum[i] - (pos == -1 ? 0 :prefix_sum[pos]) => %d \ttotal_sum / K =>%d\n"
                    ,prefix_sum[i] - (pos == -1 ? 0 :prefix_sum[pos]),total_sum / K);
            if (prefix_sum[i] - (pos == -1 ? 0 :prefix_sum[pos]) == total_sum / K)
            {
                System.out.println("\tTrue. Change Pos and Temp\n");
                pos = i;
                temp++;
            }

            // if it becomes greater than
            // required sum break out
            else if (prefix_sum[i] - (pos == -1 ? 0 :
                    prefix_sum[pos]) > total_sum / K) {
                System.out.println("\tBreak\n");
                break;
            }
        }

        // check if temp has reached to K
        System.out.printf("temp = %s, K=%s\n",temp,K);
        return (temp == K);
    }

    public static void main(String []args){

        int arr[] = { 1, 4, 2, 3, 5 };
        int n = arr.length;

        int K = 3;
        if (KpartitionsPossible(arr, n, K))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}

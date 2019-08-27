import java.util.Arrays;

class SegmentTree
{
    int[] segmentTree;
    int[] arr;
    public int[] getSegmentTree()
    {
        return segmentTree;
    }
    private int getTreeLength(int arrlength){
        int res = 2;
        while(res<arrlength)
        {
            res <<=1;
        }
        return res*2;
    }
    SegmentTree(int arr[])
    {
        this.arr =arr;
        segmentTree = new int[getTreeLength(arr.length)];
        buildTree(1,0,arr.length-1);
    }
    void buildTree(int node, int start, int end)
    {
        if(start == end)
        {
            segmentTree[node] = arr[start];
        }
        else
        {
            int mid = (start+end)/2;
            buildTree(2*node, start, mid);
            buildTree(2*node+1,  mid+1, end);
            segmentTree[node] = segmentTree[2*node]+segmentTree[2*node+1];
        }
    }
    int findPosInTree(int pos_in_arr){
        int low =0, high = arr.length;
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(pos_in_arr==mid)
                return mid;
            else
                if(pos_in_arr>mid)
                {
                    low =mid+1;
                }
                else
                {
                    high = mid-1;
                }
        }
    }
}
public class SegmentTreeImpl {
    static public void main(String... args)
    {
        int[] arr = new int[]{1,2,3,4,5,6};
        SegmentTree s = new SegmentTree(arr);
        System.out.println("Seg Tree -> " + Arrays.toString(s.getSegmentTree()));
    }
}

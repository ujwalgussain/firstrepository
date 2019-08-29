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
    int updateQuery(int pos_in_arr,int new_value, int node, int start, int end){
        System.out.println("");
        if(start==end)
        {
            int old_value = segmentTree[node];
            segmentTree[node] = new_value;
            System.out.println("old -> " + old_value + " node "+" return diff " + (new_value-old_value));
            return new_value-old_value;
        }
        int mid = (start+end)/2;
        int diff =  (mid<=pos_in_arr)?updateQuery(pos_in_arr,new_value,2*node,start,mid)
                :updateQuery(pos_in_arr,new_value,2*node+1,mid+1,end);
        segmentTree[node]+=diff;
        return diff;
    }
}
public class SegmentTreeImpl {
    static public void main(String... args)
    {
        int[] arr = new int[]{1,2,3,4,5,6};
        SegmentTree s = new SegmentTree(arr);
        System.out.println("Seg Tree -> " + Arrays.toString(s.getSegmentTree()));
        s.updateQuery(1,10,1,0,arr.length-1);
        System.out.println("Seg Tree -> " + Arrays.toString(s.getSegmentTree()));

    }
}

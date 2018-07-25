package boj_6549;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static long[] tree;
    public static int[] array;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String[] s = in.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            array = new int[n];
            tree = new long[n*4];

            for(int i = 1; i<s.length;i++){
                array[i-1] = Integer.parseInt(s[i]);
            }

            int largest = n;
            int k;
            int current = array[0];
            int Stacked = 1;
            int height = array[0];
            int StackedHeight = array[0] * Stacked;

            for(int i = 1; i < array.length; i++){
                current = 1 * array[i];
                height = array[i];
                if(height < array[i-1]){
                    Stacked = 1;
                    StackedHeight = height + Stacked;
                } else {
                    Stacked += 1;
                    StackedHeight = height * Stacked;
                }

                if(largest < StackedHeight)
                    largest = StackedHeight;
                if(largest < current)
                    largest = current;
            }

            System.out.println(largest);



            //init(array,0,n-1,1);
           // System.out.println(tree[1]);

    }

    public static long init(int arr[], int left, int right, int node){
        if(left == right)
            return tree[node] = arr[left];
        int mid = (left + right) / 2;
        long leftNode = init(arr,left,mid,node*2);
        long rightNode = init(arr, mid+1, right, node*2+1);

        if(leftNode > rightNode) {
            if(leftNode  >= rightNode * 2)
                return tree[node] = leftNode;
            else
                return tree[node] = rightNode * 2;
        } else {
            if(leftNode * 2 <= rightNode)
                return tree[node] = rightNode;
            else
                return tree[node] = leftNode * 2;
        }
    }


}

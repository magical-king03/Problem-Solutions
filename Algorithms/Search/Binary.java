package Search;

public class Binary {
    public static void main(String[] args) {
        int arr[] = {2, 5, 7, 8, 9, 100};
        int element = 455;
        int low = 0, high = arr.length - 1, f = 0;
        while(low <= high){
            int mid = (low+high)/2;
            if(arr[mid] == element){
                f = 1;
                break;
            }else if(arr[mid] > element){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        if(f == 1){
            System.out.println("Element found");
        }else{
            System.out.println("Element not found");
        }
    }
}

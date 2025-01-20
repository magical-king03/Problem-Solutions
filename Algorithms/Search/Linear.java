package Search;

public class Linear {
    public static void main(String[] args) {
        int arr[] = {2, 5, 6, 7, 8};
        int f = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == 574){
                f = 1;
                break;
            }
        }
        if(f == 1){
            System.out.println("Element found");
        }else{
            System.out.println("Element not found");
        }
    }
}

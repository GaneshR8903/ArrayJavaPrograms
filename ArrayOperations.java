import java.util.*;

public class ArrayOperations {
    public static int[] insert(int[] arr,int element,int index){
        if(index<0||index>arr.length){
            throw new ArrayIndexOutOfBoundsException("Index out of Bounds");
        }
        int[] newArr =new int[arr.length+1];
        for(int i=0,j=0;i<newArr.length;i++){
            if(i==index){
                newArr[i]=element;
            }else{
                newArr[i]=arr[j++];
            }
        }
        return newArr;
    }
    public static int[] delete(int[] arr,int index){
        if(index<0||index>arr.length){
            throw  new ArrayIndexOutOfBoundsException("Index out of Bounds");
        }
        int[] newArr=new int[arr.length-1];
        for(int i=0,j=0;i<arr.length;i++){
            if(i==index){
                continue;
            }
            newArr[j++]=arr[i];
        }
        return newArr;
    }
    public static int search(int[] arr,int element){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==element){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the "+n+" elements of an array: ");
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.toString(arr);
        while (true) { 
            System.out.println("Choose the operation: ");
            System.out.println("1.Insert");
            System.out.println("2.Delete");
            System.out.println("3.Search");
            System.out.println("4.Exit");
            int choice=sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter the element to insert:");
                    int insertElement=sc.nextInt();
                    System.out.println("Enter index to insert at: ");
                    int insertIndex=sc.nextInt();
                    arr=insert(arr, insertElement, insertIndex);
                    System.out.println("Array after Insertion : "+Arrays.toString(arr));
                }
                case 2 -> {
                    System.out.println("Enter the index to delete at: ");
                    int deleteIndex=sc.nextInt();
                    arr=delete(arr, deleteIndex);
                    System.out.println("Array after deletion: "+Arrays.toString(arr));
                }
                case 3 -> {
                    System.out.println("Enter the element to search: ");
                    int searchElement=sc.nextInt();
                    int searchIndex=search(arr, searchElement);
                    if(searchIndex!=-1){
                        System.out.println("Element found at index: "+searchIndex);
                    }
                    else{
                        System.out.println("Element not found");
                    }
                }
                case 4 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice.Please choose again.");
            }
        }
    }
}

import java.util.Arrays;

public class Day4 {

    public static void main(String[] args) {

        int arr[]={1,2,3,4,4,5,6,7,8};
        findDuplicateElement(arr);


    }

    public static void findDuplicateElement(int arr[]) {
        int ind = 0;
        int count = 0; // Counter to track iterations
        int n = arr.length;

        while (count < n) { // Terminate if we've checked all elements
            int nextIndex = Math.abs(arr[ind]);

            // Check if the current value has already been visited
            if (arr[nextIndex] < 0) {
                System.out.println("Duplicate element is: " + nextIndex);
                return; // Exit after finding the duplicate
            }

            // Mark the current index as visited
            arr[nextIndex] = -arr[nextIndex];
            ind = nextIndex;
            count++;
        }

        // If no duplicate is found within n iterations
        System.out.println("No duplicate found");
    }

    public static void getFloorAndCeil(int a[],int myFloorAndCeil){
        int left =0;
        int right = a.length-1;
        int mid=(left+right)/2;
        int floor=-1;
        int ceil=-1;
        while(left<=right){

            int ele=a[mid];
            if(ele>myFloorAndCeil){
                right=mid-1;
                ceil=mid;
            }else if(ele<myFloorAndCeil){
                left=mid+1;
                floor=mid;
            }else{
                left++;
                right--;
            }
            mid=(left+right)/2;
        }

        System.out.println("for "+myFloorAndCeil+" floor :"+a[floor]+"  Ceil :"+a[ceil]);
    }

    public static void firstAndLastIndexOfElement(int []arr,int findMyFirstAndLastIndex){

        int left =0;
        int right = arr.length-1;
        int mid= (left+right)/2;

        // get the first index
        int firstIndexAt=-1;
        while(left<=right){
            int element=arr[mid];

            if(element>findMyFirstAndLastIndex){
                right=mid-1;
            }else if(element<findMyFirstAndLastIndex){
                left=mid+1;
            }else{
                firstIndexAt=mid;
                right=mid-1;
            }
            mid=(left+right)/2;
        }

        // get the last index
        int lastIndexAt =-1;
        left=0;
        right=arr.length-1;
        mid=(left+right)/2;

        while(left<=right){
            int element=arr[mid];
            if(element>findMyFirstAndLastIndex){
                right=mid-1;
            }else if(element<findMyFirstAndLastIndex){
                left=mid+1;
            }else{
                lastIndexAt =mid;
                left=mid+1;
            }
            mid=(left+right)/2;
        }
        System.out.println("first index at :"+firstIndexAt+" and last index at :"+lastIndexAt);
    }

    public static void subsetOfArray(String []arr){
        int totalNumber=(int)Math.pow(2, arr.length);
        for(int i=0;i<totalNumber;i++){
            int j=0;
            String ans="";
            int number=i;
            int len=arr.length-1;
            while(j<arr.length){
                int val=number%2;
                if(val==0){
                    ans="-"+ans;
                }else{
                    ans=arr[len-j]+ans;
                }
                number/=2;
                j++;
            }
            System.out.println(ans);
        }
    }

    public static void binarySearch(int []arr,int findMe){
        int left=0;
        int right=arr.length-1;
        int mid=(left+right)/2;

        while (left<=right){
            if(findMe>arr[mid]){
                left=mid+1;
            }else if (findMe<arr[mid]){
                right=mid-1;
            }else{
                System.out.println("element we found at ::"+findMe +" at "+mid);
                break;
            }
            mid=(left+right)/2;
        }

    }

    public static void rotateArray(int []arr,int rotate){
        rotate=rotate%arr.length;
        if(rotate<0){
            rotate=rotate-arr.length;
        }
        reverse(arr,0,rotate-1);
        reverse(arr,rotate,arr.length-1);
        reverse(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    public static void reverse(int arr[],int left,int right){

        while(left < right){
            int ele= arr[left];
            arr[left]=arr[right];
            arr[right]=ele;
            left++;
            right--;
        }
    }

    public static void reverseArray(int arr[]){
        int left=0;
        int right=arr.length-1;
        while(left < right){
            int ele= arr[left];
            arr[left]=arr[right];
            arr[right]=ele;
            left++;
            right--;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void printSubArray(String []a){
        for(int start=0;start<a.length;start++){
            for(int end=start;end<a.length;end++){
               for(int j=start;j<=end;j++){
                   System.out.print(a[j]+"");
               }
                System.out.println();
            }
        }
    }

    public static void differenceInArray(int a1[],int a2[]){
        int total=0;
        int carry=0;
        int mul=1;
        int ind1= a1.length-1,ind2=a2.length-1;

        while(ind1>=0|| ind2>=0 || carry>0){
            int d1=0;
            int d2=0;
            if(ind1>=0){
                d1=a1[ind1];
            }

            if(ind2>=0){
                d2=a2[ind2];
            }
            int diffInDigit=d1-d2-carry;

            ind1--;
            ind2--;

            if(diffInDigit<0){
                diffInDigit=diffInDigit+10;
                carry=1;
            }else{
                carry=0;
            }
            total=total+(diffInDigit*mul);
            mul*=10;

        }

        System.out.println(total);
    }

    public static void sumOf2Array(int []arr1,int []arr2){
        int carry=0;
        int mult=1;
        int total=0;
        int index1=arr1.length-1;
        int index2=arr2.length-1;

        while(index1>=0 || index2>=0 || carry>0){
            int d1=0;
            int d2=0;
            if(index1>=0){
                d1=arr1[index1];
            }
            if(index2>=0){
                d2=arr2[index2];
            }

            index1--;
            index2--;

            int sumOfDigits=d1+d2+carry;
            if(sumOfDigits>=10){
                carry=sumOfDigits/10;
                sumOfDigits=sumOfDigits%10;
            }else{
                carry=0;
            }

            total=total+sumOfDigits*mult;
            mult*=10;

        }
        System.out.println("Sum of 2 array is :: "+total);
    }

    public static void  printBarChart(int[] arr){

        int max=findMaxAndMin(arr,true);
        int count =max;
        for(int i=max;i>0;i--){
            for(int j=0;j< arr.length;j++){
                if(j==0){
                    System.out.print(count+"   ");
                }
                if(arr[j]>=i){
                    System.out.print("*\t");
                }else{
                    System.out.print("\t");
                }

            }
            count--;
            System.out.println();
        }

    }

    public static int findMaxAndMin(int arr[],boolean isMax){
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;

        for(int i=0;i<arr.length;i++){

            if(arr[i]>max){
                max=arr[i];
            }
            if(arr[i]<min){
                min=arr[i];
            }

        }
        return isMax?max:min;
    }

    public static void findElementInArray(int []arr,int element){
        boolean isFound=Boolean.FALSE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==element){
                System.out.println("Found "+element+" at index "+i);
                isFound=Boolean.TRUE;
                break;
            }
        }
        if(!isFound){
            System.out.println("Element = "+element+" not found");
        }
    }

    public static void spanOfArray(int []arr){
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;

        for(int i=0;i<arr.length;i++){

            if(arr[i]>max){
                max=arr[i];
            }
            if(arr[i]<min){
                min=arr[i];
            }

        }
        System.out.println("span of the array is :"+(max-min));
    }
}


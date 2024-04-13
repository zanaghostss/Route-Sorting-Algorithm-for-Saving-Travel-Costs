import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);

        int n=scanner.nextInt();

        int array[]=new int[n];




        int xx = n;
        int k = 2;
        int result = calculateCombination(xx, k);

        int matrix[][]=new int[result][2];





        for (int i = 0; i < n; i++) {
            array[i]=scanner.nextInt();
        }

        //sort1(array);
        //print(array);





        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]+"\t");
        }


        int savarray1[]=new int[(2*result)/2];



        int[][] result1 = new int[result][2];
        int index = 0;
        for (int i = 0; i < result; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                result1[index][0] = array[i];
                result1[index][1] = array[i + j + 1];
                index++;
            }
        }


        for (int i = 0; i < result; i++) {
            for (int j = 0; j < 2; j++) {

            }
        }




        for (int i = 0; i < result; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(result1[i][j]+"\t");
            }
            System.out.println();
        }

        int onearray[]=new int[result*2];
        int secend_array[]=new int[result*2];
        int third_array[]=new int[result*2];

        CC(onearray,result1);
        CC2(onearray,secend_array);

        for (int i = 0; i <secend_array.length ; i++) {
            System.out.print(secend_array[i]+"\t");
        }
        System.out.println();
        for (int i = 0; i < onearray.length; i++) {
            System.out.print(onearray[i]+"\t");
        }
        System.out.println();

        CC3(onearray,secend_array,third_array);

        for (int i = 0; i <third_array.length ; i++) {
            System.out.print(third_array[i]+"\t");
        }
        System.out.println();


        //sort1(third_array);
        int ffourarray[]=new int[(result/2)];

        for (int i = 0; i < third_array.length; i++) {
            System.out.print(third_array[i]+"\t");
        }
        //sortrow_s(third_array);
        int third1 [] =new int[third_array.length/2];
        System.out.println();
        for (int i = 0; i < third_array.length; i++) {
            System.out.print(third_array[i]+"\t");
        }
        third_cutter(third_array,third1);
        System.out.println();
        for (int i = 0; i < third1.length; i++) {
            System.out.print(third1[i]+"\t");
        }
        finsort(third1,result1);

        change_row(0,4,result1);

        for (int i = 0; i < result; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(result1[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < third1.length; i++) {
            System.out.print(third1[i]+"\t");
        }


    }
    public static int calculateCombination(int n, int k) {
        if (k < 0 || k > n) {
            return 0;
        }
        int numerator = factorial(n);
        int denominator = factorial(k) * factorial(n - k);
        return numerator / denominator;
    }

    public static int factorial(int num) {
        if (num == 0 || num == 1) {
            return 1;
        }
        int result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }

    public static void sort1(int [] array,int [][]matrix){
        for (int i = 0; i <array.length-1 ; i++) {
            for (int j = 0; j <array.length-1 ; j++) {
                int J3=j+3;
                int J1=j+1;
                if (j+3>=array.length-1 || j+1>=array.length-1){
                    J3=array.length-1;
                    J1=array.length-1;
                }
                if (array[J1]>array[J3]){


                    int temp=array[J1];

                    array[J1]=array[J3];

                    array[J3]=temp;




                }
            }
        }
    }

    public static void print(int []array){
        for (int i = 0; i <array.length ; i++) {
            for (int j = 0; j <array.length ; j++) {
                System.out.print(array[i]+"\t");
            }
        }
    }
    public static void change_row(int start,int end,int [][] matrix){
        int temp= matrix[start][0] ;
        int temp1=matrix[start][1];

        matrix[start][0]=matrix[end][0];
        matrix[start][1]=matrix[end][1];

        matrix[end][0]=temp;
        matrix[end][1]=temp1;


    }
    public static void CC(int [] array,int[][] matrix){

        int indices=0;
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[0].length ; j++) {
                array[indices]=matrix[i][j];
                indices++;
            }
        }

    }

    public static void CC2(int []array,int [] array1){

        for (int i = 0; i < array1.length; i++) {
            array1[i]=0;
        }

        for (int i = 0; i < array.length; i++) {
            if(i%2!=0 & i!=0){
                array1[i]=array[i];
            }
        }

    }
    public static void CC3(int[] array,int [] array2,int[] array3){

        for (int i = 0; i < array3.length; i++) {
            array3[i]=0;
        }

        for (int i = 1; i < array.length; i+=2) {
            int t=array2[i]-array[i-1];
            int to=Math.abs(t);
            array3[i]=to;
        }
    }

    public static void third_cutter(int [] third,int [] third1){
        int indices=0;
        for (int i = 1; i <third.length ; i+=2) {
            if (indices < third.length) {
                third1[indices] = third[i];
                indices++;
            }
        }
    }
    public static void finsort(int [] thirdd1,int mattr[][]){
        for (int i = 0; i <thirdd1.length -1; i++) {
            for (int j = 0; j <thirdd1.length-1 ; j++) {
                if (thirdd1[j]<thirdd1[j+1]){


                    change_row(j,j+1,mattr);



                    int temp3=thirdd1[j];
                    thirdd1[j]=thirdd1[j+1];
                    thirdd1[j+1]=temp3;
                }
            }
        }
    }








}
package java_2;


import java.util.Arrays;

public class Main {



    public static void main(String[] args) {

        int[] array = new int[]{10000000};
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] / 2;
            System.out.println(array[i]);

        }


        float[] arr = new float[]{5000000};
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            System.out.println(arr[i]);

            for (int a = 0; i < arr.length; i++)
                arr[i] = 1;

        }


        fillArray(arr);
        long a = System.currentTimeMillis();
        System.out.println("метод первый " + Arrays.toString(arr));
        method_one(arr);
        System.currentTimeMillis();
        System.out.println("время выполнения программы/компиляции " + (System.currentTimeMillis() - a));


//

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000; i++) ;
            }
        });

    }



    private static void method_one(float[] arr) {
    }

    private static void fillArray(float[] arr) {
    }

    private static void method_two(float arr[], float array []) {
        Method_two a = new Method_two();
        int h = 0;
        float[] a1 = new float[5];
        float[] a2 = new float[5];
        System.arraycopy(array, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        System.out.println("a1 before " + Arrays.toString(a1));
        System.out.println("a2 before " + Arrays.toString(a2));

        new Thread(() -> Method_two.method_two2(arr, 0)).start();
        new Thread(() -> Method_two.method_two2(array, h)).start();


        System.out.println("a1 after " + Arrays.toString(a1));
        System.out.println("a2 after " + Arrays.toString(a2));

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);


        System.out.println(compareArrays(arr, array));

    }

    private static boolean compareArrays(float a1[], float a2[]) {
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i])
                return false;
        }
        return true;

    }

}


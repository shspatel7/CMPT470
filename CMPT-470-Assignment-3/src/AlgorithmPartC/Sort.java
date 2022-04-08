package AlgorithmPartC;

public class Sort {

    private int[] myData;
    private int size;
    public Sort(int[] data , int size) {
        this.myData = data;
        this.size = size;
    }

    public void bubbleSort(int[] a, int n) {
        this.size = n;
        this.myData = a;
        for (int i = 0; i < size -1 ; i++)
            for (int j = 0; j < size-i-1; j++)
                if (myData[j] > myData[j+1])
                {
                    // swap arr[j+1] and arr[j]
                    int temp = myData[j];
                    myData[j] = myData[j+1];
                    myData[j+1] = temp;
                }
    }

    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }
    private static void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
}

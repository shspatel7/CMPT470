package Algorithm;
import java.util.Random;

public class Algorithm {

	int maxCapacity=1000;
	int size=0;
	public int myData[]= new int[maxCapacity];

	Random rand = new Random(System.currentTimeMillis());

	// Some initialization here
	public Algorithm(int n){
		for (int i=0; i<=n; i++) {
			myData[i]=rand.nextInt(1000);
			size ++;
		}
	}

	public int runAlgorithm (int key, int target) {
		int index=-1;
		if (size < 100) {
			bubbleSort(); 
			insert (key);
			index= linearlSearch(target);
		} else {
			mergeSort(myData, size);
			insert(key);
			index= binarySearch(myData,target,  0,  size-1);
		}      
		return index;
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
	public static void merge(
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

	public int binarySearch( int[] sortedArray, int key, int low, int high) {
		int index = -1;

		while (low <= high) {
			int mid = low  + ((high - low) / 2);
			if (sortedArray[mid] < key) {
				low = mid + 1;
			} else if (sortedArray[mid] > key) {
				high = mid - 1;
			} else if (sortedArray[mid] == key) {
				index = mid;
				break;
			}
		}
		return index;
	}

	int linearlSearch(int target){
		int index=-1;
		for (int i = 0; i < size-1; i++){
			if (target==myData[i]){
				index=i;
			}
		}
		return index;
	}


	void insert( int key){
		int i;
		for ( i = size-1; i >0; i--){
			if (myData[i]>key){
				myData[i+1]=myData[i];
			}
			else{

				break;				
			}
		}
		myData[i+1]=key;
		size++;
	}

	void bubbleSort()
	{
		for (int i = 0; i < size-1; i++)
			for (int j = 0; j < size-i-1; j++)
				if (myData[j] > myData[j+1])
				{
					// swap arr[j+1] and arr[j]
					int temp = myData[j];
					myData[j] = myData[j+1];
					myData[j+1] = temp;
				}
	} 

	public String toString()
	{
		String data="["+ myData[0];

		for (int i = 1; i < size; i++)
			data+=", "+myData[i];
		data+="]";
		return data;
	}

}
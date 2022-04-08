package AlgorithmPartC;
import java.util.Random;

public class Algorithm {

	int maxCapacity=1000;
	int size=0;
	public int myData[]= new int[maxCapacity];
	private Sort mySort;
	private Search mySearch;
	private Insert insert;

	Random rand = new Random(System.currentTimeMillis());

	// Some initialization here
	public Algorithm(int n){
		for (int i=0; i<=n; i++) {
			myData[i]=rand.nextInt(1000);
			size ++;
		}
		this.mySort = new Sort(myData, size);
		this.mySearch = new Search(myData, size, 0, 0);
		this.insert = new Insert(myData, size, 0);
	}

	public int runAlgorithm (int key, int target) {
		int index=-1;
		if (size < 100) {
			mySort.bubbleSort(myData, size);
			insert.insert(key);
			index= mySearch.linearSearch(target);
		} else {
			mySort.mergeSort(myData, size);
			insert.insert(key);
			index= mySearch.binarySearch(myData, target, 0, size-1);
		}      
		return index;
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
package Algorithm;
import java.util.Random;

public abstract class Algorithm {

	int maxCapacity=1000;
	int size=0;
	public int[] myData = new int[maxCapacity];

	Random rand = new Random(System.currentTimeMillis());

	// Some initialization here
	public Algorithm(int n){
		for (int i=0; i<=n; i++) {
			myData[i]=rand.nextInt(1000);
			size ++;
		}
	}

	public abstract int runAlgorithm (int key, int target);

	public abstract void sort();

	public final void insert( int key){
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

	public abstract int search(int target);

	public final String toString()
	{
		String data="["+ myData[0];

		for (int i = 1; i < size; i++)
			data+=", "+myData[i];
		data+="]";
		return data;
	}

}
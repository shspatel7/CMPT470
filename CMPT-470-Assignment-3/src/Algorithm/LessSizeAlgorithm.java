package Algorithm;

public class LessSizeAlgorithm extends Algorithm {
    public LessSizeAlgorithm(int n) {
        super(n);
    }

    public void sort(){
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

    public int search(int target) {
        int index=-1;
		for (int i = 0; i < size-1; i++){
			if (target==myData[i]){
				index=i;
			}
		}
		return index;
    }
}

package AlgorithmPartC;

public class Search {
    private int[] myData;
    private int size;
    private int key;
    private int target;

    public Search(int[] myData, int size, int key, int target) {
        this.myData = myData;
        this.size = size;
        this.key = key;
        this.target = target;
    }

    public int binarySearch( int[] sortedArray, int key, int low, int high) {
        int index = -1;
        this.key = key;
        this.myData = sortedArray;
        this.size = sortedArray.length;
        while (low <= high) {
            int mid = low  + ((high - low) / 2);
            if (myData[mid] < this.key) {
                low = mid + 1;
            } else if (myData[mid] > this.key) {
                high = mid - 1;
            } else if (myData[mid] == this.key) {
                index = mid;
                break;
            }
        }
        return index;
    }

    public int linearSearch(int target){
        this.target = target;
        int index=-1;
        for (int i = 0; i < size-1; i++){
            if (this.target==myData[i]){
                index=i;
            }
        }
        return index;
    }
}

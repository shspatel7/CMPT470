package AlgorithmPartC;

public class Insert {
    private int[] myData;
    private int size;
    private int key;

    public Insert(int[] data, int size, int key) {
        this.myData = data;
        this.size = size;
        this.key = key;
    }

    public void insert(int key){
        this.key = key;
        int i;
        for ( i = size-1; i >0; i--){
            if (myData[i]>this.key){
                myData[i+1]=myData[i];
            }
            else{

                break;
            }
        }
        myData[i+1]=this.key;
        size++;
    }
}

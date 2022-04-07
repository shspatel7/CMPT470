package Algorithm;

public class MoreSizeAlgorithm extends Algorithm {
    public MoreSizeAlgorithm(int n) {
        super(n);
    }

	public int runAlgorithm (int key, int target) {
		int index=-1;
		sort();
		insert(key);
		index = search(target);
		return index;
	}
    
    public void sort(){
        sort(myData, size);
    }

    private void sort(int[] a, int n) {
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
		sort(l, mid);
		sort(r, n - mid);

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

    public int search( int[] sortedArray, int key, int low, int high) {
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

    public int search(int target) {
        return search(myData, target, 0, size-1);
    }    
}
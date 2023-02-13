package sort;

class Sort3 {

	int partition(int arr[], int begin, int end) {
		int temp;
		int pivot = (begin + end) / 2;
		int L = begin;
		int R = end;

		while (L < R) {

			while (arr[L] < arr[pivot] && L < R)
				L++;

			while (arr[R] >= arr[pivot] && L < R)
				R--;

			if (L < R) { // L의 원소와 R의 원소 교환
				temp = arr[L];
				arr[L] = arr[R];
				arr[R] = temp;
			}
		}
		temp = arr[pivot]; // R의 원소와 피봇 원소 교환
		arr[pivot] = arr[R];
		arr[R] = temp;
		return L;
	}

	int partitionSelf(int arr[], int begin, int end) {
		int pivot, temp;
		pivot = (begin + end) / 2;

		int L = begin;
		int R = end;

		while (L < R) {
			while (arr[L] > arr[pivot] && L < R)
				L++;
			while (arr[R] <= arr[pivot] && L < R)
				R--;

			if (arr[L] > arr[R]) {
				temp = arr[L];
				arr[L] = arr[R];
				arr[R] = temp;
			}

		}
		
		temp = arr[pivot];
		arr[pivot] = arr[L];
		arr[L] = temp;

		return L;
	}

	void quickSort(int arr[], int begin, int end) {
		if (begin < end) {
			int p;
			p = partitionSelf(arr, begin, end);

			quickSort(arr, begin, p - 1);
			quickSort(arr, p + 1, end);
		}

	}
}

public class ex11_3_quick {

	public static void main(String[] args) {
		int arr[] = { 69, 10, 30, 2, 16, 8, 31, 22 };
		Sort3 S = new Sort3();

		System.out.printf("\n정렬할 원소 : ");
		for (int i = 0; i < arr.length; i++)
			System.out.printf(" %d", arr[i]);
		System.out.println();
		S.quickSort(arr, 0, arr.length - 1);

		for (int k = 0; k < arr.length; k++)
			System.out.printf("%3d ", arr[k]);
	}

}

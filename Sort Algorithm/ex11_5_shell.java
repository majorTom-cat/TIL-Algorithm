package sort;

class Sort5 {

	void intervalSort(int arr[], int begin, int end, int interval) {
		int i, j, temp;
		for (i = begin + interval; i <= end; i = i + interval) {
			temp = arr[i];
			for (j = i - interval; j >= begin && temp < arr[j]; j -= interval)
				arr[j + interval] = arr[j];
			arr[j + interval] = temp;
		}
	}

	void shellSort(int arr[], int size) {
		int i, j, interval, t = 0, temp;
		interval = size / 2;
		while (interval >= 1) {
			for (i = 0; i < interval; i++) {
				intervalSort(arr, i, size - 1, interval);
			}
			System.out.printf("\n셀정렬 %d 단계 : interval = %d >> ", ++t, interval);
			for (j = 0; j < size; j++)
				System.out.printf("%d  ", arr[j]);
			System.out.println();
			interval /= 2;
		}

	}
}

public class ex11_5_shell {

	public static void main(String[] args) {
		int arr[] = { 69, 10, 30, 2, 16, 8, 31, 22 };
		Sort5 S = new Sort5();

		System.out.printf("\n정렬할 원소 : ");
		for (int i = 0; i < arr.length; i++)
			System.out.printf(" %d", arr[i]);
		System.out.println();
		S.shellSort(arr, arr.length);

	}

}

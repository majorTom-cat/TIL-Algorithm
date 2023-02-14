package Algo;

class Sort5 {

	void intervalSort(int arr[], int i, int size, int interval) {
		int temp, h, j, p;
		h = i % interval;
		boolean move;
		for (p = h; p < size; p+=interval) {
			// while (interval <= j && j < size)
			if (p + interval >= size) // array의 size를 넘어가는 경우
				break;
			
			temp = arr[p + interval];
			j = p + interval;
			if (arr[j - interval] > temp)
				move = true;
			else
				move = false;
			while (move) { // 데이터 이동
				arr[j] = arr[j - interval];
				j = j - interval;

				if (j - interval <= 0) // array의 범위를 벗어날 경우
					break;
				if (j > 0 && arr[j - interval] > temp)
					move = true;
				else
					move = false;
			}
			arr[j] = temp;
		} // for 문의 끝
	}

	void shellSort(int arr[], int size) {
		int interval = size;
		int k, t = 0; // 단계 출력을 위해
		
		while (interval >= 1) {
			interval = interval / 2;
			for (int i = 0; i < interval; i++)
				intervalSort(arr, i, size, interval);

			System.out.printf("셸 정렬 %d 단계 (interval = %d) : ", ++t, interval);
			for (k = 0; k < size; k++) // 단계별 수행 결과 출력
				System.out.printf("%d  ", arr[k]);
			System.out.println();

		}
	}
}

public class ex11_5_shellAnother {

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

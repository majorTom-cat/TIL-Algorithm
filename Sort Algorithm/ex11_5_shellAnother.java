package Algo;

class Sort5 {

	void intervalSort(int arr[], int i, int size, int interval) {
		int temp, h, j, k, p;
		h = i % interval;
		boolean move;
		for (p = h; p < size; p+=interval) {
			// while (interval <= j && j < size)
			if (p + interval >= size) 
				break;
			
			temp = arr[p + interval];
			j = p + interval;
			if (arr[j - interval] > temp)
				move = true;
			else
				move = false;
			while (move) {
				arr[j] = arr[j - interval];
				j = j - interval;

				if (j - interval <= 0)
					break;
				
				if (j > 0 && arr[j - interval] > temp)
					move = true;
				else
					move = false;
			}
			
			arr[j] = temp;
	
		}
		System.out.printf("단계 %d : ", i);
		for (k = 0; k < size; k++) // 단계별 수행 결과 출력
			System.out.printf("%d  ", arr[k]);
//		System.out.printf(", 바꾼 데이터 : %d", 0);
		System.out.println();
	}

	void shellSort(int arr[], int size) {
		int interval = size;

		while (interval >= 1) {
			interval = interval / 2;
			for (int i = 0; i < interval; i++)
				intervalSort(arr, i, size, interval);

			//			int temp, i, j, k;
			//			for (i = 1; i < size; i++) {
			//				temp = arr[i];
			//				for (j = i; j > 0 && (arr[j - 1] > temp); j--) { // 기존 배열의 내용을 계속 탐색중일때
			//					arr[j] = arr[j - 1];
			//				}
			//				arr[j] = temp; // j가 0이거나 a[j-1] <= temp(temp가 저장될 위치 확정) 일때 실행 
			//
			//				System.out.printf("단계 %d : ", i);
			//				for (k = 0; k < size; k++) // 단계별 수행 결과 출력
			//					System.out.printf("%d  ", arr[k]);
			//				System.out.printf(", 바꾼 데이터 : %d", temp);
			//				System.out.println();
			//			}
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

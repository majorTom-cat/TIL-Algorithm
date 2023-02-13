package sort;

class Sort4 {

	void insertSort(int arr[], int n) {
		int temp, i, j, k;
				for (i = 1; i < n; i++) {
					temp = arr[i];
					j = i;
					if (arr[j - 1] > temp) {
						while ((j -1) >= 0 && arr[j - 1] > temp) {
							arr[j] = arr[j - 1];
							j = j - 1;
							if (i <= 0) break;
						}
						arr[j] = temp;
					}
					
					System.out.printf("단계 %d : ", i);
					for(k = 0; k<n;k++) // 단계별 수행 결과 출력
						System.out.printf("%d  ", arr[k]);
					System.out.printf(", 바꾼 데이터 : %d", temp);
					System.out.println();
				}
		
		
//		boolean move;
//		for (i = 1; i < n; i++) {
//
//			temp = arr[i];
//			j = i;
//			if (arr[j - 1] > temp)
//				move = true;
//			else
//				move = false;
//			while (move) {
//				arr[j] = arr[j - 1];
//				j = j - 1;
//				if (j > 0 && arr[j - 1] > temp)
//					move = true;
//				else
//					move = false;
//			}
//			arr[j] = temp;
//		}

	}
}

public class ex11_4_insert {

	public static void main(String[] args) {
		int arr[] = { 69, 10, 30, 2, 16, 8, 31, 22 };
		Sort4 S = new Sort4();

		System.out.printf("\n정렬할 원소 : ");
		for (int i = 0; i < arr.length; i++)
			System.out.printf(" %d", arr[i]);
		System.out.println();
		S.insertSort(arr, arr.length);

	}

}

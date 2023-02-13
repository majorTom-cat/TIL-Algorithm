package sort;

class Sort {

	public void selectionSort(int arr[]) {
		int i,j,k;

		for (i = 0; i < arr.length - 1; i++) {

			for (j = i + 1; j < arr.length; j++) { // j = i + 1 로 했어야 했음. not j = 1
				if (arr[i] > arr[j]) { // 부등호 방향에따라 오름차순 내림차순 가능
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;	
				}
				System.out.println();
				for (k=0; k<arr.length;k++) {
					System.out.printf("%3d ", arr[k]);
				}
				
			}
			System.out.printf("\n 선택 정렬 %d 단계 : ", i+1);
			for(j = 0; j<arr.length;j++)
				System.out.printf("%3d ", arr[j]);
			System.out.println();
			
		}
	}
}

public class ex11_1_select {

	public static void main(String[] args) {
		int arr[] = { 69, 10, 30, 20, 16, 8, 31, 22 };
		Sort S = new Sort();

		System.out.printf("\n정렬할 원소 : ");
		for (int i = 0; i < arr.length; i++)
			System.out.printf(" %d", arr[i]);
		System.out.println();
		S.selectionSort(arr);
		
	}

}

package sort;

class Sort2 {

	public void bubbleSort(int arr[]) {
		int i, j;

		for (i = 0; i < arr.length - 1; i++) {
			
			
			int flag = 0;
			
			for (j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					
					flag = 1;
				}
			}
			
			if (flag == 0) // bubble 정렬이 갖고있는 특징중 하나
				break;
			
			System.out.printf("\n 선택 정렬 %d 단계 : ", i + 1);
			for (int k = 0; k < arr.length; k++) 
				System.out.printf("%3d ", arr[k]);
			
			
		}
	}
}

public class ex11_2_bubble {

	public static void main(String[] args) {
		int arr[] = { 69, 10, 30, 2, 16, 8, 31, 22 };
		Sort2 S = new Sort2();

		System.out.printf("\n정렬할 원소 : ");
		for (int i = 0; i < arr.length; i++)
			System.out.printf(" %d", arr[i]);
		System.out.println();
		S.bubbleSort(arr);
		
	}

}

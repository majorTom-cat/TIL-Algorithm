package sort;

class SortGPT {
    public void mergeSortGPT(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortGPT(arr, left, mid);
            mergeSortGPT(arr, mid + 1, right);
            mergeGPT(arr, left, mid, right);
        }
    }

    private void mergeGPT(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}


class Sort6 {

	private int sorted[] = new int[8];

	void merge(int arr[], int begin, int middle, int end) {
		int size = arr.length;
		int i, j, k, t;
		i = begin;
		j = middle + 1;
		k = begin;
		while (i <= middle && j <=end) { // 양쪽의 데이터 어느쪽을 처리할지
			if (arr[i]<= arr[j]) // i 는 왼쪽 j 는 오른쪽
				sorted[k]= arr[i++]; // 왼쪽
			else 
				sorted[k]= arr[j++]; // 오른쪽
			k++;
		}
		
		// 남아있는 데이터를 어떻게 처리할때
		if(i>middle) { // 왼쪽이 먼저 머지가 끝났을때
			for(t=j; t<=end; t++, k++)
				sorted[k]= arr[t];
		}
		else { // 오른쪽이 먼저 머지가 끝났을때
			for(t=i; t<=middle; t++, k++)
				sorted[k] = arr[t]; 
		}
		for (t=begin; t<=end;t++) // 단계별 정렬 결과 저장
			arr[t]= sorted[t]; 
		System.out.printf("\n 병합 정렬 >> ");
		for(t=0; t<size; t++)
			System.out.printf("%3d ", arr[t]);
	}

	void mergeSort(int arr[], int begin, int end) { // 이 구조를 이해하는것이 핵심. 호출이 어떻게 되는가
		int middle;
		if (begin < end) {
			middle = (begin + end) / 2;
			mergeSort(arr, begin, middle); // 분할된 영역의 왼쪽
			mergeSort(arr, middle + 1, end); // 분할된 영역의 오른쪽
			merge(arr, begin, middle, end);
		}
	}
}

public class ex11_6_merge {

	public static void main(String[] args) {
		int arr[] = { 69, 10, 30, 2, 16, 8, 31, 22 };
		int size = arr.length;
		Sort6 S = new Sort6();

		System.out.printf("\n정렬할 원소 : ");
		for (int i = 0; i < arr.length; i++)
			System.out.printf(" %d", arr[i]);
		System.out.println();
		S.mergeSort(arr, 0, size - 1);

	}

}

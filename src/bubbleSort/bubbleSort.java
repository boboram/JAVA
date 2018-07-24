package bubbleSort;

/**
 * 버블 정렬
 * 하나씩 비교하여 큰 값(혹은 작은값 -- 오름차순인 경우)이면 교환
 * 마지막 인덱스값부터 값이 정해짐
 * */
public class bubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numAry[] = {1, 5, 7, 4, 2, 3, 6};
		int numAryDesc[] = {1, 5, 7, 4, 2, 3, 6};
		
		//오름차순
		System.out.println("==으름차순==\n");
		for(int i=0; i<numAry.length-1; i++) {
			int temp = 0;
			for(int j=0; j<(numAry.length-(i+1)); j++) {
				if(numAry[j] >= numAry[j+1]) {
					temp = numAry[j];
					numAry[j] = numAry[j+1];
					numAry[j+1] = temp;
				}
			}
		}
		
		for(int i=0; i<numAry.length; i++) {
			System.out.println(numAry[i]);
		}
		
		//내림차순
		System.out.println("\n==내림차순==\n");
		for(int i=0; i<numAryDesc.length-1; i++) {
			int temp = 0;
			for(int j=0; j<(numAryDesc.length-(i+1)); j++) {
				if(numAryDesc[j] <= numAryDesc[j+1]) {
					temp = numAryDesc[j];
					numAryDesc[j] = numAryDesc[j+1];
					numAryDesc[j+1] = temp;
				}
			}
		}
		
		for(int i=0; i<numAryDesc.length; i++) {
			System.out.println(numAryDesc[i]);
		}
	}

}

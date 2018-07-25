package insertSort;

/**
 * 삽입 정렬
 * 인덱스 값과 인덱스 -1의 값을 비교하여 인덱스값이 더 작은경우 인덱스 -1 자리에 인덱스 값을 넣고 인덱스 -1자리 이후부터 인덱스 값까지 한칸씩 밀리는 정렬 방식
 **/
public class insertSort {

	public static void main(String[] args) {
		int numberArray[] = { 5, 1, 6, 4, 2, 3 };
		
		for(int i=1; i<numberArray.length; i++) {
			
			if(numberArray[i-1] < numberArray[i]) continue;
			
			int temp = numberArray[i];
			
			for(int j=0; j<i; j++) {
				
				if(numberArray[j] > temp) {
					
					/*
					 * 배열값이 1 5 6 4 2 3 이고,
					 * i칸에 있는 값이 4라면
					 * 5가 있는 칸에 4가 들어가고
					 * 5와 6은 오른쪽으로 한칸씩 밀린다.(for문으로)
					 * 이를 ++로하게 되면 오른쪽 값이 먼저 바뀌게 되기 때문에 --로 구현한다.
					 * 4가 있던 자리부터 본인보다 한칸 왼쪽에 있는 값을 가져온다.
					 * */
					for(int k=i; k>=j+1; k--) { //찾은 큰값 전까지 배열 값 오른쪽으로 한칸씩 옮기기
						//작은값인 i부터 찾은 큰 값보다 한칸 큰곳까지 내려가면 윗칸에 아래칸 값을 넣는다.
						numberArray[k] = numberArray[k-1];
					}
					numberArray[j] = temp;
					break;
				}
			}
		}
		
		for(int i=0; i<numberArray.length; i++) {
			System.out.print(numberArray[i] + "\t");
		}

	}

}

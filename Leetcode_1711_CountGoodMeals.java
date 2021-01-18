package leetcode;

import java.util.*;

public class Leetcode_1711_CountGoodMeals {

	int mod = 1000000007;
    public int countPairs(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        long res = 0; // 총 카운트 갯수
        for (int num : arr) { // 음식에 대한 루프
            int power = 1; // 2의 제곱수의 시작
            for (int i = 0; i < 22; i++) { // 최대 제곱 인자는 21
                res += map.getOrDefault(power - num, 0); // y = 2^z - x 에서 y = power - num 이 된다. 이 값이 있으면 갯수를, 없으면 0을 더해준다.
                res %= mod;
                power *= 2; // 2를 계속 곱해준다.
            }
            map.put(num, map.getOrDefault(num, 0) + 1); // 맵에 저장하는 것은 해당 음식을 키로 했을 때 갯수
        }
        return (int) res;
    }
	
    	// 1,3,5,7,9
 		// 2^0부터 2^21까지 돌면서 해당 음식 맛을 뺏을 때의 값이 맵에 있는 지 찾는다. 처음에는 없으니까 모두 패스
 		// (1,1)이 들어감
 		
 		// 3 차례
 		// 마찬가지로 돌면서 값에서 3을 뻇을 때 값이 맵에 있는 지 찾는다. 2^2 - 3=1이고, 1이 이미 저장되어 있으니까 현재까지 1의 갯수인 1을 더해준다.
 		// 나머지는 없다.
 		// (3, 1)이 들어간다.
 		
 		// 5 차례
 		// 5를 뺏을 때 값이 맵에 있는지 찾는다. 2^3 - 5 = 3이고, 3이 이미 저장되어 있으니까 현재까지 3으로 만들어지는 조합의 갯수인 1을 더해준다.
 		// 나머지는 없다.
 		// (5,1)이 들어간다.
 		
 		// 7 차례
 		// 7을 뺏을 때 값이 맵에 있는 지 찾는다. 2^3 - 7 = 1이고, 1이 이미 저장되어 있으니까 현재까지 1의 갯수인 1을 더해준다
 		// 나머지는 없다.
 		// (7,1)이 들어간다.
 		
 		// 9 차례
 		// 9를 뺏을 때 값이 맵에 있는 지 찾는다. 2^4 - 9 = 7이고, 7이 이미 저장되어 있으니까 현재까지 7의 갯수인 1을 더해준다.
 		// 나머지는 없다.
 		// (9,1)이 들어간다.

    	// 결과값은 4
}

package fb;

import java.util.HashMap;
import java.util.Map;

public class TaskScheduler123 {

	public int taskWithCoolDown(int[] arr, int coolDown) {
		int res = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0 ; i < arr.length; i++) {
			res++;
			if(map.containsKey(arr[i])) {
				if(res > map.get(arr[i]) + coolDown) {
					map.put(arr[i], res);
				} else {
					res = map.get(arr[i]) + coolDown + 1;
					map.put(arr[i], res);
				}
			} else {
				map.put(arr[i], res);
			}
		}
		return res;
	}
	
	public String taskWithCoolDown2(int[] arr, int coolDown) {
		int res = 0;
		Map<Integer, Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		for(int x : arr) {
			res++;
			if(map.containsKey(x)) {
				if(res > map.get(x) + coolDown) {
					sb.append(x);
					map.put(x, res);
				} else {
					while(res <= map.get(x) + coolDown) {
						sb.append("_");
						res++;
					}
					sb.append(x);
					map.put(x, res);
				}
			} else {
				sb.append(x);
				map.put(x, res);
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		TaskScheduler123 x = new TaskScheduler123();
		int[] arr = {1,2,1,1,1,1,1,1,1,1,2,3,3,4};
		System.out.println(x.taskWithCoolDown2(arr, 2));
	}
}

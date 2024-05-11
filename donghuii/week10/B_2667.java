package P2024_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B_2667 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.valueOf(bufferedReader.readLine());
		int[][] app = new int[n][n];
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String[] parses = bufferedReader.readLine().split("");
			for (int j = 0; j < n; j++) {
				app[i][j] = Integer.parseInt(parses[j]);
				if (app[i][j] == 1) {
					list.add(new int[] {i, j});
				}
			}
		}

		for (int[] a : list) {
			System.out.println(Arrays.toString(a));
		}
		int value = 0;
		int count = 0;
		while (true) {
			int a = list.get(0)[0];
			int b = list.get(0)[1];
			for (int j = 1; j < list.size(); j++) {
				if (a + 1 == list.get(j)[0] || b + 1 == list.get(j)[1]) {
					count++;
					list.remove(j);
				} else {
					value++;
					break;
				}
			}
			if (list.isEmpty()) {
				break;
			}
		}
		System.out.println("00" + list);
		bufferedReader.close();
	}

	private static void getApp(int[][] app) {

	}
}

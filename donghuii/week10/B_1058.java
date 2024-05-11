package P2024_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class B_1058 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bufferedReader.readLine());
		String[] arr = new String[n];
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr[i] = bufferedReader.readLine();
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i].charAt(j) == 'Y') {
					list.add(new int[] {i, j});
				}
			}
		}

		Set<Integer> set = new HashSet<>();
		set.add(list.get(0)[0]);
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = 0; j < list.size() - 1; j++) {

				if (list.get(i)[1] == list.get(j + 1)[0]) {
					set.add(list.get(j + 1)[0]);
				}
			}
		}

		System.out.println("set" + set);

		for (int[] a : list) {
			System.out.println(Arrays.toString(a));
		}
		bufferedReader.close();
	}
}

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ShortestPathSolution {

	public static void main(String[] args) {
		String path = "C:\\Users\\kalra.himanshu\\Desktop\\PathFinding\\map.txt";
		Character[][] arr = null;
		// int[][] arr1 = null;
		
		int si = -1, sj = -1, di = -1, dj = -1;
		try {

			arr = Files.lines(Paths.get(path)).map(line -> {
				Character[] a = line.chars().filter(i -> (char) i != ' ').mapToObj(ch -> (char) ch)
						.toArray(Character[]::new);
				// System.out.println(Arrays.toString(a));
				return a;
			}).toArray(Character[][]::new);

			// System.out.println(arr.length +":"+ arr[0].length);
			int[][] blocked = new int[Integer.MAX_VALUE/2000000][Integer.MAX_VALUE/20000000];
			int c=0;
			for (int i = 0; i < arr.length; ++i) {
				for (int j = 0; j < arr[i].length; ++j) {
					if (arr[i][j] == 'S') {
						si = i;
						sj = j;
					} else if (arr[i][j] == 'E') {
						di = i;
						dj = j;
					}
					else if(arr[i][j]=='W') {
						blocked[c][0] =i;
						blocked[c][1] =j;
						++c;
					}
						
					System.out.print(arr[i][j] + " ");

				}
				System.out.println("");
			}
			
			
			
			AStar.test(1, arr.length, arr[0].length, si, sj, di, dj, blocked);
			
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}

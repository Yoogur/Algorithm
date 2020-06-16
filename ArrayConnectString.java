package algorithm;

import java.util.*;

public class ArrayConnectString {
  static int num = 0;

  public static void main(String[] args) {
    char[][] c = {
            {'a', 'p', 'c', 'd', 'h', 'x'},
            {'i', 'p', 'p', 'a', 'd', 'b'},
            {'e', 'l', 'p', 'a', 'd', 'b'},
            {'e', 'l', 'c', 'a', 'd', 'b'}};
    String str = "apple";
    Map<Character, Set<Integer[]>> map = new HashMap<>();
    for (int i = 0; i < c.length; i++) {
      for (int j = 0; j < c[0].length; j++) {
        if (!map.containsKey(c[i][j])) {
          map.put(c[i][j], new HashSet<>());
        }
        map.get(c[i][j]).add(new Integer[]{i, j});
      }
    }
    findnext(map, 0, str, null);
    System.out.println(num);
  }

  public static void findnext(Map<Character, Set<Integer[]>> map, int index, String str, Integer[] lastSite) {
    for (Integer[] i : map.get(str.charAt(index))) {
      if (i == lastSite) {
        continue;
      }
      if (lastSite == null || i[0] >= lastSite[0] - 1 && i[0] <= lastSite[0] + 1 && i[1] >= lastSite[1] - 1 && i[1] <= lastSite[1] + 1) {
        System.out.println(str.charAt(index)+"-->"+ Arrays.toString(i));
        if(index==str.length()-1){
          num++;
          continue;
        }
        findnext(map, index + 1, str, i);
      }
    }
  }
}

package string;

/**
 * Created by ksama on 1/23/16.
 */
public class EditDistanceFinder {

  public int minDistance(String word1, String word2) {
    int[] d = new int[word2.length() + 1];
    for (int i = 0; i <= word2.length(); ++i) d[i] = i;
    for (int i = 1; i <= word1.length(); ++i) {
      int prev = d[0];
      d[0] = i;
      for (int j = 1; j <= word2.length(); ++j) {
        int tmp = d[j];
        d[j] = Math.min(d[j - 1], d[j]) + 1;
        d[j] = Math.min(d[j], prev + (word1.charAt(i -1) == word2.charAt(j - 1) ? 0: 1));
        prev = tmp;
      }
    }
    return d[word2.length()];
  }

  public static void main(String[] args){
    System.out.println(new EditDistanceFinder().minDistance("hjfdajs","shjfdah"));
  }
}

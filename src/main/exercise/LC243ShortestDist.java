package exercise;

public class LC243ShortestDist {

    public static int shortestDistance(String[] wordsDict, String word1, String word2) {
        int minDist = Integer.MAX_VALUE;
        int i1 = -1;
        int i2 = -1;

        for (int i = 0; i< wordsDict.length; i++) {
            String currWord = wordsDict[i];
            if (currWord.equals(word1)) {
                i1 = i;
            } else if (currWord.equals(word2)) {
                i2 = i;
            }
            if (i1 != -1 && i2 != -1) {
                minDist = Math.min(minDist, Math.abs(i1 - i2));
            }
        }
        return minDist;
    }

    public static void main(String[] args) {
        String[] wordsDict = new String[] {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "coding";
        String word2 = "practice";
        int res = LC243ShortestDist.shortestDistance(wordsDict, word1, word2);
        System.out.println(res);
    }
}

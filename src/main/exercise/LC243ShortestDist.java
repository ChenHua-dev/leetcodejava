package exercise;

public class LC243ShortestDist {

    public static int shortestDistance(String[] wordsDict, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int shortest = Integer.MAX_VALUE;

        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                index1 = i;
            } else if (wordsDict[i].equals(word2)) {
                index2 = i;
            }

            if (index1 != -1 && index2 != -1) {
                shortest = Math.min(shortest, Math.abs(index1 - index2));
            }
        }
        return shortest;
    }

    public static void main(String[] args) {
        String[] wordsDict = new String[] {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "coding";
        String word2 = "practice";
        int res = LC243ShortestDist.shortestDistance(wordsDict, word1, word2);
        System.out.println(res);
    }
}

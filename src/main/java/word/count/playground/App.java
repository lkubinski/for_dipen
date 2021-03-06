/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package word.count.playground;

import word.count.WordCountRemoveCharacters;
import word.count.WordCountWordBoundary;

import java.io.IOException;
import java.util.Map;

public class App {
    private static final String file = "src/main/resources/shakespeare.txt";

    public static void main(String[] args) throws IOException {
        Map<String, Long> wordCountMap;

        WordCountWordBoundary wordCountWordBoundary = new WordCountWordBoundary();
        WordCountRemoveCharacters wc = new WordCountRemoveCharacters();

        long time = System.nanoTime();
        try {
            wordCountMap = wordCountWordBoundary.wordCount(file);
        } finally {
            System.out.printf("WordCountWordBoundary solution: time = %dms%n", (System.nanoTime() - time) / 1_000_000);
        }

//        wordCountMap.forEach((k,v) -> System.out.printf("%s -> %s %n", k, v));

        time = System.nanoTime();
        try {
            wordCountMap = wc.wordCount(file);
        } finally {
            System.out.printf("WordCountRemoveCharacters solution: time = %dms%n", (System.nanoTime() - time) / 1_000_000);
        }


//        wordCountMap.forEach((k,v) -> System.out.printf("%s -> %s %n", k, v));
    }
}

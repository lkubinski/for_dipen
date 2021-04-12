package word.count;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

public class WordCountRemoveCharacters {
    private static String unnecessaryCharactersReg = "[0-9.,!:%\\(\\)\\[\\]\\{\\}]";

    public Map<String, Long> wordCount(String file) throws IOException {
//        String allText = new String(
//                Files.readAllBytes(Paths.get(file)), StandardCharsets.UTF_8);

        String allText = Files.readString(Paths.get(file));

        String withoutUnnecessaryCh = allText.replaceAll(unnecessaryCharactersReg, " ");
        String[] split = withoutUnnecessaryCh.split("\\s+");
        Map<String, Long> unsortedMap = Arrays.stream(split)
                .map(String::toLowerCase)
                .collect(groupingBy(Function.identity(), counting()));

        return unsortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.<String,Long>comparingByValue().reversed())
                //.limit(10)
                .collect(toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
    }
}

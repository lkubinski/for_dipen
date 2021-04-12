package word.count;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static word.count.utils.PredicateUtils.Not;

public class WordCountWordBoundary {

    public Map<String, Long> wordCountRegex(String file) throws IOException {
        Stream<String> lines = Files.lines(Paths.get(file));

        Map<String, Long> collect = lines
                .map(String::toLowerCase)
                .map(s -> s.replaceAll("[0-9_]+", " "))
                .map(s -> s.split("\\W"))
                .flatMap(Stream::of)
                .filter(Not(String::isBlank))
                .collect(groupingBy(Function.identity(), counting()));

        LinkedHashMap<String, Long> sortedWords = collect.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        return sortedWords;
    }
}

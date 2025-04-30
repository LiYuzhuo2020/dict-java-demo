package com.wordMatch;

import com.wordMatch.dict.CompositeDictionary;
import com.wordMatch.dict.Dictionary;
import com.wordMatch.dict.MyDictionary;
import com.wordMatch.dict.UserDictionary;
import com.wordMatch.service.WordMatchService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author rainly
 */
public class Main {
    public static void main(String[] args) {
        String input = "likesamsungmobile";
        int stage = 1;
        Set<String> customDict = new HashSet<>();

        // 根据阶段选择字典
        Dictionary dictionary = buildDictionary(stage, customDict);
        WordMatchService service = new WordMatchService(dictionary);

        List<String> results = service.breakSentence(input);
        results.forEach(System.out::println);
    }

    private static Dictionary buildDictionary(int stage, Set<String> customDict) {
        switch (stage) {
            case 1:
                return new MyDictionary();
            case 2:
                return new UserDictionary(customDict);
            case 3:
                return new CompositeDictionary(List.of(
                        new MyDictionary(),
                        new UserDictionary(customDict)
                ));
            default:
                throw new IllegalArgumentException("Invalid stage");
        }
    }
}

package com.wordMatch.service;

import com.wordMatch.dict.Dictionary;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rainly
 */
public class WordMatchService {

    private final Dictionary dictionary;

    public WordMatchService(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public List<String> breakSentence(String input) {
        List<List<String>> allPaths = new ArrayList<>();
        backtrack(input.toLowerCase(), 0, new ArrayList<>(), allPaths);
        return formatResults(allPaths);
    }

    private void backtrack(String s, int start, List<String> path, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);
            if (dictionary.contains(word)) {
                path.add(word);
                backtrack(s, end, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    private List<String> formatResults(List<List<String>> wordBreaks) {
        List<String> results = new ArrayList<>();
        for (List<String> words : wordBreaks) {
            if (!words.isEmpty()) {
                String sentence = String.join(" ", words);
                sentence = sentence.substring(0, 1) + sentence.substring(1);
                results.add(sentence);
            }
        }
        return results;
    }
}

package com.wordMatch.dict;

import java.util.Set;

/**
 * @author rainly
 */
public class MyDictionary implements Dictionary{
    private final Set<String> words = Set.of(
            "i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "man", "go"
    );

    @Override
    public boolean contains(String word) {
        return words.contains(word.toLowerCase());
    }
}

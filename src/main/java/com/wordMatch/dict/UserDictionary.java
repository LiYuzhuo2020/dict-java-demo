package com.wordMatch.dict;

import java.util.Set;

/**
 * @author rainly
 */
public class UserDictionary implements Dictionary{
    private final Set<String> words;

    public UserDictionary(Set<String> words) {
        this.words = words;
    }

    @Override
    public boolean contains(String word) {
        return words.contains(word.toLowerCase());
    }
}

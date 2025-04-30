package com.wordMatch.dict;

import java.util.List;

/**
 * @author rainly
 */
public class CompositeDictionary implements Dictionary{
    private final List<Dictionary> dictionaries;

    public CompositeDictionary(List<Dictionary> dictionaries) {
        this.dictionaries = dictionaries;
    }

    @Override
    public boolean contains(String word) {
        return dictionaries.stream()
                .anyMatch(dict -> dict.contains(word));
    }
}

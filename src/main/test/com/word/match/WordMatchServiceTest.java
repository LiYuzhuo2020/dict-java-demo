package com.word.match;

import com.wordMatch.dict.Dictionary;
import com.wordMatch.dict.MyDictionary;
import com.wordMatch.dict.UserDictionary;
import com.wordMatch.service.WordMatchService;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static junit.framework.Assert.assertTrue;

public class WordMatchServiceTest {

    @Test
    void testStage1() {
        WordMatchService service = new WordMatchService(new MyDictionary());
        List<String> results = service.breakSentence("likesamsungmobile");
        assertTrue("failed to break the sentence!",results.contains("like sam sung mobile"));
    }

    @Test
    void testStage2() {
        Dictionary userDict = new UserDictionary(Set.of("samsung"));
        WordMatchService service = new WordMatchService(userDict);
        List<String> results = service.breakSentence("samsungmobile");
        assertTrue(results.contains("Samsung mobile"));
    }
}

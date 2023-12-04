package Task1;

import java.util.HashMap;

public class Dictionary {
    private HashMap<String, String> dictionary;

    public Dictionary() {
        dictionary = new HashMap<>();
        addWord("Agrin", "The Best student.");
        addWord("Car", "An engine that moves with tires");
    }

    public void addWord(String word, String meaning) {
        dictionary.put(word.toLowerCase(), meaning);
    }

    public String searchWord(String word) {
        return dictionary.getOrDefault(word.toLowerCase(), "Word not found in the dictionary.");
    }
}


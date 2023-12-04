package Task1;

public class DictionaryController {
    private Task1.Dictionary dictionary;

    public DictionaryController(Task1.Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public String searchWord(String word) {
        if (word.isEmpty()) {
            return "Please enter a word.";
        }

        return dictionary.searchWord(word);
    }
    public static void main(String[]args) {
        Task1.DictionaryView.launch(Task1.DictionaryView.class, args);
    }

}


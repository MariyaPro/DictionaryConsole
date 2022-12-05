package dictionaryapp.dictionaries;

import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;

public class DictionaryNumbers extends DictionaryFile {
    public DictionaryNumbers(Path dictionarySource) {
        super(dictionarySource);
    }

    @Override
    boolean isValidWord(@NotNull String word) {
        int length = 5;
        if (word.length() != length) return false;
        for (int i = 0; i < length; i++) {
            char c = word.charAt(i);
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
}

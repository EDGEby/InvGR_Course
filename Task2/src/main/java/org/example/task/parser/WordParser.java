package org.example.task.parser;

import org.example.task.component.TextComponent;
import org.example.task.component.TextComponentType;
import org.example.task.component.TextComposite;

public class WordParser extends AbstractTextParser{

    @Override
    public TextComponent parse(String text) {

        if (!text.matches(TextRegexPattern.WORD_DELIMETER)) {
            return getNextParser().parse(text);
        }

        TextComposite wordComposite = new TextComposite(TextComponentType.WORD);

        for (char c : text.toCharArray()) {
            wordComposite.addComponent(getNextParser().parse(String.valueOf(c)));
        }

        return wordComposite;
    }
}

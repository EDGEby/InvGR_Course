package org.example.task.parser;

import org.example.task.component.TextComponent;
import org.example.task.component.TextComponentType;
import org.example.task.component.TextComposite;

public class PunctuationParser extends AbstractTextParser{

    @Override
    public TextComponent parse(String text) {
        TextComposite punctuationComposite = new TextComposite(TextComponentType.PUNCTUATION);

        for (char c : text.toCharArray()) {
            punctuationComposite.addComponent(getNextParser().parse(String.valueOf(c)));
        }

        return punctuationComposite;
    }
}

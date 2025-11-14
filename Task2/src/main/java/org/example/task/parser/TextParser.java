package org.example.task.parser;

import org.example.task.component.TextComponent;
import org.example.task.component.TextComponentType;
import org.example.task.component.TextComposite;

public class TextParser extends AbstractTextParser{

    @Override
    public TextComponent parse(String text) {
        TextComposite textComposite = new TextComposite(TextComponentType.TEXT);

        String[] paragraphs = text.strip().split(TextRegexPattern.PARAGRAPH_DELIMITER);

        for (String paragraph : paragraphs) {
            textComposite.addComponent(getNextParser().parse(paragraph));
        }

        return textComposite;

    }
}

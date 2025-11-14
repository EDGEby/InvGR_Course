package org.example.task.parser;

import org.example.task.component.TextComponent;
import org.example.task.component.TextComponentType;
import org.example.task.component.TextComposite;

public class SentenceParser extends AbstractTextParser{

    @Override
    public TextComponent parse(String text) {
        TextComposite sentenceComposite = new TextComposite(TextComponentType.SENTENCE);

        String[] sentences = text.split(TextRegexPattern.LEXEME_DELIMETER);

        for(String sentence : sentences) {
            sentenceComposite.addComponent(getNextParser().parse(sentence.trim()));
        }
        return sentenceComposite;
    }
}

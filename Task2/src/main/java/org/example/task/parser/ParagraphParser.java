package org.example.task.parser;

import org.example.task.component.TextComponent;
import org.example.task.component.TextComponentType;
import org.example.task.component.TextComposite;

public class ParagraphParser extends AbstractTextParser {

    @Override
    public TextComponent parse(String text) {
        TextComposite paragraphComposite = new TextComposite(TextComponentType.PARAGRAPH);

        String[] paragraphs = text.split(TextRegexPattern.SENTENCE_DELIMETER);

        for(String paragraph : paragraphs) {
            paragraphComposite.addComponent(getNextParser().parse(paragraph));
        }
        return paragraphComposite;
    }
}

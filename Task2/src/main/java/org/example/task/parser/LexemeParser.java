package org.example.task.parser;

import org.example.task.component.TextComponent;
import org.example.task.component.TextComponentType;
import org.example.task.component.TextComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser extends AbstractTextParser {

    @Override
    public TextComponent parse(String text) {
        TextComposite lexemeComposite = new TextComposite(TextComponentType.LEXEME);

        Matcher m = Pattern.compile(TextRegexPattern.WORD_OR_PUNCT_DELIMETER).matcher(text);

        while (m.find()) {
            String token = m.group();

            lexemeComposite.addComponent(getNextParser().parse(token));
        }
        return  lexemeComposite;
    }
}

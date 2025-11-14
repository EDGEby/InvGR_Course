package org.example.task.parser;

import org.example.task.component.TextComponent;
import org.example.task.component.TextComponentType;
import org.example.task.component.TextLeaf;

public class SymbolParser extends AbstractTextParser {

    @Override
    public TextComponent parse(String text) {
        return new TextLeaf(text.charAt(0), TextComponentType.SYMBOL);
    }
}

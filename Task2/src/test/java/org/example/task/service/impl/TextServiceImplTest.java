package org.example.task.service.impl;

import org.example.task.component.TextComponentType;
import org.example.task.component.TextComposite;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceImplTest {

    private TextServiceImpl textService;

    private TextComposite parph1;
    private TextComposite parph2;

    @BeforeEach
    void setUp() {
        textService = new TextServiceImpl();

        TextComposite word1 = new TextComposite(TextComponentType.WORD) {
            @Override
            public String toString() {
                return "Hello";
            }
        };
        TextComposite word2 = new TextComposite(TextComponentType.WORD) {
            @Override
            public String toString() {
                return "world";
            }
        };
        TextComposite word3 = new TextComposite(TextComponentType.WORD) {
            @Override
            public String toString() {
                return "Java";
            }
        };

        TextComposite lex1 = new TextComposite(TextComponentType.LEXEME);
        lex1.addComponent(word1);

        TextComposite lex2 = new TextComposite(TextComponentType.LEXEME);
        lex2.addComponent(word2);

        TextComposite lex3 = new TextComposite(TextComponentType.LEXEME);
        lex3.addComponent(word3);

        TextComposite sent1 = new TextComposite(TextComponentType.SENTENCE);
        sent1.addComponent(lex1);

        TextComposite sent2 = new TextComposite(TextComponentType.SENTENCE);
        sent2.addComponent(lex2);
        sent2.addComponent(lex3);

        parph1 = new TextComposite(TextComponentType.PARAGRAPH);
        parph1.addComponent(sent1);

        paragraph2 = new TextComposite(TextComponentType.PARAGRAPH);
        paragraph2.addComponent(sent2);
    }

    @Test
    void testSortByLexemeCount() {
        TextComposite text = new TextComposite(TextComponentType.TEXT);
        text.addComponent(parph1);
        text.addComponent(parph2);

        List<TextComposite> sorted = textService.sortByLexemeCount(text).stream()
                .map(c -> (TextComposite) c)
                .toList();

        assertEquals(1, sorted.get(0).getComponents().size());
        assertEquals(2, sorted.get(1).getComponents().size());
    }

    @Test
    void testMaxSentencesWithCommonWords() {
        TextComposite text = new TextComposite(TextComponentType.TEXT);
        text.addComponent(parph1);
        text.addComponent(parph2);

        int max = textService.maxSentencesWithCommonWords(text);
        assertEquals(1, max);
    }

    @Test
    void testSwapEdgeLexemes() {
        TextComposite text = new TextComposite(TextComponentType.TEXT);
        text.addComponent(parph1);
        text.addComponent(parph2);

        String firstLexBefore = ((TextComposite) parph2.getComponents().get(0)).getComponents().get(0).toString();
        assertEquals("world", firstLexBefore);

        textService.swapEdgeLexemes(text);

        String firstLexAfter = ((TextComposite) parph2.getComponents().get(0)).getComponents().get(0).toString();
        assertEquals("Java", firstLexAfter);
    }
}

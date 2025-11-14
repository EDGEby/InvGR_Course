package org.example.task.parser;

final class TextRegexPattern {
    static final String PARAGRAPH_DELIMITER = "(\\R{2,})";
    static final String SENTENCE_DELIMETER = "(?<=[.!?])\\s+";
    static final String LEXEME_DELIMETER = "\\s+";
    static final String WORD_OR_PUNCT_DELIMETER = "(\\p{L}+|\\p{Punct})";
    static final String WORD_DELIMETER = "\\p{L}+";

    private TextRegexPattern() {}
}

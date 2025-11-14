package org.example.task.service;

import org.example.task.component.TextComponent;
import org.example.task.component.TextComposite;

import java.util.List;

public interface TextService {

    public int maxSentencesWithCommonWords(TextComposite text);
    public List<TextComponent> sortByLexemeCount(TextComposite text);
    public void swapEdgeLexemes(TextComposite text);

}

package org.example.task.component;

import java.util.ArrayList;
import java.util.List;

public class TextComposite extends TextComponent{
    private static final String TABULATION = "\t";
    private static final String NEW_LINE = "\n";
    private static final String SPACE = " ";
    private ArrayList<TextComponent> components = new ArrayList<>();

    public TextComposite(TextComponentType textComponentType) {
        setComponentType(textComponentType);
    }

    public void addComponent(TextComponent textComponent) {
        components.add(textComponent);
    }
    public void removeComponent(TextComponent textComponent) {
        components.remove(textComponent);
    }


    public List<TextComponent> getComponents() {
        return components;
    }

    public void setComponents(List<TextComponent> newComponents) {
        this.components = new ArrayList<>(newComponents);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (TextComponent component : components) {

            if (getComponentType() == TextComponentType.PARAGRAPH) {
                sb.append(TABULATION);
            }
            sb.append(component.toString());

            if (getComponentType() == TextComponentType.PARAGRAPH) {
                sb.append(NEW_LINE);
            }

            if (getComponentType() == TextComponentType.SENTENCE) {
                sb.append(SPACE);
            }


        }
        return sb.toString().stripTrailing();
    }


}

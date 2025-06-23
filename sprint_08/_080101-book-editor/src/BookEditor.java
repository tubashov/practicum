import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookEditor {

    private HeaderDecorator headerDecorator;
    private List<LineProcessor> lineProcessors = new ArrayList<>();

    public static void main(String[] args) {
        BookEditor bookEditor = new BookEditor();

        // Заголовок: верхний регистр + перенос строки
        bookEditor.setHeaderDecorator(header -> header.toUpperCase() + "\n");

        // Строки: делаем первую букву заглавной
        bookEditor.addLineProcessor(line -> {
                    if (line.isEmpty()) {
                        return line;
                    }
                    return line.substring(0, 1).toUpperCase() + line.substring(1);
                }
        );

        // Строки: добавляем перенос строки в конец
        bookEditor.addLineProcessor(line -> line + "\n");

        List<String> content = Arrays.asList(
                "Приключения Java-программиста",
                "История началась рано утром, ",
                "когда программист вышел из дома, ",
                "решив выпить утренний кофе."
        );

        List<String> resultContent = bookEditor.processText(content);

        // Печать — как одна строка, чтобы отразить переносы
        for (String line : resultContent) {
            System.out.print(line); // .print вместо println
        }
    }


    public List<String> processText(List<String> sourceText) {
        List<String> resultText = new ArrayList<>();

        String sourceHeader = sourceText.get(0);
        String decoratedHeader = headerDecorator.decorate(sourceHeader);
        resultText.add(decoratedHeader);

        for (int i=1; i<sourceText.size(); i++) {
            String currentLine = sourceText.get(i);
            for (LineProcessor processor: lineProcessors) {
                currentLine = processor.processLine(currentLine);
            }
            resultText.add(currentLine);
        }

        return resultText;
    }

    public void setHeaderDecorator(HeaderDecorator headerDecorator) {
        this.headerDecorator = headerDecorator;
    }

    public void addLineProcessor(LineProcessor lineProcessor) {
        this.lineProcessors.add(lineProcessor);
    }
}

interface HeaderDecorator {
    String decorate(String header);
}

interface LineProcessor {
    String processLine(String line);
}
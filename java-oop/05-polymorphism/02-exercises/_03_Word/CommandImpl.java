package _03_Word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandImpl implements CommandInterface {

    private Map<String, TextTransform> commandTransforms;
    private StringBuilder text;

    public CommandImpl(StringBuilder text) {
        this.commandTransforms = new HashMap<>();
        this.text = text;
        // Напълни мапа с команди
        this.init();
    }

    // Този метод ми пълни мапа с текс трансформации, които поддържа CommandImpl
    @Override
    public void init() {
        this.commandTransforms.clear();
        for (Command p : this.initCommands()) {
            this.commandTransforms.putIfAbsent(p.getText(), p.getTextTransform());
        }
    }

    @Override
    public void handleInput(String input) {
        // cut 1 3
        String[] tokens = input.split("\\s+");

        String commandName = tokens[0];
        int startInd = Integer.parseInt(tokens[1]);
        int endInd = Integer.parseInt(tokens[2]);

        // от този мап ще взема TextTransform обекта и извикваме действието, което поддържа този TextTransform обект.
        this.commandTransforms.get(commandName).invokeOn(this.text, startInd, endInd);
    }

    // Създавам новите команди, които моето приложение ще поддържа
    protected List<Command> initCommands() {
        List<Command> commands = new ArrayList<>();
        CutTransform cutTransform = new CutTransform();
        commands.add(new Command("uppercase", new ToUpperTransform()));
        commands.add(new Command("cut", cutTransform));
        commands.add(new Command("paste", new PasteTransform(cutTransform)));
        return commands;
    }
}

package com.arsenii.task8;

import com.arsenii.task4.subtask2.Memento;
import com.arsenii.task4.subtask2.StatEnum;
import com.arsenii.task4.subtask2.Stats;
import com.arsenii.task6.character.Character;
import com.arsenii.task7.DataElement;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class CharacterController {
    private static int it = 0;
    private static String[] listData = new String[5];
    private final CharacterModel characterModel;
    private final GUI gui;

    public CharacterController(GUI gui) {
        characterModel = CharacterModel.getInstance();
        this.gui = gui;
    }

    public void generateStats() {
        Stats stats = Stats.generate();
        characterModel.setStats(stats);
        setStatFields(stats);
    }

    private void setStatFields(Stats stats) {
        gui.strengthTextField.setText(getStat(stats, StatEnum.STRENGTH));
        gui.dexterityTextField.setText(getStat(stats, StatEnum.DEXTERITY));
        gui.wisdomTextField.setText(getStat(stats, StatEnum.WISDOM));
        gui.charismaTextField.setText(getStat(stats, StatEnum.CHARISMA));
        gui.intellectTextField.setText(getStat(stats, StatEnum.INTELLECT));
        gui.constitutionTextField.setText(getStat(stats, StatEnum.CONSTITUTION));
    }

    private String getStat(Stats stats, StatEnum statEnum) {
        return Integer.toString(stats.getStatValue(statEnum));
    }

    public void saveMemento() {
        if (characterModel.getStats() != null) {
            characterModel.saveStats(new Memento(characterModel.getStats()));
            gui.infoTextArea.setText("Attributes were successfully saved!");
        } else {
            gui.infoTextArea.setText("Cannot save empty attributes");
        }
    }

    public void returnMemento() {
        setStatFields(characterModel.getLastSavedStats());
    }

    public void createCharacter() {
        if (it >= 5) {
            gui.infoTextArea.setText("You can create only 5 characters");
            return;
        }
        if (characterModel.getStats() == null) {
            gui.infoTextArea.setText("Cannot create character with empty attributes");
            return;
        }

        String name = gui.nameField.getText();
        String race = String.valueOf(gui.raceComboBox.getSelectedItem());
        String clazz = String.valueOf(gui.classComboBox.getSelectedItem());
        Character character = characterModel.createCharacter(name, race, clazz);
        character.setStats(characterModel.getStats());
        character.addRaceBonuses();
        characterModel.setCharacter(character);
        characterModel.addCharacterToList(character);
        String characterInfo = name + " - " + race + " - " + clazz;
        listData[it++] = characterInfo;
        gui.characterList.setListData(listData);
        gui.infoTextArea.setText("Character " + name + " was successfully created!");
        System.out.println(characterInfo);
        System.out.println(character.getCharacterType());
        character.getCharacterRace().print();
    }

    public void saveJSON(){
        String json = "[\n";
        List<Character> characters = characterModel.getCharacters();
        for (Character character : characters){
            json = json.concat(generateJSON(character));
            if(characters.indexOf(character) != characters.size() - 1){
                json = json.concat(",");
            }
            json = json.concat("\n");
        }
        json = json.concat("]");
        gui.JSONTextArea.setText(json);
        try (FileWriter fileWriter = new FileWriter("output.json")) {
            fileWriter.write(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void printSelectedCharacter(){
        Character character = characterModel.getCharacters().get(gui.characterList.getSelectedIndex());
        gui.infoTextArea.setText(generateJSON(character));
    }

    private String generateJSON(Character character){
        List<DataElement> dataElements = new ArrayList<>();
        dataElements.add(character);
        dataElements.add(character.getCharacterType());
        dataElements.add(character.getCharacterRace());

        JSONObject jsonObject = new JSONObject();
        dataElements.stream()
                .map(dataElement -> dataElement.access(characterModel.getDataElementVisitor()))
                .forEach(jsonObject::putAll);

        TreeMap<String, String> stats = character.getStats().access(characterModel.getDataElementVisitor());
        JSONObject statObject = new JSONObject(stats);
        jsonObject.put("Attributes", statObject);
        return jsonObject.toJSONString();
    }
}

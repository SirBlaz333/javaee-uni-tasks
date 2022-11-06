package com.arsenii.task8;

import com.arsenii.task6.character.Character;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private final CharacterController characterController;
    JTextField nameField;
    JComboBox<String> raceComboBox;
    JComboBox<String> classComboBox;
    private JPanel mainPanel;
    private JButton generateButton;
    JTextField strengthTextField;
    JTextField dexterityTextField;
    JTextField intellectTextField;
    JTextField constitutionTextField;
    JTextField wisdomTextField;
    JTextField charismaTextField;
    private JButton saveButton;
    private JButton returnButton;
    JList<String> characterList;
    private JButton saveJSONButton;
    JTextArea infoTextArea;
    private JButton createCharacterButton;
    JTextArea JSONTextArea;

    public GUI() {
        setTitle("DnD Character Creator");
        setContentPane(mainPanel);
        setSize(1000, 700);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        characterController = new CharacterController(this);
        generateButton.addActionListener(e -> characterController.generateStats());
        saveButton.addActionListener(e -> characterController.saveMemento());
        returnButton.addActionListener(e -> characterController.returnMemento());
        createCharacterButton.addActionListener(e -> characterController.createCharacter());
        saveJSONButton.addActionListener(e -> characterController.saveJSON());
        characterList.addListSelectionListener(e -> characterController.printSelectedCharacter());
        pack();
    }

    public static void main(String[] args) {
        new GUI();
    }
}

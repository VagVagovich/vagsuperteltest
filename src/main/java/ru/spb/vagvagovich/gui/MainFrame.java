package ru.spb.vagvagovich.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import ru.spb.vagvagovich.MainApplication;
import ru.spb.vagvagovich.model.Port;
import ru.spb.vagvagovich.utils.PortUtils;

/**
 * Основное окно приложения
 * @author VagVagovich
 */
public class MainFrame extends JFrame{
    
    /** Отступ между элементами */
    private static final int PAD = 5;
    
    /** Поле ввода массива строк */
    private final JTextArea inputTextArea = new JTextArea(10,50);
    /** Поле вывода последовательности чисел */
    private final JTextArea outputArraysArea = new JTextArea(2,50);
    /** Поле вывода перестановок массивов */
    private final JTextArea outputDecartArea = new JTextArea(10,50);
    /** Кнопка пересчета */
    private final JButton culcButton = new JButton("Рассчитать");
    
    /**
     * Создать основное окно
     */
    public MainFrame() {
        super();
        setTitle("Работа с массивом строк");
        
        createAndSetPanels();
        pack();
        setResizable(false);
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                MainApplication.close(MainFrame.this);
            }
        });
    }
    
    /**
     * Создать и задать панели окна
     */
    private void createAndSetPanels() {
        outputArraysArea.setEditable(false);
        outputArraysArea.setToolTipText("Последовательность всех чисел из массива");
        outputDecartArea.setEditable(false);
        outputDecartArea.setToolTipText("Декартово произведение чисел из массива");
        culcButton.addActionListener(e -> reculc());
        
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints(GridBagConstraints.RELATIVE, 0, 1, 1, 1.0, 1.0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(PAD, PAD, PAD, PAD), 0, 0);
        add(new JLabel("Ввод строк"), gbc);
        add(new JScrollPane(inputTextArea), gbc);
        gbc = new GridBagConstraints(GridBagConstraints.RELATIVE, 1, 1, 1, 1.0, 1.0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(PAD, PAD, PAD, PAD), 0, 0);
        add(new JLabel("Результаты:"), gbc);
        gbc = new GridBagConstraints(GridBagConstraints.RELATIVE, 2, 1, 1, 1.0, 1.0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(PAD, PAD, PAD, PAD), 0, 0);
        add(new JLabel("Последовательности"), gbc);
        add(new JScrollPane(outputArraysArea), gbc);
        gbc = new GridBagConstraints(GridBagConstraints.RELATIVE, 3, 1, 1, 1.0, 1.0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(PAD, PAD, PAD, PAD), 0, 0);
        add(new JLabel("Группы элементов"), gbc);
        add(new JScrollPane(outputDecartArea), gbc);
        gbc = new GridBagConstraints(1, 4, 1, 1, 1.0, 1.0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(PAD, PAD, PAD, PAD), 0, 0);
        add(culcButton, gbc);
    }
    
    /**
     * Пересчитать массивы и вывести результат
     */
    private void reculc() {
        Port port = Port.createPortFromString(inputTextArea.getText());
        outputArraysArea.setText(PortUtils.convertStringArraysToIntArray(port.getIndexes()).toString());
        outputDecartArea.setText(PortUtils.convertStringArraysUnicGroups(port.getIndexes()).toString());
    }

}

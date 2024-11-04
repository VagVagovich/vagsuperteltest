package ru.spb.vagvagovich.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import ru.spb.vagvagovich.MainApplication;

public class MainFrame extends JFrame{
    
    public MainFrame() {
        super();
        setTitle("Работа с массивом строк");
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                MainApplication.close(MainFrame.this);
            }
        });
    }

}

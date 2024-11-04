package ru.spb.vagvagovich;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ru.spb.vagvagovich.gui.ExitDialog;
import ru.spb.vagvagovich.gui.MainFrame;

/**
 * Само приложение
 */
public class MainApplication {

    /**
     * Стартовый метод приложения
     * @param args - аргуметны командной строки
     */
    public static void main(String[] args) {
        //Здесь можно поработать с аргументами при необходимости
        MainFrame mainWindow = new MainFrame();
        mainWindow.setVisible(true);
    }
    
    /**
     * Закрыть приложение
     * @param frame - компонент, вызывающий закрытие(для привязки к нему диалогов подтверждения)
     */
    public static void close(JFrame frame) {
        if (new ExitDialog(frame, "Завершить работу?",
                JOptionPane.INFORMATION_MESSAGE).isExit()) {
            exit();
        }
    }
    
    /**
     * Выход из ПК
     */
    private static void exit() {
        System.exit(0);
    }

}

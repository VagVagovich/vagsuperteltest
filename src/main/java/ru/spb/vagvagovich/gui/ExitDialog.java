package ru.spb.vagvagovich.gui;

import java.awt.Component;

import javax.swing.JOptionPane;

/**
 * Диалог закрытия приложения
 */
@SuppressWarnings("serial")
public class ExitDialog extends JOptionPane {

    /**
     * Настроить и отобразить диалог
     * 
     * @param component - родительский компонент
     * @param message - сообщение
     * @param style - стиль окна диалога
     */
    public ExitDialog(Component component, String message, int style) {

        setOptions(new Object[]{ "Да", "Отмена" });
        setOptionType(YES_NO_OPTION);
        setMessageType(style);
        setMessage(message);
        createDialog(component, "Подтверждение").setVisible(true);
    }

    /**
     * Была ли нажата кнопка подтверждения выхода
     * 
     * @return была ли нажата кнопка подтверждения выхода
     */
    public boolean isExit() {
        return getValue().equals(options[0]);
    }

}

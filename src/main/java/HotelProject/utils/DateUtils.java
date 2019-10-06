/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelProject.utils;

import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;

/**
 *
 * @author Jackson
 */
public class DateUtils {
    
    public static class DateVerifier extends InputVerifier {
        
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        @Override
        public boolean verify(JComponent input) {
            JFormattedTextField tf = (JFormattedTextField) input;
            boolean result = false;
            if (input == tf) {
                try {
                    format.parse(tf.getText());
                    result |= true;
                } catch (ParseException pe) {
                    Toolkit.getDefaultToolkit().beep();
                    result |= false;
                }
            }
            return result;
        }

        @Override
        public boolean shouldYieldFocus(JComponent input) {
            return verify(input);
        }
    }
    
}

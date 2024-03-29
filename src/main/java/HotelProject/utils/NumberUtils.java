/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelProject.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;

/**
 *
 * @author Jackson
 */
public class NumberUtils {
    private static final char GROUPING_SEPARATOR = DecimalFormatSymbols.getInstance().getGroupingSeparator();
    private static final char DECIMAL_SEPARATOR = DecimalFormatSymbols.getInstance().getDecimalSeparator();
    private static final String NUMBER_FILTER_REGEX = "[^\\d\\" + DECIMAL_SEPARATOR + "]";
    private static final char M_DECIMAL_SEPARATOR = DECIMAL_SEPARATOR;
    private static final String LEADING_ZERO_FILTER_REGEX = "^0+(?!$)";

    /**
     * Add grouping separators to string
     *
     * @param original original string, may already contains incorrect grouping separators
     * @return string with correct grouping separators
     */
    public static String format(final String original) {
        final String[] parts = original.split("\\" + M_DECIMAL_SEPARATOR, -1);
        String number = parts[0] // since we split with limit -1 there will always be at least 1 part
                .replaceAll(NUMBER_FILTER_REGEX, "")
                .replaceFirst(LEADING_ZERO_FILTER_REGEX, "");
        // add grouping separators, need to reverse back and forth since Java regex does not support
        // right to left matching
        number = StringUtils.reverse(StringUtils.reverse(number).replaceAll("(.{3})", "$1" + GROUPING_SEPARATOR));
        // remove leading grouping separator if any
        number = StringUtils.removeStart(number, String.valueOf(GROUPING_SEPARATOR));

        // add fraction part if any
        if (parts.length > 1) {
            number += M_DECIMAL_SEPARATOR + parts[1];
        }

        return number;
    }

    /**
     * Return numeric value repesented by the text field
     *
     * @param numero
     * @return numeric value or {@link Double.NaN} if not a number
     */
    public static Double getNumericValue(final String numero) {
        String original = numero.trim().replaceAll(NUMBER_FILTER_REGEX, "");
        original = StringUtils.replace(
            original,
            String.valueOf(M_DECIMAL_SEPARATOR),
            String.valueOf(DECIMAL_SEPARATOR)
        );

        try {
            return NumberFormat.getInstance().parse(original).doubleValue();
        } catch (ParseException e) {
            return 0.0;
        }
    }
    
    public static String validateDouble(String str) {
        if (!str.matches("\\d*(\\.\\d{0,2})?")) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }
}

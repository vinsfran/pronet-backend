package py.com.aquipago.pronetbackend.utils;

import py.com.aquipago.pronetbackend.exception.ServiceException;

public class NumberUtil {

    public static Integer stringToInteger(String cadena) throws ServiceException {
        try {
            return Integer.parseInt(cadena);
        } catch (NumberFormatException nfe) {
            throw new ServiceException(KeyMessageUtil.INVALID_DATA, "Error al convertir String a Integer : " + nfe.getMessage());
        }
    }

    public static boolean isLong(String cadena) {
        boolean resul = false;
        try {
            Long l = Long.parseLong(cadena);
            resul = true;
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }
        return resul;
    }

}

/*
 * Sistemas de Informacion II 2009
 * Proyecto Sipsa
 */
package sipsa.control;

/**
 * Clase para validacion de CUIT
 * @author Claudio Rodrigo Pereyra Diaz
 * @author Maria Eugenia Sanchez
 */
public class CUIT {

    /**
     * Calcula el dígito verificador dado un CUIT completo o sin él.
     * @param cuit El CUIT como String sin guiones
     * @return El valor del dígito verificador calculado.
     */
    private static int calcularDigitoCuit(String cuit) {

        int[] mult = {5, 4, 3, 2, 7, 6, 5, 4, 3, 2};
        char[] nums = cuit.toCharArray();

        int total = 0;
        for (int i = 0; i < mult.length; i++) {
            int valor = Integer.parseInt(String.copyValueOf(nums, i, 1));
            total += valor * mult[i];
        }
        int resto = total % 11;
        return resto == 0 ? 0 : resto == 1 ? 9 : 11 - resto;
    }

    /**
     * Valida el CUIT ingresado.
     * @param cuit Número de CUIT como string con o sin guiones
     * @return True si el CUIT es válido y False si no.
     */
    public static Boolean validaCuit(String cuit) {
        if (cuit == null) {
            return false;
        }
        cuit = limpiar(cuit);
        if (cuit.length() != 11) {
            return false;
        } else {
            int calculado = calcularDigitoCuit(cuit);
            int digito = Integer.parseInt(cuit.substring(10));
            return calculado == digito;
        }
    }

    /**
     * Quita los guiones del CUIT o CUIL
     * @param cuit Cuit con guiones
     * @return Cuit sin guiones
     */
    public static String limpiar(String cuit) {
        return cuit.replace("-", "");
    }
}

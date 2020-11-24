package com.telefonica.somt.commons;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import com.hazelcast.util.StringUtil;


public class Util {

   

    /**
     * Agrega el IGV
     * 
     * @param value
     * @return value con IGV
     */
    public static BigDecimal addIgv(Float value) {
	
	BigDecimal amount = new BigDecimal(value.toString());

	return roundValue(amount.multiply(Constant.IGV).add(amount));
    }
    

    /**
     * Redondea a 2 decimales
     * 
     * @param value
     * @return value con 2 decimales
     */
    public static BigDecimal roundValue(BigDecimal value) {

	return value.setScale(2, RoundingMode.HALF_UP);
    }
    
    /**
     * Compara cuando uno de los valores puede ser null
     * 
     * @param value
     * @return True si hay coincidencia, false si uno de los valores es null o no hay coincidencia
     */
    public static Boolean compare(String value1, String value2) {

   	Boolean result = Boolean.FALSE;

   	if (Boolean.FALSE.equals(StringUtil.isNullOrEmpty(value1))) {
   	    if (Boolean.FALSE.equals(StringUtil.isNullOrEmpty(value2))) {
   		result = value1.equalsIgnoreCase(value2);
   	    }
   	}

   	return result;

       }

    /**
     * Valida que una lista no venga null ni vacia
     * 
     * @param value, lista que se desea validar
     * @return false si la lista es null o vacia
     */
    public static Boolean isEmptyOrNullList(List value1) {

   	Boolean result = Boolean.FALSE;

   	if (Boolean.FALSE.equals(value1 == null)) {
   	    if (Boolean.FALSE.equals(value1.isEmpty())) {
   		result = Boolean.TRUE;
   	    }
   	}

   	return result;

       }

}

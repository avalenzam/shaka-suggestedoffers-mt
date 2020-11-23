package com.telefonica.somt.commons;

import java.math.BigDecimal;

public class Constant {

    public static final String	   ZERO		    = "0";
    public static final String	   ONE		    = "1";
    public static final String	   TWO		    = "2";
    public static final String	   NULL		    = "null";
    public static final String	   CURRENT_PARRILLA = "PARRILLA 3";
    public static final String	   PARRILLA	    = "3";
    public static final String	   OFERTA_CONGIF    = "275";
    public static final BigDecimal IGV		    = new BigDecimal(0.18);

    public static final String YES = "Y";
    public static final String NO  = "N";

    public static final String MOBILE = "mobile";

    // PRODUCT VARIABLES
    public static final String ORIGINSYSTEM		 = "originSystem";
    public static final String BUNDLELOBS		 = "bundleLOBS";
    public static final String INDICATOR_MT		 = "indicatorMT";
    public static final String LANDLINE			 = "landline";
    public static final String PORTING_IND		 = "PortingInd";
    public static final String BROADBAND		 = "broadband";
    public static final String INTERNET_PLAN		 = "Internet_Plan";
    public static final String COMMERCIAL_DOWNLOAD_SPEED = "Commercial_Download_Speed";
    public static final String ACCESS			 = "Access";
    public static final String NETWORK_TECHNOLOGY	 = "Network_Technology";
    public static final String ULTRA_WIFI		 = "Ultra_WiFi";
    public static final String CABLEE_TV		 = "cableTv";
    public static final String TV_PLAN			 = "TV_Plan";
    public static final String FULFILLMENT_CODE		 = "Fulfillment_Code";
    public static final String TV_SERVICE_TECHNOLOGY	 = "TV_Service_Technology";
    public static final String SVA			 = "SVA";
    public static final String CHANNELS_PACK		 = "Channels_Pack";
    public static final String PACK_NAME		 = "Pack_Name";
    public static final String ITEM_IDENTIFIER		 = "Item_Identifier";
    public static final String STBS			 = "STBS";
    public static final String STB			 = "STB";
    public static final String STB_TYPE			 = "STB_Type";
    public static final String TV_MAIN			 = "TV_Main";
    public static final String TV_ADDIONAL_SERVICES	 = "TV_Additional_Services";
    public static final String SHARED_EQUIPMENT_MAIN	 = "Shared_Equipment_Main";
    public static final String DEVICE			 = "device";
    public static final String EQUIPMENT_TYPE		 = "Equipment_Type";
    public static final String EQUIPMENT_SUB_TYPE	 = "Equipment_Sub_Type";
    public static final String TOTAL_PRICE		 = "total price";
    public static final String POSTPAID			 = "postpaid";

    // FIJA PRODUCT ORIGINpRODUCT
    public static final String VOICE_INTERNET_TV = "Voice+Internet+TV";
    public static final String VOICE_INTERNET	 = "Voice+Internet";
    public static final String VOICE_TV		 = "Voice+TV";
    public static final String INTERNET_TV	 = "Internet+TV";
    public static final String VOICE		 = "Voice";
    public static final String TV		 = "TV";
    public static final String INTERNET		 = "Internet";
    public static final String TRIO		 = "Trio";
    public static final String DUO_BA		 = "DUO BA";
    public static final String DUO_TV		 = "DUO TV";
    public static final String DUO_BA_TV	 = "DUO BA+TV";
    public static final String MONO_LINEA	 = "Mono Linea";
    public static final String MONO_TV		 = "Mono TV";
    public static final String MONO_BA		 = "Mono BA";
    public static final String SOLO_MOVIL	 = "SoloMovil";
    
    //CLUSTER
    public static final String SOLO_MOVIL_CLUSTER = "soloMovil";
    public static final String SOLO_PREPAGO = "soloPrepago";
    public static final String SOLOFIJA = "soloFija";
    public static final String SOLOFIJA_PORTA = "soloFija porta";
    public static final String TOTALIZADO = "totalizados";
    public static final String TOTALIZADO_PORTA = "totalizados porta";

    public static final String ESTELAR = "estelar";

    public static final String ATIS = "ATIS";
    public static final String CMS  = "CMS";
    public static final String ALDM = "ALDM";

    public static final String PERUVIAN_COIN = "PEN";

    // URL
    public static final String PARQUE_UNIFICADO_URL   = "http://10.4.43.93:8889/products-0.0.1/products";
    public static final String ELEGIBLE_OFFERS_MT_URL = "http://10.4.43.94:8889/shaka-elegibleoffers-mt-0.0.1/offerings/?";

    // HEADER
    public static final String UNICA_SERVICE_ID	= "UNICA-ServiceId";
    public static final String UNICA_TIMESTAMP	= "UNICA-Timestamp";

    /**
     * Gestión de Log y entornos.
     */
    public static final String NEW_LINE		      = System.getProperty("line.separator");
    public static final String CLASS_LOG_LABEL	      = "[Class]: ";
    public static final String METHOD_LOG_LABEL	      = "[Method]: ";
    public static final String PARAMETERS_LOG_LABEL   = "()";
    public static final String INPUT_PARAMETERS_LABEL = "[Input Params]: ";
    public static final String INPUT_PARAMETER_LABEL  = "[Input]: ";
    public static final String OUTPUT_LABEL	      = "[Output Object]: ";
    public static final String SEPARATOR	      = "===================================================================================================================================================================================";

    private Constant() {

    }

}

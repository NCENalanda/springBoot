package com.ltd.pvt.dem.vendoragency.api.utility;

public interface RegularExpressionPattern {
	
	
	 String REG_EXP_ADDRESS    =  "[a-zA-Z]{3,30}";
     String REG_EXP_NAME       =  "[a-zA-Z]{3,40}";
	 String REG_EXP_MOBILE     =  "[3-9][0-9]{9}";
	 String REG_EXP_PASSWORD   =  "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{6,15}$";
	 String EMAIL_PATTERN      =  "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                                 +"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


}

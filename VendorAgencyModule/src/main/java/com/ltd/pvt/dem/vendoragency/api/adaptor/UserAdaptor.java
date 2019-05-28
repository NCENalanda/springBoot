package com.ltd.pvt.dem.vendoragency.api.adaptor;

import com.ltd.pvt.dem.vendoragency.api.dto.AgencyDetail;
import com.ltd.pvt.dem.vendoragency.api.dto.AgencySignin;
import com.ltd.pvt.dem.vendoragency.api.dto.AgencySignup;
import com.ltd.pvt.dem.vendoragency.api.model.Agency;


public interface UserAdaptor {
	
	  Agency        convertSignUp(AgencySignup dto);
	  Agency        convertSignin(AgencySignin dto);
	 AgencyDetail   convertModel(Agency model);

}

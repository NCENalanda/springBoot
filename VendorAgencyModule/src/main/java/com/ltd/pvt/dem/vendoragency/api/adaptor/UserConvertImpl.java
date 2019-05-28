package com.ltd.pvt.dem.vendoragency.api.adaptor;

import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ltd.pvt.dem.vendoragency.api.dto.AgencyDetail;
import com.ltd.pvt.dem.vendoragency.api.dto.AgencySignin;
import com.ltd.pvt.dem.vendoragency.api.dto.AgencySignup;
import com.ltd.pvt.dem.vendoragency.api.model.Agency;

/**
 * 
 *      Convert the POJO to POJO with Adapter method develop as below listed
 *      public User convertDtoToModel(UserSignup dto)
 *      public User convertSigninToModel(UserSignin dto)
 *      public UserDetail convertModelToUserDetail(User model)
 *     
 * 
 * 
 * */

@Component
public class UserConvertImpl implements UserAdaptor {
	
	
	private static final Logger log = LoggerFactory.getLogger(UserConvertImpl.class);


	@Override
	public Agency convertSignUp(AgencySignup dto) {
		Agency model=null;
		log.debug("UserConfig.convertDtoToModel()");
		model=new Agency();
		model.setAgencyOwnerName(dto.getFirsrname()+dto.getLastname());
		model.setAgencyName(dto.getAgencyName());;
		model.setAgencyEmail(dto.getUsername());
		model.setAgencyPhone(new BigInteger(dto.getContact()));
		model.setAgencyAddress(dto.getAddress());
		model.setAgencyPassword(dto.getPassword());
		return model;
	}

	@Override
	public Agency convertSignin(AgencySignin dto) {
		Agency model=null;
		log.debug("UserConfig.convertSigninToModel()");
		model=new Agency();
		model.setAgencyEmail(dto.getUsername());
		model.setAgencyPassword(dto.getPassword());
		return model;
	}

	@Override
	public AgencyDetail convertModel(Agency model) {
		AgencyDetail  dto =null;
		log.debug("UserConfig.convertModelToUserDetail()");
		dto=new AgencyDetail();
		dto.setOwnerName(model.getAgencyOwnerName());;
		dto.setAgencyName(model.getAgencyName());
		dto.setUsername(model.getAgencyEmail());
		dto.setAddress(model.getAgencyAddress());
		dto.setContact(model.getAgencyPhone().toString());
		return dto;
	}

}

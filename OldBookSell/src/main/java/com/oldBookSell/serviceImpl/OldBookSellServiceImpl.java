package com.oldBookSell.serviceImpl;

import java.util.ArrayList;	
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.oldBookSell.dto.OldBookSellDTO;
import com.oldBookSell.model.Address;
import com.oldBookSell.model.UserDetails;
import com.oldBookSell.repository.UserDetailRepository;
import com.oldBookSell.service.OldBookSellServices;


@Service
public class OldBookSellServiceImpl implements OldBookSellServices{

	@Autowired
	UserDetailRepository userDetailRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public OldBookSellDTO createUser(OldBookSellDTO odlBookSellDTO) {
		

		UserDetails userDetails=new UserDetails();
		
		userDetails.setFirstName(odlBookSellDTO.getFirstName());
		userDetails.setLastName(odlBookSellDTO.getLastName());
		userDetails.setMobileNumber(odlBookSellDTO.getMobileNumber());
		userDetails.setEmail(odlBookSellDTO.getEmail());
		userDetails.setPassword(bcryptEncoder.encode(odlBookSellDTO.getPassword()));
		userDetails.setRole(odlBookSellDTO.getRole());
		
		Address addressObj=new Address();
		
		addressObj.setAddress(odlBookSellDTO.getAddress());
		addressObj.setAddress2(odlBookSellDTO.getAddress2());
		addressObj.setDistrict(odlBookSellDTO.getDistrict());
		addressObj.setLocation(odlBookSellDTO.getLocation());
		addressObj.setPostalCode(odlBookSellDTO.getPinCode());
		addressObj.setState(odlBookSellDTO.getState());
		
		List<Address> list=new ArrayList<>();
		list.add(addressObj);
		
//		userDetails.setAddress(list);
		
		if(userDetailRepository.existsByEmail(odlBookSellDTO.getEmail())) {
		UserDetails userObj=	userDetailRepository.findByEmail(odlBookSellDTO.getEmail());
//			System.out.println(userObj.getAddress().);
		list.addAll(userObj.getAddress());
		userObj.setAddress(list);
			
			userDetailRepository.save(userObj);
		}else {
			userDetailRepository.save(userDetails);
		}
		
		return odlBookSellDTO;
	}

	@Override
	public UserDetails addAddress(OldBookSellDTO address) {
		
		Address addressObj=new Address();
		
		addressObj.setAddress(address.getAddress());
		addressObj.setAddress2(address.getAddress2());
		addressObj.setDistrict(address.getDistrict());
		addressObj.setLocation(address.getLocation());
		addressObj.setPostalCode(address.getPinCode());
		addressObj.setState(address.getState());
		
		List<Address> list=new ArrayList<>();
		
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails userObj=	userDetailRepository.findByEmail(authentication.getName());
//		System.out.println(userObj.getAddress().);
		
		list.addAll(userObj.getAddress());
		list.add(addressObj);
		userObj.setAddress(list);
		
		userDetailRepository.save(userObj);
		System.out.println("insert new record"+address.getAddress());
//		userDetailRepository.save(userDetails);
		return userDetailRepository.findByEmail(authentication.getName());
	}

	@Override
	public UserDetails getAddress() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return userDetailRepository.findByEmail(authentication.getName());
	}

}

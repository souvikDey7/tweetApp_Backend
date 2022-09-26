package com.twitters.business.facade;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.twitters.business.config.KafkaProducer;
import com.twitters.business.mapper.RegistrationMapper;
import com.twitters.business.security.JwtUtils;
import com.twitters.business.service.RegisterService;

import be.twitter.customerdistribution.api.LoginApi;
import be.twitter.customerdistribution.api.RegisterApi;
import be.twitter.customerdistribution.types.Credential;
import be.twitter.customerdistribution.types.UserDetails;

@RestController
@RequestMapping("/api/v1.0/tweets")
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.OPTIONS })
public class RegistrationController implements RegisterApi, LoginApi {

	@Autowired
	private RegisterService registerService;
	@Autowired
	private RegistrationMapper registrationMapper;
	@Autowired
	private JwtUtils jwt;

	@Autowired
	private KafkaProducer kafkaProducer;
	
	@Override
	public ResponseEntity<String> userRegistration(@Valid UserDetails userDetails) {
		jwt.setkey(jwt.generateToken(registrationMapper.toCredentialDTO(userDetails.getCridential())));
		String flag = registerService.userRegistration(registrationMapper.toUserDetailsDTO(userDetails));
		if (!flag.equals("success")) {
			kafkaProducer.sendMessage(
					userDetails.getFirstName() + " " + userDetails.getLastName() + " Registered Successfully.");
			return new ResponseEntity<>(flag, HttpStatus.OK);
		}
		return new ResponseEntity<>(jwt.getCredential(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> login(@Valid Credential credential) {
		String flag = registerService.userLogin(registrationMapper.toCredentialDTO(credential));
		if (!flag.equals("success"))
			return new ResponseEntity<>(flag, HttpStatus.OK);
		jwt.setkey(jwt.generateToken(registrationMapper.toCredentialDTO(credential)));
		return new ResponseEntity<>(jwt.getCredential(), HttpStatus.OK);
	}
}

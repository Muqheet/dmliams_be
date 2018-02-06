package org.alimdaadsociety.model.service;

import java.util.Date;
import java.util.Map;
import java.util.List;

import javax.mail.MessagingException;

import org.alimdaadsociety.model.bean.AppUser;
import org.alimdaadsociety.model.bean.AppUserToken;
import org.alimdaadsociety.model.repository.AppUserRepository;
import org.alimdaadsociety.model.repository.AppUserTokenRepository;
import org.alimdaadsociety.utility.OtpGenerator;
import org.alimdaadsociety.utility.SmtpMaliSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AppUserService {
	
	@Autowired
	AppUserTokenRepository appUserTokenRepository;
	@Autowired
	AppUserRepository appUserRepository;
	@Autowired
	SmtpMaliSender smtpMaliSender;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	
	public void Signup(AppUser appUser, String reg_token) throws Exception {
		AppUserToken urt = appUserTokenRepository.findOne(reg_token);
		
		if(urt == null)
			throw new Exception("Signup-Token is invalid");		
		
		if(! urt.getToken_email().equals(appUser.getEmail()))
			throw new Exception("Signup-Token is not valid for this email");
		
		/*get difference of milliseconds, convert to seconds by dividing 1000 and check if it's > 24hours*/
		if( (new Date().getTime() - urt.getToken_gen_time().getTime())/1000 > (60*60*24) )
			throw new Exception("Signup-Token is expired");
		
		appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
		appUser.setEnabled(true);
		appUserRepository.save(appUser);
		appUserTokenRepository.delete(urt);
	}


	public String generateUserToken(String email) {
		String token = OtpGenerator.generateOtp(8);
		AppUserToken appUserToken = new AppUserToken();
		appUserToken.setToken_email(email);
		appUserToken.setToken(token);
		appUserToken.setToken_gen_time(new Date());
		appUserTokenRepository.save(appUserToken);
		return token;		
	}


	public void generateUserSignupToken(String email) throws MessagingException {
		String token = generateUserToken(email);
		String template = "<b>You are invited</b>"
				+ "<br><br>"
				+ "To register your profile as an admin at AlimdaadSociety.org please click the link below and use Signup token <b>"+token+"</b> while registration."
				+ "<br>"
				+ "<a href='https://alimdaadsociety.org/Register'>https://alimdaadsociety.org/Register</a>"
				+ "<br><br>"
				+ "Note: The token will expire after <b>24</b> hours."
				+ "<br><br>"
				+ "If this email is irrelevant to you, disregard this email and no action will be taken."
				+ "<br><br>"
				+ "Regards,"
				+ "<br>"
				+ "AlimdaadSociety Team"
				+ "<br><br>"
				+ "Disclamer: This is an auto-generated email. Please do not reply.";
		smtpMaliSender.send(email, "Registration Invite", template);

		
	}
	public void forgotPassword(String email) throws MessagingException {
		AppUser user = appUserRepository.findByEmail(email);
		if(user != null) {
			String token = generateUserToken(email);
			String template = "Hi "+user.getUsername()+","
						+ "<br><br>"
						+ "To reset your password please click the link below."
						+ "<br>"
						+ "<a href='https://alimdaadsociety.org/ChangePassword/"+token+"'>https://alimdaadsociety.org/ChangePassword/"+token+"</a>"
						+ "<br><br>"
						+ "If you don't wish to reset your password, disregard this email and no action will be taken."
						+ "<br><br>"
						+ "Note: This link will expire after <b>25</b> minutes."
						+ "<br><br>"
						+ "Regards,"
						+ "<br>"
						+ "AlimdaadSociety Team"
						+ "<br><br>"
						+ "Disclamer: This is an auto-generated email. Please do not reply.";
			smtpMaliSender.send(email, "Reset Password", template);
			
		}
	}
	
	
	public void changePassword(String password, String token) throws Exception {
		AppUserToken aut = appUserTokenRepository.findOne(token);
		
		if(aut == null)
			throw new Exception("Token is invalid");
		if( (new Date().getTime() - aut.getToken_gen_time().getTime())/1000 > (60*30) )
			throw new Exception("Token expired");
		
		String email = aut.getToken_email();
		
		AppUser appUser = appUserRepository.findByEmail(email);
		appUser.setPassword(bCryptPasswordEncoder.encode(password));
		appUserRepository.save(appUser);
		appUserTokenRepository.delete(aut);
			
	}


	public List<AppUser> findAll() {
		return (List<AppUser>) appUserRepository.findAll();
	}

}

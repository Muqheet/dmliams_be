package org.alimdaadsociety.model.bean;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class AppUser
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idUser;

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<AppUserRoles> appUserRoles;

	//	@NotNull @NotBlank @NotEmpty @Pattern(regexp = "[a-z A-Z]")
	private String username;

	@Email
	private String email;

	private String mobile;

	private String mobile_cc;

	//	@Pattern(regexp = "")
	@JsonIgnore
	private String password;

	private boolean enabled;

	public AppUser() {
		super();
	}
	//	For Spring Security
	public AppUser(AppUser appUser) {
		this.idUser = appUser.getIdUser();
		this.username = appUser.getUsername();
		this.email = appUser.getEmail();
		this.password = appUser.getPassword();
		this.enabled = appUser.isEnabled();
		this.appUserRoles = appUser.getAppUserRoles();
	}

	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public Set<AppUserRoles> getAppUserRoles() {
		return appUserRoles;
	}
	public void setAppUserRoles(Set<AppUserRoles> appUserRoles) {
		this.appUserRoles = appUserRoles;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getMobile_cc() {
		return mobile_cc;
	}
	public void setMobile_cc(String mobile_cc) {
		this.mobile_cc = mobile_cc;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}

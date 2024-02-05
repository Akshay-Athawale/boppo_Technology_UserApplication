package com.boppo.userApplication;

public class ChangePasswordDto {

	private String password;
    private String oldPassword;
    private String newPassword;
    private String reNewPassword;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getReNewPassword() {
		return reNewPassword;
	}
	public void setReNewPassword(String reNewPassword) {
		this.reNewPassword = reNewPassword;
	}
	public ChangePasswordDto(String password, String oldPassword, String newPassword, String reNewPassword) {
		super();
		this.password = password;
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
		this.reNewPassword = reNewPassword;
	}
	public ChangePasswordDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ChangePasswordDto [password=" + password + ", oldPassword=" + oldPassword + ", newPassword="
				+ newPassword + ", reNewPassword=" + reNewPassword + "]";
	}
    
    
}

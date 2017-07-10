package in.brewcode.admin.service;

import in.brewcode.admin.dto.AuthorRegistrationDto;

public interface IUserRegistrationService {

public void registerUser(AuthorRegistrationDto authorRegistrationDto);
public void updateUser(AuthorRegistrationDto authorRegistrationDto);
public void updatePassword(String oldPassword, String newPassword);
}

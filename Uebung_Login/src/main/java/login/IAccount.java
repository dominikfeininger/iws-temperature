package main.java.login;

import main.java.login.exceptions.NoConnectionToRepositoryException;

public interface IAccount {
	void setLoggedIn(boolean value);
	boolean checkPassword(String password) throws NoConnectionToRepositoryException;
	void setDisabled(boolean value);
	boolean isLoggedIn();
	boolean isDisabled();
}

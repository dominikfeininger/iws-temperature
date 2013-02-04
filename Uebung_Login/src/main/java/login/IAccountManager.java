package main.java.login;

import javax.security.auth.login.AccountNotFoundException;

public interface IAccountManager {
	IAccount find(String accountId);
}

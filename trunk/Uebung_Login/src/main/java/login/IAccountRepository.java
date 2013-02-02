package main.java.login;

import javax.security.auth.login.AccountNotFoundException;

public interface IAccountRepository {
	IAccount find(String accountId);
}

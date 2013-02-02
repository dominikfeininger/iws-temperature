package main.java.login;

import main.java.login.exceptions.AccountAlreadyLoggedInException;
import main.java.login.exceptions.AccountDisabledException;
import main.java.login.exceptions.NoConnectionToRepositoryException;

public class LoginService {
	private final IAccountRepository accountRepository;
	private String previousAccountId = "";
	private int failedAttempts = 0;

	public LoginService(IAccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public void login(String accountId, String password) {
		IAccount account;

		account = accountRepository.find(accountId);

		try {
			if (account.checkPassword(password)) {
				if (account.isDisabled())
					throw new AccountDisabledException();
				if (account.isLoggedIn())
					throw new AccountAlreadyLoggedInException();
				account.setLoggedIn(true);
			} else {
				if (previousAccountId.equals(accountId))
					++failedAttempts;
				else {
					failedAttempts = 1;
					previousAccountId = accountId;
				}
			}

			if (failedAttempts == 3)
				account.setDisabled(true);

		} catch (NoConnectionToRepositoryException e) {

		}
	}
}

package test.java.login;

import static org.junit.Assert.*;

import javax.security.auth.login.AccountNotFoundException;

import main.java.login.IAccount;
import main.java.login.IAccountRepository;
import main.java.login.LoginService;
import main.java.login.exceptions.AccountAlreadyLoggedInException;
import main.java.login.exceptions.AccountDisabledException;
import main.java.login.exceptions.NoConnectionToRepositoryException;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class LoginServiceTest {

	/**
	 * itShouldSetAccountToLoggedInWhenPasswordMatches
	 * 
	 * @throws AccountNotFoundException
	 */
	@Test
	public void testCase1() {
		IAccount account = mock(IAccount.class);
		when(account.checkPassword(anyString())).thenReturn(true);

		IAccountRepository accountRepository = mock(IAccountRepository.class);
		when(accountRepository.find(anyString())).thenReturn(account);

		LoginService service = new LoginService(accountRepository);

		service.login("iws_user", "password");

		verify(account, times(1)).setLoggedIn(true);
	}

	@Test
	public void testCase2() {
		IAccount account = mock(IAccount.class);
		when(account.checkPassword(anyString())).thenReturn(false);

		IAccountRepository accountRepository = mock(IAccountRepository.class);
		when(accountRepository.find(anyString())).thenReturn(account);

		LoginService service = new LoginService(accountRepository);

		service.login("iws_user", "password");
		verify(account, never()).setLoggedIn(true);
	}

	/**
	 * itShouldSetAccountToRevokedAfterThreeFailedLoginAttempts
	 * 
	 * @throws AccountNotFoundException
	 */
	@Test
	public void testCase3() {
		IAccount account = mock(IAccount.class);
		when(account.checkPassword(anyString())).thenReturn(false);

		IAccountRepository accountRepository = mock(IAccountRepository.class);
		when(accountRepository.find(anyString())).thenReturn(account);

		LoginService service = new LoginService(accountRepository);

		for (int i = 0; i < 3; ++i)
			service.login("iws_user", "password");

		verify(account, times(1)).setDisabled(true);
	}

	@Test
	public void testCase4() {
		IAccount account = mock(IAccount.class);
		when(account.checkPassword(anyString())).thenReturn(false);

		IAccountRepository accountRepository = mock(IAccountRepository.class);
		when(accountRepository.find(anyString())).thenReturn(account);

		LoginService service = new LoginService(accountRepository);

		IAccount secondAccount = mock(IAccount.class);
		when(secondAccount.checkPassword(anyString())).thenReturn(false);
		when(accountRepository.find("schuchert")).thenReturn(secondAccount);

		service.login("iws_user", "password");
		service.login("iws_user", "password");
		service.login("iws_user2", "password");

		verify(secondAccount, never()).setDisabled(true);
	}

	@Test(expected = AccountAlreadyLoggedInException.class)
	public void testCase5() {
		IAccount account = mock(IAccount.class);
		when(account.checkPassword(anyString())).thenReturn(true);

		IAccountRepository accountRepository = mock(IAccountRepository.class);
		when(accountRepository.find(anyString())).thenReturn(account);

		LoginService service = new LoginService(accountRepository);

		when(account.isLoggedIn()).thenReturn(true);
		service.login("iws_user", "password");
	}

	@Test(expected = AccountDisabledException.class)
	public void testCase6() {
		IAccount account = mock(IAccount.class);
		when(account.checkPassword(anyString())).thenReturn(true);

		IAccountRepository accountRepository = mock(IAccountRepository.class);
		when(accountRepository.find(anyString())).thenReturn(account);

		LoginService service = new LoginService(accountRepository);

		when(account.isDisabled()).thenReturn(true);
		service.login("iws_user", "password");
	}

	@Test
	public void testCase7() {
		IAccount account = mock(IAccount.class);
		when(account.checkPassword(anyString())).thenThrow(new NoConnectionToRepositoryException());
		
		IAccountRepository accountRepository = mock(IAccountRepository.class);
		when(accountRepository.find(anyString())).thenReturn(account);

		LoginService service = new LoginService(accountRepository);
		service.login("iws_user", "password");

		verify(account, never()).setLoggedIn(true);
		verify(account, never()).setDisabled(true);
	}

}

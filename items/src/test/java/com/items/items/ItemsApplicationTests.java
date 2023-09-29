package com.items.items;

import com.items.items.model.User;
import com.items.items.service.UserService;
import com.items.items.service.UserServiceImplementation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemsApplicationTests {

	@Test
	public void testValidUsername(){
		UserService userService = new UserServiceImplementation();
		String username = "julionoboa";
		String password = "Alabama123";
		String confirmPassword = "Alabama123";
		User user = new User(username, password, confirmPassword);

		Boolean result = userService.createUser(user);
		assert(result);
	}

	@Test
	public void testInvalidUsernameBecauseIsTooLong(){
		UserService userService = new UserServiceImplementation();
		String username = "julionoboagomez23";
		String password = "Alabama123";
		String confirmPassword = "Alabama123";
		User user = new User(username, password, confirmPassword);

		Boolean result = userService.createUser(user);
		assertFalse(result);
	}

	@Test
	public void testInvalidUsernameBecauseIsTooShort(){
		UserService userService = new UserServiceImplementation();
		String username = "jul";
		String password = "Alabama123";
		String confirmPassword = "Alabama123";
		User user = new User(username, password, confirmPassword);

		Boolean result = userService.createUser(user);
		assertFalse(result);
	}

	@Test
	public void testInvalidUsernameBecauseHasSpecialCharacters(){
		UserService userService = new UserServiceImplementation();
		String username = "julion!oboa";
		String password = "Alabama123";
		String confirmPassword = "Alabama123";
		User user = new User(username, password, confirmPassword);

		Boolean result = userService.createUser(user);
		assertFalse(result);
	}

	@Test
	public void testInvalidUsernameBecauseHasWhiteSpace(){
		UserService userService = new UserServiceImplementation();
		String username = "juli noboa";
		String password = "Alabama123";
		String confirmPassword = "Alabama123";
		User user = new User(username, password, confirmPassword);

		Boolean result = userService.createUser(user);
		assertFalse(result);
	}

	@Test
	public void testInvalidPasswordBecauseIsTooShort(){
		UserService userService = new UserServiceImplementation();
		String username = "julionoboagomez23";
		String password = "A13";
		String confirmPassword = "A13";
		User user = new User(username, password, confirmPassword);

		Boolean result = userService.createUser(user);
		assertFalse(result);
	}

	@Test
	public void testInvalidPasswordBecauseDoesNotHaveACapital(){
		UserService userService = new UserServiceImplementation();
		String username = "julionoboagomez23";
		String password = "alabama123";
		String confirmPassword = "alabama123";
		User user = new User(username, password, confirmPassword);

		Boolean result = userService.createUser(user);
		assertFalse(result);
	}

	@Test
	public void testInvalidPasswordBecauseHasAWhiteSpace(){
		UserService userService = new UserServiceImplementation();
		String username = "julionoboagomez23";
		String password = "Ala bama123";
		String confirmPassword = "Ala bama123";
		User user = new User(username, password, confirmPassword);

		Boolean result = userService.createUser(user);
		assertFalse(result);
	}

	@Test
	public void testPasswordEncryption(){
		String password = "Alabama123";
		String expected = "Grghgsg789";

		String encryptedPassword = UserServiceImplementation.encryptPassword(password);
		assertEquals(expected, encryptedPassword);
	}

	@Test
	public void testPasswordDecryption(){
		String encryptedPassword = "Grghgsg789";
		String expected = "Alabama123";

		String decryptedPassword = UserServiceImplementation.decryptPassword(encryptedPassword);
		assertEquals(expected, decryptedPassword);
	}

}

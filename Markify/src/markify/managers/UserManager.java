package markify.managers;

import markify.entities.User;
import markify.dao.UserDao;


public class UserManager {
	private static UserManager instance = new UserManager();
	private static UserDao dao = new UserDao();
	// To follow the singleton pattern, we need to make sure that only a single instance of UserManager is created.
	// For this a private constructor is required. Having a private constructor, instances cannot be created.
	//But as an instance is required, it is done by creating it in this class itself.
	private UserManager() {}
	public static UserManager getInstance() {
		return instance;
	}
	
	public User createUser(long id, String email, String password, String firstName, String lastName, int gender, String userType) {
		User user = new User();
		user.setId(id);
		user.setEmail(email);
		user.setPassword(password);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setGender(gender);
		user.setUserType(userType);
		
		return user;
	}
	
	public User[] getUsers() {
		return dao.getUsers();
	}
	
}

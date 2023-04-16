package markify.dao;

import markify.DataStore;
import markify.entities.User;

public class UserDao {
	public User[] getUsers() {
		return DataStore.getUsers();
	}
	
}

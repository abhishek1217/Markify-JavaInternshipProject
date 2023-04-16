package markify;

import markify.entities.Bookmark;
import markify.entities.User;
import markify.managers.BookmarkManager;
import markify.managers.UserManager;

public class Launch {
	private static User[] users;
	private static Bookmark[][] bookmarks;
	
	private static void loadData() {
		System.out.println("1. Loading Data....");
		DataStore.loadData();
		users = UserManager.getInstance().getUsers();
		bookmarks = BookmarkManager.getinstance().getBookmarks();
		
//		System.out.println("Printing Data....");
//		printUserData();
//		printBookmarkData();
	}
	
	
//	private static void printBookmarkData() {
//		for (Bookmark[] bookmarkList: bookmarks) {
//			for(Bookmark bookmark: bookmarkList) {
//				System.out.println(bookmark);
//			}
//		}
//		
//	}
//
//
//	private static void printUserData() {
//		for (User user: users) {
//			System.out.println(user);
//		}
//		
//	}
	private static void start() {
		// System.out.println("\n2. Bookmarking...");
		for(User user: users) {
			View.browse(user, bookmarks);
		}
		
	}

	public static void main(String[] args) {
		loadData();
		start();
	}


	
}

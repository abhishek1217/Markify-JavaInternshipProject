package markify.entities;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import markify.managers.BookmarkManager;

class WebLinkTest {

	@Test
	void testIsKidFriendlyEligible() {
		// Test 1: "porn" in url -- false
		WebLink webLink = BookmarkManager.getinstance().createWebLink(2000,"Taming Tiger, Part 2","http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html","http://www.javaworld.com");
		
		boolean isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		
		assertFalse(isKidFriendlyEligible,"For porn in Url - isKidFriendlyEligible() must return false");
		
		// Test 2: "porn" in title -- false
		webLink = BookmarkManager.getinstance().createWebLink(2000,"Taming Porn, Part 2","http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com");
		
		isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		
		assertFalse(isKidFriendlyEligible,"For Porn in Title - isKidFriendlyEligible() must return false");
		
		// Test 3: "adult" in host -- false
		webLink = BookmarkManager.getinstance().createWebLink(2000,"Taming Tiger, Part 2","http://www.javaworld.com/article/2072759/core-java/taming-tiger+--part-2.html","http://www.adult.com");
		
		isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		
		assertFalse(isKidFriendlyEligible,"For Adult in Host - isKidFriendlyEligible() must return false");
		
		// Test 4: "adult" in url, but not in host part -- true
		webLink = BookmarkManager.getinstance().createWebLink(2000,"Taming Tiger, Part 2","http://www.javaworld.com/article/2072759/core-java/taming-adult+--part-2.html","http://www.javaworld.com");
		
		isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		
		assertTrue(isKidFriendlyEligible,"For Adult in Url - isKidFriendlyEligible() must return true");
		
		// Test 5: "adult" in title only -- true
		webLink = BookmarkManager.getinstance().createWebLink(2000,"Taming Adult, Part 2","http://www.javaworld.com/article/2072759/core-java/taming-tiger+--part-2.html","http://www.javaworld.com");
		
		isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		
		assertTrue(isKidFriendlyEligible,"For Adult in Title - isKidFriendlyEligible() must return true");
	}

}

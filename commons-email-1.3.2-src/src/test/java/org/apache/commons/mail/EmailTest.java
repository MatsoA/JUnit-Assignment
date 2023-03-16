package org.apache.commons.mail;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

public class EmailTest {
	
	private static final String[] TEST_EMAILS = { "ab@bc.com", 
			"a.b@c.org", "abcdefghijklmnopqrst@abcdefghijklmnopqrst.com.bd"};
	
	private static final String VALID_EMAIL = "ab@bc.com";
	
	/*Concrete Email Class*/
	private EmailConcrete email;
	private EmailDummy mimeEmail;
	private EmailDummyMissing mimeEmailMissing;
	
	@Before
	public void setUpEmailTest() throws Exception {
		email = new EmailConcrete();
		mimeEmail = new EmailDummy("test", VALID_EMAIL, VALID_EMAIL);
		mimeEmailMissing = new EmailDummyMissing("test", VALID_EMAIL, VALID_EMAIL);
	}
	
	@After
	public void tearDownEmailTest() throws Exception {
		
	}
	
	//Testing of addBcc(String...)
	@Test
	public void testAddBcc() throws Exception {
		email.addBcc(TEST_EMAILS);
		
		assertEquals(3, email.getBccAddresses().size());
	}
	
	//Testing of addCc(string email)
	@Test
	public void testAddCc() throws Exception {
		email.addCc(TEST_EMAILS[0]);
		
		assertEquals(1, email.getCcAddresses().size());
	}
	
	//Testing of addHeader(String name, String value) with no inputs
	@Test
	public void testAddHeaderNoArgs() throws Exception {
		try {
			email.addHeader(null, null);
		} catch (Exception e) {
			assertEquals(e.getClass(), java.lang.IllegalArgumentException.class);
		}
	}
	
	//Testing of addHeader(String name, String value) with no value
	@Test
	public void testAddHeaderNoValue() throws Exception {
		try {
			email.addHeader(null, "value");
		} catch (Exception e) {
			assertEquals(e.getClass(), java.lang.IllegalArgumentException.class);
		}
	}
	
	//Testing of addHeader(String name, String value) with no value
	@Test
	public void testAddHeaderNoName() throws Exception {
		try {
			email.addHeader("name", null);
		} catch (Exception e) {
			assertEquals(e.getClass(), java.lang.IllegalArgumentException.class);
		}
	}
	
	//Testing of addHeader(String name, String value) with correct inputs
	@Test
	public void testAddHeaderBothArgs() throws Exception {
		email.addHeader("name", "value");
		
		assertEquals(email.getHeaders().size(), 1);
	}
	
	
	//Testing of addReplyTo(String email, String name)
	@Test
	public void testAddReplyTo() throws Exception {
		email.addReplyTo(VALID_EMAIL, "value");
		
		assertEquals(email.getReplyToAddresses().size(), 1);
	}
	
	//Testing of buildMimeMessage() with full email attributes
	@Test
	public void buildMimeMessage() throws Exception {
		
		
		try {
			mimeEmail.buildMimeMessage();
			
		} catch (Exception e) {
			System.out.print(e);
		}
	}
	
	//Testing of buildMimeMessage() with missing email attributes:
	@Test
	public void buildMimeMessageMissing() throws Exception {
		try {
			mimeEmailMissing.buildMimeMessage();
			
		} catch (Exception e) {
			System.out.print(e);
		}
	}
	
	
	
}

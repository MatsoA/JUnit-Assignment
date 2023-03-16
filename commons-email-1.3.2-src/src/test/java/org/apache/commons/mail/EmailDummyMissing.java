package org.apache.commons.mail;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeBodyPart;

//class setup with attributes needed for full mime message
public class EmailDummyMissing extends EmailConcrete {
	
	private InternetAddress createInternetAddress(String email, String name, String charsetName) throws EmailException {
		InternetAddress address = null;

        try
        {
            address = new InternetAddress(email);

            // check name input
            if (EmailUtils.isNotEmpty(name))
            {
                // check charset input.
                if (EmailUtils.isEmpty(charsetName))
                {
                    address.setPersonal(name);
                }
                else
                {
                    // canonicalize the charset name and make sure
                    // the current platform supports it.
                    Charset set = Charset.forName(charsetName);
                    address.setPersonal(name, set.name());
                }
            }

            // run sanity check on new InternetAddress object; if this fails
            // it will throw AddressException.
            address.validate();
        }
        catch (AddressException e)
        {
            throw new EmailException(e);
        }
        catch (UnsupportedEncodingException e)
        {
            throw new EmailException(e);
        }
        return address;

	}
	
	public EmailDummyMissing(String hostName, String sender, String recipient) throws EmailException, MessagingException {
		
		MimeMultipart multipart = new MimeMultipart();
		MimeBodyPart bodyMessagePart = new MimeBodyPart();
		bodyMessagePart.setContent("email body", this.charset);
		multipart.addBodyPart(bodyMessagePart);
		
		
		this.hostName = "test";
		this.fromAddress = createInternetAddress(sender, "name", this.charset);
		this.toList.add(createInternetAddress(recipient, "name", this.charset));
		this.content = "String";
		this.popBeforeSmtp = true;
	}
}

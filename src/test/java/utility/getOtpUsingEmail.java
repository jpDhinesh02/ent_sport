package utility;

import javax.mail.*;
import java.util.Properties;

public class getOtpUsingEmail {
    public static void main(String[] args) {
        System.out.println("Start reading...");

        String host = "pop.gmail.com";// change accordingly
      //   String mailStoreType = "pop3";
        String username = "jpdhinesh2002@gmail.com";// change accordingly
        String password = "hffi ddmx udjj hfeu";// change accordingly
        
        try {

            //create properties field
            Properties properties = new Properties();
      
            properties.put("mail.pop3.host", host);
            properties.put("mail.pop3.port", "995");
            properties.put("mail.pop3.starttls.enable", "true");
            Session emailSession = Session.getDefaultInstance(properties);
        
            Store store = emailSession.getStore("pop3s");
      
            store.connect(host, username, password);
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);
      
            Message[] messages = emailFolder.getMessages();
            System.out.println("messages.length---" + messages.length);
      
            for (int i = 0, n = messages.length; i < n; i++) {
               Message message = messages[i];
               System.out.println("---------------------------------");
               System.out.println("Email Number " + (i + 1));
               System.out.println("Subject: " + message.getSubject());
               System.out.println("From: " + message.getFrom()[0]);
               System.out.println("Text: " + message.getContent().toString());
      
            }
      
            //close the store and folder objects
            emailFolder.close(false);
            store.close();
      
            } catch (NoSuchProviderException e) {
               e.printStackTrace();
            } catch (MessagingException e) {
               e.printStackTrace();
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
        }
      
         
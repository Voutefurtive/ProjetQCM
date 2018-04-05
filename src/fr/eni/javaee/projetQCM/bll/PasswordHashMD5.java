package fr.eni.javaee.projetQCM.bll;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PasswordHashMD5 {
	
	
   private static MessageDigest md;

   public static String cryptWithMD5(String password){
    try {
        md = MessageDigest.getInstance("MD5");
        byte[] passBytes = password.getBytes();
        md.reset();
        byte[] digested = md.digest(passBytes);
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<digested.length;i++){
            sb.append(Integer.toHexString(0xff & digested[i]));
        }
        return sb.toString();
    } catch (NoSuchAlgorithmException ex) {
        Logger.getLogger(PasswordHashMD5.class.getName()).log(Level.SEVERE, null, ex);
    }
        return null;


   }

}
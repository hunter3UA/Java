package com.example.hotelApp.sl;

import javassist.bytecode.ByteArray;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;


public class  Security {
    private static int saltLength=32;
    private static int hash_iteration=10*1000;
    private static int desiredKeyLength=256;
    public static class Salted_Hash{
        public Integer hash_iterations;
        public String passwordHash;
    }


     public static Salted_Hash getSaltedHash(String password){
         Salted_Hash salted_hash=new Salted_Hash();
         try{
            byte[] salt= SecureRandom.getInstance("SHA1PRNG").generateSeed(saltLength);
            salted_hash.hash_iterations=hash_iteration;
            salted_hash.passwordHash=Base64.encodeBase64String(salt) +"$" + hash(password,salt,hash_iteration);

        }catch (NoSuchAlgorithmException ex){

        }
         return salted_hash;
     }
     public static boolean check(String password,Salted_Hash salted_hash){
         String[] saltAndPass=salted_hash.passwordHash.split("\\$");
         if(saltAndPass.length!=2){
             throw new IllegalArgumentException("The stored password have thr form 'slat$hash'");
         }
         String hashOfInput=hash(password,Base64.decodeBase64(saltAndPass[0]),salted_hash.hash_iterations);
         return hashOfInput.equals(saltAndPass[1]);

     }

     private static String hash(String password,byte[] salt,Integer hash_iteration) {
        try{
            if(password==null || password.length()==0)
                throw  new IllegalArgumentException("Empty passwords are not supported");
            SecretKeyFactory f=SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            SecretKey key=f.generateSecret(new PBEKeySpec(
                    password.toCharArray(), salt,hash_iteration,desiredKeyLength
            ));
            return Base64.encodeBase64String(key.getEncoded());
        }catch (NoSuchAlgorithmException ex){

        }catch (InvalidKeySpecException ex){

        }
         return null;
     }
}

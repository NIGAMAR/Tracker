package com.vihan.tracker.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UUIDGeneratorUtil {
    public static String generateUUID(String input){
        StringBuilder uuid=new StringBuilder();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(input.getBytes());
            byte[] byteDigest = messageDigest.digest();
            for(byte digest:byteDigest){
                String hex = Integer.toHexString(0xFF & digest);
                while (hex.length()<2){
                    hex = "0" + hex;
                }
                uuid.append(hex);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return uuid.toString();
    }
}

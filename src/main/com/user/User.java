package main.com.user;

import main.com.account.Account;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User extends Account implements UserImpl
{
    private final String name;
    private final String password;

    private String hashPassword(String pwd)
    {
        try
        {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(pwd.getBytes());
            StringBuilder hexString = new StringBuilder(2 * hash.length);

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e)
        {
            throw new RuntimeException(e);
        }
    }

    public User (String name, String password)
    {
        super();
        this.name = name;
        this.password = hashPassword(password);
    }

    public String getName()
    {
        return name;
    }

    public boolean verifyPassword(String pwd)
    {
        String newPwd = hashPassword(pwd);
        return newPwd.equals(password);
    }
}

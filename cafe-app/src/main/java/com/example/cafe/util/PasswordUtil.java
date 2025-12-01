package com.example.cafe.util;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordUtil {
    public static String hashPassword(String plain) {
        return BCrypt.hashpw(plain, BCrypt.gensalt(10));
    }

    public static boolean verifyPassword(String plain, String hash) {
        if (hash == null) return false;
        return BCrypt.checkpw(plain, hash);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tads.model.utils;

import java.security.SecureRandom;
import java.util.stream.Collectors;

/**
 *
 * @author juann
 */
public class RandomPassword {
    public static String generateRandomPassword(int len)
    {
        int randNumOrigin = 48;
        int randNumBound = 122;
        SecureRandom random = new SecureRandom();
        return random.ints(len, randNumOrigin, randNumBound + 1)
                    .mapToObj(i -> String.valueOf((char)i))
                    .collect(Collectors.joining());
    }
}

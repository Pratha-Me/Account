/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Calendar;
import java.util.Date;

public class Token {

    public final String tokensecretkey = "TokenDecodertokensecretkey";
    boolean status = false;
    private String userCode, userName, userType, branch;

    public Token() {
    }

    public String getToken(String userId, String userType, String userName, String branch) {
        String token = "";
        try {
            Date date = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.DATE, 1);
            token = Jwts.builder()
                    .setId(userId)
                    .setIssuer(userName)
                    .setSubject(userType)
                    .setAudience(branch)
                    .setIssuedAt(date)
                    .setExpiration(c.getTime())
                    .signWith(SignatureAlgorithm.HS256, tokensecretkey).compact();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Token Generate " + token);
        return token;
    }

    public Token(String Authorization) {
        if (Authorization.contains("Bearer ")) {
            final String token = Authorization.substring(7);
            try {
                final Claims claims = Jwts.parser().setSigningKey(tokensecretkey).parseClaimsJws(token).getBody();
                status = true;
                userCode = claims.getId();
                userName = claims.getIssuer();
                userType = claims.getSubject();
                branch = claims.getAudience();
            } catch (Exception e) {
                System.out.println(e);
                userType = "";
                userCode = "";
                userName = "";
                branch = "";
                status = false;
            }
        } else {
            userType = "";
            userCode = "";
            userName = "";
            branch = "";
            status = false;
        }

    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

}

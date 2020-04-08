package com.redhat.quarkushackfest.team1.util;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.googleapis.auth.oauth2.GooglePublicKeysManager;
import com.google.api.client.http.apache.ApacheHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

/** Tool for verifying JWT Tokens for Bots in Hangouts Chat. */
public class JWTVerify {
  // Bearer Tokens received by bots will always specify this issuer.
  static String CHAT_ISSUER = "chat@system.gserviceaccount.com";

  // Url to obtain the public certificate for the issuer.
  static String PUBLIC_CERT_URL_PREFIX =
      "https://www.googleapis.com/service_accounts/v1/metadata/x509/";

  // Intended audience of the token, which will be the project number of the bot.
  static String AUDIENCE = "748122792428";


  public static boolean verify(String token) throws GeneralSecurityException, IOException {
	  
	token = token.replaceAll("Bearer ", "");
	  
	System.out.println("Verifying token "+ token);
	
    JsonFactory factory = new JacksonFactory();

    GooglePublicKeysManager.Builder keyManagerBuilder =
        new GooglePublicKeysManager.Builder(new ApacheHttpTransport(), factory);

    String certUrl = PUBLIC_CERT_URL_PREFIX + CHAT_ISSUER;
    keyManagerBuilder.setPublicCertsEncodedUrl(certUrl);

    GoogleIdTokenVerifier.Builder verifierBuilder =
        new GoogleIdTokenVerifier.Builder(keyManagerBuilder.build());
    verifierBuilder.setIssuer(CHAT_ISSUER);
    GoogleIdTokenVerifier verifier = verifierBuilder.build();

    GoogleIdToken idToken = GoogleIdToken.parse(factory, token);
    if (idToken == null) {
      System.out.println("Token cannot be parsed");
      return false;
    }

    // Verify valid token, signed by CHAT_ISSUER.
    if (!verifier.verify(idToken)
        || !idToken.verifyAudience(Collections.singletonList(AUDIENCE))
        || !idToken.verifyIssuer(CHAT_ISSUER)) {
      System.out.println("Invalid token");
      
      return false;
    }

    System.out.println("Token is OK");
    return true;
  }
}

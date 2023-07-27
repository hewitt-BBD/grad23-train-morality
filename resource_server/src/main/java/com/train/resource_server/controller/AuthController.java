package com.train.resource_server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

@RestController
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest authRequest) throws GeneralSecurityException, IOException {

        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), new GsonFactory())
                .setAudience(Collections.singletonList(authRequest.getClientId()))
                .build();

        GoogleIdToken idToken = verifier.verify(authRequest.getIdToken());
        if (idToken != null) {
            Payload payload = idToken.getPayload();

            String userId = payload.getSubject();

            String email = payload.getEmail();
            boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
            String name = (String) payload.get("name");

            //System.out.println("User ID: " + userId + "\nEmail: " + email + "\nName: " + name);

            return ResponseEntity.ok().build();

        } else {
            System.out.println("Invalid ID token.");
            return ResponseEntity.notFound().build();
        }
    }
}


class AuthRequest {
    private String idToken;
    private String clientId;

    public AuthRequest(String idToken, String clientId) {
        this.idToken = idToken;
        this.clientId = clientId;
    }

    public String getIdToken() {
        return idToken;
    }

    public String getClientId() {
        return clientId;
    }

}


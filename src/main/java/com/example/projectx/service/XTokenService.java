package com.example.projectx.service;

import com.example.projectx.data.models.Token;
import com.example.projectx.data.repositories.TokenRepository;
import com.example.projectx.exceptions.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

import static com.example.projectx.exceptions.ExceptionMessages.INVALID_TOKEN_EMAIL;

@Service
@AllArgsConstructor
public class XTokenService implements TokenService{

    private final TokenRepository tokenRepository;
    @Override
    public String createToken(String userEmail) {
        String token = generateToken();
        Token userToken = new Token();
        userToken.setToken(token);
        userToken.setOwnerEmail(userEmail);

        Token savedToken = tokenRepository.save(userToken);

        String tokenToSend = savedToken.getToken();

        return tokenToSend;
    }

    @Override
    public Token findOwnerByEmail(String email) {
        Token token = tokenRepository.findOwnerByEmail(email)
                .orElseThrow(()-> new UserNotFoundException(INVALID_TOKEN_EMAIL.getMessage()));
        return token;
    }

    @Override
    public void deleteToken(String id) {
        tokenRepository.deleteById(id);

    }

    private String generateToken(){
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < 5; i++){
            Random random = new Random();
            int digits = random.nextInt(1, 9);
            otp.append(digits);

        }
        return String.valueOf(otp);
    }
}

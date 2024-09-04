package com.engagehub.api.dgs;

import com.engagehub.api.model.AuthenticationUser;
import com.engagehub.api.model.AuthenticationSession;
import com.engagehub.api.service.AuthenticationService;
import org.springframework.stereotype.Component;
import graphql.schema.DataFetcher;

@Component
public class AuthenticationDataFetcher {

    private final AuthenticationService authenticationService;

    public AuthenticationDataFetcher(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    public DataFetcher<AuthenticationUser> getUserByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            Long userId = dataFetchingEnvironment.getArgument("id");
            return authenticationService.getUserById(userId);
        };
    }

    public DataFetcher<AuthenticationSession> getSessionByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            Long sessionId = dataFetchingEnvironment.getArgument("id");
            return authenticationService.getSessionById(sessionId);
        };
    }

    // Add other DataFetchers if needed
}

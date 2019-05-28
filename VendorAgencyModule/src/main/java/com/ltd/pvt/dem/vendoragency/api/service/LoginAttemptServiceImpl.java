package com.ltd.pvt.dem.vendoragency.api.service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;


@Service
public class LoginAttemptServiceImpl implements  LoginAttemptService {

	
	private static final Logger log = LoggerFactory.getLogger(LoginAttemptServiceImpl.class);

    private final int MAX_ATTEMPT = 3;
    private LoadingCache<String, Integer> attemptsCache;

    public LoginAttemptServiceImpl() {
        super();
       log.debug("LoginAttemptServiceImpl.LoginAttemptServiceImpl()");
        attemptsCache = CacheBuilder.newBuilder().expireAfterWrite(2, TimeUnit.MINUTES).build(new CacheLoader<String, Integer>() {
            @Override
            public Integer load(final String key) {
                return 0;
            }
        });
    }

    public void loginSucceeded(String key) {
    	log.debug("LoginAttemptServiceImpl.loginSucceeded()");
        attemptsCache.invalidate(key);
    }

    public void loginFailed(String key) {
        int attempts = 0;
        log.debug("LoginAttemptServiceImpl.loginFailed()");
        try {
            attempts = attemptsCache.get(key);
        } catch (ExecutionException e) {
            attempts = 0;
        }
        attempts++;
        attemptsCache.put(key, attempts);
    }

    public boolean isBlocked(String key) {
    	log.debug("LoginAttemptServiceImpl.isBlocked()");
        try {
        	
            return attemptsCache.get(key) >= MAX_ATTEMPT;
        } catch (ExecutionException e) {
            log.warn("You are blocked     "+e.getMessage());
            return false;
        }
    }
}

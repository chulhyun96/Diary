package com.cheolhyeon.diary.security;

import com.cheolhyeon.diary.entity.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@Getter
public class CustomOAuth2User implements OAuth2User {

    private final OAuth2User oauth2User;
    private final User user;

    public CustomOAuth2User(OAuth2User oauth2User, User user) {
        this.oauth2User = oauth2User;
        this.user = user;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return oauth2User.getAttributes();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getName() {
        return user.getKakaoId();
    }

    public String getKakaoId() {
        return user.getKakaoId();
    }

    public String getNickname() {
        return user.getNickname();
    }

}
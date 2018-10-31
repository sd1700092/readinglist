package com.eastmoney.readinglist;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Collection;
import java.util.Collections;

/**
 * @author Administrator
 * created: 2018-10-31 17:41
 */
@Entity
public class Reader implements UserDetails {
    private static final long serialVersionUID = 1L;

    @Id
    private String username;
    private String fullname;
    private String password;
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getFullname() {
        return fullname;
    }
    
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("READER"));
    }
    
    
    @Override
    public boolean isAccountNonExpired() {
        return true; // 不过期，不加锁，不禁用
    }
    
    @Override
    public boolean isAccountNonLocked() {
        return true; // 不过期，不加锁，不禁用
    }
    
    @Override
    public boolean isCredentialsNonExpired() {
        return true; // 不过期，不加锁，不禁用
    }
    
    @Override
    public boolean isEnabled() {
        return true; // 不过期，不加锁，不禁用
    }
}

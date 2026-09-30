package com.example.oop;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.regex.Pattern;

public class User {
    // 私有字段：只能getter/setter
    private final long id;
    private String username;
    private String email;
    private final LocalDateTime createdAt;

    private static final Pattern EMAIL_PATTERN = 
        Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    
    // 全参构造器
    public User(long id, String username, String email, LocalDateTime createAt) {
        this.id = id;
        this.username = requireNonBlank(username, "username");
        setEmail(email);
        this.createdAt = Objects.requireNonNull(createAt, "createdAt");
    }

    // id自动生成，自动取时间的构造器
    public User(String username, String email) {
        this(IdGenerator.nextId(), username, email, LocalDateTime.now());
    }

    public long getId() {return id;}
    public String getUsername() {return username;}
    public String getEmail() {return email;}
    public LocalDateTime getCreatedAt() {return createdAt;}

    // setter: 只有可变字段才有
    public void setUsername(String username) {
        this.username = requireNonBlank(username, "username");
    }

    public void setEmail(String email) {
        if (email == null || !EMAIL_PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException("invalid email: " + email);
        }
        this.email = email;
    }

    private static String requireNonBlank(String v, String field) {
        if (v == null || v.isBlank()) {
            throw new IllegalArgumentException(field+" must not be blank");
        }
        return v;
    }

    @Override 
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
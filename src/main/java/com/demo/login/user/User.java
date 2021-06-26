package com.demo.login.user;

import com.demo.login.security.AuthenticationProvider;

import javax.persistence.*;

    @Entity
    @Table(name = "users")
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(nullable = false, unique = true, length = 45)
        private String email;

        @Enumerated(EnumType.STRING)
        @Column(name = "auth_provider")
        private AuthenticationProvider authProvider;

        @Column(nullable = false, length = 64)
        private String password;

        @Column(name = "first_name", nullable = false, length = 20)
        private String firstName;

        @Column(name = "last_name", nullable = false, length = 20)
        private String lastName;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
        public AuthenticationProvider getAuthProvider() {
            return authProvider;
        }

        public void setAuthProvider(AuthenticationProvider authProvider) {
            this.authProvider = authProvider;
        }

        // getters and setters are not shown

}

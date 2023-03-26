package com.mercadona.mercadona.service;

import com.mercadona.mercadona.model.Client;
import com.mercadona.mercadona.repository.UserRepository;
import com.mercadona.mercadona.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Client client = this.userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not exists"));

        return new UserDetailsImpl(client);
    }


}

package com.eazybytes.server.config;

import com.eazybytes.server.model.Customer;
import com.eazybytes.server.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EazyBankUserDetails implements UserDetailsService {

    final
    CustomerRepository customerRepository;

    public EazyBankUserDetails(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userName, password;
        List<GrantedAuthority> authorities;
        List<Customer> customer = customerRepository.findByEmail(username);
        if (customer.isEmpty()) {
            throw new UsernameNotFoundException("User details not found for the user : " + username);
        } else {
            userName = customer.get(0).getEmail();
            password = customer.get(0).getPassword();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(customer.get(0).getRole()));
        }
        return new User(userName, password, authorities);
    }
}

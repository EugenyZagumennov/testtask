package com.testtask.task.core.service;

import com.testtask.task.core.exception.WrongTimeException;
import com.testtask.task.core.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalTime;

/**
 * User service class
 *
 * @author Evgeniy Zagumennov
 */
@Service
@Transactional
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TimeService timeService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = userRepository.findByUsername(username);
        if (userDetails == null) {
            throw new UsernameNotFoundException(String.format("User '%s' wasn't found!", username));
        }
        if (!timeService.isBetweenEightAndFive(LocalTime.now())) {
            throw new WrongTimeException();
        }
        return userDetails;
    }
}

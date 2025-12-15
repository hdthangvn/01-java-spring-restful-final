package vn.hoidanit.jobhunter.service;

import java.lang.StackWalker.Option;

import java.util.Optional;
import org.springframework.stereotype.Service;
import vn.hoidanit.jobhunter.domain.User;
import vn.hoidanit.jobhunter.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User handleCreateUser(User user) {
        // Here you would typically add logic to save the user to the database
        // For example:
        return this.userRepository.save(user);
    }

    public void handleDeleteUser(Long id) {
        this.userRepository.deleteById(id);
    }

    public User fetchUserById(Long id) {
        Optional<User> userOptional = this.userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        }

        return null;
    }

    public java.util.List<User> fetchAllUsers() {
        return this.userRepository.findAll();
    }

    public User handleUpdateUser(User reUser) {
        User currentUser = this.fetchUserById(reUser.getId());
        if (currentUser != null) {
            currentUser.setName(reUser.getName());
            currentUser.setEmail(reUser.getEmail());
            currentUser.setPassword(reUser.getPassword());
            // update user
            currentUser = this.userRepository.save(currentUser);
        }
        return currentUser;
    }

    public User handleGetUserByUsername(String username) {
        return this.userRepository.findByEmail(username);
    }

}

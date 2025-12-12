package vn.hoidanit.jobhunter.service;

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
        // Logic to delete user by id
        this.userRepository.deleteById(id);
    }

}

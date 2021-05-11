package harbour.barber.service;

import harbour.barber.exception.UserException;
import harbour.barber.mapper.UserMapper;
import harbour.barber.model.Role;
import harbour.barber.model.User;
import harbour.barber.model.dto.UserDto;
import harbour.barber.repository.RoleRepository;
import harbour.barber.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    private final UserMapper mapper;

    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if(user == null){
            throw  new UsernameNotFoundException("User not found");
        }

        return user;
    }

    public List<UserDto> getAll(){
        return userRepository.findAll()
                .stream()
                .map(mapper::mapToUserDto)
                .collect(Collectors.toList());
    }

    public void add(UserDto request){
        User user = userRepository.findByUsername(request.getUsername());
        if(user != null){
            throw new UserException("User already exist");
        }
        Role role = roleRepository.findByName("ROLE_USER");
        user = mapper.mapToUser(request);
        user.setRoles(Set.of(role));
        user.setPassword(encoder.encode(request.getPassword()));
        userRepository.save(user);
    }

    public void remove(Long id){
        userRepository.deleteById(id);
    }

}

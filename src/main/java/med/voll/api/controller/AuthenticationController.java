package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.user.RegisteredUserData;
import med.voll.api.domain.user.User;
import med.voll.api.domain.user.UserRepository;
import med.voll.api.domain.user.authenticationData;
import med.voll.api.infra.security.DataTokenJWT;
import med.voll.api.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authorization")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    @Transactional
    public ResponseEntity executeLogin(@RequestBody @Valid authenticationData data) {
        var usernamePasswordAuthenticationTokenuthenticationToken = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var authentication = this.authenticationManager.authenticate(usernamePasswordAuthenticationTokenuthenticationToken);

        var tokenJWT = tokenService.generateToken((User) authentication.getPrincipal());

        return ResponseEntity.ok(new DataTokenJWT(tokenJWT));
    }

    @PostMapping("/register")
    @Transactional
    public ResponseEntity register(@RequestBody @Valid RegisteredUserData data) {
        if (this.userRepository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User user = new User(data.login(), encryptedPassword, data.role());

        this.userRepository.save(user);
        return ResponseEntity.ok().build();
    }

}

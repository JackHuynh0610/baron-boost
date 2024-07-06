package com.webapp.BaronBoost.security;

import com.webapp.BaronBoost.users.models.User;
import com.webapp.BaronBoost.users.services.UserService;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

/**
 * REST controller for handling user authentication operations.
 * This controller provides endpoints for user registration, email verification,
 * user authentication, and token generation.
 *
 * <p>
 * Example usage:
 * <pre>
 *     - POST /authenticate/signup: Create a new user and send a verification email.
 *     - GET /authenticate/verify: Verify a user using a verification code.
 *     - POST /authenticate/signin: Authenticate user credentials and generate a JWT token.
 * </pre>
 * </p>
 */
@RestController
@CrossOrigin
@RequestMapping("/authenticate")
public class AuthenticationController {

    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

/*    private String htmlFilePathVS = "/verify_success.html"; //VS = verify success
    private String cssFilePathVS = "/verify_success.css";
    private String htmlFilePathVF = "/verify_fail.html"; //VF = verify fail
    private String cssFilePathVF = "/verify_fail.css";*/

    /**
     * Constructor for AuthenticationController.
     *
     * @param userService           the UserService instance
     * @param jwtService            the JwtService instance
     * @param authenticationManager the AuthenticationManager instance
     */
    public AuthenticationController(UserService userService, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    /**
     * Process user registration and send verification email.
     *
     * @param user    the User object containing registration details
     * @param request the HttpServletRequest object
     * @return ResponseEntity containing the saved user details and HTTP status
     * @throws MessagingException if an error occurs while sending the verification email
     * @throws IOException        if an error occurs during file operations
     */


    @PostMapping("/signup")
    public ResponseEntity<Object> processRegister(@RequestBody User user, HttpServletRequest request) {
        try {
            Optional<User> existingUser = userService.findUserByUsername(user.getUsername());
            if (existingUser.isPresent()) {
                return new ResponseEntity<>("Username already exists", HttpStatus.BAD_REQUEST);
            }
            User savedUser = userService.saveUser(user, getSiteURL(request));
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Verify a user using the provided verification code.
     *
     * @param code the verification code
     * @return ResponseEntity containing the success or error message and HTTP status
     * @throws IOException if an error occurs during file operations
     */
/*    @GetMapping("/verify")
    public ResponseEntity<String> verifyUser(@RequestParam("code") String code) throws IOException {
        if (userService.verify(code)) {
            String successMessage = HTMLCSSToStringUtil.mergeHTMLAndCSS(htmlFilePathVS, cssFilePathVS);

            return new ResponseEntity<>(successMessage, HttpStatus.OK);
        } else {
            String errorMessage = HTMLCSSToStringUtil.mergeHTMLAndCSS(htmlFilePathVF, cssFilePathVF);
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }
    }*/
    @GetMapping("/verify")
    public ResponseEntity<String> verifyUser(@RequestParam("code") String code) {
        System.out.println("Incoming verification code: " + code);
        if (userService.verify(code)) {
            // Success message HTML with embedded CSS
            String successMessage = "<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                    "    <title>Verification Successful</title>\n" +
                    "    <style>\n" +
                    "        body {\n" +
                    "            font-family: Arial, sans-serif;\n" +
                    "            background-color: #1a1a1a;\n" +
                    "            margin: 0;\n" +
                    "            padding: 0;\n" +
                    "            color: #d3d3d3;\n" +
                    "        }\n" +
                    "        .container {\n" +
                    "            width: 90%;\n" +
                    "            max-width: 600px;\n" +
                    "            margin: 50px auto;\n" +
                    "            background-color: #2e2e2e;\n" +
                    "            border-radius: 8px;\n" +
                    "            padding: 20px;\n" +
                    "            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5);\n" +
                    "            border: 1px solid #4b0082;\n" +
                    "            text-align: center;\n" +
                    "        }\n" +
                    "        h1 {\n" +
                    "            color: #d3d3d3;\n" +
                    "        }\n" +
                    "        p {\n" +
                    "            color: #d3d3d3;\n" +
                    "            line-height: 1.6;\n" +
                    "            margin-bottom: 10px;\n" +
                    "        }\n" +
                    "        .footer {\n" +
                    "            text-align: center;\n" +
                    "            margin-top: 20px;\n" +
                    "            font-size: 0.9em;\n" +
                    "            color: #a9a9a9;\n" +
                    "        }\n" +
                    "        @media only screen and (max-width: 600px) {\n" +
                    "            .container {\n" +
                    "                padding: 10px;\n" +
                    "            }\n" +
                    "            .footer {\n" +
                    "                font-size: 0.8em;\n" +
                    "            }\n" +
                    "        }\n" +
                    "    </style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <div class=\"container\">\n" +
                    "        <h1>Verification Successful !!!</h1>\n" +
                    "        <p>Dear User,</p>\n" +
                    "        <p>Thank you for trusting and using our services!</p>\n" +
                    "        <p>Your email has been successfully verified. You can now log in and start using your Baron Boost account.</p>\n" +
                    "        <p>Thank you for verifying your email address.</p>\n" +
                    "        <p>Best regards,</p>\n" +
                    "        <p>The Baron Boost Team</p>\n" +
                    "        <div class=\"footer\">\n" +
                    "            &copy; <span id=\"current-year\"></span> Baron Boost. All rights reserved.\n" +
                    "        </div>\n" +
                    "    </div>\n" +
                    "    <script>\n" +
                    "        document.getElementById(\"current-year\").textContent = new Date().getFullYear();\n" +
                    "    </script>\n" +
                    "</body>\n" +
                    "</html>";

            return new ResponseEntity<>(successMessage, HttpStatus.OK);
        } else {
            // Error message HTML with embedded CSS
            String errorMessage = "<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                    "    <title>Verification Failed</title>\n" +
                    "    <style>\n" +
                    "        body {\n" +
                    "            font-family: Arial, sans-serif;\n" +
                    "            background-color: #1a1a1a;\n" +
                    "            margin: 0;\n" +
                    "            padding: 0;\n" +
                    "            color: #d3d3d3;\n" +
                    "        }\n" +
                    "        .container {\n" +
                    "            width: 90%;\n" +
                    "            max-width: 600px;\n" +
                    "            margin: 50px auto;\n" +
                    "            background-color: #2e2e2e;\n" +
                    "            border-radius: 8px;\n" +
                    "            padding: 20px;\n" +
                    "            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5);\n" +
                    "            border: 1px solid #4b0082;\n" +
                    "            text-align: center;\n" +
                    "        }\n" +
                    "        h1 {\n" +
                    "            color: #d3d3d3;\n" +
                    "        }\n" +
                    "        p {\n" +
                    "            color: #d3d3d3;\n" +
                    "            line-height: 1.6;\n" +
                    "            margin-bottom: 10px;\n" +
                    "        }\n" +
                    "        a {\n" +
                    "            color: #f4f1f7;\n" +
                    "            text-decoration: none;\n" +
                    "            background-color: #4b0082;\n" +
                    "            border-radius: 5px;\n" +
                    "            padding: 5px 10px;\n" +
                    "            transition: background-color 0.3s ease;\n" +
                    "        }\n" +
                    "        a:hover {\n" +
                    "            background-color: #6a0dad;\n" +
                    "        }\n" +
                    "        .footer {\n" +
                    "            text-align: center;\n" +
                    "            margin-top: 20px;\n" +
                    "            font-size: 0.9em;\n" +
                    "            color: #a9a9a9;\n" +
                    "        }\n" +
                    "        @media only screen and (max-width: 600px) {\n" +
                    "            .container {\n" +
                    "                padding: 10px;\n" +
                    "            }\n" +
                    "            .footer {\n" +
                    "                font-size: 0.8em;\n" +
                    "            }\n" +
                    "        }\n" +
                    "    </style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <div class=\"container\">\n" +
                    "        <h1>Verification Failed !!!</h1>\n" +
                    "        <p>Dear User,</p>\n" +
                    "        <p>We regret to inform you that your email verification has failed. Please try verifying your email again.</p>\n" +
                    "        <p>This occurs most likely due to the link already being used or our server encountering problems.</p>\n" +
                    "        <p>If you continue to experience issues, please contact our support team for assistance.</p>\n" +
                    "        <p>Contact us at: <a href=\"mailto:baronboostservice@gmail.com\">baronboostservice@gmail.com</a></p>\n" +
                    "        <p>Best regards,</p>\n" +
                    "        <p>The Baron Boost Team</p>\n" +
                    "        <div class=\"footer\">\n" +
                    "            &copy; <span id=\"current-year\"></span> Baron Boost. All rights reserved.\n" +
                    "        </div>\n" +
                    "    </div>\n" +
                    "    <script>\n" +
                    "        document.getElementById(\"current-year\").textContent = new Date().getFullYear();\n" +
                    "    </script>\n" +
                    "</body>\n" +
                    "</html>";

            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }
    }


    /**
     * Authenticate user credentials and generate a JWT token.
     *
     * @param authRequest the AuthRequest object containing user credentials
     * @return ResponseEntity containing the generated JWT token or an error message and HTTP status
     */
    @PostMapping("/signin")
    public ResponseEntity<String> authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            String token = jwtService.generateToken(authRequest.getUsername());
            return new ResponseEntity<>(token, HttpStatus.OK);
        } else {
            throw new UsernameNotFoundException("invalid user request!");
        }
    }

    /**
     * Retrieve the base URL of the site from the HTTP request.
     *
     * @param request the HttpServletRequest object
     * @return the base URL of the site as a String
     */
    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }
}
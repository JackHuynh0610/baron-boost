package com.webapp.BaronBoost.users.controllers;

import com.webapp.BaronBoost.users.models.User;
import com.webapp.BaronBoost.users.services.UserService;
import com.webapp.BaronBoost.utils.html_css_converter.HTMLCSSToStringUtil;
import com.webapp.BaronBoost.utils.password_utils.UtilityPasswordReset;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import net.bytebuddy.utility.RandomString;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Controller class for handling forgot password functionality.
 *
 * <p>
 * This controller provides endpoints for processing forgot password requests,
 * sending reset password emails, showing reset password forms, and processing
 * password reset requests.
 * </p>
 *
 * @see UserService
 * @see JavaMailSender
 * @see HTMLCSSToStringUtil
 * @see UtilityPasswordReset
 * @see ResponseEntity
 * @see HttpStatus
 * @see MimeMessage
 * @see MimeMessageHelper
 * @see RandomString
 * @see CrossOrigin
 * @see RestController
 * @see RequestMapping
 * @see PostMapping
 * @see GetMapping
 * @see RequestParam
 * @see IOException
 * @see MessagingException
 * @see HttpServletRequest
 * @see User
 * @see UsernameNotFoundException
 * @see HttpStatus
 */
@RestController
@CrossOrigin
@RequestMapping("/updatePassword")
public class ForgotPasswordController {

    private JavaMailSender mailSender;
    private UserService userService;

    // private String htmlFilePathPR = "/reset_password.html"; //PR = password reset
    // private String cssFilePathPR = "/reset_password.css";

    // private String htmlFilePathRPE = "src/main/resources/templates/reset_password_email.html"; //RPE = reset password email
    // private String cssFilePathRPE = "src/main/resources/templates/reset_password_email.css";

    // private String htmlFilePathPRS = "/password_reset_success.html"; //PRS = password reset success
    // private String cssFilePathPRS = "/password_reset_success.css";

    // private String htmlFilePathPRF = "/password_reset_fail.html"; //PRF = passsword reset fail
    // private String cssFilePathPRF = "/password_reset_fail.css";

    public ForgotPasswordController(UserService userService, JavaMailSender mailSender) {
        this.userService = userService;
        this.mailSender = mailSender;
    }

    /**
     * Process the forgot password request and send an email with a reset password link.
     *
     * @param request the HTTP servlet request
     * @return a response entity with a message indicating the status of the process
     * @throws IOException if an I/O error occurs while processing the request
     */
    @PostMapping("/forgotPassword")
    public ResponseEntity<String> processForgotPassword(HttpServletRequest request) throws IOException {
        String username = request.getParameter("username");
        String token = RandomString.make(30);

        try {
            userService.updateResetPasswordToken(token, username);
            User user = userService.findUserByUsername(username).get();
            String resetPasswordLink = UtilityPasswordReset.getSiteURL(request) + "/updatePassword/resetPassword?token=" + token;
            sendEmail(user.getEmail(), resetPasswordLink);
            return new ResponseEntity<>("We have sent a reset password link to your email. Please check.", HttpStatus.OK);
        } catch (UsernameNotFoundException ex) {
            return new ResponseEntity<>("Username not found", HttpStatus.NOT_FOUND);
        } catch (UnsupportedEncodingException | MessagingException e) {
            return new ResponseEntity<>("Error fail to send email", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Send an email with the reset password link.
     *
     * @param recipientEmail the email address of the recipient
     * @param link           the reset password link
     * @throws MessagingException if an error occurs while sending the email
     * @throws IOException        if an I/O error occurs while processing the email content
     */
    public void sendEmail(String recipientEmail, String link) throws MessagingException, IOException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        String senderEmail = "baronboostservice@gmail.com";
        String senderName = "Baron Boost";
        String subject = "Here's the link to reset your password";
        //String content = HTMLCSSToStringUtil.mergeHTMLAndCSSWithToken(htmlFilePathRPE, cssFilePathRPE, link);
        String content = "<!DOCTYPE html>\n" +
    "<html lang=\"en\">\n" +
    "<head>\n" +
    "    <meta charset=\"UTF-8\">\n" +
    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
    "    <title>Reset Password Email</title>\n" +
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
    "            margin: 20px auto;\n" +
    "            background-color: #2e2e2e;\n" +
    "            border-radius: 8px;\n" +
    "            padding: 20px;\n" +
    "            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5);\n" +
    "            border: 1px solid #4b0082;\n" +
    "        }\n" +
    "        p {\n" +
    "            color: #d3d3d3;\n" +
    "            line-height: 1.6;\n" +
    "            margin-bottom: 10px;\n" +
    "        }\n" +
    "        a {\n" +
    "            color: #000000;\n" +
    "            background-color: #f4f1f7;\n" +
    "            border: 1px solid #4b0082;\n" +
    "            padding: 10px 20px;\n" +
    "            text-decoration: none;\n" +
    "            border-radius: 5px;\n" +
    "            display: inline-block;\n" +
    "            margin-top: 10px;\n" +
    "            transition: background-color 0.3s ease;\n" +
    "        }\n" +
    "        a:visited {\n" +
    "            color: #fff;\n" +
    "        }\n" +
    "        a:hover {\n" +
    "            background-color: #6a0dad;\n" +
    "            border-color: #6a0dad;\n" +
    "        }\n" +
    "        .header {\n" +
    "            text-align: center;\n" +
    "            margin-bottom: 20px;\n" +
    "        }\n" +
    "        .header img {\n" +
    "            width: 100px;\n" +
    "            height: auto;\n" +
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
    "            a {\n" +
    "                padding: 8px 16px;\n" +
    "            }\n" +
    "            .header img {\n" +
    "                width: 80px;\n" +
    "            }\n" +
    "            .footer {\n" +
    "                font-size: 0.8em;\n" +
    "            }\n" +
    "        }\n" +
    "    </style>\n" +
    "</head>\n" +
    "<body>\n" +
    "    <div class=\"container\">\n" +
    "        <p>Dear User,</p>\n" +
    "        <p>We have received a request to reset your password for your Baron Boost account.</p>\n" +
    "        <p>If this request was not made by you, please ignore this email.</p>\n" +
    "        <p>Click the link below to securely change your password:</p>\n" +
    "        <p><a href=\"" + link + "\">Reset Password</a></p>\n" +
    "        <p>If you did not request a password reset, no further action is needed.</p>\n" +
    "        <p>Thank you for choosing Baron Boost.</p>\n" +
    "        <p>Best regards,</p>\n" +
    "        <p>The Baron Boost Team</p>\n" +
    "        <div class=\"footer\">\n" +
    "            &copy; <span id=\"current-year\"></span> Baron Boost. All rights reserved.\n" +
    "        </div>\n" +
    "        <script>\n" +
    "            document.getElementById(\"current-year\").textContent = new Date().getFullYear();\n" +
    "        </script>\n" +
    "    </div>\n" +
    "</body>\n" +
    "</html>";

        helper.setFrom(senderEmail, senderName);
        helper.setTo(recipientEmail);
        helper.setSubject(subject);
        helper.setText(content, true);
        mailSender.send(message);
    }

    /**
     * Show the reset password form.
     *
     * @param token the reset password token
     * @return a response entity with the reset password form or an error message
     */
    @GetMapping("/resetPassword")
    public ResponseEntity<String> showResetPasswordForm(@RequestParam("token") String token) {
        User user = userService.getByResetPasswordToken(token);

        if (user == null) {
            return new ResponseEntity<>("Invalid Token", HttpStatus.BAD_REQUEST);
        }

        try {
//            String resetPasswordForm = HTMLCSSToStringUtil.mergeHTMLAndCSSWithToken(htmlFilePathPR, cssFilePathPR, token);
            String resetPasswordForm = generateResetPasswordForm(token);
            return new ResponseEntity<>(resetPasswordForm, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error retrieving HTML/CSS files", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private String generateResetPasswordForm(String token) throws IOException {
        // Define the HTML content with embedded CSS
        String htmlContent = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Reset Password</title>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            font-family: Arial, sans-serif;\n" +
                "            background-color: #1a1a1a;\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "            color: #d3d3d3;\n" +
                "        }\n" +
                "\n" +
                "        .container {\n" +
                "            width: 90%;\n" +
                "            max-width: 600px;\n" +
                "            margin: 20px auto;\n" +
                "            background-color: #2e2e2e;\n" +
                "            border-radius: 8px;\n" +
                "            padding: 20px;\n" +
                "            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5);\n" +
                "            border: 1px solid #4b0082;\n" +
                "        }\n" +
                "\n" +
                "        p {\n" +
                "            color: #d3d3d3;\n" +
                "            line-height: 1.6;\n" +
                "            margin-bottom: 10px;\n" +
                "        }\n" +
                "\n" +
                "        a {\n" +
                "            color: #000000;\n" +
                "            background-color: #f4f1f7;\n" +
                "            border: 1px solid #4b0082;\n" +
                "            padding: 10px 20px;\n" +
                "            text-decoration: none;\n" +
                "            border-radius: 5px;\n" +
                "            display: inline-block;\n" +
                "            margin-top: 10px;\n" +
                "            transition: background-color 0.3s ease;\n" +
                "        }\n" +
                "\n" +
                "        a:visited {\n" +
                "            color: #fff;\n" +
                "        }\n" +
                "\n" +
                "        a:hover {\n" +
                "            background-color: #6a0dad;\n" +
                "            border-color: #6a0dad;\n" +
                "        }\n" +
                "\n" +
                "        .header {\n" +
                "            text-align: center;\n" +
                "            margin-bottom: 20px;\n" +
                "        }\n" +
                "\n" +
                "        .header img {\n" +
                "            width: 100px;\n" +
                "            height: auto;\n" +
                "        }\n" +
                "\n" +
                "        .footer {\n" +
                "            text-align: center;\n" +
                "            margin-top: 20px;\n" +
                "            font-size: 0.9em;\n" +
                "            color: #a9a9a9;\n" +
                "        }\n" +
                "\n" +
                "        /* Media Queries */\n" +
                "        @media only screen and (max-width: 600px) {\n" +
                "            .container {\n" +
                "                padding: 10px;\n" +
                "            }\n" +
                "            a {\n" +
                "                padding: 8px 16px;\n" +
                "            }\n" +
                "            .header img {\n" +
                "                width: 80px;\n" +
                "            }\n" +
                "            .footer {\n" +
                "                font-size: 0.8em;\n" +
                "            }\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>Password Reset</h1>\n" +
                "    <form action=\"/updatePassword/resetPassword\" method=\"post\">\n" +
                "        <input type=\"hidden\" name=\"token\" value=\"" + token + "\">\n" +
                "        <p>Hello there,</p>\n" +
                "        <p>We noticed that you're resetting your password. Please enter your new password below:</p>\n" +
                "        <label for=\"password\">New Password:</label>\n" +
                "        <input type=\"password\" id=\"password\" name=\"password\" required>\n" +
                "        <br><br>\n" +
                "        <input type=\"submit\" value=\"Reset Password\">\n" +
                "        <p>If you didn't request this password reset, please ignore this email.</p>\n" +
                "        <p>Best regards,</p>\n" +
                "        <p>The Baron Boost Team</p>\n" +
                "    </form>\n" +
                "    <div class=\"footer\">\n" +
                "        <p>From Yeh: \"If you forget your password, you probably forget to ping for your team!\"</p>\n" +
                "        &copy; <span id=\"current-year\"></span> Baron Boost. All rights reserved.\n" +
                "    </div>\n" +
                "    <script>\n" +
                "        document.getElementById(\"current-year\").textContent = new Date().getFullYear();\n" +
                "    </script>\n" +
                "</body>\n" +
                "</html>";

        return htmlContent;
    }

    /**
     * Process the reset password request.
     *
     * @param request the HTTP servlet request
     * @return a response entity with a success message or an error message
     * @throws IOException if an I/O error occurs while processing the request
     */
/*    @PostMapping("/resetPassword")
    public ResponseEntity<String> processResetPassword(HttpServletRequest request) throws IOException {
        String token = request.getParameter("token");
        String password = request.getParameter("password");

        User customer = userService.getByResetPasswordToken(token);

        if (customer == null) {
            String fail = HTMLCSSToStringUtil.mergeHTMLAndCSS(htmlFilePathPRF, cssFilePathPRF);
            return new ResponseEntity<>(fail, HttpStatus.BAD_REQUEST);
        } else {
            String success = HTMLCSSToStringUtil.mergeHTMLAndCSS(htmlFilePathPRS, cssFilePathPRS);
            userService.updatePassword(customer, password);
            return new ResponseEntity<>(success, HttpStatus.OK);
        }
    }*/
    @PostMapping("/resetPassword")
    public ResponseEntity<String> processResetPassword(HttpServletRequest request) {
        String token = request.getParameter("token");
        String password = request.getParameter("password");

        User customer = userService.getByResetPasswordToken(token);

        if (customer == null) {
            // HTML and CSS for failure response
            String failHtml = "<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                    "    <title>Password Reset Failed</title>\n" +
                    "    <style>\n" +
                    "        body {\n" +
                    "            font-family: Arial, sans-serif;\n" +
                    "            background-color: #1a1a1a;\n" +
                    "            margin: 0;\n" +
                    "            padding: 0;\n" +
                    "            color: #d3d3d3;\n" +
                    "        }\n" +
                    "\n" +
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
                    "\n" +
                    "        h1 {\n" +
                    "            color: #d3d3d3;\n" +
                    "        }\n" +
                    "\n" +
                    "        p {\n" +
                    "            color: #d3d3d3;\n" +
                    "            line-height: 1.6;\n" +
                    "            margin-bottom: 10px;\n" +
                    "        }\n" +
                    "\n" +
                    "        a {\n" +
                    "            color: #f4f1f7;\n" +
                    "            text-decoration: none;\n" +
                    "            background-color: #4b0082;\n" +
                    "            border-radius: 5px;\n" +
                    "            padding: 5px 10px;\n" +
                    "            transition: background-color 0.3s ease;\n" +
                    "        }\n" +
                    "\n" +
                    "        a:hover {\n" +
                    "            background-color: #6a0dad;\n" +
                    "        }\n" +
                    "\n" +
                    "        .footer {\n" +
                    "            text-align: center;\n" +
                    "            margin-top: 20px;\n" +
                    "            font-size: 0.9em;\n" +
                    "            color: #a9a9a9;\n" +
                    "        }\n" +
                    "\n" +
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
                    "        <h1>Password Reset Failed !!!</h1>\n" +
                    "        <p>Dear User,</p>\n" +
                    "        <p>Unfortunately, we were unable to reset your password.</p>\n" +
                    "        <p>Please try again or contact our support team for assistance.</p>\n" +
                    "        <p>Contact us at: <a href=\"mailto:baronboostservice@gmail.com\">baronboostservice@gmail.com</a></p>\n" +
                    "        <p>We apologize for the inconvenience.</p>\n" +
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

            return new ResponseEntity<>(failHtml, HttpStatus.BAD_REQUEST);
        } else {
            // HTML and CSS for success response (as previously provided)
            String successHtml = "<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                    "    <title>Password Reset Success</title>\n" +
                    "    <style>\n" +
                    "        body {\n" +
                    "            font-family: Arial, sans-serif;\n" +
                    "            background-color: #1a1a1a;\n" +
                    "            margin: 0;\n" +
                    "            padding: 0;\n" +
                    "            color: #d3d3d3;\n" +
                    "        }\n" +
                    "\n" +
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
                    "\n" +
                    "        h1 {\n" +
                    "            color: #d3d3d3;\n" +
                    "        }\n" +
                    "\n" +
                    "        p {\n" +
                    "            color: #d3d3d3;\n" +
                    "            line-height: 1.6;\n" +
                    "            margin-bottom: 10px;\n" +
                    "        }\n" +
                    "\n" +
                    "        a {\n" +
                    "            color: #f4f1f7;\n" +
                    "            text-decoration: none;\n" +
                    "            background-color: #4b0082;\n" +
                    "            border-radius: 5px;\n" +
                    "            padding: 5px 10px;\n" +
                    "            transition: background-color 0.3s ease;\n" +
                    "        }\n" +
                    "\n" +
                    "        a:hover {\n" +
                    "            background-color: #6a0dad;\n" +
                    "        }\n" +
                    "\n" +
                    "        .footer {\n" +
                    "            text-align: center;\n" +
                    "            margin-top: 20px;\n" +
                    "            font-size: 0.9em;\n" +
                    "            color: #a9a9a9;\n" +
                    "        }\n" +
                    "\n" +
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
                    "        <h1>Password Reset Successful !!!</h1>\n" +
                    "        <p>Dear User,</p>\n" +
                    "        <p>Your password has been successfully reset.</p>\n" +
                    "        <p>You can now log in to your Baron Boost account using your new password.</p>\n" +
                    "        <p>If you did not request this change, please just ignore the email or alternatively contact us.</p>\n" +
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

            // Update password and return success response
            userService.updatePassword(customer, password);
            return new ResponseEntity<>(successHtml, HttpStatus.OK);
        }
    }
}
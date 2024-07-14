package com.webapp.BaronBoost.stripe.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.webapp.BaronBoost.stripe.dto.CreatePaymentRequest;
import com.webapp.BaronBoost.stripe.dto.StripeResponse;
import com.webapp.BaronBoost.stripe.service.StripeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/stripe")
@RequiredArgsConstructor
public class StripeController {

    private final StripeService stripeService;

    @SuppressWarnings("rawtypes")
    @PostMapping("/create-payment")
    public ResponseEntity<StripeResponse> createPayment(@RequestBody CreatePaymentRequest createPaymentRequest) {
        StripeResponse stripeResponse = stripeService.createPayment(createPaymentRequest);
        return ResponseEntity
                .status(stripeResponse.getHttpStatus())
                .body(stripeResponse);
    }

    @SuppressWarnings("rawtypes")
    @GetMapping("/capture-payment")
    public ResponseEntity<StripeResponse> capturePayment(@RequestParam String sessionId) {
    StripeResponse stripeResponse = stripeService.capturePayment(sessionId);
          return ResponseEntity
                 .status(stripeResponse.getHttpStatus())
                 .body(stripeResponse);
     }
}
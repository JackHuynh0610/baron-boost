package com.webapp.BaronBoost.purge.controllers;



import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.BaronBoost.purge.services.PurgeService;


@CrossOrigin
@RestController
@RequestMapping("/warning")
public class PurgeController {
    
    private final PurgeService purgeService;

    public PurgeController(PurgeService purgeService){
        this.purgeService = purgeService;
    }

    @DeleteMapping("/purge")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> wipeOutDatabase(){
        purgeService.wipeData();
        return ResponseEntity.ok("All customers and orders are deleted permanantly, booster status are now set to NOT_BOOSTING. This action could not be revert");
    }
}

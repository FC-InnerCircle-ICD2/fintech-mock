package com.ic.mockserver

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthCheckController {

    @GetMapping("/health-check")
    fun health(): ResponseEntity<String> {
        return ResponseEntity.ok().body("ok")
    }
}
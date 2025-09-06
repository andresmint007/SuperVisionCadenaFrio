package com.medisuply.supervisioncadenafrio.controller;

import com.medisuply.supervisioncadenafrio.dto.RequestDTO;
import com.medisuply.supervisioncadenafrio.entity.Request;
import com.medisuply.supervisioncadenafrio.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class RequestController {
    
    private final RequestService requestService;
    
    @PostMapping("/createrequest")
    public ResponseEntity<?> processTemperatureRequest(@Valid @RequestBody RequestDTO requestDTO) {
        Map<String, Object> response = new HashMap<>();
        try {
            // Save request in logs
            Request savedRequest = requestService.saveRequest(requestDTO);
            
            // process
            String status = analyzeTemperature(requestDTO.getTemperature(), requestDTO.getType());
            String action = determineAction(requestDTO.getTemperature(), requestDTO.getType());
            
            // create response
            response.put("requestId", savedRequest.getId());
            response.put("status", status);
            response.put("action", action);
            response.put("temperature", requestDTO.getTemperature());
            response.put("type", requestDTO.getType());
            response.put("timestamp", System.currentTimeMillis());
            response.put("mensaje", "Sucess");
            
            return new ResponseEntity<>(response, HttpStatus.OK);
            
        } catch (Exception e) {
            response.put("mensaje", "error processing request");
            response.put("errors", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    private String analyzeTemperature(Double temperature, String type) {
        if (temperature == null) return "UNKNOWN";
        
        // Logique d'analyse selon le type de capteur
        switch (type.toUpperCase()) {
            case "TEMPERATURE_SENSOR":
            case "FRIDGE":
                if (temperature < -18) return "TOO_COLD";
                if (temperature > 8) return "TOO_HOT";
                return "NORMAL";
                
            case "FREEZER":
                if (temperature < -25) return "TOO_COLD";
                if (temperature > -15) return "TOO_HOT";
                return "NORMAL";
                
            case "ROOM":
                if (temperature < 18) return "TOO_COLD";
                if (temperature > 25) return "TOO_HOT";
                return "NORMAL";
                
            default:
                return "UNKNOWN_TYPE";
        }
    }
    
    private String determineAction(Double temperature, String type) {
        String status = analyzeTemperature(temperature, type);
        
        switch (status) {
            case "TOO_COLD":
                return "INCREASE_TEMPERATURE";
            case "TOO_HOT":
                return "DECREASE_TEMPERATURE";
            case "NORMAL":
                return "MAINTAIN_TEMPERATURE";
            default:
                return "CHECK_SENSOR";
        }
    }
}

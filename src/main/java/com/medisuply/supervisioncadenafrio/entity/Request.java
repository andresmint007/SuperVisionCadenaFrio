package com.medisuply.supervisioncadenafrio.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.Instant;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("requests")
public class Request {
    
    @PrimaryKey
    private UUID id;
    
    private Double temperature;
    
    private String type;
    
    private Instant timestamp;
    
    public Request(Double temperature, String type) {
        this.id = UUID.randomUUID();
        this.temperature = temperature;
        this.type = type;
        this.timestamp = Instant.now();
    }
}

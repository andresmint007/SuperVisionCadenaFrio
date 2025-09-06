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
    
    private Double temperatura;

    private String ubicacion;
    
    private String tipoSensor;
    
    private Instant timestamp;
    
    public Request(Double temperatura, String tipoSensor) {
        this.id = UUID.randomUUID();
        this.temperatura = temperatura;
        this.tipoSensor = tipoSensor;
        this.timestamp = Instant.now();
    }
}

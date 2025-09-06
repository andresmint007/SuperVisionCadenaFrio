package com.medisuply.supervisioncadenafrio.dto;

public class NotificationDTO {
    private String to = "andreslab7@gmail.com";
    private String subject;
    private String content;
    private String phone = "+573174669534";
    private String contentPhone;

    // Constructor vacío
    public NotificationDTO() {}

    // Constructor con parámetros
    public NotificationDTO(String to, String subject, String content, String phone, String contentPhone) {
        this.to = to != null ? to : this.to;
        this.subject = subject;
        this.content = content;
        this.phone = phone != null ? phone : this.phone;
        this.contentPhone = contentPhone;
    }

    // Getters y setters
    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getContentPhone() {
        return contentPhone;
    }
    public void setContentPhone(String contentPhone) {
        this.contentPhone = contentPhone;
    }
}

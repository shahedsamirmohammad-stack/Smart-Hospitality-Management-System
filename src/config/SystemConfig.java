// Name: Shahed Samir Mohammed
// ID: 220231639
// Design Patterns Lab - Final Project
// Smart Hospitality Management System (SHMS)

package config;

import java.util.HashMap;
import java.util.Map;

public class SystemConfig {
    
    // Singleton instance
    private static SystemConfig instance = null;
    
    // Configuration settings
    private String hotelName;
    private String hotelAddress;
    private String phoneNumber;
    private String email;
    private double taxRate;
    private Map<String, Boolean> availableServices;
    
    // Private constructor (Singleton pattern)
    private SystemConfig() {
        this.hotelName = "Smart Hospitality Hotel";
        this.hotelAddress = "Gaza City, Palestine";
        this.phoneNumber = "+970 59 999 9999";
        this.email = "info@smarthotel.ps";
        this.taxRate = 0.16; // 16% tax
        
        this.availableServices = new HashMap<>();
        availableServices.put("Breakfast", true);
        availableServices.put("Dinner", true);
        availableServices.put("Spa", true);
        availableServices.put("Parking", true);
        availableServices.put("WiFi", true);
        availableServices.put("Laundry", false);
    }
    
    // Get singleton instance
    public static SystemConfig getInstance() {
        if (instance == null) {
            instance = new SystemConfig();
        }
        return instance;
    }
    
    // Getters and Setters
    public String getHotelName() { return hotelName; }
    public void setHotelName(String hotelName) { this.hotelName = hotelName; }
    
    public String getHotelAddress() { return hotelAddress; }
    public void setHotelAddress(String hotelAddress) { this.hotelAddress = hotelAddress; }
    
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public double getTaxRate() { return taxRate; }
    public void setTaxRate(double taxRate) { this.taxRate = taxRate; }
    
    public boolean isServiceAvailable(String service) {
        return availableServices.getOrDefault(service, false);
    }
    
    public void addService(String service) {
        availableServices.put(service, true);
        System.out.println("[CONFIG] Service added: " + service);
    }
    
    public void removeService(String service) {
        availableServices.put(service, false);
        System.out.println("[CONFIG] Service removed: " + service);
    }
    
    public void displayConfig() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║     HOTEL SYSTEM CONFIGURATION        ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ Hotel Name: " + hotelName);
        System.out.println("║ Address: " + hotelAddress);
        System.out.println("║ Phone: " + phoneNumber);
        System.out.println("║ Email: " + email);
        System.out.println("║ Tax Rate: " + (taxRate * 100) + "%");
        System.out.println("║ Available Services: " + availableServices.keySet());
        System.out.println("╚════════════════════════════════════════╝\n");
    }
}
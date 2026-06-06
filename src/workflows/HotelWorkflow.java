// Name: Shahed Samir Mohammed
// ID: 220231639
// Design Patterns Lab - Final Project
// Smart Hospitality Management System (SHMS)

package workflows;

import notifications.NotificationService;

public abstract class HotelWorkflow {
    protected String workflowName;
    protected NotificationService notificationService;
    
    public HotelWorkflow(String name, NotificationService notificationService) {
        this.workflowName = name;
        this.notificationService = notificationService;
    }
    
    // Template Method - defines the fixed structure
    public final void executeWorkflow() {
        System.out.println("\n╔══════════════════════════════════════════════════════════╗");
        System.out.println("║  Starting: " + workflowName);
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        
        notificationService.notifyObservers("WORKFLOW_START", workflowName + " has begun");
        
        stepOne();
        stepTwo();
        stepThree();
        stepFour(); // optional, can be empty
        stepFive(); // optional, can be empty
        
        notificationService.notifyObservers("WORKFLOW_COMPLETE", workflowName + " has completed");
        
        System.out.println("\n╔══════════════════════════════════════════════════════════╗");
        System.out.println("║  Completed: " + workflowName);
        System.out.println("╚══════════════════════════════════════════════════════════╝\n");
    }
    
    // Steps to be implemented by subclasses
    protected abstract void stepOne();
    protected abstract void stepTwo();
    protected abstract void stepThree();
    
    // Optional steps (can be overridden if needed)
    protected void stepFour() {
        // Optional - do nothing by default
    }
    
    protected void stepFive() {
        // Optional - do nothing by default
    }
    
    public String getWorkflowName() {
        return workflowName;
    }
}
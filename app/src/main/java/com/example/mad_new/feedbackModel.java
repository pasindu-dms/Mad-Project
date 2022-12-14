package com.example.mad_new;

public class feedbackModel {
    String name;
    String feedback;

    public feedbackModel(){

    }
    public feedbackModel(String feeeback){
        this.feedback=feeeback;
    }

    public feedbackModel( String feedback,String name) {
        this.name = name;
        this.feedback = feedback;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }


}

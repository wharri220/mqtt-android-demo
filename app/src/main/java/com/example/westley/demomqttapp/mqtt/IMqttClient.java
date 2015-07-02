package com.example.westley.demomqttapp.mqtt;

public interface IMqttClient {
    public void connect();
    public void disconnect();
    public void publish(String topic, String payload);
    public void subscribe(String topic);
    public void destroy();
}

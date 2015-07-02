package com.example.westley.demomqttapp.mqtt;

import android.content.Context;
import android.util.Log;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MqttClient implements IMqttClient {

    private MqttAndroidClient client;
    private MqttConnectOptions mqttOptions;

    public MqttClient(Context ctx, String host, String deviceId, String password){
        mqttOptions = new MqttConnectOptions();
        mqttOptions.setUserName(deviceId);
        mqttOptions.setPassword(password.toCharArray());

        client = new MqttAndroidClient(ctx, host, deviceId);
    }

    public void connect(){
        try{
            client.connect(mqttOptions);
        }catch(MqttException ex){
            Log.e("MqttClient", ex.getMessage());
        }
    }

    public void disconnect(){
        try{
            client.disconnect();
        }catch (MqttException ex){
            Log.e("MqttClient", ex.getMessage());
        }
    }

    public void publish(String topic, String payload){
        MqttMessage message = new MqttMessage(payload.getBytes());
        try {
            client.publish(topic, message);
        }catch (MqttException ex){
            Log.e("MqttClient", ex.getMessage());
        }
    }

    public void subscribe(String topic){
        //not implemented
    }

    public void destroy(){
        client.unregisterResources();
    }
}

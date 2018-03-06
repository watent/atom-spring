package com.watent.spring.bean;

public class MongoClient {


    private String id;

    private String ip;

    private Integer port;

    public MongoClient(String ip, Integer port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    public String toString() {
        return "MongoClient{" +
                "id='" + id + '\'' +
                ", ip='" + ip + '\'' +
                ", port=" + port +
                '}';
    }
}

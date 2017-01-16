package com.example.hcd_fresher037.englishtutor.Topic;

/**
 * Created by HCD-Fresher037 on 1/10/2017.
 */

public class Topic {
    public int id;
    public String topicName;
    public String topicIntro;
    public String topicQues1;
    public String topicQues2;
    public String topicQues3;
    public byte[] anh;

    public Topic(int id, String topicName, String topicIntro, String topicQues1, String topicQues2, String topicQues3, byte[] anh) {
        this.id = id;
        this.topicName = topicName;
        this.topicIntro = topicIntro;
        this.topicQues1 = topicQues1;
        this.topicQues2 = topicQues2;
        this.topicQues3 = topicQues3;
        this.anh = anh;
    }
}

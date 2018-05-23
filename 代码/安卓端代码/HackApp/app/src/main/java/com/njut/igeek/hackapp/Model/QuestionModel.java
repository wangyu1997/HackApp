package com.njut.igeek.hackapp.Model;

import java.io.Serializable;

public class QuestionModel implements Serializable {

    String imgUrl;

    String question;

    String qA;
    String qB;
    String qC;
    String qD;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getqA() {
        return qA;
    }

    public void setqA(String qA) {
        this.qA = qA;
    }

    public String getqB() {
        return qB;
    }

    public void setqB(String qB) {
        this.qB = qB;
    }

    public String getqC() {
        return qC;
    }

    public void setqC(String qC) {
        this.qC = qC;
    }

    public String getqD() {
        return qD;
    }

    public void setqD(String qD) {
        this.qD = qD;
    }

    @Override
    public String toString() {
        return "QuestionModel{" +
                "imgUrl='" + imgUrl + '\'' +
                ", question='" + question + '\'' +
                ", qA='" + qA + '\'' +
                ", qB='" + qB + '\'' +
                ", qC='" + qC + '\'' +
                ", qD='" + qD + '\'' +
                '}';
    }
}

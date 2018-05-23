package com.malasong.server.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "pic_model")
@Data
public class PicModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String img_url;
    private String title;
    private String content;
}

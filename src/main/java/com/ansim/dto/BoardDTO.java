package com.ansim.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class BoardDTO {

    private int seqno;
    private String user_id;
    private LocalDate regdate;
    private String title;
    private String content;
    private String options;
    private double departure_LATITUDE;
    private double departure_LONGITUDE;
    private double destination_LATITUDE;
    private double destination_LONGITUDE;
    private LocalDateTime MEETING_TIME;
    private int hitno;
    private String departure;
    private String destination;

}

package com.neblessed.jobhunter_bot.model.headhunter_model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@Data
@NoArgsConstructor
public class HhPojo {
    private int id;
    private boolean premium;
    private String name;
    private int department;
    private boolean has_test;
    private boolean response_letter_required;
    private Area area;
    private Salary salary;
    private Type type;
    private Address address;
    private Object response_url;
    private Object sort_point_distance;
    private Date published_at;
    private Date created_at;
    private boolean archived;
    private String apply_alternate_url;
    private Object insider_interview;
    private String url;
    private String alternate_url;
    private ArrayList<Object> relations;
    private Employer employer;
    private Snippet snippet;
    private Object contacts;
    private Object schedule;
    private ArrayList<Object> working_days;
    private ArrayList<Object> working_time_intervals;
    private ArrayList<Object> working_time_modes;
    private boolean accept_temporary;
    private ArrayList<ProfessionalRole> professional_roles;
    private boolean accept_incomplete_resumes;
    private Experience experience;
    private Employment employment;
    private Object adv_response_url;
    public boolean is_adv_vacancy;

    public static class Address{
        public String city;
        public String street;
        public String building;
        public double lat;
        public double lng;
        public Object description;
        public String raw;
        public Metro metro;
        public ArrayList<MetroStation> metro_stations;
        public String id;
    }

    public static class Area{
        public String id;
        public String name;
        public String url;
    }

    public static class Employer{
        public String id;
        public String name;
        public String url;
        public String alternate_url;
        public LogoUrls logo_urls;
        public String vacancies_url;
        public boolean accredited_it_employer;
        public boolean trusted;
    }

    public static class Employment{
        public String id;
        public String name;
    }

    public static class Experience{
        public String id;
        public String name;
    }

    public static class LogoUrls{
        @JsonProperty("90")
        public String _90;
        @JsonProperty("240")
        public String _240;
        public String original;
    }

    public static class Metro{
        public String station_name;
        public String line_name;
        public String station_id;
        public String line_id;
        public double lat;
        public double lng;
    }

    public static class MetroStation{
        public String station_name;
        public String line_name;
        public String station_id;
        public String line_id;
        public double lat;
        public double lng;
    }

    public static class ProfessionalRole{
        public String id;
        public String name;
    }

    public static class Salary{
        public int from;
        @JsonProperty("to")
        public int myto;
        public String currency;
        public boolean gross;
    }

    public static class Snippet{
        public String requirement;
        public String responsibility;
    }

    public static class Type{
        public String id;
        public String name;
    }
}

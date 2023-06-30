package com.neblessed.jobhunter_bot.model.headhunter_model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
public class Headhunter {
    public class Address{
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

    public class Area{
        public String id;
        public String name;
        public String url;
    }

    public class Department{
        public String id;
        public String name;
    }

    public class Employer{
        public String id;
        public String name;
        public String url;
        public String alternate_url;
        public LogoUrls logo_urls;
        public String vacancies_url;
        public boolean accredited_it_employer;
        public boolean trusted;
    }

    public class Employment{
        public String id;
        public String name;
    }

    public class Experience{
        public String id;
        public String name;
    }

    public class Item{
        public String id;
        public boolean premium;
        public String name;
        public Department department;
        public boolean has_test;
        public boolean response_letter_required;
        public Area area;
        public Object salary;
        public Type type;
        public Address address;
        public Object response_url;
        public Object sort_point_distance;
        public Date published_at;
        public Date created_at;
        public boolean archived;
        public String apply_alternate_url;
        public Object insider_interview;
        public String url;
        public Object adv_response_url;
        public String alternate_url;
        public ArrayList<Object> relations;
        public Employer employer;
        public Snippet snippet;
        public Object contacts;
        public Object schedule;
        public ArrayList<Object> working_days;
        public ArrayList<WorkingTimeInterval> working_time_intervals;
        public ArrayList<Object> working_time_modes;
        public boolean accept_temporary;
        public ArrayList<ProfessionalRole> professional_roles;
        public boolean accept_incomplete_resumes;
        public Experience experience;
        public Employment employment;
    }

    public class LogoUrls{
        @JsonProperty("240")
        public String _240;
        @JsonProperty("90")
        public String _90;
        public String original;
    }

    public class Metro{
        public String station_name;
        public String line_name;
        public String station_id;
        public String line_id;
        public double lat;
        public double lng;
    }

    public class MetroStation{
        public String station_name;
        public String line_name;
        public String station_id;
        public String line_id;
        public double lat;
        public double lng;
    }

    public class ProfessionalRole{
        public String id;
        public String name;
    }

    public class Root{
        public ArrayList<Item> items;
        public int found;
        public int pages;
        public int per_page;
        public int page;
        public Object clusters;
        public Object arguments;
        public String alternate_url;
    }

    public class Snippet{
        public String requirement;
        public String responsibility;
    }

    public class Type{
        public String id;
        public String name;
    }

    public class WorkingTimeInterval{
        public String id;
        public String name;
    }

}

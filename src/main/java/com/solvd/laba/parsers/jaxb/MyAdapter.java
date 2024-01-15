package com.solvd.laba.parsers.jaxb;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.LocalDate;

public class MyAdapter extends XmlAdapter<String, LocalDate> {
    @Override
    public LocalDate unmarshal(String s) throws Exception {
        if (s == null || s.isEmpty()) {
            return null;
        }
        return LocalDate.parse(s);  // YYYY-MM-DD format
    }

    @Override
    public String marshal(LocalDate date) throws Exception {
        if (date == null) {
            return null;
        }
        return date.toString();  // date as string in YYYY-MM-DD format
    }
}


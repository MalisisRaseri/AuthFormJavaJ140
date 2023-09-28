package com.example.DBInfro;

import java.time.LocalDateTime;

public class Domain {
    public Integer id;
    public String webName;
    public String domainName;
    public String ip;
    public LocalDateTime dateReg;
    public String countryReg;
    public Person person;

    public Domain(Integer id, String webName, String domainName, String ip, LocalDateTime dateReg, String countryReg, Person person) {
        this.id = id;
        this.webName = webName;
        this.domainName = domainName;
        this.ip = ip;
        this.dateReg = dateReg;
        this.countryReg = countryReg;
        this.person = person;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWebName() {
        return webName;
    }

    public void setWebName(String webName) {
        this.webName = webName;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public LocalDateTime getDateReg() {
        return dateReg;
    }

    public void setDateReg(LocalDateTime dateReg) {
        this.dateReg = dateReg;
    }

    public String getCountryReg() {
        return countryReg;
    }

    public void setCountryReg(String countryReg) {
        this.countryReg = countryReg;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


    @Override
    public String toString() {
        return "Domain{" +
                "id=" + id +
                ", webName='" + webName + '\'' +
                ", domainName='" + domainName + '\'' +
                ", ip='" + ip + '\'' +
                ", dateReg=" + dateReg +
                ", countryReg='" + countryReg + '\'' +
                ", person=" + person +
                '}';
    }
}
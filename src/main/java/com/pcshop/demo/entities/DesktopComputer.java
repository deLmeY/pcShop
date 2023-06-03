package com.pcshop.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "desktop_computer")
@NoArgsConstructor
@Getter
@Setter
public class DesktopComputer extends DefaultEntity{
    @Column(name = "form")
    private String form;
}

package com.pcshop.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "laptop")
@NoArgsConstructor
@Data
public class Laptop extends DefaultEntity{
    @Column(name = "size")
    private Double size;
}

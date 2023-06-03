package com.pcshop.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "hdd")
@NoArgsConstructor
@Data
public class Hdd extends DefaultEntity{
    @Column(name = "volume")
    private Integer volume;
}

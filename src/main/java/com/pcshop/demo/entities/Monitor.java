package com.pcshop.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "monitor")
@NoArgsConstructor
@Data
public class Monitor extends DefaultEntity {
    @Column(name = "diagonal")
    private Double diagonal;
}

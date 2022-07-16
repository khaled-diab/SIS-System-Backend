/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "academic_term")
public class AcademicTerm extends BaseEntity {

    private static final long serialVersionUID = 1L;
    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date endDate;

    @JoinColumn(name = "academic_year", referencedColumnName = "id")
    @ManyToOne
    private AcademicYear academicYear;

    @OneToMany(mappedBy = "academicTermId")
    private List<Lecture> lectures;

    @Column(name="status")
    private boolean status ;


}

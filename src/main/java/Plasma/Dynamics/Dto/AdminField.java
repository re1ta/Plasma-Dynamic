package Plasma.Dynamics.Dto;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class AdminField {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int one;

    private int two;
}

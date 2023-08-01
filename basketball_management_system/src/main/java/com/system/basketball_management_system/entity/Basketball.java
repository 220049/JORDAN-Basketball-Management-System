package com.system.basketball_management_system.entity;



import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Basketball")

public class Basketball {
    @Id
    @SequenceGenerator(name = "shb_product_seq_gen", sequenceName = "shb_product_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "shb_product_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer basket_ballId;

    private String basketballname;

    private String basketballprice;

    private String basketballcontact;

    private String basketballlocation;

    private String basketballimage;
    private String basketballimage1;
    private String basketballimage2;
@Column(length=1000)
    private String Description;

    @Transient
    private String imageBase64;

    @Transient
    private String image1Base64;


    @Transient
    private String image2Base64;

}

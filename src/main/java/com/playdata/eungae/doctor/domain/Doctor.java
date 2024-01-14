
package com.playdata.eungae.doctor.domain;

import com.playdata.eungae.base.BaseEntity;
import com.playdata.eungae.hospital.domain.Hospital;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
@Table(name = "doctor")
@Entity
public class Doctor extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long doctorSeq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_seq")
    private Hospital hospital;

    @Column(nullable = false)
    private String name;

    @ColumnDefault("'1'")
    private String status;

    @Column(nullable = false)
    private int treatmentPossible;

    private String doctorProfileImage;

    @ColumnDefault("'N'")
    private char deleteYN;

    public Doctor(String name) {
        this.name = name;
    }

    //연관관계 편의 메소드
    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
        hospital.addDoctor(this);
    }

    public void deleteDoctor() {
        this.deleteYN = 'Y';
    }
}

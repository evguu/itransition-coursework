package org.litnine.coursework.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "collection")
@Data
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Collection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String description;
    private String imageURL;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    @NotNull
    @CreatedDate
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    @LastModifiedDate
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    User user;

    private Boolean int1_visible;
    private Boolean int2_visible;
    private Boolean int3_visible;
    private Boolean text1_visible;
    private Boolean text2_visible;
    private Boolean text3_visible;
    private Boolean md1_visible;
    private Boolean md2_visible;
    private Boolean md3_visible;
    private Boolean date1_visible;
    private Boolean date2_visible;
    private Boolean date3_visible;
    private Boolean bool1_visible;
    private Boolean bool2_visible;
    private Boolean bool3_visible;

    private String int1_title;
    private String int2_title;
    private String int3_title;
    private String text1_title;
    private String text2_title;
    private String text3_title;
    private String md1_title;
    private String md2_title;
    private String md3_title;
    private String date1_title;
    private String date2_title;
    private String date3_title;
    private String bool1_title;
    private String bool2_title;
    private String bool3_title;
}

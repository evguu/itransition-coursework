package org.litnine.coursework.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "collection")
@Data
@NoArgsConstructor
public class Collection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String description;
    private String imageURL;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    User user;

    private Boolean int1_visible = false;
    private Boolean int2_visible = false;
    private Boolean int3_visible = false;
    private Boolean text1_visible = false;
    private Boolean text2_visible = false;
    private Boolean text3_visible = false;
    private Boolean md1_visible = false;
    private Boolean md2_visible = false;
    private Boolean md3_visible = false;
    private Boolean date1_visible = false;
    private Boolean date2_visible = false;
    private Boolean date3_visible = false;
    private Boolean bool1_visible = false;
    private Boolean bool2_visible = false;
    private Boolean bool3_visible = false;

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

package org.litnine.coursework.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "item")
@Data
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    Collection collection;

    private String int1_content;
    private String int2_content;
    private String int3_content;
    private String text1_content;
    private String text2_content;
    private String text3_content;
    private String md1_content;
    private String md2_content;
    private String md3_content;
    private String date1_content;
    private String date2_content;
    private String date3_content;
    private String bool1_content;
    private String bool2_content;
    private String bool3_content;

}

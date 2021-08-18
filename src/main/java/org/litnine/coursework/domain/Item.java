package org.litnine.coursework.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

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

    private Integer int1_content;
    private Integer int2_content;
    private Integer int3_content;
    private String text1_content;
    private String text2_content;
    private String text3_content;
    private String md1_content;
    private String md2_content;
    private String md3_content;
    private Date date1_content;
    private Date date2_content;
    private Date date3_content;
    private Boolean bool1_content;
    private Boolean bool2_content;
    private Boolean bool3_content;

}

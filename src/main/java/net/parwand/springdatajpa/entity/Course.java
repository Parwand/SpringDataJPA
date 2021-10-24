package net.parwand.springdatajpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {
    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long courseId;
    private String title;
    private String credit;
    @OneToOne(
            mappedBy = "course"
    )
    private CourseMaterial courseMaterial;
    @ManyToMany(
            cascade = CascadeType.ALL
    )
   @JoinTable(
           name = "student_course_map",
           joinColumns = @JoinColumn(
                   name = "course_id",
                   referencedColumnName = "courseId"
           ),
           inverseJoinColumns = @JoinColumn(
                   name = "student_id",
                   referencedColumnName = "studentId"
           )
   )
    private List<Student> students;
}

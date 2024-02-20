package com.devhamzat.student_management_system.dto.coursedto;

import com.devhamzat.student_management_system.entity.Course;

public class CourseDto {
    private String courseName;
    private String courseCode;
    private Integer courseUnit;

    public void setCourseName(Course courseName) {
        this.courseName = courseName.getCourseName();
    }

    public void setCourseCode(Course courseCode) {
        this.courseCode = courseCode.getCourseCode();
    }


    public void setCourseUnit(Course courseUnit) {
        this.courseUnit = courseUnit.getCourseUnit();
    }

    @Override
    public String toString() {
        return "CourseDto{" +
                "courseName='" + courseName + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", courseUnit=" + courseUnit +
                '}';
    }

}

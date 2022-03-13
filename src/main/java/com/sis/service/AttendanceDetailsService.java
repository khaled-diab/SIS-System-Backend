package com.sis.service;

import com.sis.dao.AttendanceDetailsRepository;
import com.sis.dto.attendanceDetails.AttendanceDetailsDTO;
import com.sis.entities.AttendanceDetails;
import com.sis.entities.Lecture;
import com.sis.entities.mapper.AttendanceDetailsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class AttendanceDetailsService extends BaseServiceImp<AttendanceDetails>{


    @Autowired
    private AttendanceDetailsRepository attendanceDetailsRepository;

    @Autowired
    private AttendanceDetailsMapper attendanceDetailsMapper;


    @Override
    public JpaRepository<AttendanceDetails, Long> Repository() {
        return this.attendanceDetailsRepository;
    }

    public ArrayList<AttendanceDetailsDTO> findStudentAttendances(long studentId, long courseId){
        ArrayList<AttendanceDetails> attendanceDetails= this.attendanceDetailsRepository.findStudentAttendances(studentId, courseId);
        if(attendanceDetails!=null){
            return this.attendanceDetailsMapper.toDTOs(attendanceDetails);
        }
        return null;
    }

    public ArrayList<AttendanceDetailsDTO> getAttendanceDetailsByLecture(Lecture lecture){
        ArrayList<AttendanceDetails> attendanceDetails = this.attendanceDetailsRepository.getAttendanceDetailsByLecture(lecture.getId());
        ArrayList<AttendanceDetailsDTO> attendanceDetailsDTOs = new ArrayList<>();
        if(attendanceDetails!= null){
            attendanceDetailsDTOs=  this.attendanceDetailsMapper.toDTOs(attendanceDetails);
        }

        return  attendanceDetailsDTOs;

    }


}

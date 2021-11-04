package com.sis.entities.mapper;

import com.sis.dto.AcademicYearDTO;
import com.sis.entities.AcademicYear;
import com.sis.util.PageResult;

import java.util.ArrayList;
import java.util.Collection;

import static java.util.stream.Collectors.toCollection;

public class AcademicYearMapper implements Mapper<AcademicYear, AcademicYearDTO> {


    @Override
    public AcademicYearDTO toDTO(AcademicYear entity) {
        AcademicYearDTO academicYearDTO = new AcademicYearDTO(entity.getCode(),
                entity.getName(), entity.getStartDate(), entity.getEndDate());
        academicYearDTO.setId(academicYearDTO.getId());
        return academicYearDTO;
    }

    @Override
    public AcademicYear toEntity(AcademicYearDTO dto) {
        AcademicYear academicYear = new AcademicYear();
        academicYear.setId(dto.getId());
        academicYear.setCode(dto.getName());
        academicYear.setEndDate(dto.getEnd_date());
        academicYear.setStartDate(dto.getStart_date());
        academicYear.setName(dto.getName());
        return academicYear;
    }

    @Override
    public ArrayList<AcademicYearDTO> toDTOs(Collection<AcademicYear> academicYears) {
        return academicYears.stream().map(entity -> toDTO(entity)).collect(toCollection(ArrayList<AcademicYearDTO>::new));
    }

    @Override
    public ArrayList<AcademicYear> toEntities(Collection<AcademicYearDTO> academicYearDTOS) {
        return academicYearDTOS.stream().map(dto -> toEntity(dto)).collect(toCollection(ArrayList<AcademicYear>::new));
    }

    @Override
    public PageResult<AcademicYearDTO> toDataPage(PageResult<AcademicYear> entities) {
        return new PageResult<>(entities.getData().stream().map(entity ->
                toDTO(entity)).collect(toCollection(ArrayList<AcademicYearDTO>::new))
                , entities.getTotalCount(), entities.getPageSize(), entities.getCurrPage());
    }
}

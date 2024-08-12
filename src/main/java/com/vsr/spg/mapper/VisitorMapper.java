package com.vsr.spg.mapper;

import com.vsr.spg.dto.VisitorDTO;
import com.vsr.spg.entity.Visitor;
import org.springframework.stereotype.Service;

@Service
public class VisitorMapper extends AbstractMapper<Visitor, VisitorDTO>{
    @Override
    public Class<VisitorDTO> getDtoClass() {
        return VisitorDTO.class;
    }
}

package com.ansim.mapper;

import com.ansim.dto.CctvDTO;
import com.ansim.dto.DeliboxDTO;
import com.ansim.dto.EmergbellDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MarkerMapper {

    //cctv 좌표
    public List<CctvDTO> cctv()throws Exception;

    //emergbell 좌표
    public List<EmergbellDTO> emergbell()throws Exception;

    //delibox 좌표
    public List<DeliboxDTO> delibox()throws Exception;
}

package org.scoula.icecream.service;

import org.scoula.icecream.domain.IcecreamVO;
import org.scoula.icecream.dto.IcecreamDTO;

import java.util.List;

public interface IcecreamService {
    void create(IcecreamDTO icecream);
    List<IcecreamDTO> findAll();
}

package org.scoula.icecream.mapper;

import org.scoula.icecream.domain.IcecreamVO;

import java.util.List;

public interface IcecreamMapper {
    void create(IcecreamVO icecreamVO);
    List<IcecreamVO> findAll();
}

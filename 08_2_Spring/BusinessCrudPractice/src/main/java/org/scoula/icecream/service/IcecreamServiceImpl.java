package org.scoula.icecream.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.icecream.domain.IcecreamVO;
import org.scoula.icecream.dto.IcecreamDTO;
import org.scoula.icecream.mapper.IcecreamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class IcecreamServiceImpl implements IcecreamService {

    @Autowired
    private IcecreamMapper mapper;

    @Override
    public void create(IcecreamDTO icecream) {
        log.info("create------------" + icecream);
        IcecreamVO vo = icecream.toVo();
        mapper.create(vo);
        icecream.setNo(vo.getNo());
    }

    @Override
    public List<IcecreamDTO> findAll() {
        log.info("findAll........................");
        return mapper.findAll().stream()
                .map(IcecreamDTO::of)
                .toList();
    }
}

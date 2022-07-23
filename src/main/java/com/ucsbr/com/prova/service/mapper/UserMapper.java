package com.ucsbr.com.prova.service.mapper;

import com.ucsbr.com.prova.entity.User;
import com.ucsbr.com.prova.service.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface UserMapper extends EntityMapper<UserDTO, User>{
}

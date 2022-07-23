package com.ucsbr.com.prova.webrest;

import javax.validation.Valid;

import com.ucsbr.com.prova.service.UserService;
import com.ucsbr.com.prova.service.dto.UserDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@ApiOperation("Usuários")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @ApiOperation(value = "Cria um novo usuário")
  @ApiResponses(value = {
      @ApiResponse(code = 201, message = "Usuário Criado"),
      @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
      @ApiResponse(code = 500, message = "Foi gerada uma exceção")
  })
  @PostMapping
  public ResponseEntity<UserDTO> create(@Valid @RequestBody UserDTO userDto) {
    UserDTO user = userService.save(userDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(user);
  }
}

package com.doctor.rest.Controller;

import com.doctor.rest.Dto.DtoForResponse.PacienteComConsulta;
import com.doctor.rest.Dto.PacienteRequest;
import com.doctor.rest.Dto.PacienteResponse;
import com.doctor.rest.Dto.DtoForRequests.PacienteDTO;
import com.doctor.rest.Models.Consulta;
import com.doctor.rest.Models.Paciente;
import com.doctor.rest.Models.ProcedimentosRealizados;
import com.doctor.rest.Repo.PacienteRepository;
import com.doctor.rest.Services.eServices;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200")
//@EnableSwagger2
@RequestMapping("/api/consulta/")
public class ConsultaController {
   @Autowired
    private PacienteRepository pacienteRepository;
   @Autowired
   private eServices services;
   @Autowired
   private ModelMapper modelMapper;

   
   @PostMapping("addPaciente")
   
    public Paciente addPaciente(@RequestBody PacienteDTO request){
      Paciente paciente = modelMapper.map(request, Paciente.class);
      return pacienteRepository.save(paciente);

   }
   
   @GetMapping("getAllPacientes")
    public List<Paciente> getAllPacientes(){
       return pacienteRepository.findAll();
   }
   
   @GetMapping("getPacienteByRG")
   
    public ResponseEntity<Optional<Paciente>> getPacienteByRG(@RequestParam  String rg){
       return new ResponseEntity<Optional<Paciente>>(services.findByRg(rg), HttpStatus.OK);
   }
   
   @PutMapping("addConsulta")
   
   public List<Consulta> addConsulta(String rg, Consulta consulta){
        return services.addConsulta(rg, consulta);
    }
   
    @PutMapping("/updateConsulta")
    
    public List<Consulta> changeConsulta(String rg, int consulPos, @RequestBody Consulta consulta){
       return services.changeConsulta(rg, consulPos, consulta);
    }
   
   @DeleteMapping("deleteAll")
   
    public String deleteAll(){
       services.deleteAll();
       return "Successfully deleted";
   }
   
   @PutMapping("updatePaciente")
   
    public String updatePaciente(@RequestBody Paciente paciente){
        services.updatePaciente(paciente);
        return "Paciente atualizado!";
   }
   
   @PostMapping("addHorarios")
   
    public String addHorario(@RequestParam LocalTime horario){
       services.addHorarios(horario);
       return "Horario adicionado";
   }
   
   @GetMapping("getHorarios")
   
    public List<String> getHorarios(){
       return services.getHorarios();
    }
    
    @GetMapping("testandoInfo")
    
    public List<PacienteResponse> getInformation(){
       return services.getInfo();
    }
    
    @GetMapping("getConsultasPaciente")
    
    public List<PacienteResponse> getConsultasPaciente(){ return services.getConsultasPaciente();}
    
    @GetMapping("/getConsultasPacienteByQuery")
    
    public PacienteComConsulta getConsultasPacienteByQuery(String rg){ return services.getConsultaQuery(rg);}
    
    @PostMapping
    
    public List<ProcedimentosRealizados> addProcedimentos(String rg, ProcedimentosRealizados procedimentos)
    { return services.addProcedimento(rg, procedimentos);}


}

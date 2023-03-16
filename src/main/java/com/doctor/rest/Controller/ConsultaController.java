package com.doctor.rest.Controller;

import com.doctor.rest.Dto.PacienteRequest;
import com.doctor.rest.Dto.PacienteResponse;
import com.doctor.rest.Models.Consulta;
import com.doctor.rest.Models.Paciente;
import com.doctor.rest.Models.ProcedimentosRealizados;
import com.doctor.rest.Repo.ConsultaRepository;
import com.doctor.rest.Repo.PacienteRepository;
import com.doctor.rest.Services.eServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController
@EnableSwagger2
@RequestMapping("/api/consulta/")
public class ConsultaController {
   @Autowired
    private PacienteRepository pacienteRepository;
   @Autowired
    private ConsultaRepository consultaRepository;

   @Autowired
   private eServices services;


   @PostMapping("addPaciente")
    public Paciente addPaciente(@RequestBody PacienteRequest request){

       return pacienteRepository.save(request.getPaciente());

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
    @PutMapping
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
    @PostMapping
    public List<ProcedimentosRealizados> addProcedimentos(String rg, ProcedimentosRealizados procedimentos)
    { return services.addProcedimento(rg, procedimentos);}


}

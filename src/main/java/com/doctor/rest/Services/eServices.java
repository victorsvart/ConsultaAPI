package com.doctor.rest.Services;

import com.doctor.rest.Dto.DtoForRequests.ConsultaDTO;
import com.doctor.rest.Dto.DtoForRequests.ConsultaPacienteDTO;
import com.doctor.rest.Dto.DtoForResponse.PacienteComConsulta;
import com.doctor.rest.Dto.PacienteResponse;
import com.doctor.rest.Models.Consulta;
import com.doctor.rest.Models.Paciente;
import com.doctor.rest.Models.ProcedimentosRealizados;
import com.doctor.rest.Repo.ConsultaRepository;
import com.doctor.rest.Repo.PacienteRepository;
import com.doctor.rest.Repo.ProcedimentosRealizadosRepository;
import com.doctor.rest.Repo.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Service
public class eServices {
    private final PacienteRepository pacienteRepository;
    private final ConsultaRepository consultaRepository;
    private final ProcedimentosRealizadosRepository procedimentosRealizadosRepository;
    private final UserRepository userRepository;
    private final List<String> horarios;

    public eServices(PacienteRepository pacienteRepository, ConsultaRepository consultaRepository
            , ProcedimentosRealizadosRepository
                             procedimentosRealizadosRepository, UserRepository userRepository) {
        this.pacienteRepository = pacienteRepository;
        this.consultaRepository = consultaRepository;
        this.procedimentosRealizadosRepository = procedimentosRealizadosRepository;
        this.userRepository = userRepository;
        horarios = new ArrayList<String>();
    }


    public Paciente addPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Optional<Paciente> findById(int ID) {
        return pacienteRepository.findByID(ID);
    }

    public Optional<Paciente> findByRg(String rg) {
        return pacienteRepository.findByRG(rg);
    }

    public void deleteAll() {
        pacienteRepository.deleteAll();
    }

    public void updatePaciente(Paciente paciente) {
        Paciente pacienteUpdate = paciente;
        pacienteUpdate.setFirstName(paciente.getFirstName());
        pacienteUpdate.setLastName(paciente.getLastName());
        pacienteUpdate.setEndereco(paciente.getEndereco());
        pacienteUpdate.setConsul(paciente.getConsul());
        pacienteUpdate.setAge(paciente.getAge());
        pacienteUpdate.setLaudo(paciente.getLaudo());
        pacienteUpdate.setNascimento(paciente.getNascimento());
        pacienteUpdate.setProfissao(paciente.getProfissao());
        pacienteUpdate.setTelefone(paciente.getTelefone());
        pacienteUpdate.setRG(paciente.getRG());
        pacienteUpdate.setProcedimentosRealizados(paciente.getProcedimentosRealizados());
        pacienteRepository.save(pacienteUpdate);
    }

    public List<String> addHorarios(LocalTime horario) {
        int hora = horario.getHour();
        int minuto = horario.getMinute();
        horarios.add(String.valueOf(hora + minuto));
        return horarios;
    }

    public List<String> getHorarios() {
        return horarios;
    }

    public List<PacienteResponse> getInfo() {
        return pacienteRepository.getJoinInformation();
    }

    public List<PacienteResponse> getConsultasPaciente() {
        return pacienteRepository.getConsultasPaciente();
    }
    public PacienteComConsulta getConsultaQuery(String rg){
        List<ConsultaPacienteDTO> pacienteRequested =  pacienteRepository.findByKeyword(rg);
        PacienteComConsulta paciente = new PacienteComConsulta();
        ArrayList<Consulta> gettedConsulta = new ArrayList<>();
        for (ConsultaPacienteDTO item: pacienteRequested)
        {
            paciente.setFirstName(item.getFirstName());
            paciente.setLastName(item.getLastName());
            paciente.setRG(item.getRG());
        }
        List<ConsultaDTO> consultaRequested = consultaRepository.findByKeyword(rg);
        for (ConsultaDTO item : consultaRequested)
        {
            String DataConsulta = item.getDataConsulta();
            String HorarioConsulta = item.getHorarioConsulta();
            Consulta consulta = new Consulta();
            consulta.setDataConsulta(LocalDate.parse(DataConsulta));
            consulta.setHorarioConsulta(HorarioConsulta);
            gettedConsulta.add(consulta);
        }
        paciente.setConsul(gettedConsulta);
        return paciente;

    }


    public List<Consulta> addConsulta(String rg, Consulta consulta) {
        Paciente paciente = pacienteRepository.findByRG(rg).get();
        List<Consulta> consultas = paciente.getConsul();
        consultas.add(consulta);
        return consultaRepository.saveAll(consultas);

    }
    

    public List<Consulta> changeConsulta(String rg, int consulPos, Consulta consulta) {
        Paciente paciente = pacienteRepository.findByRG(rg).get();
        List<Consulta> consultas = paciente.getConsul();
        Consulta consultaInPos = null;
        for (int i = 0; i <= consulPos; i++) {
            consultaInPos = consultas.get(i);
        }
        consultaInPos.setDataConsulta(consulta.getDataConsulta());
        consultaInPos.setHorarioConsulta(consulta.getHorarioConsulta());
        consultaInPos.setIsDeleted(consulta.getIsDeleted());
        return Collections.singletonList(consultaRepository.save(consultaInPos));

    }

    public List<ProcedimentosRealizados> addProcedimento(String rg, ProcedimentosRealizados procedimentosRealizados) {
        Paciente paciente = pacienteRepository.findByRG(rg).get();
        List<ProcedimentosRealizados> procedimentos = paciente.getProcedimentosRealizados();
        procedimentos.add(procedimentosRealizados);
        return procedimentosRealizadosRepository.saveAll(procedimentos);
    }
    // public Consulta getConsultaByRG(String rg){
    //     return consultaRepository.getConsultaByRG(rg);
    // }

}
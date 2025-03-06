package com.example.agendamento_notificacao_api.infrastructure.entities;




import com.example.agendamento_notificacao_api.infrastructure.enums.StatusNotificacaoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "agendamento")
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long Id;
    private String emailDestinatario;
    private String telefoneDestinatario;
    private LocalDateTime dataHoraEnvio;
    private LocalDateTime dataHoraAgendamento;
    private LocalDateTime dataHoraModificacao;
    private String mensagem;

    private StatusNotificacaoEnum statusNotificacao;


    @PrePersist

    private void prePresist(){
        dataHoraAgendamento = LocalDateTime.now();
        statusNotificacao = StatusNotificacaoEnum.AGENDADO;
    }








}

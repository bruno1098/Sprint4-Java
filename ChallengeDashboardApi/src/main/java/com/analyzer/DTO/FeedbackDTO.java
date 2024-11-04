package com.analyzer.DTO;

import java.time.LocalDateTime;

public class FeedbackDTO {
    private Long id;
    private String descricao;
    private int nota;
    private Long usuarioId;
    private LocalDateTime data;

    public FeedbackDTO(Long id, String descricao, int nota, Long usuarioId, LocalDateTime data) {
        this.id = id;
        this.descricao = descricao;
        this.nota = nota;
        this.usuarioId = usuarioId;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}


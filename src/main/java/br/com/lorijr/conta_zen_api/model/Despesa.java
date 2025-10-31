package br.com.lorijr.conta_zen_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "despesas")
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;
    private BigDecimal valor;

    @Column(nullable = false)
    private LocalDate dataVencimento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    Despesa parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Despesa> itens = new ArrayList<>();

    @Formula("(SELECT SUM(d.valor) FROM Despesa d WHERE d.parent_id = id)")
    private BigDecimal totalItens;

    public Despesa(String nome, BigDecimal valor, LocalDate dataVencimento){
        this.nome = nome;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
    }

    public Despesa(String nome, LocalDate dataVencimento){
        this.nome = nome;
        this.dataVencimento = dataVencimento;
        this.valor = null;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public void setParent(Despesa parent) {
        this.parent = parent;
    }

    public void adicionarItem(Despesa item){
        this.itens.add(item);
        item.setParent(this);
    }

    @Transient
    public BigDecimal getValorCalculado(){
        if(this.valor != null){
            return this.valor;
        }
        return this.totalItens != null ? this.totalItens : BigDecimal.ZERO;
    }


}

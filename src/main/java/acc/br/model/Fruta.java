package acc.br.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@SequenceGenerator(
        name = "fruta_seq",
        sequenceName = "fruta_sequence",
        allocationSize = 1,
        initialValue = 1
)
public class Fruta extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fruta_seq")
    public Long id;

    public String nome;
    public int qtd;
}

package testeController;

import controller.PessoaController;
import model.Pessoa;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class TestePessoaTest {
    private PessoaController verificaLista;

    @BeforeEach
    public void setUp() {
        verificaLista = new PessoaController();
    }

    @Test
    public void verificaListaFeminina(){
        List<Pessoa> listaPessoa = Arrays.asList(
                new Pessoa("Geovanna", 20, "F"),
                new Pessoa("Flavia", 48, "F"),
                new Pessoa("Junior", 24, "M")
        );

        verificaLista.setListaDePessoas(listaPessoa);

        List<Pessoa> listaFeminina = verificaLista.verificaListaFeminina();

        assertTrue("A lista contém pessoas que não são do gênero 'F'.",
                listaFeminina.stream().allMatch(p -> p.getSexo().equalsIgnoreCase("F")));

    }
}
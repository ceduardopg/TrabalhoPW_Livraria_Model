package br.edu.ifsul.utilrelatorios;

import br.edu.ifsul.modelo.Catalogo;
import br.edu.ifsul.modelo.Livraria;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class FabricaObjetos {
    public static List<Livraria> carregaLivraria(){
        List<Livraria> lista = new ArrayList<>();
        Livraria l = new Livraria();
        l.setId(1);
        l.setNome("Books");
        l.setSite("www.books.com");
        lista.add(l);
        Catalogo c = new Catalogo();
        c.setNome("Teste");
        c.setDescricao("Um catalogo");
        l.getCatalogos().add(c);
        return lista;
    }
}

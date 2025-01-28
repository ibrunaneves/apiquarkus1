package acc.br;

import java.util.List;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import acc.br.model.Fruta;

@Path("/frutas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FrutaResource {

    @GET
    public List<Fruta> list() {
        return Fruta.listAll(); // Retorna todas as frutas salvas no banco
    }

    @POST
    @Transactional
    public Response novaFruta(Fruta fruta) {
        fruta.persist(); // Salva no banco
        return Response.status(Response.Status.CREATED).entity(fruta).build(); // Retorna a fruta com o ID gerado
    }
}

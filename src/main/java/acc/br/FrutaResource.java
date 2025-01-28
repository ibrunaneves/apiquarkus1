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
        return Fruta.listAll();
    }

    @POST
    @Transactional
    public Response novaFruta(Fruta fruta) {
        if (fruta.id != null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("ID não deve ser enviado no corpo da requisição")
                    .build();
        }

        fruta.persist(); // Hibernate gera o ID automaticamente
        return Response.status(Response.Status.CREATED).entity(fruta).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deletarFruta(@PathParam("id") Long id) {
        boolean deleted = Fruta.deleteById(id);
        return deleted ? Response.noContent().build() : Response.status(Response.Status.NOT_FOUND).build();
    }
}

package dk.topdanmark.area.boundary;

import dk.topdanmark.area.controller.CircleCalculator;
import dk.topdanmark.area.controller.SquareCalculator;
import dk.topdanmark.area.entity.Area;
import dk.topdanmark.area.entity.Circle;
import dk.topdanmark.area.entity.Square;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/area")
@Stateless
public class AreaResource {
    
    @Inject
    CircleCalculator circleCalculator;
    
    @Inject
    SquareCalculator squareCalculator;
    
    @PersistenceContext()
    EntityManager em;
    
    @GET
    @Path("circle/calculate/{radius}/")
    @Produces({MediaType.APPLICATION_JSON})
    public Circle calculateCircleArea(@NotNull @PathParam("radius") double radius){
        final Circle circle = circleCalculator.calculateArea(radius);
        circleCalculator.saveCircle(circle);
        return circle;
    }
    
    @GET
    @Path("circle/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Circle getCircle(@NotNull @PathParam("id") Integer id){
        Circle circle = em.find(Circle.class, id);
        return circle;
    }
    
    @POST
    @Path("circle")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    public Response saveCircle(@Context HttpServletRequest request, @NotNull Circle circle){
        circleCalculator.saveCircle(circle);
        String url = request.getRequestURL().toString();
        String reqString = url + "/" + circle.id;
        return Response.status(Response.Status.OK).entity(reqString).build();
    }
    
    @GET
    @Path("circles/")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Circle> circles(){
        final List<Circle> circles = em.createNamedQuery(Circle.GET_ALL, Circle.class).getResultList();
        return circles;
    }
    

    @GET
    @Path("square/calculate/{side}/")
    @Produces({MediaType.APPLICATION_JSON})
    public Square calculateSquareArea(@NotNull @PathParam("side") double side){
        final Square square = squareCalculator.calculateArea(side);
        squareCalculator.saveSquare(square);
        return square;
    }
            
    @GET
    @Path("squares")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Square> squares(){
        final List<Square> squares = em.createNamedQuery(Square.GET_ALL, Square.class).getResultList();
        return squares;
    }        
            
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Area> areas(){
        List<Area> areas = new ArrayList<>();
        final List<Circle> circles = em.createNamedQuery(Circle.GET_ALL, Circle.class).getResultList();
        final List<Square> squares = em.createNamedQuery(Square.GET_ALL, Square.class).getResultList();
        areas.addAll(circles);
        areas.addAll(squares);
        return areas;
    }  
}

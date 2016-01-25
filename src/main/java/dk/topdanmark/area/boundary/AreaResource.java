package dk.topdanmark.area.boundary;

import dk.topdanmark.area.controller.CircleCalculator;
import dk.topdanmark.area.controller.SquareCalculator;
import dk.topdanmark.area.entity.Circle;
import dk.topdanmark.area.entity.Square;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/area")
@Stateless
@Produces("application/json")
public class AreaResource {
    
    @Inject
    CircleCalculator circleCalculator;
    
    @Inject
    SquareCalculator squareCalculator;
    
    @GET
    @Path("circle/{radius}/")
    @Produces({MediaType.APPLICATION_JSON})
    public Circle calculateCircleArea(@NotNull @PathParam("radius") double radius){
        return circleCalculator.calculateArea(radius);
    }
       
    @GET
    @Path("square/{side}/")
    @Produces({MediaType.APPLICATION_JSON})
    public Square calculateSquareArea(@NotNull @PathParam("side") double side){
        return squareCalculator.calculateArea(side);
    }
            
            
            
    
}

package dk.topdanmark.area.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQueries({
    @NamedQuery(name = Circle.GET_ALL, query="select c from Circle c")
})
@XmlRootElement
public class Circle extends Area{
    
    public static final String GET_ALL = "dk.topdanmark.area.entity.Circle";
    
 
}

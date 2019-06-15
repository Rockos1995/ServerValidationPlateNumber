/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plateNumber.ws.service;

import com.plateNumber.models.Restrictionaday;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.simple.JSONObject;

/**
 *
 * @author Oswal
 */
@Stateless
@Path("com.platenumber.models.restrictionaday")
public class RestrictionadayFacadeREST extends AbstractFacade<Restrictionaday> {

    @PersistenceContext(unitName = "com.oswaldo_plateNumberServer_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public RestrictionadayFacadeREST() {
        super(Restrictionaday.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Restrictionaday entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Restrictionaday entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Restrictionaday find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
     @GET
    @Path("validateNumberPlate/{lastPlateNumber}/{date}")
    @Produces({MediaType.TEXT_PLAIN})
    public String findByNumberPlate(
            @PathParam("lastPlateNumber") Integer lastPlateNumber,
            @PathParam("date") String date) {
        Restrictionaday res = null;
        String consulta;
        JSONObject obj=new JSONObject();    
  
        try {
            consulta = "FROM Restrictionaday r WHERE r.numberPlate = ?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, lastPlateNumber);
            res = (Restrictionaday) query.getSingleResult();
            if(res!= null){
                Integer numberDay = res.getIdDay().getIdDay();
                Integer actualDate = this.getNumberDay(date);
                if(actualDate != null){
                    obj.put("restriction",(numberDay.equals(actualDate))?'1':'0');    
                    return obj.toJSONString();
                }
            }            
        } catch (Exception e) {
            return null;
        }
        return  null;
    }
    
    private HashMap<String,Object> response (Object obj){
        HashMap hs = new HashMap<>();
        hs.put("restriction", obj);
        return hs;
    }    
    private Integer getNumberDay(String date){
        Date dateFormat = null;
         try {
            Calendar cal = Calendar.getInstance();
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat = format.parse(date);
            cal.setTime(dateFormat);
            return  cal.get(Calendar.DAY_OF_WEEK);
        } catch (ParseException e) {
            System.out.println("Error to parse string");
            return null;
        }
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Restrictionaday> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Restrictionaday> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}

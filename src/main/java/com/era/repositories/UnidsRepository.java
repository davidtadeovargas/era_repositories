package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Unid;

public class UnidsRepository extends Repository {

   public UnidsRepository() {
        super(Unid.class);
    }

   @Override
   final public List<Unid> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Unid> records = (List<Unid>) this.getAllLike(likes, search);
       
       return records;
   }

   public Unid getUnidKilo() throws Exception {
       
       final Unid Unid = (Unid)this.getByCode("KILO");
       return Unid;
   }
   
   public Unid getUnidMETROCUADRADO() throws Exception {
       
       final Unid Unid = (Unid)this.getByCode("METROCUADRADO");
       return Unid;
   }
   
   public Unid getUnidCABEZA() throws Exception {
       
       final Unid Unid = (Unid)this.getByCode("CABEZA");
       return Unid;
   }
   
   public Unid getUnidKILOWATT() throws Exception {
       
       final Unid Unid = (Unid)this.getByCode("KILOWATT");
       return Unid;
   }
   
   public Unid getUnidKILOWATTHORA() throws Exception {
       
       final Unid Unid = (Unid)this.getByCode("KILOWATT/HORA");
       return Unid;
   }
   
   public Unid getUnidGRAMONETO() throws Exception {
       
       final Unid Unid = (Unid)this.getByCode("GRAMONETO");
       return Unid;
   }
   
   public Unid getUnidDOCENAS() throws Exception {
       
       final Unid Unid = (Unid)this.getByCode("DOCENAS");
       return Unid;
   }
   
   public Unid getUnidGRAMO() throws Exception {
       
       final Unid Unid = (Unid)this.getByCode("GRAMO");
       return Unid;
   }
   
   public Unid getUnidMETROCÚBICO() throws Exception {
       
       final Unid Unid = (Unid)this.getByCode("METROCÚBICO");
       return Unid;
   }
   
   public Unid getUnidLITRO() throws Exception {
       
       final Unid Unid = (Unid)this.getByCode("LITRO");
       return Unid;
   }
   
   public Unid getUnidMILLAR() throws Exception {
       
       final Unid Unid = (Unid)this.getByCode("MILLAR");
       return Unid;
   }
   
   public Unid getUnidTONELADA() throws Exception {
       
       final Unid Unid = (Unid)this.getByCode("TONELADA");
       return Unid;
   }
   
   public Unid getUnidDECENAS() throws Exception {
       
       final Unid Unid = (Unid)this.getByCode("DECENAS");
       return Unid;
   }
   
   public Unid getUnidCAJA() throws Exception {
       
       final Unid Unid = (Unid)this.getByCode("CAJA");
       return Unid;
   }
   
   public Unid getUnidMETROLINEAL() throws Exception {
       
       final Unid Unid = (Unid)this.getByCode("METRO LINEAL");
       return Unid;
   }
   
   public Unid getUnidPIEZA() throws Exception {
       
       final Unid Unid = (Unid)this.getByCode("PIEZA");
       return Unid;
   }
   
   public Unid getUnidPAR() throws Exception {
       
       final Unid Unid = (Unid)this.getByCode("PAR");
       return Unid;
   }
   
   public Unid getUnidJUEGO() throws Exception {
       
       final Unid Unid = (Unid)this.getByCode("JUEGO");
       return Unid;
   }
   
   public Unid getUnidBARRIL() throws Exception {
       
       final Unid Unid = (Unid)this.getByCode("BARRIL");
       return Unid;
   }
   
   public Unid getUnidCIENTOS() throws Exception {
       
       final Unid Unid = (Unid)this.getByCode("CIENTOS");
       return Unid;
   }
   
   public Unid getUnidBOTELLA() throws Exception {
       
       final Unid Unid = (Unid)this.getByCode("BOTELLA");
       return Unid;
   }
}
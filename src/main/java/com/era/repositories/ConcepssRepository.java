package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Conceps;

public class ConcepssRepository extends Repository {

    public ConcepssRepository() {
        super(Conceps.class);
    }
    
    public Conceps getByType(final TYPES type) throws Exception {
        
        String code = "";
        switch(type){
            
            case AJUSTE_POR_INVENTARIO:
                code = "AIN";
                break;
                
            case MERMA:
                code = "MER";
                break;
                
            case ROBO:
                code = "ROB";
                break;
                
            case MAL_ESTADO:
                code = "MAL";
                break;
                
            case COMPRA:
                code = "COM";
                break;
                
            case CADUCO:
                code = "CAD";
                break;
                
            case ROTO:
                code = "ROT";
                break;
                
            case DEFECTUOSO:
                code = "DEF";
                break;
                
            case MOJADO:
                code = "MOJ";
                break;
                
            case SIN_CAJA:
                code = "SINC";
                break;
                
            case PROMOCION:
                code = "PROMO";
                break;
                
            case CORTESIA:
                code = "CORTE";
                break;
                
            case OFERTA:
                code = "OFER";
                break;
                
            case NO_FUNCIONA:
                code = "NOFUN";
                break;
                
            case SALIDA_GENERICA:
                code = "SALG";
                break;
                
            case ENTRADA_GENERICA:
                code = "ENTG";
                break;
                
            case MERMA_AGRANEL:
                code = "MERMA";
                break;
                
            case PRORTEO:
                code = "PROR";
                break;
                
            case DONACIONES:
                code = "DONA";
                break;
            
            case TRASPASO:
                code = "TRAS";
                break;
                
            case VENTA:
                code = "VENTA";
                break;
                
            case CANVENTA:
                code = "CANVENTA";
                break;
        }
        
        //Get the record
        final Conceps Concep = (Conceps)this.getByCode(code);
        
        return Concep;
    }
    
    @Override
    final public List<Conceps> getByLikeEncabezados(final String search) throws Exception{

        final List<String> likes = new ArrayList<>();
        likes.add("falt");
        likes.add("fmod");

        final List<Conceps> records = (List<Conceps>) this.getAllLike(likes, search);

        return records;
    }
    
    
    public enum TYPES {        
        AJUSTE_POR_INVENTARIO,
        MERMA,
        ROBO,
        MAL_ESTADO,
        COMPRA,
        CADUCO,
        ROTO,
        DEFECTUOSO,
        MOJADO,
        SIN_CAJA,
        PROMOCION,
        CORTESIA,
        OFERTA,
        NO_FUNCIONA,
        SALIDA_GENERICA,
        ENTRADA_GENERICA,
        MERMA_AGRANEL,
        PRORTEO,
        DONACIONES,
        TRASPASO,
        VENTA,
        CANVENTA
    }
}
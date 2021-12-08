//package edu.uph.ii.springbootprj.filters;
//
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.format.annotation.NumberFormat;
//import org.thymeleaf.util.StringUtils;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//
//@Getter @Setter
//public class VehicleFilter {
//    private String phrase;
//
//
//    private QUERY_MODE queryMode;
//
//    public String getPhraseLIKE(){return phrase.isEmpty()?"":"%"+phrase+"%";}
//
//    public boolean isEmpty(){
//        return StringUtils.isEmptyOrWhitespace(phrase);
//    }
//
//    public void clear(){
//        phrase="";
//    }
//
//    public enum QUERY_MODE{
//        NAMED_METHOD,
//        NAMED_QUERY,
//        QUERY,
//        SpEL_AND_ENTITY_GRAPH,
//        CRITERIA,
//    }
//}

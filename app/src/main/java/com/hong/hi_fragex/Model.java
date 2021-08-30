package com.hong.hi_fragex;

public class Model {

/*    private String labelNo[];
    private String materialNm[];
    private String materialCd[];
    private String materialWh[];
    private String materialEa[];*/
    private String labelNo;
    private String materialNm;
    private String materialCd;
    private String materialWh;
    private String materialEa;

/*    public Model(String labelNo[], String materialNm[], String materialCd[], String materialWh[], String materialEa[]){
        this.labelNo = labelNo;
        this.materialNm = materialNm;
        this.materialCd = materialCd;
        this.materialWh = materialWh;
        this.materialEa = materialEa;

    }*/

    public Model(String labelNo, String materialNm, String materialCd, String materialWh, String materialEa) {
        this.labelNo = labelNo;
        this.materialNm = materialNm;
        this.materialCd = materialCd;
        this.materialWh = materialWh;
        this.materialEa = materialEa;
    }
    /*public String[] getlabelNo() {
        return labelNo;
    }

    public String[] getmaterialNm() {
        return materialNm;
    }

    public String[] getmaterialCd() {
        return materialCd;
    }

    public String[] getmaterialWh() {
        return materialWh;
    }

    public String[] getMaterialEa() {
        return materialEa;
    }*/


    public String getlabelNo() {
        return labelNo;
    }

    public String getmaterialNm() {
        return materialNm;
    }

    public String getmaterialCd() {
        return materialCd;
    }

    public String getmaterialWh() {
        return materialWh;
    }

    public String getMaterialEa() {
        return materialEa;
    }
}

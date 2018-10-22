package com.tenghong.ndip.model.diet;

import java.io.Serializable;

/**
 * diet_element
 * @author 
 */
public class DietElement implements Serializable {

    private Integer elementId;

    /**
     * 1原材料 2菜 3套餐 4菜单
     */
    private Integer goalType;

    /**
     * 对应目标的id
     */
    private Integer goalId;

    private String department;

    private String energy;

    private String protein;

    private String fat;

    private String carbohydrate;

    private String df;

    private String ca;

    private String fe;

    private String zn;

    private String se;

    private String cu;

    private String mn;

    private String mg;

    private String na;

    private String k;

    private String p;

    private String vita;

    private String vite;

    private String vitb1;

    private String vitb2;

    private String vitc;

    private String vitpp;

    private String asp;

    private String water;

    private String vpp;

    private String i;

    private String purine;

    private static final long serialVersionUID = 1L;

    public Integer getElementId() {
        return elementId;
    }

    public void setElementId(Integer elementId) {
        this.elementId = elementId;
    }

    public Integer getGoalType() {
        return goalType;
    }

    public void setGoalType(Integer goalType) {
        this.goalType = goalType;
    }

    public Integer getGoalId() {
        return goalId;
    }

    public void setGoalId(Integer goalId) {
        this.goalId = goalId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEnergy() {
        return energy;
    }

    public void setEnergy(String energy) {
        this.energy = energy;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public String getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(String carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public String getDf() {
        return df;
    }

    public void setDf(String df) {
        this.df = df;
    }

    public String getCa() {
        return ca;
    }

    public void setCa(String ca) {
        this.ca = ca;
    }

    public String getFe() {
        return fe;
    }

    public void setFe(String fe) {
        this.fe = fe;
    }

    public String getZn() {
        return zn;
    }

    public void setZn(String zn) {
        this.zn = zn;
    }

    public String getSe() {
        return se;
    }

    public void setSe(String se) {
        this.se = se;
    }

    public String getCu() {
        return cu;
    }

    public void setCu(String cu) {
        this.cu = cu;
    }

    public String getMn() {
        return mn;
    }

    public void setMn(String mn) {
        this.mn = mn;
    }

    public String getMg() {
        return mg;
    }

    public void setMg(String mg) {
        this.mg = mg;
    }

    public String getNa() {
        return na;
    }

    public void setNa(String na) {
        this.na = na;
    }

    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    public String getVita() {
        return vita;
    }

    public void setVita(String vita) {
        this.vita = vita;
    }

    public String getVite() {
        return vite;
    }

    public void setVite(String vite) {
        this.vite = vite;
    }

    public String getVitb1() {
        return vitb1;
    }

    public void setVitb1(String vitb1) {
        this.vitb1 = vitb1;
    }

    public String getVitb2() {
        return vitb2;
    }

    public void setVitb2(String vitb2) {
        this.vitb2 = vitb2;
    }

    public String getVitc() {
        return vitc;
    }

    public void setVitc(String vitc) {
        this.vitc = vitc;
    }

    public String getVitpp() {
        return vitpp;
    }

    public void setVitpp(String vitpp) {
        this.vitpp = vitpp;
    }

    public String getAsp() {
        return asp;
    }

    public void setAsp(String asp) {
        this.asp = asp;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public String getVpp() {
        return vpp;
    }

    public void setVpp(String vpp) {
        this.vpp = vpp;
    }

    public String getI() {
        return i;
    }

    public void setI(String i) {
        this.i = i;
    }

    public String getPurine() {
        return purine;
    }

    public void setPurine(String purine) {
        this.purine = purine;
    }

    @Override
    public String toString() {
        return "DietElement{" +
                "elementId=" + elementId +
                ", goalType=" + goalType +
                ", goalId=" + goalId +
                ", department=" + department +
                ", energy='" + energy + '\'' +
                ", protein='" + protein + '\'' +
                ", fat='" + fat + '\'' +
                ", carbohydrate='" + carbohydrate + '\'' +
                ", df='" + df + '\'' +
                ", ca='" + ca + '\'' +
                ", fe='" + fe + '\'' +
                ", zn='" + zn + '\'' +
                ", se='" + se + '\'' +
                ", cu='" + cu + '\'' +
                ", mn='" + mn + '\'' +
                ", mg='" + mg + '\'' +
                ", na='" + na + '\'' +
                ", k='" + k + '\'' +
                ", p='" + p + '\'' +
                ", vita='" + vita + '\'' +
                ", vite='" + vite + '\'' +
                ", vitb1='" + vitb1 + '\'' +
                ", vitb2='" + vitb2 + '\'' +
                ", vitc='" + vitc + '\'' +
                ", vitpp='" + vitpp + '\'' +
                ", asp='" + asp + '\'' +
                ", water='" + water + '\'' +
                ", vpp='" + vpp + '\'' +
                ", i='" + i + '\'' +
                ", purine='" + purine + '\'' +
                '}';
    }
}
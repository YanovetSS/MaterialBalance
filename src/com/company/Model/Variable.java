package com.company.Model;

/**
 * Created by MakeMeSm1Le- on 16.02.2017.
 */
public class Variable {
    
    private String name;
    private int power;
    private Double valueParam;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Double getValueParam() {
        return valueParam;
    }
    
    public Double getValue(){
        return Math.pow(valueParam,power);
    }

    public void setValueParam(Double valueParam) {
        this.valueParam = valueParam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Variable variable = (Variable) o;

        if (name != null ? !name.equals(variable.name) : variable.name != null) return false;
        return valueParam.equals(variable.valueParam);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + power;
        result = 31 * result + valueParam.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Variable{" +
                "name='" + name + '\'' +
                ", power=" + power +
                ", valueParam=" + valueParam +
                '}';
    }
}

package com.dushan.rishitha.iotuserapplication.model;

/**
 * Created by Rishitha on 1/27/2018.
 */
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class deviceData {
    @SerializedName("components")
    private List<data> array;

    public deviceData(List<data> array) {
        this.array = array;
    }

    public List<data> getArray() {
        return array;
    }

    public void setArray(List<data> array) {
        this.array = array;
    }

    public class data{
        @SerializedName("Component_id")
        private String Id;
        @SerializedName("Name")
        private String name;
        @SerializedName("Current_value")
        private String currentValue;
        @SerializedName("Unit")
        private String unit;


        public data(String Id, String name, String currentValue, String unit){
            this.Id = Id;
            this.name = name;
            this.currentValue = currentValue;
            this.unit = unit;
        }
        public String getId() {return Id;}
        public void setId(String id) {Id = id;}

        public String getName() {return name;}
        public void setName(String name) {this.name = name;}

        public String getCurrentValue() {return currentValue;}
        public void setCrrentValue(String currentValue) {this.currentValue = currentValue;}

        public String getUnit() {return unit;}
        public void setUnit(String unit) {this.unit = unit;}
    }
}
